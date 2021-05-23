package com.example.pki;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.exception.BaseException;
import com.example.exception.ServiceException;

import cn.com.jit.ida.util.pki.PKIException;
import cn.com.jit.ida.util.pki.encoders.Base64;
import cn.com.jit.platform.pki.Flag;
import cn.com.jit.platform.pki.HandleResult;
import cn.com.jit.platform.pki.PKIToolkits;

public class PkiHelper {

    private static final Logger LOG = LoggerFactory.getLogger(PkiHelper.class);

    private static PKIToolkits toolkits = null;

//    private static BouncyCastleProvider bouncyCastleProvider;

    static {
        try {
            toolkits = PKIToolkits.getInstance();
        } catch (PKIException e) {
            e.printStackTrace();
            LOG.error("CertUtil initialize Exception " + e.getErrDesc(), "initialize");
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("CertUtil initialize Exception " + e.getMessage(), "initialize");
        }

    }

    /**
     * p7验签
     * 
     * @param signedData
     *            签名结果
     * @param flag
     *            该参数转换成二进制后，<br>
     *            第一位代表的是签名类型（0：attach, 1:detach），<br>
     *            第二位代表是否经过base64编码（0:否,1:是），如果是base64编码，原文也是base64编码，<br>
     *            第三位没有意义<br>
     * @param originalData
     *            原文
     * @param out
     *            结果输出
     * @return true：验签成功，否则代表验签失败
     */
    public static Map<String, Object> verifyP7Sign(byte[] signedData, int flag, byte[] originalData) throws ServiceException {
        
        Map<String, Object> map = new HashMap<String, Object>();
        HandleResult result_1 = new HandleResult();
        try {
            toolkits.p7Verify(signedData, flag, originalData, result_1);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        map.put("errorCode", result_1.errorCode);
        map.put("cert", result_1.cert);
        return map;
    }

    public static byte[] getMessageBody(String p1ORP7, String alg, String attachORDetach, byte[] original, byte[] signedData,
            byte[] cert) {
        byte[] originalLengthByte = ByteBuffer.allocate(4).order(ByteOrder.BIG_ENDIAN).putInt(original.length).array();
        byte[] signedDataLengthByte = ByteBuffer.allocate(4).order(ByteOrder.BIG_ENDIAN).putInt(signedData.length).array();
        byte[] certLengthByte = ByteBuffer.allocate(4).order(ByteOrder.BIG_ENDIAN).putInt(cert.length).array();
        // 起始4byte固定值：0xa7 0xae 0xac oxa8,用于确认是验签请求
        byte[] requestByte = { -89, -82, -84, -88 };
        int messageLength = original.length + signedData.length;

        byte[] messageBody = null;
        if ("p1".equals(p1ORP7)) {
            messageLength += 18;
            messageLength += cert.length;
            messageBody = new byte[messageLength];
            // 验签请求标志
            int offset = 0;
            System.arraycopy(requestByte, 0, messageBody, offset, 4);
            offset += 4;

            // p7标记
            messageBody[offset] = 1;
            offset += 1;

            // 摘要算法
            byte balg = 1;
            if ("sha1".equalsIgnoreCase(alg)) {
                balg = 1;
            } else if ("sha256".equalsIgnoreCase(alg)) {
                balg = 2;
            } else if ("sm3".equalsIgnoreCase(alg)) {
                balg = 4;
            } else if ("md5".equalsIgnoreCase(alg)) {
                balg = 4;
            }
            messageBody[offset] = balg;
            offset += 1;

            // 原文长度
            System.arraycopy(originalLengthByte, 0, messageBody, offset, 4);
            offset += 4;

            // 原文
            System.arraycopy(original, 0, messageBody, offset, original.length);
            offset += original.length;

            // 签名值长度
            System.arraycopy(signedDataLengthByte, 0, messageBody, offset, 4);
            offset += 4;

            // 签名值
            System.arraycopy(signedData, 0, messageBody, offset, signedData.length);
            offset += signedData.length;

            // 证书长度
            System.arraycopy(certLengthByte, 0, messageBody, offset, 4);
            offset += 4;

            // 证书值
            System.arraycopy(cert, 0, messageBody, offset, cert.length);
        } else {
            messageLength += 14;
            messageBody = new byte[messageLength];
            // 验签请求标志
            int offset = 0;
            System.arraycopy(requestByte, 0, messageBody, offset, 4);
            offset += 4;

            // p7标记
            messageBody[offset] = 2;
            offset += 1;

            // attach 1\detach 2
            byte ad = 1;
            if ("detach".equals(attachORDetach)) {
                ad = 2;
            }
            messageBody[offset] = ad;
            offset += 1;

            // 原文长度
            System.arraycopy(originalLengthByte, 0, messageBody, offset, 4);
            offset += 4;

            // 原文
            System.arraycopy(original, 0, messageBody, offset, original.length);
            offset += original.length;

            // 签名值长度
            System.arraycopy(signedDataLengthByte, 0, messageBody, offset, 4);
            offset += 4;

            // 签名值
            System.arraycopy(signedData, 0, messageBody, offset, signedData.length);
        }
        return messageBody;
    }

    /**
     * 解信封
     * 
     * @param envelopData
     *            信封的二进制编码，需要先解析Base64，不能直接对Base64编码取getBytes
     * @param key
     * @param cert
     * @return
     * @throws UnsupportedEncodingException
     */
    public static byte[] decryptEnvelop(byte[] envelopData, byte[] key, byte[] cert) throws UnsupportedEncodingException {
        Flag flag = new Flag(false);
        flag.setBase64(false);
        // flag.setSM2(isSMP7)
        byte[] originalMsg = Base64.decode(envelopData);

        HandleResult result = new HandleResult();
        try {
            toolkits.p7DecryptEnvelope(key, cert, flag.toFlag(), originalMsg, result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result.getResultData();
    }

    /**
     * 加密信封
     * 
     * @cert public certificate of receiver
     * @data data to be encrypt
     * @return
     */
    public static byte[] encryptEnvelop(byte[] cert, byte[] data) {
        HandleResult result = new HandleResult();
        Flag flag = new Flag(false);
        flag.setBase64(false);
        String algorithm = PKIToolkits.SYMMETRICARITHMETICTYPE_AES_128_ECB;
        try {
            toolkits.p7Envelope(cert, algorithm, null, flag.toFlag(), data, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.getResultData();
    }

    /*
     * p1签名
     * 
     * @param privateKey 私钥
     * 
     * @param digestArithmeticType 摘要算法 国密业务：SM3 RSA业务：MD5、SHA1、SHA256
     * 
     * @param flag 该参数转换成二进制后，<br> 第一位没有意义，<br>
     * 第二位代表是否经过base64编码（0:否,1:是），如果是base64编码，原文与签名结果也是base64编码<br>
     * 第三位代表业务类型（0：RSA，1：GM）,<br>
     * 
     * @param out 结果输出
     * 
     * @param originalData 原文
     */
    public static byte[] p1sign(byte[] privateKey, String digestArithmeticType, byte[] originalData) throws BaseException {
        HandleResult result = new HandleResult();
        Flag flag = new Flag(false);
        flag.setBase64(false);
        try {
            toolkits.p1Sign(privateKey, digestArithmeticType, flag.toFlag(), originalData, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result.errorCode != 0) {
            throw new BaseException(String.valueOf(result.errorCode), new String(result.errorDescription));
        }
        return result.getResultData();
    }

    /***
     * 根据证书私钥进行进行P7签名，返回一个二位数组内容
     * 
     * @return
     * @throws CertificateEncodingException
     */
    public static HandleResult getPFXP7Sign(Map<String, Object> map, String queryName) throws CertificateEncodingException {
        HandleResult result = new HandleResult();
        byte[] plainData = queryName.getBytes();
        Flag fl = new Flag(false);
        fl.setDetach(false);
        fl.setBase64(false);
        fl.setSM2(false);
        int flagValue = fl.toFlag();
        String digestAlgorithm = "SHA256";
        byte[] prvkey = ((PrivateKey) map.get("privatekey")).getEncoded();
        byte[] cert1 = ((Certificate) map.get("cert")).getEncoded();
        try {
            toolkits.p7Sign(prvkey, cert1, digestAlgorithm, flagValue, plainData, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
