package com.mr.controller.dayquestion.view;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author zhanxp
 * @version 1.0  2019/2/8
 * @Description todo
 */
@Getter
@Setter
@ToString
public class QuestionVM implements Serializable {
    private String question;
    private String answera;
    private String answerb;
    private String answerc;
    private String answerd;
}
