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
 * @date 2018/10/29 21:03
 * @email 1984629668@qq.com
 * @description APP更新接口
 */
@Data
@Entity
@Table(name = "app_apk")
@EqualsAndHashCode()
public class ApkEntity {
    @Id
    @GenericGenerator(name = "generateUUID", strategy = "uuid")
    @GeneratedValue(generator = "generateUUID")
    private String id;
    /**
     * APP的包名
     */
    private String applicationId;
    /**
     * APP下载地址
     */
    private String url;

    /**
     * APP里面的版本号
     */
    private Integer versionCode;

    /**
     * 版本名称
     */
    private String versionName;

    /**
     * APP更新的内容
     */
    private String content;

    /**
     * 是否强制更新
     */
    private String isUpdate;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
}
