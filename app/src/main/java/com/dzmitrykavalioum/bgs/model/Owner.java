
package com.dzmitrykavalioum.bgs.model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Owner implements Serializable {

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
    @SerializedName("dateOfBirth")
    @Expose
    private String dateOfBirth;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("rating")
    @Expose
    private Integer rating;
    @SerializedName("isActive")
    @Expose
    private Boolean isActive;
    @SerializedName("gameCollection")
    @Expose
    private List<Integer> gameCollection = null;
    @SerializedName("meetingSet")
    @Expose
    private List<Integer> meetingSet = null;
    @SerializedName("createdMeets")
    @Expose
    private List<Integer> createdMeets = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public Owner() {
    }

    /**
     *
     * @param password
     * @param createdMeets
     * @param gameCollection
     * @param rating
     * @param dateOfBirth
     * @param location
     * @param id
     * @param login
     * @param isActive
     * @param userId
     * @param meetingSet
     */
    public Owner(Integer userId, Integer id, String login, String password, String dateOfBirth, String location, Integer rating, Boolean isActive, List<Integer> gameCollection, List<Integer> meetingSet, List<Integer> createdMeets) {
        super();
        this.userId = userId;
        this.id = id;
        this.login = login;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.location = location;
        this.rating = rating;
        this.isActive = isActive;
        this.gameCollection = gameCollection;
        this.meetingSet = meetingSet;
        this.createdMeets = createdMeets;
    }

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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public List<Integer> getGameCollection() {
        return gameCollection;
    }

    public void setGameCollection(List<Integer> gameCollection) {
        this.gameCollection = gameCollection;
    }

    public List<Integer> getMeetingSet() {
        return meetingSet;
    }

    public void setMeetingSet(List<Integer> meetingSet) {
        this.meetingSet = meetingSet;
    }

    public List<Integer> getCreatedMeets() {
        return createdMeets;
    }

    public void setCreatedMeets(List<Integer> createdMeets) {
        this.createdMeets = createdMeets;
    }

}