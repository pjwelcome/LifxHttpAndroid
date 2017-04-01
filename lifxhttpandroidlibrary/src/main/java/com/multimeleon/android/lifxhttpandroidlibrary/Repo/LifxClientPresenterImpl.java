package com.multimeleon.android.lifxhttpandroidlibrary.Repo;

import com.multimeleon.android.lifxhttpandroidlibrary.Common.Constants;
import com.multimeleon.android.lifxhttpandroidlibrary.Interfaces.ILifxClient;
import com.multimeleon.android.lifxhttpandroidlibrary.Interfaces.LifxLightsRepo;
import com.multimeleon.android.lifxhttpandroidlibrary.Models.SingleLight.LifxLightStateRequest;

import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Peter-John on 2017-03-25.
 * LifxHttpAndroid
 */

public class LifxClientPresenterImpl implements LifxClientPresenter {

    private ILifxClient client;
    private LifxLightsRepo lifxLightsRepo;
    private Scheduler backgroundThread;
    private Scheduler mainThread;
    private CompositeDisposable compositeSubscription = new CompositeDisposable();

    public LifxClientPresenterImpl(ILifxClient client, LifxLightsRepo repo, Scheduler backgroundThread, Scheduler mainThread) {
        this.client = client;
        lifxLightsRepo = repo;
        this.backgroundThread = backgroundThread;
        this.mainThread = mainThread;
    }

    @Override
    public void fetchAllLights() {

        addSubscription(lifxLightsRepo.getLights(Constants.LIFXALLLIGGHTSSTRING)
                .subscribeOn(backgroundThread)
                .observeOn(mainThread)
                .subscribe(
                        lights -> this.client.setLights(lights),
                        error -> this.client.setError(error.getMessage())));
    }

    @Override
    public void cleanUp() {
        this.compositeSubscription.dispose();
    }

    @Override
    public void toggleLights(String lightId, LifxLightStateRequest stateRequest) {
        addSubscription(lifxLightsRepo.setLightState(lightId, stateRequest)
                .subscribeOn(backgroundThread)
                .observeOn(mainThread)
                .subscribe(
                        results -> this.client.toggleLightResult(results),
                        error -> this.client.setError(error.getMessage())));
    }


    private void addSubscription(Disposable subscription) {
        this.compositeSubscription.add(subscription);
    }
}
