package com.taobao.android.dinamicx.view;

import android.content.Context;
import android.widget.TextView;

/* compiled from: Taobao */
public class DXMeasuredTextView extends TextView {
    private final long mInitThreadId = Thread.currentThread().getId();

    public DXMeasuredTextView(Context context) {
        super(context);
    }

    public long getInitThreadId() {
        return this.mInitThreadId;
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }
}
