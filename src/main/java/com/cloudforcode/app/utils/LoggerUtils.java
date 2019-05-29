package com.cloudforcode.app.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/10/27 21:01
 * @email 1984629668@qq.com
 * @description
 */
public class LoggerUtils {
    private static Logger logger;

    private static void init(Class className) {
        logger = LoggerFactory.getLogger(className.getSimpleName());
    }

    public static void debug(Class className, String message) {
        init(className);
        logger.debug(message);
    }

    public static void info(Class className, String message) {
        init(className);
        logger.info("------->>>" + message);
    }

    public static void error(Class className, String message) {
        init(className);
        logger.error("------->>>" + message);
    }

    public static void warn(Class className, String message) {
        init(className);
        logger.warn("------->>>" + message);
    }
}
