package com.wms.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.wms.bean.Godown;
import com.wms.bean.MakeInventory;
import com.wms.commons.utils.ExcelToDisk;
import com.wms.service.GodownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wms.bean.Cargo;
import com.wms.commons.base.BaseController;
import com.wms.commons.utils.OrderNumberUtil;
import com.wms.commons.utils.PageInfo;
import com.wms.service.CargoService;

import javax.servlet.http.HttpServletResponse;

/**
 * cargo货物表
 * Created by DengMin on 2016/12/26.
 */
@Controller
@RequestMapping("/cargo")
public class CargoController extends BaseController{

    @Autowired
    private CargoService cargoService;

    @Autowired
    private GodownService godownService;

    /**
     * 跳转到cargo页面
     * @return
     */
    @GetMapping("/cargopage")
    public String cargopage(){
        return "adjustment/cargo";
    }

    /**
     * 跳转到cargoedit页面
     * @return
     */
    @GetMapping("/cargoeditpage")
    public String cargoeditpage(Integer id, Model model){
        Cargo cargo = cargoService.selectByPrimaryKey(id);
        model.addAttribute("cargo",cargo);
        return "adjustment/cargoedit";
    }

    /**
     * 跳转到cargodd页面
     * @return
     */
    @GetMapping("/cargoddpage")
    public String cargoddpage(){
        return "adjustment/cargodd";
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @RequestMapping("/deletepk")
    @ResponseBody
    public Object deleteByPrimaryKey(Integer id){
        int result = cargoService.deleteByPrimaryKey(id);
        if(result > 0){
            return renderSuccess("删除成功");
        }
        return renderError("删除失败");
    }

    /**
     * 添加
     * @param cargo
     * @return
     */
    @RequestMapping("/insert")
    @ResponseBody
    public Object insert(Cargo cargo){
        cargo.setcShippingno(OrderNumberUtil.generateOrderNo());
        int result = cargoService.insert(cargo);
        if(result > 0){
            return renderSuccess("添加成功");
        }
        return renderError("添加失败");
    }

    /**
     * 分页查询
     * @param cargo
     * @return
     */
    @RequestMapping("/select")
    @ResponseBody
    public Object select(Cargo cargo,Integer rows,Integer page){
        PageInfo pageInfo = new PageInfo(page,rows);
        Map<String,Object> map = new HashMap<String,Object>();
        if(cargo.getcSkumodel() != null){
            map.put("SKM",cargo.getcSkumodel());
        }
        if(cargo.getCreatedateStart() != null){
            map.put("start" ,cargo.getCreatedateStart());
        }
        if(cargo.getCreatedateEnd() != null){
            map.put("end" ,cargo.getCreatedateEnd());
        }
        pageInfo.setCondition(map);
        cargoService.select(pageInfo);
        return pageInfo;
    }

    /**
     *修改
     * @param cargo
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public Object update(Cargo cargo){
        int result = cargoService.updateByPrimaryKey(cargo);
        if(result > 0){
            return renderSuccess("修改成功");
        }
        return renderError("修改失败");
    }

    /**
     * @param resp
     */
    @RequestMapping("/ToDiskExcelAll")
    @ResponseBody
    public void ToDiskExcelAll(@RequestParam("cName") String cName,@RequestParam("cStorerid") String cStorerid,@RequestParam("cWhid") String cWhid,@RequestParam("cNum") String cNum,@RequestParam("cTotalweight") String cTotalweight
            ,@RequestParam("cTotalvolume") String cTotalvolume,@RequestParam("cSkumodel") String cSkumodel,@RequestParam("cPhone") String cPhone, HttpServletResponse resp){
        ExcelToDisk<Cargo> ex = new ExcelToDisk<Cargo>();
        String [] title = {"货物名称","货主","货主号码","出库单号","仓库编码","数量","总货毛重","总货体积","入库时间","货物型号"};
        String cShippingno = OrderNumberUtil.generateOrderNo();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Godown godown = godownService.selectByPrimaryKey(Integer.valueOf(cWhid));
        Object data [] = {cName,cStorerid,cPhone,cShippingno,godown.getGoWhid(),cNum,cTotalweight,cTotalvolume,s.format(new Date()),cSkumodel};
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
        ex.Excel(data,"货物出库单"+sdf.format(new Date())+".xls",title,resp);
    }

}
