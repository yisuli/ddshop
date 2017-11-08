package com.lys.ddshop.web;

import com.dhc.ddshop.pojo.po.TbItem;
import com.dhc.ddshop.pojo.vo.TbItemCustom;
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
  @ResponseBody
  @RequestMapping("/items")
public Result<TbItemCustom> listItemsByPage(Page page){
    Result<TbItemCustom> list = null;
    try {
        list = itemService.listItemsByPage(page);
    }catch (Exception e) {
        e.printStackTrace();
    }
    System.out.println(list);
    return list;

}
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


}
