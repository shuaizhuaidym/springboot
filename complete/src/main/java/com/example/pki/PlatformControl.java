package com.example.pki;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.ResourceBundle.Control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 国际化控制类，用于控制平台的国际化资源加载行为。
 * </p>
 * <p>
 * 该类用于使JDK的ResourceBundle工厂方法在加载国际化资源时从平台指定的位置加载所有国际化资源，
 * 并返回平台自己的国际化ResourceBundle对象。
 * </p>
 * 
 * @author Jove
 */
public class PlatformControl extends Control {

	private static final Logger logger = LoggerFactory.getLogger(PlatformControl.class);

	private static final String I18N_SUFFIX = "properties";

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.ResourceBundle.Control#getFormats(java.lang.String)
	 */
	@Override
	public List<String> getFormats(String baseName) {
		// 平台固定使用Properties作为国际化资源文件
		return Control.FORMAT_PROPERTIES;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.ResourceBundle.Control#newBundle(java.lang.String,
	 * java.util.Locale, java.lang.String, java.lang.ClassLoader, boolean)
	 */
	@Override
	public ResourceBundle newBundle(String baseName, Locale locale,
			String format, ClassLoader loader, boolean reload)
			throws IllegalAccessException, InstantiationException, IOException {
		// 最终返回的ResourceBundle对象
		PlatformBundle bundle = new PlatformBundle();

		// 搜索资源包下所有国际化资源文件
		Enumeration<URL> i18nList;
		try {
			if (logger.isDebugEnabled()) {
				logger.debug("Finding I18N resources with base name: ["
						+ baseName + "] and locale: [" + locale + "]");
			}
			i18nList = findResources(baseName, loader, locale);
		} catch (Throwable t) {
			// 出错时记录调试信息
			if (logger.isErrorEnabled()) {
				logger.error(
						"Find I18N resources with base name: ["
								+ baseName
								+ "] and locale: ["
								+ locale
								+ "] failed, an empty resource bundle object will be return.",
						t);
			}
			return bundle;
		}
		if (i18nList == null) {
			// 如果没有找到则返回空的Bundle对象
			logger.debug("No I18N resources has been found, an empty resource bundle object will be return");
			return bundle;
		}
		// 如果找到了则依次加载到Bundle对象中，再返回
		while (i18nList.hasMoreElements()) {
			URL url = i18nList.nextElement();
			try {
				// 获取资源文件的流程操作对象
				logger.debug("Get the I/O stream of one I18N resource: "
						+ url.getFile() + "].");
				InputStream stream = getResourceAsStream(url);
				// 将资源文件中的国际化资源加载到Bundle对象中
				logger.debug("Put the content of one I18N resource into the resource bundle object.");
				bundle.append(stream);
			} catch (Throwable t) {
				// 出错时记录调试信息
				if (logger.isErrorEnabled()) {
					logger.error(
							"Load I18N file: ["
									+ url.getFile()
									+ "] failed, an empty resource bundle object will be return.",
							t);
				}
			}
		}

		return bundle;
	}

	/**
	 * <p>
	 * 使用指定的类加载器加指定名称的基于指定语言环境的国际化资源文件的位置。
	 * </p>
	 * 
	 * @param baseName
	 *            指定的国际化资源名称。
	 * @param classLoader
	 *            指定的类加载器。
	 * @param locale
	 *            指定的语言环境。
	 * @return 查找到的所有国际化资源文件的位置。
	 * @throws IOException
	 *             查找时遇到错误返回此异常。
	 */
	protected Enumeration<URL> findResources(String baseName,
			ClassLoader classLoader, Locale locale) throws IOException {
		if (logger.isDebugEnabled()) {
			logger.debug("Argument [baseName]: " + baseName);
			logger.debug("Argument [locale]: " + locale);
		}
		// 获得指定语言环境的国际化资源名称
		String bundleName = toBundleName(baseName, locale);
		if (logger.isDebugEnabled()) {
			logger.debug("Generated I18N bundle name is: " + bundleName);
		}
		// 转换为资源文件名
		bundleName = toResourceName(bundleName, I18N_SUFFIX);
		if (logger.isDebugEnabled()) {
			logger.debug("Converted resource bundle name is: " + bundleName);
		}

		// 定位所有模块国际化资源位置
		return classLoader.getResources(bundleName);
	}

	/**
	 * <p>
	 * 获得指定URL表示的资源的流。
	 * </p>
	 * 
	 * @param url
	 *            指定的资源。
	 * @return 指定资源的流。
	 * @throws PrivilegedActionException
	 */
	protected InputStream getResourceAsStream(final URL url)
			throws PrivilegedActionException {
		if (url == null) {
			logger.debug("Argument [url] should not be null.");
			return null;
		}

		// 以流的方式加载国际化资源文件
		return AccessController
				.doPrivileged(new PrivilegedExceptionAction<InputStream>() {

					public InputStream run() throws IOException {
						// 打开文件
						URLConnection connection = url.openConnection();
						// 如果出错返回null
						if (connection == null) {
							return null;
						}
						// 禁用缓存
						connection.setUseCaches(false);

						return connection.getInputStream();
					}
				});
	}

	public static void main(String[] args) {
		Control control = new PlatformControl();
		ResourceBundle rb = ResourceBundle.getBundle(
				"cn.com.jit.platform.base.i18n.res.messages", control);
		System.out.println(rb.keySet());
	}
}
