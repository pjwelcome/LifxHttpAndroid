package com.multimeleon.android.lifxhttpandroidlibrary.Repo;

import com.multimeleon.android.lifxhttpandroidlibrary.Common.Constants;
import com.multimeleon.android.lifxhttpandroidlibrary.Interfaces.ILifxClient;
import com.multimeleon.android.lifxhttpandroidlibrary.Interfaces.LifxLightsRepo;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

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

    private void addSubscription(Disposable subscription) {
        this.compositeSubscription.add(subscription);
    }
}
