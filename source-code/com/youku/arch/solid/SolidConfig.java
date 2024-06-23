package com.youku.arch.solid;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.solid.download.DefaultDownloaderImpl;
import com.youku.arch.solid.download.IDownloader;
import com.youku.arch.solid.execuror.DefaultExecutor;
import com.youku.arch.solid.log.DefaultLoggerImpl;
import com.youku.arch.solid.log.ILogger;
import com.youku.arch.solid.log.SLog;
import com.youku.arch.solid.monitor.DefaultMonitorImpl;
import com.youku.arch.solid.monitor.IMonitor;
import com.youku.arch.solid.util.AbiUtils;
import com.youku.arch.solid.util.LibPathUtil;
import com.youku.arch.solid.util.TimeUtil;
import java.io.File;
import java.util.concurrent.Executor;

/* compiled from: Taobao */
public final class SolidConfig {
    private static transient /* synthetic */ IpChange $ipChange;
    private AbiUtils.AbiType abiType = AbiUtils.AbiType.UN_KNOW;
    private Application application;
    private IDownloader downloader;
    private Executor executor;
    private long launchTimeMillions = -1;
    private String libInstallPath;
    private ILogger logger;
    private IMonitor monitor;
    private boolean openLog;
    private boolean useCompress = true;
    private String versionName;

    /* compiled from: Taobao */
    public static class Builder {
        private static transient /* synthetic */ IpChange $ipChange;
        private SolidConfig mSolidConfig;

        public Builder(Application application) {
            SolidConfig solidConfig = new SolidConfig();
            this.mSolidConfig = solidConfig;
            solidConfig.application = application;
        }

        public SolidConfig build() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1651187435")) {
                return (SolidConfig) ipChange.ipc$dispatch("-1651187435", new Object[]{this});
            }
            SolidConfig solidConfig = this.mSolidConfig;
            if (solidConfig == null) {
                return null;
            }
            if (solidConfig.launchTimeMillions < 0) {
                this.mSolidConfig.launchTimeMillions = TimeUtil.getCurTimeStamp();
            }
            if (TextUtils.isEmpty(this.mSolidConfig.versionName) && this.mSolidConfig.application != null) {
                try {
                    PackageInfo packageInfo = this.mSolidConfig.application.getPackageManager().getPackageInfo(this.mSolidConfig.application.getPackageName(), 0);
                    this.mSolidConfig.versionName = packageInfo.versionName;
                } catch (Exception unused) {
                    this.mSolidConfig.versionName = "";
                }
            }
            if (this.mSolidConfig.logger == null) {
                SLog.setLogger(new DefaultLoggerImpl(this.mSolidConfig.openLog));
            } else {
                SLog.setLogger(this.mSolidConfig.logger);
            }
            if (this.mSolidConfig.executor == null) {
                this.mSolidConfig.executor = new DefaultExecutor();
            }
            if (this.mSolidConfig.monitor == null) {
                this.mSolidConfig.monitor = new DefaultMonitorImpl();
            }
            if (TextUtils.isEmpty(this.mSolidConfig.libInstallPath)) {
                SolidConfig solidConfig2 = this.mSolidConfig;
                solidConfig2.libInstallPath = LibPathUtil.getDefaultLibPath(solidConfig2.application);
            }
            SolidConfig solidConfig3 = this.mSolidConfig;
            solidConfig3.libInstallPath = this.mSolidConfig.libInstallPath + File.separator + LibPathUtil.getSpaceName(this.mSolidConfig.versionName);
            if (this.mSolidConfig.downloader == null) {
                this.mSolidConfig.downloader = new DefaultDownloaderImpl();
            }
            SolidConfig solidConfig4 = this.mSolidConfig;
            this.mSolidConfig = null;
            return solidConfig4;
        }

        public Builder openLog(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-196218122")) {
                return (Builder) ipChange.ipc$dispatch("-196218122", new Object[]{this, Boolean.valueOf(z)});
            }
            SolidConfig solidConfig = this.mSolidConfig;
            if (solidConfig == null) {
                return this;
            }
            solidConfig.openLog = z;
            return this;
        }

        public Builder setAbiType(AbiUtils.AbiType abiType) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1212452726")) {
                return (Builder) ipChange.ipc$dispatch("1212452726", new Object[]{this, abiType});
            }
            SolidConfig solidConfig = this.mSolidConfig;
            if (!(solidConfig == null || abiType == null)) {
                solidConfig.abiType = abiType;
            }
            return this;
        }

        public Builder setDownloader(IDownloader iDownloader) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1013033004")) {
                return (Builder) ipChange.ipc$dispatch("1013033004", new Object[]{this, iDownloader});
            }
            SolidConfig solidConfig = this.mSolidConfig;
            if (!(solidConfig == null || iDownloader == null)) {
                solidConfig.downloader = iDownloader;
            }
            return this;
        }

        public Builder setExecutor(Executor executor) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-928445991")) {
                return (Builder) ipChange.ipc$dispatch("-928445991", new Object[]{this, executor});
            }
            SolidConfig solidConfig = this.mSolidConfig;
            if (!(solidConfig == null || executor == null)) {
                solidConfig.executor = executor;
            }
            return this;
        }

        public Builder setLaunchTimeMillions(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1386010743")) {
                return (Builder) ipChange.ipc$dispatch("1386010743", new Object[]{this, Long.valueOf(j)});
            }
            SolidConfig solidConfig = this.mSolidConfig;
            if (solidConfig != null && j > 0) {
                solidConfig.launchTimeMillions = j;
            }
            return this;
        }

        public Builder setLibPath(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1227996072")) {
                return (Builder) ipChange.ipc$dispatch("-1227996072", new Object[]{this, str});
            }
            if (!(this.mSolidConfig == null || str == null || str.isEmpty())) {
                this.mSolidConfig.libInstallPath = str;
            }
            return this;
        }

        public Builder setLogger(ILogger iLogger) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1161836136")) {
                return (Builder) ipChange.ipc$dispatch("-1161836136", new Object[]{this, iLogger});
            }
            SolidConfig solidConfig = this.mSolidConfig;
            if (!(solidConfig == null || iLogger == null)) {
                solidConfig.logger = iLogger;
            }
            return this;
        }

        public Builder setMonitor(IMonitor iMonitor) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-925920048")) {
                return (Builder) ipChange.ipc$dispatch("-925920048", new Object[]{this, iMonitor});
            }
            SolidConfig solidConfig = this.mSolidConfig;
            if (!(solidConfig == null || iMonitor == null)) {
                solidConfig.monitor = iMonitor;
            }
            return this;
        }

        public Builder setVersionName(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2108519343")) {
                return (Builder) ipChange.ipc$dispatch("-2108519343", new Object[]{this, str});
            }
            if (this.mSolidConfig != null && !TextUtils.isEmpty(str)) {
                this.mSolidConfig.versionName = str;
            }
            return this;
        }

        public Builder useCompress(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1320486041")) {
                return (Builder) ipChange.ipc$dispatch("-1320486041", new Object[]{this, Boolean.valueOf(z)});
            }
            SolidConfig solidConfig = this.mSolidConfig;
            if (solidConfig == null) {
                return this;
            }
            solidConfig.useCompress = z;
            return this;
        }
    }

    /* access modifiers changed from: package-private */
    public AbiUtils.AbiType getAbiType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "496707117")) {
            return this.abiType;
        }
        return (AbiUtils.AbiType) ipChange.ipc$dispatch("496707117", new Object[]{this});
    }

    public Application getApplication() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1673628206")) {
            return this.application;
        }
        return (Application) ipChange.ipc$dispatch("1673628206", new Object[]{this});
    }

    public IDownloader getDownloader() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1162732137")) {
            return this.downloader;
        }
        return (IDownloader) ipChange.ipc$dispatch("-1162732137", new Object[]{this});
    }

    /* access modifiers changed from: package-private */
    public Executor getExecutor() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "161601998")) {
            return this.executor;
        }
        return (Executor) ipChange.ipc$dispatch("161601998", new Object[]{this});
    }

    public long getLaunchTimeMillions() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1936604984")) {
            return this.launchTimeMillions;
        }
        return ((Long) ipChange.ipc$dispatch("-1936604984", new Object[]{this})).longValue();
    }

    public String getLibInstallPath() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1010688736")) {
            return this.libInstallPath;
        }
        return (String) ipChange.ipc$dispatch("-1010688736", new Object[]{this});
    }

    /* access modifiers changed from: package-private */
    public IMonitor getMonitor() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2004270999")) {
            return this.monitor;
        }
        return (IMonitor) ipChange.ipc$dispatch("2004270999", new Object[]{this});
    }

    public String getVersionName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "367611348")) {
            return this.versionName;
        }
        return (String) ipChange.ipc$dispatch("367611348", new Object[]{this});
    }

    /* access modifiers changed from: package-private */
    public String getZipPath() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1174341815")) {
            return (String) ipChange.ipc$dispatch("1174341815", new Object[]{this});
        }
        return this.libInstallPath + File.separator + "zip";
    }

    public boolean isOpenLog() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-908770139")) {
            return this.openLog;
        }
        return ((Boolean) ipChange.ipc$dispatch("-908770139", new Object[]{this})).booleanValue();
    }

    public void setDownloader(IDownloader iDownloader) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-796135705")) {
            ipChange.ipc$dispatch("-796135705", new Object[]{this, iDownloader});
            return;
        }
        this.downloader = iDownloader;
    }

    /* access modifiers changed from: package-private */
    public boolean useCompress() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-287569652")) {
            return this.useCompress;
        }
        return ((Boolean) ipChange.ipc$dispatch("-287569652", new Object[]{this})).booleanValue();
    }
}
