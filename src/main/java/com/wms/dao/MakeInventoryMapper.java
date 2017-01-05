package com.wms.dao;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.springframework.stereotype.Repository;
import com.wms.bean.MakeInventory;
import java.util.List;
import java.util.Map;

@Repository
public interface MakeInventoryMapper {
    int deleteByPrimaryKey(Integer miId);

    int insert(MakeInventory record);

    int insertSelective(MakeInventory record);

    MakeInventory selectByPrimaryKey(Integer miId);

    List<MakeInventory> select(Pagination pagination,Map<String,Object> map);

    int updateByPrimaryKeySelective(MakeInventory record);

    int updateByPrimaryKey(MakeInventory record);
    
    List<MakeInventory> selectByOrder(String order);
}