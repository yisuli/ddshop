package com.lys.ddshop.service;

import com.dhc.ddshop.pojo.po.TbItemParam;
import com.dhc.ddshop.pojo.vo.TbItemParamCustom;
import com.lys.ddshop.common.dto.Page;
import com.lys.ddshop.common.dto.Result;

/**
 * User: Administrator
 * Date: 2017/11/13
 * Time: 20:22
 * Version:V1.0
 */
public interface ItemParamService {
    Result<TbItemParamCustom> listItemParamsByPage(Page page);

    TbItemParam getItemParamByCid(Long cid);

    int saveItemParam(Long cid, String paramData);
}
