package com.cloudforcode.app.utils;

import com.aliyun.oss.OSSClient;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class AliyunOSSUtil {
    private String endpoint = "oss-cn-beijing.aliyuncs.com";
    private String accessKeyId = "LTAISsmllZxCAdEn";
    private String accessKeySecret = "cEECkSd0qItliYeWTWKxOMrTdRqx1d";
    private OSSClient ossClient;

    public AliyunOSSUtil() {
        ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
    }

    public void init() {
        ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
    }

    /**
     * @param file     上传的文件
     * @param rootName 文件名
     * @return
     * @throws IOException
     */
    public String uploadFile(MultipartFile file, String rootName) throws IOException {
        if (file.getSize() > 100 * 1024 * 1024) {
            return null;
        }
        String originalFilename = file.getOriginalFilename();
        String substring = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
        String name = simpleDateFormat.format(new Date())+"-" + UUID.randomUUID() + substring;
        InputStream inputStream = file.getInputStream();

        ossClient.putObject("gyapp", rootName + "/" + name, inputStream);

        ossClient.shutdown();

        return name;
    }

    /**
     * 上传新图片,删除原图片,用于更新.
     * 先上传,再删除.
     *
     * @param file     图片文件
     * @param rootName 存放路径
     * @param oldName  旧图片名称
     * @return 新图片名字
     * @throws IOException
     */
    public String uploadFile(MultipartFile file, String rootName, String oldName) throws IOException {
        String name = uploadFile(file, rootName);

        init();
        ossClient.deleteObject("gyapp", oldName);
        ossClient.shutdown();
        return name;
    }

}
