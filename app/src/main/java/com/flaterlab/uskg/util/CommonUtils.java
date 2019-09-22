package com.flaterlab.uskg.util;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;

import java.io.IOException;

public class CommonUtils {

    public static Drawable getIcon(Context context, String fileName) throws IOException {
        return Drawable.createFromStream(
                context.getAssets().open("icons/" + fileName), null);
    }

    public static int densityToPixels(DisplayMetrics metrics, int density) {
        return (int) (density * metrics.density + 0.5f);
    }

    public static int getDisplayHeight(Display display) {
        Point size = new Point();
        display.getSize(size);
        return size.y;
    }

    public static int getActionBarSize(Context context) {
        TypedValue tv = new TypedValue();
        if (context.getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
            return TypedValue.complexToDimensionPixelSize(
                    tv.data, context.getResources().getDisplayMetrics());
        }
        return 0;
    }
}
