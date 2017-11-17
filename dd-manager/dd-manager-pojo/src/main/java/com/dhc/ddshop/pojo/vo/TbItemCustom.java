package com.dhc.ddshop.pojo.vo;

import com.dhc.ddshop.pojo.po.TbItem;

/**
 * User: Administrator
 * Date: 2017/11/8
 * Time: 10:55
 * Version:V1.0
 */
public class TbItemCustom extends TbItem{

    private String catName;
    private Long priceView;

    public Long getPriceView() {
        return priceView;
    }

    public void setPriceView(Long priceView) {
        this.priceView = priceView;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }
}
