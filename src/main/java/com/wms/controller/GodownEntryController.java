package com.wms.controller;

import java.io.FileOutputStream;
import java.net.URL;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.util.Streams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.wms.bean.GodownEntry;
import com.wms.bean.Receiving;
import com.wms.commons.base.BaseController;
import com.wms.commons.utils.ReadXls;
import com.wms.service.GodownEntryService;
import com.wms.service.ReceivingService;
/**
 * 
 *
 */
@Controller
@RequestMapping("/putstorage")
public class GodownEntryController extends BaseController {
	
	@Autowired
	private GodownEntryService godownEntryService;
	
	@Autowired
	private ReceivingService receivingService;

	
	@RequestMapping("/receiving")
	public String ruchuPage(){
		return "putstorage/receiving";
	} 
	
	
	@RequestMapping("/readExcle")
	public void Excle(@RequestParam("file") MultipartFile file, HttpServletRequest request){
		try {
			String path = (UserController.class.getResource("/").toString()).substring(6);
			if(!file.isEmpty()){
				Streams.copy(file.getInputStream(),new FileOutputStream(path+"/"+file.getOriginalFilename()),true);
			}
			URL url = UserController.class.getResource("/"+file.getOriginalFilename());
			List<List<String>> list = ReadXls.readxls(url.getFile());
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@PostMapping("/save")
	@ResponseBody
	public Object save(GodownEntry godownEntry,Receiving receiving){
		int a = godownEntryService.insert(godownEntry);
		int b = receivingService.insert(receiving);
		if(a>0 && b>0){
			return renderSuccess("添加成功");
		}
		return renderError("添加失败");
	}

}
