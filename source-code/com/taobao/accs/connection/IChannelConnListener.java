package com.taobao.accs.connection;

import androidx.annotation.Keep;
import com.taobao.aranger.annotation.type.Callback;
import com.taobao.aranger.exception.IPCException;

@Callback
@Keep
/* compiled from: Taobao */
public interface IChannelConnListener {
    @Keep
    void onStart() throws IPCException;
}
