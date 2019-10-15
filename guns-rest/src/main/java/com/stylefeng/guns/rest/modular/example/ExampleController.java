package com.stylefeng.guns.rest.modular.example;

import com.stylefeng.guns.rest.common.SimpleObject;
import com.stylefeng.guns.rest.common.persistence.model.User;
import com.stylefeng.guns.rest.modular.example.param.Test;
import com.stylefeng.guns.rest.userinfo.ThreadUserLocal;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 常规控制器
 *
 * @author fengshuonan
 * @date 2017-08-23 16:02
 */
@Controller
@RequestMapping("/hello")
public class ExampleController {

    @RequestMapping("")
    public ResponseEntity hello(@RequestBody SimpleObject simpleObject) {

        User user = ThreadUserLocal.getUserLocal();
        System.out.println(simpleObject.getUser());
        return ResponseEntity.ok("请求成功!");
    }

    @RequestMapping("test")
    public ResponseEntity test(@RequestBody Test test) {
        System.out.println(test.getTestName());
        return ResponseEntity.ok("请求成功!");
    }
}
