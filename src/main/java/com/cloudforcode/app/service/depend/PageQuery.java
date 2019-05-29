package com.cloudforcode.app.service.depend;

import lombok.Data;

import java.util.List;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/10/27 20:12
 * @email 1984629668@qq.com
 * @description 分页查询
 */
@Data
public class PageQuery<T> {
    private Integer currentPage;
    private Integer pageSize;
    private Long count;
    private List<T> items;
}
