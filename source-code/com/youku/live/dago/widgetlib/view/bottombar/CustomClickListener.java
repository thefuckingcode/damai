package com.youku.live.dago.widgetlib.view.bottombar;

import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public abstract class CustomClickListener implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private long mLastClickTime;
    private long timeInterval = 1000;

    public CustomClickListener() {
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1190200055")) {
            ipChange.ipc$dispatch("-1190200055", new Object[]{this, view});
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mLastClickTime > this.timeInterval) {
            onSingleClick();
            this.mLastClickTime = currentTimeMillis;
            return;
        }
        onFastClick();
    }

    /* access modifiers changed from: protected */
    public abstract void onFastClick();

    /* access modifiers changed from: protected */
    public abstract void onSingleClick();

    public CustomClickListener(long j) {
        this.timeInterval = j;
    }
}
