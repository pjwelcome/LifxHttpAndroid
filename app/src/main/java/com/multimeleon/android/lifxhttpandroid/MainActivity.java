package com.multimeleon.android.lifxhttpandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.multimeleon.android.lifxhttpandroidlibrary.LifxCallBacks;
import com.multimeleon.android.lifxhttpandroidlibrary.LifxClient;
import com.multimeleon.android.lifxhttpandroidlibrary.Models.SingleLight.Light;

import java.util.List;

public class MainActivity extends AppCompatActivity implements LifxCallBacks {

    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LifxClient client = new LifxClient("apikey", this);
        client.getListOfLights();
    }

    @Override
    public void lights(List<Light> lights) {
        for (Light light : lights) {
            Log.i(TAG, "Lights Power: " + light.getId());
        }
    }

    @Override
    public void lifxError(String error) {
        Log.i(TAG, "error: " + error);
    }
}
