package com.wms.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wms.bean.Allotput;
import com.wms.commons.base.BaseController;
import com.wms.commons.utils.PageInfo;
import com.wms.service.AllotputService;

@Controller
@RequestMapping("/allotput")
public class AllotputController extends BaseController {
	
	@Autowired
	private AllotputService allotputService;
	
	@GetMapping("/alloputPage")
	public String alloputPage(){
		return "putstorage/alloputPage";
	}
	
	@GetMapping("/editPage")
    public String editPage(Integer id, Model model) {
        Allotput all = allotputService.selectByPrimaryKey(id);
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(all.getApId());
        model.addAttribute("roleIds", ids);
        model.addAttribute("allotput", all);
        return "putstorage/allotputEdit";
    }
	
	@PostMapping("/select")
	@ResponseBody
	public Object select(Integer page, Integer rows){
		 PageInfo pageInfo = new PageInfo(page, rows);
		 allotputService.selectAll(pageInfo);
	     return pageInfo;
	}
	
	@PostMapping("/update")
	@ResponseBody
	public Object update(Allotput allotput,String time){
		allotput.setApTime(updateTime(time));
		int a = allotputService.updateByPrimaryKey(allotput);
		if(a>0){
			return renderSuccess("修改成功");
		}
		return renderSuccess("修改失败");
	}
	
	@PostMapping("/delete")
	@ResponseBody
	public Object delete(int id){
		int a = allotputService.deleteByPrimaryKey(id);
		if(a>0){
			return renderSuccess("删除成功");
		}
		return renderSuccess("删除失败");
	}
	
	 /**
     * 把字符串时间转成Date类型
     *
     * @param time
     * @return
     */
    private Date updateTime(String time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

}
