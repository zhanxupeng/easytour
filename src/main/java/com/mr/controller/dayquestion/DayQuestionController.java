package com.mr.controller.dayquestion;

import com.mr.controller.base.BaseController;
import com.mr.controller.base.BaseVerify;
import com.mr.controller.base.ResultContext;
import com.mr.controller.dayquestion.param.AnswerPM;
import com.mr.service.dayquestion.DayQuestionService;
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
@RequestMapping("/dayQuestion")
public class DayQuestionController extends BaseController {

    @Autowired
    private DayQuestionService dayQuestionService;

    @PostMapping("/question.do")
    public ResultContext question(BaseVerify baseVerify) {
        verify(baseVerify);
        return success(dayQuestionService.getQuestion());
    }

    @PostMapping("/answer.do")
    public ResultContext answer(AnswerPM answerPM) {
        verify(answerPM);
        return success(dayQuestionService.answer(answerPM.getAnswer()));
    }
}
