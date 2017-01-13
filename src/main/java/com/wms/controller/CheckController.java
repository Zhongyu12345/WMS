package com.wms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wms.bean.GodownEntry;
import com.wms.bean.MakeInventory;
import com.wms.bean.Receiving;
import com.wms.commons.base.BaseController;
import com.wms.service.GodownEntryService;
import com.wms.service.MakeInventoryService;
import com.wms.service.ReceivingService;

@Controller
@RequestMapping("/check")
public class CheckController extends BaseController{
	
	@Autowired
	private GodownEntryService godownEntryService;
	
	@Autowired
	private ReceivingService recevingService;
	
	@Autowired
	private MakeInventoryService makeinventoryService;
	
	/**
     *跳转到盘点差异页面
     * @return
     */
    @GetMapping("/checkpage")
    public String page(){
        return "data/check";
    }
    
    /**
     *跳转到入库计划差异页面
     * @return
     */
    @GetMapping("/receivcheckpage")
    public String receivpage(){
        return "data/receivcheck";
    }
    
    /**
     * 入库计划差异数据
     * @return
     */
    @GetMapping("select")
    @ResponseBody
    public List<Object> select(@RequestParam(value = "checknum") String checknum){
    	GodownEntry godownEntry = godownEntryService.selectByNo(checknum);
    	Receiving receiving = recevingService.selectByNo(checknum);
    	List<Object> list = new ArrayList<Object>();
    	for(Object l:list){
    		System.out.println("-------------------"+l);
    	}
    	
    	list.add(godownEntry);
    	list.add(receiving);
    	ModelAndView model = new ModelAndView();
    	model.addObject("list", list);
    	model.setViewName("data/receivcheck");
    	return list;
    }
    
    /**
     * 盘点差异数据
     */
    @GetMapping("selectc")
    @ResponseBody
    public List<MakeInventory> selectCheck(@RequestParam(value = "checknum") String checknum){
    	List<MakeInventory> makeInventory = makeinventoryService.selectByOrder(checknum);
    	ModelAndView model = new ModelAndView();
    	model.addObject("makeInventory", makeInventory);
    	model.setViewName("data/check");
    	return makeInventory;
    }
}
