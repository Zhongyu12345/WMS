package com.wms.controller;

<<<<<<< Updated upstream
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
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
>>>>>>> Stashed changes
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wms.bean.SalesReturn;
import com.wms.commons.base.BaseController;
import com.wms.commons.utils.PageInfo;
<<<<<<< Updated upstream
import com.wms.commons.utils.StringUtils;
=======
>>>>>>> Stashed changes
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
	
<<<<<<< Updated upstream
	@PostMapping("/save")
	@ResponseBody
	public Object save(SalesReturn salesreturn, String time){
		salesreturn.setSrTime(updateTime(time));
		int a = salesReturnService.insert(salesreturn);
		if(a>0){
			return renderSuccess("添加成功");
		}
		return renderError("添加失败");
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
	public Object select(SalesReturn sales, Integer page, Integer rows){
		 PageInfo pageInfo = new PageInfo(page, rows);
		 Map<String, Object> condition = new HashMap<String, Object>();
	        if (StringUtils.isNotBlank(sales.getSrName())) {
	        	String str = "%"+sales.getSrName()+"%";
	            condition.put("srname",str );
	        }
	        if(StringUtils.isNotBlank(sales.getSrSipping())){
	        	condition.put("srsipping", sales.getSrSipping());
	        }
	        if (sales.getCreatedateStart() != null) {
	            condition.put("startTime", sales.getCreatedateStart());
	        }
	        if (sales.getCreatedateEnd() != null) {
	            condition.put("endTime", sales.getCreatedateEnd());
	        }
	     pageInfo.setCondition(condition);
=======
	@PostMapping("/select")
	@ResponseBody
	public Object select(Integer page, Integer rows){
		 PageInfo pageInfo = new PageInfo(page, rows);
>>>>>>> Stashed changes
		 salesReturnService.selectAll(pageInfo);
	     return pageInfo;
	}
	
	@PostMapping("/update")
	@ResponseBody
<<<<<<< Updated upstream
	public Object update(SalesReturn salesreturn,String time){
		salesreturn.setSrTime(updateTime(time));
=======
	public Object update(SalesReturn salesreturn){
>>>>>>> Stashed changes
		int a = salesReturnService.updateByPrimaryKey(salesreturn);
		if(a>0){
			return renderSuccess("修改成功");
		}
<<<<<<< Updated upstream
		return renderError("修改失败");
=======
		return null;
>>>>>>> Stashed changes
	}
	
	@PostMapping("/delete")
	@ResponseBody
	public Object delete(int id){
		int a = salesReturnService.deleteByPrimaryKey(id);
		if(a>0){
			return renderSuccess("删除成功");
		}
<<<<<<< Updated upstream
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
=======
		return null;
	}
>>>>>>> Stashed changes
}
