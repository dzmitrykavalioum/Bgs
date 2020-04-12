package com.dzmitrykavalioum.bgs.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dzmitrykavalioum.bgs.R;
import com.dzmitrykavalioum.bgs.model.GameCollection;

import java.util.ArrayList;

public class GameAdapter extends BaseAdapter {
    Context ctx;
    LayoutInflater layoutInflater;
    ArrayList<GameCollection> games;

    public GameAdapter(Context context, ArrayList<GameCollection> listgames) {
        ctx = context;
        games = listgames;
        layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

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

        GameCollection game = getGamw(i);
        ((TextView)view.findViewById(R.id.tv_title_game)).setText(game.getTitle());
        ((TextView)view.findViewById(R.id.tv_rating_game)).setText(game.getRating().toString());

        return view;

    }

    GameCollection getGamw(int i) {
        return (GameCollection) getItem(i);
    }

}
