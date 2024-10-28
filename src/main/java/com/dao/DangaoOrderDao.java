package com.dao;

import com.entity.DangaoOrderEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.DangaoOrderView;

/**
 * 商品订单 Dao 接口
 *
 * @author 
 */
public interface DangaoOrderDao extends BaseMapper<DangaoOrderEntity> {

   List<DangaoOrderView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
