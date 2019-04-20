package com.mr.service.scenery;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.mr.common.enums.ENDictionaryType;
import com.mr.common.exception.BusinessException;
import com.mr.controller.scenery.param.PlanDetailPM;
import com.mr.controller.scenery.param.RecommendDetailPM;
import com.mr.controller.scenery.param.SceneryQueryPM;
import com.mr.controller.scenery.param.SceneryRoutePM;
import com.mr.controller.scenery.view.SceneryDetailVM;
import com.mr.controller.scenery.view.SceneryQueryVM;
import com.mr.controller.scenery.view.SceneryRouteVM;
import com.mr.dao.dictionary.DictionaryMapper;
import com.mr.dao.scenery.SceneryMapper;
import com.mr.dto.RecommendDetailDTO;
import com.mr.dto.SceneryDTO;
import com.mr.dto.SceneryQueryDTO;
import com.mr.dto.SceneryRouteDTO;
import com.mr.entity.dictionary.Dictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhanxp
 * @version 1.0  2019/2/10
 * @Description todo
 */
@Service
public class SceneryServiceImpl implements SceneryService {
    @Autowired
    private SceneryMapper sceneryMapper;
    @Autowired
    private DictionaryMapper dictionaryMapper;

    @Override
    public List<SceneryRouteVM> routePlan(SceneryRoutePM sceneryRoutePM) {
        List<List<SceneryRouteDTO>> listList = getRoutePlan(sceneryRoutePM);
        return listList.stream().map(x -> {
            SceneryRouteVM sceneryRouteVM = new SceneryRouteVM();
            sceneryRouteVM.setIdList(x.stream().map(SceneryRouteDTO::getId).collect(Collectors.toList()));
            sceneryRouteVM.setImage(x.get(0).getPictures().split(StrUtil.COMMA)[0]);
            sceneryRouteVM.setNumber(x.size());
            sceneryRouteVM.setScore((int) (x.stream().mapToDouble(SceneryRouteDTO::getAverageScore).average().orElse(0) + 0.5));
            int time = x.stream().mapToInt(SceneryRouteDTO::getAdviseDuration).sum();
            if (time < 5) {
                sceneryRouteVM.setTimeDescription("轻松");
            } else if (time < 6) {
                sceneryRouteVM.setTimeDescription("适度");
            } else {
                sceneryRouteVM.setTimeDescription("挑战");
            }
            BigDecimal price = x.stream().map(SceneryRouteDTO::getAdultTicket).reduce(BigDecimal.ZERO, BigDecimal::add);
            sceneryRouteVM.setPrice(price.toString());
            List<String> routeList = x.stream().map(SceneryRouteDTO::getName).collect(Collectors.toList());
            sceneryRouteVM.setRoutePlan(String.join("-->", routeList));
            return sceneryRouteVM;
        }).collect(Collectors.toList());
    }

    private List<List<SceneryRouteDTO>> getRoutePlan(SceneryRoutePM sceneryRoutePM) {
        SceneryQueryDTO sceneryQueryDTO = new SceneryQueryDTO();
        if (StrUtil.isNotBlank(sceneryRoutePM.getCity())) {
            Dictionary dictionary = dictionaryMapper.getByTypeAndLabel(ENDictionaryType.CITY.getValue(), sceneryRoutePM.getCity());
            if (ObjectUtil.isNull(dictionary)) {
                throw new BusinessException("该城市暂未开通");
            }
            sceneryQueryDTO.setCityCode(dictionary.getKey());
            sceneryQueryDTO.setCategoryList(sceneryRoutePM.getCategoryList());
            sceneryQueryDTO.setPreferenceList(sceneryRoutePM.getPreferenceList());
            sceneryQueryDTO.setWeather(sceneryRoutePM.getWeather());
        }
        List<SceneryRouteDTO> list = sceneryMapper.routeSuit(sceneryQueryDTO);
        if (CollectionUtil.isEmpty(list)) {
            throw new BusinessException("暂无推荐景点");
        }

        boolean hasCategory = CollectionUtil.isNotEmpty(sceneryRoutePM.getCategoryList());
        boolean hasPreference = CollectionUtil.isNotEmpty(sceneryRoutePM.getPreferenceList());
        list.forEach(x -> {
            double averageCategoryScore = 3;
            double averagePreferenceScore = 3;
            if (hasCategory) {
                averageCategoryScore = x.getCategoryScore() * 1.0 / sceneryRoutePM.getCategoryList().size();
            }
            if (hasPreference) {
                averagePreferenceScore = x.getPreferenceScore() * 1.0 / sceneryRoutePM.getPreferenceList().size();
            }
            x.setAverageScore((averageCategoryScore + averagePreferenceScore) / 2);
        });


        //一天一个景点的路线
        List<SceneryRouteDTO> oneScenerys = list.stream()
                .filter(x -> x.getAdviseDuration() >= 6 && x.getAdviseDuration() <= 8).collect(Collectors.toList());
        List<List<SceneryRouteDTO>> oneSceneryList = oneScenerys.stream().map(Collections::singletonList).collect(Collectors.toList());

        // todo 选择景点后，从评分高的景点开始玩（玩累了可能中途放弃，考虑用户心理，每次最近的景点玩，这样有时间放松）
        //一天两个景点的路线
        List<List<SceneryRouteDTO>> twoSceneryList = getSomeFromList(list, 2);
        twoSceneryList = getSuitable(twoSceneryList);

        //一天三个景点的路线
        List<List<SceneryRouteDTO>> threeSceneryList = getSomeFromList(list, 3);
        threeSceneryList = getSuitable(threeSceneryList);

        //一天四个景点的路线
        List<List<SceneryRouteDTO>> fourSceneryList = getSomeFromList(list, 4);
        fourSceneryList = getSuitable(fourSceneryList);

        List<List<SceneryRouteDTO>> allSuitableList = new LinkedList<>();
        allSuitableList.addAll(oneSceneryList);
        allSuitableList.addAll(twoSceneryList);
        allSuitableList.addAll(threeSceneryList);
        allSuitableList.addAll(fourSceneryList);

        //这里还要按最优分数排序，取前7个

        //从小到大
        allSuitableList.sort(this::comparator);
        //反序
        Collections.reverse(allSuitableList);
        //取前7个
        if (allSuitableList.size() < 7) {
            return allSuitableList;
        } else {
            return allSuitableList.subList(0, 7);
        }
    }

    private int comparator(List<SceneryRouteDTO> x, List<SceneryRouteDTO> y) {
        double xScore = x.stream().mapToDouble(SceneryRouteDTO::getAverageScore).average().orElse(0);
        double yScore = y.stream().mapToDouble(SceneryRouteDTO::getAverageScore).average().orElse(0);
        return (int) ((xScore - yScore) * 10000);
    }

    /**
     * 获取在一天时间范围内的景点
     *
     * @param list
     * @return
     */
    private List<List<SceneryRouteDTO>> getSuitable(List<List<SceneryRouteDTO>> list) {
        if (ObjectUtil.isNotNull(list)) {
            list = list.stream().map(this::getBestRoute).collect(Collectors.toList());
            list = list.stream().filter(x -> {
                double allTime = allTime(x);
                return allTime >= 6 && allTime <= 8;
            }).collect(Collectors.toList());
            return list;
        }
        return new LinkedList<>();
    }

    /**
     * 获取游玩所有景点花费的时间
     *
     * @param list
     * @return
     */
    private double allTime(List<SceneryRouteDTO> list) {
        double allTime = list.stream().mapToDouble(SceneryRouteDTO::getAdviseDuration).sum();
        for (int i = 0; i < list.size() - 1; i++) {
            double distance = distanceDouble(list.get(i).getPosition(), list.get(i + 1).getPosition());
            //路程转化成时间
            allTime = allTime + distance * 0.1;
        }
        return allTime;
    }

    /**
     * 获取从评分高的景点开始玩，优先最近的路线
     *
     * @param list
     * @return
     */
    private List<SceneryRouteDTO> getBestRoute(List<SceneryRouteDTO> list) {
        SceneryRouteDTO sceneryRouteDTO = list.stream().max((x, y) -> (int) ((x.getAverageScore() - y.getAverageScore()) * 1000))
                .orElseThrow(() -> new BusinessException("获取最佳景点异常"));
        list.remove(sceneryRouteDTO);
        List<SceneryRouteDTO> sceneryRouteDTOList = new LinkedList<>();
        sceneryRouteDTOList.add(sceneryRouteDTO);
        sceneryRouteDTOList.addAll(getBest(sceneryRouteDTO, list));
        return sceneryRouteDTOList;
    }

    /**
     * 按贪心算法获取最佳路线
     *
     * @param sceneryRouteDTO
     * @param list
     * @return
     */
    private List<SceneryRouteDTO> getBest(SceneryRouteDTO sceneryRouteDTO, List<SceneryRouteDTO> list) {
        if (list.size() == 1) {
            return list;
        }
        String position = sceneryRouteDTO.getPosition();
        List<SceneryRouteDTO> positionList = new LinkedList<>();
        SceneryRouteDTO minPosition = list.stream()
                .min((x, y) -> (distance(position, x.getPosition()) - distance(position, y.getPosition())))
                .orElseThrow(() -> new RuntimeException("获取最近距离失败"));
        list.remove(minPosition);
        positionList.add(minPosition);
        positionList.addAll(getBest(minPosition, list));
        return positionList;
    }

    /**
     * 距离10000倍的整数
     *
     * @param a
     * @param b
     * @return
     */
    private int distance(String a, String b) {
        return (int) ((distanceDouble(a, b)) * 10000);
    }

    /**
     * 获取两个点直接的距离
     *
     * @param a
     * @param b
     * @return
     */
    private double distanceDouble(String a, String b) {
        a = a.replace("(", "");
        a = a.replace(")", "");
        b = b.replace("(", "");
        b = b.replace(")", "");
        double x = Double.parseDouble(a.split(",")[0]);
        double y = Double.parseDouble(a.split(",")[1]);
        double xx = Double.parseDouble(b.split(",")[0]);
        double yy = Double.parseDouble(b.split(",")[1]);
        return (x - xx) * (x - xx) + (y - yy) * (y - yy);
    }

    /**
     * 从List中获取some个数据
     *
     * @param list
     * @param some
     * @return
     */
    private List<List<SceneryRouteDTO>> getSomeFromList(List<SceneryRouteDTO> list, int some) {
        if (some == 0) {
            return null;
        }
        List<List<SceneryRouteDTO>> listList = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            List<SceneryRouteDTO> subList = new LinkedList<>();
            for (int j = i + 1; j < list.size(); j++) {
                if (j != i) {
                    subList.add(list.get(j));
                }
            }

            List<List<SceneryRouteDTO>> childrenList = getSomeFromList(subList, some - 1);
            if (childrenList != null) {
                for (List<SceneryRouteDTO> childrenItem : childrenList) {
                    List<SceneryRouteDTO> parentList = new LinkedList<>();
                    parentList.add(list.get(i));
                    parentList.addAll(childrenItem);
                    listList.add(parentList);
                }
            } else {
                listList.add(Collections.singletonList(list.get(i)));
            }
        }
        return listList;
    }

    @Override
    public List<SceneryQueryVM> recommend(SceneryQueryPM sceneryQueryPM) {
        SceneryQueryDTO sceneryQueryDTO = new SceneryQueryDTO();
        if (StrUtil.isNotBlank(sceneryQueryPM.getCity())) {
            Dictionary dictionary = dictionaryMapper.getByTypeAndLabel(ENDictionaryType.CITY.getValue(), sceneryQueryPM.getCity());
            if (ObjectUtil.isNull(dictionary)) {
                throw new BusinessException("该城市暂未开通");
            }
            sceneryQueryDTO.setCityCode(dictionary.getKey());
            sceneryQueryDTO.setCategoryList(sceneryQueryPM.getCategoryList());
            sceneryQueryDTO.setPreferenceList(sceneryQueryPM.getPreferenceList());
            sceneryQueryDTO.setWeather(sceneryQueryPM.getWeather());
        }

        List<SceneryDTO> list = sceneryMapper.suit(sceneryQueryDTO);
        if (CollectionUtil.isEmpty(list)) {
            throw new BusinessException("暂无推荐景点");
        }
        return list.stream().map(x -> {
            SceneryQueryVM sceneryQueryVM = new SceneryQueryVM();
            sceneryQueryVM.setId(x.getId());
            sceneryQueryVM.setSceneryName(x.getName());
            sceneryQueryVM.setImage(x.getPictures().split(StrUtil.COMMA)[0]);
            int allCount = 0;
            if (CollectionUtil.isNotEmpty(sceneryQueryDTO.getCategoryList())) {
                allCount += sceneryQueryDTO.getCategoryList().size();
            }
            if (CollectionUtil.isNotEmpty(sceneryQueryDTO.getPreferenceList())) {
                allCount += sceneryQueryDTO.getPreferenceList().size();
            }
            if (StrUtil.isNotBlank(sceneryQueryDTO.getWeather())) {
                allCount += 1;
            }
            sceneryQueryVM.setAverageScore((int) ((x.getCategoryScore() + x.getPreferenceScore() + x.getWeatherScore()) * 1.0 / allCount + 0.5));
            return sceneryQueryVM;
        }).collect(Collectors.toList());
    }

    @Override
    public List<SceneryDetailVM> planDetail(PlanDetailPM planDetailPM) {
        return planDetailPM.getIdList().stream().map(x -> {
            RecommendDetailDTO recommendDetailDTO = new RecommendDetailDTO();
            recommendDetailDTO.setSceneryId(x);
            recommendDetailDTO.setCategoryList(planDetailPM.getCategoryList());
            recommendDetailDTO.setPreferenceList(planDetailPM.getPreferenceList());
            recommendDetailDTO.setWeather(planDetailPM.getWeather());
            return getSceneryDetail(recommendDetailDTO);
        }).collect(Collectors.toList());
    }

    @Override
    public SceneryDetailVM recommendDetail(RecommendDetailPM recommendDetailPM) {
        RecommendDetailDTO recommendDetailDTO = new RecommendDetailDTO();
        BeanUtil.copyProperties(recommendDetailPM, recommendDetailDTO);
        return getSceneryDetail(recommendDetailDTO);
    }

    private SceneryDetailVM getSceneryDetail(RecommendDetailDTO recommendDetailDTO) {
        SceneryDTO sceneryDTO = sceneryMapper.detail(recommendDetailDTO);
        if (ObjectUtil.isNull(sceneryDTO)) {
            throw new BusinessException("景点不存在");
        }

        SceneryDetailVM sceneryDetailVM = new SceneryDetailVM();
        sceneryDetailVM.setPictureList(StrUtil.isBlank(sceneryDTO.getPictures()) ? null :
                Arrays.asList(sceneryDTO.getPictures().split(StrUtil.COMMA)));
        sceneryDetailVM.setName(sceneryDTO.getName());
        if (CollectionUtil.isNotEmpty(recommendDetailDTO.getCategoryList())) {
            sceneryDetailVM.setCategoryScore((int) (sceneryDTO.getCategoryScore() * 1.0 / recommendDetailDTO.getCategoryList().size()));
        }
        if (CollectionUtil.isNotEmpty(recommendDetailDTO.getPreferenceList())) {
            sceneryDetailVM.setPreferenceScore((int) (sceneryDTO.getPreferenceScore() * 1.0 / recommendDetailDTO.getPreferenceList().size()));
        }
        if (StrUtil.isNotBlank(recommendDetailDTO.getWeather())) {
            sceneryDetailVM.setWeatherScore(sceneryDTO.getWeatherScore());
        }
        sceneryDetailVM.setSpecial(sceneryDTO.getSpecial());
        sceneryDetailVM.setBrief(sceneryDTO.getBrief());
        sceneryDetailVM.setGuide(sceneryDTO.getGuide());
        sceneryDetailVM.setAdultTicket(sceneryDTO.getAdultTicket());
        sceneryDetailVM.setStudentTicket(sceneryDTO.getStudentTicket());
        return sceneryDetailVM;
    }
}
