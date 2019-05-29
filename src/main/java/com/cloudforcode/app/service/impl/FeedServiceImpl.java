package com.cloudforcode.app.service.impl;

import com.cloudforcode.app.entity.FeedEntity;
import com.cloudforcode.app.repository.FeedRepository;
import com.cloudforcode.app.service.FeedService;
import com.cloudforcode.app.service.depend.Items;
import com.cloudforcode.app.service.depend.OrderType;
import com.cloudforcode.app.service.depend.PageQuery;
import com.cloudforcode.app.service.depend.QueryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/12/4
 * @email 1984629668@qq.com
 * @description
 */
@Service
public class FeedServiceImpl implements FeedService {
    private final FeedRepository feedRepository;

    @Autowired
    public FeedServiceImpl(FeedRepository feedRepository) {
        this.feedRepository = feedRepository;
    }

    @Override
    public FeedEntity addEntity(FeedEntity feedEntity) {
        return feedRepository.save(feedEntity);
    }

    @Override
    public void deleteEntity(String s) {
        feedRepository.deleteById(s);
    }

    @Override
    public FeedEntity findEntity(String s) {
        return feedRepository.getOne(s);
    }

    @Override
    public Items<FeedEntity> findAllEntity(String applicationId) {
        long count = feedRepository.count();
        List<FeedEntity> list = feedRepository.findByApplicationId(applicationId);
        return new Items<>(count, list);
    }

    @Override
    public PageQuery<FeedEntity> pageEntity(Integer currentPage, Integer pageSize, OrderType orderType, String... sortField) {
        return new QueryUtils<FeedEntity>().pageEntity(feedRepository, currentPage, pageSize, orderType, sortField);
    }
}
