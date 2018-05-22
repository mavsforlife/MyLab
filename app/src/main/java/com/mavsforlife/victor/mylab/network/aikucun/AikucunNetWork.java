package com.mavsforlife.victor.mylab.network.aikucun;

import com.mavsforlife.victor.mylab.network.aikucun.aikuconverter.AiGsonConverterFactory;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * Created by victor on 2017/11/22.
 * Email: wwmdirk@gmail.com
 */

public class AikucunNetWork {
    private static AikucunApi sAikucunApi;
    private static OkHttpClient sOkHttpClient = new OkHttpClient()
            .newBuilder()
            .addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    return chain.proceed(chain.request()
                            .newBuilder()
                            .addHeader("Accept-Language", "zh-CN,zh;q=0.8")
                            .addHeader("User-Agent", "PRO5 android 5.1 1.1.24 1.0")
                            .addHeader("AKC-MODEL", "PRO5")
                            .addHeader("AKC-OS", "android")
                            .addHeader("AKC-OS-VERSION", "5.1")
                            .addHeader("AKC-APP-VERSION", "1.1.24")
                            .addHeader("AKC-APP-API-VERSION", "1.0")
                            .addHeader("AKC-APP-BUILD-VERSION", "71")
                            .addHeader("AKC-AKC-DID", "962f246b7d1115e7647ce90f3ce94579")
                            .addHeader("Content-Type", "application/json")
                            .build());
                }
            })
            .addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    return chain.proceed(chain.request()
                            .newBuilder()
                            .url(chain.request().url().newBuilder()
                                    .addQueryParameter("appid", "28769828")
                                    .addQueryParameter("did", "962f246b7d1115e7647ce90f3ce94579")
                                    .addQueryParameter("noncestr", "123456")
                                    .addQueryParameter("sync", "0")
                                    .addQueryParameter("sync", "token")
                                    .build())
                            .build());
                }
            })
            .addInterceptor(new HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY))
            .build();
    private static Converter.Factory sConverterFactory = AiGsonConverterFactory.create();
    private static CallAdapter.Factory sCallAdapterFactory = RxJava2CallAdapterFactory.create();

    public static AikucunApi getAikucunApi() {
        if (sAikucunApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(sOkHttpClient)
                    .baseUrl("http://app.akucun.com/api/v1.0/")
                    .addConverterFactory(sConverterFactory)
                    .addCallAdapterFactory(sCallAdapterFactory)
                    .build();
            sAikucunApi = retrofit.create(AikucunApi.class);
        }
        return sAikucunApi;
    }
}
