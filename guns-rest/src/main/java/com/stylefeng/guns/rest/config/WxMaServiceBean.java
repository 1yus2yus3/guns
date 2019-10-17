package com.stylefeng.guns.rest.config;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.config.WxMaInMemoryConfig;
import com.stylefeng.guns.rest.config.properties.WxSmallProgramProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


/***
 * 微信小程序配置信息
 */
@Component
public class WxMaServiceBean {

    @Autowired
    WxSmallProgramProperties wxSmallProgramProperties;

    @Bean
    public WxMaService wxMaService() {
        WxMaInMemoryConfig config = new WxMaInMemoryConfig();
        config.setAppid(wxSmallProgramProperties.getAppid());
        config.setSecret(wxSmallProgramProperties.getSecret());
        config.setToken(wxSmallProgramProperties.getToken());
        config.setAesKey(wxSmallProgramProperties.getAesKey());
        config.setMsgDataFormat(wxSmallProgramProperties.getMsgDataFormat());

        WxMaService service = new WxMaServiceImpl();
        service.setWxMaConfig(config);
        return service;
    }
}
