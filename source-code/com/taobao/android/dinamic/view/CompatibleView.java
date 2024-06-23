package com.taobao.android.dinamic.view;

import android.annotation.SuppressLint;
import android.content.Context;
import com.taobao.android.dinamic.b;

@SuppressLint({"ViewConstructor"})
/* compiled from: Taobao */
public class CompatibleView extends DFrameLayout {
    public CompatibleView(Context context, String str) {
        super(context);
        if (b.e()) {
            setContentDescription(str);
        }
    }
}
