package com.wms.service;

import com.wms.bean.Receiving;
import com.wms.commons.utils.PageInfo;

public interface ReceivingService {

	int deleteByPrimaryKey(Integer rId);
	
	int insert(Receiving record);
	
	int insertSelective(Receiving record);
	
	Receiving selectByPrimaryKey(Integer rId);
	
	void selectAll(PageInfo pageinfo);
	
	int updateByPrimaryKeySelective(Receiving record);
	
	int updateByPrimaryKey(Receiving record);
}
