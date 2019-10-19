package com.stylefeng.guns.rest.config;

import java.util.ArrayList;
import java.util.List;

/**
 * web配置
 *
 * @author cola
 * @date 2019-10-20 15:48
 */
public class WebInterceptUrlConfig {

    //无需登录拦截的URL地址
    public static List<String> RUL_NO_INTERCEPT_LIST = new ArrayList<>();

    static {
        RUL_NO_INTERCEPT_LIST.add("");
    }

}
