package com.wms.service.impl;

import com.baomidou.framework.service.impl.SuperServiceImpl;
import com.wms.bean.Children;
import com.wms.bean.Resource;
import com.wms.bean.User;
import com.wms.commons.result.Tree;
import com.wms.dao.ResourceMapper;
import com.wms.dao.RoleMapper;
import com.wms.dao.UserRoleMapper;
import com.wms.service.IResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Resource 表数据服务层接口实现类
 */
@Service
public class ResourceServiceImpl extends SuperServiceImpl<ResourceMapper, Resource> implements IResourceService {

    private static final int RESOURCE_MENU = 0; //菜单
    private static final int RESOURCE_BUTTON = 1; //按钮

    @Autowired
    private ResourceMapper resourceMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Resource> selectAll() {
        return resourceMapper.selectAll();
    }

    @Override
    public List<Tree> selectAllTree() {
        List<Tree> trees = new ArrayList<Tree>();
        // 查询所有的一级树
        List<Resource> resources = resourceMapper.selectAllByTypeAndPIdNull(RESOURCE_MENU);
        if (resources == null) {
            return null;
        }
        for (Resource resourceOne : resources) {
            Tree treeOne = new Tree();

            treeOne.setId(resourceOne.getId());
            treeOne.setText(resourceOne.getName());
            treeOne.setIconCls(resourceOne.getIcon());
            treeOne.setAttributes(resourceOne.getUrl());
            //查询所有一级树下的菜单
            List<Resource> resourceSon = resourceMapper.selectAllByTypeAndPId(RESOURCE_MENU, resourceOne.getId());

            if (resourceSon != null) {
                List<Children> tree = new ArrayList<Children>();
                for (Resource resourceTwo : resourceSon) {
                    Children treeTwo = new Children();
                    treeTwo.setId(resourceTwo.getId());
                    treeTwo.setText(resourceTwo.getName());
                    treeTwo.setIconCls(resourceTwo.getIcon());
                    treeTwo.setAttributes(resourceTwo.getUrl());

                    List<Resource> resourceSons = resourceMapper.selectAllByTypeAndPId(RESOURCE_MENU, resourceTwo.getId());
                    if (resourceSons != null) {
                        List<Children> children = new ArrayList<Children>();
                        for (Resource resourceThree : resourceSons) {
                            Children treeThree = new Children();
                            treeThree.setId(resourceThree.getId());
                            treeThree.setText(resourceThree.getName());
                            treeThree.setIconCls(resourceThree.getIcon());
                            treeThree.setAttributes(resourceThree.getUrl());
                            children.add(treeThree);
                        }
                        treeTwo.setChildrenes(children);
                        tree.add(treeTwo);
                    } else {
                        treeTwo.setState("closed");
                    }
                    treeOne.setChildrens(tree);
                }
            } else {
                treeOne.setState("closed");
            }
            trees.add(treeOne);
        }
        return trees;
    }

    @Override
    public List<Tree> selectAllTrees() {
        List<Tree> treeOneList = new ArrayList<Tree>();
        //查询所有的一级树
        List<Resource> resources = resourceMapper.selectAllByTypeAndPIdNull(RESOURCE_MENU);
        if (resources == null) {
            return null;
        }
        for (Resource resourceOne : resources) {
            Tree treeOne = new Tree();
            treeOne.setId(resourceOne.getId());
            treeOne.setText(resourceOne.getName());
            treeOne.setIconCls(resourceOne.getIcon());
            treeOne.setAttributes(resourceOne.getUrl());
            List<Resource> resourceSon = resourceMapper.selectAllByTypeAndPId(RESOURCE_MENU, resourceOne.getId());
            if (resourceSon == null) {
                treeOne.setState("closed");
            } else {
                List<Tree> treeTwoList = new ArrayList<Tree>();

                for (Resource resourceTwo : resourceSon) {
                    Tree treeTwo = new Tree();

                    treeTwo.setId(resourceTwo.getId());
                    treeTwo.setText(resourceTwo.getName());
                    treeTwo.setIconCls(resourceTwo.getIcon());
                    treeTwo.setAttributes(resourceTwo.getUrl());

                    /***************************************************/
                    List<Resource> resourceSons = resourceMapper.selectAllByTypeAndPId(RESOURCE_BUTTON, resourceTwo.getId());

                    if (resourceSons == null) {
                        treeTwo.setState("closed");
                    } else {
                        List<Tree> treeThreeList = new ArrayList<Tree>();

                        for (Resource resourceThree : resourceSons) {
                            Tree treeThree = new Tree();
                            treeThree.setId(resourceThree.getId());
                            treeThree.setText(resourceThree.getName());
                            treeThree.setIconCls(resourceThree.getIcon());
                            treeThree.setAttributes(resourceThree.getUrl());
                            treeThreeList.add(treeThree);
                        }
                        treeTwo.setChildren(treeThreeList);
                    }
                    /***************************************************/

                    treeTwoList.add(treeTwo);
                }
                treeOne.setChildren(treeTwoList);
            }

            treeOneList.add(treeOne);
        }
        return treeOneList;
    }

    @Override
    public List<Tree> selectTree(User user) {
        List<Tree> trees = new ArrayList<Tree>();
        //超级管理
        if (user.getLoginName().equals("admin")) {
            List<Resource> resourceFather = resourceMapper.selectAllByTypeAndPIdNull(RESOURCE_MENU);
            if (resourceFather == null) {
                return null;
            }
            for (Resource resourceOne : resourceFather) {
                Tree treeOne = new Tree();
                treeOne.setId(resourceOne.getId());
                treeOne.setText(resourceOne.getName());
                treeOne.setIconCls(resourceOne.getIcon());
                treeOne.setAttributes(resourceOne.getUrl());
                List<Resource> resourceSon = resourceMapper.selectAllByTypeAndPId(RESOURCE_MENU, resourceOne.getId());
                if (resourceSon != null) {
                    List<Tree> tree = new ArrayList<Tree>();
                    for (Resource resourceTwo : resourceSon) {
                        Tree treeTwo = new Tree();
                        treeTwo.setId(resourceTwo.getId());
                        treeTwo.setText(resourceTwo.getName());
                        treeTwo.setIconCls(resourceTwo.getIcon());
                        treeTwo.setAttributes(resourceTwo.getUrl());
                        tree.add(treeTwo);
                    }
                    treeOne.setChildren(tree);
                } else {
                    treeOne.setState("closed");
                }
                trees.add(treeOne);
            }
            return trees;
        }
        // 普通用户
        List<Resource> resourceIdList = new ArrayList<Resource>();
        List<Long> roleIdList = userRoleMapper.selectRoleIdListByUserId(user.getId());
        for (Long id : roleIdList) {
            List<Resource> resourceIdLists = roleMapper.selectResourceIdListByRoleIdAndType(id);
            for (Resource resource : resourceIdLists) {
                resourceIdList.add(resource);
            }
        }
        for (Resource resource : resourceIdList) {
            if (resource != null && resource.getPid() == null) {
                Tree treeOne = new Tree();
                treeOne.setId(resource.getId());
                treeOne.setText(resource.getName());
                treeOne.setIconCls(resource.getIcon());
                treeOne.setAttributes(resource.getUrl());
                List<Tree> tree = new ArrayList<Tree>();
                for (Resource resourceTwo : resourceIdList) {
                    if (resourceTwo.getPid() != null && resource.getId().longValue() == resourceTwo.getPid().longValue()) {
                        Tree treeTwo = new Tree();
                        treeTwo.setId(resourceTwo.getId());
                        treeTwo.setText(resourceTwo.getName());
                        treeTwo.setIconCls(resourceTwo.getIcon());
                        treeTwo.setAttributes(resourceTwo.getUrl());
                        tree.add(treeTwo);
                    }
                }
                treeOne.setChildren(tree);
                trees.add(treeOne);
            }
        }
        return trees;
    }

}