package com.stylefeng.guns.rest.config;

import com.github.binarywang.wxpay.config.WxPayConfig;
import com.github.binarywang.wxpay.service.WxPayService;
import com.github.binarywang.wxpay.service.impl.WxPayServiceImpl;
import com.stylefeng.guns.rest.config.properties.WxPayProperties;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @date: 2019/01/24 15:17
 * @description:
 */
@Configuration
@ConditionalOnClass(WxPayService.class)
@EnableConfigurationProperties(WxPayProperties.class)
public class WxPayConfiguration {

    @Autowired
    private WxPayProperties wxPayProperties;

    @Bean
    @ConditionalOnMissingBean
    public WxPayService wxPayService() {
        WxPayConfig payConfig = new WxPayConfig();
        payConfig.setAppId(StringUtils.trimToNull(this.wxPayProperties.getAppId()));
        payConfig.setMchId(StringUtils.trimToNull(this.wxPayProperties.getMchId()));
        payConfig.setMchKey(StringUtils.trimToNull(this.wxPayProperties.getMchKey()));
        payConfig.setSubAppId(StringUtils.trimToNull(this.wxPayProperties.getSubAppId()));
        payConfig.setSubMchId(StringUtils.trimToNull(this.wxPayProperties.getSubMchId()));
        payConfig.setKeyPath(StringUtils.trimToNull(this.wxPayProperties.getKeyPath()));
        // 可以指定是否使用沙箱环境
        payConfig.setUseSandboxEnv(false);

        WxPayService wxPayService = new WxPayServiceImpl();
        wxPayService.setConfig(payConfig);
        return wxPayService;
    }

}
