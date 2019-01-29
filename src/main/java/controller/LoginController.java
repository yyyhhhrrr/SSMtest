package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @BelongsProject: SSMtest
 * @BelongsPackage: controller
 * @Author: yang
 * @CreateTime: 2019-01-24 15:19
 * @Description: ${Description}
 */
@Controller
public class LoginController {

    //登录
    @RequestMapping("/Login")
    public String login(HttpSession session,String username, String password) throws Exception{
          //调用service 进行身份认证
         //..
        session.setAttribute("username",username);

        //重定向到商品列表界面
        return "redirect:/items/queryItems.action";


    }

    //退出
    @RequestMapping("Logout")
    public String logout(HttpSession session) throws Exception{


        //清除session
        session.invalidate();

        //调用service
        return "redirect:/items/queryItems.action";

    }

    //退出
}
