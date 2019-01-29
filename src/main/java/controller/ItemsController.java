package controller;

import Validation.ValidGroup1;
import entity.Items;
import entity.ItemsCustom;
import entity.ItemsQueryVo;
import exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.ItemsService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @BelongsProject: SSMtest
 * @BelongsPackage: controller
 * @Author: yang
 * @CreateTime: 2019-01-18 15:11
 * @Description: ${Description}
 */

@Controller
@RequestMapping("/items")
public class ItemsController {



    @Autowired
    ItemsService itemsService;


    // 日期类型转换
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    //商品查询
    @RequestMapping("/queryItems")
    public ModelAndView queryItems(HttpServletRequest httpServletRequest, ItemsQueryVo itemsQueryVo) throws  Exception{
        List<ItemsCustom> itemsList=itemsService.findItemsList(itemsQueryVo);
        // 向list填充信息


        //返回ModelAndView
        ModelAndView modelAndView =  new ModelAndView();
        //相当 于request的setAttribut，在jsp页面中通过itemsList取数据
        modelAndView.addObject("itemsList", itemsList);

        //指定视图
        modelAndView.setViewName("items/itemsList");
        return  modelAndView;
    }

    // 可以定义其他方法

    //商品信息页面展示
//    @RequestMapping("/editItems")
//    @RequestMapping(value="/editItems",method = {RequestMethod.GET,RequestMethod.POST})
//    public ModelAndView editItems() throws  Exception{
//        //调用service查询商品信息
//        ItemsCustom itemsCustom=itemsService.findItemsById(1);
//
//        ModelAndView modelAndView=new ModelAndView();
//
//        //返回商品修改页面
//        modelAndView.setViewName("items/editItems");
//
//       //讲商品信息放入mv
//       modelAndView.addObject(itemsCustom);
//        return  modelAndView;
//    }
    @RequestMapping(value="/editItems",method = {RequestMethod.GET,RequestMethod.POST})
    public String editItems(Model model,Integer id) throws  Exception{
        //调用service查询商品信息
        ItemsCustom itemsCustom=itemsService.findItemsById(id);
//        //判断是否商品为空
//        if(itemsCustom ==null){
//            throw new CustomException("修改的商品信息不存在");
//        }

        model.addAttribute("itemsCustom",itemsCustom);
        return "items/editItems";
    }


    //商品信息提交修改
    // 在需要校验的pojo前边添加@Validated，在需要校验的pojo后边添加BindingResult
    @RequestMapping("/editItemsSubmit")
     public String editItemsSubmit(Model model,
                                   HttpServletRequest httpServletRequest,
                                   Integer id,
                                   @Validated(value={ValidGroup1.class}) ItemsCustom itemsCustom,
                                   BindingResult bindingResult,
                                   MultipartFile items_pic //接受商品的图片
                                    ) throws  Exception{
        if (bindingResult.hasErrors()){
            //输出错误信息
            List<ObjectError> allErrors=bindingResult.getAllErrors();
            for(ObjectError objectError:allErrors){
                //输出错误信息
                System.out.println(objectError.getDefaultMessage());
            }
            model.addAttribute("allErrors",allErrors);
            //出错 重新回到商品修改页面
            return "items/editItems";

        }


        //上传图片

        String oraginfilename=items_pic.getOriginalFilename();
         if (items_pic !=null && oraginfilename!=null && oraginfilename.length()>0){

             //存储图片的屋里路径
             String pic_path="F:\\java框架练习\\SSM\\picture\\";
             //上传图片的原始名称

             //新的图片名称
             String newfilename= UUID.randomUUID()+oraginfilename.substring(oraginfilename.lastIndexOf("."));

             File newfile=new File(pic_path+newfilename);

             //将内存中的数据写入磁盘
             items_pic.transferTo(newfile);

             //将内存中的数据写入出来
             itemsCustom.setPic(newfilename);
         }




//         name=   httpServletRequest.getParameter("name");
//        date= httpServletRequest.getParameter("createtime");
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date createtime=simpleDateFormat.parse(date);
//        System.out.println(name);
//        System.out.println(date);
//        ItemsCustom itemsCustom=new ItemsCustom();
//        itemsCustom.setCreatetime(createtime);

        //调用service 更新商品信息
        itemsService.updateItems(id,itemsCustom);
//
//        ModelAndView modelAndView=new ModelAndView();
//        modelAndView.setViewName("/items/success");
        return"redirect:queryItems.action";

     }

     //删除商品信息
     @RequestMapping("deleteItems")
     public String deleteItems(HttpServletRequest httpServletRequest,Integer[] items_id) throws Exception{
        System.out.println(httpServletRequest.getParameter("items_id"));
        itemsService.deleteItems(items_id);

        return "redirect:queryItems.action";
     }



     //批量修改商品页面，将商品信息查询出来，在页面中可以编辑商品信息
     @RequestMapping("/editItemsQuery")
     public ModelAndView editItemsQuery(HttpServletRequest httpServletRequest, ItemsQueryVo itemsQueryVo) throws  Exception{
         List<ItemsCustom> itemsList=itemsService.findItemsList(itemsQueryVo);
         // 向list填充信息


         //返回ModelAndView
         ModelAndView modelAndView =  new ModelAndView();
         //相当 于request的setAttribut，在jsp页面中通过itemsList取数据
         modelAndView.addObject("itemsList", itemsList);

         //指定视图
         modelAndView.setViewName("items/editItemsQuery");
         return  modelAndView;
     }

    //批量修改商品提交
    // 通过ItemsQueryVo接受批量提交的商品信息，讲商品信息存储到ItemsQueryVo 的 itemsList属性中
    @RequestMapping("editItemsAllSubmit")
    public String editItemsAllSubmit(ItemsQueryVo itemsQueryVo) throws  Exception{

        List<ItemsCustom> itemsList=itemsQueryVo.getItemsList();
        for(ItemsCustom itemsCustom:itemsList){
            itemsService.updateItems(itemsCustom.getId(),itemsCustom);
        }
        return "redirect:editItemsQuery.action";
    }




    //查询商品信息输出json (RESTful风格)
    // itemsView/{id}的{id}表示占位符，通过@PathVariable获取占位符中的参数
    @RequestMapping("/itemsView/{id}")
    public @ResponseBody ItemsCustom itemsView(@PathVariable Integer id) throws Exception{

        //返回商品查询信息
        ItemsCustom itemsCustom=itemsService.findItemsById(id);
        return itemsCustom;
    }


}
