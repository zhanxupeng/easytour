package com.mr.service.dayquestion;

import com.mr.controller.dayquestion.view.QuestionVM;

/**
 * @author zhanxp
 * @version 1.0  2019/2/8
 * @Description todo
 */
public interface DayQuestionService {
    QuestionVM getQuestion();

    String answer(String answer);
}
