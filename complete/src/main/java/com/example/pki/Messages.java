package com.example.pki;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.ResourceBundle.Control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 国际化工具类，用于获取平台的国际化信息。
 * </p>
 * 
 * @author Jove
 */
public class Messages {

	private static final Logger logger = LoggerFactory.getLogger(Messages.class);

	private static final String BASE_NAME = "cn.com.jit.platform.base.i18n.res.messages";

	private static ResourceBundle RESOURCE_BUNDLE;
	static {
		// 加载国际化资源
		load(Locale.getDefault());
	}

	/**
	 * <p>
	 * 获取指定的Key对应的国际化和参数化后的信息。
	 * </p>
	 * <p>
	 * 参考示例：
	 * <ul>
	 * <li>Messages.getString("F0BF0001");</li>
	 * <li>Messages.getString("F0BF0001", "1");</li>
	 * <li>Messages.getString("F0BF0001", "1", 2, true);</li>
	 * <li>Messages.getString("F0BF0001", new Object[] { "1", 2, true });</li>
	 * </ul>
	 * </p>
	 * 
	 * @param key
	 *            指定用于查找国际化信息的Key值。
	 * @param args
	 *            指定的Key对应的国际化和参数化信息。
	 * @return <ul>
	 *         <li>当参数Key和参数args同时传入时，返回指定的Key对应的国际化和参数化信息</li>
	 *         <li>当只传入Key时，只返回对应的国际化信息</li>
	 *         <li>当参数Key为null或获取对应的国际化信息失败时，原样返回参数Key的值</li>
	 *         <li>当参数args值中出现null时，将被替换为字符串形式的"null"</li>
	 *         </ul>
	 */
	public static String getString(final String key, final Object... args) {
		// 先取国际化资源
		if (logger.isDebugEnabled()) {
			logger.debug("Get the I18N value for key: " + key);
		}
		String value;
		try {
			value = RESOURCE_BUNDLE.getString(key);
		} catch (Throwable t) {
			// 出错后记录日志，原样返回Key值
			if (logger.isErrorEnabled()) {
				String iString = "Invalid Key: " + key;
				iString += " (locale=" + RESOURCE_BUNDLE.getLocale() + ").";
				logger.error(iString, t);
			}
			return key;
		}

		// 如果没有参数，则直接返回国际化信息
		if ((args == null) || (args.length == 0)) {
			logger.debug("No arguments just return I18N information.");
			return value;
		}

		// 如果有参数，则检查参数值是否有是null的，然后再做参数化处理
		logger.debug("Has arguments do arguments format.");
		try {
			Object[] nonNullArgs = args;
			for (int i = 0; i < args.length; i++) {
				if (args[i] == null) {
					logger.debug("Some arguments have value: [null], use \"null\" instead.");
					// 如果参数值有为null的，先将参数拷贝一份（避免影响调用者对参数的后续使用）
					if (nonNullArgs == args) {
						nonNullArgs = (Object[]) args.clone();
					}
					// 将值设置为字符串形式的null，防止程序报错
					nonNullArgs[i] = "null";
				}
			}
			return MessageFormat.format(value, nonNullArgs);
		} catch (Throwable t) {
			// 出错后记录日志，原样返回国际化信息
			if (logger.isErrorEnabled()) {
				String iString = "Invalid message format: " + value + "(";
				for (int i = 0; i < args.length; i++) {
					iString += " arg[" + i + "]=" + args[i];
				}
				iString += ")";
				logger.error(iString, t);
			}
			return value;
		}
	}

	/**
	 * <p>
	 * 重新加载国际化资源。
	 * </p>
	 * 
	 * @param targetLocale
	 *            指定要加载的语言环境，不指定使用默认的。
	 */
	public static void reload(Locale targetLocale) {
		ResourceBundle.clearCache();
		load(targetLocale);
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
		Control control = new PlatformControl();
		RESOURCE_BUNDLE = ResourceBundle.getBundle(BASE_NAME, locale, control);
	}

}
