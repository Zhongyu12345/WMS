package com.wms.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wms.bean.Godown;
import com.wms.bean.Receiving;
import com.wms.bean.User;
import com.wms.bean.vo.UserVo;
import com.wms.commons.base.BaseController;
import com.wms.commons.utils.ExcelToDisk;
import com.wms.commons.utils.OrderNumberUtil;
import com.wms.commons.utils.PageInfo;
import com.wms.commons.utils.StringUtils;
import com.wms.service.GodownService;
import com.wms.service.IUserService;
import com.wms.service.ReceivingService;

@Controller
@RequestMapping("/receiving")
public class ReceivingController extends BaseController {
	
	@Autowired
	private ReceivingService receivingService;
	
    @Autowired
    private GodownService godownService;
    
    @Autowired
    private IUserService userService;
	
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
        User user = userService.selectById(rece.getrAdminid());
        rece.setAdminname(user.getLoginName());
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(rece.getrId());
        model.addAttribute("roleIds", ids);
        model.addAttribute("user", rece);
        return "putstorage/receivingEdit";
    }
	
	@PostMapping("/update")
	@ResponseBody
	public Object update(Receiving receiving, String time,String oldWhid,String oldCrossflag,String oldVolume){
		receiving.setrTime(updateTime(time));
		UserVo user = userService.selectByloginname(receiving.getAdminname());
		receiving.setrAdminid(user.getId().intValue());
		double oldv = Double.valueOf(oldVolume);
		int a=0,b=0;
		if(receiving.getrWhid().equals(oldWhid)){//仓库不变
			if("1".equals(oldCrossflag) && "1".equals(receiving.getrCrossflag())){//如果之前不越库，现在也不越库
				if(Double.valueOf(oldVolume)>receiving.getrNum()){//如果之前体积大于现在体积
					Godown g = godownService.selectByPrimaryKey(Integer.valueOf(receiving.getrWhid()));
			    	g.setGoRdvolume(g.getGoRdvolume()+(oldv-receiving.getrNum()));//可用容积，可用容积 ＝　可用容积＋（之前体积－现在体积）
			    	g.setGoUsevolume(g.getGoUsevolume()-(oldv-receiving.getrNum()));//已用容积，已用容积＝　已用容积－（之前体积－现在体积）
			    	a = godownService.updateByPrimaryKey(g);
			    	b = receivingService.updateByPrimaryKey(receiving);
				}else if(Double.valueOf(oldVolume)<receiving.getrNum()){//如果之前体积小于现在体积
					Godown g = godownService.selectByPrimaryKey(Integer.valueOf(receiving.getrWhid()));
			    	g.setGoRdvolume(g.getGoRdvolume()-(receiving.getrNum()-oldv));//可用容积，可用容积 ＝　可用容积-（现在体积-之前体积）
			    	g.setGoUsevolume(g.getGoUsevolume()+(receiving.getrNum()-oldv));//已用容积，已用容积＝　已用容积+（现在体积-之前体积）
			    	a = godownService.updateByPrimaryKey(g);
			    	b = receivingService.updateByPrimaryKey(receiving);
				}else{//如果之前现在体积相等
			    	b = receivingService.updateByPrimaryKey(receiving);
			    	if(b>0){
			    		return renderSuccess("修改成功");
					}else{
						return renderError("修改失败");
					}
				}
			}else if("1".equals(oldCrossflag) && "0".equals(receiving.getrCrossflag())){//如果之前不越库，现在越库
				Godown g = godownService.selectByPrimaryKey(Integer.valueOf(receiving.getrWhid()));
		    	g.setGoRdvolume(g.getGoRdvolume()+oldv);//可用容积，可用容积 ＝　可用容积+之前体积
		    	g.setGoUsevolume(g.getGoUsevolume()-oldv);//已用容积，已用容积＝　已用容积-之前体积
		    	a = godownService.updateByPrimaryKey(g);
		    	b = receivingService.updateByPrimaryKey(receiving);
			}else if("0".equals(oldCrossflag) && "1".equals(receiving.getrCrossflag())){//如果之前越库，现在不越库
				Godown g = godownService.selectByPrimaryKey(Integer.valueOf(receiving.getrWhid()));
		    	g.setGoRdvolume(g.getGoRdvolume()-receiving.getrNum());//可用容积，可用容积 ＝　可用容积-现在体积
		    	g.setGoUsevolume(g.getGoUsevolume()+receiving.getrNum());//已用容积，已用容积＝　已用容积+现在体积
		    	a = godownService.updateByPrimaryKey(g);
		    	b = receivingService.updateByPrimaryKey(receiving);
			}else if("0".equals(oldCrossflag) && "0".equals(receiving.getrCrossflag())){//入果之前越库，现在越库
				b = receivingService.updateByPrimaryKey(receiving);
		    	if(b>0){
		    		return renderSuccess("修改成功");
				}else{
					return renderError("修改失败");
				}
			}else{
				System.out.println("没有预想到的情况");
			}
		}else{//仓库改变
			if("1".equals(oldCrossflag) && "1".equals(receiving.getrCrossflag())){//如果之前不越库，现在也不越库
				/**
				 * 还原以前仓库
				 */
				Godown go = godownService.selectByPrimaryKey(Integer.valueOf(oldWhid));
				go.setGoRdvolume(go.getGoRdvolume()+oldv);//可用容积
				go.setGoUsevolume(go.getGoUsevolume()-oldv);//已用容积
				godownService.updateByPrimaryKey(go);
				/**
				 * 修改现在仓库
				 */
				Godown g = godownService.selectByPrimaryKey(Integer.valueOf(receiving.getrWhid()));
		    	g.setGoRdvolume(g.getGoRdvolume()-receiving.getrNum());//可用容积，可用容积 ＝　可用容积-现在体积
		    	g.setGoUsevolume(g.getGoUsevolume()+receiving.getrNum());//已用容积，已用容积＝　已用容积+现在体积
		    	a = godownService.updateByPrimaryKey(g);
		    	b = receivingService.updateByPrimaryKey(receiving);
			}else if("1".equals(oldCrossflag) && "0".equals(receiving.getrCrossflag())){//如果之前不越库，现在越库
				/**
				 * 还原以前仓库
				 */
				Godown go = godownService.selectByPrimaryKey(Integer.valueOf(oldWhid));
				go.setGoRdvolume(go.getGoRdvolume()+oldv);//可用容积
				go.setGoUsevolume(go.getGoUsevolume()-oldv);//已用容积
				a = godownService.updateByPrimaryKey(go);
		    	b = receivingService.updateByPrimaryKey(receiving);
			}else if("0".equals(oldCrossflag) && "1".equals(receiving.getrCrossflag())){//如果之前越库，现在不越库
				Godown g = godownService.selectByPrimaryKey(Integer.valueOf(receiving.getrWhid()));
		    	g.setGoRdvolume(g.getGoRdvolume()-receiving.getrNum());//可用容积，可用容积 ＝　可用容积-现在体积
		    	g.setGoUsevolume(g.getGoUsevolume()+receiving.getrNum());//已用容积，已用容积＝　已用容积+现在体积
		    	a = godownService.updateByPrimaryKey(g);
		    	b = receivingService.updateByPrimaryKey(receiving);
			}else if("0".equals(oldCrossflag) && "0".equals(receiving.getrCrossflag())){//入果之前越库，现在越库
				b = receivingService.updateByPrimaryKey(receiving);
				if(b>0){
					return renderSuccess("修改成功");
				}else{
					return renderError("修改失败");
				}
			}else{
				System.out.println("没有预想到的情况");
			}
		}
		if(a>0 && b>0){
			return renderSuccess("修改成功");
		}
		return renderError("修改失败");
	}
	
	@PostMapping("/delete")
	@ResponseBody
	public Object delete(Integer id){
		Receiving rece = receivingService.selectByPrimaryKey(id);
		Godown go = godownService.selectByPrimaryKey(Integer.valueOf(rece.getrWhid()));
		go.setGoRdvolume(go.getGoRdvolume()+rece.getrNum());//可用容积
		go.setGoUsevolume(go.getGoUsevolume()-rece.getrNum());//已用容积
		int b = godownService.updateByPrimaryKey(go);
    	int a = receivingService.deleteByPrimaryKey(id);
		if(a>0 && b>0){
			return renderSuccess("删除成功");
		}
		return renderError("删除失败");
	}
	
	@RequestMapping("/toexcel")
	public void excel(String id,HttpServletResponse resp){
		Receiving rece = receivingService.selectByPrimaryKey(Integer.valueOf(id));
		excel(rece,resp);
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
    
    private void excel(Receiving rece,HttpServletResponse resp){
    	ExcelToDisk<Receiving> e = new ExcelToDisk<>();
	  SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
	  String dan = OrderNumberUtil.generateOrderNo();//单号
	  String title[] = {"货物名称","货物型号","货主","货主号码","客户托单号","发货数量","发货重量","发货体积","仓库","发货单号","发货时间"};
	   Godown g =  godownService.selectByPrimaryKey(Integer.valueOf(rece.getrWhid()));
	   SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
	  Object obj[] = {rece.getrName(),rece.getrSkumodel(),rece.getrStorerid(),rece.getrPhone(),rece.getrSippingno(),rece.getrNumber(),rece.getrHeavy(),rece.getrNum(),g.getGoWhid(),dan,f.format(new Date())};
      e.Excel(obj,"越库出货单"+sdf.format(new Date())+".xls",title,resp);
    }

}
