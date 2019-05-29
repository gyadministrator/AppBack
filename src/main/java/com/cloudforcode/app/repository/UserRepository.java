package com.cloudforcode.app.repository;

import com.cloudforcode.app.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/11/27
 * @email 1984629668@qq.com
 * @description
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    List<UserEntity> findByApplicationId(String applicationId);

    UserEntity findByUsernameAndPassword(String username, String password);

    UserEntity findByUsername(String username);
}
