package com.youku.arch.solid.model;

import androidx.annotation.Keep;
import java.util.List;

@Keep
/* compiled from: Taobao */
public class SoGroup {
    public CompressInfo compressInfo;
    public boolean isAutoDownload;
    public String name;
    public int priority;
    public List<SoInfo> soItemList;
}
