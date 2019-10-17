package com.stylefeng.guns.rest.modular.pay;

import com.github.binarywang.wxpay.bean.notify.WxPayNotifyResponse;
import com.github.binarywang.wxpay.bean.notify.WxPayOrderNotifyResult;
import com.github.binarywang.wxpay.bean.notify.WxPayRefundNotifyResult;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/wx/pay")
public class WxPayPortalController {

    @Resource
    private WxPayService wxPayService;


    @PostMapping("/notify/order")
    public String parseOrderNotifyResult(@RequestBody String xmlData) throws WxPayException {
        final WxPayOrderNotifyResult notifyResult = wxPayService.parseOrderNotifyResult(xmlData);
        //tradeService.weChatPayCallBackNotify(notifyResult);
        return WxPayNotifyResponse.success("成功");
    }

    @PostMapping("/notify/refund")
    public String parseRefundNotifyResult(@RequestBody String xmlData) throws WxPayException {
        final WxPayRefundNotifyResult result = wxPayService.parseRefundNotifyResult(xmlData);
        //tradeService.weChatRefundCallBackNotify(result);
        return WxPayNotifyResponse.success("成功");
    }

}
