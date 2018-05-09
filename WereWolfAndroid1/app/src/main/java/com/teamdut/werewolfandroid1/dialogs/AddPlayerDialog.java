package com.teamdut.werewolfandroid1.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.teamdut.werewolfandroid1.R;

public class AddPlayerDialog extends Dialog implements View.OnClickListener {
    private Context context;
    private OnButtonClickListener listener;

    private EditText editNewPlayer;
    private RelativeLayout okButton;

    public AddPlayerDialog(@NonNull Context context, OnButtonClickListener listener) {
        super(context);
        this.context = context;
        this.listener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.dialog_add_player);

        editNewPlayer = (EditText) findViewById(R.id.edit_new_player);
        okButton = (RelativeLayout) findViewById(R.id.button_ok);

        okButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (editNewPlayer.getText().toString().length() > 0) {
            listener.onOkClicked(editNewPlayer.getText().toString());
            dismiss();
        } else {
            Toast.makeText(context, "Please enter player's name", Toast.LENGTH_SHORT).show();
        }
    }

    public interface OnButtonClickListener {
        void onOkClicked(String name);
    }
}
