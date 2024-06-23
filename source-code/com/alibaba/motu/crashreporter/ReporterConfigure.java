package com.alibaba.motu.crashreporter;

import com.alibaba.motu.tbrest.rest.RestConstants;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;

/* compiled from: Taobao */
public class ReporterConfigure {
    public String adashxServerHost = RestConstants.G_DEFAULT_ADASHX_HOST;
    public boolean closeMainLooperMonitor = false;
    public int enabeANRTimeoutInterval = 5000;
    public long enabeMainLooperTimeoutInterval = DanmakuFactory.DEFAULT_DANMAKU_DURATION_V;
    public boolean enableANRMainThreadOnly = false;
    public boolean enableAbortCount = false;
    public boolean enableActivityMonitor = true;
    public boolean enableBreakPadDump = false;
    public boolean enableCatchANRException = true;
    public boolean enableCatchNativeException = true;
    public boolean enableCatchUncaughtException = true;
    public boolean enableDebug = false;
    public boolean enableDeduplication = false;
    public boolean enableDumpAllThread = false;
    public boolean enableDumpAppLog = false;
    public boolean enableDumpEventsLog = false;
    public boolean enableDumpRadioLog = false;
    public boolean enableDumpSysLog = false;
    public boolean enableExternalLinster = true;
    public boolean enableFinalizeFake = true;
    public int enableMaxThreadNumber = 200;
    public int enableMaxThreadStackTraceNumber = 64;
    public boolean enableSecuritySDK = true;
    public boolean enableStartCount = true;
    public int enableSysLogcatLinkMaxCount = 100;
    public int enableSysLogcatMaxCount = 100;
    public boolean enableUIProcessSafeGuard = false;
    public boolean enableUncaughtExceptionIgnore = true;
    public boolean isCloseMainLooperSampling = false;
    public int sendOnLaunchDelay = 0;

    public void setEnableANRMainThreadOnly(boolean z) {
        this.enableANRMainThreadOnly = z;
    }

    public void setEnableCatchANRException(boolean z) {
        this.enableCatchANRException = z;
    }

    public void setEnableDebug(boolean z) {
        this.enableDebug = z;
    }

    public void setEnableDumpAllThread(boolean z) {
        this.enableDumpAllThread = z;
    }

    public void setEnableDumpAppLog(boolean z) {
        this.enableDumpAppLog = z;
    }

    public void setEnableDumpEventsLog(boolean z) {
        this.enableDumpEventsLog = z;
    }

    public void setEnableDumpRadioLog(boolean z) {
        this.enableDumpRadioLog = z;
    }

    public void setEnableDumpSysLog(boolean z) {
        this.enableDumpSysLog = z;
    }
}
