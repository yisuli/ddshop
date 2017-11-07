package com.lys.ddshop.service;

import com.dhc.ddshop.pojo.po.TbItem;

import java.util.List;

/**
 * User: Administrator
 * Date: 2017/11/6
 * Time: 16:40
 * Version:V1.0
 */
public interface ItemService {
    TbItem getById(Long itemId);
    List<TbItem> listItems();
}
