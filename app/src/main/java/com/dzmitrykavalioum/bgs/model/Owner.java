package com.dzmitrykavalioum.bgs.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.ObjectIdResolver;

@JsonIdentityInfo(resolver = ObjectIdResolver.class,
        property = "@ownerId",
        generator = ObjectIdGenerators.IntSequenceGenerator.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({

        "id",
        "login",
        "password",
        "dateOfBirth",
        "location",
        "rating",
        "isActive",
        "gameCollection",
        "meetingSet",
        "createdMeets"
})
public class Owner implements Serializable {


    @JsonProperty("id")
    private Integer id;
    @JsonProperty("login")
    private String login;
    @JsonProperty("password")
    private String password;
    @JsonProperty("dateOfBirth")
    private String dateOfBirth;
    @JsonProperty("location")
    private String location;
    @JsonProperty("rating")
    private Integer rating;
    @JsonProperty("isActive")
    private Boolean isActive;
    @JsonProperty("gameCollection")
    private List<Integer> gameCollection = null;
    @JsonProperty("meetingSet")
    private List<Object> meetingSet = null;
    @JsonProperty("createdMeets")
    private List<Object> createdMeets = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Owner() {
    }

    /**
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
    public Owner(Integer userId, Integer id, String login, String password, String dateOfBirth, String location, Integer rating, Boolean isActive, List<Integer> gameCollection, List<Object> meetingSet, List<Object> createdMeets) {
        super();

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


    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("login")
    public String getLogin() {
        return login;
    }

    @JsonProperty("login")
    public void setLogin(String login) {
        this.login = login;
    }

    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }

    @JsonProperty("dateOfBirth")
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    @JsonProperty("dateOfBirth")
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(String location) {
        this.location = location;
    }

    @JsonProperty("rating")
    public Integer getRating() {
        return rating;
    }

    @JsonProperty("rating")
    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @JsonProperty("isActive")
    public Boolean getIsActive() {
        return isActive;
    }

    @JsonProperty("isActive")
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @JsonProperty("gameCollection")
    public List<Integer> getGameCollection() {
        return gameCollection;
    }

    @JsonProperty("gameCollection")
    public void setGameCollection(List<Integer> gameCollection) {
        this.gameCollection = gameCollection;
    }

    @JsonProperty("meetingSet")
    public List<Object> getMeetingSet() {
        return meetingSet;
    }

    @JsonProperty("meetingSet")
    public void setMeetingSet(List<Object> meetingSet) {
        this.meetingSet = meetingSet;
    }

    @JsonProperty("createdMeets")
    public List<Object> getCreatedMeets() {
        return createdMeets;
    }

    @JsonProperty("createdMeets")
    public void setCreatedMeets(List<Object> createdMeets) {
        this.createdMeets = createdMeets;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}