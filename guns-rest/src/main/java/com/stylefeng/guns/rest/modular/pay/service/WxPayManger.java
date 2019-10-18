package com.stylefeng.guns.rest.modular.pay.service;

import com.stylefeng.guns.rest.modular.pay.dto.WxPayResultDTO;
import com.stylefeng.guns.rest.modular.pay.param.WxPayJSAPI;

/**
 * Copyright (C),
 *
 * @author: Cola
 * @date: 2019/10/17 18:32
 * @description:
 */
public interface WxPayManger {

    /***
     * 微信公众号支付统一下单接口
     * @param wxPayJSAPI
     * @return wxPayResultDTO 支付必要参数信息
     */
    WxPayResultDTO unifiedPayOrder(WxPayJSAPI wxPayJSAPI);
}
