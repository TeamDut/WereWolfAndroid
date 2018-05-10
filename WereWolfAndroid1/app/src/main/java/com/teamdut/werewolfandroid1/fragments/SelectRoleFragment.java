package com.teamdut.werewolfandroid1.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.teamdut.werewolfandroid1.R;
import com.teamdut.werewolfandroid1.activities.PlayingActivity;
import com.teamdut.werewolfandroid1.adapters.ListRoleAdapter;
import com.teamdut.werewolfandroid1.models.Role;
import com.teamdut.werewolfandroid1.utils.Constant;
import com.teamdut.werewolfandroid1.utils.GridSpacingItemDecoration;

import java.util.ArrayList;

public class SelectRoleFragment extends BaseFragment implements View.OnClickListener {
    private RecyclerView listRoleView;
    private ListRoleAdapter adapter;
    private ArrayList<Role> listRole;
    private RelativeLayout btnBack;
    private RelativeLayout btnStart;

    public static SelectRoleFragment newInstance() {

        Bundle args = new Bundle();

        SelectRoleFragment fragment = new SelectRoleFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_select_role;
    }

    @Override
    protected void initVariables(Bundle savedInstanceState, View rootView) {
        listRoleView = (RecyclerView) rootView.findViewById(R.id.list_role);
        btnBack = (RelativeLayout) rootView.findViewById(R.id.btn_back);
        btnStart = (RelativeLayout) rootView.findViewById(R.id.btn_start);
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        listRole = new ArrayList<>();
        listRole.add(new Role(1, "Werewolf", -6, R.drawable.werewolf));
        listRole.add(new Role(2, "Villager", 1, R.drawable.villager));
        listRole.add(new Role(3, "Seer", 7, R.drawable.seer));
        listRole.add(new Role(4, "Body Guard", 3, R.drawable.bodyguard));

        adapter = new ListRoleAdapter(getActivity(), listRole, new ListRoleAdapter.PositionClickListener() {
            @Override
            public void itemClicked(int position) {
                listRole.get(position).addQuantity(1);
            }

            @Override
            public void subClicked(int position) {
                if (listRole.get(position).getQuantity() > 0) {
                    listRole.get(position).addQuantity(-1);
                }
            }

            @Override
            public void plusClicked(int position) {
                listRole.get(position).addQuantity(1);
            }
        });
        adapter.setHasStableIds(true);

        listRoleView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        listRoleView.addItemDecoration(new GridSpacingItemDecoration(2, Constant.convertDpIntoPixels(20, getActivity()), false));
        listRoleView.setAdapter(adapter);

        btnBack.setOnClickListener(this);
        btnStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back:
                break;
            case R.id.btn_start:
                Intent i = new Intent(Constant.BC_START);
                getActivity().sendBroadcast(i);

                startActivity(PlayingActivity.class);
                break;
        }
    }
}
