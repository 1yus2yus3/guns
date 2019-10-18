package com.stylefeng.guns.rest.config;

import cn.binarywang.wx.miniapp.api.WxMaService;
import com.stylefeng.guns.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Copyright (C), 杭州未智科技有限公司
 *
 * @author: Cola
 * @date: 2019/10/18 16:38
 * @description:
 */
public class WxMaConfigurationTest extends BaseTest {

    @Resource(name = "wxMaServiceSmallProgram")
    WxMaService wxMaService;


    @Test
    public void wxMaServiceSmallProgram() {
        wxMaService.toString();
    }

    @Test
    public void wxMaServiceSubscription() {
    }
}