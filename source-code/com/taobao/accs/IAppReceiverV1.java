package com.taobao.accs;

import androidx.annotation.Keep;
import com.taobao.aranger.annotation.type.Callback;
import com.taobao.aranger.exception.IPCException;

@Callback
/* compiled from: Taobao */
public interface IAppReceiverV1 extends IAppReceiver {
    @Keep
    void onBindApp(int i, String str) throws IPCException;
}
