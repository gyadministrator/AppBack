package com.cloudforcode.app.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/11/29 20:39
 * @email 1984629668@qq.com
 * @description
 */
@Data
@Entity
@Table(name = "app_recipe")
@EqualsAndHashCode()
public class RecipeEntity {
    @Id
    @GenericGenerator(name = "generateUUID", strategy = "uuid")
    @GeneratedValue(generator = "generateUUID")
    private String id;
    /**
     * APP的包名
     */
    private String applicationId;

    /**
     * 图片
     */
    private String image;

    /**
     * 用户
     */
    @OneToOne
    private UserEntity userEntity;

    /**
     * 内容
     */
    private String content;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
}
