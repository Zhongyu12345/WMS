package com.wms.service;

<<<<<<< Updated upstream
=======
import java.util.List;

>>>>>>> Stashed changes
import com.wms.bean.Allotput;
import com.wms.commons.utils.PageInfo;

public interface AllotputService {

    int deleteByPrimaryKey(Integer apId);

    int insert(Allotput record);

    int insertSelective(Allotput record);

<<<<<<< Updated upstream
    Allotput selectByPrimaryKey(Integer apId);
=======
    List<Allotput> selectByPrimaryKey(Integer apId);
>>>>>>> Stashed changes
    
    void selectAll(PageInfo pageinfo);

    int updateByPrimaryKeySelective(Allotput record);

    int updateByPrimaryKey(Allotput record);
}
