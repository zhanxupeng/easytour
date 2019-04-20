package com.mr.service.travelphoto;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.mr.controller.travelphoto.param.TravelDetailPM;
import com.mr.controller.travelphoto.param.TravelListPM;
import com.mr.controller.travelphoto.view.TravelDetailVM;
import com.mr.controller.travelphoto.view.TravelListVM;
import com.mr.dao.travelphoto.TravelPhotoMapper;
import com.mr.dto.TravelListDTO;
import com.mr.entity.travelphoto.TravelPhoto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhanxp
 * @version 1.0  2019/2/8
 * @Description todo
 */
@Service
public class TravelPhotoServiceImpl implements TravelPhotoService {
    @Autowired
    private TravelPhotoMapper travelPhotoMapper;

    @Override
    public List<TravelListVM> travelList(TravelListPM travelListPM) {
        List<TravelListDTO> list = travelPhotoMapper.selectByCategory(travelListPM.getCategory());
        return list.stream().map(x -> {
            TravelListVM travelListVM = new TravelListVM();
            travelListVM.setId(x.getId());
            travelListVM.setNickName(x.getNickName());
            travelListVM.setBrief(x.getBrief());
            travelListVM.setHeadPicture(x.getHeadPicture());
            travelListVM.setImage(StrUtil.isBlank(x.getPictures()) ? null : x.getPictures().split(StrUtil.COMMA)[0]);
            return travelListVM;
        }).collect(Collectors.toList());
    }

    @Override
    public TravelDetailVM travelDetail(TravelDetailPM travelDetailPM) {
        TravelPhoto travelPhoto = travelPhotoMapper.getById(travelDetailPM.getId());
        TravelDetailVM travelDetailVM = new TravelDetailVM();
        travelDetailVM.setPictureList(ObjectUtil.isNull(travelPhoto.getPictures()) ? null :
                Arrays.asList(travelPhoto.getPictures().split(StrUtil.COMMA)));
        travelDetailVM.setCity(travelPhoto.getCity());
        travelDetailVM.setSceneryName(travelPhoto.getSceneryName());
        travelDetailVM.setTitle(travelPhoto.getTitle());
        travelDetailVM.setContent(travelPhoto.getContent());
        return travelDetailVM;
    }
}
