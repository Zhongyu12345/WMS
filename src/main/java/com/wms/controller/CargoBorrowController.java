package com.wms.controller;

import com.wms.bean.CargoBorrow;
import com.wms.bean.vo.UserVo;
import com.wms.commons.base.BaseController;
import com.wms.commons.utils.PageInfo;
import com.wms.service.CargoBorrowService;
import com.wms.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 货品借出登记
 * Created by DengMin on 2016/12/21.
 */
@Controller
@RequestMapping("/borrow")
public class CargoBorrowController extends BaseController{

    @Autowired
    private CargoBorrowService cargoborrowservice;

    @Autowired
    private IUserService iUserService;

    /**
     * 跳转到货品借出登记页面
     * @return
     */
    @GetMapping("/borrowpage")
    public String borrowpage(){
        return "adjustment/cargoborrow";
    }

    /**
     * 跳转到添加页面
     * @return
     */
    @GetMapping("/borrowaddpage")
    public String borrowaddpage(){
        return "adjustment/cargoborrowadd";
    }

    /**
     * 跳转到修改页面
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/editPage")
    public String editPage(Integer id, Model model){
        CargoBorrow cargoBorrow = cargoborrowservice.selectByPrimaryKey(id);
        model.addAttribute("cargoBorrow",cargoBorrow);
        return "adjustment/cargoborrowedit";
    }

    /**
     * 新增货品借出
     * @param cargoBorrow
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public Object add(CargoBorrow cargoBorrow){
        cargoBorrow.setCbStatus("未归还");
        int result = cargoborrowservice.insert(cargoBorrow);
        if(result > 0){
            return renderSuccess("添加成功");
        }
        return renderError("添加失败");
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public Object deleteByPrimaryKey(Integer id){
        int result = cargoborrowservice.deleteByPrimaryKey(id);
        if(result > 0){
            return renderSuccess("删除成功");
        }
        return  renderError("删除失败");
    }

    /**
     * 分页查询
     * @param cargoBorrow
     * @param page
     * @param rows
     * @return
     */
    @PostMapping("/selectByPage")
    @ResponseBody
    public Object select(CargoBorrow cargoBorrow,Integer page, Integer rows){
        PageInfo pageInfo = new PageInfo(page,rows);
        Map<String,Object> map = new HashMap<String,Object>();
        if(cargoBorrow.getCbSkumodel() != null){
            map.put("CBSK",cargoBorrow.getCbSkumodel());
        }
        if(cargoBorrow.getCreatedateStart() != null){
            map.put("startTime",cargoBorrow.getCreatedateStart());
        }
        if(cargoBorrow.getCreatedateEnd() != null){
            map.put("endTime",cargoBorrow.getCreatedateEnd());
        }
        pageInfo.setCondition(map);
        cargoborrowservice.select(pageInfo);
        return pageInfo;
    }

    /**
     * 普通用户分页查询
     * @param userVo
     * @return
     */
    @RequestMapping("/user")
    @ResponseBody
    public Object SelectUserBytype(UserVo userVo){
        Map<String,Object> map = new HashMap<>();
        if(userVo.getName() != null){
            map.put("name",userVo.getName());
        }
        List<UserVo> list = iUserService.selectUserBytype(map);
        return list;
    }

    /**
     * 修改
     * @param cargoBorrow
     * @return
     */
    @RequestMapping("/edit")
    @ResponseBody
    public Object Edit(CargoBorrow cargoBorrow){
        cargoBorrow.setCbStatus("已归还");
        int result = cargoborrowservice.updateByPrimaryKey(cargoBorrow);
        if(result > 0){
            return renderSuccess("修改成功");
        }
        return renderError("修改失败");
    }

}
