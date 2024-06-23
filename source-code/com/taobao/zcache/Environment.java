package com.taobao.zcache;

import androidx.annotation.Keep;

@Keep
/* compiled from: Taobao */
public enum Environment {
    Debug(0),
    Daily(1),
    Release(2);
    
    public final int value;

    private Environment(int i) {
        this.value = i;
    }
}
