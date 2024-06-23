package com.youku.live.dago.widgetlib.interactive.resource.prefetch;

import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.downloader.request.DownloadListener;
import com.youku.live.dago.widgetlib.interactive.resource.prefetch.ResourceEntity;
import java.io.File;
import java.util.ArrayList;
import tb.io1;
import tb.sb0;
import tb.u21;
import tb.ub0;

/* compiled from: Taobao */
public class ResourcesDownloader {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "ResourcesDownloader";

    private io1 getParams(String str, boolean z) {
        IpChange ipChange = $ipChange;
        int i = 2;
        int i2 = 1;
        if (AndroidInstantRuntime.support(ipChange, "625514321")) {
            return (io1) ipChange.ipc$dispatch("625514321", new Object[]{this, str, Boolean.valueOf(z)});
        }
        io1 io1 = new io1();
        if (z) {
            i2 = 7;
        }
        io1.c = i2;
        io1.b = 10;
        io1.d = 0;
        io1.f = getStorePath() + File.separatorChar + str;
        if (z) {
            i = 5;
        }
        io1.l = i;
        return io1;
    }

    private String getStorePath() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-659241626")) {
            return ResourcesCacheManager.getStorePath();
        }
        return (String) ipChange.ipc$dispatch("-659241626", new Object[]{this});
    }

    public void batchDownload(Config config, DownloadListener downloadListener, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1564617238")) {
            ipChange.ipc$dispatch("-1564617238", new Object[]{this, config, downloadListener, Boolean.valueOf(z)});
            return;
        }
        Log.d(TAG, "batch_download for " + config.getNamespace());
        sb0 sb0 = new sb0();
        sb0.b = getParams(config.getNamespace(), z);
        if (config.getConfigItems() != null) {
            ArrayList arrayList = new ArrayList();
            for (ResourceEntity.Resource resource : config.getConfigItems()) {
                u21 u21 = new u21();
                u21.a = resource.uri.toString();
                u21.d = resource.uri.getLastPathSegment();
                arrayList.add(u21);
            }
            sb0.a = arrayList;
        }
        ub0.c().b(sb0, downloadListener);
    }

    public void download(String str, String str2, DownloadListener downloadListener, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2025350482")) {
            ipChange.ipc$dispatch("2025350482", new Object[]{this, str, str2, downloadListener, Boolean.valueOf(z)});
            return;
        }
        Log.d(TAG, "download for " + str + ", key:" + str2);
        ResourceEntity.Resource resourceConfig = PrefetchManager.getResourceConfig(str, str2);
        if (resourceConfig != null) {
            sb0 sb0 = new sb0();
            sb0.a = new ArrayList();
            u21 u21 = new u21();
            u21.a = resourceConfig.uri.toString();
            u21.d = resourceConfig.uri.getLastPathSegment();
            sb0.a.add(u21);
            sb0.b = getParams(str, z);
            ub0.c().b(sb0, downloadListener);
        }
    }
}
