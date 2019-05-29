package com.cloudforcode.app.controller;

import com.cloudforcode.app.entity.BaseEntity;
import com.cloudforcode.app.entity.FeedEntity;
import com.cloudforcode.app.service.FeedService;
import com.cloudforcode.app.service.depend.OrderType;
import com.cloudforcode.app.service.depend.PageQuery;
import com.cloudforcode.app.utils.LoggerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/12/4
 * @email 1984629668@qq.com
 * @description
 */
@RestController
@RequestMapping("feed")
public class FeedController {
    private final FeedService feedService;

    @Autowired
    public FeedController(FeedService feedService) {
        this.feedService = feedService;
    }

    @PostMapping("/addFeed")
    public BaseEntity addEntity(@RequestBody FeedEntity feedEntity) {
        LoggerUtils.info(this.getClass(), "添加app" + feedEntity.toString());
        feedEntity.setCreateTime(new Date());
        feedEntity = feedService.addEntity(feedEntity);
        BaseEntity<FeedEntity> baseEntity = new BaseEntity<>();
        baseEntity.setCode(200);
        baseEntity.setData(feedEntity);
        baseEntity.setMessage("添加成功");
        return baseEntity;
    }

    @GetMapping("/pageEntity/{currentPage}/{pageSize}")
    public BaseEntity pageEntity(@PathVariable("currentPage") Integer currentPage, @PathVariable("pageSize") Integer pageSize) {
        LoggerUtils.info(this.getClass(), "分页查询" + "当前页:" + currentPage + "每页条数:" + pageSize);
        PageQuery<FeedEntity> pageEntity = feedService.pageEntity(currentPage, pageSize, OrderType.DESC, "id");
        BaseEntity<PageQuery<FeedEntity>> baseEntity = new BaseEntity<>();
        baseEntity.setCode(200);
        baseEntity.setMessage("查询成功");
        baseEntity.setData(pageEntity);
        return baseEntity;
    }
}
