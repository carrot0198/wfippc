package cn.wfippc.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.wfippc.demo.entity.Msg;

/**
 * Created by yangyibo on 17/1/18.
 */
@Controller
public class LoginController {

    @RequestMapping("/")
    public String index(Model model){
    	System.out.println(model);
        Msg msg =  new Msg("测试标题","测试内容","额外信息，只对管理员显示");
        model.addAttribute("msg", msg);
        return "home";
    }
}
