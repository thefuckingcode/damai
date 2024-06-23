package com.taobao.accs.base;

import androidx.annotation.Keep;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.aranger.annotation.type.Callback;
import com.taobao.aranger.exception.IPCException;

@Callback
@Keep
/* compiled from: Taobao */
public interface AccsConnectStateListener {
    @Keep
    void onConnected(TaoBaseService.ConnectInfo connectInfo) throws IPCException;

    @Keep
    void onDisconnected(TaoBaseService.ConnectInfo connectInfo) throws IPCException;
}
