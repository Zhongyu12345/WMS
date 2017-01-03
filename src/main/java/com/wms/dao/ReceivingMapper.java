package com.wms.dao;

import java.util.List;
<<<<<<< Updated upstream
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
=======

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.plugins.Page;
>>>>>>> Stashed changes
import com.wms.bean.Receiving;

@Repository
public interface ReceivingMapper {
    int deleteByPrimaryKey(Integer rId);

    int insert(Receiving record);

    int insertSelective(Receiving record);

	Receiving selectByPrimaryKey(Integer rId);
	
<<<<<<< Updated upstream
//	List<Receiving> selectAll(Page<Receiving> page);
	
	List<Receiving> selectAll(Pagination page, Map<String, Object> params);
=======
	List<Receiving> selectAll(Page<Receiving> page);
>>>>>>> Stashed changes

    int updateByPrimaryKeySelective(Receiving record);

    int updateByPrimaryKey(Receiving record);
}