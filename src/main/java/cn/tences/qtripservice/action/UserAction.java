package cn.tences.qtripservice.action;

import cn.tences.qtripservice.bean.RestFulBean;
import cn.tences.qtripservice.bean.UserBean;
import cn.tences.qtripservice.database.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserAction {
    @Autowired
    private UserService userService;


    /**
     * 注册
     *
     * @param userBean
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/register.do", method = RequestMethod.PUT)
    public RestFulBean<UserBean> register(@RequestBody UserBean userBean) {
        return userService.registorServer(userBean);
    }

    /**
     * 登录
     *
     * @param phone
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/loginbypwd.do", method = RequestMethod.POST)
    public RestFulBean<UserBean> loginByPwd(String phone, String password) {
        System.out.println("phone:" + phone);
        return userService.login(phone, password);
    }

}