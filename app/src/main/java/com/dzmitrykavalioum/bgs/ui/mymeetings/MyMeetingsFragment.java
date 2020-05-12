package com.dzmitrykavalioum.bgs.ui.mymeetings;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.dzmitrykavalioum.bgs.R;
import com.dzmitrykavalioum.bgs.adapters.MeetingAdapter;
import com.dzmitrykavalioum.bgs.model.GameCollection;
import com.dzmitrykavalioum.bgs.model.Meeting;
import com.dzmitrykavalioum.bgs.model.UserResponse;

import java.util.ArrayList;
import java.util.List;

public class MyMeetingsFragment extends Fragment {


    private List<Meeting> meetings;
    private UserResponse userResponse;
    private ListView lv_meetings;
    private MeetingAdapter meetingAdapter;

    public static MyMeetingsFragment newInstance() {
        return new MyMeetingsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.my_meetings_fragment, container, false);
        lv_meetings = (ListView) root.findViewById(R.id.lv_my_meetings);
        Bundle bundle = getArguments();
        if (bundle != null) {
            userResponse = (UserResponse) bundle.getSerializable(UserResponse.class.getSimpleName());
//            textView.setText(userResponse.getLogin());

        }
        meetings = userResponse.getMeetingSet();

        if (meetings != null) {
            meetingAdapter = new MeetingAdapter(getActivity(),(ArrayList<Meeting>)meetings,userResponse);
            lv_meetings.setAdapter(meetingAdapter);

        }


        return root;
    }


}
