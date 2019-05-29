package com.cloudforcode.app.service;

import com.cloudforcode.app.service.depend.Items;
import com.cloudforcode.app.service.depend.OrderType;
import com.cloudforcode.app.service.depend.PageQuery;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/10/27 20:12
 * @email 1984629668@qq.com
 * @description
 */
public interface BaseService<T, ID> {
    /**
     * 添加实体
     *
     * @param t 实体
     */
    @Transactional
    T addEntity(T t);

    /**
     * 根据id来删除实体
     *
     * @param id id
     */
    @Transactional
    void deleteEntity(ID id);

    /**
     * 根据id查询实体
     *
     * @param id id
     */
    T findEntity(ID id);

    /**
     * 查询所有
     *
     * @return
     */
    Items<T> findAllEntity(String applicationId);

    /**
     * 分页查询
     *
     * @param currentPage 当前页
     * @param pageSize    每页显示条数
     * @return
     */
    PageQuery<T> pageEntity(Integer currentPage, Integer pageSize, OrderType orderType, String... sortField);
}
