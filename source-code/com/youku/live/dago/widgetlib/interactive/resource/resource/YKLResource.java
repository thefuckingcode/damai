package com.youku.live.dago.widgetlib.interactive.resource.resource;

import android.net.Uri;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.interactive.resource.prefetch.ResourceEntity;

/* compiled from: Taobao */
public class YKLResource extends ResourceEntity.Resource {
    private static transient /* synthetic */ IpChange $ipChange;
    public long gmtModified = 0;

    public YKLResource(String str, String str2, Uri uri) {
        super(str, str2, uri);
    }

    public boolean equals(Object obj) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "20344720")) {
            return this.key.equals(((YKLResource) obj).key);
        }
        return ((Boolean) ipChange.ipc$dispatch("20344720", new Object[]{this, obj})).booleanValue();
    }

    public YKLResource(String str, String str2, Uri uri, long j) {
        super(str, str2, uri, j);
    }
}
