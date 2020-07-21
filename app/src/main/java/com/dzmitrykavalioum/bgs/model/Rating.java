
package com.dzmitrykavalioum.bgs.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "game",
        "user",
        "gameRate",
        "userExperience",
        "completedMeets"
})
public class Rating implements Serializable {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("game")
    private String game;
    @JsonProperty("user")
    private String user;
    @JsonProperty("gameRate")
    private Float gameRate;
    @JsonProperty("userExperience")
    private Float userExperience;
    @JsonProperty("completedMeets")
    private Integer completedMeets;

    /**
     * No args constructor for use in serialization
     *
     */
    public Rating() {
    }

    /**
     *
     * @param completedMeets
     * @param game
     * @param gameRate
     * @param userExperience
     * @param id
     * @param user
     */
    public Rating(Integer id, String game, String user, Float gameRate, Float userExperience, Integer completedMeets) {
        super();
        this.id = id;
        this.game = game;
        this.user = user;
        this.gameRate = gameRate;
        this.userExperience = userExperience;
        this.completedMeets = completedMeets;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    public Rating withId(Integer id) {
        this.id = id;
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

    public Rating withGame(String game) {
        this.game = game;
        return this;
    }

    @JsonProperty("user")
    public String getUser() {
        return user;
    }

    @JsonProperty("user")
    public void setUser(String user) {
        this.user = user;
    }

    public Rating withUser(String user) {
        this.user = user;
        return this;
    }

    @JsonProperty("gameRate")
    public Float getGameRate() {
        return gameRate;
    }

    @JsonProperty("gameRate")
    public void setGameRate(Float gameRate) {
        this.gameRate = gameRate;
    }

    public Rating withGameRate(Float gameRate) {
        this.gameRate = gameRate;
        return this;
    }

    @JsonProperty("userExperience")
    public Float getUserExperience() {
        return userExperience;
    }

    @JsonProperty("userExperience")
    public void setUserExperience(Float userExperience) {
        this.userExperience = userExperience;
    }

    public Rating withUserExperience(Float userExperience) {
        this.userExperience = userExperience;
        return this;
    }

    @JsonProperty("completedMeets")
    public Integer getCompletedMeets() {
        return completedMeets;
    }

    @JsonProperty("completedMeets")
    public void setCompletedMeets(Integer completedMeets) {
        this.completedMeets = completedMeets;
    }

    public Rating withCompletedMeets(Integer completedMeets) {
        this.completedMeets = completedMeets;
        return this;
    }

}