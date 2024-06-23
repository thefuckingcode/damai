package com.taobao.zcache.network;

import com.taobao.zcache.Error;
import java.util.Map;

/* compiled from: Taobao */
public interface DownloadFinishedCallback {
    void onDownloadFinished(int i, Map<String, String> map, Error error, String str);
}
