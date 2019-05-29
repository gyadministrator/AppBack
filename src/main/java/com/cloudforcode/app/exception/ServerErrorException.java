package com.cloudforcode.app.exception;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/10/27 15:33
 * @email 1984629668@qq.com
 * @description 服务器异常
 */
public class ServerErrorException extends RuntimeException {

    public ServerErrorException(String message) {
        super("服务器内部错误:" + message);
    }
}
