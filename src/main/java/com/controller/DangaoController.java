
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 商品
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/dangao")
public class DangaoController {
    private static final Logger logger = LoggerFactory.getLogger(DangaoController.class);

    private static final String TABLE_NAME = "dangao";

    @Autowired
    private DangaoService dangaoService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private AddressService addressService;//收货地址
    @Autowired
    private CartService cartService;//购物车
    @Autowired
    private DangaoCollectionService dangaoCollectionService;//商品收藏
    @Autowired
    private DangaoCommentbackService dangaoCommentbackService;//商品评价
    @Autowired
    private DangaoOrderService dangaoOrderService;//商品订单
    @Autowired
    private DianyuanService dianyuanService;//店员
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private NewsService newsService;//公告信息
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("店员".equals(role))
            params.put("dianyuanId",request.getSession().getAttribute("userId"));
        params.put("dangaoDeleteStart",1);params.put("dangaoDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = dangaoService.queryPage(params);

        //字典表数据转换
        List<DangaoView> list =(List<DangaoView>)page.getList();
        for(DangaoView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        DangaoEntity dangao = dangaoService.selectById(id);
        if(dangao !=null){
            //entity转view
            DangaoView view = new DangaoView();
            BeanUtils.copyProperties( dangao , view );//把实体数据重构到view中
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody DangaoEntity dangao, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,dangao:{}",this.getClass().getName(),dangao.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<DangaoEntity> queryWrapper = new EntityWrapper<DangaoEntity>()
            .eq("dangao_name", dangao.getDangaoName())
            .eq("dangao_types", dangao.getDangaoTypes())
            .eq("dangao_kucun_number", dangao.getDangaoKucunNumber())
            .eq("dangao_price", dangao.getDangaoPrice())
            .eq("shangxia_types", dangao.getShangxiaTypes())
            .eq("dangao_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DangaoEntity dangaoEntity = dangaoService.selectOne(queryWrapper);
        if(dangaoEntity==null){
            dangao.setDangaoClicknum(1);
            dangao.setShangxiaTypes(1);
            dangao.setDangaoDelete(1);
            dangao.setInsertTime(new Date());
            dangao.setCreateTime(new Date());
            dangaoService.insert(dangao);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody DangaoEntity dangao, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,dangao:{}",this.getClass().getName(),dangao.toString());
        DangaoEntity oldDangaoEntity = dangaoService.selectById(dangao.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(dangao.getDangaoPhoto()) || "null".equals(dangao.getDangaoPhoto())){
                dangao.setDangaoPhoto(null);
        }

            dangaoService.updateById(dangao);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<DangaoEntity> oldDangaoList =dangaoService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<DangaoEntity> list = new ArrayList<>();
        for(Integer id:ids){
            DangaoEntity dangaoEntity = new DangaoEntity();
            dangaoEntity.setId(id);
            dangaoEntity.setDangaoDelete(2);
            list.add(dangaoEntity);
        }
        if(list != null && list.size() >0){
            dangaoService.updateBatchById(list);
        }

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<DangaoEntity> dangaoList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            DangaoEntity dangaoEntity = new DangaoEntity();
//                            dangaoEntity.setDangaoName(data.get(0));                    //商品名称 要改的
//                            dangaoEntity.setDangaoUuidNumber(data.get(0));                    //商品编号 要改的
//                            dangaoEntity.setDangaoPhoto("");//详情和图片
//                            dangaoEntity.setDangaoTypes(Integer.valueOf(data.get(0)));   //商品类型 要改的
//                            dangaoEntity.setDangaoKucunNumber(Integer.valueOf(data.get(0)));   //商品库存 要改的
//                            dangaoEntity.setDangaoPrice(Integer.valueOf(data.get(0)));   //购买获得积分 要改的
//                            dangaoEntity.setDangaoOldMoney(data.get(0));                    //商品原价 要改的
//                            dangaoEntity.setDangaoNewMoney(data.get(0));                    //现价 要改的
//                            dangaoEntity.setDangaoClicknum(Integer.valueOf(data.get(0)));   //商品热度 要改的
//                            dangaoEntity.setDangaoContent("");//详情和图片
//                            dangaoEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            dangaoEntity.setDangaoDelete(1);//逻辑删除字段
//                            dangaoEntity.setInsertTime(date);//时间
//                            dangaoEntity.setCreateTime(date);//时间
                            dangaoList.add(dangaoEntity);


                            //把要查询是否重复的字段放入map中
                                //商品编号
                                if(seachFields.containsKey("dangaoUuidNumber")){
                                    List<String> dangaoUuidNumber = seachFields.get("dangaoUuidNumber");
                                    dangaoUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> dangaoUuidNumber = new ArrayList<>();
                                    dangaoUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("dangaoUuidNumber",dangaoUuidNumber);
                                }
                        }

                        //查询是否重复
                         //商品编号
                        List<DangaoEntity> dangaoEntities_dangaoUuidNumber = dangaoService.selectList(new EntityWrapper<DangaoEntity>().in("dangao_uuid_number", seachFields.get("dangaoUuidNumber")).eq("dangao_delete", 1));
                        if(dangaoEntities_dangaoUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(DangaoEntity s:dangaoEntities_dangaoUuidNumber){
                                repeatFields.add(s.getDangaoUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [商品编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        dangaoService.insertBatch(dangaoList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }



    /**
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<DangaoView> returnDangaoViewList = new ArrayList<>();

        //查询订单
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        PageUtils pageUtils = dangaoOrderService.queryPage(params1);
        List<DangaoOrderView> orderViewsList =(List<DangaoOrderView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(DangaoOrderView orderView:orderViewsList){
            Integer dangaoTypes = orderView.getDangaoTypes();
            if(typeMap.containsKey(dangaoTypes)){
                typeMap.put(dangaoTypes,typeMap.get(dangaoTypes)+1);
            }else{
                typeMap.put(dangaoTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("dangaoTypes",type);
            PageUtils pageUtils1 = dangaoService.queryPage(params2);
            List<DangaoView> dangaoViewList =(List<DangaoView>)pageUtils1.getList();
            returnDangaoViewList.addAll(dangaoViewList);
            if(returnDangaoViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = dangaoService.queryPage(params);
        if(returnDangaoViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnDangaoViewList.size();//要添加的数量
            List<DangaoView> dangaoViewList =(List<DangaoView>)page.getList();
            for(DangaoView dangaoView:dangaoViewList){
                Boolean addFlag = true;
                for(DangaoView returnDangaoView:returnDangaoViewList){
                    if(returnDangaoView.getId().intValue() ==dangaoView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnDangaoViewList.add(dangaoView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnDangaoViewList = returnDangaoViewList.subList(0, limit);
        }

        for(DangaoView c:returnDangaoViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnDangaoViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = dangaoService.queryPage(params);

        //字典表数据转换
        List<DangaoView> list =(List<DangaoView>)page.getList();
        for(DangaoView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        DangaoEntity dangao = dangaoService.selectById(id);
            if(dangao !=null){

                //点击数量加1
                dangao.setDangaoClicknum(dangao.getDangaoClicknum()+1);
                dangaoService.updateById(dangao);

                //entity转view
                DangaoView view = new DangaoView();
                BeanUtils.copyProperties( dangao , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody DangaoEntity dangao, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,dangao:{}",this.getClass().getName(),dangao.toString());
        Wrapper<DangaoEntity> queryWrapper = new EntityWrapper<DangaoEntity>()
            .eq("dangao_name", dangao.getDangaoName())
            .eq("dangao_uuid_number", dangao.getDangaoUuidNumber())
            .eq("dangao_types", dangao.getDangaoTypes())
            .eq("dangao_kucun_number", dangao.getDangaoKucunNumber())
            .eq("dangao_price", dangao.getDangaoPrice())
            .eq("dangao_clicknum", dangao.getDangaoClicknum())
            .eq("shangxia_types", dangao.getShangxiaTypes())
            .eq("dangao_delete", dangao.getDangaoDelete())
//            .notIn("dangao_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DangaoEntity dangaoEntity = dangaoService.selectOne(queryWrapper);
        if(dangaoEntity==null){
            dangao.setDangaoClicknum(1);
            dangao.setDangaoDelete(1);
            dangao.setInsertTime(new Date());
            dangao.setCreateTime(new Date());
        dangaoService.insert(dangao);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

