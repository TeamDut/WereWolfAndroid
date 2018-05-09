package com.teamdut.werewolfandroid1.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.teamdut.werewolfandroid1.R;
import com.teamdut.werewolfandroid1.adapters.ListCardAdapter;
import com.teamdut.werewolfandroid1.models.Role;
import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.InfiniteScrollAdapter;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;

import java.util.ArrayList;

public class PlayingActivity extends BaseActivity implements DiscreteScrollView.OnItemChangedListener<RecyclerView.ViewHolder> {
    private DiscreteScrollView scrollView;
    private ListCardAdapter adapter;
    private ArrayList<Role> listRole;
    private InfiniteScrollAdapter infiniteAdapter;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_playing;
    }

    @Override
    protected void initVariables(Bundle savedInstanceState) {
        scrollView = (DiscreteScrollView) findViewById(R.id.list_card);
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
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
    }

    @Override
    public void onCurrentItemChanged(@Nullable RecyclerView.ViewHolder viewHolder, int adapterPosition) {

    }
}
