package com.multimeleon.android.lifxhttpandroidlibrary;

import com.multimeleon.android.lifxhttpandroidlibrary.Models.SingleLight.Result;

import java.util.List;

/**
 * Created by dvtmpjwelcome on 2017/04/01.
 */

public interface LifxLightToggleCallBacks extends LifxCallBacks {

    void LightToggledSuccess(List<Result> results);
}
