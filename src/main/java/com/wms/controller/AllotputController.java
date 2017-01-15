package com.wms.controller;

import java.io.FileOutputStream;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.util.Streams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.wms.bean.Allotput;
import com.wms.bean.Godown;
import com.wms.commons.base.BaseController;
import com.wms.commons.utils.PageInfo;
import com.wms.commons.utils.ReadXls;
import com.wms.commons.utils.StringUtils;
import com.wms.service.AllotputService;
import com.wms.service.GodownService;

@Controller
@RequestMapping("/allotput")
public class AllotputController extends BaseController {
	
	@Autowired
	private AllotputService allotputService;
	
    @Autowired
    private GodownService godownService;
	
	@GetMapping("/alloputPage")
	public String alloputPage(){
		return "putstorage/alloputPage";
	}
	
	@RequestMapping("/readExcle")
	public String Excle(@RequestParam("file") MultipartFile file, HttpServletRequest request, Model model) {
		if (file != null) {
			try {
				String path = (AllotputController.class.getResource("/").toString()).substring(6);
				if (!file.isEmpty()) {
					Streams.copy(file.getInputStream(), new FileOutputStream(path + "/" + file.getOriginalFilename()),
							true);
				}
				URL url = AllotputController.class.getResource("/" + file.getOriginalFilename());
				List<List<String>> list = ReadXls.readxls(url.getFile());
				Allotput ap = new Allotput();
				List<String> obj = list.get(0);
				for (int j = 0; j < obj.size(); j++) {
					ap.setApName(obj.get(0));
					ap.setApSkumodel(obj.get(1));
					ap.setApNum(Double.valueOf(obj.get(2)));
					ap.setApVolume(Double.valueOf(obj.get(3)));
					ap.setApWhid(obj.get(4));//仓库
					ap.setApSipping(obj.get(5));
					ap.setApTime(updateTime(obj.get(6)));
				}
			 	Godown g = godownService.selectByWhid(ap.getApWhid());
			 	ap.setApWhid(g.getGoId().toString());
				int a = allotputService.insert(ap);
				if(a>0){
					model.addAttribute("msg", "添加成功");
				}else{
					model.addAttribute("msg", "添加失败");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
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
	public Object select(Allotput allo, Integer page, Integer rows){
		 PageInfo pageInfo = new PageInfo(page, rows);
		 Map<String, Object> condition = new HashMap<String, Object>();
	        if (StringUtils.isNotBlank(allo.getApName())) {
	        	String str = "%"+allo.getApName()+"%";
	            condition.put("apname",str );
	        }
	        if(StringUtils.isNotBlank(allo.getApSipping())){
	        	condition.put("apsipping", allo.getApSipping());
	        }
	        if (allo.getCreatedateStart() != null) {
	            condition.put("startTime", allo.getCreatedateStart());
	        }
	        if (allo.getCreatedateEnd() != null) {
	            condition.put("endTime", allo.getCreatedateEnd());
	        }
	     pageInfo.setCondition(condition);
		 allotputService.selectAll(pageInfo);
	     return pageInfo;
	}
	
	@PostMapping("/update")
	@ResponseBody
	public Object update(Allotput allotput,String time,String oldWhid,String oldVolume){
		allotput.setApTime(updateTime(time));
		double oldv = Double.valueOf(oldVolume);
		int a =0,b=0;
		if(oldWhid.equals(allotput.getApWhid())){//仓库不变
			if(Double.valueOf(oldVolume)>allotput.getApVolume()){//如果之前体积大于现在体积
				Godown g = godownService.selectByPrimaryKey(Integer.valueOf(allotput.getApWhid()));
		    	g.setGoRdvolume(g.getGoRdvolume()+(oldv-allotput.getApVolume()));//可用容积，可用容积 ＝　可用容积＋（之前体积－现在体积）
		    	g.setGoUsevolume(g.getGoUsevolume()-(oldv-allotput.getApVolume()));//已用容积，已用容积＝　已用容积－（之前体积－现在体积）
		    	a = godownService.updateByPrimaryKey(g);
		    	b = allotputService.updateByPrimaryKey(allotput);
			}else if(Double.valueOf(oldVolume)<allotput.getApVolume()){//如果之前体积小于现在体积
				Godown g = godownService.selectByPrimaryKey(Integer.valueOf(allotput.getApWhid()));
		    	g.setGoRdvolume(g.getGoRdvolume()-(allotput.getApVolume()-oldv));//可用容积，可用容积 ＝　可用容积-（现在体积-之前体积）
		    	g.setGoUsevolume(g.getGoUsevolume()+(allotput.getApVolume()-oldv));//已用容积，已用容积＝　已用容积+（现在体积-之前体积）
		    	a = godownService.updateByPrimaryKey(g);
		    	b = allotputService.updateByPrimaryKey(allotput);
			}else{//如果之前现在体积相等
		    	b = allotputService.updateByPrimaryKey(allotput);
		    	if(b>0){
		    		return renderSuccess("修改成功");
				}else{
					return renderError("修改失败");
				}
			}
		}else{//仓库改变
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
			Godown g = godownService.selectByPrimaryKey(Integer.valueOf(allotput.getApWhid()));
	    	g.setGoRdvolume(g.getGoRdvolume()-allotput.getApVolume());//可用容积，可用容积 ＝　可用容积-现在体积
	    	g.setGoUsevolume(g.getGoUsevolume()+allotput.getApVolume());//已用容积，已用容积＝　已用容积+现在体积
	    	a = godownService.updateByPrimaryKey(g);
	    	b = allotputService.updateByPrimaryKey(allotput);
		}
		if(a>0&&b>0){
			return renderSuccess("修改成功");
		}
		return renderError("修改失败");
	}
	
	@PostMapping("/delete")
	@ResponseBody
	public Object delete(int id){
		int a = allotputService.deleteByPrimaryKey(id);
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
