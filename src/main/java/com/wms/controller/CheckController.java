package com.wms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wms.commons.base.BaseController;

@Controller
@RequestMapping("/check")
public class CheckController extends BaseController{
	
	/**
     *跳转到adjust页面
     * @return
     */
    @GetMapping("/page")
    public String page(){
        return "data/check";
    }
}
