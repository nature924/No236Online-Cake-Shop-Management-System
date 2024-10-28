package com.entity.vo;

import com.entity.DangaoOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 商品订单
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("dangao_order")
public class DangaoOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 订单号
     */

    @TableField(value = "dangao_order_uuid_number")
    private String dangaoOrderUuidNumber;


    /**
     * 收货地址
     */

    @TableField(value = "address_id")
    private Integer addressId;


    /**
     * 商品
     */

    @TableField(value = "dangao_id")
    private Integer dangaoId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 购买数量
     */

    @TableField(value = "buy_number")
    private Integer buyNumber;


    /**
     * 实付价格
     */

    @TableField(value = "dangao_order_true_price")
    private Double dangaoOrderTruePrice;


    /**
     * 订单类型
     */

    @TableField(value = "dangao_order_types")
    private Integer dangaoOrderTypes;


    /**
     * 支付类型
     */

    @TableField(value = "dangao_order_payment_types")
    private Integer dangaoOrderPaymentTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：订单号
	 */
    public String getDangaoOrderUuidNumber() {
        return dangaoOrderUuidNumber;
    }


    /**
	 * 获取：订单号
	 */

    public void setDangaoOrderUuidNumber(String dangaoOrderUuidNumber) {
        this.dangaoOrderUuidNumber = dangaoOrderUuidNumber;
    }
    /**
	 * 设置：收货地址
	 */
    public Integer getAddressId() {
        return addressId;
    }


    /**
	 * 获取：收货地址
	 */

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }
    /**
	 * 设置：商品
	 */
    public Integer getDangaoId() {
        return dangaoId;
    }


    /**
	 * 获取：商品
	 */

    public void setDangaoId(Integer dangaoId) {
        this.dangaoId = dangaoId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：购买数量
	 */
    public Integer getBuyNumber() {
        return buyNumber;
    }


    /**
	 * 获取：购买数量
	 */

    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }
    /**
	 * 设置：实付价格
	 */
    public Double getDangaoOrderTruePrice() {
        return dangaoOrderTruePrice;
    }


    /**
	 * 获取：实付价格
	 */

    public void setDangaoOrderTruePrice(Double dangaoOrderTruePrice) {
        this.dangaoOrderTruePrice = dangaoOrderTruePrice;
    }
    /**
	 * 设置：订单类型
	 */
    public Integer getDangaoOrderTypes() {
        return dangaoOrderTypes;
    }


    /**
	 * 获取：订单类型
	 */

    public void setDangaoOrderTypes(Integer dangaoOrderTypes) {
        this.dangaoOrderTypes = dangaoOrderTypes;
    }
    /**
	 * 设置：支付类型
	 */
    public Integer getDangaoOrderPaymentTypes() {
        return dangaoOrderPaymentTypes;
    }


    /**
	 * 获取：支付类型
	 */

    public void setDangaoOrderPaymentTypes(Integer dangaoOrderPaymentTypes) {
        this.dangaoOrderPaymentTypes = dangaoOrderPaymentTypes;
    }
    /**
	 * 设置：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：订单创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
