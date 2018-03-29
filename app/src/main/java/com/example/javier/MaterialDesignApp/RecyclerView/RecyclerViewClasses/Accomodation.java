package com.example.javier.MaterialDesignApp.RecyclerView.RecyclerViewClasses;

/**
 * Created by Hamza on 22/11/2015.
 */
public class Accomodation {
    String address;
    String city;
    String  link;
    String hotelName;
    String website;
    String availability;
    String longitude;
    String lat;
    String contact;
    String id;


    public Accomodation(String address,
            String city,
            String  link,
            String hotelName,
            String website,
            String availability,
            String longitude,
            String lat,
            String contact,
            String id) {
       this.address=address;
        this.availability=availability;
        this.city=city;
        this.contact=contact;
        this.id=id;
        this.lat=lat;
        this.link=link;
        this.hotelName=hotelName;
        this.website=website;
        this.longitude=longitude;
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getLink() {
        return link;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getWebsite() {
        return website;
    }

    public String getAvailability() {
        return availability;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLat() {
        return lat;
    }

    public String getContact() {
        return contact;
    }
}

