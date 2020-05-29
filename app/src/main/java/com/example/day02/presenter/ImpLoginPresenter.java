package com.example.day02.presenter;

import android.text.TextUtils;
import android.widget.Toast;

import com.example.day02.bean.LoginBean;
import com.example.day02.callback.LoginCallBack;
import com.example.day02.model.ImpLoginModel;
import com.example.day02.view.LoginView;

public class ImpLoginPresenter implements LoginPresenter, LoginCallBack {
    private LoginView loginView;
    private ImpLoginModel impLoginModel;

    public ImpLoginPresenter(LoginView loginView) {
        this.loginView = loginView;
        impLoginModel = new ImpLoginModel();
    }

    @Override
    public void login(String name, String pwd) {

        if (TextUtils.isEmpty(name)) {
            loginView.onFail("name不能为空");
            return;
        }


        if (TextUtils.isEmpty(pwd)) {
            loginView.onFail("pwd不能为空");
            return;
        }
        impLoginModel.login(name, pwd, this);
    }

    @Override
    public void onSuccess(LoginBean loginBean) {
        loginView.onSuccess(loginBean);
    }

    @Override
    public void onFail(String error) {
        loginView.onFail(error);
    }
}
