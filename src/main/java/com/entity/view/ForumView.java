package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ForumEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 论坛
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("forum")
public class ForumView extends ForumEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 帖子状态的值
	*/
	@ColumnInfo(comment="帖子状态的字典表值",type="varchar(200)")
	private String forumStateValue;

	//级联表 店员
		/**
		* 店员名称
		*/

		@ColumnInfo(comment="店员名称",type="varchar(200)")
		private String dianyuanName;
		/**
		* 联系方式
		*/

		@ColumnInfo(comment="联系方式",type="varchar(200)")
		private String dianyuanPhone;
		/**
		* 邮箱
		*/

		@ColumnInfo(comment="邮箱",type="varchar(200)")
		private String dianyuanEmail;
		/**
		* 店员类型
		*/
		@ColumnInfo(comment="店员类型",type="int(11)")
		private Integer dianyuanTypes;
			/**
			* 店员类型的值
			*/
			@ColumnInfo(comment="店员类型的字典表值",type="varchar(200)")
			private String dianyuanValue;
		/**
		* 店员介绍
		*/

		@ColumnInfo(comment="店员介绍",type="longtext")
		private String dianyuanContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer dianyuanDelete;
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
	//级联表 管理员
		/**
		* 用户名
		*/
		@ColumnInfo(comment="用户名",type="varchar(100)")
		private String uusername;
		/**
		* 密码
		*/
		@ColumnInfo(comment="密码",type="varchar(100)")
		private String upassword;
		/**
		* 角色
		*/
		@ColumnInfo(comment="角色",type="varchar(100)")
		private String urole;
		/**
		* 新增时间
		*/
		@ColumnInfo(comment="新增时间",type="timestamp")
		private Date uaddtime;



	public ForumView() {

	}

	public ForumView(ForumEntity forumEntity) {
		try {
			BeanUtils.copyProperties(this, forumEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 帖子状态的值
	*/
	public String getForumStateValue() {
		return forumStateValue;
	}
	/**
	* 设置： 帖子状态的值
	*/
	public void setForumStateValue(String forumStateValue) {
		this.forumStateValue = forumStateValue;
	}


	//级联表的get和set 店员

		/**
		* 获取： 店员名称
		*/
		public String getDianyuanName() {
			return dianyuanName;
		}
		/**
		* 设置： 店员名称
		*/
		public void setDianyuanName(String dianyuanName) {
			this.dianyuanName = dianyuanName;
		}

		/**
		* 获取： 联系方式
		*/
		public String getDianyuanPhone() {
			return dianyuanPhone;
		}
		/**
		* 设置： 联系方式
		*/
		public void setDianyuanPhone(String dianyuanPhone) {
			this.dianyuanPhone = dianyuanPhone;
		}

		/**
		* 获取： 邮箱
		*/
		public String getDianyuanEmail() {
			return dianyuanEmail;
		}
		/**
		* 设置： 邮箱
		*/
		public void setDianyuanEmail(String dianyuanEmail) {
			this.dianyuanEmail = dianyuanEmail;
		}
		/**
		* 获取： 店员类型
		*/
		public Integer getDianyuanTypes() {
			return dianyuanTypes;
		}
		/**
		* 设置： 店员类型
		*/
		public void setDianyuanTypes(Integer dianyuanTypes) {
			this.dianyuanTypes = dianyuanTypes;
		}


			/**
			* 获取： 店员类型的值
			*/
			public String getDianyuanValue() {
				return dianyuanValue;
			}
			/**
			* 设置： 店员类型的值
			*/
			public void setDianyuanValue(String dianyuanValue) {
				this.dianyuanValue = dianyuanValue;
			}

		/**
		* 获取： 店员介绍
		*/
		public String getDianyuanContent() {
			return dianyuanContent;
		}
		/**
		* 设置： 店员介绍
		*/
		public void setDianyuanContent(String dianyuanContent) {
			this.dianyuanContent = dianyuanContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getDianyuanDelete() {
			return dianyuanDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setDianyuanDelete(Integer dianyuanDelete) {
			this.dianyuanDelete = dianyuanDelete;
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
	//级联表的get和set 管理员
		/**
		* 获取： 用户名
		*/
		public String getUusername() {
			return uusername;
		}
		/**
		* 设置： 用户名
		*/
		public void setUusername(String uusername) {
			this.uusername = uusername;
		}
		/**
		* 获取： 密码
		*/
		public String getUpassword() {
			return upassword;
		}
		/**
		* 设置： 密码
		*/
		public void setUpassword(String upassword) {
			this.upassword = upassword;
		}
		/**
		* 获取： 角色
		*/
		public String getUrole() {
			return urole;
		}
		/**
		* 设置： 角色
		*/
		public void setUrole(String urole) {
			this.urole = urole;
		}
		/**
		* 获取： 新增时间
		*/
		public Date getUaddtime() {
			return uaddtime;
		}
		/**
		* 设置： 新增时间
		*/
		public void setUaddtime(Date uaddtime) {
			this.uaddtime = uaddtime;
		}


	@Override
	public String toString() {
		return "ForumView{" +
			", forumStateValue=" + forumStateValue +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", newMoney=" + newMoney +
			", yonghuSumJifen=" + yonghuSumJifen +
			", yonghuNewJifen=" + yonghuNewJifen +
			", dianyuanName=" + dianyuanName +
			", dianyuanPhone=" + dianyuanPhone +
			", dianyuanEmail=" + dianyuanEmail +
			", dianyuanContent=" + dianyuanContent +
			", dianyuanDelete=" + dianyuanDelete +
			"} " + super.toString();
	}
}
