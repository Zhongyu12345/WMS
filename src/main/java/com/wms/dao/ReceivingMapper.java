package com.wms.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.wms.bean.Receiving;

@Repository
public interface ReceivingMapper {
    int deleteByPrimaryKey(Integer rId);

    int insert(Receiving record);

    int insertSelective(Receiving record);

	Receiving selectByPrimaryKey(Integer rId);
	
//	List<Receiving> selectAll(Page<Receiving> page);
	
	List<Receiving> selectAll(Pagination page, Map<String, Object> params);

    int updateByPrimaryKeySelective(Receiving record);

    int updateByPrimaryKey(Receiving record);
    
    Receiving selectByNo(String No);
    
    Receiving selectByModel(String model);
}