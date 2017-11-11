package com.lys.ddshop.service;

import com.lys.ddshop.common.dto.TreeNode;

import java.util.List;

/**
 * User: Administrator
 * Date: 2017/11/11
 * Time: 11:25
 * Version:V1.0
 */
public interface ItemCatService {
    List<TreeNode> listItemCatsByPid(Long parentId);
}
