package com.teamdut.werewolfandroid1.fragments;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.teamdut.werewolfandroid1.R;
import com.teamdut.werewolfandroid1.adapters.ListPlayerAdapter;
import com.teamdut.werewolfandroid1.dialogs.AddPlayerDialog;
import com.teamdut.werewolfandroid1.models.Player;
import com.teamdut.werewolfandroid1.utils.Constant;
import com.teamdut.werewolfandroid1.utils.GridSpacingItemDecoration;

import java.util.ArrayList;

public class SelectPlayerFragment extends BaseFragment {
    private RecyclerView listPlayerView;
    private ListPlayerAdapter adapter;
    private ArrayList<Player> listPlayer;

    public static SelectPlayerFragment newInstance() {

        Bundle args = new Bundle();

        SelectPlayerFragment fragment = new SelectPlayerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_select_player;
    }

    @Override
    protected void initVariables(Bundle savedInstanceState, View rootView) {
        listPlayerView = (RecyclerView) rootView.findViewById(R.id.list_player);
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        listPlayer = new ArrayList<>();
        listPlayer.add(new Player(0, "New"));

        adapter = new ListPlayerAdapter(getActivity(), listPlayer, new ListPlayerAdapter.PositionClickListener() {
            @Override
            public void itemClicked(int position) {
                if (position == 0) {
                    AddPlayerDialog dialog = new AddPlayerDialog(getActivity(), new AddPlayerDialog.OnButtonClickListener() {
                        @Override
                        public void onOkClicked(String name) {
                            listPlayer.add(new Player(listPlayer.size(), name, true));
                            adapter.notifyDataSetChanged();
                        }
                    });
                    dialog.show();
                } else {
                    if (listPlayer.get(position).isSelected()) {
                        listPlayer.get(position).setSelected(false);
                    } else {
                        listPlayer.get(position).setSelected(true);
                    }
                }
            }
        });
        adapter.setHasStableIds(true);

        listPlayerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        listPlayerView.addItemDecoration(new GridSpacingItemDecoration(3, Constant.convertDpIntoPixels(30, getActivity()), true));
        listPlayerView.setAdapter(adapter);
    }
}
