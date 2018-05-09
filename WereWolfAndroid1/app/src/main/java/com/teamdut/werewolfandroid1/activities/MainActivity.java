package com.teamdut.werewolfandroid1.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.teamdut.werewolfandroid1.R;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private Button buttonNewGame;
    private Button buttonHistory;
    private Button buttonAbout;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    protected void initVariables(Bundle savedInstanceState) {
        buttonNewGame = (Button) findViewById(R.id.button_new_game);
        buttonHistory = (Button) findViewById(R.id.button_history);
        buttonAbout = (Button) findViewById(R.id.button_about);
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        buttonNewGame.setOnClickListener(this);
        buttonHistory.setOnClickListener(this);
        buttonAbout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_new_game:
                startActivity(PrepareActivity.class);
                break;
            case R.id.button_history:
                break;
            case R.id.button_about:
                break;
        }
    }
}
