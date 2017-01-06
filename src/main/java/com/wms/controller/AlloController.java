package com.wms.controller;

import com.wms.bean.MakeInventory;
import com.wms.commons.base.BaseController;
import com.wms.commons.utils.ExcelToDisk;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 新增调拨单
 * Created by DengMin on 2017/1/6.
 */

@Controller
@RequestMapping("/allo")
public class AlloController extends BaseController{

    @GetMapping("/allpage")
    public String allopage(){
        return "adjustment/allo";
    }

    @RequestMapping("/ToDiskExcelout")
    public void ToDiskExcelout(@RequestParam("data") Object data[], HttpServletResponse resp){
        ExcelToDisk<MakeInventory> ex = new ExcelToDisk<MakeInventory>();
        String [] title = {"ID","货物名称","货物型号","仓库编号","实际盘点数量","盘点人"};
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
        ex.Excel(data,"调拨出库单"+sdf.format(new Date())+".xls",title,resp);
        ex.Excel(data,"调拨入库单"+sdf.format(new Date())+".xls",title,resp);
    }
}
