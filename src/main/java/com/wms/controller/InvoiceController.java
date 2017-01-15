package com.wms.controller;

import com.wms.bean.Godown;
import com.wms.bean.Invoice;
import com.wms.bean.Shipment;
import com.wms.commons.base.BaseController;
import com.wms.commons.bean.Search;
import com.wms.commons.utils.PageInfo;
import com.wms.commons.utils.ReadXls;
import com.wms.commons.utils.TimeUtils;
import com.wms.service.GodownService;
import com.wms.service.InvoiceService;
import com.wms.service.ShipmentService;
import org.apache.commons.fileupload.util.Streams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.FileOutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    @Autowired
    private ShipmentService shipmentService;

    @Autowired
    private GodownService godownService;

    /** 出货单管理页面 */
    @GetMapping(value = "invoice.html")
    public String getInvoicePage() {
        return "outbound/invoice";
    }

    /** 分页查询 */
    @ResponseBody
    @PostMapping("dataGrid")
    public Object dataGrid(Search search, Integer page, Integer rows) {
      PageInfo pageInfo = new PageInfo(page,rows);
      Map<String,Object> map = new HashMap<String,Object>();
      if(search.getName() != null){
          map.put("name",search.getName());
      }
      if(search.getStartTime() != null){
          map.put("startTime",search.getStartTime());
      }
      if(search.getEndTime() != null){
          map.put("endTime",search.getEndTime());
      }
      pageInfo.setCondition(map);
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

    /**
     * @param file
     * @param req
     */
    @RequestMapping("/ReadExcel")
    public Object ReadExcel(@RequestParam("file")MultipartFile file, HttpServletRequest req,Model model){
        try {
            String path = (makeinventoryController.class.getResource("/").toString()).substring(6);
            if (!file.isEmpty()) {
                Streams.copy(file.getInputStream(), new FileOutputStream(path + "/" + file.getOriginalFilename()), true);
            }
            URL url = makeinventoryController.class.getResource("/" + file.getOriginalFilename());
            List<List<String>> list = ReadXls.readxls(url.getFile());
            Invoice invoice = new Invoice();
            List<String> data = list.get(0);
            for(int i = 0;i<data.size();i++){
                invoice.setInName(data.get(0));
                invoice.setStore(data.get(1));
                invoice.setPhone(data.get(2));
                invoice.setInOddnumber(data.get(3));
                invoice.setInWhid(data.get(4));
                invoice.setInNum(Double.valueOf(data.get(5)));
                invoice.setInVolume(Double.valueOf(data.get(6)));
                invoice.setTotalweigh(Double.valueOf(data.get(7)));
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:MM");
                invoice.setInTime(sdf.parse(data.get(8)));
                invoice.setInSkumodel(data.get(9));
            }
            model.addAttribute("invoice",invoice);
            }catch (Exception e) {
            e.printStackTrace();
        }
        return "outbound/invoiceImport";
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
    public Object updateInvoice(Invoice invoice) {
        Shipment shipment = new Shipment();
        shipment.setShStoreid(invoice.getStore());
        shipment.setShSkumodel(invoice.getInSkumodel());
        shipment.setShPhone(invoice.getPhone());
        shipment.setShSippingno(invoice.getInOddnumber());
        shipment.setShWhid(invoice.getInWhid());
        shipment.setShDamage(invoice.getDamage());
        shipment.setShCause(invoice.getCause());
        shipment.setShTime(new Date());
        shipment.setShShnum(invoice.getInNum());
        shipment.setShTotalweigh(invoice.getTotalweigh());
        shipment.setShTotalvolume(invoice.getInVolume());
        int result = shipmentService.addShipment(shipment);
        Godown godown = new Godown();
        godown = godownService.selectByWhid(invoice.getInWhid());
        godown.setGoUsevolume(godown.getGoUsevolume()-invoice.getInVolume());//以用的要加
        godown.setGoRdvolume(godown.getGoRdvolume()+invoice.getInVolume());//可用要减
        godownService.updateByPrimaryKey(godown);
        Invoice invoice1 = new Invoice();
        invoice1.setStatus(1);
        invoice1.setInId(invoice.getInId());
        invoiceService.updateInvoice(invoice1);
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

    @ResponseBody
    @PostMapping(value = "invoice.php")
    public Object importCrossDatabase(Invoice invoice, String byTime){
        invoice.setInTime(TimeUtils.updateTime(byTime));
        invoice.setCause("");
        invoice.setDamage(0);
        int result = invoiceService.importInvoice(invoice);
        if (result > 0) {
            return renderSuccess("添加成功!");
        }
        return renderError("添加失败!");
    }

}