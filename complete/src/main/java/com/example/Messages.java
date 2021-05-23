package com.example;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.ResourceBundle.Control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 鍥介檯鍖栧伐鍏风被锛岀敤浜庤幏鍙栧钩鍙扮殑鍥介檯鍖栦俊鎭��
 * </p>
 * 
 * @author Jove
 */
public class Messages {

    private static final Logger logger = LoggerFactory.getLogger(Messages.class);

    private static final String BASE_NAME = "cn.com.jit.platform.base.i18n.res.messages";

    private static ResourceBundle RESOURCE_BUNDLE;
    static {
        // 鍔犺浇鍥介檯鍖栬祫婧�
        load(Locale.getDefault());
    }

    /**
     * <p>
     * 鑾峰彇鎸囧畾鐨凨ey瀵瑰簲鐨勫浗闄呭寲鍜屽弬鏁板寲鍚庣殑淇℃伅銆�
     * </p>
     * <p>
     * 鍙傝�冪ず渚嬶細
     * <ul>
     * <li>Messages.getString("F0BF0001");</li>
     * <li>Messages.getString("F0BF0001", "1");</li>
     * <li>Messages.getString("F0BF0001", "1", 2, true);</li>
     * <li>Messages.getString("F0BF0001", new Object[] { "1", 2, true });</li>
     * </ul>
     * </p>
     * 
     * @param key
     *            鎸囧畾鐢ㄤ簬鏌ユ壘鍥介檯鍖栦俊鎭殑Key鍊笺��
     * @param args
     *            鎸囧畾鐨凨ey瀵瑰簲鐨勫浗闄呭寲鍜屽弬鏁板寲淇℃伅銆�
     * @return
     *         <ul>
     *         <li>褰撳弬鏁癒ey鍜屽弬鏁癮rgs鍚屾椂浼犲叆鏃讹紝杩斿洖鎸囧畾鐨凨ey瀵瑰簲鐨勫浗闄呭寲鍜屽弬鏁板寲淇℃伅</li>
     *         <li>褰撳彧浼犲叆Key鏃讹紝鍙繑鍥炲搴旂殑鍥介檯鍖栦俊鎭�</li>
     *         <li>褰撳弬鏁癒ey涓簄ull鎴栬幏鍙栧搴旂殑鍥介檯鍖栦俊鎭け璐ユ椂锛屽師鏍疯繑鍥炲弬鏁癒ey鐨勫��</li>
     *         <li>褰撳弬鏁癮rgs鍊间腑鍑虹幇null鏃讹紝灏嗚鏇挎崲涓哄瓧绗︿覆褰㈠紡鐨�"null"</li>
     *         </ul>
     */
    public static String getString(final String key, final Object... args) {
        // 鍏堝彇鍥介檯鍖栬祫婧�
        if (logger.isDebugEnabled()) {
            logger.debug("Get the I18N value for key: " + key);
        }
        String value;
        try {
            value = RESOURCE_BUNDLE.getString(key);
        } catch (Throwable t) {
            // 鍑洪敊鍚庤褰曟棩蹇楋紝鍘熸牱杩斿洖Key鍊�
            if (logger.isErrorEnabled()) {
                String iString = "Invalid Key: " + key;
                iString += " (locale=" + RESOURCE_BUNDLE.getLocale() + ").";
                logger.error(iString, t);
            }
            return key;
        }

        // 濡傛灉娌℃湁鍙傛暟锛屽垯鐩存帴杩斿洖鍥介檯鍖栦俊鎭�
        if ((args == null) || (args.length == 0)) {
            logger.debug("No arguments just return I18N information.");
            return value;
        }

        // 濡傛灉鏈夊弬鏁帮紝鍒欐鏌ュ弬鏁板�兼槸鍚︽湁鏄痭ull鐨勶紝鐒跺悗鍐嶅仛鍙傛暟鍖栧鐞�
        logger.debug("Has arguments do arguments format.");
        try {
            Object[] nonNullArgs = args;
            for (int i = 0; i < args.length; i++) {
                if (args[i] == null) {
                    logger.debug("Some arguments have value: [null], use \"null\" instead.");
                    // 濡傛灉鍙傛暟鍊兼湁涓簄ull鐨勶紝鍏堝皢鍙傛暟鎷疯礉涓�浠斤紙閬垮厤褰卞搷璋冪敤鑰呭鍙傛暟鐨勫悗缁娇鐢級
                    if (nonNullArgs == args) {
                        nonNullArgs = (Object[]) args.clone();
                    }
                    // 灏嗗�艰缃负瀛楃涓插舰寮忕殑null锛岄槻姝㈢▼搴忔姤閿�
                    nonNullArgs[i] = "null";
                }
            }
            return MessageFormat.format(value, nonNullArgs);
        } catch (Throwable t) {
            // 鍑洪敊鍚庤褰曟棩蹇楋紝鍘熸牱杩斿洖鍥介檯鍖栦俊鎭�
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
     * 閲嶆柊鍔犺浇鍥介檯鍖栬祫婧愩��
     * </p>
     * 
     * @param targetLocale
     *            鎸囧畾瑕佸姞杞界殑璇█鐜锛屼笉鎸囧畾浣跨敤榛樿鐨勩��
     */
    public static void reload(Locale targetLocale) {
        ResourceBundle.clearCache();
        load(targetLocale);
    }

    /**
     * <p>
     * 鍔犺浇鍥介檯鍖栬祫婧愩��
     * </p>
     * 
     * @param targetLocale
     *            鎸囧畾瑕佸姞杞界殑璇█鐜锛屼笉鎸囧畾浣跨敤榛樿鐨勩��
     */
    public static void load(Locale targetLocale) {
        Locale locale = targetLocale;
        if (locale == null) {
            locale = Locale.getDefault();
        }
        Control control = Control.getControl(new ArrayList<String>());
        RESOURCE_BUNDLE = ResourceBundle.getBundle(BASE_NAME, locale, control);
    }

}
