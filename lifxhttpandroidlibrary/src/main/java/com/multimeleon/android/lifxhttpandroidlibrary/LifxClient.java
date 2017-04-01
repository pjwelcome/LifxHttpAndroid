package com.multimeleon.android.lifxhttpandroidlibrary;

import com.multimeleon.android.lifxhttpandroidlibrary.Common.Constants;
import com.multimeleon.android.lifxhttpandroidlibrary.Common.Injector;
import com.multimeleon.android.lifxhttpandroidlibrary.Interfaces.ILifxClient;
import com.multimeleon.android.lifxhttpandroidlibrary.Models.SingleLight.LifxLightStateRequest;
import com.multimeleon.android.lifxhttpandroidlibrary.Models.SingleLight.Light;
import com.multimeleon.android.lifxhttpandroidlibrary.Models.SingleLight.Result;
import com.multimeleon.android.lifxhttpandroidlibrary.Repo.LifxClientPresenter;
import com.multimeleon.android.lifxhttpandroidlibrary.Repo.LifxClientPresenterImpl;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Peter-John on 2017-03-24.
 * LifxHttpAndroid
 */

public class LifxClient implements ILifxClient {

    private String apiKey;
    private LifxLightToggleCallBacks callBacks;
    private List<Light> lights;
    private String error;
    private LifxClientPresenter presenter;

    public LifxClient(String apiKey, LifxLightToggleCallBacks callBacks) {
        this.apiKey = apiKey;
        this.callBacks = callBacks;
        presenter = new LifxClientPresenterImpl(this, Injector.provideLifxLightsRepo(this.apiKey), Schedulers.io(), AndroidSchedulers.mainThread());
    }
    @Override
    public String getApiKey() {
        return apiKey;
    }
    @Override
    public void setLights(List<Light> lights) {
        this.lights = lights;
        callBacks.lights(lights);
    }

    @Override
    public String getError() {
        return this.error;
    }

    @Override
    public void setError(String message) {
        this.error = message;
        callBacks.lifxError(error);
    }

    @Override
    public void toggleLight(String lightId, boolean on, Double brightness) {

        presenter.toggleLights(lightId, new LifxLightStateRequest(on ? Constants.LIFXLIGHTSONSTRING : Constants.LIFXLIGHTSOFFSTRING, brightness));
    }

    @Override
    public void toggleLightResult(List<Result> results) {
        callBacks.LightToggledSuccess(results);
    }


    @Override
    public void getListOfLights() {
        presenter.fetchAllLights();
    }
}
