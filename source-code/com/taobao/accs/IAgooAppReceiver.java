package com.taobao.accs;

import androidx.annotation.Keep;
import com.taobao.aranger.annotation.type.Callback;
import com.taobao.aranger.exception.IPCException;

@Callback
/* compiled from: Taobao */
public interface IAgooAppReceiver extends IAppReceiverV1 {
    @Keep
    String getAppkey() throws IPCException;

    @Override // com.taobao.accs.IAppReceiverV1
    @Keep
    void onBindApp(int i, String str) throws IPCException;
}
