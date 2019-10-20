package com.stylefeng.guns.rest.modular.auth.controller;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.core.enums.WxUserAuthSourceTypeEnum;
import com.stylefeng.guns.core.enums.WxUserStatusEnum;
import com.stylefeng.guns.core.exception.GunsException;
import com.stylefeng.guns.core.persistence.model.WxUser;
import com.stylefeng.guns.core.persistence.model.WxUserAuths;
import com.stylefeng.guns.core.persistence.service.IWxUserAuthsService;
import com.stylefeng.guns.core.persistence.service.IWxUserService;
import com.stylefeng.guns.rest.common.exception.BizExceptionEnum;
import com.stylefeng.guns.rest.modular.auth.controller.dto.AuthRequest;
import com.stylefeng.guns.rest.modular.auth.controller.dto.AuthResponse;
import com.stylefeng.guns.rest.modular.auth.util.JwtTokenUtil;
import me.chanjar.weixin.common.error.WxErrorException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 请求验证的
 *
 * @author fengshuonan
 * @Date 2017/8/24 14:22
 */
@RestController
public class AuthController {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Resource(name = "wxMaServiceSmallProgram")
    private WxMaService wxMaServiceSmallProgram;
    @Resource
    private IWxUserAuthsService iWxUserAuthsService;
    @Resource
    private IWxUserService iWxUserService;

    @RequestMapping(value = "${jwt.auth-path}")
    public ResponseEntity<?> createAuthenticationToken(AuthRequest authRequest) {
        if(authRequest.getCode() == null) {
            throw new GunsException(BizExceptionEnum.PARAM_NO_ERROR);
        }
        WxMaJscode2SessionResult sessionResult;
        try {
            sessionResult = wxMaServiceSmallProgram.getUserService().getSessionInfo(authRequest.getCode());
        }catch (WxErrorException e) {
            logger.error("createAuthenticationToken=>code2openid error,reason :{}",e);
            throw new GunsException(BizExceptionEnum.SYSTEM_ERROR);
        }
        //根据openid查询数据库中是否存在该openid
        WxUserAuths wxUserAuths = new WxUserAuths();
        wxUserAuths.setSourceType(WxUserAuthSourceTypeEnum.MINI_PROGRAM_OPENID.getValue());
        wxUserAuths.setIdentifier(sessionResult.getOpenid());
        wxUserAuths.setValid(1);
        wxUserAuths =  iWxUserAuthsService.selectOne(new EntityWrapper<>());
        //openid未找到系统对应的微信用户 调用用户注册逻辑
        if(wxUserAuths == null) {
            if(authRequest.getEncryptedData() == null || authRequest.getIv() == null) {
                //前端新用户授权需要提交用户信息参数
                logger.error("createAuthenticationToken=> lack necessary param : current param : " + authRequest.toString());
                throw new GunsException(BizExceptionEnum.WX_AUTH_NO_USER_INFO_ERROR);
            }
            WxMaUserInfo wxMaUserInfo;
            try {
                wxMaUserInfo = wxMaServiceSmallProgram.getUserService().
                        getUserInfo(sessionResult.getSessionKey(),authRequest.getEncryptedData(),authRequest.getIv());
            }catch (Exception e) {
                logger.error("createAuthenticationToken=>wx get userinfo api error,reason :{}",e);
                throw new GunsException(BizExceptionEnum.WX_AUTH_NO_USER_INFO_ERROR);
            }
            //持久化新用户
            WxUser wxUser = new WxUser();
            wxUser.setUnionId(wxMaUserInfo.getUnionId());
            wxUser.setUserNickName(wxMaUserInfo.getNickName());
            wxUser.setUserHeadPic(wxMaUserInfo.getAvatarUrl());
            wxUser.setGender(wxMaUserInfo.getGender());
            wxUser.setLanguage(wxMaUserInfo.getLanguage());
            wxUser.setCountry(wxMaUserInfo.getCountry());
            wxUser.setProvince(wxMaUserInfo.getProvince());
            wxUser.setCity(wxMaUserInfo.getCity());
            wxUser.setStatus(WxUserStatusEnum.NORMAL.getValue());
            iWxUserService.insert(wxUser);
            //持久化新用户授权方式
            wxUserAuths = new WxUserAuths();
            wxUserAuths.setUserId(wxUser.getId());
            wxUserAuths.setSourceType(WxUserAuthSourceTypeEnum.MINI_PROGRAM_OPENID.getValue());
            wxUserAuths.setIdentifier(sessionResult.getOpenid());
            wxUserAuths.setValid(1);
            iWxUserAuthsService.insert(wxUserAuths);
        }
        //userinfo => token
        final String randomKey = jwtTokenUtil.getRandomKey();
        final String token = jwtTokenUtil.generateToken(wxUserAuths.getUserId().toString(), randomKey);
        return ResponseEntity.ok(new AuthResponse(token, randomKey));
    }
}
