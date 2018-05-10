package com.teamdut.werewolfandroid1.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.TypedValue;

import com.google.gson.Gson;
import com.teamdut.werewolfandroid1.models.Player;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class Constant {
    public static String BC_START = "bc_start";
    public static String PREF_PLAYER = "pref_player";

    public static int convertDpIntoPixels(int sizeInDp, Context context) {
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, sizeInDp, context.getResources().getDisplayMetrics());
        return px;
    }

    public static void setPlayerArrayPref(Context context, String key, ArrayList<Player> values) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        JSONArray a = new JSONArray();
        for (int i = 0; i < values.size(); i++) {
            a.put(gson.toJson(values.get(i)));
        }
        if (!values.isEmpty()) {
            editor.putString(key, a.toString());
        } else {
            editor.putString(key, null);
        }
        editor.commit();
    }

    public static ArrayList<Player> getPlayerArrayPref(Context context, String key) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        String json = prefs.getString(key, null);
        Gson gson = new Gson();
        ArrayList<Player> players = new ArrayList<>();
        if (json != null) {
            try {
                JSONArray a = new JSONArray(json);
                for (int i = 0; i < a.length(); i++) {
                    Player player = gson.fromJson(a.optString(i), Player.class);
                    players.add(player);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return players;
    }
}
