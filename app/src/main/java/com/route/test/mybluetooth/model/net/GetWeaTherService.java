package com.route.test.mybluetooth.model.net;


import com.route.test.mybluetooth.entity.SplendBean;
import com.route.test.mybluetooth.entity.WeatherEntity;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by chj on 2017/8/30.
 * 功能描述: http://wthrcdn.etouch.cn/weather_mini?city=北京
 * http://api.cntv.cn/video/videolistById?vsid=VSET100167216881
 * &n=7
 * &serviceId=panda
 * &o=desc
 * &of=time
 * &p=1
 */

public interface GetWeaTherService {
    @GET("weather_mini")
    Observable<WeatherEntity> getRxMessage(@Query("city") String city);

    @GET("video/videolistById")
    Observable<SplendBean> getPandaData(@Query("vsid") String vsid,@Query("n") String n,
    @Query("serviceId")String serviceId,@Query("o") String o,@Query("of") String of,@Query("p") String p);
}
