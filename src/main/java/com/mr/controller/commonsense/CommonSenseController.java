package com.mr.controller.commonsense;

import com.mr.controller.base.BaseController;
import com.mr.controller.base.ResultContext;
import com.mr.controller.commonsense.param.SenseQueryPM;
import com.mr.service.commonsense.CommonSenseService;
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
@RequestMapping("/commomSense")
public class CommonSenseController extends BaseController {

    @Autowired
    private CommonSenseService commonSenseService;

    @PostMapping("/query.pub")
    public ResultContext query(SenseQueryPM senseQueryPM) {
        return success(commonSenseService.query(senseQueryPM));
    }
}
