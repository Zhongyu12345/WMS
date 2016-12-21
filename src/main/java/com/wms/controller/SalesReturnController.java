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

import com.wms.bean.SalesReturn;
import com.wms.commons.base.BaseController;
import com.wms.commons.utils.PageInfo;
import com.wms.service.SalesReturnService;

@Controller
@RequestMapping("/salesreturn")
public class SalesReturnController extends BaseController {
	
	@Autowired
	private SalesReturnService salesReturnService;
	
	@RequestMapping("/salesreturnAddPage")
	public String salesreturnAddPage(){
		return "putstorage/salesreturnAddPage";
	}
	
	@GetMapping("/salesreturnPage")
	public String salesreturnPage(){
		return "putstorage/salesreturnPage";
	}
	
	
	@GetMapping("/editPage")
    public String editPage(Integer id, Model model) {
        SalesReturn sales = salesReturnService.selectByPrimaryKey(id);
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(sales.getSrId());
        model.addAttribute("roleIds", ids);
        model.addAttribute("salesreturn", sales);
        return "putstorage/salesreturnEdit";
    }
	
	@PostMapping("/select")
	@ResponseBody
	public Object select(Integer page, Integer rows){
		 PageInfo pageInfo = new PageInfo(page, rows);
		 salesReturnService.selectAll(pageInfo);
	     return pageInfo;
	}
	
	@PostMapping("/update")
	@ResponseBody
	public Object update(SalesReturn salesreturn,String time){
		salesreturn.setSrTime(updateTime(time));
		int a = salesReturnService.updateByPrimaryKey(salesreturn);
		if(a>0){
			return renderSuccess("修改成功");
		}
		return renderSuccess("修改失败");
	}
	
	@PostMapping("/delete")
	@ResponseBody
	public Object delete(int id){
		int a = salesReturnService.deleteByPrimaryKey(id);
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
