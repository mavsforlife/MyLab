package com.mavsforlife.victor.mylab.network;



import com.mavsforlife.victor.mylab.model.BaseResult;
import com.mavsforlife.victor.mylab.model.Beauty;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by victor on 2017/11/20.
 * Email: wwmdirk@gmail.com
 */

public interface BaseApi {
    @GET("data/福利/{number}/{page}")
    Observable<BaseResult<List<Beauty>>> getBeauties(@Path("number") int number, @Path("page") int page);

}
