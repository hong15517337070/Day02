package com.example.day02.api;

import com.example.day02.bean.LoginBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
    //你
    String loginbaseUrl = "https://www.wanandroid.com/";
    @POST("user/login")
    @FormUrlEncoded
    Observable<LoginBean> login(@Field("username") String name,@Field("password") String pwd);
}
