package com.cloudforcode.app.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/11/27
 * @email 1984629668@qq.com
 * @description
 */
public class MD5Utils {
    /**
     * MD5方法
     *
     * @param text 明文
     * @param key  密钥
     * @return 密文
     * @throws Exception
     */
    public static String md5(String text, String key) throws Exception {
        //加密后的字符串
        String encodeStr = DigestUtils.md5Hex(text + key);
        System.out.println("MD5加密后的字符串为:encodeStr=" + encodeStr);
        return encodeStr;
    }

}
