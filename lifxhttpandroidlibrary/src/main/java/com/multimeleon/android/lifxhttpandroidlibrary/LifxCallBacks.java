package com.multimeleon.android.lifxhttpandroidlibrary;

import com.multimeleon.android.lifxhttpandroidlibrary.Models.SingleLight.Light;

import java.util.List;

/**
 * Created by Peter-John on 2017-03-25.
 * LifxHttpAndroid
 */

public interface LifxCallBacks {

    void lights(List<Light> lights);
    void lifxError(String error);
}
