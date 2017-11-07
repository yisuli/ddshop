package com.dhc.ddshop.dao;

import com.dhc.ddshop.pojo.po.TbItem;
import com.lys.ddshop.common.dto.Page;

import java.util.List;

/**
 * User: Administrator
 * Date: 2017/11/7
 * Time: 21:36
 * Version:V1.0
 */
public interface TbItemCustomMapper {
    int countItems();
    List<TbItem> listItemsByPage(Page page);
}
