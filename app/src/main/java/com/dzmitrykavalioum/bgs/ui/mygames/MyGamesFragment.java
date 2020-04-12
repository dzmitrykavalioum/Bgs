package com.dzmitrykavalioum.bgs.ui.mygames;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.dzmitrykavalioum.bgs.R;
import com.dzmitrykavalioum.bgs.adapters.GameAdapter;
import com.dzmitrykavalioum.bgs.model.GameCollection;
import com.dzmitrykavalioum.bgs.model.UserResponse;

import java.util.ArrayList;
import java.util.List;

public class MyGamesFragment extends Fragment {

    //private MyGamesViewModel myGamesViewModel;

    private UserResponse userResponse;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_my_games, container, false);
        ListView listView = root.findViewById(R.id.lv_my_games_fragment);
        TextView textView = root.findViewById(R.id.tv_mygames_name);
//        textView.setText("Hello My games");
        Bundle bundle = getArguments();
        if (bundle != null){
            userResponse = (UserResponse)bundle.getSerializable(UserResponse.class.getSimpleName());
//            textView.setText(userResponse.getLogin());

        }

        if (userResponse!=null){
            Log.i("mygames ","2list not null");
            List <GameCollection> list = userResponse.getGameCollection();
            GameAdapter gameAdapter = new GameAdapter(getActivity(), (ArrayList<GameCollection>) list);
            listView.setAdapter(gameAdapter);

//            String size = ""+list.size();
//            Log.i("mygames", size );
//            for (GameCollection  item:  list) {
//                Log.i("mygames ", item.getTitle());
//            };

        }
        else {
            Log.i("mygames ","2list is null!!!!!!!!!!!!!!!!!!");
        }
        //List <GameCollection> list = userResponse.getGameCollection();


        //String size = ""+list.size();
        //userResponse.getGameCollection().toString();
        //Log.i("size games = ", size);




//        final String[] catNames = new String[] {
//                "Рыжик", "Барсик", "Мурзик", "Мурка", "Васька",
//                "Томасина", "Кристина", "Пушок", "Дымка", "Кузя",
//                "Китти", "Масяня", "Симба"
//        };
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
//                android.R.layout.simple_list_item_1, catNames);
//
//        listView.setAdapter(adapter);


        return root;
    }
}
