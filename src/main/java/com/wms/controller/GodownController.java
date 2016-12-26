package com.wms.controller;

import com.wms.bean.Godown;
import com.wms.commons.bean.ComboBox4EasyUI;
import com.wms.service.GodownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：仓库表控制器层
 * Created by ZhongYu on 2016/12/26.
 */
@RequestMapping("godown")
@Controller
public class GodownController {

    @Autowired
    private GodownService godownService;

    /** 仓库EasyUI下拉框 */
    @ResponseBody
    @GetMapping("godownComboBox")
    public List<ComboBox4EasyUI> listComboBox4EasyUi() {
        List<ComboBox4EasyUI> comboBox4EasyUIS = new ArrayList<>();
        List<Godown> godowns = godownService.godownComboBox();
        for (Godown godown : godowns) {
            ComboBox4EasyUI comboBox4EasyUI = new ComboBox4EasyUI();
            comboBox4EasyUI.setId(String.valueOf(godown.getGoId()));
            comboBox4EasyUI.setText(godown.getGoWhid());
            comboBox4EasyUIS.add(comboBox4EasyUI);
        }
        return comboBox4EasyUIS;
    }

}