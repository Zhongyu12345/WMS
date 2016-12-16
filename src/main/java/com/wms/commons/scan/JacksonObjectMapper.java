package com.wms.commons.scan;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

/**
 * 解决Jackson 差8小时的问题
 */
@Component("jacksonObjectMapper")
public class JacksonObjectMapper extends ObjectMapper {

    private static final long serialVersionUID = 4288193147502386170L;

    private static final Locale CHINA = Locale.CHINA;

    public JacksonObjectMapper() {
        this.setLocale(CHINA);
        this.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", CHINA));
        this.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    }

}
