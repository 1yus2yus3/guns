package com.stylefeng.guns.rest.userinfo;


import com.stylefeng.guns.rest.common.persistence.model.User;

/**
 * @author Cola
 * @version 创建时间：2018/7/16下午3:58
 * @description
 */
public class ThreadUserLocal {

    private static ThreadLocal<User> local = new ThreadLocal<>();

    public static void setUserLocal(User user) {
       local.set(user);
    }

    public static User getUserLocal(){
        return local.get();
    }
}
