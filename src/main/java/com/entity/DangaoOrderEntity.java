package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 商品订单
 *
 * @author 
 * @email
 */
@TableName("dangao_order")
public class DangaoOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public DangaoOrderEntity() {

	}

	public DangaoOrderEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 订单号
     */
    @ColumnInfo(comment="订单号",type="varchar(200)")
    @TableField(value = "dangao_order_uuid_number")

    private String dangaoOrderUuidNumber;


    /**
     * 收货地址
     */
    @ColumnInfo(comment="收货地址",type="int(11)")
    @TableField(value = "address_id")

    private Integer addressId;


    /**
     * 商品
     */
    @ColumnInfo(comment="商品",type="int(11)")
    @TableField(value = "dangao_id")

    private Integer dangaoId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 购买数量
     */
    @ColumnInfo(comment="购买数量",type="int(11)")
    @TableField(value = "buy_number")

    private Integer buyNumber;


    /**
     * 实付价格
     */
    @ColumnInfo(comment="实付价格",type="decimal(10,2)")
    @TableField(value = "dangao_order_true_price")

    private Double dangaoOrderTruePrice;


    /**
     * 订单类型
     */
    @ColumnInfo(comment="订单类型",type="int(11)")
    @TableField(value = "dangao_order_types")

    private Integer dangaoOrderTypes;


    /**
     * 支付类型
     */
    @ColumnInfo(comment="支付类型",type="int(11)")
    @TableField(value = "dangao_order_payment_types")

    private Integer dangaoOrderPaymentTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="订单创建时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间  listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：订单号
	 */
    public String getDangaoOrderUuidNumber() {
        return dangaoOrderUuidNumber;
    }
    /**
	 * 设置：订单号
	 */

    public void setDangaoOrderUuidNumber(String dangaoOrderUuidNumber) {
        this.dangaoOrderUuidNumber = dangaoOrderUuidNumber;
    }
    /**
	 * 获取：收货地址
	 */
    public Integer getAddressId() {
        return addressId;
    }
    /**
	 * 设置：收货地址
	 */

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }
    /**
	 * 获取：商品
	 */
    public Integer getDangaoId() {
        return dangaoId;
    }
    /**
	 * 设置：商品
	 */

    public void setDangaoId(Integer dangaoId) {
        this.dangaoId = dangaoId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：购买数量
	 */
    public Integer getBuyNumber() {
        return buyNumber;
    }
    /**
	 * 设置：购买数量
	 */

    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }
    /**
	 * 获取：实付价格
	 */
    public Double getDangaoOrderTruePrice() {
        return dangaoOrderTruePrice;
    }
    /**
	 * 设置：实付价格
	 */

    public void setDangaoOrderTruePrice(Double dangaoOrderTruePrice) {
        this.dangaoOrderTruePrice = dangaoOrderTruePrice;
    }
    /**
	 * 获取：订单类型
	 */
    public Integer getDangaoOrderTypes() {
        return dangaoOrderTypes;
    }
    /**
	 * 设置：订单类型
	 */

    public void setDangaoOrderTypes(Integer dangaoOrderTypes) {
        this.dangaoOrderTypes = dangaoOrderTypes;
    }
    /**
	 * 获取：支付类型
	 */
    public Integer getDangaoOrderPaymentTypes() {
        return dangaoOrderPaymentTypes;
    }
    /**
	 * 设置：支付类型
	 */

    public void setDangaoOrderPaymentTypes(Integer dangaoOrderPaymentTypes) {
        this.dangaoOrderPaymentTypes = dangaoOrderPaymentTypes;
    }
    /**
	 * 获取：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：订单创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "DangaoOrder{" +
            ", id=" + id +
            ", dangaoOrderUuidNumber=" + dangaoOrderUuidNumber +
            ", addressId=" + addressId +
            ", dangaoId=" + dangaoId +
            ", yonghuId=" + yonghuId +
            ", buyNumber=" + buyNumber +
            ", dangaoOrderTruePrice=" + dangaoOrderTruePrice +
            ", dangaoOrderTypes=" + dangaoOrderTypes +
            ", dangaoOrderPaymentTypes=" + dangaoOrderPaymentTypes +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
