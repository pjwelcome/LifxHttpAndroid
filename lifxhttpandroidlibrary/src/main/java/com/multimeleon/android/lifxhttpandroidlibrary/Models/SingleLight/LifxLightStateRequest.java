package com.multimeleon.android.lifxhttpandroidlibrary.Models.SingleLight;

/**
 * Created by dvtmpjwelcome on 2017/03/11.
 */

public class LifxLightStateRequest {

    private String power;
    private Double brightness;


    public LifxLightStateRequest(String power, Double brightness) {
        this.power = power;
        this.brightness = brightness;
    }

    public Double getBrightness() {
        return brightness;
    }

    public void setBrightness(Double brightness) {
        this.brightness = brightness;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }
}
