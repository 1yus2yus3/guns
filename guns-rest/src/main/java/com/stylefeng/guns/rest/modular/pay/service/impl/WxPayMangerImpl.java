package com.stylefeng.guns.rest.modular.pay.service.impl;

import cn.binarywang.wx.miniapp.api.WxMaService;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.bean.result.WxPayUnifiedOrderResult;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import com.github.binarywang.wxpay.util.SignUtils;
import com.stylefeng.guns.core.exception.GunsException;
import com.stylefeng.guns.rest.common.exception.BizExceptionEnum;
import com.stylefeng.guns.rest.modular.pay.dto.WxPayResultDTO;
import com.stylefeng.guns.rest.modular.pay.param.WxPayJSAPI;
import com.stylefeng.guns.rest.modular.pay.service.WxPayManger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    WxPayService wxPayService;

    @Override
    public WxPayResultDTO unifiedPayOrder(WxPayJSAPI wxPayJSAPI) {

        WxPayUnifiedOrderRequest wxPayUnifiedOrderRequest = new WxPayUnifiedOrderRequest();
        wxPayUnifiedOrderRequest.setAppid(wxPayService.getConfig().getAppId());
        wxPayUnifiedOrderRequest.setOpenid(wxPayJSAPI.getOpenId());
        wxPayUnifiedOrderRequest.setBody(wxPayJSAPI.getOrderDesc());
        wxPayUnifiedOrderRequest.setOutTradeNo(wxPayJSAPI.getOrderNum());
        wxPayUnifiedOrderRequest.setTotalFee(wxPayJSAPI.getOrderMoney().multiply(new BigDecimal(100)).intValue());
        wxPayUnifiedOrderRequest.setSpbillCreateIp("10.128.5.9");
        wxPayUnifiedOrderRequest.setNotifyUrl("http://www.baid.com");
        wxPayUnifiedOrderRequest.setTradeType("JSAPI");
        wxPayUnifiedOrderRequest.setSignType("MD5");

        WxPayUnifiedOrderResult requestResult = null;
        try {
            requestResult = wxPayService.unifiedOrder(wxPayUnifiedOrderRequest);
        } catch (WxPayException e) {
            logger.error("发起微信支付请求异常，原始请求内容:",wxPayUnifiedOrderRequest.toXML());
            logger.error("发起微信支付请求异常，返回状态码:[{}],返回信息:[{}],错误代码:[{}],错误描述:[{}]",e.getReturnCode(),e.getReturnMsg(),e.getErrCode(),e.getErrCodeDes());
            logger.error("发起微信支付请求异常，异常:",e);
            throw new GunsException(BizExceptionEnum.WX_UNIFIED_PAY_ERROR);
        }

        WxPayResultDTO wxPayResultDTO = new WxPayResultDTO();
        wxPayResultDTO.setNonceStr(UUID.randomUUID().toString().replaceAll("-", ""));
        wxPayResultDTO.setPackageStr("prepay_id="+requestResult.getPrepayId());
        wxPayResultDTO.setTimeStamp(String.valueOf(System.currentTimeMillis()/1000));
        wxPayResultDTO.setSignType("MD5");
        //二次签名
        Map<String,String> params = new HashMap<>();
        params.put("timeStamp",wxPayResultDTO.getTimeStamp());
        params.put("nonceStr",wxPayResultDTO.getNonceStr());
        params.put("package",wxPayResultDTO.getPackageStr());
        params.put("signType",wxPayResultDTO.getSignType());
        params.put("appId",wxPayUnifiedOrderRequest.getAppid());

        String paySign = SignUtils.createSign(params,"MD5",wxPayService.getConfig().getMchKey(),null);
        wxPayResultDTO.setPaySign(paySign);

        return wxPayResultDTO;
    }
}
