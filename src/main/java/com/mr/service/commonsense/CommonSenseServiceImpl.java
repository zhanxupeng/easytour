package com.mr.service.commonsense;

import com.github.pagehelper.PageHelper;
import com.mr.controller.commonsense.param.SenseQueryPM;
import com.mr.controller.commonsense.view.SenseQueryVM;
import com.mr.dao.commonsense.CommonSenseMapper;
import com.mr.entity.commonsense.CommonSense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhanxp
 * @version 1.0  2019/2/8
 * @Description todo
 */
@Service
public class CommonSenseServiceImpl implements CommonSenseService {
    @Autowired
    private CommonSenseMapper commonSenseMapper;

    @Override
    public List<SenseQueryVM> query(SenseQueryPM senseQueryPM) {
        PageHelper.startPage(senseQueryPM.getCurrentPage(), senseQueryPM.getPageSize());
        List<CommonSense> list = commonSenseMapper.query();
        List<SenseQueryVM> senseQueryVMList = list.stream().map(x -> {
            SenseQueryVM senseQueryVM = new SenseQueryVM();
            senseQueryVM.setTitle(x.getTitle());
            senseQueryVM.setImage(x.getPicture());
            return senseQueryVM;
        }).collect(Collectors.toList());
        return senseQueryVMList;
    }
}
