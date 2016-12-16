package com.wms.commons.utils;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;

/**
 * Miscellaneous utilities for web applications.
 */
public class WebUtils extends org.springframework.web.util.WebUtils {
    /**
     * 判断是否ajax请求
     * spring ajax 返回含有 ResponseBody 或者 RestController注解
     *
     * @param handlerMethod HandlerMethod
     * @return 是否ajax请求
     */
    public static boolean isAjax(HandlerMethod handlerMethod) {
        ResponseBody responseBody = handlerMethod.getMethodAnnotation(ResponseBody.class);
        if (null != responseBody) {
            return true;
        }
        RestController restAnnotation = handlerMethod.getBean().getClass().getAnnotation(RestController.class);
        if (null != restAnnotation) {
            return true;
        }
        return false;
    }
}
