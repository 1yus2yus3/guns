package com.stylefeng.guns.jwt;

import com.stylefeng.guns.BaseTest;
import com.stylefeng.guns.rest.modular.auth.util.JwtTokenUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Copyright (C), 杭州未智科技有限公司
 *
 * @author: Cola
 * @date: 2019/10/16 11:25
 * @description:
 */
public class JwtConcurrentTest extends BaseTest {

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Test
    public void contextLoads() {


        Long timeBefor = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            /*final String randomKey = jwtTokenUtil.getRandomKey();
            final String token = jwtTokenUtil.generateToken("admin", randomKey);
            System.out.println(token);*/
            String token1="eyJhbGciOiJIUzUxMiJ9.eyJyYW5kb21LZXkiOiJ2Zzg0ejciLCJzdWIiOiJhZG1pbiIsImV4cCI6MTU3MTIxNTIyOCwiaWF0IjoxNTcxMjA1MjI4fQ.YHWfsvtNQaL6mRVF6cpuNA1upYX5Bbt4fXLqmdGTCgU6StdkxYzDqETRv9-IBQ9U8653D1dW8BsanZHyqj_IFQ";
            jwtTokenUtil.getClaimFromToken(token1);
        }
        Long timeAfter = System.currentTimeMillis();

        System.out.println("耗时：" + (timeAfter-timeBefor));
    }

}