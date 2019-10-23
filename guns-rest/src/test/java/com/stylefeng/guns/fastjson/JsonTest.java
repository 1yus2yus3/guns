package com.stylefeng.guns.fastjson;

import com.alibaba.fastjson.JSON;
import com.stylefeng.guns.core.util.MD5Util;
import com.stylefeng.guns.rest.modular.auth.converter.BaseTransferEntity;
import com.stylefeng.guns.rest.modular.auth.security.impl.Base64SecurityAction;
import com.stylefeng.guns.rest.modular.example.param.Test;

/**
 * json测试
 *
 * @author fengshuonan
 * @date 2017-08-25 16:11
 */


public class JsonTest {

    public static void main(String[] args) {
        String randomKey = "0k40h4";

        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
        Test simpleObject = new Test();
        simpleObject.setTestName("hahah");

        String jsonString = JSON.toJSONString(simpleObject);
        String encode = new Base64SecurityAction().doAction(jsonString);
        baseTransferEntity.setObject(encode);


        //md5签名
        String encrypt = MD5Util.encrypt(jsonString + randomKey);
        baseTransferEntity.setSign(encrypt);

        System.out.println(JSON.toJSONString(baseTransferEntity));
    }
}
