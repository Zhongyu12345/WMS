package com.wms.service;

import com.baomidou.framework.service.ISuperService;
import com.wms.bean.Resource;
import com.wms.bean.User;
import com.wms.commons.result.Tree;

import java.util.List;

/**
 * Resource 表数据服务层接口
 */
public interface IResourceService extends ISuperService<Resource> {

    List<Resource> selectAll();

    List<Tree> selectAllTree();

    List<Tree> selectAllTrees();

    List<Tree> selectTree(User currentUser);

}