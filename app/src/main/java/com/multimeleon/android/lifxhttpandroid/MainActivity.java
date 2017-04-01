package com.multimeleon.android.lifxhttpandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.multimeleon.android.lifxhttpandroidlibrary.LifxClient;
import com.multimeleon.android.lifxhttpandroidlibrary.LifxLightToggleCallBacks;
import com.multimeleon.android.lifxhttpandroidlibrary.Models.SingleLight.Light;
import com.multimeleon.android.lifxhttpandroidlibrary.Models.SingleLight.Result;

import java.util.List;

public class MainActivity extends AppCompatActivity implements LifxLightToggleCallBacks {
    private static final String TAG = MainActivity.class.getName();
    private LifxClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        client = new LifxClient("apikey", this);
        client.getListOfLights();

    }

    @Override
    public void lights(List<Light> lights) {
        for (Light light : lights) {
            Log.i(TAG, "Lights Power: " + light.getId());
        }
        client.toggleLight(lights.get(0).getId(), false, 0.5);
    }

    @Override
    public void lifxError(String error) {
        Log.i(TAG, "error: " + error);
    }

    @Override
    public void LightToggledSuccess(List<Result> results) {
        for (Result result : results) {
            Log.i(TAG, "Lights Status: " + result.getStatus());
        }
    }
}
