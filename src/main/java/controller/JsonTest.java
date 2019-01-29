package controller;

import entity.ItemsCustom;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @BelongsProject: SSMtest
 * @BelongsPackage: controller
 * @Author: yang
 * @CreateTime: 2019-01-24 10:32
 * @Description: Json测试
 */

@Controller
public class JsonTest {

    //请求json 响应json（商品信息）
    //@RequestBody 将请求的商品信息的json串转成itemsCustom对象
    //@ResponseBody 将itemsCustom转成json输出
    @RequestMapping("/requestJson")
    public @ResponseBody
    ItemsCustom requestJson(@RequestBody ItemsCustom itemsCustom){

        return itemsCustom;
    }


    @RequestMapping("/responseJson")
    public @ResponseBody
    ItemsCustom responseJson(ItemsCustom itemsCustom){
        return itemsCustom;
    }
}
