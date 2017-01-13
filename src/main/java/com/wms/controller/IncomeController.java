package com.wms.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
import com.wms.bean.vo.IncomeVo;
import com.wms.commons.base.BaseController;
import com.wms.commons.utils.PageInfo;
import com.wms.service.IncomeService;
import com.wms.service.PayService;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/income")
public class IncomeController extends BaseController{
	
	@Autowired
	private IncomeService incomeService;
	
	@Autowired
	private PayService payService;
	
	/**
	 * @return
	 * 跳转财务统计
	 */
	@GetMapping("/finpage")
	public String finPage(Model model){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String time = sdf.format(new Date());
		IncomeVo income = incomeService.selectByTime(time);
		IncomeVo pay = payService.selectByTime(time);
		if(pay == null && income != null){
			model.addAttribute("income", income);
			model.addAttribute("counts", income);
		}else if(income == null && pay != null){
			BigDecimal a = new BigDecimal(0);
			IncomeVo counts = new IncomeVo();
			counts.setOne(a.subtract(pay.getOne()));
			counts.setTwo(a.subtract(pay.getTwo()));
			counts.setThree(a.subtract(pay.getThree()));
			counts.setFour(a.subtract(pay.getFour()));
			counts.setFive(a.subtract(pay.getFive()));
			counts.setSix(a.subtract(pay.getSix()));
			counts.setSeven(a.subtract(pay.getSeven()));
			counts.setEight(a.subtract(pay.getEight()));
			counts.setNine(a.subtract(pay.getNine()));
			counts.setTen(a.subtract(pay.getTen()));
			counts.setEleven(a.subtract(pay.getEleven()));
			counts.setTwelve(a.subtract(pay.getTwelve()));
			counts.setCount(a.subtract(pay.getCount()));
			model.addAttribute("counts", counts);
			model.addAttribute("pay", pay);
		}else if(pay == null && income == null){
			return "finance/financial";
		}else{
			IncomeVo counts = new IncomeVo();
			counts.setOne(income.getOne().subtract(pay.getOne()));
			counts.setTwo(income.getTwo().subtract(pay.getTwo()));
			counts.setThree(income.getThree().subtract(pay.getThree()));
			counts.setFour(income.getFour().subtract(pay.getFour()));
			counts.setFive(income.getFive().subtract(pay.getFive()));
			counts.setSix(income.getSix().subtract(pay.getSix()));
			counts.setSeven(income.getSeven().subtract(pay.getSeven()));
			counts.setEight(income.getEight().subtract(pay.getEight()));
			counts.setNine(income.getNine().subtract(pay.getNine()));
			counts.setTen(income.getTen().subtract(pay.getTen()));
			counts.setEleven(income.getEleven().subtract(pay.getEleven()));
			counts.setTwelve(income.getTwelve().subtract(pay.getTwelve()));
			counts.setCount(income.getCount().subtract(pay.getCount()));
			model.addAttribute("counts", counts);
			model.addAttribute("pay", pay);
			model.addAttribute("income", income);
		}
		return "finance/financial";
	}
	
	@RequestMapping("inPage")
	public String getPage(){
		return "finance/income";
	}
	
	@PostMapping("/dataGrid")
    @ResponseBody
    public Object dataGrid(Tariff tariff, Integer page, Integer rows, String sort) {
        PageInfo pageInfo = new PageInfo(page, rows);
        Map<String, Object> condition = new HashMap<String, Object>();

        pageInfo.setCondition(condition);
        incomeService.selectDataGrid(pageInfo);
        return pageInfo;
    }
	
	@RequestMapping("delete")
	@ResponseBody
	public Object deleteTariff(@RequestParam("id")int id){
		int a = incomeService.deleteByPrimaryKey(id);
		if(a>0){
			return renderSuccess("删除成功");
		}
		return renderError("删除失败");
	}
	
	@PostMapping("YearCombobox")
    public @ResponseBody Object getUserName(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
    	List<HashMap<String, String>> list = new ArrayList<HashMap<String,String>>();
    	for(int i = 1980;i<=(Integer.valueOf(sdf.format(new Date())));i++){
    		HashMap<String, String> map = new HashMap<String,String>();
    		map.put("yearId", i+"");
			map.put("year", i+"");
			list.add(map);
    	}
    	JSONArray json = JSONArray.fromObject(list);
    	
    	return json;
    }
	
	@RequestMapping("searchPage")
	@ResponseBody
	public List<IncomeVo> search(@RequestParam(value = "year") String time){
		BigDecimal a = new BigDecimal(0);
		IncomeVo income = incomeService.selectByTime(time);
		IncomeVo pay = payService.selectByTime(time);
		IncomeVo count = new IncomeVo();
		count.setOne(a);
		count.setTwo(a);
		count.setThree(a);
		count.setFour(a);
		count.setFive(a);
		count.setSix(a);
		count.setSeven(a);
		count.setEight(a);
		count.setNine(a);
		count.setTen(a);
		count.setEleven(a);
		count.setTwelve(a);
		count.setCount(a);
		List<IncomeVo> list = new ArrayList<IncomeVo>();
		if(pay == null && income != null){
			list.add(income);
			list.add(count);
			list.add(income);
		}else if(income == null && pay != null){
			IncomeVo countp = new IncomeVo();
			countp.setOne(a.subtract(pay.getOne()));
			countp.setTwo(a.subtract(pay.getTwo()));
			countp.setThree(a.subtract(pay.getThree()));
			countp.setFour(a.subtract(pay.getFour()));
			countp.setFive(a.subtract(pay.getFive()));
			countp.setSix(a.subtract(pay.getSix()));
			countp.setSeven(a.subtract(pay.getSeven()));
			countp.setEight(a.subtract(pay.getEight()));
			countp.setNine(a.subtract(pay.getNine()));
			countp.setTen(a.subtract(pay.getTen()));
			countp.setEleven(a.subtract(pay.getEleven()));
			countp.setTwelve(a.subtract(pay.getTwelve()));
			countp.setCount(a.subtract(pay.getCount()));
			list.add(count);
			list.add(pay);
			list.add(countp);
		}else if(pay == null && income == null){
			list.add(count);
			list.add(count);
			list.add(count);
		}else{
			IncomeVo counts = new IncomeVo();
			counts.setOne(income.getOne().subtract(pay.getOne()));
			counts.setTwo(income.getTwo().subtract(pay.getTwo()));
			counts.setThree(income.getThree().subtract(pay.getThree()));
			counts.setFour(income.getFour().subtract(pay.getFour()));
			counts.setFive(income.getFive().subtract(pay.getFive()));
			counts.setSix(income.getSix().subtract(pay.getSix()));
			counts.setSeven(income.getSeven().subtract(pay.getSeven()));
			counts.setEight(income.getEight().subtract(pay.getEight()));
			counts.setNine(income.getNine().subtract(pay.getNine()));
			counts.setTen(income.getTen().subtract(pay.getTen()));
			counts.setEleven(income.getEleven().subtract(pay.getEleven()));
			counts.setTwelve(income.getTwelve().subtract(pay.getTwelve()));
			counts.setCount(income.getCount().subtract(pay.getCount()));
			list.add(income);
			list.add(pay);
			list.add(counts);
		}
		return list;
	}
}
