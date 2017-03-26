package com.multimeleon.android.lifxhttpandroidlibrary.Models.SingleLight;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Light implements Serializable, Parcelable {

    public final static Creator<Light> CREATOR = new Creator<Light>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Light createFromParcel(Parcel in) {
            Light instance = new Light();
            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            instance.uuid = ((String) in.readValue((String.class.getClassLoader())));
            instance.label = ((String) in.readValue((String.class.getClassLoader())));
            instance.connected = ((boolean) in.readValue((boolean.class.getClassLoader())));
            instance.power = ((String) in.readValue((String.class.getClassLoader())));
            instance.color = ((Color) in.readValue((Color.class.getClassLoader())));
            instance.zones = ((Object) in.readValue((Object.class.getClassLoader())));
            instance.brightness = ((double) in.readValue((double.class.getClassLoader())));
            instance.group = ((Group) in.readValue((Group.class.getClassLoader())));
            instance.location = ((Location) in.readValue((Location.class.getClassLoader())));
            instance.product = ((Product) in.readValue((Product.class.getClassLoader())));
            instance.infrared = ((Object) in.readValue((Object.class.getClassLoader())));
            instance.lastSeen = ((String) in.readValue((String.class.getClassLoader())));
            instance.secondsSinceSeen = ((double) in.readValue((double.class.getClassLoader())));
            return instance;
        }

        public Light[] newArray(int size) {
            return (new Light[size]);
        }

    };
    private final static long serialVersionUID = -130988529326286839L;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("uuid")
    @Expose
    private String uuid;
    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("connected")
    @Expose
    private boolean connected;
    @SerializedName("power")
    @Expose
    private String power;
    @SerializedName("color")
    @Expose
    private Color color;
    @SerializedName("zones")
    @Expose
    private Object zones;
    @SerializedName("brightness")
    @Expose
    private double brightness;
    @SerializedName("group")
    @Expose
    private Group group;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("product")
    @Expose
    private Product product;
    @SerializedName("infrared")
    @Expose
    private Object infrared;
    @SerializedName("last_seen")
    @Expose
    private String lastSeen;
    @SerializedName("seconds_since_seen")
    @Expose
    private double secondsSinceSeen;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Object getZones() {
        return zones;
    }

    public void setZones(Object zones) {
        this.zones = zones;
    }

    public double getBrightness() {
        return brightness;
    }

    public void setBrightness(double brightness) {
        this.brightness = brightness;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Object getInfrared() {
        return infrared;
    }

    public void setInfrared(Object infrared) {
        this.infrared = infrared;
    }

    public String getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(String lastSeen) {
        this.lastSeen = lastSeen;
    }

    public double getSecondsSinceSeen() {
        return secondsSinceSeen;
    }

    public void setSecondsSinceSeen(double secondsSinceSeen) {
        this.secondsSinceSeen = secondsSinceSeen;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(uuid);
        dest.writeValue(label);
        dest.writeValue(connected);
        dest.writeValue(power);
        dest.writeValue(color);
        dest.writeValue(zones);
        dest.writeValue(brightness);
        dest.writeValue(group);
        dest.writeValue(location);
        dest.writeValue(product);
        dest.writeValue(infrared);
        dest.writeValue(lastSeen);
        dest.writeValue(secondsSinceSeen);
    }

    public int describeContents() {
        return 0;
    }

}
