package com.lys.ddshop.service.impl;

import com.dhc.ddshop.dao.TbItemCatMapper;
import com.dhc.ddshop.pojo.po.TbItemCat;
import com.dhc.ddshop.pojo.po.TbItemCatExample;
import com.lys.ddshop.common.dto.TreeNode;
import com.lys.ddshop.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Administrator
 * Date: 2017/11/11
 * Time: 11:26
 * Version:V1.0
 */
@Service
public class ItemCatServiceImpl implements ItemCatService{
    @Autowired
    private TbItemCatMapper itemCatDao;

    @Override
    public List<TreeNode> listItemCatsByPid(Long parentId) {
        List<TreeNode> treeNodeList=null;
        try {
            //创建查询模板
            TbItemCatExample example = new TbItemCatExample();
            TbItemCatExample.Criteria criteria = example.createCriteria();
            criteria.andParentIdEqualTo(parentId);
            //执行查询
            List<TbItemCat> itemCatList = itemCatDao.selectByExample(example);
            //要序列化成JSON的列表对象
            treeNodeList = new ArrayList<TreeNode>();
            //遍历原有列表生成新列表
            for (int i=0;i<itemCatList.size();i++){
                TbItemCat itemCat = itemCatList.get(i);
                TreeNode treeNode = new TreeNode();
                treeNode.setId(itemCat.getId());
                treeNode.setText(itemCat.getName());
                treeNode.setState(itemCat.getIsParent()? "closed":"open");

                treeNodeList.add(treeNode);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return treeNodeList;
    }
}
