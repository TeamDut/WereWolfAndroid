package com.teamdut.werewolfandroid1.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.teamdut.werewolfandroid1.R;
import com.teamdut.werewolfandroid1.adapters.MyPagerAdapter;
import com.teamdut.werewolfandroid1.fragments.SelectPlayerFragment;
import com.teamdut.werewolfandroid1.fragments.SelectRoleFragment;

import java.util.ArrayList;

public class PrepareActivity extends BaseActivity {
    private ViewPager pager;
    private MyPagerAdapter pagerAdapter;
    private SelectPlayerFragment selectPlayerFragment;
    private SelectRoleFragment selectRoleFragment;
    private ArrayList<Fragment> listFragment;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_prepare;
    }

    @Override
    protected void initVariables(Bundle savedInstanceState) {
        pager = (ViewPager) findViewById(R.id.pager);
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        selectPlayerFragment = SelectPlayerFragment.newInstance();
        selectRoleFragment = SelectRoleFragment.newInstance();

        listFragment = new ArrayList<>();
        listFragment.add(selectPlayerFragment);
        listFragment.add(selectRoleFragment);

        pagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), listFragment);
        pager.setAdapter(pagerAdapter);
    }
}
