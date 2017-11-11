package com.dhc.ddshop.dao;

import com.dhc.ddshop.pojo.vo.TbItemCustom;

import java.util.List;
import java.util.Map;

/**
 * User: Administrator
 * Date: 2017/11/7
 * Time: 21:36
 * Version:V1.0
 */
public interface TbItemCustomMapper {
    int countItems(Map<String,Object> map);
    List<TbItemCustom> listItemsByPage(Map<String,Object> map);
}

