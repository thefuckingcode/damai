package anetwork.channel.interceptor;

import anetwork.channel.aidl.DefaultFinishEvent;
import java.util.List;
import java.util.Map;
import tb.pd;

/* compiled from: Taobao */
public interface Callback {
    void onDataReceiveSize(int i, int i2, pd pdVar);

    void onFinish(DefaultFinishEvent defaultFinishEvent);

    void onResponseCode(int i, Map<String, List<String>> map);
}
