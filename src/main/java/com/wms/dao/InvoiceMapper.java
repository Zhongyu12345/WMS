package com.wms.dao;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.wms.bean.Invoice;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/** 直接发货单 */
@Repository
public interface InvoiceMapper {

    /** 查询所有 */
    List<Invoice> queryAll();

    /** 分页查询 */
    List<Invoice> selectInvoicePage(Pagination page, Map<String, Object> params);

    /** 根据ID删除 */
    int deleteByPrimaryKey(Integer inId);

    /** 添加 */
    int insert(Invoice record);

    /** 动态SQL添加 */
    int insertSelective(Invoice record);

    /** 根据ID查询 */
    Invoice selectByPrimaryKey(Integer inId);

    /** 根据ID更新 动态SQL */
    int updateByPrimaryKeySelective(Invoice record);

    /** 根据ID更新 */
    int updateByPrimaryKey(Invoice record);
}