package com.lys.ddshop.service.impl;


import com.dhc.ddshop.dao.TbItemCustomMapper;
import com.dhc.ddshop.dao.TbItemMapper;
import com.dhc.ddshop.pojo.po.TbItem;
import com.lys.ddshop.common.dto.Page;
import com.lys.ddshop.common.dto.Result;
import com.lys.ddshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: Administrator
 * Date: 2017/11/6
 * Time: 16:43
 * Version:V1.0
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private TbItemMapper itemDao;
    @Autowired
    private TbItemCustomMapper itemCustomDao;

    @Override
    public TbItem getById(Long itemId) {
        TbItem tbItem= itemDao.selectByPrimaryKey(itemId);
        return tbItem;
    }

    /*@Override
    public List<TbItem> listItems() {
        List<TbItem> list = null;
        try {
            list = itemDao.selectByExample(null);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }*/

    @Override
    public Result<TbItem> listItemsByPage(Page page) {
       Result<TbItem> result = null;
        try {
            result=new Result<TbItem>();

            int total=itemCustomDao.countItems();
            result.setTotal(total);

           List<TbItem> list = itemCustomDao.listItemsByPage(page);
            result.setRows(list);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
