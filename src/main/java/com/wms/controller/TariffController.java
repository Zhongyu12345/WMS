package com.wms.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wms.bean.Tariff;
import com.wms.commons.base.BaseController;
import com.wms.commons.utils.PageInfo;
import com.wms.service.TariffService;

@Controller
@RequestMapping("/tariff")
public class TariffController extends BaseController{
	
	@Autowired
	private TariffService tariffService;
	
	@GetMapping("page")
	public String tariffPage(){
		return "data/tariff";
	}
	
	@GetMapping("addPage")
	public String tariffAddpage(){
		return "data/tariffAdd";
	}
	
	@GetMapping("editPage")
	public String tariffEditpage(Model model, @RequestParam("id") int id){
		Tariff tariff = tariffService.selectByPrimaryKey(id);
		model.addAttribute("tariff", tariff);
		return "data/tariffEdit";
	}
	
	@PostMapping("/dataGrid")
    @ResponseBody
    public Object dataGrid(Tariff tariff, Integer page, Integer rows, String sort) {
        PageInfo pageInfo = new PageInfo(page, rows);
        Map<String, Object> condition = new HashMap<String, Object>();

        pageInfo.setCondition(condition);
        tariffService.selectDataGrid(pageInfo);
        return pageInfo;
    }
	
	@RequestMapping("add")
	@ResponseBody
	public Object addTariff(Tariff tariff){
		int a = tariffService.insert(tariff);
		if(a>0){
			return renderSuccess("添加成功");
		}
		return renderError("添加失败");
	}
	
	@RequestMapping("edit")
	@ResponseBody
	public Object editTariff(Tariff tariff){
		int a = tariffService.updateByPrimaryKeySelective(tariff);
		if(a>0){
			return renderSuccess("修改成功");
		}
		return renderError("修改失败");
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public Object deleteTariff(@RequestParam("id")int id){
		int a = tariffService.deleteByPrimaryKey(id);
		if(a>0){
			return renderSuccess("删除成功");
		}
		return renderError("删除失败");
	}
}
