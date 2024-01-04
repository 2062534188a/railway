package com.railway.Utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
    /**
     * MD5加密
     *
     * @param data 需要加密的数据
     * @return 加密后的数据
     */
    public static String encrypt(String data) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");// 生成一个MD5加密计算摘要
            md.update(data.getBytes());// 计算md5函数
            return new BigInteger(1, md.digest()).toString(16);//返回16进制字符串

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * MD5 批量加密
     *
     * @param data 需要加密的数据
     * @return 加密后数据数组
     */
    public static String[] encrypt(String... data) {
        MessageDigest md = null;
        String[] MD5Arrays = new String[data.length];//生成存储加密后数据的数组
        try {
            for (int i = 0; i < data.length; i++) {
                md = MessageDigest.getInstance("MD5");// 生成一个MD5加密计算摘要
                md.update(data[i].getBytes());// 计算md5函数
                MD5Arrays[i] = new BigInteger(1, md.digest()).toString(16);//返回16进制字符串
            }
            return MD5Arrays;

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

}
