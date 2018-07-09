package cn.tences.qtripservice.database.service;

import cn.tences.qtripservice.bean.RestFulBean;
import cn.tences.qtripservice.bean.UserBean;
import cn.tences.qtripservice.database.dao.UserDao;
import cn.tences.qtripservice.utils.RestFulUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UserService {
    @Autowired
    private UserDao userDao;

    public RestFulBean<UserBean> registorServer(UserBean userBean) {
        UserBean user = userDao.getUser(userBean.getPhone());
        if (user != null) {
            return RestFulUtil.getInstance().getResuFulBean(null, 1, "已经注册过了");
        } else {
            user = userDao.registor(userBean);
            if (user != null) {
                return RestFulUtil.getInstance().getResuFulBean(user, 200, "注册成功");
            } else {
                return RestFulUtil.getInstance().getResuFulBean(null, 1, "注册失败");
            }
        }

    }

    public RestFulBean<UserBean> login(String phone, String password) {
        UserBean user = userDao.login(phone, password);
        if (user != null) {
            return RestFulUtil.getInstance().getResuFulBean(user, 200, "登录成功");
        } else {
            return RestFulUtil.getInstance().getResuFulBean(null, 1, "用户不存在");
        }
    }
}
