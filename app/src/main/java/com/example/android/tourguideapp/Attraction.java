package com.example.android.tourguideapp;

class Attraction {
    private String name;
    private String description;
    private int imageResourceId;

    /**
     * Create a new Attraction object.
     *
     * @param name        is the name of the site
     * @param description short description of the attraction
     * @param imageId     is the id of an photo or image resource associated with attraction
     */
    Attraction(String name, String description, int imageId) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
