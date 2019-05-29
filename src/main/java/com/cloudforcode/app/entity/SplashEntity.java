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
 * @date 2018/10/27 15:24
 * @email 1984629668@qq.com
 * @description app启动图管理
 */
@Data
@Entity
@Table(name = "app_splash")
@EqualsAndHashCode()
public class SplashEntity {
    @Id
    @GenericGenerator(name = "generateUUID", strategy = "uuid")
    @GeneratedValue(generator = "generateUUID")
    private String id;
    /**
     * APP的包名
     */
    private String applicationId;
    /**
     * APP启动图
     */
    private String splashImage;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
}
