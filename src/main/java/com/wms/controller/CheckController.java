package com.wms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wms.bean.GodownEntry;
import com.wms.commons.base.BaseController;
import com.wms.service.GodownEntryService;

@Controller
@RequestMapping("/check")
public class CheckController extends BaseController{
	
	@Autowired
	private GodownEntryService godownEntryService;
	
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
    public Object selectReceiv(Model model,@RequestParam(value = "checknum") String checknum){
    	GodownEntry godownEntry = godownEntryService.selectByNo(checknum);
    	model.addAttribute("godownEntry", godownEntry);
    	
    	return null;
    }
}
