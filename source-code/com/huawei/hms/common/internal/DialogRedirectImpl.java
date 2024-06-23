package com.huawei.hms.common.internal;

import android.app.Activity;
import android.content.Intent;

/* compiled from: Taobao */
public class DialogRedirectImpl extends DialogRedirect {
    private final Activity activity;
    private final Intent intent;
    private final int requestCode;

    DialogRedirectImpl(Intent intent2, Activity activity2, int i) {
        this.intent = intent2;
        this.activity = activity2;
        this.requestCode = i;
    }

    @Override // com.huawei.hms.common.internal.DialogRedirect
    public final void redirect() {
        Intent intent2 = this.intent;
        if (intent2 != null) {
            this.activity.startActivityForResult(intent2, this.requestCode);
        }
    }
}
