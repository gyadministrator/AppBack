package com.cloudforcode.app.exception;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/10/27 15:33
 * @email 1984629668@qq.com
 * @description 参数异常
 */
public class ArgumentsException extends RuntimeException {

    public ArgumentsException(String message) {
        super("参数错误:" + message);
    }
}
