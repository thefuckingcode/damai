package com.taobao.zcache.network;

import androidx.annotation.Keep;
import java.util.HashMap;

@Keep
/* compiled from: Taobao */
public class DownloadRequest {
    public boolean fetchResponseHeader = false;
    public HashMap<String, String> header = null;
    public String tempFilePath = null;
    public int timeout = 0;
    public String traceId = null;
    public String url = null;
}
