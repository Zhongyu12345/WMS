package com.wms.dao;

import org.springframework.stereotype.Repository;

import com.wms.bean.Godown;

import java.util.List;

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
}