package com.cloudforcode.app.service.depend;
import com.cloudforcode.app.exception.ArgumentsException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/10/27 20:12
 * @email 1984629668@qq.com
 * @description 分页查询工具类
 */
public class QueryUtils<T> {


    /**
     * 通用分页查询
     *
     * @param repository repository
     * @param currentPage 当前页
     * @param pageSize 每页条数
     * @param sortField 排序字段
     * @param orderType 排序类型
     * @return
     */
    public PageQuery<T> pageEntity(JpaRepository repository, Integer currentPage, Integer pageSize, OrderType orderType, String... sortField) {
        Sort sort;
        if (orderType == null || orderType == OrderType.ASC) {
            sort = new Sort(Sort.Direction.ASC, sortField);
        } else if (orderType == OrderType.DESC) {
            sort = new Sort(Sort.Direction.DESC, sortField);
        } else {
            throw new ArgumentsException("排序参数错误");
        }

        Pageable pageable = PageRequest.of(currentPage - 1, pageSize, sort);

        long count = repository.count();

        Page<T> items = repository.findAll(pageable);

        PageQuery<T> query = new PageQuery<>();
        query.setCurrentPage(currentPage);
        query.setPageSize(pageSize);
        query.setCount(count);
        query.setItems(items.getContent());
        return query;
    }
}
