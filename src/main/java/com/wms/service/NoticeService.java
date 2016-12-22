package com.wms.service;

import java.util.List;

import com.wms.bean.Notice;
import com.wms.commons.utils.PageInfo;

public interface NoticeService {

    List<Notice> queryAll();

    void selectDataGrid(PageInfo pageInfo);

    Notice selectById(Integer id);

    int addShipment(Notice notice);

    int deleteById(Integer id);

    int updateShipment(Notice notice);
}
