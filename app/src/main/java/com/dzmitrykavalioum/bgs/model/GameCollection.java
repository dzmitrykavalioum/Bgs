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
import com.fasterxml.jackson.annotation.SimpleObjectIdResolver;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,
        property = "@boardGameId",
        resolver = SimpleObjectIdResolver.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({

        "id",
        "logo",
        "title",
        "description",
        "age",
        "rating",
        "isActive",
        "owners",
        "meetings",
        "numberOfOwners",
        "numberOfMeetings"
})
public class GameCollection implements Serializable {


    @JsonProperty("id")
    private int id;
    @JsonProperty("logo")
    private String logo;
    @JsonProperty("title")
    private String title;
    @JsonProperty("description")
    private Object description;
    @JsonProperty("age")
    private Integer age;
    @JsonProperty("rating")
    private Integer rating;
    @JsonProperty("isActive")
    private Boolean isActive;
    @JsonProperty("owners")
    private List<UserResponse> owners = null;
    @JsonProperty("meetings")
    private List<Meeting> meetings = null;
    @JsonProperty("numberOfOwners")
    private Integer numberOfOwners;
    @JsonProperty("numberOfMeetings")
    private Integer numberOfMeetings;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GameCollection() {
    }

    /**
     * @param rating
     * @param logo
     * @param description
     * @param numberOfOwners
     * @param owners
     * @param meetings
     * @param id
     * @param title
     * @param isActive
     * @param numberOfMeetings
     * @param age
     */
    public GameCollection(int id, String logo, String title, Object description, Integer age, Integer rating, Boolean isActive, List<UserResponse> owners, List<Meeting> meetings, Integer numberOfOwners, Integer numberOfMeetings) {
        super();
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


    @JsonProperty("id")
    public int getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("logo")
    public String getLogo() {
        return logo;
    }

    @JsonProperty("logo")
    public void setLogo(String logo) {
        this.logo = logo;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("description")
    public Object getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(Object description) {
        this.description = description;
    }

    @JsonProperty("age")
    public Integer getAge() {
        return age;
    }

    @JsonProperty("age")
    public void setAge(Integer age) {
        this.age = age;
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

    @JsonProperty("owners")
    public List<UserResponse> getOwners() {
        return owners;
    }

    @JsonProperty("owners")
    public void setOwners(List<UserResponse> owners) {
        this.owners = owners;
    }

    @JsonProperty("meetings")
    public List<Meeting> getMeetings() {
        return meetings;
    }

    @JsonProperty("meetings")
    public void setMeetings(List<Meeting> meetings) {
        this.meetings = meetings;
    }

    @JsonProperty("numberOfOwners")
    public Integer getNumberOfOwners() {
        return numberOfOwners;
    }

    @JsonProperty("numberOfOwners")
    public void setNumberOfOwners(Integer numberOfOwners) {
        this.numberOfOwners = numberOfOwners;
    }

    @JsonProperty("numberOfMeetings")
    public Integer getNumberOfMeetings() {
        return numberOfMeetings;
    }

    @JsonProperty("numberOfMeetings")
    public void setNumberOfMeetings(Integer numberOfMeetings) {
        this.numberOfMeetings = numberOfMeetings;
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