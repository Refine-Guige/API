package com.auto.refine.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;

public class RsaEncrytion {
    //RSA加密
    public String encrytion(byte[] data,String privateKey) {
        String str2 = null;
        try {
            BASE64Decoder decoder = new BASE64Decoder();//解码
            byte[] privateKeyBytes = decoder.decodeBuffer(privateKey);//对私钥进行解码
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");//key工厂
            PrivateKey key = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
            Signature signature = Signature.getInstance("SHA256withRSA");

            signature.initSign(key);//初始化
            signature.update(data);//更新
            byte[] bytes = signature.sign();//签名
            BASE64Encoder encoder = new BASE64Encoder();//编码
            str2 = encoder.encodeBuffer(bytes);
            System.out.println(str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str2;
    }

    public String encrytion(String src,String privateKey,String chaset) throws UnsupportedEncodingException {
        return  encrytion(src.getBytes(chaset),privateKey);
    }

}
