/**
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package cn.superfl.apagemonitor.util;

import org.slf4j.Logger;

/**
 *
 * @author superfl
 * @version $Id: LoggerUtil.java, v 0.1 2017-03-17 上午10:58 superfl Exp $$
 */
public class LoggerUtil {
    /** 线程编号修饰符 */
    private static final char THREAD_RIGHT_TAG       = ']';

    /** 线程编号修饰符 */
    private static final char THREAD_LEFT_TAG        = '[';

    /**
     * 禁用构造函数
     */
    private LoggerUtil() {
        // 禁用构造函数
    }

    /**
     * 生成<font color="blue">调试</font>级别日志<br>
     * 可处理任意多个输入参数，并避免在日志级别不够时字符串拼接带来的资源浪费
     *
     * @param logger
     * @param obj
     */
    public static void debug(Logger logger, Object... obj) {
        if (logger.isDebugEnabled()) {
            logger.debug(getLogString(obj));
        }
    }

    /**
     * 生成<font color="blue">通知</font>级别日志<br>
     * 可处理任意多个输入参数，并避免在日志级别不够时字符串拼接带来的资源浪费
     *
     * @param logger
     * @param obj
     */
    public static void info(Logger logger, Object... obj) {
        if (logger.isInfoEnabled()) {
            logger.info(getLogString(obj));
        }
    }


    /**
     * 生成<font color="brown">警告</font>级别日志<br>
     * 可处理任意多个输入参数，并避免在日志级别不够时字符串拼接带来的资源浪费
     *
     * @param logger
     * @param obj
     */
    public static void warn(Logger logger, Object... obj) {
        if (logger.isWarnEnabled()) {
            logger.warn(getLogString(obj));
        }
    }

    /**
     * 生成<font color="brown">警告级别日志
     * 可处理任意多个输入参数，并避免在日志级别不够时字符串拼接带来的资源浪费
     * @param logger 日志对象
     * @param obj 输出对象
     * @param t 异常对象
     */
    public static void error(Logger logger, Throwable t, Object... obj) {
        if (logger.isErrorEnabled()) {
            logger.error(getLogString(obj), t);
        }
    }

    /**
     * 生成输出到日志的字符串
     *
     * @param obj 任意个要输出到日志的参数
     * @return
     */
    public static String getLogString(Object... obj) {
        StringBuilder log = new StringBuilder();
        log.append(THREAD_LEFT_TAG).append(Thread.currentThread().getId())
                .append(THREAD_RIGHT_TAG);
        for (Object o : obj) {
            log.append(o);
        }
        return log.toString();
    }

}