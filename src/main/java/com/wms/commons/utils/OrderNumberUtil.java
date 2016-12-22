package com.wms.commons.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 描述：订单生成工具类
 * Created by ZhongYu on 2016/12/21.
 */
public class OrderNumberUtil {

    public static String generateOrderNo() {
        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        StringBuilder stringBuilder = new StringBuilder(format.format(new Date()));
        for (int i = 0; i < 1; i++) {
            stringBuilder.append(new Random().nextInt(2));
        }
        return stringBuilder.toString();
    }

}