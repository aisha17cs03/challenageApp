package com.monthly.challeanges.challenageApp;

//this challenge class is help us store all the challenges information
public class Challenge {
    private Long id;
    private String month;
    private String description;

    //constructor for all id, month, description
    public Challenge(Long id, String month, String description) {
        this.id = id;
        this.month = month;
        this.description = description;
    }

    //getter for id
    public Long getId() {
        return id;
    }

    //setter for id
    public void setId(Long id) {
        this.id = id;
    }

    //getter for month
    public String getMonth() {
        return month;
    }

    //setter for month
    public void setMonth(String month) {
        this.month = month;
    }

    //getter for description
    public String getDescription() {
        return description;
    }

    //setter for description
    public void setDescription(String description) {
        this.description = description;
    }
}
