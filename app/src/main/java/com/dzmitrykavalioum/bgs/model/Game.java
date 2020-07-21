package com.dzmitrykavalioum.bgs.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "logo",
        "title",
        "description",
        "isActive",
        "ratingValue",
        "numberOfOwners",
        "numberOfMeetings"
})
public class Game implements Serializable {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("logo")
    private String logo;
    @JsonProperty("title")
    private String title;
    @JsonProperty("description")
    private String description;
    @JsonProperty("isActive")
    private Boolean isActive;
    @JsonProperty("ratingValue")
    private Float ratingValue;
    @JsonProperty("numberOfOwners")
    private Integer numberOfOwners;
    @JsonProperty("numberOfMeetings")
    private Integer numberOfMeetings;

    /**
     * No args constructor for use in serialization
     *
     */
    public Game() {
    }

    /**
     *
     * @param ratingValue
     * @param logo
     * @param description
     * @param numberOfOwners
     * @param id
     * @param title
     * @param isActive
     * @param numberOfMeetings
     */
    public Game(Integer id, String logo, String title, String description, Boolean isActive, Float ratingValue, Integer numberOfOwners, Integer numberOfMeetings) {
        super();
        this.id = id;
        this.logo = logo;
        this.title = title;
        this.description = description;
        this.isActive = isActive;
        this.ratingValue = ratingValue;
        this.numberOfOwners = numberOfOwners;
        this.numberOfMeetings = numberOfMeetings;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    public Game withId(Integer id) {
        this.id = id;
        return this;
    }

    @JsonProperty("logo")
    public String getLogo() {
        return logo;
    }

    @JsonProperty("logo")
    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Game withLogo(String logo) {
        this.logo = logo;
        return this;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    public Game withTitle(String title) {
        this.title = title;
        return this;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    public Game withDescription(String description) {
        this.description = description;
        return this;
    }

    @JsonProperty("isActive")
    public Boolean getIsActive() {
        return isActive;
    }

    @JsonProperty("isActive")
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Game withIsActive(Boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    @JsonProperty("ratingValue")
    public Float getRatingValue() {
        return ratingValue;
    }

    @JsonProperty("ratingValue")
    public void setRatingValue(Float ratingValue) {
        this.ratingValue = ratingValue;
    }

    public Game withRatingValue(Float ratingValue) {
        this.ratingValue = ratingValue;
        return this;
    }

    @JsonProperty("numberOfOwners")
    public Integer getNumberOfOwners() {
        return numberOfOwners;
    }

    @JsonProperty("numberOfOwners")
    public void setNumberOfOwners(Integer numberOfOwners) {
        this.numberOfOwners = numberOfOwners;
    }

    public Game withNumberOfOwners(Integer numberOfOwners) {
        this.numberOfOwners = numberOfOwners;
        return this;
    }

    @JsonProperty("numberOfMeetings")
    public Integer getNumberOfMeetings() {
        return numberOfMeetings;
    }

    @JsonProperty("numberOfMeetings")
    public void setNumberOfMeetings(Integer numberOfMeetings) {
        this.numberOfMeetings = numberOfMeetings;
    }

    public Game withNumberOfMeetings(Integer numberOfMeetings) {
        this.numberOfMeetings = numberOfMeetings;
        return this;
    }

}