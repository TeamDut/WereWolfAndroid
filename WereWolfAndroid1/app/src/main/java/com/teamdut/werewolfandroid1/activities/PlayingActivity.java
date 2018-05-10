package com.teamdut.werewolfandroid1.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.teamdut.werewolfandroid1.R;
import com.teamdut.werewolfandroid1.adapters.ListCardAdapter;
import com.teamdut.werewolfandroid1.adapters.ListPlayingPlayerAdapter;
import com.teamdut.werewolfandroid1.models.Player;
import com.teamdut.werewolfandroid1.models.Role;
import com.teamdut.werewolfandroid1.utils.Constant;
import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.InfiniteScrollAdapter;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;

import java.util.ArrayList;
import java.util.Set;

public class PlayingActivity extends BaseActivity implements DiscreteScrollView.OnItemChangedListener<RecyclerView.ViewHolder> {
    private DiscreteScrollView scrollView;
    private ListCardAdapter adapter;
    private ArrayList<Role> listRole;
    private InfiniteScrollAdapter infiniteAdapter;

    private RecyclerView listPlayingPlayerView;
    private ListPlayingPlayerAdapter listPlayerAdaper;
    private ArrayList<Player> listPlayer;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_playing;
    }

    @Override
    protected void initVariables(Bundle savedInstanceState) {
        scrollView = (DiscreteScrollView) findViewById(R.id.list_card);
        listPlayingPlayerView = (RecyclerView) findViewById(R.id.list_playing_player);
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        //Setup list card
        listRole = new ArrayList<>();

        adapter = new ListCardAdapter(this, listRole, new ListCardAdapter.PositionClickListener() {
            @Override
            public void itemClicked(int position) {

            }
        });
        adapter.setHasStableIds(true);

        infiniteAdapter = InfiniteScrollAdapter.wrap(adapter);
        scrollView.setAdapter(infiniteAdapter);
        scrollView.setOffscreenItems(3);
        scrollView.addOnItemChangedListener(this);
        scrollView.setItemTransformer(new ScaleTransformer.Builder()
                .setMinScale(0.8f)
                .build());

        //Setup list player
        listPlayer = new ArrayList<>();
        listPlayer = Constant.getPlayerArrayPref(this, Constant.PREF_PLAYER);

        listPlayerAdaper = new ListPlayingPlayerAdapter(this, listPlayer, new ListPlayingPlayerAdapter.PositionClickListener() {
            @Override
            public void itemClicked(int position) {

            }
        });
        listPlayerAdaper.setHasStableIds(true);

        listPlayingPlayerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        listPlayingPlayerView.setAdapter(listPlayerAdaper);
    }

    @Override
    public void onCurrentItemChanged(@Nullable RecyclerView.ViewHolder viewHolder, int adapterPosition) {

    }
}
