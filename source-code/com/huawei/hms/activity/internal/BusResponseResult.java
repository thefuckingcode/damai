package com.huawei.hms.activity.internal;

import android.content.Intent;

/* compiled from: Taobao */
public class BusResponseResult {
    private int code;
    private Intent intent;

    public int getCode() {
        return this.code;
    }

    public Intent getIntent() {
        return this.intent;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setIntent(Intent intent2) {
        this.intent = intent2;
    }
}
