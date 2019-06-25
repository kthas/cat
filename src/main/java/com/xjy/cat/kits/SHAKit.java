package com.xjy.cat.kits;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * SHA-256加密
 * @author 12264
 **/
public class SHAKit {
    public String SHA(String strText){
        // 是否是有效字符串
        if (strText != null && strText.length() > 0) {
            try {
                // SHA 加密开始
                // 创建加密对象 并傳入加密類型
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                // 传入要加密的字符串
                messageDigest.update(strText.getBytes("UTF-8"));
                // 得到 byte 類型结果
                byte passwdByte[] =  messageDigest.digest();
                //将byte数组转为加密后的字符串
                String encryptPassword = byte2Hex(passwdByte);
                return encryptPassword;
            } catch (NoSuchAlgorithmException e) {
                return null;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return null;
            }
        }else {
            return null;
        }
    }

    /**
     * 将byte转为16进制
     *
     * @author CaoLu.
     */
    private static String byte2Hex(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer();
        String temp = null;
        for (int i = 0; i < bytes.length; i++) {
            temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length() == 1) {
                // 1得到一位的进行补0操作
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }
    public static void main(String[] args) {
        SHAKit sha = new SHAKit();
        System.out.println(sha.SHA("xjy"));
    }
}
