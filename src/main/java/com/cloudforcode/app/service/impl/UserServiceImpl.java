package com.cloudforcode.app.service.impl;

import com.cloudforcode.app.entity.UserEntity;
import com.cloudforcode.app.repository.UserRepository;
import com.cloudforcode.app.service.UserService;
import com.cloudforcode.app.service.depend.Items;
import com.cloudforcode.app.service.depend.OrderType;
import com.cloudforcode.app.service.depend.PageQuery;
import com.cloudforcode.app.service.depend.QueryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/11/27
 * @email 1984629668@qq.com
 * @description
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity addEntity(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public void deleteEntity(String s) {
        userRepository.deleteById(s);
    }

    @Override
    public UserEntity findEntity(String s) {
        return userRepository.getOne(s);
    }

    @Override
    public Items<UserEntity> findAllEntity(String applicationId) {
        List<UserEntity> list = userRepository.findByApplicationId(applicationId);
        long count = userRepository.count();
        return new Items<>(count, list);
    }

    @Override
    public PageQuery<UserEntity> pageEntity(Integer currentPage, Integer pageSize, OrderType orderType, String... sortField) {
        return new QueryUtils<UserEntity>().pageEntity(userRepository, currentPage, pageSize, orderType, sortField);
    }

    @Override
    public UserEntity update(UserEntity userEntity) {
        //todo
        UserEntity entity = this.findEntity(userEntity.getId());
        if (userEntity.getImage() != null && !userEntity.getImage().equals("")) {
            entity.setImage(userEntity.getImage());
        }
        if (userEntity.getAddress() != null && !userEntity.getAddress().equals("")) {
            entity.setAddress(userEntity.getAddress());
        }
        if (userEntity.getPassword() != null && !userEntity.getPassword().equals("")) {
            entity.setPassword(userEntity.getPassword());
        }
        return userRepository.save(entity);
    }

    @Override
    public UserEntity login(UserEntity userEntity) {
        return userRepository.findByUsernameAndPassword(userEntity.getUsername(), userEntity.getPassword());
    }

    @Override
    public UserEntity queryUserByPhone(String username) {
        return userRepository.findByUsername(username);
    }
}
