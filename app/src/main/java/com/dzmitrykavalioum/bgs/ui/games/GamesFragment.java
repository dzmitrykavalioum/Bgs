package com.dzmitrykavalioum.bgs.ui.games;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.dzmitrykavalioum.bgs.R;
import com.dzmitrykavalioum.bgs.adapters.GameAdapter;
import com.dzmitrykavalioum.bgs.model.GameCollection;
import com.dzmitrykavalioum.bgs.model.UserResponse;
import com.dzmitrykavalioum.bgs.service.NetworkService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GamesFragment extends Fragment {

    //private GamesViewModel gamesViewModel;
    private UserResponse userResponse;
    private List<GameCollection> games;
    private ListView lvGames;
    private GameAdapter gameAdapter;
    private  boolean withBtn = true;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_game, container, false);
        lvGames = (ListView)root.findViewById(R.id.lv_uncubscrzble_game) ;
        Bundle bundle = getArguments();
        userResponse = (UserResponse)bundle.getSerializable(UserResponse.class.getSimpleName());
        Call<List<GameCollection>> gamesCall = NetworkService.users().unsubscrableGameList(userResponse.getId());
        gamesCall.enqueue(new Callback<List<GameCollection>>() {
            @Override
            public void onResponse(Call<List<GameCollection>> call, Response<List<GameCollection>> response) {
                games = response.body();
                if (games!=null){
                    gameAdapter = new GameAdapter(getActivity(),(ArrayList<GameCollection>)games,withBtn,userResponse.getId());
                    lvGames.setAdapter(gameAdapter);
                    gameAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<GameCollection>> call, Throwable t) {
                Toast.makeText(getActivity(),t.getMessage().toString(),Toast.LENGTH_LONG).show();
            }
        });

        return root;
    }
}
