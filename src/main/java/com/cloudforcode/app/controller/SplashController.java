package com.cloudforcode.app.controller;

import com.cloudforcode.app.entity.BaseEntity;
import com.cloudforcode.app.entity.SplashEntity;
import com.cloudforcode.app.service.SplashService;
import com.cloudforcode.app.service.depend.Items;
import com.cloudforcode.app.service.depend.OrderType;
import com.cloudforcode.app.service.depend.PageQuery;
import com.cloudforcode.app.utils.LoggerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/10/27 20:54
 * @email 1984629668@qq.com
 * @description
 */
@RestController
@RequestMapping("splash")
public class SplashController {
    private final SplashService splashService;

    @Autowired
    public SplashController(SplashService splashService) {
        this.splashService = splashService;
    }

    @PostMapping("/addSplash")
    public BaseEntity addEntity(@RequestBody SplashEntity splashEntity) {
        LoggerUtils.info(this.getClass(), "添加启动图" + splashEntity.toString());
        splashEntity.setCreateTime(new Date());
        splashEntity = splashService.addEntity(splashEntity);
        BaseEntity<SplashEntity> baseEntity = new BaseEntity<>();
        baseEntity.setCode(200);
        baseEntity.setData(splashEntity);
        baseEntity.setMessage("添加成功");
        return baseEntity;
    }

    @GetMapping("/pageEntity/{currentPage}/{pageSize}")
    public BaseEntity pageEntity(@PathVariable("currentPage") Integer currentPage, @PathVariable("pageSize") Integer pageSize) {
        LoggerUtils.info(this.getClass(), "分页查询" + "当前页:" + currentPage + "每页条数:" + pageSize);
        PageQuery<SplashEntity> pageEntity = splashService.pageEntity(currentPage, pageSize, OrderType.DESC, "id");
        BaseEntity<PageQuery<SplashEntity>> baseEntity = new BaseEntity<>();
        baseEntity.setCode(200);
        baseEntity.setMessage("查询成功");
        baseEntity.setData(pageEntity);
        return baseEntity;
    }

    @GetMapping("/update")
    public BaseEntity updateEntity(@RequestParam("applicationId")String applicationId) {
        LoggerUtils.info(this.getClass(), "获取最新启动图");
        Items<SplashEntity> allEntity = splashService.findAllEntity(applicationId);
        List<SplashEntity> items = allEntity.getItems();
        SplashEntity splashEntity = items.get(items.size() - 1);
        BaseEntity<SplashEntity> baseEntity = new BaseEntity<>();
        baseEntity.setCode(200);
        baseEntity.setMessage("获取成功");
        baseEntity.setData(splashEntity);
        return baseEntity;
    }
}
