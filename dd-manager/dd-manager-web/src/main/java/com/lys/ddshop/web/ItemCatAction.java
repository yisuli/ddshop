package com.lys.ddshop.web;

import com.lys.ddshop.common.dto.TreeNode;
import com.lys.ddshop.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * User: Administrator
 * Date: 2017/11/11
 * Time: 10:57
 * Version:V1.0
 */
@Controller
public class ItemCatAction {


    @Autowired
    private ItemCatService itemCatService;

    @ResponseBody
    @RequestMapping("/itemCats")
    public List<TreeNode> listItemCatsByPid(@RequestParam("parentId") Long parentId){
        List<TreeNode> treeNodeList=null;
        try {
            treeNodeList=itemCatService.listItemCatsByPid(parentId);
        }catch (Exception e){
            e.printStackTrace();
        }

        return treeNodeList;

    }
}
