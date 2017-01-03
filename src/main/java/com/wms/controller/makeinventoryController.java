package com.wms.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wms.commons.utils.ReadXls;
import com.wms.commons.utils.TimeUtils;
import jxl.Workbook;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.apache.commons.fileupload.util.Streams;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.wms.bean.MakeInventory;
import com.wms.commons.base.BaseController;
import com.wms.commons.utils.ExcelToDisk;
import com.wms.commons.utils.PageInfo;
import com.wms.service.MakeInventoryService;
import org.springframework.web.multipart.MultipartFile;

/**
 * 盘点单管理
 * Created by DengMin on 2016/12/23.
 */

@Controller
@RequestMapping("/make")
public class makeinventoryController extends BaseController{

    @Autowired
    private MakeInventoryService makeInventoryService;

    @GetMapping("/selectpage")
    private String selectpage(){
        return "adjustment/makeinventory";
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/deletepk")
    @ResponseBody
    public Object deleteByPrimaryKey(Integer id){
        int result = makeInventoryService.deleteByPrimaryKey(id);
        if(result > 0){
            return renderSuccess("删除成功");
        }
        return renderError("删除失败");
    }

    /**
     * 新增
     * @param m
     * @return
     */
    @RequestMapping("/insert")
    @ResponseBody
    public Object insert(MakeInventory m){
        int result = makeInventoryService.insert(m);
        if(result  > 0){
            return renderSuccess("添加成功");
        }
        return renderError("添加失败");
    }

    /**
     * 分页查询
     * @param page
     * @param rows
     * @param m
     * @return
     */
    @RequestMapping("/select")
    @ResponseBody
    public Object select(Integer page,Integer rows,MakeInventory m){
        PageInfo pageInfo = new PageInfo(page,rows);
        Map<String,Object> map = new HashMap<>();
        if(m.getMiSkumodel() != null){
            map.put("SKM",m.getMiSkumodel());
        }
        if(m.getCreateState() != null){
            map.put("stateTime",m.getCreateState());
        }
        if(m.getCreateEnd() != null){
            map.put("endTime",m.getCreateEnd());
        }
        pageInfo.setCondition(map);
        makeInventoryService.select(pageInfo);
        return pageInfo;
    }


    /**
     *导出excel表
     * @param data
     * @param resp
     */
    @RequestMapping("/ToDiskExcel")
    @ResponseBody
    public void ToDiskExcel(@RequestParam("data") Object data[], HttpServletResponse resp){
        ExcelToDisk<MakeInventory> ex = new ExcelToDisk<MakeInventory>();
        String [] title = {"ID","货物名称","货物型号","盘点数量","实际盘点数量","盘点人","仓库编号"};
        ex.Excel(data,"Makeinventory.xls",title,resp);
    }

    /**
     * 读取excel表
     * @param file
     * @param req
     */
    @RequestMapping("/ReadExcle")
    public String ReadExcle(@RequestParam("file")MultipartFile file, HttpServletRequest req){
        try {
            String path =  (makeinventoryController.class.getResource("/").toString()).substring(6);
            if(!file.isEmpty()){
                Streams.copy(file.getInputStream(),new FileOutputStream(path+"/"+file.getOriginalFilename()),true);
            }
            URL url= makeinventoryController.class.getResource("/"+file.getOriginalFilename());
            List<List<String>> list = ReadXls.readxls(url.getFile());
            MakeInventory makeInventory = new MakeInventory();
            List<String> l = list.get(0);
            for(int i=0;i<l.size();i++){
                makeInventory.setMiName(l.get(1).toString());
                makeInventory.setMiSkumodel(l.get(6).toString());
                makeInventory.setMiNum(Double.valueOf(l.get(3).toString()));
                makeInventory.setMiActual(Double.valueOf(l.get(4).toString()));
                makeInventory.setMiNames(l.get(5).toString());
                makeInventory.setMiWhid(l.get(2).toString());
                makeInventory.setMiTime(new Date());
            }
            int result = makeInventoryService.insert(makeInventory);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "adjustment/makeinventory";
    }

}
