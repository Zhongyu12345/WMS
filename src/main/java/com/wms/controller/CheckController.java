package com.wms.controller;

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
import com.wms.commons.base.BaseController;
import com.wms.service.GodownEntryService;
import com.wms.service.MakeInventoryService;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/check")
public class CheckController extends BaseController{
	
	@Autowired
	private GodownEntryService godownEntryService;
	
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
    public Object selectReceiv(Model model,@RequestParam(value = "checknum") String checknum){
    	GodownEntry godownEntry = godownEntryService.selectByNo(checknum);
    	model.addAttribute("godownEntry", godownEntry);
    	
    	return null;
    }
    
    /**
     * 盘点差异数据
     */
    @GetMapping("selectc")
    @ResponseBody
    public List<MakeInventory> selectCheck(@RequestParam(value = "checknum") String checknum){
    	System.out.println("-----------------------   "+checknum+"     ");
    	List<MakeInventory> makeInventory = makeinventoryService.selectByOrder(checknum);
    	ModelAndView model = new ModelAndView();
    	model.addObject("makeInventory", makeInventory);
    	model.setViewName("data/check");
    	/*JSONArray json = JSONArray.fromObject(makeInventory);*/
    	return makeInventory;
    }
}
