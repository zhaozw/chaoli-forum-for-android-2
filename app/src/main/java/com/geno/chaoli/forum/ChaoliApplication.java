package com.geno.chaoli.forum;

import android.app.Application;
import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.geno.chaoli.forum.network.MyOkHttp;

import java.io.InputStream;

/**
 * Created by jianhao on 16-8-25.
 */
public class ChaoliApplication extends Application {
    /*private Retrofit retrofit;
    private OkHttpClient okHttpClient;
    private ChaoliService service;*/
    private static Context appContext;
    @Override
    public void onCreate() {
        super.onCreate();
        ChaoliApplication.appContext = getApplicationContext();
        //Glide.get(this).register(GlideUrl.class, InputStream.class, new OkHttpUrlLoader.Factory(MyOkHttp.getClient()));
        /*okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new ReceivedCookiesInterceptor(this))
                .addInterceptor(new AddCookiesInterceptor(this))
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        service = retrofit.create(ChaoliService.class);*/
    }

    public static Context getAppContext() {
        return appContext;
    }
/*public OkHttpClient getClient(){
        return okHttpClient;
    }

    public ChaoliService getService(){
        return service;
    }*/
}
