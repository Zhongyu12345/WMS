package com.wms.controller;

import com.wms.bean.Allotout;
import com.wms.commons.base.BaseController;
import com.wms.commons.bean.Search;
import com.wms.commons.utils.PageInfo;
import com.wms.commons.utils.ReadXls;
import com.wms.commons.utils.StringUtils;
import com.wms.commons.utils.TimeUtils;
import com.wms.service.AllotoutService;
import org.apache.commons.fileupload.util.Streams;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 调拨单管理
 * Created by ZhongYu on 2016/12/21.
 */
@Controller
@RequestMapping(value = "allotout")
public class AllotoutController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(AllotoutController.class);

    @Autowired
    private AllotoutService allotoutService;

    /** 调拨单管理页面 */
    @GetMapping(value = "allotout.html")
    public String getAllotoutPage() {
    	logger.info("调拨单管理页面");
        return "outbound/allotout";
    }

    /** 调拨单添加页面 */
    @GetMapping(value = "insert")
    public String getAdd(){
        return "outbound/allotoutAdd";
    }

    /** 分页查询 模糊查询 */
    @ResponseBody
    @PostMapping("dataGrid")
    public Object dataGrid(Search search, Integer page, Integer rows, String startTime) {
        PageInfo pageInfo = new PageInfo(page, rows);
        Map<String, Object> condition = new HashMap<String, Object>();
        if (StringUtils.isNotBlank(search.getName())) {
            condition.put("name", search.getName());
        }
        if (search.getStartTime() != null) {
            condition.put("startTime", search.getStartTime());
        }
        if (search.getEndTime() != null) {
            condition.put("endTime", search.getEndTime());
        }
        pageInfo.setCondition(condition);
        allotoutService.selectDataGrid(pageInfo);
        return pageInfo;
    }

    /** 添加调拨单 */
    @ResponseBody
    @PostMapping(value = "allotout")
    public Object addAllotout(Allotout allotout, String byTime) {
        allotout.setAoTime(TimeUtils.updateTime(byTime));
        int result = allotoutService.addAllotout(allotout);
        if (result > 0) {
            return renderSuccess("添加成功!");
        } else {
            return renderError("添加失败!");
        }
    }

    /** 进入编辑页面 */
    @GetMapping(value = "getEditPage")
    public String editPage(Model model, @RequestParam(value = "id") Integer id) {
        Allotout allotout = allotoutService.queryById(id);
        model.addAttribute("allotout", allotout);
        return "outbound/allotoutEdit";
    }

    /** 更新调拨单 */
    @ResponseBody
    @PostMapping("allotout/update")
    public Object updateAllotout(@ModelAttribute Allotout allotout, String byTime) {
        allotout.setAoTime(TimeUtils.updateTime(byTime));
        int result = allotoutService.updateAllotout(allotout);
        if (result > 0) {
            return renderSuccess("更新成功!");
        } else {
            return renderError("更新失败!");
        }
    }

    /** 删除调拨单 */
    @ResponseBody
    @PostMapping("allotout/delete")
    public Object deleteAllotout(@Param("id") Integer id) {
        int result = allotoutService.deleteAllotout(id);
        if (result > 0) {
            return renderSuccess("删除成功!");
        } else {
            return renderError("删除失败!");
        }
    }

    /** 进入导入页面 */
    @GetMapping("importAllotout.html")
    public String importAllotoutPage(){
        return "outbound/allotoutImport";
    }

    /** 读取提交的Excel */
    @PostMapping("readExcle")
    public String readExcle(@RequestParam("file") MultipartFile file, Model model) {
        String path = (AllotoutController.class.getResource("/").toString()).substring(6);
        if (!file.isEmpty()) {
            try {
                Streams.copy(file.getInputStream(), new FileOutputStream(path + "/" + file.getOriginalFilename()), true);
                URL url = GodownEntryController.class.getResource("/" + file.getOriginalFilename());
                List<List<String>> lists = ReadXls.readxls(url.getFile());
                Allotout allotout = new Allotout();
                List<String> objects = lists.get(0);
                for (int i = 0; i < objects.size(); i++) {
                    allotout.setAoName(objects.get(0));
                    allotout.setAoSkumodel(objects.get(1));
                    allotout.setAoNum(Integer.valueOf(objects.get(2)));
                    allotout.setAoWhid(objects.get(4));
                    allotout.setAoSippingno(objects.get(5));
                    allotout.setAoTime(TimeUtils.updateTime(objects.get(6)));
                    allotout.setAoVolume(Double.valueOf(objects.get(3)));
                }
                model.addAttribute("allotout", allotout);
            } catch (Exception e) {
                model.addAttribute("error", "请导入正确的数据!!!");
                e.printStackTrace();
            }
        }
        return "outbound/allotoutImport";
    }

    /** 添加调拨单 */
    @ResponseBody
    @PostMapping(value = "allotout.php")
    public Object importAllotout(Allotout allotout, String byTime) {
        allotout.setAoTime(TimeUtils.updateTime(byTime));
        int result = allotoutService.importAllotout(allotout);
        if (result > 0) {
            return renderSuccess("添加成功!");
        } else {
            return renderError("添加失败!");
        }
    }

}
