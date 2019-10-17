package com.stylefeng.guns.rest.modular.pay.service.impl;

import com.stylefeng.guns.BaseTest;
import com.stylefeng.guns.rest.modular.pay.dto.WxPayResultDTO;
import com.stylefeng.guns.rest.modular.pay.param.WxPayJSAPI;
import com.stylefeng.guns.rest.modular.pay.service.WxPayManger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class WxPayMangerImplTest extends BaseTest {

    @Autowired
    WxPayManger wxPayManger;

    @Test
    public void unifiedPayOrder() {
        WxPayResultDTO wxPayResultDTO = wxPayManger.unifiedPayOrder(new WxPayJSAPI("test0001", "测试订单",BigDecimal.ONE,"odT_W5QDVmuKfLSVadlSRlBigR6w"));
    }
}