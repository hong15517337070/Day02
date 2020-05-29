package com.example.day02.callback;

import com.example.day02.bean.LoginBean;

public interface LoginCallBack {
    void onSuccess(LoginBean loginBean);
    void onFail(String error);
}
