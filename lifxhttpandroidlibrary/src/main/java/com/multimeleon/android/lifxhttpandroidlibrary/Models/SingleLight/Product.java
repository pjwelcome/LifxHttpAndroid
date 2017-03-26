package com.multimeleon.android.lifxhttpandroidlibrary.Models.SingleLight;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Product implements Serializable, Parcelable {

    public final static Creator<Product> CREATOR = new Creator<Product>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Product createFromParcel(Parcel in) {
            Product instance = new Product();
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.identifier = ((String) in.readValue((String.class.getClassLoader())));
            instance.company = ((String) in.readValue((String.class.getClassLoader())));
            instance.capabilities = ((Capabilities) in.readValue((Capabilities.class.getClassLoader())));
            return instance;
        }

        public Product[] newArray(int size) {
            return (new Product[size]);
        }

    };
    private final static long serialVersionUID = -1129817301976561492L;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("identifier")
    @Expose
    private String identifier;
    @SerializedName("company")
    @Expose
    private String company;
    @SerializedName("capabilities")
    @Expose
    private Capabilities capabilities;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Capabilities getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(Capabilities capabilities) {
        this.capabilities = capabilities;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(name);
        dest.writeValue(identifier);
        dest.writeValue(company);
        dest.writeValue(capabilities);
    }

    public int describeContents() {
        return 0;
    }

}
