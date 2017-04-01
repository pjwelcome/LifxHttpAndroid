package com.multimeleon.android.lifxhttpandroidlibrary.Interfaces;

import com.multimeleon.android.lifxhttpandroidlibrary.Models.SingleLight.Light;
import com.multimeleon.android.lifxhttpandroidlibrary.Models.SingleLight.Result;

import java.util.List;

/**
 * Created by Peter-John on 2017-03-25.
 * LifxHttpAndroid
 */

public interface ILifxClient {

    String getApiKey();

    void setLights(List<Light> lights);

    void getListOfLights();

    String getError();

    void setError(String message);

    void toggleLight(String lightId, boolean on, Double brightness);

    void toggleLightResult(List<Result> results);

}
