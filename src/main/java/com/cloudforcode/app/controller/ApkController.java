package com.cloudforcode.app.controller;

import com.cloudforcode.app.entity.ApkEntity;
import com.cloudforcode.app.entity.BaseEntity;
import com.cloudforcode.app.service.ApkService;
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
 * @date 2018/10/29 21:34
 * @email 1984629668@qq.com
 * @description
 */
@RestController
@RequestMapping("apk")
public class ApkController {
    private final ApkService apkService;

    @Autowired
    public ApkController(ApkService apkService) {
        this.apkService = apkService;
    }

    @PostMapping("/addApk")
    public BaseEntity addEntity(@RequestBody ApkEntity apkEntity) {
        LoggerUtils.info(this.getClass(), "添加app" + apkEntity.toString());
        apkEntity.setCreateTime(new Date());
        apkEntity = apkService.addEntity(apkEntity);
        BaseEntity<ApkEntity> baseEntity = new BaseEntity<>();
        baseEntity.setCode(200);
        baseEntity.setData(apkEntity);
        baseEntity.setMessage("添加成功");
        return baseEntity;
    }

    @GetMapping("/pageEntity/{currentPage}/{pageSize}")
    public BaseEntity pageEntity(@PathVariable("currentPage") Integer currentPage, @PathVariable("pageSize") Integer pageSize) {
        LoggerUtils.info(this.getClass(), "分页查询" + "当前页:" + currentPage + "每页条数:" + pageSize);
        PageQuery<ApkEntity> pageEntity = apkService.pageEntity(currentPage, pageSize, OrderType.DESC, "id");
        BaseEntity<PageQuery<ApkEntity>> baseEntity = new BaseEntity<>();
        baseEntity.setCode(200);
        baseEntity.setMessage("查询成功");
        baseEntity.setData(pageEntity);
        return baseEntity;
    }

    @GetMapping("/update")
    public BaseEntity updateEntity(@RequestParam("applicationId") String applicationId) {
        LoggerUtils.info(this.getClass(), "获取最新app版本");
        Items<ApkEntity> allEntity = apkService.findAllEntity(applicationId);
        List<ApkEntity> items = allEntity.getItems();
        ApkEntity apkEntity = items.get(items.size() - 1);
        BaseEntity<ApkEntity> baseEntity = new BaseEntity<>();
        if (apkEntity != null) {
            baseEntity.setCode(200);
            baseEntity.setMessage("获取成功");
            baseEntity.setData(apkEntity);
        } else {
            baseEntity.setCode(500);
            baseEntity.setMessage("获取失败");
            baseEntity.setData(null);
        }
        return baseEntity;
    }
}
