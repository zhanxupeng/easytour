package com.mr.controller.travelphoto;

import com.mr.controller.base.BaseController;
import com.mr.controller.base.ResultContext;
import com.mr.controller.travelphoto.param.TravelDetailPM;
import com.mr.controller.travelphoto.param.TravelListPM;
import com.mr.service.travelphoto.TravelPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhanxp
 * @version 1.0  2019/2/8
 * @Description todo
 */
@RestController
@RequestMapping("/travelphoto")
public class TravelPhotoController extends BaseController {

    @Autowired
    private TravelPhotoService travelPhotoService;

    @PostMapping("/travelList.pub")
    public ResultContext travelList(TravelListPM travelListPM) {
        return success(travelPhotoService.travelList(travelListPM));
    }

    @PostMapping("/travelDetail.pub")
    public ResultContext travelDetail(TravelDetailPM travelDetailPM) {
        return success(travelPhotoService.travelDetail(travelDetailPM));
    }
}
