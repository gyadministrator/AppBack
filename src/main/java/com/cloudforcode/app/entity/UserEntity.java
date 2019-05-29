package com.cloudforcode.app.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/11/27
 * @email 1984629668@qq.com
 * @description
 */
@Data
@Entity
@Table(name = "app_user")
@EqualsAndHashCode()
public class UserEntity {
    @Id
    @GenericGenerator(name = "generateUUID", strategy = "uuid")
    @GeneratedValue(generator = "generateUUID")
    private String id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 所在地址
     */
    private String address;

    /**
     * 性别
     */
    private String sex;

    /**
     * 头像
     */
    private String image;

    /**
     * APP的包名
     */
    private String applicationId;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
}
