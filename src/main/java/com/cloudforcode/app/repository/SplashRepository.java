package com.cloudforcode.app.repository;

import com.cloudforcode.app.entity.SplashEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/10/27 20:10
 * @email 1984629668@qq.com
 * @description APP启动repository
 */
@Repository
public interface SplashRepository extends JpaRepository<SplashEntity, String> {
    List<SplashEntity> findByApplicationId(String applicationId);
}
