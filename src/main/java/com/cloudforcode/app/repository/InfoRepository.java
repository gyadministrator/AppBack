package com.cloudforcode.app.repository;

import com.cloudforcode.app.entity.InfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/12/4
 * @email 1984629668@qq.com
 * @description
 */
@Repository
public interface InfoRepository extends JpaRepository<InfoEntity, String> {
    List<InfoEntity> findByApplicationId(String applicationId);
}
