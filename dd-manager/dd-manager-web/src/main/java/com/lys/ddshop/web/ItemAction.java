package com.lys.ddshop.web;

import com.dhc.ddshop.pojo.po.TbItem;
import com.dhc.ddshop.pojo.vo.TbItemCustom;
import com.dhc.ddshop.pojo.vo.TbItemQuery;
import com.lys.ddshop.common.dto.Order;
import com.lys.ddshop.common.dto.Page;
import com.lys.ddshop.common.dto.Result;
import com.lys.ddshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * User: Administrator
 * Date: 2017/11/6
 * Time: 16:29
 * Version:V1.0
 */
@Controller
@Scope("prototype")
public class ItemAction {
    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/item/{itemId}" , method = RequestMethod.GET)
    @ResponseBody
    public TbItem getById(@PathVariable("itemId") Long itemId){
        System.out.println(itemId);
        return itemService.getById(itemId);
    }

  /*  @ResponseBody
    @RequestMapping("/items")
    public List<TbItem> listItems(){
        List<TbItem> list = null;
        try {
            list = itemService.listItems();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }*/
  //分页查询全部，排序
    //page分页所用，order排序所用
  @ResponseBody
  @RequestMapping("/items")
public Result<TbItemCustom> listItemsByPage(Page page, Order order , TbItemQuery query){
    Result<TbItemCustom> list = null;
    try {
        list = itemService.listItemsByPage(page,order,query);
    }catch (Exception e) {
        e.printStackTrace();
    }
    System.out.println(list);
    return list;

}
//模糊查询
//    @ResponseBody
//    @RequestMapping("/items")aa
//    public Result<TbItemCustom> listItemsByPage(Page page, Order order){
//        Result<TbItemCustom> list = null;
//        try {
//            list = itemService.listItemsByPage(page,order);
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println(list);
//        return list;
//
//    }


@ResponseBody
@RequestMapping("/items/batch")
public int updateBatch(@RequestParam("ids[]") List<Long> ids){
    System.out.println(ids);
    int i=0;
    try {
        i=itemService.updateBatch(ids);
    }catch (Exception e){
        e.printStackTrace();
    }
    return i;
}
    @ResponseBody
    @RequestMapping("/items/batchup")
    public int addBatch(@RequestParam("ids[]") List<Long> ids){
        System.out.println(ids);
        int i=0;
        try {
            i=itemService.addBatch(ids);
        }catch (Exception e){
            e.printStackTrace();
        }
        return i;
    }
    @ResponseBody
    @RequestMapping("/items/batchdown")
    public int deleteBatch(@RequestParam("ids[]") List<Long> ids){
        System.out.println(ids);
        int i=0;
        try {
            i=itemService.deleteBatch(ids);
        }catch (Exception e){
            e.printStackTrace();
        }
        return i;
    }

    @ResponseBody
    @RequestMapping("/item")
    public int saveItem(TbItem tbItem,String content){
        int i=0;
        try {
            i=itemService.saveItem(tbItem,content);
        }catch (Exception e){
            e.printStackTrace();
        }
        return i;
    }


}
