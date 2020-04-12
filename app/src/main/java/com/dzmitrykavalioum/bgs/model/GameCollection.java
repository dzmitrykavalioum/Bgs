package com.dzmitrykavalioum.bgs.model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class GameCollection implements Serializable {

    @SerializedName("@boardGameId")
    @Expose
    private Integer boardGameId;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("logo")
    @Expose
    private String logo;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private Object description;
    @SerializedName("age")
    @Expose
    private Integer age;
    @SerializedName("rating")
    @Expose
    private Integer rating;
    @SerializedName("isActive")
    @Expose
    private Boolean isActive;
    @SerializedName("owners")
    @Expose
    private List<Integer> owners = null;
    @SerializedName("meetings")
    @Expose
    private List<Object> meetings = null;
    @SerializedName("numberOfOwners")
    @Expose
    private Integer numberOfOwners;
    @SerializedName("numberOfMeetings")
    @Expose
    private Integer numberOfMeetings;

    /**
     * No args constructor for use in serialization
     *
     */
    public GameCollection() {
    }

    /**
     *
     * @param rating
     * @param logo
     * @param description
     * @param numberOfOwners
     * @param boardGameId
     * @param owners
     * @param meetings
     * @param id
     * @param title
     * @param isActive
     * @param numberOfMeetings
     * @param age
     */
    public GameCollection(Integer boardGameId, Integer id, String logo, String title, Object description, Integer age, Integer rating, Boolean isActive, List<Integer> owners, List<Object> meetings, Integer numberOfOwners, Integer numberOfMeetings) {
        super();
        this.boardGameId = boardGameId;
        this.id = id;
        this.logo = logo;
        this.title = title;
        this.description = description;
        this.age = age;
        this.rating = rating;
        this.isActive = isActive;
        this.owners = owners;
        this.meetings = meetings;
        this.numberOfOwners = numberOfOwners;
        this.numberOfMeetings = numberOfMeetings;
    }

    public Integer getBoardGameId() {
        return boardGameId;
    }

    public void setBoardGameId(Integer boardGameId) {
        this.boardGameId = boardGameId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public List<Integer> getOwners() {
        return owners;
    }

    public void setOwners(List<Integer> owners) {
        this.owners = owners;
    }

    public List<Object> getMeetings() {
        return meetings;
    }

    public void setMeetings(List<Object> meetings) {
        this.meetings = meetings;
    }

    public Integer getNumberOfOwners() {
        return numberOfOwners;
    }

    public void setNumberOfOwners(Integer numberOfOwners) {
        this.numberOfOwners = numberOfOwners;
    }

    public Integer getNumberOfMeetings() {
        return numberOfMeetings;
    }

    public void setNumberOfMeetings(Integer numberOfMeetings) {
        this.numberOfMeetings = numberOfMeetings;
    }

//    @Override
//    public String toString() {
//        return new ToStringBuilder(this).append("boardGameId",
//                boardGameId).append("id", id).append("logo", logo).append("title", title).
//                append("description", description).append("age", age).append("rating", rating).
//                append("isActive", isActive).append("owners", owners).append("meetings", meetings).
//                append("numberOfOwners", numberOfOwners).append("numberOfMeetings", numberOfMeetings).toString();
//    }

}