package com.cloudforcode.app.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.cloudforcode.app.entity.BaseEntity;
import com.cloudforcode.app.entity.UserEntity;
import com.cloudforcode.app.service.UserService;
import com.cloudforcode.app.service.depend.OrderType;
import com.cloudforcode.app.service.depend.PageQuery;
import com.cloudforcode.app.utils.Des3Util;
import com.cloudforcode.app.utils.LoggerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/11/29 20:05
 * @email 1984629668@qq.com
 * @description
 */
@RestController
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public BaseEntity addEntity(@RequestBody UserEntity userEntity) {
        LoggerUtils.info(this.getClass(), "添加app" + userEntity.toString());
        UserEntity u = userService.queryUserByPhone(userEntity.getUsername());
        BaseEntity<UserEntity> baseEntity = new BaseEntity<>();
        if (u == null) {
            userEntity.setCreateTime(new Date());
            userEntity = userService.addEntity(userEntity);
            baseEntity.setCode(200);
            baseEntity.setData(userEntity);
            baseEntity.setMessage("添加成功");
        } else {
            baseEntity.setCode(500);
            baseEntity.setData(userEntity);
            baseEntity.setMessage("添加失败");
        }
        return baseEntity;
    }

    @GetMapping("/pageEntity/{currentPage}/{pageSize}")
    public BaseEntity pageEntity(@PathVariable("currentPage") Integer currentPage, @PathVariable("pageSize") Integer pageSize) {
        LoggerUtils.info(this.getClass(), "分页查询" + "当前页:" + currentPage + "每页条数:" + pageSize);
        PageQuery<UserEntity> pageEntity = userService.pageEntity(currentPage, pageSize, OrderType.DESC, "id");
        BaseEntity<PageQuery<UserEntity>> baseEntity = new BaseEntity<>();
        baseEntity.setCode(200);
        baseEntity.setMessage("查询成功");
        baseEntity.setData(pageEntity);
        return baseEntity;
    }

    @PutMapping("/update")
    public BaseEntity update(@RequestBody UserEntity userEntity) {
        LoggerUtils.info(this.getClass(), "用户登录" + userEntity.toString());
        userEntity = userService.update(userEntity);
        BaseEntity<UserEntity> baseEntity = new BaseEntity<>();
        baseEntity.setCode(200);
        baseEntity.setMessage("查询成功");
        baseEntity.setData(userEntity);
        return baseEntity;
    }

    @PostMapping("/login")
    public String login(@RequestBody String param) {
        UserEntity userEntity = new UserEntity();
        BaseEntity<UserEntity> baseEntity = new BaseEntity<>();
        try {
            String json = Des3Util.decode(param);
            JSONObject jsonObject = (JSONObject) JSON.parse(json);
            userEntity.setUsername(jsonObject.getString("username"));
            userEntity.setPassword(jsonObject.getString("password"));
            userEntity = userService.login(userEntity);
            if (userEntity != null) {
                baseEntity.setCode(200);
                baseEntity.setMessage("登录成功");
                baseEntity.setData(userEntity);
            } else {
                baseEntity.setCode(500);
                baseEntity.setMessage("登录失败");
                baseEntity.setData(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            baseEntity.setCode(500);
            baseEntity.setMessage("登录失败");
            baseEntity.setData(null);
        }
        return baseEntity.result(baseEntity);
    }

  /*  @PostMapping("/login")
    public BaseEntity login(@RequestBody UserEntity userEntity) {
        userEntity = userService.login(userEntity);
        BaseEntity<UserEntity> baseEntity = new BaseEntity<>();
        if (userEntity != null) {
            baseEntity.setCode(200);
            baseEntity.setMessage("登录成功");
            baseEntity.setData(userEntity);
        } else {
            baseEntity.setCode(500);
            baseEntity.setMessage("登录失败");
            baseEntity.setData(null);
        }
        return baseEntity;
    }*/

    @GetMapping("/queryUser")
    public BaseEntity queryUser(@RequestParam("userId") String userId) {
        UserEntity userEntity = userService.queryUserByPhone(userId);
        BaseEntity<UserEntity> baseEntity = new BaseEntity<>();
        if (userEntity != null) {
            baseEntity.setCode(200);
            baseEntity.setMessage("查询成功");
            baseEntity.setData(userEntity);
        } else {
            baseEntity.setCode(500);
            baseEntity.setMessage("查询失败");
            baseEntity.setData(null);
        }
        return baseEntity;
    }
}
