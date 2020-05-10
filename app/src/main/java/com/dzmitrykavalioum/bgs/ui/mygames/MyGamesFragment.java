package com.dzmitrykavalioum.bgs.ui.mygames;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.dzmitrykavalioum.bgs.GameItemActivity;
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

public class MyGamesFragment extends Fragment {

    //private MyGamesViewModel myGamesViewModel;

    private UserResponse userResponse;
    GameAdapter gameAdapter;
    ListView listView;
    List<GameCollection> list;
    private boolean withBtn = false;

// TODO  game collection update
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_my_games, container, false);
        listView = root.findViewById(R.id.lv_my_games_fragment);
        TextView textView = root.findViewById(R.id.tv_mygames_name);
//        textView.setText("Hello My games");
        Bundle bundle = getArguments();
        if (bundle != null) {
            userResponse = (UserResponse) bundle.getSerializable(UserResponse.class.getSimpleName());
//            textView.setText(userResponse.getLogin());

        }


        List<GameCollection> list = userResponse.getGameCollection();
        if (list != null) {
            gameAdapter = new GameAdapter(getActivity(), (ArrayList<GameCollection>) list, withBtn, userResponse.getId());
            listView.setAdapter(gameAdapter);
            gameAdapter.notifyDataSetChanged();
            listView.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    GameCollection gameItem = (GameCollection) gameAdapter.getItem(i);
                    Log.i("mygame", "OnitemClick");
                    Log.i("mygame", gameItem.getTitle());
                    Intent intent = new Intent(getContext(), GameItemActivity.class);
                    intent.putExtra(GameCollection.class.getSimpleName(), gameItem);
                    intent.putExtra(UserResponse.class.getSimpleName(), userResponse);
                    getActivity().startActivityForResult(intent, Activity.RESULT_OK);

                }
            });
        } else
            Toast.makeText(getActivity(), userResponse.getLogin() + " in system", Toast.LENGTH_SHORT).show();


        return root;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i("onActivity", "fragment");
        Toast.makeText(getActivity(), "OKEY", Toast.LENGTH_SHORT).show();
        if (resultCode == Activity.RESULT_OK) {
            Toast.makeText(getActivity(), "Done", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), resultCode, Toast.LENGTH_SHORT).show();
        }
    }
}
