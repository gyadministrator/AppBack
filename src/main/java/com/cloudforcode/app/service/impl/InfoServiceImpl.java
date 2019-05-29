package com.cloudforcode.app.service.impl;

import com.cloudforcode.app.entity.InfoEntity;
import com.cloudforcode.app.repository.InfoRepository;
import com.cloudforcode.app.service.InfoService;
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
public class InfoServiceImpl implements InfoService {
    private final InfoRepository infoRepository;

    @Autowired
    public InfoServiceImpl(InfoRepository infoRepository) {
        this.infoRepository = infoRepository;
    }

    @Override
    public InfoEntity addEntity(InfoEntity infoEntity) {
        return infoRepository.save(infoEntity);
    }

    @Override
    public void deleteEntity(String s) {
        infoRepository.deleteById(s);
    }

    @Override
    public InfoEntity findEntity(String s) {
        return infoRepository.getOne(s);
    }

    @Override
    public Items<InfoEntity> findAllEntity(String applicationId) {
        long count = infoRepository.count();
        List<InfoEntity> list = infoRepository.findByApplicationId(applicationId);
        return new Items<>(count, list);
    }

    @Override
    public PageQuery<InfoEntity> pageEntity(Integer currentPage, Integer pageSize, OrderType orderType, String... sortField) {
        return new QueryUtils<InfoEntity>().pageEntity(infoRepository, currentPage, pageSize, orderType, sortField);
    }
}
