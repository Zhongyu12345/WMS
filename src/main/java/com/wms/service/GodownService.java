package com.wms.service;

import com.wms.bean.Godown;
import com.wms.commons.utils.PageInfo;

import java.util.List;

/**
 * 描述：仓库表服务接口
 * Created by ZhongYu on 2016/12/26.
 */
public interface GodownService {

    /** 仓库下拉框 */
    List<Godown> godownComboBox();
    
    void selectDataGrid(PageInfo pageInfo);
    
    int updateByPrimaryKey(Godown record);
    
    Godown selectByPrimaryKey(Integer goId);

    int insert(Godown godown);
    
    int updateStatus(Godown godown);
    
    Godown selectById(int id);

}