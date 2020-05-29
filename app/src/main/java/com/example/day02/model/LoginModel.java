package com.example.day02.model;

import com.example.day02.callback.LoginCallBack;

public interface LoginModel  {
    void login(String name, String pwd, LoginCallBack loginCallBack);
}
