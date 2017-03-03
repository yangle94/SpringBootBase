package cn.ylapl.util.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * 日志封装
 * Static methods for validation and emiting log messages
 */
public class LogUtil implements Serializable{
	private static final Logger logger = LoggerFactory.getLogger(LogUtil.class);

	public static void debug(Object obj,String str) {
		logger.debug("************ " + obj.getClass().getName()
				+ Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "**************" + str);
	}

	public static void info(Object obj,String str) {
		logger.info("************ " + obj.getClass().getName()
				+ Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "**************" + str);
	}

	public static void error(Object obj,String str) {
		logger.error("************ " + obj.getClass().getName()
				+ Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "**************" + str);
	}

	public static void warn(Object obj,String str) {
		logger.warn("************ " + obj.getClass().getName()
				+ Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "**************" + str);
	}
}
