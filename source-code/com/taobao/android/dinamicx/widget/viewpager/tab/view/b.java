package com.taobao.android.dinamicx.widget.viewpager.tab.view;

import android.content.Context;
import android.content.res.TypedArray;
import androidx.appcompat.R;

/* compiled from: Taobao */
public class b {
    private static final int[] a = {R.attr.colorPrimary};

    static void a(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(a);
        boolean z = !obtainStyledAttributes.hasValue(0);
        obtainStyledAttributes.recycle();
        if (z) {
            throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
        }
    }
}
