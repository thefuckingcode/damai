package com.youku.live.dago.widgetlib.interactive.resource.resource;

import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.downloader.request.DownloadListener;
import com.youku.live.dago.widgetlib.interactive.resource.prefetch.Config;
import com.youku.live.dago.widgetlib.interactive.resource.prefetch.ResourceEntity;
import com.youku.live.dago.widgetlib.interactive.resource.utils.FileUtils;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tb.io1;
import tb.sb0;
import tb.u21;
import tb.ub0;

/* compiled from: Taobao */
public class YKLResourcesDownloader {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "YKLResourcesDownloader";
    public ConcurrentHashMap<String, YKLDownloadBean> mDownloadingList = new ConcurrentHashMap<>();

    /* compiled from: Taobao */
    public class YklDownloadListener implements DownloadListener {
        private Map<String, YKLDownloadBean> downloadList;
        private DownloadListener listener;

        public YklDownloadListener(Map<String, YKLDownloadBean> map, DownloadListener downloadListener) {
            this.downloadList = map;
            this.listener = downloadListener;
        }

        @Override // com.taobao.downloader.request.DownloadListener
        public void onDownloadError(String str, int i, String str2) {
            Map<String, YKLDownloadBean> map = this.downloadList;
            if (map != null && map.containsKey(str)) {
                this.downloadList.remove(str);
            }
            DownloadListener downloadListener = this.listener;
            if (downloadListener != null) {
                downloadListener.onDownloadError(str, i, str2);
            }
        }

        @Override // com.taobao.downloader.request.DownloadListener
        public void onDownloadFinish(String str, String str2) {
            Map<String, YKLDownloadBean> map = this.downloadList;
            if (map != null && map.containsKey(str)) {
                this.downloadList.remove(str);
            }
            DownloadListener downloadListener = this.listener;
            if (downloadListener != null) {
                downloadListener.onDownloadFinish(str, str2);
            }
        }

        @Override // com.taobao.downloader.request.DownloadListener
        public void onDownloadProgress(int i) {
            DownloadListener downloadListener = this.listener;
            if (downloadListener != null) {
                downloadListener.onDownloadProgress(i);
            }
        }

        @Override // com.taobao.downloader.request.DownloadListener
        public void onDownloadStateChange(String str, boolean z) {
            DownloadListener downloadListener = this.listener;
            if (downloadListener != null) {
                downloadListener.onDownloadStateChange(str, z);
            }
        }

        @Override // com.taobao.downloader.request.DownloadListener
        public void onFinish(boolean z) {
            DownloadListener downloadListener = this.listener;
            if (downloadListener != null) {
                downloadListener.onFinish(z);
            }
        }

        @Override // com.taobao.downloader.request.DownloadListener
        public void onNetworkLimit(int i, io1 io1, DownloadListener.NetworkLimitCallback networkLimitCallback) {
            DownloadListener downloadListener = this.listener;
            if (downloadListener != null) {
                downloadListener.onNetworkLimit(i, io1, networkLimitCallback);
            }
        }
    }

    private void checkFileExist(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "162748300")) {
            ipChange.ipc$dispatch("162748300", new Object[]{this, str, str2});
            return;
        }
        FileUtils.deleteFolder(getStorePath() + File.separatorChar + str + File.separatorChar + str2);
    }

    private io1 getParams(String str, boolean z) {
        IpChange ipChange = $ipChange;
        int i = 2;
        int i2 = 1;
        if (AndroidInstantRuntime.support(ipChange, "-182232590")) {
            return (io1) ipChange.ipc$dispatch("-182232590", new Object[]{this, str, Boolean.valueOf(z)});
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
        if (!AndroidInstantRuntime.support(ipChange, "-181884315")) {
            return YKLResourcesCacheManager.getStorePath();
        }
        return (String) ipChange.ipc$dispatch("-181884315", new Object[]{this});
    }

    public void batchDownload(Config config, DownloadListener downloadListener, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-393286581")) {
            ipChange.ipc$dispatch("-393286581", new Object[]{this, config, downloadListener, Boolean.valueOf(z)});
            return;
        }
        Log.d(TAG, "batch_download for " + config.getNamespace());
        String namespace = config.getNamespace();
        sb0 sb0 = new sb0();
        sb0.b = getParams(namespace, z);
        ArrayList arrayList = (ArrayList) ((ArrayList) config.getConfigItems()).clone();
        if (arrayList != null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ResourceEntity.Resource resource = (ResourceEntity.Resource) it.next();
                u21 u21 = new u21();
                String uri = resource.uri.toString();
                u21.a = uri;
                if (!this.mDownloadingList.containsKey(uri)) {
                    String str = resource.key;
                    u21.d = str;
                    checkFileExist(namespace, str);
                    YKLDownloadBean yKLDownloadBean = new YKLDownloadBean();
                    String str2 = u21.a;
                    yKLDownloadBean.url = str2;
                    this.mDownloadingList.put(str2, yKLDownloadBean);
                    arrayList2.add(u21);
                }
            }
            sb0.a = arrayList2;
        }
        ub0.c().b(sb0, new YklDownloadListener(this.mDownloadingList, downloadListener));
    }

    public void download(String str, String str2, DownloadListener downloadListener, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1975833169")) {
            ipChange.ipc$dispatch("1975833169", new Object[]{this, str, str2, downloadListener, Boolean.valueOf(z)});
            return;
        }
        Log.d(TAG, "download for " + str + ", key:" + str2);
        ResourceEntity.Resource resourceConfig = YKLPrefetchManager.getInstance().getResourceConfig(str, str2);
        if (resourceConfig != null) {
            sb0 sb0 = new sb0();
            sb0.a = new ArrayList();
            u21 u21 = new u21();
            String uri = resourceConfig.uri.toString();
            u21.a = uri;
            if (!this.mDownloadingList.containsKey(uri)) {
                String str3 = resourceConfig.key;
                u21.d = str3;
                checkFileExist(str, str3);
                sb0.a.add(u21);
                YKLDownloadBean yKLDownloadBean = new YKLDownloadBean();
                String str4 = u21.a;
                yKLDownloadBean.url = str4;
                this.mDownloadingList.put(str4, yKLDownloadBean);
                sb0.b = getParams(str, z);
                ub0.c().b(sb0, new YklDownloadListener(this.mDownloadingList, downloadListener));
            }
        }
    }

    public void download(String str, List<YKLDownloadBean> list, final YKLDownloadListener yKLDownloadListener, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "78718673")) {
            ipChange.ipc$dispatch("78718673", new Object[]{this, str, list, yKLDownloadListener, Boolean.valueOf(z)});
            return;
        }
        sb0 sb0 = new sb0();
        if (list != null) {
            sb0.a = new ArrayList();
            for (YKLDownloadBean yKLDownloadBean : list) {
                u21 u21 = new u21();
                String str2 = yKLDownloadBean.url;
                u21.a = str2;
                if (!this.mDownloadingList.containsKey(str2)) {
                    String str3 = yKLDownloadBean.fileName;
                    u21.d = str3;
                    checkFileExist(str, str3);
                    sb0.a.add(u21);
                    this.mDownloadingList.put(u21.a, yKLDownloadBean);
                    sb0.b = getParams(str, z);
                }
            }
            Log.d("ykl-download", "start download ");
            ub0.c().b(sb0, new DownloadListener() {
                /* class com.youku.live.dago.widgetlib.interactive.resource.resource.YKLResourcesDownloader.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.taobao.downloader.request.DownloadListener
                public void onDownloadError(String str, int i, String str2) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "289469266")) {
                        ipChange.ipc$dispatch("289469266", new Object[]{this, str, Integer.valueOf(i), str2});
                        return;
                    }
                    ConcurrentHashMap<String, YKLDownloadBean> concurrentHashMap = YKLResourcesDownloader.this.mDownloadingList;
                    if (concurrentHashMap != null && concurrentHashMap.containsKey(str)) {
                        YKLResourcesDownloader.this.mDownloadingList.remove(str);
                    }
                    ((ILog) Dsl.getService(ILog.class)).d("ykl-download", "download error, url = " + str);
                    ((ILog) Dsl.getService(ILog.class)).i("ykl-download", "download error, MSG = " + str2);
                    YKLDownloadListener yKLDownloadListener = yKLDownloadListener;
                    if (yKLDownloadListener != null) {
                        yKLDownloadListener.onDownloadError(str, i, str2);
                    }
                }

                @Override // com.taobao.downloader.request.DownloadListener
                public void onDownloadFinish(String str, String str2) {
                    String str3;
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "246795698")) {
                        ipChange.ipc$dispatch("246795698", new Object[]{this, str, str2});
                        return;
                    }
                    YKLDownloadBean yKLDownloadBean = null;
                    ConcurrentHashMap<String, YKLDownloadBean> concurrentHashMap = YKLResourcesDownloader.this.mDownloadingList;
                    if (concurrentHashMap != null && concurrentHashMap.containsKey(str)) {
                        yKLDownloadBean = YKLResourcesDownloader.this.mDownloadingList.remove(str);
                    }
                    if (yKLDownloadBean != null) {
                        ((ILog) Dsl.getService(ILog.class)).d("liulei-download", "download finish, url = " + yKLDownloadBean.url);
                        if (yKLDownloadBean.isZip) {
                            if (!str2.endsWith(".zip")) {
                                str3 = str2 + ".zip";
                                new File(str2).renameTo(new File(str3));
                            }
                            new YKLAfterDownloadProcessor(str, yKLDownloadListener).process(yKLDownloadBean.isZip, str2);
                        } else {
                            String str4 = yKLDownloadBean.type;
                            if (ResourceConstants.FILE_TYPE_SVGA.equals(str4)) {
                                str3 = str2 + ".svga";
                            } else if ("webp".equals(str4)) {
                                str3 = str2 + ".webp";
                            } else if ("mp4gift".equals(str4)) {
                                str3 = str2 + ".mp4";
                            } else {
                                str3 = str2;
                            }
                            new File(str2).renameTo(new File(str3));
                        }
                        str2 = str3;
                        new YKLAfterDownloadProcessor(str, yKLDownloadListener).process(yKLDownloadBean.isZip, str2);
                    }
                    YKLDownloadListener yKLDownloadListener = yKLDownloadListener;
                    if (yKLDownloadListener != null) {
                        yKLDownloadListener.onDownloadFinish(str, str2);
                    }
                }

                @Override // com.taobao.downloader.request.DownloadListener
                public void onDownloadProgress(int i) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "2058471103")) {
                        ipChange.ipc$dispatch("2058471103", new Object[]{this, Integer.valueOf(i)});
                    }
                }

                @Override // com.taobao.downloader.request.DownloadListener
                public void onDownloadStateChange(String str, boolean z) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-350040270")) {
                        ipChange.ipc$dispatch("-350040270", new Object[]{this, str, Boolean.valueOf(z)});
                    }
                }

                @Override // com.taobao.downloader.request.DownloadListener
                public void onFinish(boolean z) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "693401678")) {
                        ipChange.ipc$dispatch("693401678", new Object[]{this, Boolean.valueOf(z)});
                    }
                }

                @Override // com.taobao.downloader.request.DownloadListener
                public void onNetworkLimit(int i, io1 io1, DownloadListener.NetworkLimitCallback networkLimitCallback) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-943653462")) {
                        ipChange.ipc$dispatch("-943653462", new Object[]{this, Integer.valueOf(i), io1, networkLimitCallback});
                    }
                }
            });
        }
    }

    public void batchDownload(String str, List<ResourceEntity.Resource> list, DownloadListener downloadListener, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1518297232")) {
            ipChange.ipc$dispatch("1518297232", new Object[]{this, str, list, downloadListener, Boolean.valueOf(z)});
            return;
        }
        Log.d(TAG, "batch_download for list");
        sb0 sb0 = new sb0();
        sb0.b = getParams(str, z);
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (ResourceEntity.Resource resource : list) {
                u21 u21 = new u21();
                String uri = resource.uri.toString();
                u21.a = uri;
                if (!this.mDownloadingList.containsKey(uri)) {
                    String str2 = resource.key;
                    u21.d = str2;
                    checkFileExist(str, str2);
                    YKLDownloadBean yKLDownloadBean = new YKLDownloadBean();
                    String str3 = u21.a;
                    yKLDownloadBean.url = str3;
                    this.mDownloadingList.put(str3, yKLDownloadBean);
                    arrayList.add(u21);
                }
            }
            sb0.a = arrayList;
        }
        ub0.c().b(sb0, new YklDownloadListener(this.mDownloadingList, downloadListener));
    }
}
