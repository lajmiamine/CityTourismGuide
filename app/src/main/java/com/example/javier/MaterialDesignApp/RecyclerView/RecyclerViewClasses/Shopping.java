package com.example.javier.MaterialDesignApp.RecyclerView.RecyclerViewClasses;


public class Shopping{

    String name;
    String description;
    String city;
    String adress;
    String type;
    String phone;
    String longitude;
    String lat;
    String id ;

    public Shopping(String name, String description, String city,String adress,String type,String phone,String longitude,String lat,String id) {
        this.name = name;
        this.description = description;
        this.city=city;
        this.adress=adress;
        this.type=type;
        this.phone=phone;
        this.longitude=longitude;
        this.lat=lat;
        this.id=id;

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
