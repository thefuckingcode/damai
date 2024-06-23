package com.youku.arch.solid.download;

import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.downloader.api.QueueConfig;
import com.taobao.downloader.api.Request;
import com.taobao.downloader.api.RequestQueue;
import com.taobao.downloader.inner.IEnLoaderListener;
import com.taobao.downloader.inner.IRetryPolicy;
import com.youku.arch.solid.Solid;
import com.youku.arch.solid.download.DownloadTask;
import com.youku.arch.solid.log.SLog;
import com.youku.arch.solid.util.TimeUtil;

/* compiled from: Taobao */
public class DefaultDownloaderImpl implements IDownloader {
    private static final String DOWNLOADER_BIZ_ID = "solid";
    private RequestQueue mRequestQueue;
    private IRetryPolicy mRetryPolicy;

    /* access modifiers changed from: package-private */
    /* renamed from: com.youku.arch.solid.download.DefaultDownloaderImpl$2  reason: invalid class name */
    /* compiled from: Taobao */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$youku$arch$solid$download$DownloadTask$Priority;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            int[] iArr = new int[DownloadTask.Priority.values().length];
            $SwitchMap$com$youku$arch$solid$download$DownloadTask$Priority = iArr;
            iArr[DownloadTask.Priority.HIGH.ordinal()] = 1;
            $SwitchMap$com$youku$arch$solid$download$DownloadTask$Priority[DownloadTask.Priority.NORMAL.ordinal()] = 2;
            try {
                $SwitchMap$com$youku$arch$solid$download$DownloadTask$Priority[DownloadTask.Priority.LOW.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* compiled from: Taobao */
    public static class BatchStatus {
        private static transient /* synthetic */ IpChange $ipChange;
        private StringBuilder failedMsgBuilder;
        private int finishCount = 0;
        private boolean isAllSuccess = true;
        private IDownloadListener listener;
        private long startTime;
        private int totalCount;

        /* compiled from: Taobao */
        public interface Callback {
            void onFail(DownloadItem downloadItem, String str, String str2);

            void onSuccess(DownloadItem downloadItem, String str, String str2, long j);
        }

        public BatchStatus(int i, @Nullable IDownloadListener iDownloadListener) {
            this.totalCount = i;
            this.failedMsgBuilder = new StringBuilder();
            this.listener = iDownloadListener;
            this.startTime = TimeUtil.getCurTimeStamp();
        }

        public BatchableListener createListener(DownloadItem downloadItem, String str) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-155538462")) {
                return new BatchableListener(downloadItem, str, new Callback() {
                    /* class com.youku.arch.solid.download.DefaultDownloaderImpl.BatchStatus.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // com.youku.arch.solid.download.DefaultDownloaderImpl.BatchStatus.Callback
                    public void onFail(DownloadItem downloadItem, String str, String str2) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-2051557225")) {
                            ipChange.ipc$dispatch("-2051557225", new Object[]{this, downloadItem, str, str2});
                            return;
                        }
                        BatchStatus.this.finishOne(downloadItem, str, false, str2, null, 0);
                    }

                    @Override // com.youku.arch.solid.download.DefaultDownloaderImpl.BatchStatus.Callback
                    public void onSuccess(DownloadItem downloadItem, String str, String str2, long j) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-7336738")) {
                            ipChange.ipc$dispatch("-7336738", new Object[]{this, downloadItem, str, str2, Long.valueOf(j)});
                            return;
                        }
                        BatchStatus.this.finishOne(downloadItem, str, true, null, str2, j);
                    }
                });
            }
            return (BatchableListener) ipChange.ipc$dispatch("-155538462", new Object[]{this, downloadItem, str});
        }

        public synchronized void finishOne(DownloadItem downloadItem, String str, boolean z, String str2, String str3, long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-884196650")) {
                ipChange.ipc$dispatch("-884196650", new Object[]{this, downloadItem, str, Boolean.valueOf(z), str2, str3, Long.valueOf(j)});
                return;
            }
            IDownloadListener iDownloadListener = this.listener;
            if (iDownloadListener != null) {
                this.finishCount++;
                if (z) {
                    iDownloadListener.onLibSuccess(downloadItem, str3, j);
                } else {
                    iDownloadListener.onLibError(downloadItem, str2);
                    if (this.failedMsgBuilder.length() > 0) {
                        this.failedMsgBuilder.append("; ");
                    }
                    StringBuilder sb = this.failedMsgBuilder;
                    sb.append("[error]");
                    sb.append(str2);
                    this.isAllSuccess = false;
                }
                if (this.finishCount == this.totalCount) {
                    if (this.isAllSuccess) {
                        this.listener.onSuccess(TimeUtil.getCurTimeStamp() - this.startTime);
                    } else {
                        this.listener.onError();
                    }
                }
            }
        }
    }

    /* compiled from: Taobao */
    public static class BatchableListener implements IEnLoaderListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private BatchStatus.Callback batchStatusCallback;
        private DownloadItem item;
        private String url;

        public BatchableListener(DownloadItem downloadItem, String str, BatchStatus.Callback callback) {
            this.item = downloadItem;
            this.url = str;
            this.batchStatusCallback = callback;
        }

        public void onCanceled() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-849564447")) {
                ipChange.ipc$dispatch("-849564447", new Object[]{this});
            }
        }

        public void onCompleted(boolean z, long j, String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1845509889")) {
                ipChange.ipc$dispatch("-1845509889", new Object[]{this, Boolean.valueOf(z), Long.valueOf(j), str});
                return;
            }
            this.batchStatusCallback.onSuccess(this.item, this.url, str, j);
        }

        public void onError(int i, String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "933378853")) {
                ipChange.ipc$dispatch("933378853", new Object[]{this, Integer.valueOf(i), str});
                return;
            }
            this.batchStatusCallback.onFail(this.item, this.url, str);
        }

        public void onPaused(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1407179032")) {
                ipChange.ipc$dispatch("-1407179032", new Object[]{this, Boolean.valueOf(z)});
            }
        }

        public void onProgress(long j, long j2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1661800435")) {
                ipChange.ipc$dispatch("-1661800435", new Object[]{this, Long.valueOf(j), Long.valueOf(j2)});
            }
        }

        public void onStart() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2146608462")) {
                ipChange.ipc$dispatch("2146608462", new Object[]{this});
            }
        }
    }

    private Request.Priority convertPriority(DownloadTask.Priority priority) {
        int i = AnonymousClass2.$SwitchMap$com$youku$arch$solid$download$DownloadTask$Priority[priority.ordinal()];
        if (i == 1) {
            return Request.Priority.HIGH;
        }
        if (i != 2) {
            return Request.Priority.LOW;
        }
        return Request.Priority.NORMAL;
    }

    @Override // com.youku.arch.solid.download.IDownloader
    public void download(DownloadTask downloadTask, IDownloadListener iDownloadListener) {
        if (downloadTask.getDownloadCount() != 0) {
            BatchStatus batchStatus = new BatchStatus(downloadTask.getDownloadCount(), iDownloadListener);
            for (DownloadItem downloadItem : downloadTask.getDownloadItems()) {
                Request.Build listener = new Request.Build().setUrl(downloadItem.getUrl()).setName(downloadItem.getName()).setCachePath(downloadItem.getPath()).setMd5(downloadItem.getMd5()).setBizId(DOWNLOADER_BIZ_ID).setUseCache(true).setPriority(convertPriority(downloadItem.getPriority())).setNetwork(Request.Network.MOBILE).setRetryPolicy(this.mRetryPolicy).setListener(batchStatus.createListener(downloadItem, downloadItem.getUrl()));
                iDownloadListener.onLibStart(downloadItem);
                this.mRequestQueue.add(listener.build());
            }
        }
    }

    @Override // com.youku.arch.solid.download.IDownloader
    public void init() {
        RequestQueue requestQueue = new RequestQueue(Solid.getInstance().getApplication(), new QueueConfig.Build().setThreadPoolSize(Math.min(6, 10)).build());
        this.mRequestQueue = requestQueue;
        requestQueue.start();
        this.mRetryPolicy = new IRetryPolicy() {
            /* class com.youku.arch.solid.download.DefaultDownloaderImpl.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public int getConnectTimeout() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "12838830")) {
                    return 15000;
                }
                return ((Integer) ipChange.ipc$dispatch("12838830", new Object[]{this})).intValue();
            }

            public int getReadTimeout() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-1722347264")) {
                    return 15000;
                }
                return ((Integer) ipChange.ipc$dispatch("-1722347264", new Object[]{this})).intValue();
            }

            public int getRetryCount() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "238529022")) {
                    return 3;
                }
                return ((Integer) ipChange.ipc$dispatch("238529022", new Object[]{this})).intValue();
            }
        };
        SLog.e("download", "default downloader init");
    }
}
