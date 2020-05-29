package com.example.day02.model;

import com.example.day02.api.ApiService;
import com.example.day02.bean.LoginBean;
import com.example.day02.callback.LoginCallBack;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ImpLoginModel implements LoginModel {
    @Override
    public void login(String name, String pwd, final LoginCallBack loginCallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.loginbaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<LoginBean> observable = apiService.login(name, pwd);
        observable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<LoginBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(LoginBean loginBean) {
                int errorCode = loginBean.getErrorCode();
                if (errorCode == 0){
                    loginCallBack.onSuccess(loginBean);
                }else {
                    loginCallBack.onFail(loginBean.getErrorMsg());
                }

            }

            @Override
            public void onError(Throwable e) {
                loginCallBack.onFail("登录失败"+e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
