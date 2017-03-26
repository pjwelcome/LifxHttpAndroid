package com.multimeleon.android.lifxhttpandroidlibrary.Interfaces;

import com.multimeleon.android.lifxhttpandroidlibrary.Models.SingleLight.LifxLightStateRequest;
import com.multimeleon.android.lifxhttpandroidlibrary.Models.SingleLight.Light;
import com.multimeleon.android.lifxhttpandroidlibrary.Models.SingleLight.Result;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by dvtmpjwelcome on 2017/03/11.
 */

public interface LifxLightsService {

    @GET("{selector}")
    Observable<List<Light>> getLights(@Path("selector") String selector);

    @PUT("{selector}/state")
    Observable<List<Result>> setLightState(@Path("selector") String selector, @Body LifxLightStateRequest body);

}
