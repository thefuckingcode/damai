package com.youku.live.dsl.preloader;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.uc.webview.export.cyclone.StatAction;
import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.PlayerConfig;
import com.youku.alixplayer.opensdk.live.LiveInfo;
import com.youku.alixplayer.opensdk.utils.PlayerUtil;
import com.youku.android.liveservice.LivePlayerController;
import com.youku.android.liveservice.bean.LivePlayControl;
import com.youku.android.liveservice.bean.VideoInfo;
import com.youku.live.dago.liveplayback.widget.Utils;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.alarm.IYoukuLiveAlarm;
import com.youku.live.dsl.config.IRemoteConfig;
import com.youku.live.widgets.WidgetSDKEngine;
import com.youku.xadsdk.plugin.AdUtil;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class ILivePayControlPreloader implements LivePlayerController.IPlayControlListener, IPreloader {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long DEFAULT_TIMEOUT_INTERVAL = 5000;
    private static ILivePayControlPreloader sInstance;
    private volatile long beginTimestamp = 0;
    private volatile IResultCallback failureCallback;
    private volatile String instanceId;
    private volatile boolean isFinish;
    private volatile boolean isSuccess;
    private volatile String liveId;
    private volatile Map<String, Object> results;
    private volatile IResultCallback successCallback;

    private void doFinish() {
        IResultCallback iResultCallback;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1329823419")) {
            ipChange.ipc$dispatch("-1329823419", new Object[]{this});
        } else if (isFinish()) {
            synchronized (this) {
                if (isSuccess()) {
                    iResultCallback = this.successCallback;
                } else {
                    iResultCallback = this.failureCallback;
                }
                this.successCallback = null;
                this.failureCallback = null;
            }
            if (iResultCallback != null) {
                iResultCallback.onResult(this.results);
                removeSelfImp(true);
            }
        }
    }

    public static IPreloader getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-746183834")) {
            return (IPreloader) ipChange.ipc$dispatch("-746183834", new Object[0]);
        }
        if (sInstance == null) {
            synchronized (ILivePayControlPreloader.class) {
                if (sInstance == null) {
                    sInstance = new ILivePayControlPreloader();
                }
            }
        }
        return sInstance;
    }

    private long getTimeoutInterval() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1749192807")) {
            return ((Long) ipChange.ipc$dispatch("1749192807", new Object[]{this})).longValue();
        }
        IRemoteConfig iRemoteConfig = (IRemoteConfig) Dsl.getService(IRemoteConfig.class);
        if (iRemoteConfig != null) {
            return iRemoteConfig.getLong("YKLiveRoom_ABTest", "use_prefetch_playcontrol_timeout", 5000);
        }
        return 5000;
    }

    private boolean isSuccess() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1888847762")) {
            return this.isSuccess;
        }
        return ((Boolean) ipChange.ipc$dispatch("1888847762", new Object[]{this})).booleanValue();
    }

    private void removeSelfImp(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "505300169")) {
            ipChange.ipc$dispatch("505300169", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        IYoukuLiveAlarm iYoukuLiveAlarm = (IYoukuLiveAlarm) Dsl.getService(IYoukuLiveAlarm.class);
        if (iYoukuLiveAlarm != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("liveId", this.liveId);
            String str = "0";
            hashMap.put(StatAction.KEY_TOTAL, str);
            if (z) {
                str = "1";
            }
            hashMap.put("fromFinish", str);
            iYoukuLiveAlarm.commitSuccess("LivePlayControlPreloader", "", hashMap);
        }
        String str2 = this.instanceId;
        if (!TextUtils.isEmpty(str2)) {
            ((IPreloaderManangerImp) IPreloaderManangerImp.getInstance()).removePreloader(str2);
        }
    }

    @Override // com.youku.live.dsl.preloader.IPreloader
    public IPreloader addResultCallback(IResultCallback iResultCallback, IResultCallback iResultCallback2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1623002582")) {
            return (IPreloader) ipChange.ipc$dispatch("-1623002582", new Object[]{this, iResultCallback, iResultCallback2});
        }
        synchronized (this) {
            this.successCallback = iResultCallback;
            this.failureCallback = iResultCallback2;
        }
        doFinish();
        return this;
    }

    public boolean async(final String str, final String str2, final Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "641061485")) {
            return ((Boolean) ipChange.ipc$dispatch("641061485", new Object[]{this, str, str2, context})).booleanValue();
        }
        this.instanceId = str;
        this.liveId = str2;
        this.beginTimestamp = System.currentTimeMillis();
        IYoukuLiveAlarm iYoukuLiveAlarm = (IYoukuLiveAlarm) Dsl.getService(IYoukuLiveAlarm.class);
        if (iYoukuLiveAlarm != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("liveId", str2);
            hashMap.put(StatAction.KEY_TOTAL, "1");
            iYoukuLiveAlarm.commitSuccess("LivePlayControlPreloader", "", hashMap);
        }
        WidgetSDKEngine.getInstance().getRenderMananger().postOnWorkerThread(new Runnable() {
            /* class com.youku.live.dsl.preloader.ILivePayControlPreloader.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-381013681")) {
                    ipChange.ipc$dispatch("-381013681", new Object[]{this});
                    return;
                }
                ILivePayControlPreloader.this.asyncImp(str, str2, context);
            }
        });
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x004c A[SYNTHETIC, Splitter:B:12:0x004c] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0064  */
    public boolean asyncImp(String str, String str2, Context context) {
        Map map;
        String str3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-4086587")) {
            return ((Boolean) ipChange.ipc$dispatch("-4086587", new Object[]{this, str, str2, context})).booleanValue();
        }
        PlayerConfig defaultPlayerConfig = Utils.getDefaultPlayerConfig(context);
        String str4 = null;
        if (Utils.isYoukuOrHuaweiBaipai(context)) {
            try {
                map = AdUtil.getPreAdParameter(context, (PlayVideoInfo) null);
            } catch (Throwable unused) {
            }
            LivePlayerController livePlayerController = new LivePlayerController(str2, context, defaultPlayerConfig.getLiveCCode(), defaultPlayerConfig.getAppKey());
            livePlayerController.setPlayControlListener(this);
            if (map != null) {
                try {
                    str4 = new JSONObject(map).toString();
                } catch (Throwable unused2) {
                }
            }
            if (TextUtils.isEmpty(defaultPlayerConfig.getPlayAbilityJson())) {
                str3 = defaultPlayerConfig.getPlayAbilityJson();
            } else {
                str3 = PlayerUtil.getAbilityJson();
            }
            livePlayerController.getPlayControl(str2, "", "0", str4, str3, "", null, null, null, false, "");
            return true;
        }
        map = null;
        LivePlayerController livePlayerController2 = new LivePlayerController(str2, context, defaultPlayerConfig.getLiveCCode(), defaultPlayerConfig.getAppKey());
        livePlayerController2.setPlayControlListener(this);
        if (map != null) {
        }
        if (TextUtils.isEmpty(defaultPlayerConfig.getPlayAbilityJson())) {
        }
        livePlayerController2.getPlayControl(str2, "", "0", str4, str3, "", null, null, null, false, "");
        return true;
    }

    public void clearResult() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "943013917")) {
            ipChange.ipc$dispatch("943013917", new Object[]{this});
        } else if (this.results != null) {
            this.results.clear();
        }
    }

    @Nullable
    public LiveInfo getPrefetchVideoInfo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-338278400")) {
            return (LiveInfo) ipChange.ipc$dispatch("-338278400", new Object[]{this});
        } else if (this.results == null) {
            return null;
        } else {
            Object obj = this.results.get("videoInfo");
            if (obj instanceof LiveInfo) {
                return (LiveInfo) obj;
            }
            return null;
        }
    }

    @Override // com.youku.live.dsl.preloader.IPreloader
    public boolean isFinish() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1784267658")) {
            return this.isFinish;
        }
        return ((Boolean) ipChange.ipc$dispatch("1784267658", new Object[]{this})).booleanValue();
    }

    public boolean isTimeout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-76606092")) {
            return ((Boolean) ipChange.ipc$dispatch("-76606092", new Object[]{this})).booleanValue();
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.beginTimestamp;
        if (j != 0 && currentTimeMillis - j <= getTimeoutInterval()) {
            return false;
        }
        return true;
    }

    public void removeSelf() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-16961645")) {
            ipChange.ipc$dispatch("-16961645", new Object[]{this});
            return;
        }
        removeSelfImp(false);
    }

    @Override // com.youku.android.liveservice.LivePlayerController.IPlayControlListener
    public void requestFailure(LivePlayControl livePlayControl, int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-602179890")) {
            ipChange.ipc$dispatch("-602179890", new Object[]{this, livePlayControl, Integer.valueOf(i), str});
            return;
        }
        HashMap hashMap = new HashMap(3);
        hashMap.put("livePlayControl", livePlayControl);
        hashMap.put("code", Integer.valueOf(i));
        hashMap.put("msg", str);
        this.results = hashMap;
        this.isFinish = true;
        doFinish();
    }

    @Override // com.youku.android.liveservice.LivePlayerController.IPlayControlListener
    public void requestSuccess(VideoInfo videoInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1186474438")) {
            ipChange.ipc$dispatch("-1186474438", new Object[]{this, videoInfo});
            return;
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("videoInfo", videoInfo);
        this.results = hashMap;
        this.isFinish = true;
        this.isSuccess = true;
        doFinish();
    }
}
