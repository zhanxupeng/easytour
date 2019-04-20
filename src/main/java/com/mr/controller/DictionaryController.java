package com.mr.controller;

import cn.hutool.core.util.ObjectUtil;
import com.mr.dao.dictionary.DictionaryMapper;
import com.mr.entity.dictionary.Dictionary;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author zhanxp
 * @version 1.0  2019/2/7
 * @Description todo
 */
@RestController
public class DictionaryController {
    @Autowired
    private DictionaryMapper dictionaryMapper;
    @Autowired
    private RedissonClient redissonClient;

    @GetMapping("getById.do")
    public Map<String, String> getById() {
        RBucket<Dictionary> bucket = redissonClient.getBucket("1");
        Dictionary dictionary;
        dictionary = bucket.get();
        if (ObjectUtil.isNull(dictionary)) {
            System.out.println("从数据库中获取");
            dictionary = dictionaryMapper.getById("1");
            bucket.set(dictionary, 30, TimeUnit.MINUTES);
        }
        Map<String, String> map = new HashMap<>();
        map.put("aaaa", dictionary.getLabel());
        return map;
    }
}
