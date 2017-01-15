package com.wms.controller;

import com.wms.bean.Compay;
import com.wms.bean.Pay;
import com.wms.commons.base.BaseController;
import com.wms.commons.utils.PageInfo;
import com.wms.service.CompayService;
import com.wms.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by W on 2017/1/13.
 */


@Controller
@RequestMapping("/pay")
public class PayController extends BaseController {
    @Autowired
    private PayService payService;

    @Autowired
    private CompayService compayService;

    @GetMapping("/manager")
    public String manager() {
        return "system/payPage";
    }


    //查询
    @PostMapping("/select")
    @ResponseBody
    public Object select(Pay pay, Integer page, Integer rows) {
        PageInfo pageinfo = new PageInfo(page, rows);
        Map<String, Object> map = new HashMap<String, Object>();
        pageinfo.setCondition(map);
        payService.selectDataGrid(pageinfo);
        return pageinfo;
    }


    //打开添加页面
    @RequestMapping("/addPage")
    public String addPage(){
        return "system/payAdd";
    }


    //添加
    @PostMapping("/add")
    @ResponseBody
    public Object add(Pay pay) {
        Compay cp = compayService.selectByPrimaryKey(1);
        System.out.println(cp.getCacount()+"=============");
        cp.setCacount(cp.getCacount().subtract(pay.getPpay()));
        int b = compayService.updateByPrimaryKey(cp);
        int a  = payService.insert(pay);
        if(a>0&&b>0){
            return renderSuccess("添加成功");
        }else {
            return renderError("添加失败");
        }
    }



    //删除
    @PostMapping("/delete")
    @ResponseBody
    public Object delete(int id){
        int a = payService.deleteByPrimaryKey(id);
        if(a>0){
            return renderSuccess("删除成功");
        }
        return renderError("删除失败");
    }


}
