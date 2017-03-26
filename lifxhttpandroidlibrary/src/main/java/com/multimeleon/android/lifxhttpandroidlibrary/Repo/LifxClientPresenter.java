package com.multimeleon.android.lifxhttpandroidlibrary.Repo;

import com.multimeleon.android.lifxhttpandroidlibrary.Models.SingleLight.Light;

import java.util.List;

/**
 * Created by Peter-John on 2017-03-25.
 * LifxHttpAndroid
 */

public interface LifxClientPresenter {

    void fetchAllLights();

    void cleanUp();
}
