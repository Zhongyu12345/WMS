package com.wms.dao;

import org.springframework.stereotype.Repository;
import com.wms.bean.Allotout;

@Repository
public interface AllotoutMapper {
    int deleteByPrimaryKey(Integer aoId);

    int insert(Allotout record);

    int insertSelective(Allotout record);

    Allotout selectByPrimaryKey(Integer aoId);

    int updateByPrimaryKeySelective(Allotout record);

    int updateByPrimaryKey(Allotout record);
}