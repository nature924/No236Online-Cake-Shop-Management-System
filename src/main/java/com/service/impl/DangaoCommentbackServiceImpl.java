package com.service.impl;

import com.utils.StringUtil;
import com.service.DictionaryService;
import com.utils.ClazzDiff;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import com.dao.DangaoCommentbackDao;
import com.entity.DangaoCommentbackEntity;
import com.service.DangaoCommentbackService;
import com.entity.view.DangaoCommentbackView;

/**
 * 商品评价 服务实现类
 */
@Service("dangaoCommentbackService")
@Transactional
public class DangaoCommentbackServiceImpl extends ServiceImpl<DangaoCommentbackDao, DangaoCommentbackEntity> implements DangaoCommentbackService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<DangaoCommentbackView> page =new Query<DangaoCommentbackView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
