package com.dzmitrykavalioum.bgs.adapters;

import android.content.Context;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dzmitrykavalioum.bgs.R;
import com.dzmitrykavalioum.bgs.model.Game;
import com.dzmitrykavalioum.bgs.model.User;
import com.dzmitrykavalioum.bgs.service.NetworkService;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GameAdapter extends BaseAdapter {
    private Context ctx;
    private LayoutInflater layoutInflater;
    private ArrayList<Game> games;
    private Button btn_add;
    private ImageView iv_game;
    private boolean withBtn;
    private int userId;
    private String urlImage;

    public GameAdapter(Context context, ArrayList<Game> listgames, boolean withBtn, int userId) {
        ctx = context;
        games = listgames;
        layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.withBtn = withBtn;
        this.userId = userId;
    }

    // TODO  change text on Button
    @Override
    public int getCount() {
        return games.size();
    }

    @Override
    public Object getItem(int i) {
        return games.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        View view = convertView;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.item_game, viewGroup, false);
        }

        Game game = getGame(i);
        ((TextView) view.findViewById(R.id.tv_title_game)).setText(game.getTitle());
        ((TextView) view.findViewById(R.id.tv_rating_game)).setText(game.getRatingValue().toString());
        urlImage = game.getLogo();
        iv_game = view.findViewById(R.id.iv_game);
        Log.i("gameadapter", game.getTitle()+ " "+ urlImage);
        if (urlImage!=""){
            Picasso.get().load(urlImage).into(iv_game);

        }
        else{
            iv_game.setImageResource(R.drawable.ic_menu_camera);
        }

        btn_add = (Button) view.findViewById(R.id.btn_add_game);
        if (withBtn) {
            btn_add.setVisibility(View.VISIBLE);
            btn_add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    addGame(userId, game.getId(), view);
                }
            });
        }


        return view;

    }

    public void addGame(int userId, int gameId, View view) {
        Call<User> addGameCall = NetworkService.users().addGame(userId, gameId);
        addGameCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                btn_add.setText(R.string.done);

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(ctx, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    Game getGame(int i) {
        return (Game) getItem(i);
    }

}
