package com.route.test.mybluetooth.model.net;

import android.content.Context;
import android.util.Log;

import com.route.test.mybluetooth.utils.NetworkUtils;

import java.io.File;
import java.io.IOException;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by chj on 2017/8/30.
 */

public class HttpUtils {
    private static final String URL_WEATHER ="http://wthrcdn.etouch.cn/";
    private static final String URL_PANDA="http://api.cntv.cn/";
    private static final int NET_MAX = 30; //30秒  有网超时时间
    private static final int NO_NET_MAX = 60 * 60 * 24 * 7; //7天 无网超时时间

    public static Retrofit getRetrofit(String url, final Context context){
        //应用程序拦截器
        Interceptor mInterceptor=new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Log.e("TAG", "拦截 网络 缓存");
                Request request=chain.request();
                if (!NetworkUtils.networkIsAvailable(context)) {//判断网络状态,无网络时读取缓存
                    Log.e("TAG", "无网~~ 缓存");
                    request=request.newBuilder()
                    //Pragma:no-cache。在HTTP/1.1协议中，它的含义和Cache-Control:no-cache相同。为了确保缓存生效
                    .removeHeader("Pragma")
                            .header("Cache-Control", "private, only-if-cached, max-stale=" + NO_NET_MAX)
                            .build();

                }else{//有网状态
                    Log.e("TAG", "有网~~ 缓存");
                    request =request.newBuilder()
                            .removeHeader("Pragma")
                            .header("Cache-Control", "private, max-age=" + NET_MAX)//添加缓存请求头
                            .build();
                }
                return chain.proceed(request);
            }
        };


        //网络拦截器

        Interceptor mNetInterceptor=new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Log.e("TAG", "拦截 应用 缓存");
                Request request = chain.request();
                if (!NetworkUtils.networkIsAvailable(context)) {//判断网络状态 无网络时
                    request = request.newBuilder()
                            //Pragma:no-cache。在HTTP/1.1协议中，它的含义和Cache-Control:no-cache相同。为了确保缓存生效
                            .removeHeader("Pragma")
                            .header("Cache-Control", "private, only-if-cached, max-stale=" + NO_NET_MAX)
                            .build();
                } else {
                    request = request.newBuilder()
                            //Pragma:no-cache。在HTTP/1.1协议中，它的含义和Cache-Control:no-cache相同。为了确保缓存生效
                            .removeHeader("Pragma")
                            .header("Cache-Control", "private, max-age=" + NET_MAX)//添加缓存请求头
                            .build();
                }
                return chain.proceed(request);
            }
        };


        //设置缓存路径
        File mFile=new File(context.getCacheDir()+"http");//设置储存目录
        long maxSize=10*1024*1024;//10MB最大缓存
        Cache mCache=new Cache(mFile,maxSize);

        OkHttpClient mClient=new OkHttpClient.Builder()
                .addInterceptor(mInterceptor)//添加应用拦截器
                .addNetworkInterceptor(mNetInterceptor)//添加网络拦截器
                .cache(mCache)//添加缓存
                .build();

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(url)//添加baseUrl
                .client(mClient)//添加okclient
                .addConverterFactory(GsonConverterFactory.create())//添加gson工厂
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//添加rxjava
                .build();

        return retrofit;

    }
    //创建接口实现类
    public  static GetWeaTherService createWeatherService(Context context){
        return getRetrofit(URL_WEATHER,context).create(GetWeaTherService.class);
    }

    public static GetWeaTherService getPandaData(Context context){
        return getRetrofit(URL_PANDA,context).create(GetWeaTherService.class);
    }
}
