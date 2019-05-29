package com.cloudforcode.app.controller;

import com.alibaba.fastjson.JSON;
import com.cloudforcode.app.utils.AliyunOSSUtil;
import com.cloudforcode.app.utils.LoggerUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/upload")
public class UploadController {
    @PostMapping(value = "/image", produces = {"application/json;charset=utf-8"})
    public String image(@RequestParam("file") MultipartFile file) {
        LoggerUtils.info(this.getClass(), "上传图片");
        Map<String, Object> map = new HashMap<>();
        try {
            AliyunOSSUtil aliyunOSSUtil = new AliyunOSSUtil();
            String image = aliyunOSSUtil.uploadFile(file, "splash");
            image = "https://gyapp.oss-cn-beijing.aliyuncs.com/splash/" + image;
            map.put("code", 200);
            map.put("data", image);
        } catch (Exception e) {
            map.put("code", 500);
            map.put("data", "上传失败");
            e.printStackTrace();
        }
        return JSON.toJSONString(map);
    }

    @PostMapping(value = "/images", produces = {"application/json;charset=utf-8"})
    public String images(@RequestParam("file") MultipartFile[] file) {
        LoggerUtils.info(this.getClass(), "上传图片");
        StringBuilder buffer = new StringBuilder();
        Map<String, Object> map = new HashMap<>();
        try {
            for (int i = 0; i < file.length; i++) {
                AliyunOSSUtil aliyunOSSUtil = new AliyunOSSUtil();
                String image = aliyunOSSUtil.uploadFile(file[i], "splash");
                image = "https://gyapp.oss-cn-beijing.aliyuncs.com/splash/" + image;
                if (i != 0) {
                    buffer.append(",");
                }
                buffer.append(image);
            }
            map.put("code", 200);
            map.put("data", buffer.toString());
        } catch (Exception e) {
            map.put("code", 500);
            map.put("data", "上传失败");
            e.printStackTrace();
        }
        return JSON.toJSONString(map);
    }
}
