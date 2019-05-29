package com.cloudforcode.app.repository;

import com.cloudforcode.app.entity.ApkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/10/29 21:27
 * @email 1984629668@qq.com
 * @description
 */
@Repository
public interface ApkRepository extends JpaRepository<ApkEntity, String> {
    List<ApkEntity> findByApplicationId(String applicationId);
}
