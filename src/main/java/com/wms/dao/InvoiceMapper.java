package com.wms.dao;

import org.springframework.stereotype.Repository;

import com.wms.bean.Invoice;

/**
 * Invoice 直接发货单
 */
@Repository
public interface InvoiceMapper {
    int deleteByPrimaryKey(Integer inId);

    int insert(Invoice record);

    int insertSelective(Invoice record);

    Invoice selectByPrimaryKey(Integer inId);

    int updateByPrimaryKeySelective(Invoice record);

    int updateByPrimaryKey(Invoice record);
}