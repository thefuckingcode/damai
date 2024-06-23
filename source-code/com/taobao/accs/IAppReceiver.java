package com.taobao.accs;

import androidx.annotation.Keep;
import com.taobao.aranger.annotation.type.Callback;
import com.taobao.aranger.exception.IPCException;
import java.util.Map;

@Callback
@Keep
/* compiled from: Taobao */
public interface IAppReceiver {
    @Keep
    Map<String, String> getAllServices() throws IPCException;

    @Keep
    String getService(String str) throws IPCException;

    @Keep
    void onBindApp(int i) throws IPCException;

    @Keep
    void onBindUser(String str, int i) throws IPCException;

    @Keep
    void onData(String str, String str2, byte[] bArr) throws IPCException;

    @Keep
    void onSendData(String str, int i) throws IPCException;

    @Keep
    void onUnbindApp(int i) throws IPCException;

    @Keep
    void onUnbindUser(int i) throws IPCException;
}
