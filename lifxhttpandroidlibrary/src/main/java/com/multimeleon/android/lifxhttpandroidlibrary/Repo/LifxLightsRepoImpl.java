package com.multimeleon.android.lifxhttpandroidlibrary.Repo;

import com.multimeleon.android.lifxhttpandroidlibrary.Interfaces.LifxLightsRepo;
import com.multimeleon.android.lifxhttpandroidlibrary.Interfaces.LifxLightsService;
import com.multimeleon.android.lifxhttpandroidlibrary.Models.SingleLight.LifxLightStateRequest;
import com.multimeleon.android.lifxhttpandroidlibrary.Models.SingleLight.Light;
import com.multimeleon.android.lifxhttpandroidlibrary.Models.SingleLight.Result;

import java.io.IOException;
import java.util.List;

import io.reactivex.Observable;

/**
 * Created by dvtmpjwelcome on 2017/03/11.
 */

public class LifxLightsRepoImpl implements LifxLightsRepo {

    private LifxLightsService lightsService;

    public LifxLightsRepoImpl(LifxLightsService lightsService) {
        this.lightsService = lightsService;
    }

    @Override
    public Observable<List<Light>> getLights(String selector) {
        return lightsService.getLights(selector)
                .retryWhen(observable ->
                        observable.flatMap(o ->
                        {
                            if (o instanceof IOException) {
                                return Observable.error(o);
                            }
                            return Observable.error(o);
                        }));
    }

    @Override
    public Observable<List<Result>> setLightState(String selector, LifxLightStateRequest request) {
        return lightsService.setLightState(selector, request);
    }
}
