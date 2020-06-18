package com.example.my_cv_app.expirience;



public class Experience {

    private String title, subtitle, date, city;
    private int image;

    public Experience(String title, String subtitle, String date, String city, int image) {
        this.title = title;
        this.subtitle = subtitle;
        this.date = date;
        this.city = city;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getDate() {
        return date;
    }

    public String getCity() {
        return city;
    }

    public int getImage() {
        return image;
    }
}
