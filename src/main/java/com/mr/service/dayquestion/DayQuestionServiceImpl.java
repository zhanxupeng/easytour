package com.mr.service.dayquestion;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.mr.common.exception.BusinessException;
import com.mr.common.exception.SystemException;
import com.mr.controller.base.UserContext;
import com.mr.controller.dayquestion.view.QuestionVM;
import com.mr.dao.customer.CustomerMapper;
import com.mr.dao.dayquestion.DayQuestionMapper;
import com.mr.entity.customer.Customer;
import com.mr.entity.dayquestion.DayQuestion;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author zhanxp
 * @version 1.0  2019/2/8
 * @Description todo
 */
@Service
public class DayQuestionServiceImpl implements DayQuestionService {
    private final static String ANSWER_PREFIX = "ANSWER";
    private final static String DAY_QUESTION = "DAY_QUESTION";
    private final static String DAY_QUESTION_FLAG = "1";
    private final static int DAY_QUESTION_COIN = 10;
    @Autowired
    private DayQuestionMapper dayQuestionMapper;
    @Autowired
    private RedissonClient redissonClient;
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public QuestionVM getQuestion() {
        RBucket<String> dayQuestionBucket = redissonClient.getBucket(DAY_QUESTION + DatePattern.NORM_DATE_FORMAT.format(new Date()) + UserContext.getCustomerId());
        if (dayQuestionBucket.isExists()) {
            throw new BusinessException("您今天已经回答过问题了，请改日再来");
        }
        int count = dayQuestionMapper.countAll();
        if (count == 0) {
            throw new BusinessException("题目不存在");
        }
        int random = (int) (Math.random() * (count));
        PageHelper.startPage(random + 1, 1);
        List<DayQuestion> dayQuestionList = dayQuestionMapper.query();
        if (CollectionUtil.isEmpty(dayQuestionList)) {
            throw new BusinessException("查询题目出错");
        }
        DayQuestion dayQuestion = dayQuestionList.get(0);
        QuestionVM questionVM = new QuestionVM();
        questionVM.setQuestion(dayQuestion.getQuestion());
        questionVM.setAnswera(dayQuestion.getAnswera());
        questionVM.setAnswerb(dayQuestion.getAnswerb());
        questionVM.setAnswerc(dayQuestion.getAnswerc());
        questionVM.setAnswerd(dayQuestion.getAnswerd());
        RBucket<String> rBucket = redissonClient.getBucket(ANSWER_PREFIX + UserContext.getCustomerId());
        rBucket.set(dayQuestion.getAnswer(), 30, TimeUnit.MINUTES);
        return questionVM;
    }

    @Override
    public String answer(String answer) {
        RBucket<String> bucket = redissonClient.getBucket(ANSWER_PREFIX + UserContext.getCustomerId());
        RBucket<String> dayQuestionBucket = redissonClient.getBucket(DAY_QUESTION + DatePattern.NORM_DATE_FORMAT.format(new Date()) + UserContext.getCustomerId());
        if (dayQuestionBucket.isExists()) {
            throw new BusinessException("您今天已经回答过问题了，请改日再来");
        }
        String rightAnswer = bucket.get();
        if (StrUtil.isBlank(rightAnswer)) {
            dayQuestionBucket.set(DAY_QUESTION_FLAG, 1, TimeUnit.DAYS);
            throw new BusinessException("回答超时，请改天再来");
        }
        if (!rightAnswer.equals(answer)) {
            dayQuestionBucket.set(DAY_QUESTION_FLAG, 1, TimeUnit.DAYS);
            throw new BusinessException("回答错误，请改天再来");
        }

        Customer customer = customerMapper.getById(UserContext.getCustomerId());
        customer.edit();
        customer.setGoldCoin(customer.getGoldCoin() + DAY_QUESTION_COIN);
        int update = customerMapper.update(customer);
        if (update == 0) {
            throw new SystemException("系统错误");
        }
        dayQuestionBucket.set(DAY_QUESTION_FLAG, 1, TimeUnit.DAYS);
        return String.format("回答成功，获得%s枚金币，当前金币%s枚", DAY_QUESTION_COIN, customer.getGoldCoin());
    }
}
