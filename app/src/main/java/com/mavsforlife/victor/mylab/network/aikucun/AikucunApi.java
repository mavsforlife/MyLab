package com.mavsforlife.victor.mylab.network.aikucun;

import com.mavsforlife.victor.mylab.network.aikucun.model.DataBean;

import java.util.LinkedHashMap;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Created by victor on 2017/11/22.
 * Email: wwmdirk@gmail.com
 */

public interface AikucunApi {

    @GET("live.do?action={action}")
    Observable<AikucuResult<DataBean>> getAction(@Path("action") String action, @QueryMap LinkedHashMap<String, String> map);
}
