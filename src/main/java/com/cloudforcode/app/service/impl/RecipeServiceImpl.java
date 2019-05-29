package com.cloudforcode.app.service.impl;

import com.cloudforcode.app.entity.RecipeEntity;
import com.cloudforcode.app.repository.RecipeRepository;
import com.cloudforcode.app.service.RecipeService;
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
 * @date 2018/11/29 20:49
 * @email 1984629668@qq.com
 * @description
 */
@Service
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public RecipeEntity addEntity(RecipeEntity recipeEntity) {
        return recipeRepository.save(recipeEntity);
    }

    @Override
    public void deleteEntity(String s) {
        recipeRepository.deleteById(s);
    }

    @Override
    public RecipeEntity findEntity(String s) {
        return recipeRepository.getOne(s);
    }

    @Override
    public Items<RecipeEntity> findAllEntity(String applicationId) {
        long count = recipeRepository.count();
        List<RecipeEntity> list = recipeRepository.findByApplicationId(applicationId);
        return new Items<>(count, list);
    }

    @Override
    public PageQuery<RecipeEntity> pageEntity(Integer currentPage, Integer pageSize, OrderType orderType, String... sortField) {
        return new QueryUtils<RecipeEntity>().pageEntity(recipeRepository, currentPage, pageSize, orderType, sortField);
    }
}
