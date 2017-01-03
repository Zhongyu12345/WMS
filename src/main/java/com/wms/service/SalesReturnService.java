package com.wms.service;

<<<<<<< Updated upstream
=======
import java.util.List;

>>>>>>> Stashed changes
import com.wms.bean.SalesReturn;
import com.wms.commons.utils.PageInfo;

public interface SalesReturnService {
	
		int deleteByPrimaryKey(Integer srId);

	    int insert(SalesReturn record);

	    int insertSelective(SalesReturn record);

<<<<<<< Updated upstream
	    SalesReturn selectByPrimaryKey(Integer srId);
=======
	    List<SalesReturn> selectByPrimaryKey(Integer srId);
>>>>>>> Stashed changes
	    
	    void selectAll(PageInfo pageinfo);

	    int updateByPrimaryKeySelective(SalesReturn record);

	    int updateByPrimaryKey(SalesReturn record);
}
