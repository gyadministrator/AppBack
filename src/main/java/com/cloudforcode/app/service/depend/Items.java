package com.cloudforcode.app.service.depend;

import lombok.Data;

import java.util.List;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/10/27 20:12
 * @email 1984629668@qq.com
 * @description item项
 */
@Data
public class Items<T> {

    long count;
    List<T> items;

    public Items() {
    }

    public Items(long count, List<T> items) {
        this.count = count;
        this.items = items;
    }
}
