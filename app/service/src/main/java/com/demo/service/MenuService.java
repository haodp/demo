package com.demo.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.manual.ExtMenuMapper;
import com.demo.dao.manual.entity.ExtMenu;
import com.demo.model.TreeJsonModel;

@Service
public class MenuService {

	@Autowired
	private ExtMenuMapper mapper;

	/**
	 * 画面登陆处理按钮
	 * @param userId 用户ID
	 * @param pwd 密码
	 * @return 登陆结果
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public List<TreeJsonModel> init(String userId)  {
		// userID的权限下，对应的所有MenuID。
		List<ExtMenu> menus = mapper.selectMenuTree(userId);
		// 权限的检索
		return this.getFatherNode(menus);
	}


	   /**
     * 获取父节点菜单
     * @param treesList 所有树菜单集合
     * @return
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
     */
    private List<TreeJsonModel> getFatherNode(List<ExtMenu> treesList) {
        List<TreeJsonModel> newTrees = new ArrayList<TreeJsonModel>();
        TreeJsonModel model;
        for (ExtMenu mt : treesList) {
            if (mt.getParentId() == null) {//如果parentId为空，则该节点为根目录。
            	model = new TreeJsonModel();
            	model.setId(mt.getMenuId());
            	model.setText(mt.getMenuName());
            	model.setHref(mt.getRequestUrl());
            	model.setState(true);
                //递归获取父节点下的子节点
            	model.setNodes(this.getChildrenNode(mt.getMenuId(), treesList));
                newTrees.add(model);
            }
        }
        return newTrees;
    }

    /**
     * 递归获取子节点下的子节点
     * @param pId 父节点的ID
     * @param treesList 所有菜单树集合
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    private List<TreeJsonModel> getChildrenNode(Integer pId, List<ExtMenu> treesList) {
        List<TreeJsonModel> newTrees = new ArrayList<TreeJsonModel>();
        TreeJsonModel model;
        for (ExtMenu mt : treesList) {
        	model = new TreeJsonModel();
            if (pId == null || mt.getParentId() == null) {
            	continue;
            }
            if(mt.getParentId().equals(pId)){
                //递归获取子节点下的子节点，即设置树控件中的children
            	model.setId(mt.getMenuId());
            	model.setText(mt.getMenuName());
            	model.setHref(mt.getRequestUrl());
            	model.setState(true);
            	model.setNodes(this.getChildrenNode(mt.getMenuId(), treesList));
            	newTrees.add(model);
            }
        }

        return newTrees;
    }

}
