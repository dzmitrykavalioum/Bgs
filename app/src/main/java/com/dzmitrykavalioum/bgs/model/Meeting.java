
package com.dzmitrykavalioum.bgs.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "city",
        "location",
        "dateTime",
        "creator",
        "game",
        "state",
        "numberOfMembers"
})
public class Meeting {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("city")
    private String city;
    @JsonProperty("location")
    private String location;
    @JsonProperty("dateTime")
    private String dateTime;
    @JsonProperty("creator")
    private String creator;
    @JsonProperty("game")
    private String game;
    @JsonProperty("state")
    private String state;
    @JsonProperty("numberOfMembers")
    private Integer numberOfMembers;
    private boolean inMeeting = false;

    /**
     * No args constructor for use in serialization
     *
     */
    public Meeting() {
    }

    /**
     *
     * @param dateTime
     * @param creator
     * @param game
     * @param city
     * @param numberOfMembers
     * @param location
     * @param id
     * @param state
     */
    public Meeting(Integer id, String city, String location, String dateTime, String creator, String game, String state, Integer numberOfMembers) {
        super();
        this.id = id;
        this.city = city;
        this.location = location;
        this.dateTime = dateTime;
        this.creator = creator;
        this.game = game;
        this.state = state;
        this.numberOfMembers = numberOfMembers;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    public Meeting withId(Integer id) {
        this.id = id;
        return this;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    public Meeting withCity(String city) {
        this.city = city;
        return this;
    }

    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(String location) {
        this.location = location;
    }

    public Meeting withLocation(String location) {
        this.location = location;
        return this;
    }

    @JsonProperty("dateTime")
    public String getDateTime() {
        return dateTime;
    }

    @JsonProperty("dateTime")
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Meeting withDateTime(String dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    @JsonProperty("creator")
    public String getCreator() {
        return creator;
    }

    @JsonProperty("creator")
    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Meeting withCreator(String creator) {
        this.creator = creator;
        return this;
    }

    @JsonProperty("game")
    public String getGame() {
        return game;
    }

    @JsonProperty("game")
    public void setGame(String game) {
        this.game = game;
    }

    public Meeting withGame(String game) {
        this.game = game;
        return this;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    public Meeting withState(String state) {
        this.state = state;
        return this;
    }

    @JsonProperty("numberOfMembers")
    public Integer getNumberOfMembers() {
        return numberOfMembers;
    }

    @JsonProperty("numberOfMembers")
    public void setNumberOfMembers(Integer numberOfMembers) {
        this.numberOfMembers = numberOfMembers;
    }

    public Meeting withNumberOfMembers(Integer numberOfMembers) {
        this.numberOfMembers = numberOfMembers;
        return this;
    }
    public boolean isInMeeting() {
        return inMeeting;
    }

    public void setInMeeting(boolean inMeeting) {
        this.inMeeting = inMeeting;
    }


}