package com.cb.android.badminton;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by GhanshamBansal on 15/06/17.
 */

public class BadmintonAdapter extends RecyclerView.Adapter<BadmintonAdapter.BadmintonViewHolder>{

    ArrayList<badminton> playerArrayList;
    Context context;



    public BadmintonAdapter(ArrayList<badminton> studentArrayList, Context context) {
        this.playerArrayList = studentArrayList;
        this.context = context;
    }

    @Override
    public BadmintonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.display
                ,parent,false);
        BadmintonViewHolder badmintonHolder = new BadmintonViewHolder(itemView);

        return badmintonHolder;
    }

    @Override
    public void onBindViewHolder(BadmintonViewHolder holder, int position) {
        badminton thisStudent = playerArrayList.get(position);
        holder.tvplayer.setText(thisStudent.getPlayer());
        holder.tvcountry.setText(thisStudent.getCountry());
        holder.tvrecord.setText(thisStudent.getRecord());
        holder.tvrank.setText(String.valueOf(thisStudent.getRank()));

    }

    @Override
    public int getItemCount() {
        return playerArrayList.size();
    }

    static class BadmintonViewHolder extends RecyclerView.ViewHolder{
        TextView tvplayer;
        TextView tvcountry;
        TextView tvrecord;
        TextView tvrank;
        public BadmintonViewHolder(View itemView) {
            super(itemView);
            tvplayer = (TextView) itemView.findViewById(R.id.tv_playerName);
            tvcountry = (TextView) itemView.findViewById(R.id.tv_countryName);
            tvrecord = (TextView) itemView.findViewById((R.id.tv_record));
            tvrank = (TextView) itemView.findViewById((R.id.tv_rank));

        }
    }
}