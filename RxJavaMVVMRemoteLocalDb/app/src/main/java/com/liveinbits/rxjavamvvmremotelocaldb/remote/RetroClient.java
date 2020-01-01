package com.liveinbits.rxjavamvvmremotelocaldb.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroClient {

    private static final String BASE_URL="http://192.168.0.122/RxjavaLiveData/";

    private static Retrofit instance=null;

    private static Retrofit getInstance(){
        if (instance==null){
            instance=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return instance;
    }

    public static APIService getAPIService(){
        return getInstance().create(APIService.class);
    }
}
