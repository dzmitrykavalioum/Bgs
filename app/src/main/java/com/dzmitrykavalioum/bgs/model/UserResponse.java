package com.dzmitrykavalioum.bgs.model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserResponse implements Serializable {

    @SerializedName("@userId")
    @Expose
    private Integer userId;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("login")
    @Expose
    private String login;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("age")
    @Expose
    private Integer age;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("rating")
    @Expose
    private Integer rating;
    @SerializedName("gameCollection")
    @Expose
    private List<Object> gameCollection = null;
    @SerializedName("meetingSet")
    @Expose
    private List<Object> meetingSet = null;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public List<Object> getGameCollection() {
        return gameCollection;
    }

    public void setGameCollection(List<Object> gameCollection) {
        this.gameCollection = gameCollection;
    }

    public List<Object> getMeetingSet() {
        return meetingSet;
    }

    public void setMeetingSet(List<Object> meetingSet) {
        this.meetingSet = meetingSet;
    }

}





