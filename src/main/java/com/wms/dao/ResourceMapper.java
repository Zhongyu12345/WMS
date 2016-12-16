package com.wms.dao;

import com.baomidou.mybatisplus.mapper.AutoMapper;
import com.wms.bean.Resource;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Resource 表数据库控制层接口
 */
@Repository
public interface ResourceMapper extends AutoMapper<Resource> {

    List<Resource> selectAllByTypeAndPIdNull(@Param("resourceType") Integer resourceType);

    List<Resource> selectAllByTypeAndPId(@Param("resourceType") Integer resourceType, @Param("pId") Long pId);

    List<Resource> selectAll();

}