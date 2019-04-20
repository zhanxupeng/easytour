package com.mr.service.travelphoto;

import com.mr.controller.travelphoto.param.TravelDetailPM;
import com.mr.controller.travelphoto.param.TravelListPM;
import com.mr.controller.travelphoto.view.TravelDetailVM;
import com.mr.controller.travelphoto.view.TravelListVM;

import java.util.List;

/**
 * @author zhanxp
 * @version 1.0  2019/2/8
 * @Description todo
 */
public interface TravelPhotoService {
    List<TravelListVM> travelList(TravelListPM travelListPM);

    TravelDetailVM travelDetail(TravelDetailPM travelDetailPM);
}
