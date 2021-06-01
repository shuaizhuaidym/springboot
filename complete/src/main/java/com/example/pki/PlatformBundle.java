package com.example.pki;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 国际化资源类，负责加载和处理平台需要的国际化资源。
 * </p>
 * 
 * @author Jove
 */
public class PlatformBundle extends ResourceBundle {

	private static final Logger logger = LoggerFactory.getLogger(PlatformControl.class);

	private Map<String, Object> lookup;

	public PlatformBundle() {
		this.lookup = new HashMap<String, Object>();
	}

	/**
	 * <p>
	 * 从指定的流中读取国际化资源内容并填充到当前国际化对象中。
	 * </p>
	 * 
	 * @param stream
	 *            指定的流对象。
	 * @throws IOException
	 *             从流中读取国际化资源出错时抛出此异常。
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void append(InputStream stream) throws IOException {
		Properties properties = new Properties();
		logger.debug("Read the I18N content from the steam.");
		properties.load(stream);
		logger.debug("Put the I18N content into the resource bundle object.");
		this.lookup.putAll(new HashMap(properties));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.ResourceBundle#getKeys()
	 */
	@Override
	public Enumeration<String> getKeys() {
		ResourceBundle parent = this.parent;
		return new PlatformBundleEnumeration(this.lookup.keySet(),
				(parent != null) ? parent.getKeys() : null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.ResourceBundle#handleGetObject(java.lang.String)
	 */
	@Override
	protected Object handleGetObject(String key) {
		if (key == null) {
			throw new NullPointerException();
		}
		return this.lookup.get(key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.ResourceBundle#handleKeySet()
	 */
	protected Set<String> handleKeySet() {
		return this.lookup.keySet();
	}
}
