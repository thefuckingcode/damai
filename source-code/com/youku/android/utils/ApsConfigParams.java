package com.youku.android.utils;

import androidx.annotation.Keep;

@Keep
/* compiled from: Taobao */
public class ApsConfigParams {
    public String mDefaultVal;
    public String mKey;
    public String mNs;

    ApsConfigParams(String str, String str2, String str3) {
        this.mNs = str;
        this.mKey = str2;
        this.mDefaultVal = str3;
    }
}
