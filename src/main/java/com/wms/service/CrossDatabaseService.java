package com.wms.service;

import com.wms.bean.CrossDatabase;
import com.wms.commons.utils.PageInfo;

import java.util.List;

/**
 * Created by ZhongYu on 2016/12/19.
 */
public interface CrossDatabaseService {

    List<CrossDatabase> queryAll();

    void selectDataGrid(PageInfo pageInfo);

    CrossDatabase selectById(Integer id);

    int addCrossDatabase(CrossDatabase crossDatabase);

    int deleteById(Integer id);

    int updateCrossDatabase(CrossDatabase crossDatabase);

    int importCrossDatabase(CrossDatabase crossDatabase);
}
