package com.stylefeng.guns.rest.modular.pay.service;

import java.math.BigDecimal;

/**
 * Copyright (C), 杭州未智科技有限公司
 *
 * @author: Cola
 * @date: 2019/10/17 18:32
 * @description:
 */
public interface WxPayManger {

    void unifiedPayOrder(String orderNum, String orderName, BigDecimal orderMoney,Long userId);
}
