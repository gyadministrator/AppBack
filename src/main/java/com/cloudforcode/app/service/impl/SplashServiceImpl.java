package com.cloudforcode.app.service.impl;

import com.cloudforcode.app.entity.SplashEntity;
import com.cloudforcode.app.repository.SplashRepository;
import com.cloudforcode.app.service.SplashService;
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
 * @date 2018/10/27 20:45
 * @email 1984629668@qq.com
 * @description
 */
@Service
public class SplashServiceImpl implements SplashService {
    private final SplashRepository splashRepository;

    @Autowired
    public SplashServiceImpl(SplashRepository splashRepository) {
        this.splashRepository = splashRepository;
    }

    @Override
    public SplashEntity addEntity(SplashEntity splashEntity) {
        return splashRepository.save(splashEntity);
    }

    @Override
    public void deleteEntity(String s) {
        splashRepository.deleteById(s);
    }

    @Override
    public SplashEntity findEntity(String s) {
        return splashRepository.getOne(s);
    }

    @Override
    public Items<SplashEntity> findAllEntity(String applicationId) {
        long count = splashRepository.count();
        List<SplashEntity> all = splashRepository.findByApplicationId(applicationId);
        return new Items<>(count, all);
    }

    @Override
    public PageQuery<SplashEntity> pageEntity(Integer currentPage, Integer pageSize, OrderType orderType, String... sortField) {
        return new QueryUtils<SplashEntity>().pageEntity(splashRepository, currentPage, pageSize, orderType, sortField);
    }
}
