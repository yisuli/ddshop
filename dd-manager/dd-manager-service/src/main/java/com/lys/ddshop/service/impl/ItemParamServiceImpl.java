package com.lys.ddshop.service.impl;

import com.dhc.ddshop.dao.TbItemParamCustomMapper;
import com.dhc.ddshop.pojo.vo.TbItemParamCustom;
import com.lys.ddshop.common.dto.Page;
import com.lys.ddshop.common.dto.Result;
import com.lys.ddshop.service.ItemParamService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: Administrator
 * Date: 2017/11/13
 * Time: 20:22
 * Version:V1.0
 */
@Service
public class ItemParamServiceImpl implements ItemParamService{
    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TbItemParamCustomMapper itemParamCustomDao;

    @Override
    public Result<TbItemParamCustom> listItemParamsByPage(Page page) {
        Result<TbItemParamCustom> result = null;
        try {
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("page",page);
            int count=itemParamCustomDao.countItemParams();
            List<TbItemParamCustom> list=itemParamCustomDao.listItemParamsByPage(map);


            result=new Result<TbItemParamCustom>();
            result.setTotal(count);
            result.setRows(list);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return result;
    }
}
