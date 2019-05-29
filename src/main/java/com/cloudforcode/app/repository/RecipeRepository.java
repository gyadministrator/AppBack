package com.cloudforcode.app.repository;

import com.cloudforcode.app.entity.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/11/29 20:48
 * @email 1984629668@qq.com
 * @description
 */
@Repository
public interface RecipeRepository extends JpaRepository<RecipeEntity, String> {
    List<RecipeEntity> findByApplicationId(String applicationId);
}
