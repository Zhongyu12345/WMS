package com.wms.service;

import com.wms.bean.Shipment;
import com.wms.commons.utils.PageInfo;

import java.util.List;

/**
 * Created by ZhongYu on 2016/12/19.
 */
public interface ShipmentService {

    List<Shipment> queryAll();

    void selectDataGrid(PageInfo pageInfo);

    int addShipment(Shipment shipment);
}
