package com.lys.ddshop.service.impl;


import com.dhc.ddshop.dao.TbItemCustomMapper;
import com.dhc.ddshop.dao.TbItemDescMapper;
import com.dhc.ddshop.dao.TbItemMapper;
import com.dhc.ddshop.pojo.po.TbItem;
import com.dhc.ddshop.pojo.po.TbItemDesc;
import com.dhc.ddshop.pojo.po.TbItemExample;
import com.dhc.ddshop.pojo.vo.TbItemCustom;
import com.dhc.ddshop.pojo.vo.TbItemQuery;
import com.lys.ddshop.common.dto.Order;
import com.lys.ddshop.common.dto.Page;
import com.lys.ddshop.common.dto.Result;
import com.lys.ddshop.common.util.IDUtils;
import com.lys.ddshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private TbItemDescMapper itemDescDao;

    @Override
    public TbItem getById(Long itemId) {
        TbItem tbItem = itemDao.selectByPrimaryKey(itemId);
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
    public Result<TbItemCustom> listItemsByPage(Page page, Order order, TbItemQuery query) {
        Result<TbItemCustom> result = null;
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("page", page);
            map.put("order", order);
            map.put("query", query);
            result = new Result<TbItemCustom>();

            int total = itemCustomDao.countItems(map);
            result.setTotal(total);

            List<TbItemCustom> list = itemCustomDao.listItemsByPage(map);
            result.setRows(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int updateBatch(List<Long> ids) {
        int i = 0;
        try {
            TbItem record = new TbItem();
            record.setStatus((byte) 3);
            TbItemExample example = new TbItemExample();
            TbItemExample.Criteria criteria = example.createCriteria();
            criteria.andIdIn(ids);
            i = itemDao.updateByExampleSelective(record, example);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int addBatch(List<Long> ids) {
        int i = 0;
        try {
            TbItem record = new TbItem();
            record.setStatus((byte) 1);
            TbItemExample example = new TbItemExample();
            TbItemExample.Criteria criteria = example.createCriteria();
            criteria.andIdIn(ids);
            i = itemDao.updateByExampleSelective(record, example);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int deleteBatch(List<Long> ids) {
        int i = 0;
        try {
            TbItem record = new TbItem();
            record.setStatus((byte) 2);
            TbItemExample example = new TbItemExample();
            TbItemExample.Criteria criteria = example.createCriteria();
            criteria.andIdIn(ids);
            i = itemDao.updateByExampleSelective(record, example);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    @Transactional
    @Override
    public int saveItem(TbItem tbItem, String content) {
        int i = 0;
        try {
            long itemId = IDUtils.getItemId();
            tbItem.setId(itemId);
            tbItem.setStatus((byte) 2);
            tbItem.setCreated(new Date());
            tbItem.setUpdated(new Date());
            i = itemDao.insert(tbItem);
            TbItemDesc desc = new TbItemDesc();
            desc.setItemId(itemId);
            desc.setItemDesc(content);
            desc.setCreated(new Date());
            desc.setUpdated(new Date());
            i += itemDescDao.insert(desc);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }
}
