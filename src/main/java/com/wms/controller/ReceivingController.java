package com.wms.controller;

import java.text.ParseException;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.wms.bean.Receiving;
import com.wms.commons.base.BaseController;
import com.wms.commons.utils.PageInfo;
import com.wms.commons.utils.StringUtils;
import com.wms.service.ReceivingService;

@Controller
@RequestMapping("/receiving")
public class ReceivingController extends BaseController {
	
	@Autowired
	private ReceivingService receivingService;
	
	@GetMapping("receivingPage")
	public String receivingPage(){
		return "putstorage/receivingPage";
	}
	
	@PostMapping("/select")
	@ResponseBody
	public Object select(Receiving rece , Integer page, Integer rows){
		 PageInfo pageInfo = new PageInfo(page, rows);
		 Map<String, Object> condition = new HashMap<String, Object>();
	        if (StringUtils.isNotBlank(rece.getrName())) {
	        	String str = "%"+rece.getrName()+"%";
	            condition.put("rname",str );
	        }
	        if(StringUtils.isNotBlank(rece.getrSkumodel())){
	        	condition.put("rskumodel", rece.getrSkumodel());
	        }
	        if (rece.getCreatedateStart() != null) {
	            condition.put("startTime", rece.getCreatedateStart());
	        }
	        if (rece.getCreatedateEnd() != null) {
	            condition.put("endTime", rece.getCreatedateEnd());
	        }
	        if(StringUtils.isNotBlank(rece.getrSupplierid())){
	        	condition.put("rSupplierid", rece.getrSupplierid());
	        }
	        if(StringUtils.isNotBlank(rece.getrCrossflag())){
	        	condition.put("rCrossflag", rece.getrCrossflag());
	        }
	        if(StringUtils.isNotBlank(rece.getrDirectflag())){
	        	condition.put("rDirectflag", rece.getrDirectflag());
	        }
	     pageInfo.setCondition(condition);
		 receivingService.selectAll(pageInfo);
	     return pageInfo;
	}
	
	
	@GetMapping("/editPage")
    public String editPage(Integer id, Model model) {
        Receiving rece = receivingService.selectByPrimaryKey(id);
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(rece.getrId());
        model.addAttribute("roleIds", ids);
        model.addAttribute("user", rece);
        return "putstorage/receivingEdit";
    }
	
	@PostMapping("/update")
	@ResponseBody
	public Object update(Receiving receiving, String time){
		receiving.setrTime(updateTime(time));
		int a = receivingService.updateByPrimaryKey(receiving);
		if(a>0){
			return renderSuccess("修改成功");
		}
		return renderError("修改失败");
	}
	
	@PostMapping("/delete")
	@ResponseBody
	public Object delete(Integer id){
		int a = receivingService.deleteByPrimaryKey(id);
		if(a>0){
			return renderSuccess("删除成功");
		}
		return renderError("删除失败");
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
