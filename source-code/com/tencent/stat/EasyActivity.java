package com.tencent.stat;

import android.app.Activity;

/* compiled from: Taobao */
public class EasyActivity extends Activity {
    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        StatService.onPause(this);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        StatService.onResume(this);
    }
}
