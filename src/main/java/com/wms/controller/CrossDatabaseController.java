package com.wms.controller;

import com.wms.bean.Cargo;
import com.wms.bean.CrossDatabase;
import com.wms.bean.Shipment;
import com.wms.commons.base.BaseController;
import com.wms.commons.bean.Search;
import com.wms.commons.utils.PageInfo;
import com.wms.commons.utils.ReadXls;
import com.wms.commons.utils.StringUtils;
import com.wms.commons.utils.TimeUtils;
import com.wms.service.CargoService;
import com.wms.service.CrossDatabaseService;
import com.wms.service.ShipmentService;

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
 * 越库出货单
 * Created by ZhongYu on 2016/12/23.
 */
@Controller
@RequestMapping(value = "crossDatabase")
public class CrossDatabaseController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(CrossDatabaseController.class);

    @Autowired
    private CrossDatabaseService crossDatabaseService;
    
    @Autowired
    private ShipmentService shipmentService;
    
    @Autowired
    private CargoService cargoService;

    /** 出货单管理页面 */
    @GetMapping(value = "crossDatabase.html")
    public String getShipmentPage() {
        return "outbound/crossDatabase";
    }

    /** 分页查询 */
    @ResponseBody
    @PostMapping("dataGrid")
    public Object dataGrid(Search search, Integer page, Integer rows, String sort, String order) {
        PageInfo pageInfo = new PageInfo(page, rows);
        Map<String, Object> condition = new HashMap<String, Object>();
        if (StringUtils.isNotBlank(search.getName())) {
            logger.getName();
            condition.put("name", search.getName());
        }
        if (search.getStartTime() != null) {
            condition.put("startTime", search.getStartTime());
        }
        if (search.getEndTime() != null) {
            condition.put("endTime", search.getEndTime());
        }
        pageInfo.setCondition(condition);
        crossDatabaseService.selectDataGrid(pageInfo);
        return pageInfo;
    }

    /** 查询所有实际出库表 */
    @ResponseBody
    @GetMapping(value = "crossDatabase")
    public List<CrossDatabase> queryAll() {
        return crossDatabaseService.queryAll();
    }

    @GetMapping("crossDatabase/insert")
    public String getAddShipmentPage() {
        return "outbound/crossDatabaseAdd";
    }

    /** 添加操作 */
    @ResponseBody
    @PostMapping(value = "crossDatabase")
    public Object addShipment(CrossDatabase crossDatabase, String byTime) {
        crossDatabase.setCdTime(TimeUtils.updateTime(byTime));
        int result = crossDatabaseService.addCrossDatabase(crossDatabase);
        if (result > 0) {
            return renderSuccess("添加成功!");
        } else {
            return renderError("添加失败!");
        }
    }

    /** 删除操作 */
    @ResponseBody
    @PostMapping(value = "crossDatabase/delete")
    public Object deleteById(Integer id) {
        int result = crossDatabaseService.deleteById(id);
        if (result > 0) {
            return renderSuccess("删除成功!");
        } else {
            return renderError("删除失败!");
        }
    }

    /** 进入编辑页面 */
    @GetMapping(value = "getEditPage")
    public String editPage(Model model, @RequestParam(value = "id") Integer id) {
        CrossDatabase crossDatabase = crossDatabaseService.selectById(id);
        model.addAttribute("crossDatabase", crossDatabase);
        return "outbound/crossDatabaseEdit";
    }

    /** 更新操作 */
    @ResponseBody
    @PostMapping(value = "crossDatabase/update")
    public Object updateShipment(CrossDatabase crossDatabase, String byTime) {
    	
    	Shipment shipment = new Shipment();
        shipment.setShSkumodel(crossDatabase.getCdSkumodel());
        shipment.setShStoreid(crossDatabase.getStore());
        shipment.setShTime(TimeUtils.updateTime(byTime));
        shipment.setShPhone(crossDatabase.getPhone());
        shipment.setShSippingno(crossDatabase.getCdOddnumbers());
        shipment.setShWhid(crossDatabase.getCdWhid());
        shipment.setShDamage(crossDatabase.getDamage());
        shipment.setShCause(crossDatabase.getCause());
        shipment.setShShnum(crossDatabase.getCdNum());
        shipment.setShTotalweigh(crossDatabase.getTotalweigh());
        shipment.setShTotalvolume(crossDatabase.getCdVolume());
        Cargo cargo = cargoService.selectBySkumodel(crossDatabase.getCdSkumodel());
        int a = shipmentService.addShipment(shipment);
        if(cargo.getcNum() == shipment.getShShnum().intValue()){
        	cargoService.deleteBySjumodel(cargo.getcSkumodel());
        }else if(cargo.getcNum()>shipment.getShShnum().intValue()){
        	int num = cargo.getcNum()-shipment.getShShnum().intValue();
        	Cargo cargos = new Cargo();
        	cargos.setcId(cargo.getcId());
        	cargos.setcName(cargo.getcName());
        	cargos.setcNum(num);
        	cargos.setcPhone(cargo.getcPhone());
        	cargos.setcShippingno(cargo.getcShippingno());
        	cargos.setcSkumodel(cargo.getcSkumodel());
        	cargos.setcStorerid(cargo.getcStorerid());
        	cargos.setcSupplierid(cargo.getcSupplierid());
        	cargos.setcTotalvolume(cargo.getcTotalvolume()-shipment.getShTotalvolume());
        	cargos.setcTotalweight(cargo.getcTotalweight()-shipment.getShTotalweigh());
        	cargos.setcWhid(cargo.getcWhid());
        	cargos.setcReceivedate(cargo.getcReceivedate());
        	cargoService.updateByPrimaryKeySelective(cargos);
        }
        if (a>0) {
        	crossDatabase.setCdTime(TimeUtils.updateTime(byTime));
            crossDatabase.setStatus(1);
            int result = crossDatabaseService.updateCrossDatabase(crossDatabase);
        	if(result>0){
        		return renderSuccess("确认成功!");
        	}else{
        		return renderError("确认失败!");
        	}
        } else {
            return renderError("确认失败!");
        }
    }

    @GetMapping("importCrossDatabase.html")
    public String importPage(){
        return "outbound/crossDatabaseImport";
    }

    /** 读取提交的Excel */
    @PostMapping("readExcle")
    public String readExcle(@RequestParam("file") MultipartFile file, Model model) {
        String path = (CrossDatabaseController.class.getResource("/").toString()).substring(6);
        if (!file.isEmpty()) {
            try {
                Streams.copy(file.getInputStream(), new FileOutputStream(path + "/" + file.getOriginalFilename()), true);
                URL url = GodownEntryController.class.getResource("/" + file.getOriginalFilename());
                List<List<String>> lists = ReadXls.readxls(url.getFile());
                CrossDatabase crossDatabase = new CrossDatabase();
                List<String> objects = lists.get(0);
                for (int i = 0; i < objects.size(); i++) {
                    crossDatabase.setCdName(objects.get(0));
                    crossDatabase.setCdSkumodel(objects.get(1));
                    crossDatabase.setStore(objects.get(2));
                    crossDatabase.setPhone(objects.get(3));
                    crossDatabase.setCdNum(Double.valueOf(objects.get(4)));
                    crossDatabase.setTotalweigh(Double.valueOf(objects.get(5)));
                    crossDatabase.setCdVolume(Double.valueOf(objects.get(6)));
                    crossDatabase.setCdWhid(objects.get(7));
                    crossDatabase.setCdOddnumbers(objects.get(8));
                    crossDatabase.setCdTime(TimeUtils.updateTime("".equals(objects.get(9)) ? null : objects.get(9)));
                    crossDatabase.setStatus(0);
                }
                model.addAttribute("crossDatabase", crossDatabase);
            } catch (Exception e) {
                model.addAttribute("error", "请导入正确的数据!!!");
                e.printStackTrace();
            }
        }
        return "outbound/crossDatabaseImport";
    }

    @ResponseBody
    @PostMapping(value = "crossDatabase.php")
    public Object importCrossDatabase(CrossDatabase crossDatabase,String byTime){
    	crossDatabase.setStatus(0);
    	crossDatabase.setCause("");
        crossDatabase.setCdTime(TimeUtils.updateTime(byTime));
        int result = crossDatabaseService.importCrossDatabase(crossDatabase);
        if (result > 0) {
            return renderSuccess("添加成功!");
        }
        return renderError("添加失败!");
    }

}