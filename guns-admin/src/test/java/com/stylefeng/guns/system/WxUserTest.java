package com.stylefeng.guns.system;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.base.BaseJunit;
import com.stylefeng.guns.core.enums.WxUserAuthSourceTypeEnum;
import com.stylefeng.guns.modular.system.model.WxUserAuths;
import com.stylefeng.guns.modular.system.service.IWxUserAuthsService;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Copyright (C), 杭州未智科技有限公司
 *
 * @author: Cola
 * @date: 2019/10/22 10:01
 * @description:
 */
public class WxUserTest extends BaseJunit {


    @Resource
    IWxUserAuthsService wxUserAuthsService;

    @Test
    public void test(){
        WxUserAuths wxUserAuths = new WxUserAuths();
        wxUserAuths.setSourceType(WxUserAuthSourceTypeEnum.MINI_PROGRAM_OPENID.getValue());
        wxUserAuths.setIdentifier("111");
        wxUserAuths.setValid(1);
        wxUserAuths =  wxUserAuthsService.selectOne(new EntityWrapper<>(wxUserAuths));
    }
}
