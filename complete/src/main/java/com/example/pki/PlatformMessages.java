package com.example.pki;

import java.util.Locale;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 国际化工具类，用于获取平台的国际化信息。
 * </p>
 * 
 * @author Jove
 */
public class PlatformMessages {

	private static final Logger logger = LoggerFactory.getLogger(PlatformMessages.class);

	private static final String BASE_NAME = "cn.com.jit.platform.base.i18n.res.trans";

	private static ResourceBundle RESOURCE_BUNDLE;
	static {
		// 加载国际化资源
		load(Locale.getDefault());
	}

	/**
	 * <p>
	 * 获取指定的Key对应的国际化和参数化后的信息。
	 * </p>
	 * 
	 * @param key
	 *            指定用于查找国际化信息的Key值。
	 * @return <ul>
	 *         <li>当参数Key和参数args同时传入时，返回指定的Key对应的国际化和参数化信息</li>
	 *         <li>当只传入Key时，只返回对应的国际化信息</li>
	 *         <li>当参数Key为null或获取对应的国际化信息失败时，原样返回参数Key的值</li>
	 *         <li>当参数args值中出现null时，将被替换为字符串形式的"null"</li>
	 *         </ul>
	 */
	public static String getString(final String key) {
		// 先取国际化资源
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (Throwable t) {
			// 出错后记录日志，原样返回Key值
			if (logger.isErrorEnabled()) {
				String iString = "Invalid Key: " + key;
				iString += " (locale=" + RESOURCE_BUNDLE.getLocale() + ").";
				logger.error(iString, t);
			}
		}
		return key;
	}

	/**
	 * <p>
	 * 加载国际化资源。
	 * </p>
	 * 
	 * @param targetLocale
	 *            指定要加载的语言环境，不指定使用默认的。
	 */
	public static void load(Locale targetLocale) {
		Locale locale = targetLocale;
		if (locale == null) {
			locale = Locale.getDefault();
		}
		RESOURCE_BUNDLE = ResourceBundle.getBundle(BASE_NAME, locale);
	}
}
