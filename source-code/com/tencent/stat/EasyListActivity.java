package com.tencent.stat;

import android.app.ListActivity;

/* compiled from: Taobao */
public class EasyListActivity extends ListActivity {
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
