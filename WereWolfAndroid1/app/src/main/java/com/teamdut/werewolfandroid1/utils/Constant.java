package com.teamdut.werewolfandroid1.utils;

import android.content.Context;
import android.util.TypedValue;

public class Constant {
    public static int convertDpIntoPixels(int sizeInDp, Context context) {
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, sizeInDp, context.getResources().getDisplayMetrics());
        return px;
    }
}
