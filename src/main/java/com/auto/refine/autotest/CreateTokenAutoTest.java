package com.auto.refine.autotest;

import com.auto.refine.input.ParamsInput;
import com.auto.refine.input.PublicParamsInput;
import com.auto.refine.model.CaptureRequestData;
import com.auto.refine.model.CreateTokenReqData;
import com.auto.refine.model.SaleRequestData;
import com.auto.refine.utils.PostUtils;
import net.sf.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.TreeMap;

public class CreateTokenAutoTest {

    PublicParamsInput publicParamsInput=new PublicParamsInput();
    TreeMap publicParams=publicParamsInput.publicParams();
    String url=publicParams.get("url").toString();
    String merchantId=publicParams.get("merchantId").toString();
    String pkey=publicParams.get("pkey").toString();


    @Test(priority = 1)
    public void createTokenTest(){
        String timeStr=new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
        Random random=new Random();
        CreateTokenReqData requestData= new CreateTokenReqData();
        String requestStr = null;
        PostUtils postUtils=new PostUtils();
        String postResponseResult=null;
        String radomStr="";
        for(int i=0;i<4;i++){
            radomStr+=random.nextInt(10);

        }


        ParamsInput paramsInput=new ParamsInput();
        TreeMap<String,String> param=paramsInput.Param("data/createTokenParams.xlsx");
        requestData.setTransType(param.get("transType"));
        requestData.setAccessType(param.get("accessType"));
        requestData.setVersion(param.get("version"));
        requestData.setCharset(param.get("charset"));
        requestData.setSignType(param.get("signType"));
        requestData.setMerchantId(merchantId);
        requestData.setTransId(timeStr+radomStr);
        requestData.setPayMethod(param.get("payMethod"));
        requestData.setTransTimeout(param.get("transTimeout"));
        requestData.setCarrierId(param.get("carrierId"));
        requestData.setRegisterUserId(timeStr+radomStr);
        requestData.setNotifyUrl(param.get("notifyUrl"));
        requestData.setRedirectUrl(param.get("redirectUrl"));
        requestData.setReqReserved(param.get("reqReserved"));
        requestData.setReserved(param.get("reserved"));
        requestData.setPkey(pkey);

        requestData.setCardNo(param.get("cardNo"));
        requestData.setExpirationMonth(param.get("expirationMonth"));
        requestData.setExpirationYear(param.get("expirationYear"));
        requestData.setCvv(param.get("cvv"));
        requestData.setFirstName(param.get("firstName"));
        requestData.setLastName(param.get("lastName"));
        requestData.setBillingDesc(param.get("billingDesc"));

        try {
            requestStr=requestData.createTokenRequestStr();
            postResponseResult= postUtils.postMethod(url,requestStr);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        JSONObject jsonObject=JSONObject.fromObject(postResponseResult);
        String respCode=jsonObject.get("respCode").toString();
        String respMsg=jsonObject.get("respMsg").toString();
        String status=jsonObject.get("status").toString();
        String transType=jsonObject.get("transType").toString();
        Assert.assertEquals("0000",respCode);
        Assert.assertEquals("Approved or completed successfully",respMsg);
        Assert.assertEquals("success",status);
        Assert.assertEquals("create_token",transType);

    }
}
