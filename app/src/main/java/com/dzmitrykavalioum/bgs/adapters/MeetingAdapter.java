package com.dzmitrykavalioum.bgs.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.dzmitrykavalioum.bgs.ui.gameitem.GameItemActivity;
import com.dzmitrykavalioum.bgs.R;
import com.dzmitrykavalioum.bgs.model.Meeting;
import com.dzmitrykavalioum.bgs.model.UserResponse;
import com.dzmitrykavalioum.bgs.service.NetworkService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MeetingAdapter extends BaseAdapter {
    private Context ctx;
    private LayoutInflater layoutInflater;
    private ArrayList<Meeting> meetingsOfGame;
    private Button btn_takepart;
    private UserResponse user;
    private Call<String> call;


    public MeetingAdapter(Context context, ArrayList<Meeting> meetingList, UserResponse userResponse) {
        ctx = context;
        meetingsOfGame = meetingList;
        layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        user = userResponse;
    }

    @Override
    public int getCount() {
        return meetingsOfGame.size();
    }

    @Override
    public Object getItem(int i) {
        return meetingsOfGame.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        View view = convertView;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.item_meeting, viewGroup, false);
        }

        Meeting meeting = getMeeting(i);
        ((TextView) view.findViewById(R.id.tv_location)).setText(meeting.getLocation());
        ((TextView) view.findViewById(R.id.tv_date_meeting)).setText(meeting.getDateTime());
        ((TextView) view.findViewById(R.id.tv_creator_name)).setText(meeting.getCreator().getLogin());
        ((TextView) view.findViewById(R.id.tv_members_qty)).setText(meeting.getNumberOfMembers().toString());
        btn_takepart = view.findViewById(R.id.btn_takepart_leave);
        List<Meeting> userMeetingSet = user.getMeetingSet();

        for (Meeting item : userMeetingSet) {
            if (item.getId() == meeting.getId()) {
                btn_takepart.setText("Leave");
                call = NetworkService.users().leaveMeeting(user.getId().intValue(),meeting.getId());
                meeting.setInMeeting(true);

                break;
            } else {
                btn_takepart.setText("Take part");
                call = NetworkService.users().addMeeting(user.getId().intValue(),meeting.getId());
                meeting.setInMeeting(false);

            }

        }
        btn_takepart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(ctx, meeting.getCreator().getLogin().toString() + meeting.isInMeeting(), Toast.LENGTH_SHORT).show();
                Call<String> call = null;
                if (meeting.isInMeeting()) {
                    call = NetworkService.users().leaveMeeting(user.getId().intValue(), meeting.getId());

                } else {
                    call = NetworkService.users().addMeeting (user.getId().intValue(), meeting.getId());
                }
                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        // Toast.makeText(ctx,response.body(),Toast.LENGTH_SHORT).show();
                        //boolean isInMeetingOld = meeting.isInMeeting();
                        //meeting.setInMeeting(!isInMeetingOld);

                        if (ctx instanceof GameItemActivity){
                            ((GameItemActivity)ctx).update(user.getId());

                        }

                        //notifyDataSetChanged();

                        Log.i("meeting", "ok");
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        //Toast.makeText(ctx,t.getMessage(),Toast.LENGTH_SHORT).show();
                        Log.i("meeting", t.getMessage());
                    }
                });


            }
        });
        return view;
    }

    private Meeting getMeeting(int i) {
        return (Meeting) getItem(i);
    }
}
