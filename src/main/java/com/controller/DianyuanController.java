
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
 * 店员
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/dianyuan")
public class DianyuanController {
    private static final Logger logger = LoggerFactory.getLogger(DianyuanController.class);

    private static final String TABLE_NAME = "dianyuan";

    @Autowired
    private DianyuanService dianyuanService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private AddressService addressService;//收货地址
    @Autowired
    private CartService cartService;//购物车
    @Autowired
    private DangaoService dangaoService;//商品
    @Autowired
    private DangaoCollectionService dangaoCollectionService;//商品收藏
    @Autowired
    private DangaoCommentbackService dangaoCommentbackService;//商品评价
    @Autowired
    private DangaoOrderService dangaoOrderService;//商品订单
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
        params.put("dianyuanDeleteStart",1);params.put("dianyuanDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = dianyuanService.queryPage(params);

        //字典表数据转换
        List<DianyuanView> list =(List<DianyuanView>)page.getList();
        for(DianyuanView c:list){
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
        DianyuanEntity dianyuan = dianyuanService.selectById(id);
        if(dianyuan !=null){
            //entity转view
            DianyuanView view = new DianyuanView();
            BeanUtils.copyProperties( dianyuan , view );//把实体数据重构到view中
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
    public R save(@RequestBody DianyuanEntity dianyuan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,dianyuan:{}",this.getClass().getName(),dianyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<DianyuanEntity> queryWrapper = new EntityWrapper<DianyuanEntity>()
            .eq("username", dianyuan.getUsername())
            .or()
            .eq("dianyuan_phone", dianyuan.getDianyuanPhone())
            .eq("dianyuan_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DianyuanEntity dianyuanEntity = dianyuanService.selectOne(queryWrapper);
        if(dianyuanEntity==null){
            dianyuan.setDianyuanDelete(1);
            dianyuan.setCreateTime(new Date());
            dianyuan.setPassword("123456");
            dianyuanService.insert(dianyuan);
            return R.ok();
        }else {
            return R.error(511,"账户或者联系方式已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody DianyuanEntity dianyuan, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,dianyuan:{}",this.getClass().getName(),dianyuan.toString());
        DianyuanEntity oldDianyuanEntity = dianyuanService.selectById(dianyuan.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");

            dianyuanService.updateById(dianyuan);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<DianyuanEntity> oldDianyuanList =dianyuanService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<DianyuanEntity> list = new ArrayList<>();
        for(Integer id:ids){
            DianyuanEntity dianyuanEntity = new DianyuanEntity();
            dianyuanEntity.setId(id);
            dianyuanEntity.setDianyuanDelete(2);
            list.add(dianyuanEntity);
        }
        if(list != null && list.size() >0){
            dianyuanService.updateBatchById(list);
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
            List<DianyuanEntity> dianyuanList = new ArrayList<>();//上传的东西
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
                            DianyuanEntity dianyuanEntity = new DianyuanEntity();
//                            dianyuanEntity.setUsername(data.get(0));                    //账户 要改的
//                            dianyuanEntity.setPassword("123456");//密码
//                            dianyuanEntity.setDianyuanName(data.get(0));                    //店员名称 要改的
//                            dianyuanEntity.setDianyuanPhone(data.get(0));                    //联系方式 要改的
//                            dianyuanEntity.setDianyuanEmail(data.get(0));                    //邮箱 要改的
//                            dianyuanEntity.setDianyuanTypes(Integer.valueOf(data.get(0)));   //店员类型 要改的
//                            dianyuanEntity.setDianyuanContent("");//详情和图片
//                            dianyuanEntity.setDianyuanDelete(1);//逻辑删除字段
//                            dianyuanEntity.setCreateTime(date);//时间
                            dianyuanList.add(dianyuanEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //联系方式
                                if(seachFields.containsKey("dianyuanPhone")){
                                    List<String> dianyuanPhone = seachFields.get("dianyuanPhone");
                                    dianyuanPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> dianyuanPhone = new ArrayList<>();
                                    dianyuanPhone.add(data.get(0));//要改的
                                    seachFields.put("dianyuanPhone",dianyuanPhone);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<DianyuanEntity> dianyuanEntities_username = dianyuanService.selectList(new EntityWrapper<DianyuanEntity>().in("username", seachFields.get("username")).eq("dianyuan_delete", 1));
                        if(dianyuanEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(DianyuanEntity s:dianyuanEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //联系方式
                        List<DianyuanEntity> dianyuanEntities_dianyuanPhone = dianyuanService.selectList(new EntityWrapper<DianyuanEntity>().in("dianyuan_phone", seachFields.get("dianyuanPhone")).eq("dianyuan_delete", 1));
                        if(dianyuanEntities_dianyuanPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(DianyuanEntity s:dianyuanEntities_dianyuanPhone){
                                repeatFields.add(s.getDianyuanPhone());
                            }
                            return R.error(511,"数据库的该表中的 [联系方式] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        dianyuanService.insertBatch(dianyuanList);
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
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        DianyuanEntity dianyuan = dianyuanService.selectOne(new EntityWrapper<DianyuanEntity>().eq("username", username));
        if(dianyuan==null || !dianyuan.getPassword().equals(password))
            return R.error("账号或密码不正确");
        else if(dianyuan.getDianyuanDelete() != 1)
            return R.error("账户已被删除");
        String token = tokenService.generateToken(dianyuan.getId(),username, "dianyuan", "店员");
        R r = R.ok();
        r.put("token", token);
        r.put("role","店员");
        r.put("username",dianyuan.getDianyuanName());
        r.put("tableName","dianyuan");
        r.put("userId",dianyuan.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody DianyuanEntity dianyuan, HttpServletRequest request) {
//    	ValidatorUtils.validateEntity(user);
        Wrapper<DianyuanEntity> queryWrapper = new EntityWrapper<DianyuanEntity>()
            .eq("username", dianyuan.getUsername())
            .or()
            .eq("dianyuan_phone", dianyuan.getDianyuanPhone())
            .andNew()
            .eq("dianyuan_delete", 1)
            ;
        DianyuanEntity dianyuanEntity = dianyuanService.selectOne(queryWrapper);
        if(dianyuanEntity != null)
            return R.error("账户或者联系方式已经被使用");
        dianyuan.setDianyuanDelete(1);
        dianyuan.setCreateTime(new Date());
        dianyuanService.insert(dianyuan);

        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id, HttpServletRequest request) {
        DianyuanEntity dianyuan = dianyuanService.selectById(id);
        dianyuan.setPassword("123456");
        dianyuanService.updateById(dianyuan);
        return R.ok();
    }

	/**
	 * 修改密码
	 */
	@GetMapping(value = "/updatePassword")
	public R updatePassword(String  oldPassword, String  newPassword, HttpServletRequest request) {
        DianyuanEntity dianyuan = dianyuanService.selectById((Integer)request.getSession().getAttribute("userId"));
		if(newPassword == null){
			return R.error("新密码不能为空") ;
		}
		if(!oldPassword.equals(dianyuan.getPassword())){
			return R.error("原密码输入错误");
		}
		if(newPassword.equals(dianyuan.getPassword())){
			return R.error("新密码不能和原密码一致") ;
		}
        dianyuan.setPassword(newPassword);
		dianyuanService.updateById(dianyuan);
		return R.ok();
	}



    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        DianyuanEntity dianyuan = dianyuanService.selectOne(new EntityWrapper<DianyuanEntity>().eq("username", username));
        if(dianyuan!=null){
            dianyuan.setPassword("123456");
            dianyuanService.updateById(dianyuan);
            return R.ok();
        }else{
           return R.error("账号不存在");
        }
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrDianyuan(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        DianyuanEntity dianyuan = dianyuanService.selectById(id);
        if(dianyuan !=null){
            //entity转view
            DianyuanView view = new DianyuanView();
            BeanUtils.copyProperties( dianyuan , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }



    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = dianyuanService.queryPage(params);

        //字典表数据转换
        List<DianyuanView> list =(List<DianyuanView>)page.getList();
        for(DianyuanView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        DianyuanEntity dianyuan = dianyuanService.selectById(id);
            if(dianyuan !=null){


                //entity转view
                DianyuanView view = new DianyuanView();
                BeanUtils.copyProperties( dianyuan , view );//把实体数据重构到view中

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
    public R add(@RequestBody DianyuanEntity dianyuan, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,dianyuan:{}",this.getClass().getName(),dianyuan.toString());
        Wrapper<DianyuanEntity> queryWrapper = new EntityWrapper<DianyuanEntity>()
            .eq("username", dianyuan.getUsername())
            .or()
            .eq("dianyuan_phone", dianyuan.getDianyuanPhone())
            .andNew()
            .eq("dianyuan_delete", 1)
//            .notIn("dianyuan_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DianyuanEntity dianyuanEntity = dianyuanService.selectOne(queryWrapper);
        if(dianyuanEntity==null){
            dianyuan.setDianyuanDelete(1);
            dianyuan.setCreateTime(new Date());
            dianyuan.setPassword("123456");
        dianyuanService.insert(dianyuan);

            return R.ok();
        }else {
            return R.error(511,"账户或者联系方式已经被使用");
        }
    }

}

