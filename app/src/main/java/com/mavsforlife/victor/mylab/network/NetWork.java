package com.mavsforlife.victor.mylab.network;


import com.mavsforlife.victor.mylab.network.gsonconverter.MyGsonConverterFactory;

import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * Created by victor on 2017/11/20.
 * Email: wwmdirk@gmail.com
 */

public class NetWork {

    private static BaseApi sBaseApi;
    private static OkHttpClient sOkHttpClient = new OkHttpClient();
    private static Converter.Factory sConverterFactory = MyGsonConverterFactory.create();
    private static CallAdapter.Factory sCallAdapterFactory = RxJava2CallAdapterFactory.create();

    public static BaseApi getsBaseApi() {
        if (sBaseApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(sOkHttpClient)
                    .baseUrl("http://gank.io/api/")
                    .addConverterFactory(sConverterFactory)
                    .addCallAdapterFactory(sCallAdapterFactory)
                    .build();
            sBaseApi = retrofit.create(BaseApi.class);
        }
        return sBaseApi;
    }
}
