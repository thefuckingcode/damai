package com.taobao.mass;

import androidx.annotation.Keep;
import com.taobao.aranger.annotation.method.AutoRecover;
import com.taobao.aranger.annotation.type.ServiceName;
import com.taobao.aranger.exception.IPCException;
import java.util.List;

@Keep
@ServiceName("com.taobao.mass.MassService")
/* compiled from: Taobao */
public interface IMassService {
    @Keep
    @AutoRecover
    List<String> getTopicsByService(String str) throws IPCException;

    @Keep
    @AutoRecover
    void registerTopic(String str, String str2) throws IPCException;

    @Keep
    @AutoRecover
    void unregisterTopic(String str, String str2) throws IPCException;
}
