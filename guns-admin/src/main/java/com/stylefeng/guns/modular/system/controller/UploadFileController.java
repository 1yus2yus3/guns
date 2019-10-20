package com.stylefeng.guns.modular.system.controller;

import com.stylefeng.guns.config.QiNiuUploadConfig;
import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.common.exception.BizExceptionEnum;
import com.stylefeng.guns.core.exception.GunsException;
import com.stylefeng.guns.core.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * 系统管理员控制器
 *
 * @author fengshuonan
 * @Date 2017年1月11日 下午1:08:17
 */
@Controller
@RequestMapping("/upload")
public class UploadFileController extends BaseController {

    @Autowired
    QiNiuUploadConfig qiNiuUploadConfig;

    /**
     * 上传图片
     */
    @RequestMapping(method = RequestMethod.POST, path = "/uploadFile")
    @ResponseBody
    public String upload(@RequestPart("file") MultipartFile picture) {

        String picUrlName = null;
        try {

            String prefixDate = DateUtils.date2String(new Date(),DateUtils.DATE_FORMAT_A);
            picUrlName = qiNiuUploadConfig.uploadImgDefaultName(prefixDate , picture.getBytes());
        }catch (Exception e) {
            throw new GunsException(BizExceptionEnum.UPLOAD_ERROR);
        }
        return picUrlName;
    }
}
