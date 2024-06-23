package com.youku.resource.utils;

import android.view.View;
import com.youku.resource.R;

/* compiled from: Taobao */
public final class YKCornerShadowUtils {
    public static void addCornerShadow(View view) {
        if (view != null) {
            view.setBackgroundResource(R.drawable.shadow);
        }
    }
}
