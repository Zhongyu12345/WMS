package com.wms.controller;

import com.wms.bean.Invoice;
import com.wms.commons.base.BaseController;
import com.wms.commons.bean.Search;
import com.wms.commons.utils.PageInfo;
import com.wms.commons.utils.StringUtils;
import com.wms.commons.utils.TimeUtils;
import com.wms.service.InvoiceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 直接发货单
 * Created by ZhongYu on 2016/12/23.
 */
@Controller
@RequestMapping(value = "invoice")
public class InvoiceController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(InvoiceController.class);

    @Autowired
    private InvoiceService invoiceService;

    /** 出货单管理页面 */
    @GetMapping(value = "invoice.html")
    public String getInvoicePage() {
        return "outbound/invoice";
    }

    /** 分页查询 */
    @ResponseBody
    @PostMapping("dataGrid")
    public Object dataGrid(Search search, Integer page, Integer rows, String sort, String order) {
        PageInfo pageInfo = new PageInfo(page, rows);
        Map<String, Object> condition = new HashMap<String, Object>();
        if (StringUtils.isNotBlank(search.getName())) {
            logger.getName().toString();
            condition.put("name", search.getName());
        }
        if (search.getStartTime() != null) {
            condition.put("startTime", search.getStartTime());
        }
        if (search.getEndTime() != null) {
            condition.put("endTime", search.getEndTime());
        }
        pageInfo.setCondition(condition);
        invoiceService.selectDataGrid(pageInfo);
        return pageInfo;
    }

    /** 查询所有实际出库表 */
    @ResponseBody
    @GetMapping(value = "invoice")
    public List<Invoice> queryAll() {
        return invoiceService.queryAll();
    }

    @GetMapping("getAddPage")
    public String getAddShipmentPage() {
        return "outbound/invoiceAdd";
    }

    /** 添加操作 */
    @ResponseBody
    @PostMapping(value = "invoice")
    public Object addShipment(Invoice invoice, String byTime) {
        invoice.setInTime(TimeUtils.updateTime(byTime));
        int result = invoiceService.addInvoice(invoice);
        if (result > 0) {
            return renderSuccess("添加成功!");
        } else {
            return renderError("添加失败!");
        }
    }

    /** 删除操作 */
    @ResponseBody
    @PostMapping(value = "invoice/delete")
    public Object deleteById(Integer id) {
        int result = invoiceService.deleteById(id);
        if (result > 0) {
            return renderSuccess("删除成功!");
        } else {
            return renderError("删除失败!");
        }
    }

    /** 进入编辑页面 */
    @GetMapping(value = "getEditPage")
    public String editPage(Model model, @RequestParam(value = "id") Integer id) {
        Invoice invoice = invoiceService.selectById(id);
        model.addAttribute("invoice", invoice);
        return "outbound/invoiceEdit";
    }

    /** 更新操作 */
    @ResponseBody
    @PostMapping(value = "invoice/update")
    public Object updateInvoice(Invoice invoice, String byTime) {
        invoice.setInTime(TimeUtils.updateTime(byTime));
        int result = invoiceService.updateInvoice(invoice);
        if (result > 0) {
            return renderSuccess("更新成功!");
        } else {
            return renderError("更新失败!");
        }
    }

}