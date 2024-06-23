package com.taobao.aranger.core.ipc.channel;

import com.taobao.aranger.exception.IPCException;
import java.util.List;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public interface IChannel {
    void internalRecycle(List<String> list) throws IPCException;
}
