package com.mr.controller.scenery;

import com.mr.controller.base.BaseController;
import com.mr.controller.base.ResultContext;
import com.mr.controller.scenery.param.PlanDetailPM;
import com.mr.controller.scenery.param.RecommendDetailPM;
import com.mr.controller.scenery.param.SceneryQueryPM;
import com.mr.controller.scenery.param.SceneryRoutePM;
import com.mr.service.scenery.SceneryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhanxp
 * @version 1.0  2019/2/8
 * @Description todo
 */
@RestController
@RequestMapping("/scenery")
public class SceneryController extends BaseController {

    @Autowired
    private SceneryService sceneryService;

    @PostMapping("/recommend.pub")
    public ResultContext recommend(@RequestBody SceneryQueryPM sceneryQueryPM) {
        return success(sceneryService.recommend(sceneryQueryPM));
    }

    @PostMapping("/recommendDetail.pub")
    public ResultContext recommendDetail(@RequestBody RecommendDetailPM recommendDetailPM) {
        return success(sceneryService.recommendDetail(recommendDetailPM));
    }

    @PostMapping("/routePlan.pub")
    public ResultContext routePlan(@RequestBody SceneryRoutePM sceneryRoutePM) {
        return success(sceneryService.routePlan(sceneryRoutePM));
    }

    @PostMapping("/planDetail.pub")
    public ResultContext planDetail(@RequestBody PlanDetailPM planDetailPM) {
        return success(sceneryService.planDetail(planDetailPM));
    }
}
