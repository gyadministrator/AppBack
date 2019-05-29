package com.cloudforcode.app.controller;

import com.cloudforcode.app.entity.BaseEntity;
import com.cloudforcode.app.entity.RecipeEntity;
import com.cloudforcode.app.service.RecipeService;
import com.cloudforcode.app.service.depend.OrderType;
import com.cloudforcode.app.service.depend.PageQuery;
import com.cloudforcode.app.utils.LoggerUtils;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/11/29 20:54
 * @email 1984629668@qq.com
 * @description
 */
@RestController
@RequestMapping("recipe")
public class RecipeController {
    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping("/addRecipe")
    public BaseEntity addEntity(@RequestBody RecipeEntity recipeEntity) {
        LoggerUtils.info(this.getClass(), "添加app" + recipeEntity.toString());
        recipeEntity.setCreateTime(new Date());
        recipeEntity = recipeService.addEntity(recipeEntity);
        BaseEntity<RecipeEntity> baseEntity = new BaseEntity<>();
        baseEntity.setCode(200);
        baseEntity.setData(recipeEntity);
        baseEntity.setMessage("添加成功");
        return baseEntity;
    }

    @GetMapping("/pageEntity/{currentPage}/{pageSize}")
    public BaseEntity pageEntity(@PathVariable("currentPage") Integer currentPage, @PathVariable("pageSize") Integer pageSize) {
        LoggerUtils.info(this.getClass(), "分页查询" + "当前页:" + currentPage + "每页条数:" + pageSize);
        PageQuery<RecipeEntity> pageEntity = recipeService.pageEntity(currentPage, pageSize, OrderType.DESC, "id");
        BaseEntity<PageQuery<RecipeEntity>> baseEntity = new BaseEntity<>();
        baseEntity.setCode(200);
        baseEntity.setMessage("查询成功");
        baseEntity.setData(pageEntity);
        return baseEntity;
    }
}
