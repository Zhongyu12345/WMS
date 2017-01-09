package com.wms.dao;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.wms.bean.Godown;

import java.util.List;
import java.util.Map;

@Repository
public interface GodownMapper {

    /** 仓库EasyUI下拉框查询 */
    List<Godown> findByComboBox4EasyUi();

    int deleteByPrimaryKey(Integer goId);

    int insert(Godown record);

    int insertSelective(Godown record);

    Godown selectByPrimaryKey(Integer goId);

    int updateByPrimaryKeySelective(Godown record);

    int updateByPrimaryKey(Godown record);
    
    List<Godown> selectDataGrid(Pagination page, Map<String, Object> params);
    
    Godown selectByWhid(String whid);
}