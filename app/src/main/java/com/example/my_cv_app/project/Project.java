package com.example.my_cv_app.project;

public class Project {

    private String title;
    private String description;
    private int logo;
    private int[] images;

    public Project(String title, String description, int logo, int[] images) {
        this.title = title;
        this.description = description;
        this.logo = logo;
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getLogo() {
        return logo;
    }

    public int[] getImages() {
        return images;
    }
}
