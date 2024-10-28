package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.DianyuanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 店员
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("dianyuan")
public class DianyuanView extends DianyuanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 店员类型的值
	*/
	@ColumnInfo(comment="店员类型的字典表值",type="varchar(200)")
	private String dianyuanValue;




	public DianyuanView() {

	}

	public DianyuanView(DianyuanEntity dianyuanEntity) {
		try {
			BeanUtils.copyProperties(this, dianyuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
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




	@Override
	public String toString() {
		return "DianyuanView{" +
			", dianyuanValue=" + dianyuanValue +
			"} " + super.toString();
	}
}
