package com.lys.ddshop.service.impl;

import com.lys.ddshop.common.jedis.JedisClient;
import com.lys.ddshop.common.util.JsonUtils;
import com.dhc.ddshop.dao.TbContentMapper;
import com.dhc.ddshop.pojo.po.TbContent;
import com.dhc.ddshop.pojo.po.TbContentExample;
import com.lys.ddshop.service.ContentService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: DHC
 * Date: 2017/11/20
 * Time: 15:29
 * Version:V1.0
 */
@Service
public class ContentServiceImpl implements ContentService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TbContentMapper contentDao;
    @Autowired
    private JedisClient jedisClient;

    @Override
    public List<TbContent> listContentsByCid(Long id) {
        List<TbContent> list = null;
        //查询缓存部分
        try {
            String json = jedisClient.hget("CONTENT_LIST", id + "");
            if(StringUtils.isNotBlank(json)){
                return JsonUtils.jsonToList(json, TbContent.class);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        //主体业务部分
        //创建模板
        TbContentExample example = new TbContentExample();
        TbContentExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(id);
        //执行查询
        list = contentDao.selectByExample(example);

        //存入缓存部分
        try {
            jedisClient.hset("CONTENT_LIST", id + "", JsonUtils.objectToJson(list));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return list;
    }
}
