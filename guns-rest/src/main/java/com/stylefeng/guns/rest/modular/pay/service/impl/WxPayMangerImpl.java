package com.stylefeng.guns.rest.modular.pay.service.impl;

import cn.binarywang.wx.miniapp.api.WxMaService;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.bean.result.WxPayUnifiedOrderResult;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import com.github.binarywang.wxpay.util.SignUtils;
import com.stylefeng.guns.rest.config.QiNiuUploadConfig;
import com.stylefeng.guns.rest.modular.pay.service.WxPayManger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Copyright (C), 杭州未智科技有限公司
 *
 * @author: Cola
 * @date: 2019/10/17 18:33
 * @description:
 */
@Service
public class WxPayMangerImpl implements WxPayManger {

    private static final Logger logger = LoggerFactory.getLogger(WxPayService.class);

    @Autowired
    WxMaService wxMaService;

    @Autowired
    WxPayService wxPayService;

    @Override
    public void unifiedPayOrder(String orderNum, String orderName, BigDecimal orderMoney,Long userId) {

        String openId = "";
        WxPayUnifiedOrderRequest wxPayUnifiedOrderRequest = new WxPayUnifiedOrderRequest();
        wxPayUnifiedOrderRequest.setAppid(wxMaService.getWxMaConfig().getAppid());
        wxPayUnifiedOrderRequest.setOpenid(openId);
        wxPayUnifiedOrderRequest.setBody(orderName);
        wxPayUnifiedOrderRequest.setOutTradeNo(orderName);
        wxPayUnifiedOrderRequest.setTotalFee(orderMoney.multiply(new BigDecimal(100)).intValue());
        wxPayUnifiedOrderRequest.setSpbillCreateIp("10.128.5.9");
        wxPayUnifiedOrderRequest.setNotifyUrl("");
        wxPayUnifiedOrderRequest.setTradeType("JSAPI");
        wxPayUnifiedOrderRequest.setSignType("MD5");


        WxPayUnifiedOrderResult requestResult = null;
        try {
            requestResult = wxPayService.unifiedOrder(wxPayUnifiedOrderRequest);
        } catch (WxPayException e) {
            logger.error("发起微信支付请求异常，原始请求内容:",wxPayUnifiedOrderRequest.toXML());
            logger.error("发起微信支付请求异常，返回状态码:[{}],返回信息:[{}],错误代码:[{}],错误描述:[{}]",e.getReturnCode(),e.getReturnMsg(),e.getErrCode(),e.getErrCodeDes());
            logger.error("发起微信支付请求异常，异常:",e);
        }


/*
        PayOnlineWXTradeInfoDTO onlineTradeInfo = new PayOnlineWXTradeInfoDTO();

        onlineTradeInfo.setNonceStr(UUID.randomUUID().toString().replaceAll("-", ""));
        onlineTradeInfo.setPackageStr("prepay_id="+requestResult.getPrepayId());
        onlineTradeInfo.setTimeStamp(String.valueOf(System.currentTimeMillis()/1000));
        onlineTradeInfo.setSignType("MD5");

        //二次签名
        Map<String,String> params = new HashMap<>();
        params.put("timeStamp",onlineTradeInfo.getTimeStamp());
        params.put("nonceStr",onlineTradeInfo.getNonceStr());
        params.put("package",onlineTradeInfo.getPackageStr());
        params.put("signType",onlineTradeInfo.getSignType());
        params.put("appId",wxPayUnifiedOrderRequest.getAppid());

        String paySign = SignUtils.createSign(params,"MD5",wxPayService.getConfig().getMchKey(),null);

        onlineTradeInfo.setPaySign(paySign);*/
    }
}
