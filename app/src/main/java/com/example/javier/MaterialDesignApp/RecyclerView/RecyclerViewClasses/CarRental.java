package com.example.javier.MaterialDesignApp.RecyclerView.RecyclerViewClasses;


public class CarRental{

    String name;

    String city;
    String adress;

    String phone;
    String longitude;
    String lat;
    String id ;
    String website;



    public CarRental(String name, String website,String city,String adress,String phone,String longitude,String lat,String id) {
        this.name = name;

        this.website=website;

        this.city=city;
        this.adress=adress;

        this.phone=phone;
        this.longitude=longitude;
        this.lat=lat;
        this.id=id;

    }
    public String getWebsite() {
        return website;
    }

    public String getName() {
        return name;
    }



    public String getCity() {
        return city;
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
