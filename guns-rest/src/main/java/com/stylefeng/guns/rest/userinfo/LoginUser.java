package com.stylefeng.guns.rest.userinfo;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 * 登录信息
 */
public class LoginUser implements Serializable {

    private static final long serialVersionUID = 1L;

	private Long id;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "LoginUser{" +
				"id=" + id +
				'}';
	}
}
