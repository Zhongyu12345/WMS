package com.wms.dao;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.springframework.stereotype.Repository;
import com.wms.bean.Cargo;
import java.util.List;
import java.util.Map;

@Repository
public interface CargoMapper {
    int deleteByPrimaryKey(Integer cId);

    int insert(Cargo record);

    int insertSelective(Cargo record);

    Cargo selectByPrimaryKey(Integer cId);

    Cargo selectByid(Integer cId);

    List<Cargo> select(Pagination page,Map<String,Object> map);

    int updateByPrimaryKeySelective(Cargo record);

    int updateByPrimaryKey(Cargo record);

    int update(Cargo cargo);

    int updatenum(Cargo cargo);
    
    Cargo selectBySkumodel(String Skumodel);
    
    int deleteBySkumodel(String Skumodel);
}