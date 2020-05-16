package com.dzmitrykavalioum.bgs.ui.createmeeting;

import com.dzmitrykavalioum.bgs.model.Meeting;

public interface CreateMeetingContract {
    interface PresenterContract {
        void createMeeting(int userId, int gameId, Meeting meeting);
    }

    interface ViewContract {
        void openWithSuccess(int userId, int ganeId);
    }
}
