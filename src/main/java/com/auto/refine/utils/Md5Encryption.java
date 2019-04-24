package com.auto.refine.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Encryption {
    //MD5加密
    public String encrypt(String inputStr, String chaset) {
        MessageDigest messageDigest = null;
        StringBuffer stringBuffe = null;
        try {
            try {
                messageDigest = MessageDigest.getInstance("MD5");
                byte[] inputByte;
                inputByte = inputStr.getBytes(chaset);

                messageDigest.update(inputByte);
                byte[] bytes = messageDigest.digest();

                stringBuffe = new StringBuffer();
                for (int i = 0; i < bytes.length; i++) {
                    int j = bytes[i] & 0xFF;
                    String k = Integer.toHexString(j);
                    if (k.length() == 1) {
                        stringBuffe.append(0);

                    }
                    stringBuffe.append(k);
                }
                System.out.println("MD5加密：\t" + stringBuffe);


            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return stringBuffe.toString();
    }
}
