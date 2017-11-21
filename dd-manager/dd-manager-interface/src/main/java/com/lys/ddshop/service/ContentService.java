package com.lys.ddshop.service;

import com.dhc.ddshop.pojo.po.TbContent;

import java.util.List;

/**
 * User: DHC
 * Date: 2017/11/20
 * Time: 15:28
 * Version:V1.0
 */
public interface ContentService {
    /**
     * 根据内容分类的编号查询出内容
     * @param id
     * @return
     */
    List<TbContent> listContentsByCid(Long id);
}
