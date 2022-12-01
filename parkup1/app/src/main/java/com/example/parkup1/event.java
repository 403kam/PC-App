package com.example.parkup1;

public class event {
    private String title;
    private String description;
    private String date;
    private String time;
    private String streetaddress;
    private String city;
    private String zipcode;
    private String maxparticipants;
    private String creator;
    private Integer id;
    // private String[] participants;

    public event() {
    }

    public event(String title, String description, String date,
                 String time, String streetaddress, String city,
                 String zipcode, String maxparticipants, String creator, Integer id) { //,
        // String[] participants) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.time = time;
        this.streetaddress = streetaddress;
        this.city = city;
        this.zipcode = zipcode;
        this.maxparticipants = maxparticipants;
        this.creator = creator;
        this.id = id;
        // this.participants = participants;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStreetaddress() {
        return streetaddress;
    }

    public void setStreetaddress(String streetaddress) {
        this.streetaddress = streetaddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getMaxparticipants() {
        return maxparticipants;
    }

    public void setMaxparticipants(String maxparticipants) {
        this.maxparticipants = maxparticipants;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
/*
    public String[] getParticipants() {
        return participants;
    }

    public void setParticipants(String[] participants) {
        this.participants = participants;
    }
 */
}
