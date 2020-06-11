package cn.wyf.httptest.util;

import android.util.Base64;
import android.util.Log;

import java.io.UnsupportedEncodingException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * 3des算法
 */
public class DES3Util {
    private static final String TAG = "DES3Util";
    private static final String CHARSET = "UTF-8";
    private static final String ALGORITHM = "DESede";

    private static byte[] encryptMode(byte[] src, byte[] key) {
        byte[] by = null;
        try {
            SecretKey deskey = new SecretKeySpec(key, ALGORITHM);
            Cipher ci = Cipher.getInstance(ALGORITHM);
            ci.init(1, deskey);
            by = ci.doFinal(src);
        } catch (Exception e) {
            Log.d(TAG, "3DES加密 " + e.getMessage());
        }
        return by;
    }

    private static byte[] decryptMode(byte[] src, byte[] key) {
        byte[] by = null;
        try {
            SecretKey deskey = new SecretKeySpec(key, ALGORITHM);
            Cipher ci = Cipher.getInstance(ALGORITHM);
            ci.init(2, deskey);
            by = ci.doFinal(src);
        } catch (Exception e) {
            Log.d(TAG, "3DES解密 " + e.getMessage());
        }
        return by;
    }

    /**
     * 密钥补足位数
     * @param keyBase
     * @return
     */
    public static byte[] build3DesKey(String keyBase) {
        byte[] key = new byte[24];
        try {
            byte[] temp = keyBase.getBytes(CHARSET);

            if (key.length > temp.length) {
                System.arraycopy(temp, 0, key, 0, temp.length);
            } else {
                System.arraycopy(temp, 0, key, 0, key.length);
            }
        } catch (Exception e) {
            key = null;
            Log.d(TAG, "3DES获取密钥 " + e.getMessage());
        }
        return key;
    }

    /**
     * 加密
     * @param str
     * @param key
     * @return
     */
    public static String encrypt(String str, byte[] key) {
        String result = "";
        try {
            result = Base64.encodeToString(encryptMode(str.getBytes(CHARSET), key), Base64.NO_WRAP);
        } catch (UnsupportedEncodingException e) {
            Log.d(TAG, "3DES加密转码 " + e.getMessage());
        }
        return result;
    }

    /**
     * 解密
     * @param str
     * @param key
     * @return
     */
    public static String decrypt(String str, byte[] key) {
        String result = "";
        try {
            result = new String(decryptMode(Base64.decode(str, Base64.NO_WRAP), key), CHARSET);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            Log.d(TAG, "3DES解密转码" + e);
        }
        return result;
    }
}
