package com.stylefeng.guns.rest.config;

import cn.binarywang.wx.miniapp.api.WxMaService;
import com.stylefeng.guns.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Copyright (C),
 *
 * @author: Cola
 * @date: 2019/10/18 16:38
 * @description:
 */
public class WxMaConfigurationTest extends BaseTest {

    @Resource(name = "wxMaServiceSmallProgram")
    WxMaService wxMaServiceSmallProgram;

    @Resource(name = "wxMaServiceSubscription")
    WxMaService wxMaServiceSubscription;


    @Test
    public void wxMaServiceSmallProgram() {
        wxMaServiceSmallProgram.toString();
    }

    @Test
    public void wxMaServiceSubscription() {
    }
}