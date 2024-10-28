package com.entity.vo;

import com.entity.DangaoEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 商品
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("dangao")
public class DangaoVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 商品名称
     */

    @TableField(value = "dangao_name")
    private String dangaoName;


    /**
     * 商品编号
     */

    @TableField(value = "dangao_uuid_number")
    private String dangaoUuidNumber;


    /**
     * 商品照片
     */

    @TableField(value = "dangao_photo")
    private String dangaoPhoto;


    /**
     * 商品类型
     */

    @TableField(value = "dangao_types")
    private Integer dangaoTypes;


    /**
     * 商品库存
     */

    @TableField(value = "dangao_kucun_number")
    private Integer dangaoKucunNumber;


    /**
     * 购买获得积分
     */

    @TableField(value = "dangao_price")
    private Integer dangaoPrice;


    /**
     * 商品原价
     */

    @TableField(value = "dangao_old_money")
    private Double dangaoOldMoney;


    /**
     * 现价
     */

    @TableField(value = "dangao_new_money")
    private Double dangaoNewMoney;


    /**
     * 商品热度
     */

    @TableField(value = "dangao_clicknum")
    private Integer dangaoClicknum;


    /**
     * 商品介绍
     */

    @TableField(value = "dangao_content")
    private String dangaoContent;


    /**
     * 是否上架
     */

    @TableField(value = "shangxia_types")
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */

    @TableField(value = "dangao_delete")
    private Integer dangaoDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：商品名称
	 */
    public String getDangaoName() {
        return dangaoName;
    }


    /**
	 * 获取：商品名称
	 */

    public void setDangaoName(String dangaoName) {
        this.dangaoName = dangaoName;
    }
    /**
	 * 设置：商品编号
	 */
    public String getDangaoUuidNumber() {
        return dangaoUuidNumber;
    }


    /**
	 * 获取：商品编号
	 */

    public void setDangaoUuidNumber(String dangaoUuidNumber) {
        this.dangaoUuidNumber = dangaoUuidNumber;
    }
    /**
	 * 设置：商品照片
	 */
    public String getDangaoPhoto() {
        return dangaoPhoto;
    }


    /**
	 * 获取：商品照片
	 */

    public void setDangaoPhoto(String dangaoPhoto) {
        this.dangaoPhoto = dangaoPhoto;
    }
    /**
	 * 设置：商品类型
	 */
    public Integer getDangaoTypes() {
        return dangaoTypes;
    }


    /**
	 * 获取：商品类型
	 */

    public void setDangaoTypes(Integer dangaoTypes) {
        this.dangaoTypes = dangaoTypes;
    }
    /**
	 * 设置：商品库存
	 */
    public Integer getDangaoKucunNumber() {
        return dangaoKucunNumber;
    }


    /**
	 * 获取：商品库存
	 */

    public void setDangaoKucunNumber(Integer dangaoKucunNumber) {
        this.dangaoKucunNumber = dangaoKucunNumber;
    }
    /**
	 * 设置：购买获得积分
	 */
    public Integer getDangaoPrice() {
        return dangaoPrice;
    }


    /**
	 * 获取：购买获得积分
	 */

    public void setDangaoPrice(Integer dangaoPrice) {
        this.dangaoPrice = dangaoPrice;
    }
    /**
	 * 设置：商品原价
	 */
    public Double getDangaoOldMoney() {
        return dangaoOldMoney;
    }


    /**
	 * 获取：商品原价
	 */

    public void setDangaoOldMoney(Double dangaoOldMoney) {
        this.dangaoOldMoney = dangaoOldMoney;
    }
    /**
	 * 设置：现价
	 */
    public Double getDangaoNewMoney() {
        return dangaoNewMoney;
    }


    /**
	 * 获取：现价
	 */

    public void setDangaoNewMoney(Double dangaoNewMoney) {
        this.dangaoNewMoney = dangaoNewMoney;
    }
    /**
	 * 设置：商品热度
	 */
    public Integer getDangaoClicknum() {
        return dangaoClicknum;
    }


    /**
	 * 获取：商品热度
	 */

    public void setDangaoClicknum(Integer dangaoClicknum) {
        this.dangaoClicknum = dangaoClicknum;
    }
    /**
	 * 设置：商品介绍
	 */
    public String getDangaoContent() {
        return dangaoContent;
    }


    /**
	 * 获取：商品介绍
	 */

    public void setDangaoContent(String dangaoContent) {
        this.dangaoContent = dangaoContent;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getDangaoDelete() {
        return dangaoDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setDangaoDelete(Integer dangaoDelete) {
        this.dangaoDelete = dangaoDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
