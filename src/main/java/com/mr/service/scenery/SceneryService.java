package com.mr.service.scenery;

import com.mr.controller.scenery.param.PlanDetailPM;
import com.mr.controller.scenery.param.RecommendDetailPM;
import com.mr.controller.scenery.param.SceneryQueryPM;
import com.mr.controller.scenery.param.SceneryRoutePM;
import com.mr.controller.scenery.view.SceneryDetailVM;
import com.mr.controller.scenery.view.SceneryQueryVM;
import com.mr.controller.scenery.view.SceneryRouteVM;

import java.util.List;

/**
 * @author zhanxp
 * @version 1.0  2019/2/10
 * @Description todo
 */
public interface SceneryService {
    List<SceneryQueryVM> recommend(SceneryQueryPM sceneryQueryPM);

    SceneryDetailVM recommendDetail(RecommendDetailPM recommendDetailPM);

    List<SceneryRouteVM> routePlan(SceneryRoutePM sceneryRoutePM);

    List<SceneryDetailVM> planDetail(PlanDetailPM planDetailPM);
}
