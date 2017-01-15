package com.wms.controller;

import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.util.Streams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.wms.bean.Cargo;
import com.wms.bean.Compay;
import com.wms.bean.Income;
import com.wms.bean.Receiving;
import com.wms.bean.Shipment;
import com.wms.bean.Tariff;
import com.wms.commons.base.BaseController;
import com.wms.commons.bean.Search;
import com.wms.commons.utils.ExcelToDisk;
import com.wms.commons.utils.PageInfo;
import com.wms.commons.utils.ReadXls;
import com.wms.commons.utils.StringUtils;
import com.wms.commons.utils.TimeUtils;
import com.wms.service.CargoService;
import com.wms.service.CompayService;
import com.wms.service.IncomeService;
import com.wms.service.ReceivingService;
import com.wms.service.ShipmentService;
import com.wms.service.TariffService;

/**
 * 实际出库表
 * Created by ZhongYu on 2016/12/19.
 */
@Controller
@RequestMapping(value = "shipment")
public class ShipmentController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(ShipmentController.class);

    @Autowired
    private ShipmentService shipmentService;
    
    @Autowired
    private TariffService tariffService;
    
    @Autowired
    private ReceivingService receivingService;
    
    @Autowired
    private IncomeService incomeService;
    
    @Autowired
    private CargoService cargoService;
    
    @Autowired
    private CompayService compayService;

    /** 出货单管理页面 */
    @GetMapping(value = "shipment.html")
    public String getShipmentPage() {
        return "outbound/shipment";
    }

    /** 分页查询 */
    @ResponseBody
    @PostMapping("dataGrid")
    public Object dataGrid(Search search, Integer page, Integer rows) {
        PageInfo pageInfo = new PageInfo(page, rows);
        Map<String, Object> condition = new HashMap<String, Object>();
        logger.info("出库表分页查询");
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
        shipmentService.selectDataGrid(pageInfo);
        return pageInfo;
    }

    /** 查询所有实际出库表 */
    @ResponseBody
    @GetMapping(value = "shipment")
    public List<Shipment> queryAll() {
        return shipmentService.queryAll();
    }

    /** 进入添加页面 */
    @GetMapping("shipment/insert")
    public String getAddShipmentPage() {
        return "outbound/shipmentAdd";
    }

    /** 添加操作 */
    @ResponseBody
    @PostMapping(value = "shipment")
    public Object addShipment(Shipment shipment, String addtime) {
        shipment.setShTime(TimeUtils.updateTime(addtime));
        int result = shipmentService.addShipment(shipment);
        if (result > 0) {
            return renderSuccess("添加成功!");
        } else {
            return renderError("添加失败!");
        }
    }

    /** 删除操作 */
    @ResponseBody
    @PostMapping(value = "shipment/delete")
    public Object deleteById(Integer id) {
        int result = shipmentService.deleteById(id);
        if (result > 0) {
            return renderSuccess("删除成功!");
        } else {
            return renderError("删除失败!");
        }
    }

    /** 确认已收货操作 */
    @ResponseBody
    @RequestMapping(value = "getEditPage")
    public Object editPage(Integer id) {
    	Shipment shipment = new Shipment();
    	shipment.setShId(id);
    	shipment.setStatus(1);
    	int result = shipmentService.updateShipment(shipment);
    	if (result > 0) {
            return renderSuccess("修改成功!");
        } else {
            return renderError("修改失败!");
        }
        /*Shipment shipment = shipmentService.selectById(id);
        model.addAttribute("shipment", shipment);
        return "outbound/shipmentEdit";*/
    }
    
    /**付款*/
    @RequestMapping(value="moneyPage")
    public String moneypage(Model model, @RequestParam(value = "id") Integer id, @RequestParam(value = "shTotalweigh") Double shTotalweigh){
    	Double shTotalweighs = shTotalweigh;
    	Shipment shipment = shipmentService.selectById(id);
    	Receiving receiving = receivingService.selectByModel(shipment.getShSkumodel());
    	Double VshTotalweigh = shipment.getShTotalvolume()*1000000/5000;
    	long betweenTime = (shipment.getShTime().getTime()-receiving.getrTime().getTime())/1000/60/60/24;//储存天数
    	List<Tariff> aTariffs = tariffService.selectByCause();
    	BigDecimal cMoney = new BigDecimal(0);
    	BigDecimal gMoney = new BigDecimal(0);
    	if(VshTotalweigh>shTotalweigh){
    		shTotalweighs=VshTotalweigh;
    	}
    	for(Tariff t: aTariffs){
    		if(t.getCause().equals("储存费") && t.getScope()>=shTotalweighs){
    			cMoney = t.getMoney();
    			model.addAttribute("ct", t);
    			break;
    		}else if(shTotalweighs>5000){
    			cMoney = new BigDecimal(8.8);
    			t.setMoney(cMoney);
    			model.addAttribute("ct", t);
    		}
    		
    	}
    	for(Tariff t: aTariffs){
    		if(t.getCause().equals("管理费") && t.getScope()>=shTotalweighs){
    			gMoney = t.getMoney();
    			model.addAttribute("glt", t);
    			break;
    		}else if(shTotalweighs>5000){
    			gMoney = new BigDecimal(20);
    			t.setMoney(gMoney);
    			model.addAttribute("glt", t);
    		}
    	}
    	System.out.println("----"+cMoney.multiply(new BigDecimal(betweenTime)));
    	model.addAttribute("cMoney", cMoney.multiply(new BigDecimal(betweenTime)));
    	model.addAttribute("gMoney", gMoney.multiply(new BigDecimal(betweenTime)));
    	model.addAttribute("shipments", shipment);
    	return "outbound/shipmentMoney";
    }
    
    /**确认付款*/
    @ResponseBody
    @RequestMapping("Money")
    public Object moneyed(@RequestParam("shId") int id, @RequestParam("moneyed") BigDecimal pay, @RequestParam("countMoney") BigDecimal count){
    	Shipment shipments = shipmentService.selectById(id);
    	Income income = new Income();
    	if(count.compareTo(pay) == 1){
    		return renderError("请一次性付清账单");
    	}else if(count.compareTo(pay) == -1){
    		return renderError("付款金额大于应付金额");
    	}
    	income.setIcause("储存费，管理费收入");
    	income.setIabout(shipments.getShSippingno());
    	income.setItime(TimeUtils.updateTime(new SimpleDateFormat().format(new Date())));
    	income.setIcount(count);
    	income.setIincome(pay);
    	income.setIbalance(count.subtract(pay));
    	
    	int result = incomeService.insert(income);
    	if(result >0){
    		shipments.setStatus(2);
    		int a = shipmentService.updateShipment(shipments);
    		Compay compay = compayService.selectAll();
    		Compay compays = new Compay();
    		compays.setCaid(compay.getCaid());
    		compays.setCamoney(compay.getCamoney());
    		compays.setCacount(compay.getCacount().add(income.getIincome()));
    		compayService.updateByPrimaryKeySelective(compays);
    		if(a>0){
    			return renderSuccess("付款成功");
    		}
    	}
    	return renderError("付款失败");
    }

    /** 更新操作 */
    @ResponseBody
    @PostMapping(value = "shipment/update")
    public Object updateShipment(Shipment shipment, String addtime) {
        shipment.setShTime(TimeUtils.updateTime(addtime));
        int result = shipmentService.updateShipment(shipment);
        if (result > 0) {
            return renderSuccess("更新成功!");
        } else {
            return renderError("更新失败!");
        }
    }

    @GetMapping("importShipment.html")
    public String importPage(){
        return "outbound/shipmentImport";
    }

    /** 读取提交的Excel */
    @PostMapping("readExcle")
    public String readExcle(@RequestParam("file") MultipartFile file, Model model) {
        String path = (AllotoutController.class.getResource("/").toString()).substring(6);
        if (!file.isEmpty()) {
            try {
                Streams.copy(file.getInputStream(), new FileOutputStream(path + "/" + file.getOriginalFilename()), true);
                URL url = ShipmentController.class.getResource("/" + file.getOriginalFilename());
                List<List<String>> lists = ReadXls.readxls(url.getFile());
                Shipment shipment = new Shipment();
                List<String> objects = lists.get(2);
                for (int i = 0; i < objects.size(); i++) {
                    //货主
                    shipment.setShStoreid(objects.get(0));
                    //时间
                    shipment.setShTime(TimeUtils.updateTime("".equals(objects.get(1)) ? null : objects.get(1)));
                    //号码
                    shipment.setShPhone(objects.get(2));
                    //单号
                    shipment.setShSippingno(objects.get(3));
                    //仓库
                    shipment.setShWhid(objects.get(4));
                    //损坏数量
                    shipment.setShDamage(Integer.valueOf(objects.get(5)));
                    //损坏原因
                    shipment.setShCause(objects.get(6));
                    //型号
                    shipment.setShSkumodel(objects.get(7));
                    //数量
                    shipment.setShShnum(Double.valueOf(objects.get(8)));
                    //毛重
                    shipment.setShTotalweigh(Double.valueOf(objects.get(9)));
                    //体积
                    shipment.setShTotalvolume(Double.valueOf(objects.get(10)));
                }
                model.addAttribute("shipment", shipment);
            } catch (Exception e) {
                model.addAttribute("error", "请导入正确的数据!!!");
                e.printStackTrace();
            }
        }
        return "outbound/shipmentImport";
    }

    @ResponseBody
    @PostMapping(value = "shipment.php")
    public Object importCrossDatabase(Shipment shipment, String byTime){
        shipment.setShTime(TimeUtils.updateTime(byTime));
        int result = shipmentService.importShipment(shipment);
        if (result > 0) {
            return renderSuccess("添加成功!");
        }
        return renderError("添加失败!");
    }
    
    @RequestMapping("/toexcel")
	public void excel(String id,HttpServletResponse resp,String yuanyin){
		Shipment shipment = shipmentService.selectById(Integer.valueOf(id));
		Cargo c =  cargoService.selectBySkumodel(shipment.getShSkumodel());
		shipment.setStatus(3);
       shipmentService.updateShipment(shipment);
		ExcelToDisk<Shipment> e = new ExcelToDisk<>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
		String title[] = {"货物名称","货物型号","货主","货主号码","客户托单号","退货体积","退货数量","退货时间","退货原因"};
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		Object obj[] = {c.getcName(),shipment.getShSkumodel(),shipment.getShStoreid(),shipment.getShPhone(),c.getcShippingno(),shipment.getShTotalvolume(),shipment.getShShnum(),f.format(new Date()),yuanyin};
		e.Excel(obj,"退货单"+sdf.format(new Date())+".xls",title,resp);
	}

}