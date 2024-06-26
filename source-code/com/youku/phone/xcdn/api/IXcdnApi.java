package com.youku.phone.xcdn.api;

import androidx.annotation.Keep;
import java.util.HashMap;
import java.util.Map;

@Keep
/* compiled from: Taobao */
public interface IXcdnApi {
    boolean cancelDownload(long j);

    void setGlobalConfigs(Map<String, String> map);

    long startDownload(String str, String str2, HashMap<String, String> hashMap, IXcdnCallback iXcdnCallback);
}
