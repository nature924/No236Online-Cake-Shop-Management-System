package com.entity.model;

import com.entity.DangaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 商品
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class DangaoModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 商品名称
     */
    private String dangaoName;


    /**
     * 商品编号
     */
    private String dangaoUuidNumber;


    /**
     * 商品照片
     */
    private String dangaoPhoto;


    /**
     * 商品类型
     */
    private Integer dangaoTypes;


    /**
     * 商品库存
     */
    private Integer dangaoKucunNumber;


    /**
     * 购买获得积分
     */
    private Integer dangaoPrice;


    /**
     * 商品原价
     */
    private Double dangaoOldMoney;


    /**
     * 现价
     */
    private Double dangaoNewMoney;


    /**
     * 商品热度
     */
    private Integer dangaoClicknum;


    /**
     * 商品介绍
     */
    private String dangaoContent;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    private Integer dangaoDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
