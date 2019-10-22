package com.stylefeng.guns.rest.modular.pay.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.BaseTest;
import com.stylefeng.guns.core.enums.WxUserAuthSourceTypeEnum;
import com.stylefeng.guns.rest.persistence.model.WxUserAuths;
import com.stylefeng.guns.rest.persistence.service.IWxUserAuthsService;
import com.stylefeng.guns.rest.modular.pay.dto.WxPayResultDTO;
import com.stylefeng.guns.rest.modular.pay.param.WxPayJSAPI;
import com.stylefeng.guns.rest.modular.pay.service.WxPayManger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.math.BigDecimal;

public class WxPayMangerImplTest extends BaseTest {

    @Autowired
    WxPayManger wxPayManger;

    @Resource
    IWxUserAuthsService wxUserAuthsService;

    @Test
    public void unifiedPayOrder() {
        WxPayResultDTO wxPayResultDTO = wxPayManger.unifiedPayOrder(new WxPayJSAPI("test0001", "测试订单",BigDecimal.ONE,"odT_W5QDVmuKfLSVadlSRlBigR6w"));
    }


    @Test
    public void test(){
        WxUserAuths wxUserAuths = new WxUserAuths();
        wxUserAuths.setSourceType(WxUserAuthSourceTypeEnum.MINI_PROGRAM_OPENID.getValue());
        wxUserAuths.setIdentifier("111");
        wxUserAuths.setValid(1);
        wxUserAuths =  wxUserAuthsService.selectOne(new EntityWrapper<>(wxUserAuths));
    }
}