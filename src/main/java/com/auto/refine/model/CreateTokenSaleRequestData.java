package com.auto.refine.model;

import com.auto.refine.utils.Md5Encryption;
import com.auto.refine.utils.RsaEncrytion;
import net.sf.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.TreeMap;

public class CreateTokenSaleRequestData {
    String transType;
    String accessType;
    String version;
    String charset;
    String signType;
    String merchantId;
    String transId;
    String payMethod;
    String transTimeout;
    String carrierId;
    String transAmt;
    String currency;
    String settleCurrency;
    String goodsName;
    String goodsInfo;
    String notifyUrl;
    String redirectUrl;
    String reqReserved;
    String reserved;
    String registerUserId;
    String dcc;
    //payMethodInfo
    String cardNo;
    String expirationMonth;
    String expirationYear;
    String cvv;
    String firstName;
    String lastName;
    String billingDesc;
    String pkey;

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

    public String getAccessType() {
        return accessType;
    }

    public void setAccessType(String accessType) {
        this.accessType = accessType;
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


    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public String getTransTimeout() {
        return transTimeout;
    }

    public void setTransTimeout(String transTimeout) {
        this.transTimeout = transTimeout;
    }

    public String getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(String carrierId) {
        this.carrierId = carrierId;
    }

    public String getTransAmt() {
        return transAmt;
    }

    public void setTransAmt(String transAmt) {
        this.transAmt = transAmt;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSettleCurrency() {
        return settleCurrency;
    }

    public void setSettleCurrency(String settleCurrency) {
        this.settleCurrency = settleCurrency;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsInfo() {
        return goodsInfo;
    }

    public void setGoodsInfo(String goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
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

    public String getDcc() {
        return dcc;
    }

    public void setDcc(String dcc) {
        this.dcc = dcc;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(String expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public String getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(String expirationYear) {
        this.expirationYear = expirationYear;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBillingDesc() {
        return billingDesc;
    }

    public void setBillingDesc(String billingDesc) {
        this.billingDesc = billingDesc;
    }

    public String getPkey() {
        return pkey;
    }

    public void setPkey(String pkey) {
        this.pkey = pkey;
    }

    public String createTokenSaleRequestStr() throws UnsupportedEncodingException {
        TreeMap payMethodInfo=new TreeMap();
        payMethodInfo.put("cardNo",cardNo);
        payMethodInfo.put("expirationMonth",expirationMonth);
        payMethodInfo.put("expirationYear",expirationYear);
        payMethodInfo.put("cvv",cvv);
        payMethodInfo.put("firstName",firstName);
        payMethodInfo.put("lastName",lastName);
        payMethodInfo.put("billingDesc",billingDesc);

        JSONObject payMethodInfoJson = JSONObject.fromObject(payMethodInfo);



        TreeMap requestMap=new TreeMap<>();
        requestMap.put("transType",transType);
        requestMap.put("accessType",accessType);
        requestMap.put("version",version);
        requestMap.put("charset",charset);
        requestMap.put("signType",signType);
        requestMap.put("merchantId",merchantId);
        requestMap.put("transId",transId);
        requestMap.put("registerUserId",registerUserId);
        requestMap.put("payMethod",payMethod);
        requestMap.put("payMethodInfo",payMethodInfoJson);
        requestMap.put("settleCurrency",settleCurrency);
        requestMap.put("transTimeout",transTimeout);
        requestMap.put("carrierId",carrierId);
        requestMap.put("transAmt",transAmt);
        requestMap.put("currency",currency);
        //requestMap.put("subAccountData",subAccountData);
        requestMap.put("goodsName",goodsName);
        requestMap.put("goodsInfo",goodsInfo);
        requestMap.put("notifyUrl",notifyUrl);
        requestMap.put("redirectUrl",redirectUrl);
        requestMap.put("reqReserved",reqReserved);
        requestMap.put("reserved",reserved);
        requestMap.put("dcc",dcc);


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
