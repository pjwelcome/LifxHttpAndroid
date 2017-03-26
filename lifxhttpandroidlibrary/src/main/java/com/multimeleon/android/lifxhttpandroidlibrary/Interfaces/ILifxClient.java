package com.multimeleon.android.lifxhttpandroidlibrary.Interfaces;

import com.multimeleon.android.lifxhttpandroidlibrary.Models.SingleLight.Light;

import java.util.List;

/**
 * Created by Peter-John on 2017-03-25.
 * LifxHttpAndroid
 */

public interface ILifxClient {

    String getApiKey();

    void setLights(List<Light> lights);
    void getListOfLights();

    void setError(String message);

   String getError();

}
