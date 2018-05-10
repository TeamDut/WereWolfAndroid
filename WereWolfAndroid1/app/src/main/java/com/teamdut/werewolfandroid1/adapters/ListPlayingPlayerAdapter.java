package com.teamdut.werewolfandroid1.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.teamdut.werewolfandroid1.R;
import com.teamdut.werewolfandroid1.models.Player;

import java.util.ArrayList;

public class ListPlayingPlayerAdapter extends RecyclerView.Adapter<ListPlayingPlayerAdapter.RecyclerViewHolder> {
    private Context context;
    private ArrayList<Player> listPlayer;

    private PositionClickListener listener;
    private int selectedPos = 0;

    public ListPlayingPlayerAdapter(Context context, ArrayList<Player> listPlayer, PositionClickListener listener) {
        this.context = context;
        this.listPlayer = listPlayer;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.item_player, parent, false);
        return new RecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.playerName.setText(listPlayer.get(position).getName());
        holder.playerImg.setImageResource(R.drawable.ic_person);
        if (listPlayer.get(position).isSelected()) {
            holder.selectedImg.setVisibility(View.VISIBLE);
        } else {
            holder.selectedImg.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return listPlayer.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public interface PositionClickListener {
        void itemClicked(int position);
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView playerName;
        public ImageView playerImg;
        public ImageView selectedImg;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            playerName = (TextView) itemView.findViewById(R.id.player_name);
            playerImg = (ImageView) itemView.findViewById(R.id.player_img);
            selectedImg = (ImageView) itemView.findViewById(R.id.selected_img);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.itemClicked(getLayoutPosition());
            notifyItemChanged(selectedPos);
            selectedPos = getLayoutPosition();
            notifyItemChanged(selectedPos);
        }
    }
}
