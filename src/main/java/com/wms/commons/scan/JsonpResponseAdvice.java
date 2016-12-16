package com.wms.commons.scan;

import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

/**
 * 自动jsonp
 */
@ControllerAdvice
public class JsonpResponseAdvice extends AbstractJsonpResponseBodyAdvice {

    public JsonpResponseAdvice() {
        super("callback");
    }

    @Override
    protected MediaType getContentType(MediaType contentType, ServerHttpRequest request, ServerHttpResponse response) {
        return new MediaType("application", "javascript", contentType.getCharset());
    }
}
