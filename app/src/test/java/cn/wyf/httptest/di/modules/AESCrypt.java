package cn.wyf.httptest.di.modules;


import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * AES加解密工具类
 */
public class AESCrypt {

    private static final String TAG = "AESCrypt";

    //加解密模式
    private static final String AES_ECB_MODE = "AES/ECB/PKCS5Padding";
    private static final String AES_CBC_MODE = "AES/CBC/PKCS5Padding";
    private static final String CHARSET = "UTF-8";

    private static long hex_mode = 1;
    private static long base64_mode = 2;

    //偏移量
    private static final String ivDate = "0000000000000000";

    /**
     * 密钥转换，可根据密钥具体的加密类型处理转换
     *
     * @param password 密钥
     * @return
     * @throws UnsupportedEncodingException
     */
    private static SecretKeySpec generateKey(final String password) throws UnsupportedEncodingException {
        byte[] bytes = password.getBytes(CHARSET);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "AES");
        return secretKeySpec;
    }

    /**
     * 加密数据 CBC模式
     *
     * @param password 密钥
     * @param message  要加密的数据
     * @return 做过BASE64转换的数据
     * @throws GeneralSecurityException
     */
    public static String encrypt_CBC_MODE(final String password, String message)
            throws GeneralSecurityException {
        return encrypt(base64_mode, AES_CBC_MODE, password, message);
    }

    /**
     * 加密数据 CBC模式
     *
     * @param password 密钥
     * @param message  要加密的数据
     * @return 做过hex转换的数据
     * @throws GeneralSecurityException
     */
    public static String encrypt_hex_CBC_MODE(final String password, String message)
            throws GeneralSecurityException {
        return encrypt(hex_mode, AES_CBC_MODE, password, message);
    }

    /**
     * 加密数据 ECB模式
     *
     * @param password 密钥
     * @param message  要加密的数据
     * @return 做过BASE64转换的数据
     * @throws GeneralSecurityException
     */
    public static String encrypt_ECB_MODE(final String password, String message)
            throws GeneralSecurityException {
        return encrypt(base64_mode, AES_ECB_MODE, password, message);
    }

    /**
     * 加密数据 ECB模式
     *
     * @param password 密钥
     * @param message  要加密的数据
     * @return 做过hex转换的数据
     * @throws GeneralSecurityException
     */
    public static String encrypt_hex_ECB_MODE(final String password, String message)
            throws GeneralSecurityException {
        return encrypt(hex_mode, AES_ECB_MODE, password, message);
    }

    /**
     * 加密数据
     *
     * @param password 密钥
     * @param message  要加密的数据
     * @return 根据类型转换
     * @throws GeneralSecurityException
     */
    private static String encrypt(long retMode, String mode, final String password, String message)
            throws GeneralSecurityException {
        try {
            final SecretKeySpec key = generateKey(password);
            byte[] cipherText = encrypt(mode, key, ivDate.getBytes(), message.getBytes(CHARSET));
            String encoded = "";
            if (retMode == base64_mode) {
                //NO_WRAP is important as was getting \n at the end
                encoded = Base64.getEncoder().encodeToString(cipherText);
//            String encoded = Base64.encodeToString(cipherText, Base64.NO_WRAP);
            }
            if (retMode == hex_mode) {
                //NO_WRAP is important as was getting \n at the end
                encoded = ByteUtils.byteArray2HexString(cipherText);
//            String encoded = Base64.encodeToString(cipherText, Base64.NO_WRAP);
            }
            return encoded;
        } catch (UnsupportedEncodingException e) {
            throw new GeneralSecurityException(e);
        }
    }


    private static byte[] encrypt(String mode, SecretKeySpec key, byte[] iv, byte[] message)
            throws GeneralSecurityException {
        return AES(Cipher.ENCRYPT_MODE, mode, key, iv, message);
    }


    /**
     * 解密数据 CBC模式
     *
     * @param password                密钥
     * @param base64EncodedCipherText 做过BASE64加密的加密数据
     * @return 明文数据
     * @throws GeneralSecurityException
     */
    public static String decrypt_CBC_MODE(final String password, String base64EncodedCipherText)
            throws GeneralSecurityException {
        return decrypt(base64_mode, AES_CBC_MODE, password, base64EncodedCipherText);
    }

    /**
     * 解密数据 CBC模式
     *
     * @param password                密钥
     * @param base64EncodedCipherText hex转换的加密数据
     * @return 明文数据
     * @throws GeneralSecurityException
     */
    public static String decrypt_hex_CBC_MODE(final String password, String base64EncodedCipherText)
            throws GeneralSecurityException {
        return decrypt(hex_mode, AES_CBC_MODE, password, base64EncodedCipherText);
    }

    /**
     * 解密数据 ECB模式
     *
     * @param password                密钥
     * @param base64EncodedCipherText 做过BASE64加密的加密数据
     * @return 明文数据
     * @throws GeneralSecurityException
     */
    public static String decrypt_ECB_MODE(final String password, String base64EncodedCipherText)
            throws GeneralSecurityException {
        return decrypt(base64_mode, AES_ECB_MODE, password, base64EncodedCipherText);
    }

    /**
     * 解密数据 ECB模式
     *
     * @param password                密钥
     * @param base64EncodedCipherText hex转换的加密数据
     * @return 明文数据
     * @throws GeneralSecurityException
     */
    public static String decrypt_hex_ECB_MODE(final String password, String base64EncodedCipherText)
            throws GeneralSecurityException {
        return decrypt(hex_mode, AES_ECB_MODE, password, base64EncodedCipherText);
    }

    /**
     * 解密数据
     *
     * @param mode                    模式
     * @param password                密钥
     * @param base64EncodedCipherText 加密的数据
     * @return 明文数据
     * @throws GeneralSecurityException
     */
    private static String decrypt(long retMode, String mode, final String password, String base64EncodedCipherText)
            throws GeneralSecurityException {

        try {
            final SecretKeySpec key = generateKey(password);
            byte[] decodedCipherText = null;
            if (retMode == base64_mode){
                decodedCipherText = Base64.getDecoder().decode(base64EncodedCipherText);
//            byte[] decodedCipherText = Base64.decode(base64EncodedCipherText, Base64.NO_WRAP);
            }
            if (retMode == hex_mode){
                decodedCipherText = ByteUtils.hexString2ByteArray(base64EncodedCipherText);
//            byte[] decodedCipherText = Base64.decode(base64EncodedCipherText, Base64.NO_WRAP);
            }

            if (decodedCipherText == null){
                return null;
            }
            byte[] decryptedBytes = decrypt(key, mode, ivDate.getBytes(), decodedCipherText);

            String message = new String(decryptedBytes, CHARSET);
            return message;
        } catch (UnsupportedEncodingException e) {
            throw new GeneralSecurityException(e);
        }
    }

    private static byte[] decrypt(SecretKeySpec key, String mode, byte[] iv, byte[] decodedCipherText)
            throws GeneralSecurityException {
        return AES(Cipher.DECRYPT_MODE, mode, key, iv, decodedCipherText);
    }

    private static byte[] AES(int crypt_mode, String mode, final SecretKeySpec key, final byte[] iv, final byte[] decodedCipherText) throws GeneralSecurityException {
        final Cipher cipher = Cipher.getInstance(mode);
        if (mode.equals(AES_ECB_MODE)) {//ECB模式没有偏移量
            cipher.init(crypt_mode, key);
        } else if (mode.equals(AES_CBC_MODE)) {
            IvParameterSpec ivSpec = new IvParameterSpec(iv);
            cipher.init(crypt_mode, key, ivSpec);
        }
        byte[] decryptedBytes = cipher.doFinal(decodedCipherText);
        return decryptedBytes;
    }
}