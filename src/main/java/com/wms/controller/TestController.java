package com.wms.controller;

import com.wms.commons.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试Controller
 */
@Controller
@RequestMapping("/test")
public class TestController extends BaseController {

    /**
     * 图标测试
     *
     * @return
     */
    @GetMapping("/dataGrid")
    public String dataGrid() {
        return "admin/test";
    }

}
