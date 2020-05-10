


package com.dzmitrykavalioum.bgs.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.SimpleObjectIdResolver;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,
        property = "@meetingId",
        resolver = SimpleObjectIdResolver.class)


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({

        "id",
        "location",
        "dateTime",
        "creator",
        "game",
        "members",
        "numberOfMembers"
})
public class Meeting implements Serializable {


    @JsonProperty("id")
    private int id;
    @JsonProperty("location")
    private String location;
    @JsonProperty("dateTime")
    private String dateTime;
    @JsonProperty("creator")
    private UserResponse creator;
    @JsonProperty("game")
    private GameCollection game;
    @JsonProperty("members")
    private List<UserResponse> members = null;
    @JsonProperty("numberOfMembers")
    private Integer numberOfMembers;
    private boolean inMeeting = false;

    /**
     * No args constructor for use in serialization
     */
    public Meeting() {
    }

    /**
     * @param dateTime
     * @param creator
     * @param game
     * @param numberOfMembers
     * @param members

     * @param location
     * @param id
     */
    public Meeting(int id, String location, String dateTime, UserResponse creator, GameCollection game, List<UserResponse> members, Integer numberOfMembers) {
        super();

        this.id = id;
        this.location = location;
        this.dateTime = dateTime;
        this.creator = creator;
        this.game = game;
        this.members = members;
        this.numberOfMembers = numberOfMembers;
    }



    @JsonProperty("id")
    public int getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(int id) {
        this.id = id;
    }

    public Meeting withId(int id) {
        this.id = id;
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
    public UserResponse getCreator() {
        return creator;
    }

    @JsonProperty("creator")
    public void setCreator(UserResponse creator) {
        this.creator = creator;
    }

    public Meeting withCreator(UserResponse creator) {
        this.creator = creator;
        return this;
    }

    @JsonProperty("game")
    public GameCollection getGame() {
        return game;
    }

    @JsonProperty("game")
    public void setGame(GameCollection game) {
        this.game = game;
    }

    public Meeting withGame(GameCollection game) {
        this.game = game;
        return this;
    }

    @JsonProperty("members")
    public List<UserResponse> getMembers() {
        return members;
    }

    @JsonProperty("members")
    public void setMembers(List<UserResponse> members) {
        this.members = members;
    }

    public Meeting withMembers(List<UserResponse> members) {
        this.members = members;
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