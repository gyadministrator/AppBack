package com.cloudforcode.app.controller;

import com.cloudforcode.app.entity.BaseEntity;
import com.cloudforcode.app.entity.InfoEntity;
import com.cloudforcode.app.service.InfoService;
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
@RequestMapping("info")
public class InfoController {
    private final InfoService infoService;

    @Autowired
    public InfoController(InfoService infoService) {
        this.infoService = infoService;
    }

    @PostMapping("/addInfo")
    public BaseEntity addEntity(@RequestBody InfoEntity infoEntity) {
        LoggerUtils.info(this.getClass(), "添加app" + infoEntity.toString());
        infoEntity.setCreateTime(new Date());
        infoEntity = infoService.addEntity(infoEntity);
        BaseEntity<InfoEntity> baseEntity = new BaseEntity<>();
        baseEntity.setCode(200);
        baseEntity.setData(infoEntity);
        baseEntity.setMessage("添加成功");
        return baseEntity;
    }

    @GetMapping("/pageEntity/{currentPage}/{pageSize}")
    public BaseEntity pageEntity(@PathVariable("currentPage") Integer currentPage, @PathVariable("pageSize") Integer pageSize) {
        LoggerUtils.info(this.getClass(), "分页查询" + "当前页:" + currentPage + "每页条数:" + pageSize);
        PageQuery<InfoEntity> pageEntity = infoService.pageEntity(currentPage, pageSize, OrderType.DESC, "id");
        BaseEntity<PageQuery<InfoEntity>> baseEntity = new BaseEntity<>();
        baseEntity.setCode(200);
        baseEntity.setMessage("查询成功");
        baseEntity.setData(pageEntity);
        return baseEntity;
    }
}
