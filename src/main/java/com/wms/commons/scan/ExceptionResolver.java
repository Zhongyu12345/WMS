package com.wms.commons.scan;

import com.wms.commons.result.Result;
import com.wms.commons.utils.BeanUtils;
import com.wms.commons.utils.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 异常处理，对ajax类型的异常返回ajax错误，避免页面问题
 */
@Component
@SuppressWarnings("unchecked")
public class ExceptionResolver implements HandlerExceptionResolver {

    private static Logger logger = LoggerFactory.getLogger(ExceptionResolver.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) {
        //og记录异常
        logger.error(e.getMessage(), e);
        //非控制器请求照成的异常
        if (!(handler instanceof HandlerMethod)) {
            return new ModelAndView("error/500");
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        if (WebUtils.isAjax(handlerMethod)) {
            Result result = new Result();
            result.setMsg(e.getMessage());
            return new ModelAndView(new MappingJackson2JsonView(), BeanUtils.toMap(result));
        }
        return new ModelAndView("error/500");
    }

}