package com.wms.dao;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.wms.bean.Allotout;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AllotoutMapper {
    int deleteByPrimaryKey(Integer aoId);

    int insert(Allotout record);

    int insertSelective(Allotout record);

    Allotout selectByPrimaryKey(Integer aoId);

    int updateByPrimaryKeySelective(Allotout record);

    int updateByPrimaryKey(Allotout record);

    /**
     * 分页查询
     */
    List<Allotout> selectAllotoutPage(Pagination page, Map<String, Object> params);
}