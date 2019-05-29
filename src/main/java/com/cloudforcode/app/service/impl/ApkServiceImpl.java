package com.cloudforcode.app.service.impl;

import com.cloudforcode.app.entity.ApkEntity;
import com.cloudforcode.app.repository.ApkRepository;
import com.cloudforcode.app.service.ApkService;
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
 * @date 2018/10/29 21:30
 * @email 1984629668@qq.com
 * @description
 */
@Service
public class ApkServiceImpl implements ApkService {
    private final ApkRepository apkRepository;

    @Autowired
    public ApkServiceImpl(ApkRepository apkRepository) {
        this.apkRepository = apkRepository;
    }

    @Override
    public ApkEntity addEntity(ApkEntity apkEntity) {
        return apkRepository.save(apkEntity);
    }

    @Override
    public void deleteEntity(String s) {
        apkRepository.deleteById(s);
    }

    @Override
    public ApkEntity findEntity(String s) {
        return apkRepository.getOne(s);
    }

    @Override
    public Items<ApkEntity> findAllEntity(String applicationId) {
        List<ApkEntity> list = apkRepository.findByApplicationId(applicationId);
        long count = apkRepository.count();
        return new Items<>(count, list);
    }

    @Override
    public PageQuery<ApkEntity> pageEntity(Integer currentPage, Integer pageSize, OrderType orderType, String... sortField) {
        return new QueryUtils<ApkEntity>().pageEntity(apkRepository, currentPage, pageSize, OrderType.DESC, "id");
    }
}
