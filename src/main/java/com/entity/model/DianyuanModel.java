package com.entity.model;

import com.entity.DianyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 店员
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class DianyuanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 店员名称
     */
    private String dianyuanName;


    /**
     * 联系方式
     */
    private String dianyuanPhone;


    /**
     * 邮箱
     */
    private String dianyuanEmail;


    /**
     * 店员类型
     */
    private Integer dianyuanTypes;


    /**
     * 店员介绍
     */
    private String dianyuanContent;


    /**
     * 逻辑删除
     */
    private Integer dianyuanDelete;


    /**
     * 创建时间
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

    }
