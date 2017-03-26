package com.multimeleon.android.lifxhttpandroidlibrary.Interfaces;



import com.multimeleon.android.lifxhttpandroidlibrary.Models.SingleLight.LifxLightStateRequest;
import com.multimeleon.android.lifxhttpandroidlibrary.Models.SingleLight.Light;
import com.multimeleon.android.lifxhttpandroidlibrary.Models.SingleLight.Result;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by dvtmpjwelcome on 2017/03/11.
 */

public interface LifxLightsRepo {

    Observable<List<Light>> getLights(String selector);

    Observable<List<Result>> setLightState(String selector, LifxLightStateRequest request);
}
