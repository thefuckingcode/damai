package com.taobao.accs.asp;

import androidx.annotation.Keep;
import com.taobao.aranger.annotation.method.AutoRecover;
import com.taobao.aranger.annotation.type.ServiceName;
import com.taobao.aranger.exception.IPCException;

@Keep
@ServiceName("com.taobao.accs.asp.PrefsIPCChannel")
/* compiled from: Taobao */
public interface IPrefsChannel {
    @Keep
    @AutoRecover
    void commitToDiskRemote(ModifiedRecord modifiedRecord) throws IPCException;

    @Keep
    void registerDataListenerRemote(String str, OnDataUpdateListener onDataUpdateListener) throws IPCException;
}
