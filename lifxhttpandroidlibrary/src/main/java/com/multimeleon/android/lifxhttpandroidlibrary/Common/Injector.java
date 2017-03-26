package com.multimeleon.android.lifxhttpandroidlibrary.Common;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.multimeleon.android.lifxhttpandroidlibrary.Interfaces.LifxLightsRepo;
import com.multimeleon.android.lifxhttpandroidlibrary.Interfaces.LifxLightsService;
import com.multimeleon.android.lifxhttpandroidlibrary.Repo.LifxLightsRepoImpl;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dvtmpjwelcome on 2017/03/11.
 */

public class Injector {
    private static final String BASE_URL = "https://api.lifx.com/v1/lights/";
    private static OkHttpClient okHttpClient;
    private static LifxLightsService userRestService;
    private static Retrofit retrofitInstance;
    private static String apiKey;

    public static LifxLightsRepo provideLifxLightsRepo(String apiKey) {
        Injector.apiKey = apiKey;
        return new LifxLightsRepoImpl(provideLifxLightsRestService());
    }

    static LifxLightsService provideLifxLightsRestService() {
        if (userRestService == null) {
            userRestService = getRetrofitInstance().create(LifxLightsService.class);
        }
        return userRestService;
    }

    static OkHttpClient getOkHttpClient() {
        if (okHttpClient == null) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
            okHttpClient = new OkHttpClient.Builder().addInterceptor(logging)
                    .authenticator((route, response) ->
                            response.request().newBuilder().
                                    header("Authorization", "Bearer " + Injector.apiKey).
                                    build())
                    .build();
        }
        return okHttpClient;
    }

    static Retrofit getRetrofitInstance() {
        if (retrofitInstance == null) {
            Retrofit.Builder retrofit = new Retrofit.Builder()
                    .client(Injector.getOkHttpClient()).
                            baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create());
            retrofitInstance = retrofit.build();

        }
        return retrofitInstance;
    }
}
//"c97f8d371ad06e865dcead0b5c8d71ca9155e41eed56f526f2930b044346697f"