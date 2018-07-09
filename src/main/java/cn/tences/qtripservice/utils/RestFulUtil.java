package cn.tences.qtripservice.utils;

import cn.tences.qtripservice.bean.RestFulBean;

public class RestFulUtil<T> {

    private RestFulUtil() {
    }

    public static RestFulUtil getInstance() {
        return new RestFulUtil();
    }

    public RestFulBean<T> getResuFulBean(T o, int code, String msg) {
        RestFulBean<T> objectRestFulBean = new RestFulBean<T>();
        objectRestFulBean.setCode(code);
        objectRestFulBean.setMessage(msg);
        objectRestFulBean.setData(o);
        return objectRestFulBean;
    }

}