package com.lys.ddshop.service.impl;


import com.dhc.ddshop.dao.TbItemCustomMapper;
import com.dhc.ddshop.dao.TbItemMapper;
import com.dhc.ddshop.pojo.po.TbItem;
import com.dhc.ddshop.pojo.po.TbItemExample;
import com.dhc.ddshop.pojo.vo.TbItemCustom;
import com.lys.ddshop.common.dto.Page;
import com.lys.ddshop.common.dto.Result;
import com.lys.ddshop.service.ItemService;
import jdk.nashorn.internal.runtime.RecompilableScriptFunctionData;
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
    public Result<TbItemCustom> listItemsByPage(Page page) {
       Result<TbItemCustom> result = null;
        try {
            result=new Result<TbItemCustom>();

            int total=itemCustomDao.countItems();
            result.setTotal(total);

           List<TbItemCustom> list= itemCustomDao.listItemsByPage(page);
            result.setRows(list);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int updateBatch(List<Long> ids) {
        int i=0;
        try {
            TbItem record=new TbItem();
            record.setStatus((byte)3);
            TbItemExample example=new TbItemExample();
            TbItemExample.Criteria criteria=example.createCriteria();
            criteria.andIdIn(ids);
            i=itemDao.updateByExampleSelective(record,example);
        }catch (Exception e){
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int addBatch(List<Long> ids) {
        int i=0;
        try {
            TbItem record=new TbItem();
            record.setStatus((byte)1);
            TbItemExample example=new TbItemExample();
            TbItemExample.Criteria criteria=example.createCriteria();
            criteria.andIdIn(ids);
            i=itemDao.updateByExampleSelective(record,example);
        }catch (Exception e){
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int deleteBatch(List<Long> ids) {
        int i=0;
        try {
            TbItem record=new TbItem();
            record.setStatus((byte)2);
            TbItemExample example=new TbItemExample();
            TbItemExample.Criteria criteria=example.createCriteria();
            criteria.andIdIn(ids);
            i=itemDao.updateByExampleSelective(record,example);
        }catch (Exception e){
            e.printStackTrace();
        }
        return i;
    }
}
