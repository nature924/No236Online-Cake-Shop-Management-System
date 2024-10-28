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
 * 店员
 *
 * @author 
 * @email
 */
@TableName("dianyuan")
public class DianyuanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public DianyuanEntity() {

	}

	public DianyuanEntity(T t) {
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
     * 账户
     */
    @ColumnInfo(comment="账户",type="varchar(200)")
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @ColumnInfo(comment="密码",type="varchar(200)")
    @TableField(value = "password")

    private String password;


    /**
     * 店员名称
     */
    @ColumnInfo(comment="店员名称",type="varchar(200)")
    @TableField(value = "dianyuan_name")

    private String dianyuanName;


    /**
     * 联系方式
     */
    @ColumnInfo(comment="联系方式",type="varchar(200)")
    @TableField(value = "dianyuan_phone")

    private String dianyuanPhone;


    /**
     * 邮箱
     */
    @ColumnInfo(comment="邮箱",type="varchar(200)")
    @TableField(value = "dianyuan_email")

    private String dianyuanEmail;


    /**
     * 店员类型
     */
    @ColumnInfo(comment="店员类型",type="int(11)")
    @TableField(value = "dianyuan_types")

    private Integer dianyuanTypes;


    /**
     * 店员介绍
     */
    @ColumnInfo(comment="店员介绍",type="longtext")
    @TableField(value = "dianyuan_content")

    private String dianyuanContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "dianyuan_delete")

    private Integer dianyuanDelete;


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
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }
    /**
	 * 设置：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }
    /**
	 * 设置：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：店员名称
	 */
    public String getDianyuanName() {
        return dianyuanName;
    }
    /**
	 * 设置：店员名称
	 */

    public void setDianyuanName(String dianyuanName) {
        this.dianyuanName = dianyuanName;
    }
    /**
	 * 获取：联系方式
	 */
    public String getDianyuanPhone() {
        return dianyuanPhone;
    }
    /**
	 * 设置：联系方式
	 */

    public void setDianyuanPhone(String dianyuanPhone) {
        this.dianyuanPhone = dianyuanPhone;
    }
    /**
	 * 获取：邮箱
	 */
    public String getDianyuanEmail() {
        return dianyuanEmail;
    }
    /**
	 * 设置：邮箱
	 */

    public void setDianyuanEmail(String dianyuanEmail) {
        this.dianyuanEmail = dianyuanEmail;
    }
    /**
	 * 获取：店员类型
	 */
    public Integer getDianyuanTypes() {
        return dianyuanTypes;
    }
    /**
	 * 设置：店员类型
	 */

    public void setDianyuanTypes(Integer dianyuanTypes) {
        this.dianyuanTypes = dianyuanTypes;
    }
    /**
	 * 获取：店员介绍
	 */
    public String getDianyuanContent() {
        return dianyuanContent;
    }
    /**
	 * 设置：店员介绍
	 */

    public void setDianyuanContent(String dianyuanContent) {
        this.dianyuanContent = dianyuanContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getDianyuanDelete() {
        return dianyuanDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setDianyuanDelete(Integer dianyuanDelete) {
        this.dianyuanDelete = dianyuanDelete;
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
        return "Dianyuan{" +
            ", id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", dianyuanName=" + dianyuanName +
            ", dianyuanPhone=" + dianyuanPhone +
            ", dianyuanEmail=" + dianyuanEmail +
            ", dianyuanTypes=" + dianyuanTypes +
            ", dianyuanContent=" + dianyuanContent +
            ", dianyuanDelete=" + dianyuanDelete +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
