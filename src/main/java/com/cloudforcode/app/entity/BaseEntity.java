package com.cloudforcode.app.entity;

import com.alibaba.fastjson.JSON;
import com.cloudforcode.app.utils.Des3Util;
import lombok.Data;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/10/27 15:33
 * @email 1984629668@qq.com
 * @description 统一数据返回类
 */
@Data
public class BaseEntity<T> {
    /**
     * 返回的状态码
     */
    private int code;
    /**
     * 返回的信息
     */
    private String message;
    /**
     * 返回的数据
     */
    private T data;

    public String result(BaseEntity baseEntity) {
        String result = null;
        try {
            result = Des3Util.encode(JSON.toJSONString(baseEntity));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
