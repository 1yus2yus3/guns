package com.stylefeng.guns.rest.config;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.config.WxMaConfig;
import cn.binarywang.wx.miniapp.config.WxMaInMemoryConfig;
import cn.binarywang.wx.miniapp.message.WxMaMessageHandler;
import cn.binarywang.wx.miniapp.message.WxMaMessageRouter;
import com.stylefeng.guns.rest.config.properties.WxSmallProgramProperties;
import com.stylefeng.guns.rest.config.properties.WxSubscriptionProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


/***
 * 微信小程序配置信息
 */
@Configuration
@EnableConfigurationProperties({WxSmallProgramProperties.class,WxSubscriptionProperties.class})
public class WxMaConfiguration {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    WxSmallProgramProperties wxSmallProgramProperties;

    @Autowired
    WxSubscriptionProperties wxSubscriptionProperties;

    /***
     * 初始化小程序微信基础配置对象
     * @return
     */
    @Bean
    public WxMaService wxMaServiceSmallProgram() {
        WxMaService service = new WxMaServiceImpl();
        service.setWxMaConfig(getWxMaConfig(wxSmallProgramProperties.getAppid(),wxSmallProgramProperties.getSecret(),wxSmallProgramProperties.getToken(),wxSmallProgramProperties.getAesKey(),wxSmallProgramProperties.getMsgDataFormat()));
        return service;
    }

    /***
     * 初始化公众号信息基础配置对象
     * @return
     */
    @Bean
    public WxMaService wxMaServiceSubscription() {
        WxMaService service = new WxMaServiceImpl();
        service.setWxMaConfig(getWxMaConfig(wxSubscriptionProperties.getAppid(),wxSubscriptionProperties.getSecret(),wxSubscriptionProperties.getToken(),wxSubscriptionProperties.getAesKey(),wxSubscriptionProperties.getMsgDataFormat()));
        return service;
    }

    /***
     * 微信应用内用户消息转发路由
     * @param wxMaServiceSmallProgram
     * @return
     */
    @Bean
    public WxMaMessageRouter smallProgramRouter(WxMaService wxMaServiceSmallProgram) {
        final WxMaMessageRouter router = new WxMaMessageRouter(wxMaServiceSmallProgram);
        router.rule().handler(logHandler).next();
        return router;
    }

    /***
     * 微信应用内用户消息转发路由
     * @param wxMaServiceSubscription
     * @return
     */
    @Bean
    public WxMaMessageRouter subscriptionRouter(WxMaService wxMaServiceSubscription) {
        final WxMaMessageRouter router = new WxMaMessageRouter(wxMaServiceSubscription);
        router.rule().handler(logHandler).next();
        return router;
    }

    private WxMaConfig getWxMaConfig(String appid, String secret, String token, String aesKey, String msgDataFormat) {
        WxMaInMemoryConfig config = new WxMaInMemoryConfig();
        config.setAppid(appid);
        config.setSecret(secret);
        config.setToken(token);
        config.setAesKey(aesKey);
        config.setMsgDataFormat(msgDataFormat);
        return config;
    }

    private final WxMaMessageHandler logHandler = (wxMessage, context, service, sessionManager) -> logger.info("收到微信消息: [{}]:[{}]",wxMessage.getFromUser(),wxMessage.getContent());

}
