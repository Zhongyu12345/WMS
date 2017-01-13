package com.wms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wms.bean.Compay;
import com.wms.commons.base.BaseController;
import com.wms.service.CompayService;

@RequestMapping("compay")
@Controller
public class CompayController  extends BaseController{
	
	@Autowired
	private CompayService compayService;
	
	@GetMapping("getPage")
	public String getPage(Model model){
		Compay compay = compayService.selectAll();
		model.addAttribute("compay", compay);
		return "finance/compay";
	}
}
