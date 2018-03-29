package com.example.javier.MaterialDesignApp.RecyclerView.RecyclerViewClasses;

/**
 * Created by Hamza on 22/11/2015.
 */
public class Gastronomy {
    String name;
    String description;
    String city;
    String adress;
    String type;
    String phone;
    String longitude;
    String lat;
    String id ;
    String website;
    String openingHours;
    String url;


    public Gastronomy(String name, String description, String city,String adress,String type,String phone,String longitude,String lat,String id,String website,String openingHours,String url) {
        this.name = name;
        this.description = description;
        this.city=city;
        this.adress=adress;
        this.type=type;
        this.phone=phone;
        this.longitude=longitude;
        this.lat=lat;
        this.id=id;
        this.openingHours=openingHours;
        this.website=website;
        this.url=website;


    }
    public String getUrl() {
        return url;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public String getWebsite() {
        return website;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCity() {
        return city;
    }

    public String getType() {
        return type;
    }

    public String getAdress() {
        return adress;
    }

    public String getPhone() {
        return phone;
    }

    public String getLat() {
        return lat;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getId() {
        return id;
    }
}
