package com.tencent.open.c;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import java.util.List;

/* compiled from: Taobao */
public class c extends FrameLayout {
    public c(Context context) {
        super(context);
    }

    private void a(WindowInsets windowInsets) {
        DisplayCutout displayCutout;
        List<Rect> boundingRects;
        if (Build.VERSION.SDK_INT >= 28 && windowInsets != null && (displayCutout = windowInsets.getDisplayCutout()) != null && (boundingRects = displayCutout.getBoundingRects()) != null && !boundingRects.isEmpty()) {
            setPadding(Math.max(displayCutout.getSafeInsetLeft(), 0), Math.max(displayCutout.getSafeInsetTop(), 0), Math.max(displayCutout.getSafeInsetRight(), 0), Math.max(displayCutout.getSafeInsetBottom(), 0));
        }
    }

    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        a(windowInsets);
        return super.onApplyWindowInsets(windowInsets);
    }
}
