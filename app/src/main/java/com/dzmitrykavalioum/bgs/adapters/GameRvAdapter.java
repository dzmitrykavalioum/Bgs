package com.dzmitrykavalioum.bgs.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dzmitrykavalioum.bgs.R;
import com.dzmitrykavalioum.bgs.model.Game;
import com.dzmitrykavalioum.bgs.model.User;
import com.dzmitrykavalioum.bgs.service.NetworkService;
import com.dzmitrykavalioum.bgs.ui.gameitem.GameItemActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GameRvAdapter extends RecyclerView.Adapter<GameRvAdapter.ViewHolder> {

    private List<Game> games;
    private int userId;
    private boolean withBtnAdd;
    private Context context;
    private User userResponse;

    public GameRvAdapter(List<Game> games, int userId, boolean withBtnAdd) {
        this.games = games;
        this.userId = userId;
        this.withBtnAdd = withBtnAdd;

    }

    public GameRvAdapter(List<Game> games, User user, boolean withBtnAdd) {
        this.games = games;
        this.userResponse = user;
        this.withBtnAdd = withBtnAdd;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_game, parent, false);
        context = parent.getContext();
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Game game = games.get(position);
        String urlImage = game.getLogo();
        if (urlImage != "") {

            Picasso.get().load(urlImage).into(holder.iv_game);
        } else {
            holder.iv_game.setImageResource(R.drawable.ic_menu_camera);
        }
        holder.tv_title.setText(game.getTitle());
        holder.tv_rating.setText(game.getRatingValue().toString());
        holder.addButtonListener.setGame(game);
        holder.btn_add.setVisibility(View.VISIBLE);
        if (!withBtnAdd) {
            holder.btn_add.setVisibility(View.INVISIBLE);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, GameItemActivity.class);
                    intent.putExtra(Game.class.getSimpleName(), game);
                    intent.putExtra(User.class.getSimpleName(), userResponse);
                    context.startActivity(intent);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return games.size();
    }

    private void add(Game game, int userId) {
        Call<User> addGameCall = NetworkService.users().addGame(userId, game.getId());
        addGameCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                int position = games.indexOf(game);
                games.remove(position);
                notifyItemRemoved(position);

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private Button btn_add;
        private ImageView iv_game;
        private TextView tv_title;
        private TextView tv_rating;
        private AddButtonListener addButtonListener;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title_game);
            tv_rating = itemView.findViewById(R.id.tv_rating_game);
            iv_game = itemView.findViewById(R.id.iv_game);
            btn_add = itemView.findViewById(R.id.btn_add_game);
            addButtonListener = new AddButtonListener();
            if (withBtnAdd)
                btn_add.setOnClickListener(addButtonListener);

        }

        class AddButtonListener implements View.OnClickListener {
            private Game game;

            @Override
            public void onClick(View view) {
                add(game, userId);
            }

            public void setGame(Game game) {
                this.game = game;
            }
        }
    }
}
