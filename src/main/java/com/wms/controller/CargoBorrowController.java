package com.wms.controller;

import com.wms.bean.Cargo;
import com.wms.bean.CargoBorrow;
import com.wms.bean.vo.UserVo;
import com.wms.commons.base.BaseController;
import com.wms.commons.utils.PageInfo;
import com.wms.service.CargoBorrowService;
import com.wms.service.CargoService;
import com.wms.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 货品借出登记
 * Created by DengMin on 2016/12/21.
 */
@Controller
@RequestMapping("/borrow")
public class CargoBorrowController extends BaseController{

    @Autowired
    private CargoBorrowService cargoborrowservice;

    @Autowired
    private IUserService iUserService;

    @Autowired
    private CargoService cargoService;

    /**
     * 跳转到货品借出登记页面
     * @return
     */
    @GetMapping("/borrowpage")
    public String borrowpage(){
        return "adjustment/cargoborrow";
    }

    /**
     * 跳转到添加页面
     * @return
     */
    @GetMapping("/borrowaddpage")
    public String borrowaddpage(){
        return "adjustment/cargoborrowadd";
    }

    /**
     * 跳转到修改页面
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/editPage")
    public String editPage(Integer id, Model model){
        CargoBorrow cargoBorrow = cargoborrowservice.selectByPrimaryKey(id);
        model.addAttribute("cargoBorrow",cargoBorrow);
        return "adjustment/cargoborrowedit";
    }

    /**
     * 新增货品借出
     * @param cargoBorrow
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public Object add(CargoBorrow cargoBorrow,@RequestParam("status") String status){
        Cargo cargo = cargoService.selectByPrimaryKey(cargoBorrow.getCbId());
        Cargo c = new Cargo();
        if(cargo.getcNum() != cargoBorrow.getCbNum().intValue()){
            if(status.equals("1")){
                cargoBorrow.setCbStatus("0");//0代表未归还
                int result = cargoborrowservice.insert(cargoBorrow);
                if(result > 0){
                    /**
                     * 数量（数量等于货物数量-借用数量）
                     * 体积（总数量-借用数量*单个货物体积）
                     * 重量（总重量-借用数量*单个货物总量）
                     */
                    c.setcNum(cargo.getcNum()-cargoBorrow.getCbNum().intValue());//数量
                    c.setcTotalvolume(cargo.getcTotalvolume()-cargoBorrow.getCbNum()*(cargo.getcTotalvolume()/cargo.getcNum()));//体积
                    c.setcTotalweight(cargo.getcTotalweight()-cargoBorrow.getCbNum()*(cargo.getcTotalweight()/cargo.getcNum()));//重量
                    c.setcId(cargoBorrow.getCbId());
                    cargoService.updateByPrimaryKeySelective(c);
                    return renderSuccess("添加成功");
                }else{
                    return renderError("添加失败");
                }
            }
        }else if(status.equals("0")){
            cargoBorrow.setCbStatus("1");//代表已归还
            int result = cargoborrowservice.updateByPrimaryKey(cargoBorrow);
            if(result > 0){
                /**
                 * 数量（数量等于货物数量+借用数量）
                 * 体积（剩余数量+借用数量*单个货物体积）
                 * 重量（剩余重量+借用数量*单个货物总量）
                 */
                c.setcNum(cargo.getcNum()+cargoBorrow.getCbNum().intValue());//数量
                c.setcTotalvolume(cargo.getcTotalvolume()+cargoBorrow.getCbNum()*(cargo.getcTotalvolume()/cargo.getcNum()));//体积
                c.setcTotalweight(cargo.getcTotalweight()+cargoBorrow.getCbNum()*(cargo.getcTotalweight()/cargo.getcNum()));//重量
                c.setcId(cargoBorrow.getCbId());
                cargoService.updateByPrimaryKeySelective(c);
                return renderSuccess("归还成功");
            }
        }else{
            if(status.equals("1")){
                cargoBorrow.setCbStatus("2");//2代表全部借出未归还
                int result = cargoborrowservice.insert(cargoBorrow);
                if(result > 0){
                    /**
                     * 数量（数量等于货物数量-借用数量）
                     */
                    c.setcNum(cargo.getcNum()-cargoBorrow.getCbNum().intValue());//数量
                    c.setcId(cargoBorrow.getCbId());
                    cargoService.updatenum(c);
                    return renderSuccess("添加成功");
                }
            }else{
                cargoBorrow.setCbStatus("1");
                int result = cargoborrowservice.updateByPrimaryKey(cargoBorrow);
                if(result > 0){
                    c.setcNum(cargoBorrow.getCbNum().intValue());
                    c.setcId(cargoBorrow.getCbId());
                    cargoService.updatenum(c);
                }
                return renderSuccess("归还成功");
            }
        }
        return null;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public Object deleteByPrimaryKey(Integer id){
        int result = cargoborrowservice.deleteByPrimaryKey(id);
        if(result > 0){
            return renderSuccess("删除成功");
        }
        return  renderError("删除失败");
    }

    /**
     * 分页查询
     * @param cargoBorrow
     * @param page
     * @param rows
     * @return
     */
    @PostMapping("/selectByPage")
    @ResponseBody
    public Object select(CargoBorrow cargoBorrow,Integer page, Integer rows){
        PageInfo pageInfo = new PageInfo(page,rows);
        Map<String,Object> map = new HashMap<String,Object>();
        if(cargoBorrow.getCbSkumodel() != null){
            map.put("CBSK",cargoBorrow.getCbSkumodel());
        }
        if(cargoBorrow.getCreatedateStart() != null){
            map.put("startTime",cargoBorrow.getCreatedateStart());
        }
        if(cargoBorrow.getCreatedateEnd() != null){
            map.put("endTime",cargoBorrow.getCreatedateEnd());
        }
        pageInfo.setCondition(map);
        cargoborrowservice.select(pageInfo);
        return pageInfo;
    }

    /**
     * 普通用户分页查询
     * @param userVo
     * @return
     */
    @RequestMapping("/user")
    @ResponseBody
    public Object SelectUserBytype(UserVo userVo){
        Map<String,Object> map = new HashMap<>();
        if(userVo.getName() != null){
            map.put("name",userVo.getName());
        }
        List<UserVo> list = iUserService.selectUserBytype(map);
        return list;
    }

}
