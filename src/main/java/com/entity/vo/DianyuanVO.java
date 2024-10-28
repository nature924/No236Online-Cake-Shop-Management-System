package com.entity.vo;

import com.entity.DianyuanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 店员
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("dianyuan")
public class DianyuanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 店员名称
     */

    @TableField(value = "dianyuan_name")
    private String dianyuanName;


    /**
     * 联系方式
     */

    @TableField(value = "dianyuan_phone")
    private String dianyuanPhone;


    /**
     * 邮箱
     */

    @TableField(value = "dianyuan_email")
    private String dianyuanEmail;


    /**
     * 店员类型
     */

    @TableField(value = "dianyuan_types")
    private Integer dianyuanTypes;


    /**
     * 店员介绍
     */

    @TableField(value = "dianyuan_content")
    private String dianyuanContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "dianyuan_delete")
    private Integer dianyuanDelete;


    /**
     * 创建时间
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
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：店员名称
	 */
    public String getDianyuanName() {
        return dianyuanName;
    }


    /**
	 * 获取：店员名称
	 */

    public void setDianyuanName(String dianyuanName) {
        this.dianyuanName = dianyuanName;
    }
    /**
	 * 设置：联系方式
	 */
    public String getDianyuanPhone() {
        return dianyuanPhone;
    }


    /**
	 * 获取：联系方式
	 */

    public void setDianyuanPhone(String dianyuanPhone) {
        this.dianyuanPhone = dianyuanPhone;
    }
    /**
	 * 设置：邮箱
	 */
    public String getDianyuanEmail() {
        return dianyuanEmail;
    }


    /**
	 * 获取：邮箱
	 */

    public void setDianyuanEmail(String dianyuanEmail) {
        this.dianyuanEmail = dianyuanEmail;
    }
    /**
	 * 设置：店员类型
	 */
    public Integer getDianyuanTypes() {
        return dianyuanTypes;
    }


    /**
	 * 获取：店员类型
	 */

    public void setDianyuanTypes(Integer dianyuanTypes) {
        this.dianyuanTypes = dianyuanTypes;
    }
    /**
	 * 设置：店员介绍
	 */
    public String getDianyuanContent() {
        return dianyuanContent;
    }


    /**
	 * 获取：店员介绍
	 */

    public void setDianyuanContent(String dianyuanContent) {
        this.dianyuanContent = dianyuanContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getDianyuanDelete() {
        return dianyuanDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setDianyuanDelete(Integer dianyuanDelete) {
        this.dianyuanDelete = dianyuanDelete;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
