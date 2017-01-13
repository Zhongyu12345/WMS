package com.wms.controller;

import java.io.FileOutputStream;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.util.Streams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.wms.bean.Cargo;
import com.wms.bean.Godown;
import com.wms.bean.GodownEntry;
import com.wms.bean.Receiving;
import com.wms.bean.User;
import com.wms.bean.vo.UserVo;
import com.wms.commons.base.BaseController;
import com.wms.commons.utils.PageInfo;
import com.wms.commons.utils.ReadXls;
import com.wms.commons.utils.StringUtils;
import com.wms.service.CargoService;
import com.wms.service.GodownEntryService;
import com.wms.service.GodownService;
import com.wms.service.IUserService;
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
	private GodownService godownService;

	@Autowired
	private ReceivingService receivingService;

	@Autowired
	private CargoService cargoService;

	@Autowired
	private IUserService userService;

	@RequestMapping("/receiving")
	public String ruchuPage() {
		return "putstorage/receiving";
	}

	@RequestMapping("/godownEntryPage")
	public String toPage() {
		return "putstorage/godownEntryPage";
	}

	@PostMapping("/select")
	@ResponseBody
	public Object select(GodownEntry ge, Integer page, Integer rows) {
		PageInfo pageInfo = new PageInfo(page, rows);
		Map<String, Object> condition = new HashMap<String, Object>();
		if (StringUtils.isNotBlank(ge.getgName())) {
			String str = "%" + ge.getgName() + "%";
			condition.put("gname", str);
		}
		if (StringUtils.isNotBlank(ge.getgSkumodel())) {
			condition.put("gskumodel", ge.getgSkumodel());
		}
		if (ge.getCreatedateStart() != null) {
			condition.put("startTime", ge.getCreatedateStart());
		}
		if (ge.getCreatedateEnd() != null) {
			condition.put("endTime", ge.getCreatedateEnd());
		}
		if (StringUtils.isNotBlank(ge.getgSupplierid())) {
			condition.put("gSupplierid", ge.getgSupplierid());
		}
		if (StringUtils.isNotBlank(ge.getgCrossflag())) {
			condition.put("gCrossflag", ge.getgCrossflag());
		}
		if (StringUtils.isNotBlank(ge.getgDirectflag())) {
			condition.put("gDirectflag", ge.getgDirectflag());
		}
		pageInfo.setCondition(condition);
		godownEntryService.selectAll(pageInfo);
		return pageInfo;
	}

	@PostMapping("/delete")
	@ResponseBody
	public Object delete(Integer id) {
		int a = godownEntryService.deleteByPrimaryKey(id);
		if (a > 0) {
			return renderSuccess("删除成功");
		}
		return renderError("删除失败");
	}

	@RequestMapping("/readExcle")
	public String Excle(@RequestParam("file") MultipartFile file, HttpServletRequest request, Model model) {
		if (file != null) {
			try {
				String path = (GodownEntryController.class.getResource("/").toString()).substring(6);
				if (!file.isEmpty()) {
					Streams.copy(file.getInputStream(), new FileOutputStream(path + "/" + file.getOriginalFilename()),
							true);
				}
				URL url = GodownEntryController.class.getResource("/" + file.getOriginalFilename());
				List<List<String>> list = ReadXls.readxls(url.getFile());
				GodownEntry g = new GodownEntry();
				List<String> obj = list.get(2);
				for (int j = 0; j < obj.size(); j++) {
					g.setgName(obj.get(0));// 货物名称
					g.setgStorerid(obj.get(1));// 货主
					g.setgPhone(obj.get(2));// 号码
					g.setgSippingno(obj.get(3));// 客户托单号
					g.setgSkumodel(obj.get(4));// 货物型号
					g.setgSupplierid(obj.get(5));// 供应商
					if ("".equals(obj.get(6))) {
						g.setgNumber(0);
					} else {
						g.setgNumber(Integer.valueOf(obj.get(6).trim()));// 数量
					}
					g.setgHeavy(Double.valueOf(obj.get(7).trim()));// 重量
					g.setgNum(Double.valueOf(obj.get(8).trim()));// 体积
					if ("越库".equals(obj.get(9).trim())) {
						g.setgCrossflag(0 + "");
					} else {
						g.setgCrossflag(1 + "");
					}
					if ("整进".equals(obj.get(10).trim())) {
						g.setgDirectflag(0 + "");
					} else {
						g.setgDirectflag(1 + "");
					}
					g.setgTime(updateTime("".equals(obj.get(11)) ? null : obj.get(11)));// 时间
					model.addAttribute("godown", g);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "putstorage/receiving";
	}

	@PostMapping("/save")
	@ResponseBody
	public Object save(GodownEntry godownEntry, Receiving receiving, String sgTime, String srTime) {
		godownEntry.setgTime(updateTime(sgTime));
		receiving.setrTime(updateTime(srTime));
		UserVo u = new UserVo();
		u.setLoginName(receiving.getAdminname());
		List<User> users = userService.selectByLoginName(u);
		for (User user : users) {
			receiving.setrAdminid(user.getId().intValue());
		}
		int a = godownEntryService.insert(godownEntry);
		int b = receivingService.insert(receiving);
		Cargo g = new Cargo();
		g.setcName(receiving.getrName());
		g.setcReceivedate(receiving.getrTime());
		g.setcShippingno(receiving.getrSippingno());
		g.setcSkumodel(receiving.getrSkumodel());
		g.setcStorerid(receiving.getrStorerid());
		g.setcSupplierid(receiving.getrSupplierid());
		g.setcTotalvolume(receiving.getrNum());
		g.setcWhid(receiving.getrWhid());
		g.setcNum(receiving.getrNumber());
		g.setcTotalweight(receiving.getrHeavy());
		g.setcPhone(receiving.getrPhone());
		int d = run(receiving);
		int c = cargoService.insert(g);
		if (a > 0 && b > 0 && c > 0 && d > 0) {
			return renderSuccess("添加成功");
		} else {
			return renderError("添加失败");
		}
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

	private int run(Receiving receiving) {
		int a = 0;
		if (receiving.getrCrossflag().equals("1")) {// 如果不越库
			Godown g = godownService.selectByPrimaryKey(Integer.valueOf(receiving.getrWhid()));
			g.setGoRdvolume(g.getGoRdvolume() - receiving.getrNum());// 可用容积
			g.setGoUsevolume(g.getGoUsevolume() + receiving.getrNum());// 已用容积
			a = godownService.updateByPrimaryKey(g);
			if (a > 0) {
				return 1;
			} else {
				return 0;
			}
		} else {
			return 1;
		}
	}

}
