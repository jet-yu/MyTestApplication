package utils_srcurity;

import android.util.Base64;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

/**
 * Created by Administrator on 2016/2/29.
 */
public class SecurityTool {
    /**
     * RSA-得到公钥，将原始KEY字符串数据转化为 RSA PublicKey 对象
     *
     * @param key 原始KEY字符串
     *
     * @return
     *      {@link PublicKey}
     *
     * @throws Exception
     */
    public static PublicKey getRsaPublicKey(String key) throws Exception {
        byte[] keyBytes;
        keyBytes = Base64.decode(key.getBytes("UTF-8"), Base64.DEFAULT);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA", "BC");
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        return publicKey;
    }

    /**
     * RSA-得到私钥，将原始KEY字符串数据转化为 RSA PrivateKey 对象
     *
     * @param key 原始KEY字符串
     *
     * @return
     *      {@link PrivateKey}
     *
     * @throws Exception
     */
    public static PrivateKey getRsaPrivateKey(String key) throws Exception {
        byte[] keyBytes;
        keyBytes = Base64.decode(key.getBytes("UTF-8"), Base64.DEFAULT);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA", "BC");
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
        return privateKey;
    }

    /**
     * RSA-使用公钥加密
     *
     * @param content
     * @param pkString 公钥
     *
     * @return
     *      密文
     */
    public static String RSAEncryptByPublic(String content, String pkString) {
        try {
            // 实例化加解密类
            Cipher cipher = Cipher.getInstance("RSA/None/PKCS1Padding");
            //将明文转换为byte数组
            byte[] plainText = content.getBytes();
            // 加密
            cipher.init(Cipher.ENCRYPT_MODE, getRsaPublicKey(pkString));
            // 将明文转化为根据公钥加密的密文，为byte数组格式
            byte[] enBytes = cipher.doFinal(plainText);
            // 为了方便传输我们可以将byte数组转化为base64的编码
            String str = Base64.encodeToString(enBytes, Base64.DEFAULT);
            return str;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * RSA-使用私钥解密
     *
     * @param content
     * @param skString 私钥
     *
     * @return
     *      密文
     */
    public static String RSADecryptByPrivate(String content, String skString) {
        try {
            Cipher cipher = Cipher.getInstance("RSA/None/PKCS1Padding");
            cipher.init(Cipher.DECRYPT_MODE, getRsaPrivateKey(skString));
            // 先将转为base64编码的加密后的数据转化为byte数组
            byte[] enBytes = Base64.decode(content, Base64.DEFAULT);
            // 解密称为byte数组，应该为字符串数组最后转化为字符串
            byte[] deBytes = cipher.doFinal(enBytes);
            String strdecoded = new String(deBytes);
            return strdecoded;
        } catch (Exception e) {
            return null;
        }
    }
}
