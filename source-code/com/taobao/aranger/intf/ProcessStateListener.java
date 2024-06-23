package com.taobao.aranger.intf;

import androidx.annotation.Keep;

@Keep
/* compiled from: Taobao */
public interface ProcessStateListener {
    void onProcessStart(String str);

    void onProcessStop(String str);
}
