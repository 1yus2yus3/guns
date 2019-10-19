package com.stylefeng.guns.rest.persistence.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 微信退款回调信息表
 * </p>
 *
 * @author codeGenerator
 * @since 2019-10-17
 */
@TableName("wx_refund_callback_info")
public class WxRefundCallbackInfo extends Model<WxRefundCallbackInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 原始回调结果解密前
     */
    @TableField("back_data_before")
    private String backDataBefore;
    /**
     * 原始回调结果解密后
     */
    @TableField("back_data_after")
    private String backDataAfter;
    /**
     * 支付成功时间
     */
    @TableField("back_time")
    private Date backTime;
    /**
     * 小程序ID
     */
    private String appid;
    /**
     * 商户号
     */
    @TableField("much_id")
    private String muchId;
    /**
     * 随机字符串
     */
    @TableField("nonce_str")
    private String nonceStr;
    /**
     * 订单金额
     */
    @TableField("total_fee")
    private Integer totalFee;
    /**
     * 微信支付订单号
     */
    @TableField("transaction_id")
    private String transactionId;
    /**
     * 商户订单号
     */
    @TableField("out_trade_no")
    private String outTradeNo;
    /**
     * 返回状态码
     */
    @TableField("return_code")
    private String returnCode;
    /**
     * 返回信息
     */
    @TableField("return_msg")
    private String returnMsg;
    /**
     * 退款交易号
     */
    @TableField("out_refund_no")
    private String outRefundNo;
    /**
     * 退款状态
     */
    @TableField("refund_status")
    private String refundStatus;
    /**
     * 应结订单金额
     */
    @TableField("settlement_total_fee")
    private Integer settlementTotalFee;
    /**
     * 退款金额
     */
    @TableField("refund_fee")
    private Integer refundFee;
    /**
     * 应结退款订单金额
     */
    @TableField("settlement_refund_fee")
    private Integer settlementRefundFee;
    /**
     * 退款入账账户
     */
    @TableField("refund_recv_accout")
    private String refundRecvAccout;
    /**
     * 退款资金来源
     */
    @TableField("refund_account")
    private String refundAccount;
    /**
     * 退款发起来源
     */
    @TableField("refund_request_source")
    private String refundRequestSource;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBackDataBefore() {
        return backDataBefore;
    }

    public void setBackDataBefore(String backDataBefore) {
        this.backDataBefore = backDataBefore;
    }

    public String getBackDataAfter() {
        return backDataAfter;
    }

    public void setBackDataAfter(String backDataAfter) {
        this.backDataAfter = backDataAfter;
    }

    public Date getBackTime() {
        return backTime;
    }

    public void setBackTime(Date backTime) {
        this.backTime = backTime;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMuchId() {
        return muchId;
    }

    public void setMuchId(String muchId) {
        this.muchId = muchId;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public String getOutRefundNo() {
        return outRefundNo;
    }

    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo;
    }

    public String getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
    }

    public Integer getSettlementTotalFee() {
        return settlementTotalFee;
    }

    public void setSettlementTotalFee(Integer settlementTotalFee) {
        this.settlementTotalFee = settlementTotalFee;
    }

    public Integer getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(Integer refundFee) {
        this.refundFee = refundFee;
    }

    public Integer getSettlementRefundFee() {
        return settlementRefundFee;
    }

    public void setSettlementRefundFee(Integer settlementRefundFee) {
        this.settlementRefundFee = settlementRefundFee;
    }

    public String getRefundRecvAccout() {
        return refundRecvAccout;
    }

    public void setRefundRecvAccout(String refundRecvAccout) {
        this.refundRecvAccout = refundRecvAccout;
    }

    public String getRefundAccount() {
        return refundAccount;
    }

    public void setRefundAccount(String refundAccount) {
        this.refundAccount = refundAccount;
    }

    public String getRefundRequestSource() {
        return refundRequestSource;
    }

    public void setRefundRequestSource(String refundRequestSource) {
        this.refundRequestSource = refundRequestSource;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "WxRefundCallbackInfo{" +
        "id=" + id +
        ", backDataBefore=" + backDataBefore +
        ", backDataAfter=" + backDataAfter +
        ", backTime=" + backTime +
        ", appid=" + appid +
        ", muchId=" + muchId +
        ", nonceStr=" + nonceStr +
        ", totalFee=" + totalFee +
        ", transactionId=" + transactionId +
        ", outTradeNo=" + outTradeNo +
        ", returnCode=" + returnCode +
        ", returnMsg=" + returnMsg +
        ", outRefundNo=" + outRefundNo +
        ", refundStatus=" + refundStatus +
        ", settlementTotalFee=" + settlementTotalFee +
        ", refundFee=" + refundFee +
        ", settlementRefundFee=" + settlementRefundFee +
        ", refundRecvAccout=" + refundRecvAccout +
        ", refundAccount=" + refundAccount +
        ", refundRequestSource=" + refundRequestSource +
        "}";
    }
}
