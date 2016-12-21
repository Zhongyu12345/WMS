package com.wms.service;

import com.wms.bean.SalesReturn;
import com.wms.commons.utils.PageInfo;

public interface SalesReturnService {
	
		int deleteByPrimaryKey(Integer srId);

	    int insert(SalesReturn record);

	    int insertSelective(SalesReturn record);

	    SalesReturn selectByPrimaryKey(Integer srId);
	    
	    void selectAll(PageInfo pageinfo);

	    int updateByPrimaryKeySelective(SalesReturn record);

	    int updateByPrimaryKey(SalesReturn record);
}
