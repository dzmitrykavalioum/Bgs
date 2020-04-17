
package com.dzmitrykavalioum.bgs.model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meeting implements Serializable {

    @SerializedName("@meetingId")
    @Expose
    private Integer meetingId;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("dateTime")
    @Expose
    private String dateTime;
    @SerializedName("creator")
    @Expose
    private Integer creator;
    @SerializedName("game")
    @Expose
    private Integer game;
    @SerializedName("members")
    @Expose
    private List<Object> members = null;
    @SerializedName("numberOfMembers")
    @Expose
    private Integer numberOfMembers;

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
     * @param numberOfMembers
     * @param members
     * @param meetingId
     * @param location
     * @param id
     */
    public Meeting(Integer meetingId, Integer id, String location, String dateTime, Integer creator, Integer game, List<Object> members, Integer numberOfMembers) {
        super();
        this.meetingId = meetingId;
        this.id = id;
        this.location = location;
        this.dateTime = dateTime;
        this.creator = creator;
        this.game = game;
        this.members = members;
        this.numberOfMembers = numberOfMembers;
    }

    public Integer getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(Integer meetingId) {
        this.meetingId = meetingId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Integer getGame() {
        return game;
    }

    public void setGame(Integer game) {
        this.game = game;
    }

    public List<Object> getMembers() {
        return members;
    }

    public void setMembers(List<Object> members) {
        this.members = members;
    }

    public Integer getNumberOfMembers() {
        return numberOfMembers;
    }

    public void setNumberOfMembers(Integer numberOfMembers) {
        this.numberOfMembers = numberOfMembers;
    }

}