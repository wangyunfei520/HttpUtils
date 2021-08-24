package cn.wyf.httptest.di.modules;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/**
 */
public class ByteUtils {

    /**
     * 获取数组的一部分
     * @param srcBytes
     * @param offset
     * @param len
     * @return
     */
    public static byte[] subByte(byte[] srcBytes, int offset, int len) {

        byte[] bytes;

        if (srcBytes == null) {
            return null;
        }

        if (len > srcBytes.length || offset + len > srcBytes.length
                || offset >= srcBytes.length) {
            return null;
        }

        if (len == -1) {
            bytes = new byte[srcBytes.length - offset];
            System.arraycopy(srcBytes, offset, bytes, 0, srcBytes.length
                    - offset);
        } else {
            bytes = new byte[len];
            System.arraycopy(srcBytes, offset, bytes, 0, len);
        }

        return bytes;

    }

    /**
     * 数组拼接
     *
     * @param bytesA
     * @param bytesB
     * @return
     */
    public static byte[] mergeBytes(byte[] bytesA, byte[] bytesB) {

        if (bytesA == null || bytesA.length == 0) {
            return bytesB;
        } else if (bytesB == null || bytesB.length == 0) {
            return bytesA;
        }

        byte[] bytes = new byte[bytesA.length + bytesB.length];

        System.arraycopy(bytesA, 0, bytes, 0, bytesA.length);
        System.arraycopy(bytesB, 0, bytes, bytesA.length, bytesB.length);

        return bytes;
    }

    /**
     * 多个数组拼接
     *
     * @param data
     * @return
     */
    public static byte[] merge(byte[]... data) {

        if (data == null) {
            return null;
        }

        byte[] bytes = null;
        for (int i = 0; i < data.length; i++) {
            bytes = mergeBytes(bytes, data[i]);
        }

        return bytes;
    }


    /**
     * byte[]比较
     * @param hex1
     * @param hex2
     * @param len
     * @return
     */
    public static int bytecmp(byte[] hex1, byte[] hex2, int len) {
        for (int i = 0; i < len; ++i) {
            if (hex1[i] != hex2[i]) {
                return 1;
            }
        }

        return 0;
    }

    /**
     * 十六进制 转换 byte[]
     *
     * @param hexStr
     * @return
     */
    public static byte[] hexString2ByteArray(String hexStr) {
        if (hexStr == null) {
            return null;
        }
        if (hexStr.length() % 2 != 0) {
            hexStr += "0";
        }
        byte[] data = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            char hc = hexStr.charAt(2 * i);
            char lc = hexStr.charAt(2 * i + 1);
            byte hb = hexChar2Byte(hc);
            byte lb = hexChar2Byte(lc);
            if (hb < 0 || lb < 0) {
                return null;
            }
            int n = hb << 4;
            data[i] = (byte) (n + lb);
        }
        return data;
    }

    /**
     * char转byte
     * @param c
     * @return
     */
    public static byte hexChar2Byte(char c) {
        if (c >= '0' && c <= '9') {
            return (byte) (c - '0');
        }
        if (c >= 'a' && c <= 'f') {
            return (byte) (c - 'a' + 10);
        }
        if (c >= 'A' && c <= 'F') {
            return (byte) (c - 'A' + 10);
        }
        return -1;
    }

    /**
     * byte[]转hex字符串
     * @param arr
     * @return
     */
    public static String byteArray2HexString(byte[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; ++i) {
            sb.append(String.format("%02x", arr[i]).toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 将字节数组按大端模式转为整数
     * @param bytes  金额字节数组
     * @return 转换结果
     */
    public static long bigEndian2Long(byte[] bytes) {
        if (bytes == null || bytes.length < 4) {
            return 0;
        }

        int length = bytes.length - 1;
        long result = 0;
        for (int i = 0; i < bytes.length; i++) {
            result |= ((long) (bytes[i] & 0xff)) << ((length - i) << 3);
        }

        return result;
    }

    /**
     * 将整数按大端模式转为4字节数组
     * @param intValue
     * @return	转换结果
     */
    public static byte[] intToBytes(int intValue) {
        byte[] bytes = new byte[4];
        for(int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) ((intValue >> ((3 - i) << 3)) & 0xFF);
        }
        return bytes;
    }

    /**
     * byte数组转InputStream
     * @param bytes
     * @return
     */
    public static InputStream toStream(byte[] bytes) {
        return new ByteArrayInputStream(bytes);
    }

    public static void dumpHex(String msg, byte[] bytes) {
        int length = bytes.length;
        msg = (msg == null) ? "" : msg;
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\n---------------------- " + msg + "(len:%d) ----------------------\n", length));
        for (int i = 0; i < bytes.length; i++) {
            if (i % 16 == 0) {
                if (i != 0) {
                    sb.append('\n');
                }
                sb.append(String.format("0x%08X    ", i));
            }
            sb.append(String.format("%02X ", bytes[i]));
        }
        sb.append("\n----------------------------------------------------------------------\n");
        //Log.d("ByteUtils", sb.toString());
    }

    public static String fromBytes(byte[] data, String charsetName) {
        try {
            return new String(data, charsetName);
        } catch (UnsupportedEncodingException var3) {
            return null;
        }
    }

    public static String fromBytes(byte[] data) {
        return fromBytes(data, "ISO-8859-1");
    }
}
