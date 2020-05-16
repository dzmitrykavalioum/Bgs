package com.dzmitrykavalioum.bgs.service;

import com.dzmitrykavalioum.bgs.model.GameCollection;
import com.dzmitrykavalioum.bgs.model.Meeting;
import com.dzmitrykavalioum.bgs.model.UserResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

//http://localhost:8080/mobile/sign_in/111&111

public interface UserApi {


    //user

    @GET("user")
    Call<UserResponse> signIn(@Query("login") String login, @Query("password") String password);

    @POST("user")
    Call<String> registration(@Body UserResponse userResponse);

    @PUT("user")
    Call<UserResponse> update(@Query("userId") int id, @Body UserResponse changedUser); //

    //meeting

    @PUT("user/meet_in")
    Call<String> addMeeting(@Query("userId") int userId, @Query("meetId") int meetId);

    @PUT("user/meet_out")
    Call<String> leaveMeeting(@Query("userId") int userId, @Query("meetId") int meetId);

    @GET("userMeetingList")
    Call<List<Meeting>> userMeetingList(@Query("userId")  int userId);

    @POST ("user/meet")
    Call<String> createMeeting(@Query("userId") int userId, @Query("gameId") int gameId, @Body Meeting meeting);






    //game

    @GET("gameListPage")
    Call<List<GameCollection>> unsubscrableGameList(@Query("userId") int userId);

    @POST("userGameList")
    Call<List<GameCollection>> userGameList(@Query("userId") int userId);

    @GET("allGameList")
    Call<List<GameCollection>> allGameList();

    @POST("user/game")
    Call<UserResponse> addGame(@Query("userId") int userId, @Query("gameId") int gameId);

    @DELETE("user/game")
    Call<UserResponse> deleteGame(@Query("userId") int userId, @Query("gameId") int gameId);




    /*
    *  @PutMapping("/user/meet_in")
    public String addMeeting(int userId, int meetId) {
        userService.takePartInMeeting(userId, meetId);
        return "ok";
    }


    @PutMapping("/user/meet_out")
    public String leaveMeeting(int userId, int meetId) {
        userService.leaveMeeting(userId, meetId);
        return "ok";
    }
    *
    *
    *
    *    @GetMapping("/userMeetingList")
    public List<Meeting> meetingList(int userId) {
        User currentUser = userService.getUserById(userId);
        return currentUser.getMeetingSet();
    }
    *
    *     @PostMapping("/user/meet")
    public String createMeet(int userId, int gameId, @RequestBody Meeting meet) {
        User currentUser = userService.getUserById(userId);
        meet.setGane(gameService.getGameById(gameId));
        meetingService.createMeet(currentUser.getId(), meet);
        //userService.takePartInMeeting(currentUser.getId(), meet.getId());
        return "true";
    }

    @DeleteMapping("/user/meet")
    public String deleteMeet(int userId, int meetId) {
        userService.deleteMeeting(userId, meetId);
        meetingService.removeMeet(meetId);
        return "true";
    }
    *
    * */

}
