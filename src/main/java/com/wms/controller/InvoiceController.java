package com.wms.controller;

import com.wms.bean.Invoice;
import com.wms.commons.base.BaseController;
import com.wms.commons.bean.Search;
import com.wms.commons.utils.PageInfo;
import com.wms.commons.utils.ReadXls;
import com.wms.commons.utils.StringUtils;
import com.wms.commons.utils.TimeUtils;
import com.wms.service.InvoiceService;
import org.apache.commons.fileupload.util.Streams;
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

    @GetMapping("importInvoice.html")
    public String importPage(){
        return "outbound/invoiceImport";
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
                Invoice invoice = new Invoice();
                List<String> objects = lists.get(2);
                for (int i = 0; i < objects.size(); i++) {
                    invoice.setInName(objects.get(0));
                    invoice.setInSkumodel(objects.get(1));
                    invoice.setInNum(Double.valueOf(objects.get(2)));
                    invoice.setInWhid(objects.get(3));
                    invoice.setInOddnumber(objects.get(4));
                    invoice.setInTime(TimeUtils.updateTime("".equals(objects.get(5)) ? null : objects.get(5)));
                    invoice.setInVolume(Double.valueOf(objects.get(6)));
                }
                model.addAttribute("invoice", invoice);
            } catch (Exception e) {
                model.addAttribute("error", "请导入正确的数据!!!");
                e.printStackTrace();
            }
        }
        return "outbound/invoiceImport";
    }

    @ResponseBody
    @PostMapping(value = "invoice.php")
    public Object importCrossDatabase(Invoice invoice, String byTime){
        invoice.setInTime(TimeUtils.updateTime(byTime));
        int result = invoiceService.importInvoice(invoice);
        if (result > 0) {
            return renderSuccess("添加成功!");
        }
        return renderError("添加失败!");
    }

}