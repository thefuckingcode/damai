package com.huawei.hms.api;

import android.content.Intent;

/* compiled from: Taobao */
public class UserRecoverableException extends Exception {
    private final Intent a;

    public UserRecoverableException(String str, Intent intent) {
        super(str);
        this.a = intent;
    }

    public Intent getIntent() {
        return new Intent(this.a);
    }
}
