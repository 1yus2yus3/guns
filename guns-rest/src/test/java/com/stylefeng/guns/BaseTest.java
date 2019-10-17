package com.stylefeng.guns;

import com.stylefeng.guns.rest.GunsRestApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Copyright (C), 杭州未智科技有限公司
 *
 * @author: Cola
 * @date: 2018/08/14 09:25
 * @description:
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GunsRestApplication.class)
@WebAppConfiguration
public class BaseTest {
}
