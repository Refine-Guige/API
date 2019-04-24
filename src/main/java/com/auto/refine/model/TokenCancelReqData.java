package com.auto.refine.model;

import com.auto.refine.utils.Md5Encryption;
import com.auto.refine.utils.RsaEncrytion;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.TreeMap;

public class TokenCancelReqData {
    String transType;
    String version;
    String charset;
    String signType;
    String merchantId;
    String transId;
    String notifyUrl;
    String reqReserved;
    String reserved;
    String token;
    String registerUserId;
    String pkey;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRegisterUserId() {
        return registerUserId;
    }

    public void setRegisterUserId(String registerUserId) {
        this.registerUserId = registerUserId;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
    }

    public String getReqReserved() {
        return reqReserved;
    }

    public void setReqReserved(String reqReserved) {
        this.reqReserved = reqReserved;
    }

    public String getReserved() {
        return reserved;
    }

    public void setReserved(String reserved) {
        this.reserved = reserved;
    }

    public String getPkey() {
        return pkey;
    }

    public void setPkey(String pkey) {
        this.pkey = pkey;
    }

    public String tokenCancelRequestStr() throws UnsupportedEncodingException {


        TreeMap requestMap=new TreeMap<>();
        requestMap.put("transType",transType);
        requestMap.put("version",version);
        requestMap.put("charset",charset);
        requestMap.put("signType",signType);
        requestMap.put("merchantId",merchantId);
        requestMap.put("transId",transId);
        //requestMap.put("subAccountData",subAccountData);
        requestMap.put("token",token);
        requestMap.put("registerUserId",registerUserId);
        requestMap.put("notifyUrl",notifyUrl);
        requestMap.put("reqReserved",reqReserved);
        requestMap.put("reserved",reserved);


        StringBuffer requestStrBuff=new StringBuffer();
        Iterator iterator=  requestMap.keySet().iterator();
        while(iterator.hasNext()){
            String key= (String) iterator.next();
            Object value=requestMap.get(key);
            System.out.println(key+"\t"+value);
            requestStrBuff.append(key);
            requestStrBuff.append("=");
            requestStrBuff.append(value);
            requestStrBuff.append("&");
        }
        String requestStrWithoutSign=requestStrBuff.toString()+"pkey="+pkey;
        System.out.println("requestStrBuff:\t"+requestStrBuff);
        System.out.println("requestStrWithoutSign:\t"+requestStrWithoutSign);
        String sign="";
        if(signType.equals("MD5")) {
            Md5Encryption md5Encryption = new Md5Encryption();
            sign= md5Encryption.encrypt(requestStrWithoutSign.toString(), "UTF-8");
        }else if(signType.equals("RSA")){
            RsaEncrytion rsaEncrytion=new RsaEncrytion();
            sign= rsaEncrytion.encrytion(requestStrWithoutSign.toString(),pkey,"UTF-8");
        }

        String requestStr=requestStrBuff.append("sign="+sign).toString();
        System.out.println("requestStr:\t"+requestStr);
        return requestStr;
    }


}
