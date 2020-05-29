package com.example.day02.view;

import com.example.day02.bean.LoginBean;

public interface LoginView {
    void onSuccess(LoginBean loginBean);
    void onFail(String error);
}
