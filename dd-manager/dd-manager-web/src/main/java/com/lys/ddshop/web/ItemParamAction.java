package com.lys.ddshop.web;

import com.dhc.ddshop.pojo.po.TbItemParam;
import com.dhc.ddshop.pojo.vo.TbItemParamCustom;
import com.lys.ddshop.common.dto.Page;
import com.lys.ddshop.common.dto.Result;
import com.lys.ddshop.service.ItemParamService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User: Administrator
 * Date: 2017/11/13
 * Time: 20:10
 * Version:V1.0
 */
@Controller
public class ItemParamAction {
    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ItemParamService itemParamService;

    @ResponseBody
    @RequestMapping("/itemParams")
    public Result<TbItemParamCustom> listItemParams(Page page) {
        Result<TbItemParamCustom> result = null;
        try {
            result = itemParamService.listItemParamsByPage(page);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/itemParam/query/{cid}", method = RequestMethod.GET)
    public TbItemParam getItemParamByCid(@PathVariable("cid") Long cid) {
        TbItemParam tbItemParam = null;
        try {
            tbItemParam = itemParamService.getItemParamByCid(cid);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return tbItemParam;
    }

    @ResponseBody
    @RequestMapping("/itemParamAdd/{cid}")
    public int saveItemParam(@PathVariable("cid") Long cid, String paramData) {
        int i = 0;
        try {
            i=itemParamService.saveItemParam(cid,paramData);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return i;
    }
}
