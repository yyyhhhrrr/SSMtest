package controller.test;

import entity.Items;
import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: SSMtest
 * @BelongsPackage: controller
 * @Author: yang
 * @CreateTime: 2019-01-18 10:34
 * @Description: ${Description}
 */
public class ItemsController2 implements HttpRequestHandler {
    public void handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        List<Items> itemsList=new ArrayList<Items>();
        // 向list填充信息

        Items items_1 = new Items();
        items_1.setName("联想笔记本");
        items_1.setPrice(6000f);
        items_1.setDetail("ThinkPad T430 联想笔记本电脑！");

        Items items_2 = new Items();
        items_2.setName("苹果手机");
        items_2.setPrice(5000f);
        items_2.setDetail("iphone6苹果手机！");

        itemsList.add(items_1);
        itemsList.add(items_2);


         httpServletRequest.setAttribute("itemsList",itemsList);
         httpServletRequest.getRequestDispatcher("/items/itemsList").forward(httpServletRequest,httpServletResponse);
    }
}
