package com.mr.service.commonsense;

import com.mr.controller.commonsense.param.SenseQueryPM;
import com.mr.controller.commonsense.view.SenseQueryVM;

import java.util.List;

/**
 * @author zhanxp
 * @version 1.0  2019/2/8
 * @Description todo
 */
public interface CommonSenseService {
    List<SenseQueryVM> query(SenseQueryPM senseQueryPM);
}
