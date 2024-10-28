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
 * 商品
 *
 * @author 
 * @email
 */
@TableName("dangao")
public class DangaoEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public DangaoEntity() {

	}

	public DangaoEntity(T t) {
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
     * 商品名称
     */
    @ColumnInfo(comment="商品名称",type="varchar(200)")
    @TableField(value = "dangao_name")

    private String dangaoName;


    /**
     * 商品编号
     */
    @ColumnInfo(comment="商品编号",type="varchar(200)")
    @TableField(value = "dangao_uuid_number")

    private String dangaoUuidNumber;


    /**
     * 商品照片
     */
    @ColumnInfo(comment="商品照片",type="varchar(200)")
    @TableField(value = "dangao_photo")

    private String dangaoPhoto;


    /**
     * 商品类型
     */
    @ColumnInfo(comment="商品类型",type="int(11)")
    @TableField(value = "dangao_types")

    private Integer dangaoTypes;


    /**
     * 商品库存
     */
    @ColumnInfo(comment="商品库存",type="int(11)")
    @TableField(value = "dangao_kucun_number")

    private Integer dangaoKucunNumber;


    /**
     * 购买获得积分
     */
    @ColumnInfo(comment="购买获得积分",type="int(11)")
    @TableField(value = "dangao_price")

    private Integer dangaoPrice;


    /**
     * 商品原价
     */
    @ColumnInfo(comment="商品原价",type="decimal(10,2)")
    @TableField(value = "dangao_old_money")

    private Double dangaoOldMoney;


    /**
     * 现价
     */
    @ColumnInfo(comment="现价",type="decimal(10,2)")
    @TableField(value = "dangao_new_money")

    private Double dangaoNewMoney;


    /**
     * 商品热度
     */
    @ColumnInfo(comment="商品热度",type="int(11)")
    @TableField(value = "dangao_clicknum")

    private Integer dangaoClicknum;


    /**
     * 商品介绍
     */
    @ColumnInfo(comment="商品介绍",type="longtext")
    @TableField(value = "dangao_content")

    private String dangaoContent;


    /**
     * 是否上架
     */
    @ColumnInfo(comment="是否上架",type="int(11)")
    @TableField(value = "shangxia_types")

    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "dangao_delete")

    private Integer dangaoDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
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
	 * 获取：商品名称
	 */
    public String getDangaoName() {
        return dangaoName;
    }
    /**
	 * 设置：商品名称
	 */

    public void setDangaoName(String dangaoName) {
        this.dangaoName = dangaoName;
    }
    /**
	 * 获取：商品编号
	 */
    public String getDangaoUuidNumber() {
        return dangaoUuidNumber;
    }
    /**
	 * 设置：商品编号
	 */

    public void setDangaoUuidNumber(String dangaoUuidNumber) {
        this.dangaoUuidNumber = dangaoUuidNumber;
    }
    /**
	 * 获取：商品照片
	 */
    public String getDangaoPhoto() {
        return dangaoPhoto;
    }
    /**
	 * 设置：商品照片
	 */

    public void setDangaoPhoto(String dangaoPhoto) {
        this.dangaoPhoto = dangaoPhoto;
    }
    /**
	 * 获取：商品类型
	 */
    public Integer getDangaoTypes() {
        return dangaoTypes;
    }
    /**
	 * 设置：商品类型
	 */

    public void setDangaoTypes(Integer dangaoTypes) {
        this.dangaoTypes = dangaoTypes;
    }
    /**
	 * 获取：商品库存
	 */
    public Integer getDangaoKucunNumber() {
        return dangaoKucunNumber;
    }
    /**
	 * 设置：商品库存
	 */

    public void setDangaoKucunNumber(Integer dangaoKucunNumber) {
        this.dangaoKucunNumber = dangaoKucunNumber;
    }
    /**
	 * 获取：购买获得积分
	 */
    public Integer getDangaoPrice() {
        return dangaoPrice;
    }
    /**
	 * 设置：购买获得积分
	 */

    public void setDangaoPrice(Integer dangaoPrice) {
        this.dangaoPrice = dangaoPrice;
    }
    /**
	 * 获取：商品原价
	 */
    public Double getDangaoOldMoney() {
        return dangaoOldMoney;
    }
    /**
	 * 设置：商品原价
	 */

    public void setDangaoOldMoney(Double dangaoOldMoney) {
        this.dangaoOldMoney = dangaoOldMoney;
    }
    /**
	 * 获取：现价
	 */
    public Double getDangaoNewMoney() {
        return dangaoNewMoney;
    }
    /**
	 * 设置：现价
	 */

    public void setDangaoNewMoney(Double dangaoNewMoney) {
        this.dangaoNewMoney = dangaoNewMoney;
    }
    /**
	 * 获取：商品热度
	 */
    public Integer getDangaoClicknum() {
        return dangaoClicknum;
    }
    /**
	 * 设置：商品热度
	 */

    public void setDangaoClicknum(Integer dangaoClicknum) {
        this.dangaoClicknum = dangaoClicknum;
    }
    /**
	 * 获取：商品介绍
	 */
    public String getDangaoContent() {
        return dangaoContent;
    }
    /**
	 * 设置：商品介绍
	 */

    public void setDangaoContent(String dangaoContent) {
        this.dangaoContent = dangaoContent;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }
    /**
	 * 设置：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getDangaoDelete() {
        return dangaoDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setDangaoDelete(Integer dangaoDelete) {
        this.dangaoDelete = dangaoDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Dangao{" +
            ", id=" + id +
            ", dangaoName=" + dangaoName +
            ", dangaoUuidNumber=" + dangaoUuidNumber +
            ", dangaoPhoto=" + dangaoPhoto +
            ", dangaoTypes=" + dangaoTypes +
            ", dangaoKucunNumber=" + dangaoKucunNumber +
            ", dangaoPrice=" + dangaoPrice +
            ", dangaoOldMoney=" + dangaoOldMoney +
            ", dangaoNewMoney=" + dangaoNewMoney +
            ", dangaoClicknum=" + dangaoClicknum +
            ", dangaoContent=" + dangaoContent +
            ", shangxiaTypes=" + shangxiaTypes +
            ", dangaoDelete=" + dangaoDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
