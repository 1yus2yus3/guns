package com.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 微信退款交易信息表
 * </p>
 *
 * @author codeGenerator
 * @since 2019-10-23
 */
@TableName("wx_refund_info")
public class WxRefundInfo extends Model<WxRefundInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 订单id
     */
    @TableField("order_id")
    private Long orderId;
    /**
     * 订单号
     */
    @TableField("order_num")
    private String orderNum;
    /**
     * 退款单id
     */
    @TableField("refund_order_id")
    private Long refundOrderId;
    /**
     * 退款交易号
     */
    @TableField("out_refund_no")
    private String outRefundNo;
    /**
     * 原始外部交易号
     */
    @TableField("out_trade_no")
    private String outTradeNo;
    /**
     * 应退金额
     */
    @TableField("refund_money")
    private BigDecimal refundMoney;
    /**
     * 请求数据
     */
    @TableField("request_data")
    private String requestData;
    /**
     * 返回数据
     */
    @TableField("response_data")
    private String responseData;
    /**
     * appid
     */
    private String appid;
    /**
     * much_id
     */
    @TableField("much_id")
    private String muchId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Long getRefundOrderId() {
        return refundOrderId;
    }

    public void setRefundOrderId(Long refundOrderId) {
        this.refundOrderId = refundOrderId;
    }

    public String getOutRefundNo() {
        return outRefundNo;
    }

    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public BigDecimal getRefundMoney() {
        return refundMoney;
    }

    public void setRefundMoney(BigDecimal refundMoney) {
        this.refundMoney = refundMoney;
    }

    public String getRequestData() {
        return requestData;
    }

    public void setRequestData(String requestData) {
        this.requestData = requestData;
    }

    public String getResponseData() {
        return responseData;
    }

    public void setResponseData(String responseData) {
        this.responseData = responseData;
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

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "WxRefundInfo{" +
        "id=" + id +
        ", orderId=" + orderId +
        ", orderNum=" + orderNum +
        ", refundOrderId=" + refundOrderId +
        ", outRefundNo=" + outRefundNo +
        ", outTradeNo=" + outTradeNo +
        ", refundMoney=" + refundMoney +
        ", requestData=" + requestData +
        ", responseData=" + responseData +
        ", appid=" + appid +
        ", muchId=" + muchId +
        "}";
    }
}
