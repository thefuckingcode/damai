package com.youku.arch.solid;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.solid.download.DownloadItem;
import com.youku.arch.solid.download.DownloadTask;
import com.youku.arch.solid.download.IDownloadListener;
import com.youku.arch.solid.log.SLog;
import com.youku.arch.solid.monitor.DefaultMonitorImpl;
import com.youku.arch.solid.monitor.IMonitor;
import com.youku.arch.solid.monitor.SolidMonitor;
import com.youku.arch.solid.util.TimeUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
public class Solid {
    private static transient /* synthetic */ IpChange $ipChange;
    private static volatile boolean hasStarted;
    private static volatile boolean isAllSoDownloaded;
    private static volatile boolean isAutoDownloading;
    private ActivityManager activityManager;
    private Application application;
    private final ComponentCallbacks2 mComponentCallbacks2 = new ComponentCallbacks2() {
        /* class com.youku.arch.solid.Solid.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        public void onConfigurationChanged(Configuration configuration) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-867583063")) {
                ipChange.ipc$dispatch("-867583063", new Object[]{this, configuration});
            }
        }

        public void onLowMemory() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1276304592")) {
                ipChange.ipc$dispatch("1276304592", new Object[]{this});
            }
        }

        @TargetApi(14)
        public void onTrimMemory(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1624417439")) {
                ipChange.ipc$dispatch("-1624417439", new Object[]{this, Integer.valueOf(i)});
            } else if (i == 20) {
                Solid solid = Solid.this;
                if (solid.getAm(solid.application) != null) {
                    Solid solid2 = Solid.this;
                    List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = solid2.getAm(solid2.application).getRunningAppProcesses();
                    if (runningAppProcesses != null && runningAppProcesses.size() > 0) {
                        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = runningAppProcesses.get(0);
                        if (runningAppProcessInfo.uid == Solid.this.application.getApplicationInfo().uid && runningAppProcessInfo.importance == 100) {
                            return;
                        }
                    }
                    Solid.this.autoDownload();
                }
            }
        }
    };
    private SolidConfig mConfig;
    private IMonitor mMonitor = new DefaultMonitorImpl();
    private final SoInfoManager mSoInfoManager = new SoInfoManager();

    /* compiled from: Taobao */
    public interface OnInitFinishCallback {
        void onFinish(boolean z);
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class SingletonHolder {
        static Solid mInstance = new Solid();

        private SingletonHolder() {
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void autoDownload() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-257001568")) {
            ipChange.ipc$dispatch("-257001568", new Object[]{this});
            return;
        }
        SLog.e("autoDownload", "Ready to auto download.");
        if (isAllSoDownloaded) {
            SLog.e("autoDownload", "All so auto downloaded, return out.");
        } else if (isAutoDownloading) {
            SLog.e("autoDownload", "Still auto downloading, return out.");
        } else {
            isAutoDownloading = true;
            if (!download(true, (SoGroupWrapper[]) this.mSoInfoManager.soGroupMap.values().toArray(new SoGroupWrapper[this.mSoInfoManager.soGroupMap.values().size()]))) {
                isAutoDownloading = false;
                isAllSoDownloaded = true;
                SLog.e("autoDownload", "All so auto downloaded, return out.");
            }
        }
    }

    private DownloadItem buildZipDownloadItem(boolean z, ZipDownloadItem zipDownloadItem) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-589351931")) {
            return new DownloadItem.Builder().setUrl(zipDownloadItem.getZipUrl()).setMd5(zipDownloadItem.getZipMd5()).setPath(this.mConfig.getZipPath()).setName(zipDownloadItem.getZipName()).setPriority(zipDownloadItem.getZipPriority(z)).setZipDownloadItem(zipDownloadItem).build();
        }
        return (DownloadItem) ipChange.ipc$dispatch("-589351931", new Object[]{this, Boolean.valueOf(z), zipDownloadItem});
    }

    private boolean download(boolean z, SoGroupWrapper... soGroupWrapperArr) {
        DownloadItem downloadItem;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1980438020")) {
            return ((Boolean) ipChange.ipc$dispatch("-1980438020", new Object[]{this, Boolean.valueOf(z), soGroupWrapperArr})).booleanValue();
        } else if (isLocal()) {
            return false;
        } else {
            String str = z ? "autoDownload" : "driveDownload";
            DownloadTask downloadTask = new DownloadTask();
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            ArrayList<SoInfoWrapper> arrayList = new ArrayList();
            for (SoGroupWrapper soGroupWrapper : soGroupWrapperArr) {
                if (soGroupWrapper != null) {
                    if (!this.mConfig.useCompress() || !soGroupWrapper.needDownloadZip()) {
                        arrayList.addAll(soGroupWrapper.getSoInfoList());
                    } else {
                        downloadTask.addDownloadItem(buildZipDownloadItem(z, soGroupWrapper));
                        sb.append(soGroupWrapper.getZipName());
                        sb.append(";");
                    }
                }
            }
            for (SoInfoWrapper soInfoWrapper : arrayList) {
                if (soInfoWrapper.needDownload()) {
                    if (!this.mConfig.useCompress() || !soInfoWrapper.needDownloadZip()) {
                        downloadItem = new DownloadItem.Builder().setUrl(soInfoWrapper.url()).setMd5(soInfoWrapper.md5()).setPath(this.mConfig.getLibInstallPath()).setName(soInfoWrapper.soFileName()).setPriority(soInfoWrapper.priority(z)).build();
                    } else {
                        downloadItem = buildZipDownloadItem(z, soInfoWrapper);
                    }
                    soInfoWrapper.updateStatus(Status.DOWNLOADING);
                    downloadTask.addDownloadItem(downloadItem);
                    sb.append(soInfoWrapper.soFileName());
                    sb.append(";");
                    SoGroupWrapper belongGroup = soInfoWrapper.getBelongGroup();
                    if (belongGroup != null && sb2.indexOf(belongGroup.name()) < 0) {
                        sb2.append(belongGroup.name());
                        sb2.append(";");
                    }
                }
            }
            if (downloadTask.getDownloadCount() <= 0) {
                return false;
            }
            doDownload(str, z, downloadTask);
            HashMap hashMap = new HashMap();
            hashMap.put(SolidMonitor.Params.NEED_DOWNLOAD_COUNT, downloadTask.getDownloadCount() + "");
            hashMap.put(SolidMonitor.Params.NEED_DOWNLOAD_SO_LIST, sb.toString());
            hashMap.put(SolidMonitor.Params.NEED_DOWNLOAD_GROUP_LIST, sb2.toString());
            this.mMonitor.reportStageResult(SolidMonitor.Stage.SOLID_REQUEST, hashMap);
            return true;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private ActivityManager getAm(Application application2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-605176625")) {
            return (ActivityManager) ipChange.ipc$dispatch("-605176625", new Object[]{this, application2});
        }
        try {
            if (this.activityManager == null) {
                this.activityManager = (ActivityManager) application2.getSystemService("activity");
            }
        } catch (Throwable unused) {
        }
        return this.activityManager;
    }

    public static Solid getInstance() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "863140251") ? (Solid) ipChange.ipc$dispatch("863140251", new Object[0]) : SingletonHolder.mInstance;
    }

    private void registerSystem() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1704072731")) {
            ipChange.ipc$dispatch("-1704072731", new Object[]{this});
            return;
        }
        this.application.registerComponentCallbacks(this.mComponentCallbacks2);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        this.application.registerReceiver(new BroadcastReceiver() {
            /* class com.youku.arch.solid.Solid.AnonymousClass4 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onReceive(Context context, Intent intent) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "120553254")) {
                    ipChange.ipc$dispatch("120553254", new Object[]{this, context, intent});
                    return;
                }
                Solid.this.autoDownload();
            }
        }, intentFilter);
    }

    /* access modifiers changed from: package-private */
    public void doDownload(final String str, final boolean z, DownloadTask downloadTask) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2109944234")) {
            ipChange.ipc$dispatch("2109944234", new Object[]{this, str, Boolean.valueOf(z), downloadTask});
            return;
        }
        SLog.e(str, str + ": Ready to download.");
        final long curTimeStamp = TimeUtil.getCurTimeStamp();
        this.mConfig.getDownloader().download(downloadTask, new IDownloadListener() {
            /* class com.youku.arch.solid.Solid.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.arch.solid.download.IDownloadListener
            public void onError() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1115121307")) {
                    ipChange.ipc$dispatch("1115121307", new Object[]{this});
                    return;
                }
                if (z) {
                    boolean unused = Solid.isAutoDownloading = false;
                }
                SLog.e(str, "download finish, status: fail");
            }

            @Override // com.youku.arch.solid.download.IDownloadListener
            public void onLibError(DownloadItem downloadItem, String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1036182724")) {
                    ipChange.ipc$dispatch("1036182724", new Object[]{this, downloadItem, str});
                    return;
                }
                String name = downloadItem.getName();
                String str2 = str;
                SLog.d(str2, "download single file fail -> " + name + ", errmsg -> " + str);
                StringBuilder sb = new StringBuilder();
                sb.append(downloadItem.getPath());
                sb.append(File.separator);
                sb.append(name);
                File file = new File(sb.toString());
                if (file.exists()) {
                    file.delete();
                }
                SoInfoWrapper soInfoWithSoName = Solid.this.mSoInfoManager.getSoInfoWithSoName(name);
                if (soInfoWithSoName != null) {
                    soInfoWithSoName.updateStatus(Status.DOWNLOAD_FAIL);
                }
                if (downloadItem.getZipDownloadItem() != null) {
                    downloadItem.getZipDownloadItem().downloadFail();
                }
                HashMap hashMap = new HashMap();
                SolidMonitor.Params params = SolidMonitor.Params.ELAPSE_SINCE_LAUNCH;
                hashMap.put(params, Solid.this.getElapseSinceLaunch() + "");
                SolidMonitor.Params params2 = SolidMonitor.Params.ERROR_MSG;
                if (TextUtils.isEmpty(str)) {
                    str = "unKnow";
                }
                hashMap.put(params2, str);
                hashMap.put(SolidMonitor.Params.LIB_NAME, name);
                SolidMonitor.Params params3 = SolidMonitor.Params.COST_TIME;
                hashMap.put(params3, (TimeUtil.getCurTimeStamp() - curTimeStamp) + "");
                hashMap.put(SolidMonitor.Params.SUCCESS, "0");
                Solid.this.mMonitor.reportStageResult(SolidMonitor.Stage.SOLID_LIB_DOWNLOAD, hashMap);
            }

            @Override // com.youku.arch.solid.download.IDownloadListener
            public void onLibStart(DownloadItem downloadItem) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "680991712")) {
                    ipChange.ipc$dispatch("680991712", new Object[]{this, downloadItem});
                    return;
                }
                String name = downloadItem.getName();
                String str = str;
                SLog.d(str, "download single file start -> " + name);
                HashMap hashMap = new HashMap();
                hashMap.put(SolidMonitor.Params.LIB_NAME, name);
                Solid.this.mMonitor.reportStageResult(SolidMonitor.Stage.SOLID_LIB_START_DOWNLOAD, hashMap);
            }

            @Override // com.youku.arch.solid.download.IDownloadListener
            public void onLibSuccess(DownloadItem downloadItem, String str, long j) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "894973819")) {
                    ipChange.ipc$dispatch("894973819", new Object[]{this, downloadItem, str, Long.valueOf(j)});
                    return;
                }
                File file = new File(str);
                String name = downloadItem.getName();
                String str2 = str;
                SLog.d(str2, "download single file success -> " + name);
                HashMap hashMap = new HashMap();
                SolidMonitor.Params params = SolidMonitor.Params.ELAPSE_SINCE_LAUNCH;
                hashMap.put(params, Solid.this.getElapseSinceLaunch() + "");
                SolidMonitor.Params params2 = SolidMonitor.Params.LIB_NAME;
                hashMap.put(params2, name);
                SolidMonitor.Params params3 = SolidMonitor.Params.COST_TIME;
                hashMap.put(params3, j + "");
                SolidMonitor.Params params4 = SolidMonitor.Params.SUCCESS;
                hashMap.put(params4, "1");
                SolidMonitor.Params params5 = SolidMonitor.Params.FILE_SIZE;
                hashMap.put(params5, file.length() + "");
                Solid.this.mMonitor.reportStageResult(SolidMonitor.Stage.SOLID_LIB_DOWNLOAD, hashMap);
                if (downloadItem.getZipDownloadItem() != null) {
                    ZipProcessor.unzip(downloadItem.getZipDownloadItem(), file);
                    return;
                }
                SoInfoWrapper soInfoWithSoName = Solid.this.mSoInfoManager.getSoInfoWithSoName(name);
                if (soInfoWithSoName != null) {
                    soInfoWithSoName.setLocalFile(file);
                    Status status = Status.DOWNLOADED;
                    soInfoWithSoName.updateStatus(status);
                    SoGroupWrapper belongGroup = soInfoWithSoName.getBelongGroup();
                    if (belongGroup != null && belongGroup.status() == status) {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put(params, Solid.this.getElapseSinceLaunch() + "");
                        hashMap2.put(params2, belongGroup.name());
                        hashMap2.put(params3, (TimeUtil.getCurTimeStamp() - curTimeStamp) + "");
                        hashMap2.put(params4, "1");
                        Solid.this.mMonitor.reportStageResult(SolidMonitor.Stage.SOLID_GROUP_DOWNLOAD, hashMap2);
                    }
                }
            }

            @Override // com.youku.arch.solid.download.IDownloadListener
            public void onSuccess(long j) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "199507844")) {
                    ipChange.ipc$dispatch("199507844", new Object[]{this, Long.valueOf(j)});
                    return;
                }
                if (z) {
                    boolean unused = Solid.isAutoDownloading = false;
                }
                SLog.e(str, "download finish, status: success");
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void driveDownload(SoGroupWrapper soGroupWrapper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1309975161")) {
            ipChange.ipc$dispatch("-1309975161", new Object[]{this, soGroupWrapper});
            return;
        }
        for (SoInfoWrapper soInfoWrapper : soGroupWrapper.getSoInfoList()) {
            soInfoWrapper.setDrive();
        }
        if (hasStarted()) {
            download(false, soGroupWrapper);
            return;
        }
        SLog.e("driveDownload", "driveDownload: " + soGroupWrapper.name() + " download failed, solid has not started");
    }

    public void executeTask(Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "262763383")) {
            ipChange.ipc$dispatch("262763383", new Object[]{this, runnable});
            return;
        }
        this.mConfig.getExecutor().execute(runnable);
    }

    public Application getApplication() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1137862732")) {
            return this.application;
        }
        return (Application) ipChange.ipc$dispatch("1137862732", new Object[]{this});
    }

    public SolidConfig getConfig() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1358249818")) {
            return this.mConfig;
        }
        return (SolidConfig) ipChange.ipc$dispatch("-1358249818", new Object[]{this});
    }

    public long getElapseSinceLaunch() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1896872988")) {
            return TimeUtil.getCurTimeStamp() - this.mConfig.getLaunchTimeMillions();
        }
        return ((Long) ipChange.ipc$dispatch("1896872988", new Object[]{this})).longValue();
    }

    public IMonitor getMonitor() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1230442549")) {
            return this.mConfig.getMonitor();
        }
        return (IMonitor) ipChange.ipc$dispatch("1230442549", new Object[]{this});
    }

    /* access modifiers changed from: package-private */
    public SoGroupWrapper getSoGroupWithName(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-548456645")) {
            return this.mSoInfoManager.getSoGroupWithName(str);
        }
        return (SoGroupWrapper) ipChange.ipc$dispatch("-548456645", new Object[]{this, str});
    }

    /* access modifiers changed from: package-private */
    public SoInfoWrapper getSoInfoWithSoName(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1455842667")) {
            return this.mSoInfoManager.getSoInfoWithSoName(str);
        }
        return (SoInfoWrapper) ipChange.ipc$dispatch("-1455842667", new Object[]{this, str});
    }

    public boolean hasStarted() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-891428620")) {
            return hasStarted;
        }
        return ((Boolean) ipChange.ipc$dispatch("-891428620", new Object[]{this})).booleanValue();
    }

    public void init(SolidConfig solidConfig) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-108494254")) {
            ipChange.ipc$dispatch("-108494254", new Object[]{this, solidConfig});
            return;
        }
        init(solidConfig, null);
    }

    /* access modifiers changed from: package-private */
    public boolean isLocal() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-253638826")) {
            return this.mSoInfoManager.isLocal();
        }
        return ((Boolean) ipChange.ipc$dispatch("-253638826", new Object[]{this})).booleanValue();
    }

    public void start() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1203594033")) {
            ipChange.ipc$dispatch("1203594033", new Object[]{this});
            return;
        }
        long curTimeStamp = TimeUtil.getCurTimeStamp();
        this.mConfig.getDownloader().init();
        autoDownload();
        registerSystem();
        HashMap hashMap = new HashMap();
        SolidMonitor.Params params = SolidMonitor.Params.ELAPSE_SINCE_LAUNCH;
        hashMap.put(params, getElapseSinceLaunch() + "");
        SolidMonitor.Params params2 = SolidMonitor.Params.COST_TIME;
        hashMap.put(params2, (TimeUtil.getCurTimeStamp() - curTimeStamp) + "");
        this.mMonitor.reportStageResult(SolidMonitor.Stage.SOLID_START, hashMap);
        hasStarted = true;
    }

    public void init(SolidConfig solidConfig, final OnInitFinishCallback onInitFinishCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1412731930")) {
            ipChange.ipc$dispatch("-1412731930", new Object[]{this, solidConfig, onInitFinishCallback});
            return;
        }
        this.mConfig = solidConfig;
        this.mMonitor = solidConfig.getMonitor();
        this.application = solidConfig.getApplication();
        SoLoader.appendLibSearchPath(this.mConfig.getLibInstallPath());
        executeTask(new Runnable() {
            /* class com.youku.arch.solid.Solid.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2094687898")) {
                    ipChange.ipc$dispatch("2094687898", new Object[]{this});
                    return;
                }
                boolean prepare = Solid.this.mSoInfoManager.prepare();
                SLog.e("Prepare", "prepare so info finish: " + prepare);
                OnInitFinishCallback onInitFinishCallback = onInitFinishCallback;
                if (onInitFinishCallback != null) {
                    onInitFinishCallback.onFinish(prepare);
                }
            }
        });
    }
}
