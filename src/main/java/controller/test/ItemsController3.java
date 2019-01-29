package controller.test;

/**
 * @BelongsProject: SSMtest
 * @BelongsPackage: controller
 * @Author: yang
 * @CreateTime: 2019-01-18 10:49
 * @Description: 注解的handler
 */

//使用controller注解表示一个控制器
import entity.Items;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

//@Controller
// 商品查询列表
public class ItemsController3 {


//    //@RequestMapping实现 对queryItems方法和url进行映射，一个方法对应一个url
//    //一般建议将url和方法写成一样
//    @RequestMapping("/queryItems")
//    public ModelAndView queryItems() throws  Exception{
//        List<Items> itemsList=new ArrayList<Items>();
//        // 向list填充信息
//
//        Items items_1 = new Items();
//        items_1.setName("联想笔记本");
//        items_1.setPrice(6000f);
//        items_1.setDetail("ThinkPad T430 联想笔记本电脑！");
//
//        Items items_2 = new Items();
//        items_2.setName("苹果手机");
//        items_2.setPrice(5000f);
//        items_2.setDetail("iphone6苹果手机！");
//
//        itemsList.add(items_1);
//        itemsList.add(items_2);
//
//
//        //返回ModelAndView
//        ModelAndView modelAndView =  new ModelAndView();
//        //相当 于request的setAttribut，在jsp页面中通过itemsList取数据
//        modelAndView.addObject("itemsList", itemsList);
//
//        //指定视图
//        modelAndView.setViewName("items/itemsList");
//        return  modelAndView;
//}

    // 可以定义其他方法
}
