package com.wms.service;

import com.wms.bean.Invoice;
import com.wms.commons.utils.PageInfo;

import java.util.List;

/**
 * Created by ZhongYu on 2016/12/19.
 */
public interface InvoiceService {

    List<Invoice> queryAll();

    void selectDataGrid(PageInfo pageInfo);

    Invoice selectById(Integer id);

    int addInvoice(Invoice invoice);

    int insert(Invoice invoice);

    int deleteById(Integer id);

    int updateInvoice(Invoice invoice);

    int importInvoice(Invoice invoice);
}
