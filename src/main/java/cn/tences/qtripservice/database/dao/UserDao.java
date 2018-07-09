package cn.tences.qtripservice.database.dao;

import cn.tences.qtripservice.bean.UserBean;

public interface UserDao {
    /**
     * 注册
     * @param userBean
     */
    UserBean registor(UserBean userBean);

    /**
     * 登陆
     * @return
     */
    UserBean login(String phone, String password);

    /**
     * 根据名字获取用户信息
     * @param phone
     * @return
     */
    UserBean getUser(String phone);

}
