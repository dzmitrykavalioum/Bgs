
package com.dzmitrykavalioum.bgs.model;

import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "login",
        "age",
        "dateOfBirth",
        "address",
        "email",
        "isActive",
        "isEnabled",
        "avatar",
        "city",
        "ratings",
        "games",
        "meetings",
        "totalExperience",
        "completedMeetsNumber"
})
public class User implements Serializable {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("login")
    private String login;
    @JsonProperty("age")
    private Integer age;
    @JsonProperty("dateOfBirth")
    private String dateOfBirth;
    @JsonProperty("address")
    private String address;
    @JsonProperty("email")
    private String email;
    @JsonProperty("isActive")
    private Boolean isActive;
    @JsonProperty("isEnabled")
    private Boolean isEnabled;
    @JsonProperty("avatar")
    private String avatar;
    @JsonProperty("city")
    private String city;
    @JsonProperty("ratings")
    private List<Rating> ratings = null;
    @JsonProperty("games")
    private List<Game> games = null;
    @JsonProperty("meetings")
    private List<Meeting> meetings = null;
    @JsonProperty("totalExperience")
    private Float totalExperience;
    @JsonProperty("completedMeetsNumber")
    private Integer completedMeetsNumber;

    /**
     * No args constructor for use in serialization
     *
     */
    public User() {
    }

    /**
     *
     * @param completedMeetsNumber
     * @param address
     * @param city
     * @param dateOfBirth
     * @param avatar
     * @param login
     * @param isActive
     * @param ratings
     * @param totalExperience
     * @param isEnabled
     * @param games
     * @param meetings
     * @param id
     * @param age
     * @param email
     */
    public User(Integer id, String login, Integer age, String dateOfBirth, String address, String email, Boolean isActive, Boolean isEnabled, String avatar, String city, List<Rating> ratings, List<Game> games, List<Meeting> meetings, Float totalExperience, Integer completedMeetsNumber) {
        super();
        this.id = id;
        this.login = login;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.email = email;
        this.isActive = isActive;
        this.isEnabled = isEnabled;
        this.avatar = avatar;
        this.city = city;
        this.ratings = ratings;
        this.games = games;
        this.meetings = meetings;
        this.totalExperience = totalExperience;
        this.completedMeetsNumber = completedMeetsNumber;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    public User withId(Integer id) {
        this.id = id;
        return this;
    }

    @JsonProperty("login")
    public String getLogin() {
        return login;
    }

    @JsonProperty("login")
    public void setLogin(String login) {
        this.login = login;
    }

    public User withLogin(String login) {
        this.login = login;
        return this;
    }

    @JsonProperty("age")
    public Integer getAge() {
        return age;
    }

    @JsonProperty("age")
    public void setAge(Integer age) {
        this.age = age;
    }

    public User withAge(Integer age) {
        this.age = age;
        return this;
    }

    @JsonProperty("dateOfBirth")
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    @JsonProperty("dateOfBirth")
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public User withDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    public User withAddress(String address) {
        this.address = address;
        return this;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    public User withEmail(String email) {
        this.email = email;
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

    public User withIsActive(Boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    @JsonProperty("isEnabled")
    public Boolean getIsEnabled() {
        return isEnabled;
    }

    @JsonProperty("isEnabled")
    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public User withIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
        return this;
    }

    @JsonProperty("avatar")
    public String getAvatar() {
        return avatar;
    }

    @JsonProperty("avatar")
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public User withAvatar(String avatar) {
        this.avatar = avatar;
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

    public User withCity(String city) {
        this.city = city;
        return this;
    }

    @JsonProperty("ratings")
    public List<Rating> getRatings() {
        return ratings;
    }

    @JsonProperty("ratings")
    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public User withRatings(List<Rating> ratings) {
        this.ratings = ratings;
        return this;
    }

    @JsonProperty("games")
    public List<Game> getGames() {
        return games;
    }

    @JsonProperty("games")
    public void setGames(List<Game> games) {
        this.games = games;
    }

    public User withGames(List<Game> games) {
        this.games = games;
        return this;
    }

    @JsonProperty("meetings")
    public List<Meeting> getMeetings() {
        return meetings;
    }

    @JsonProperty("meetings")
    public void setMeetings(List<Meeting> meetings) {
        this.meetings = meetings;
    }

    public User withMeetings(List<Meeting> meetings) {
        this.meetings = meetings;
        return this;
    }

    @JsonProperty("totalExperience")
    public Float getTotalExperience() {
        return totalExperience;
    }

    @JsonProperty("totalExperience")
    public void setTotalExperience(Float totalExperience) {
        this.totalExperience = totalExperience;
    }

    public User withTotalExperience(Float totalExperience) {
        this.totalExperience = totalExperience;
        return this;
    }

    @JsonProperty("completedMeetsNumber")
    public Integer getCompletedMeetsNumber() {
        return completedMeetsNumber;
    }

    @JsonProperty("completedMeetsNumber")
    public void setCompletedMeetsNumber(Integer completedMeetsNumber) {
        this.completedMeetsNumber = completedMeetsNumber;
    }

    public User withCompletedMeetsNumber(Integer completedMeetsNumber) {
        this.completedMeetsNumber = completedMeetsNumber;
        return this;
    }

}