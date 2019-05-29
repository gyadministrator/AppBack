package com.cloudforcode.app.utils;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/10/29 21:09
 * @email 1984629668@qq.com
 * @description 文件管理
 */
public class FileUtils {
    public static boolean checkImage(String fileName) {
        fileName = fileName.substring(fileName.indexOf(".") + 1, fileName.length());
        return "png".equals(fileName) || "jpg".equals(fileName) || "jpeg".equals(fileName);
    }

    public static boolean checkApk(String fileName) {
        fileName = fileName.substring(fileName.indexOf(".") + 1, fileName.length());
        return "apk".equals(fileName);
    }
}
