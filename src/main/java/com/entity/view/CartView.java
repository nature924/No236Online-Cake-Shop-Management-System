package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.CartEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 购物车
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("cart")
public class CartView extends CartEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

	//级联表 商品
		/**
		* 商品名称
		*/

		@ColumnInfo(comment="商品名称",type="varchar(200)")
		private String dangaoName;
		/**
		* 商品编号
		*/

		@ColumnInfo(comment="商品编号",type="varchar(200)")
		private String dangaoUuidNumber;
		/**
		* 商品照片
		*/

		@ColumnInfo(comment="商品照片",type="varchar(200)")
		private String dangaoPhoto;
		/**
		* 商品类型
		*/
		@ColumnInfo(comment="商品类型",type="int(11)")
		private Integer dangaoTypes;
			/**
			* 商品类型的值
			*/
			@ColumnInfo(comment="商品类型的字典表值",type="varchar(200)")
			private String dangaoValue;
		/**
		* 商品库存
		*/

		@ColumnInfo(comment="商品库存",type="int(11)")
		private Integer dangaoKucunNumber;
		/**
		* 购买获得积分
		*/

		@ColumnInfo(comment="购买获得积分",type="int(11)")
		private Integer dangaoPrice;
		/**
		* 商品原价
		*/
		@ColumnInfo(comment="商品原价",type="decimal(10,2)")
		private Double dangaoOldMoney;
		/**
		* 现价
		*/
		@ColumnInfo(comment="现价",type="decimal(10,2)")
		private Double dangaoNewMoney;
		/**
		* 商品热度
		*/

		@ColumnInfo(comment="商品热度",type="int(11)")
		private Integer dangaoClicknum;
		/**
		* 商品介绍
		*/

		@ColumnInfo(comment="商品介绍",type="longtext")
		private String dangaoContent;
		/**
		* 是否上架
		*/
		@ColumnInfo(comment="是否上架",type="int(11)")
		private Integer shangxiaTypes;
			/**
			* 是否上架的值
			*/
			@ColumnInfo(comment="是否上架的字典表值",type="varchar(200)")
			private String shangxiaValue;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer dangaoDelete;
	//级联表 用户
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 联系方式
		*/

		@ColumnInfo(comment="联系方式",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 身份证号
		*/

		@ColumnInfo(comment="身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 电子邮箱
		*/

		@ColumnInfo(comment="电子邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 余额
		*/
		@ColumnInfo(comment="余额",type="decimal(10,2)")
		private Double newMoney;
		/**
		* 总积分
		*/
		@ColumnInfo(comment="总积分",type="decimal(10,2)")
		private Double yonghuSumJifen;
		/**
		* 现积分
		*/
		@ColumnInfo(comment="现积分",type="decimal(10,2)")
		private Double yonghuNewJifen;
		/**
		* 会员等级
		*/
		@ColumnInfo(comment="会员等级",type="int(11)")
		private Integer huiyuandengjiTypes;
			/**
			* 会员等级的值
			*/
			@ColumnInfo(comment="会员等级的字典表值",type="varchar(200)")
			private String huiyuandengjiValue;



	public CartView() {

	}

	public CartView(CartEntity cartEntity) {
		try {
			BeanUtils.copyProperties(this, cartEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	//级联表的get和set 商品

		/**
		* 获取： 商品名称
		*/
		public String getDangaoName() {
			return dangaoName;
		}
		/**
		* 设置： 商品名称
		*/
		public void setDangaoName(String dangaoName) {
			this.dangaoName = dangaoName;
		}

		/**
		* 获取： 商品编号
		*/
		public String getDangaoUuidNumber() {
			return dangaoUuidNumber;
		}
		/**
		* 设置： 商品编号
		*/
		public void setDangaoUuidNumber(String dangaoUuidNumber) {
			this.dangaoUuidNumber = dangaoUuidNumber;
		}

		/**
		* 获取： 商品照片
		*/
		public String getDangaoPhoto() {
			return dangaoPhoto;
		}
		/**
		* 设置： 商品照片
		*/
		public void setDangaoPhoto(String dangaoPhoto) {
			this.dangaoPhoto = dangaoPhoto;
		}
		/**
		* 获取： 商品类型
		*/
		public Integer getDangaoTypes() {
			return dangaoTypes;
		}
		/**
		* 设置： 商品类型
		*/
		public void setDangaoTypes(Integer dangaoTypes) {
			this.dangaoTypes = dangaoTypes;
		}


			/**
			* 获取： 商品类型的值
			*/
			public String getDangaoValue() {
				return dangaoValue;
			}
			/**
			* 设置： 商品类型的值
			*/
			public void setDangaoValue(String dangaoValue) {
				this.dangaoValue = dangaoValue;
			}

		/**
		* 获取： 商品库存
		*/
		public Integer getDangaoKucunNumber() {
			return dangaoKucunNumber;
		}
		/**
		* 设置： 商品库存
		*/
		public void setDangaoKucunNumber(Integer dangaoKucunNumber) {
			this.dangaoKucunNumber = dangaoKucunNumber;
		}

		/**
		* 获取： 购买获得积分
		*/
		public Integer getDangaoPrice() {
			return dangaoPrice;
		}
		/**
		* 设置： 购买获得积分
		*/
		public void setDangaoPrice(Integer dangaoPrice) {
			this.dangaoPrice = dangaoPrice;
		}

		/**
		* 获取： 商品原价
		*/
		public Double getDangaoOldMoney() {
			return dangaoOldMoney;
		}
		/**
		* 设置： 商品原价
		*/
		public void setDangaoOldMoney(Double dangaoOldMoney) {
			this.dangaoOldMoney = dangaoOldMoney;
		}

		/**
		* 获取： 现价
		*/
		public Double getDangaoNewMoney() {
			return dangaoNewMoney;
		}
		/**
		* 设置： 现价
		*/
		public void setDangaoNewMoney(Double dangaoNewMoney) {
			this.dangaoNewMoney = dangaoNewMoney;
		}

		/**
		* 获取： 商品热度
		*/
		public Integer getDangaoClicknum() {
			return dangaoClicknum;
		}
		/**
		* 设置： 商品热度
		*/
		public void setDangaoClicknum(Integer dangaoClicknum) {
			this.dangaoClicknum = dangaoClicknum;
		}

		/**
		* 获取： 商品介绍
		*/
		public String getDangaoContent() {
			return dangaoContent;
		}
		/**
		* 设置： 商品介绍
		*/
		public void setDangaoContent(String dangaoContent) {
			this.dangaoContent = dangaoContent;
		}
		/**
		* 获取： 是否上架
		*/
		public Integer getShangxiaTypes() {
			return shangxiaTypes;
		}
		/**
		* 设置： 是否上架
		*/
		public void setShangxiaTypes(Integer shangxiaTypes) {
			this.shangxiaTypes = shangxiaTypes;
		}


			/**
			* 获取： 是否上架的值
			*/
			public String getShangxiaValue() {
				return shangxiaValue;
			}
			/**
			* 设置： 是否上架的值
			*/
			public void setShangxiaValue(String shangxiaValue) {
				this.shangxiaValue = shangxiaValue;
			}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getDangaoDelete() {
			return dangaoDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setDangaoDelete(Integer dangaoDelete) {
			this.dangaoDelete = dangaoDelete;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 联系方式
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 联系方式
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 电子邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 电子邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

		/**
		* 获取： 余额
		*/
		public Double getNewMoney() {
			return newMoney;
		}
		/**
		* 设置： 余额
		*/
		public void setNewMoney(Double newMoney) {
			this.newMoney = newMoney;
		}

		/**
		* 获取： 总积分
		*/
		public Double getYonghuSumJifen() {
			return yonghuSumJifen;
		}
		/**
		* 设置： 总积分
		*/
		public void setYonghuSumJifen(Double yonghuSumJifen) {
			this.yonghuSumJifen = yonghuSumJifen;
		}

		/**
		* 获取： 现积分
		*/
		public Double getYonghuNewJifen() {
			return yonghuNewJifen;
		}
		/**
		* 设置： 现积分
		*/
		public void setYonghuNewJifen(Double yonghuNewJifen) {
			this.yonghuNewJifen = yonghuNewJifen;
		}
		/**
		* 获取： 会员等级
		*/
		public Integer getHuiyuandengjiTypes() {
			return huiyuandengjiTypes;
		}
		/**
		* 设置： 会员等级
		*/
		public void setHuiyuandengjiTypes(Integer huiyuandengjiTypes) {
			this.huiyuandengjiTypes = huiyuandengjiTypes;
		}


			/**
			* 获取： 会员等级的值
			*/
			public String getHuiyuandengjiValue() {
				return huiyuandengjiValue;
			}
			/**
			* 设置： 会员等级的值
			*/
			public void setHuiyuandengjiValue(String huiyuandengjiValue) {
				this.huiyuandengjiValue = huiyuandengjiValue;
			}


	@Override
	public String toString() {
		return "CartView{" +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", newMoney=" + newMoney +
			", yonghuSumJifen=" + yonghuSumJifen +
			", yonghuNewJifen=" + yonghuNewJifen +
			", dangaoName=" + dangaoName +
			", dangaoUuidNumber=" + dangaoUuidNumber +
			", dangaoPhoto=" + dangaoPhoto +
			", dangaoKucunNumber=" + dangaoKucunNumber +
			", dangaoPrice=" + dangaoPrice +
			", dangaoOldMoney=" + dangaoOldMoney +
			", dangaoNewMoney=" + dangaoNewMoney +
			", dangaoClicknum=" + dangaoClicknum +
			", dangaoContent=" + dangaoContent +
			", dangaoDelete=" + dangaoDelete +
			"} " + super.toString();
	}
}
