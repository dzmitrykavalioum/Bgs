package com.dzmitrykavalioum.bgs.ui.createmeeting;

import com.dzmitrykavalioum.bgs.model.Meeting;
import com.dzmitrykavalioum.bgs.service.NetworkService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateMeetingPresenter implements CreateMeetingContract.PresenterContract {

    private CreateMeetingContract.ViewContract view;

    public CreateMeetingPresenter(CreateMeetingContract.ViewContract view) {
        this.view = view;
    }

    @Override
    public void createMeeting(int userId, int gameId, Meeting meeting) {
        Call<String> callCreateMeeting = NetworkService.users().createMeeting(userId,gameId,meeting);
        callCreateMeeting.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                    view.openWithSuccess(userId,gameId);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }
}
