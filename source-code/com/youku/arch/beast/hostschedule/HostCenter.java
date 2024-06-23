package com.youku.arch.beast.hostschedule;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.aliweex.adapter.module.net.IWXConnection;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.tao.log.statistics.TLogEventConst;
import com.youku.arch.beast.apas.remote.ApasServiceManager;
import com.youku.arch.beast.hostschedule.RequestCfg;
import com.youku.arch.beast.hostschedule.v2.bean.Ad_meta;
import com.youku.arch.beast.hostschedule.v2.bean.DomainController;
import com.youku.arch.beast.hostschedule.v2.bean.Meta;
import com.youku.core.context.YoukuContext;
import com.youku.live.dago.liveplayback.widget.PluginName;
import com.youku.live.dago.widgetlib.wedome.adapter.animation.YKLAnimationViewAdapter;
import com.youku.player.networkscheduler.NetworkSchedulerWrapper;
import com.youku.util.Logger;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: Taobao */
public class HostCenter {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String LOCAL_FILE = "ykhost.cfg";
    private static final String TAG = "HostCenter";
    private String TYPE_MP4;
    private HashMap<String, String> domainRule;
    private String hostPattern;
    private Context mContext;
    private DomainController mDomainController;
    private ExecutorService mExecutor;
    private String mFreeDomain;
    private volatile HostScheduleInfo mInfo;
    private String mNewFreeDomain;

    /* access modifiers changed from: package-private */
    /* renamed from: com.youku.arch.beast.hostschedule.HostCenter$2  reason: invalid class name */
    /* compiled from: Taobao */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$youku$arch$beast$hostschedule$RequestCfg$PlayMode;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            int[] iArr = new int[RequestCfg.PlayMode.values().length];
            $SwitchMap$com$youku$arch$beast$hostschedule$RequestCfg$PlayMode = iArr;
            iArr[RequestCfg.PlayMode.AD.ordinal()] = 1;
            $SwitchMap$com$youku$arch$beast$hostschedule$RequestCfg$PlayMode[RequestCfg.PlayMode.VIDEO.ordinal()] = 2;
            try {
                $SwitchMap$com$youku$arch$beast$hostschedule$RequestCfg$PlayMode[RequestCfg.PlayMode.FEED.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class SingletonClassInstance {
        private static final HostCenter instance = new HostCenter();

        private SingletonClassInstance() {
        }
    }

    private void asyncSaveInfoToFile(final String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1805278985")) {
            ipChange.ipc$dispatch("1805278985", new Object[]{this, str});
            return;
        }
        Logger.d(TAG, "asyncSaveInfoToFile");
        this.mExecutor.execute(new Runnable() {
            /* class com.youku.arch.beast.hostschedule.HostCenter.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1437978693")) {
                    ipChange.ipc$dispatch("1437978693", new Object[]{this});
                    return;
                }
                HostCenter.this.saveInfoToFile(str);
            }
        });
    }

    public static HostCenter getInstance() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "300486235") ? (HostCenter) ipChange.ipc$dispatch("300486235", new Object[0]) : SingletonClassInstance.instance;
    }

    private boolean isYoukuCdnResource(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1744148161")) {
            return ((Boolean) ipChange.ipc$dispatch("-1744148161", new Object[]{this, str})).booleanValue();
        } else if (TextUtils.isEmpty(str)) {
            return true;
        } else {
            if (this.hostPattern == null) {
                this.hostPattern = ApasServiceManager.getInstance().getConfig("host_center", "HostPattern", "(?<!vod-1ts.)youku.com|ott.cibntv.net|cp12.wasu.tv|aikan.miguvideo.com|ups.video.ums.uc.cn|video.ups.uc.cn");
            }
            String str2 = this.hostPattern;
            if (TextUtils.isEmpty(str2)) {
                return true;
            }
            String str3 = null;
            Matcher matcher = Pattern.compile("(?<=://)([\\w\\-]+\\.)+[\\w\\-]+").matcher(str);
            if (matcher.find()) {
                str3 = matcher.group();
            }
            if (TextUtils.isEmpty(str3)) {
                return false;
            }
            return Pattern.compile(str2).matcher(str3).find();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004e A[SYNTHETIC, Splitter:B:24:0x004e] */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    private void saveInfoToFile(String str) {
        Throwable th;
        IOException e;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-382329387")) {
            ipChange.ipc$dispatch("-382329387", new Object[]{this, str});
            return;
        }
        FileWriter fileWriter = null;
        try {
            FileWriter fileWriter2 = new FileWriter(new File(this.mContext.getFilesDir().getAbsolutePath(), LOCAL_FILE));
            try {
                fileWriter2.write(str);
                try {
                    fileWriter2.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            } catch (IOException e3) {
                e = e3;
                fileWriter = fileWriter2;
                try {
                    e.printStackTrace();
                    if (fileWriter == null) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileWriter = fileWriter2;
                if (fileWriter != null) {
                }
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            e.printStackTrace();
            if (fileWriter == null) {
                fileWriter.close();
            }
        }
    }

    public String[] getBackUpDomains(RequestCfg requestCfg, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "978472014")) {
            return (String[]) ipChange.ipc$dispatch("978472014", new Object[]{this, requestCfg, Boolean.valueOf(z)});
        }
        DomainCell domainCell = new DomainCell();
        if (requestCfg == null) {
            return null;
        }
        if (this.mInfo != null && "1".equals(ApasServiceManager.getInstance().getConfig("HostSchedule", "enable_backup_domain", "0"))) {
            Logger.d(TAG, "use pcs info");
            try {
                int i = AnonymousClass2.$SwitchMap$com$youku$arch$beast$hostschedule$RequestCfg$PlayMode[requestCfg.playMode.ordinal()];
                if (i == 1) {
                    domainCell.cellular = this.mInfo.adDomain.cellular;
                    domainCell.wifi = this.mInfo.adDomain.wifi;
                } else if (i != 2) {
                    if (i == 3) {
                        if (this.TYPE_MP4.equals(requestCfg.fileType)) {
                            domainCell.cellular = this.mInfo.feedDomain.mp4Domain.cellular;
                            domainCell.wifi = this.mInfo.feedDomain.mp4Domain.wifi;
                        } else {
                            domainCell.cellular = this.mInfo.feedDomain.hlsDomain.cellular;
                            domainCell.wifi = this.mInfo.feedDomain.hlsDomain.wifi;
                        }
                    }
                } else if (this.TYPE_MP4.equals(requestCfg.fileType)) {
                    domainCell.cellular = this.mInfo.videoDomain.mp4Domain.cellular;
                    domainCell.wifi = this.mInfo.videoDomain.mp4Domain.wifi;
                } else {
                    domainCell.cellular = this.mInfo.videoDomain.hlsDomain.cellular;
                    domainCell.wifi = this.mInfo.videoDomain.hlsDomain.wifi;
                }
                if (this.mInfo.freeDomain != null && !TextUtils.isEmpty(this.mInfo.freeDomain.all)) {
                    this.mFreeDomain = this.mInfo.freeDomain.all;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String str = z ? domainCell.wifi : domainCell.cellular;
        if (!TextUtils.isEmpty(str)) {
            return str.split(",");
        }
        return null;
    }

    public String getDomain(Map<String, String> map) {
        String[] strArr;
        String[] strArr2;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1665892514")) {
            return (String) ipChange.ipc$dispatch("-1665892514", new Object[]{this, map});
        }
        String str = null;
        if (map == null || map.isEmpty() || !map.containsKey("domainController")) {
            return null;
        }
        try {
            if (!isYoukuCdnResource(map.get("url"))) {
                Logger.e(TAG, "check host, not youku cnd resource");
                return null;
            }
        } catch (Throwable unused) {
            Logger.e(TAG, "check host, some error occurred");
        }
        String str2 = map.get("domainController");
        DomainController domainController = this.mDomainController;
        if (domainController == null || !str2.equals(domainController.rawString)) {
            synchronized (this) {
                try {
                    DomainController domainController2 = (DomainController) JSON.parseObject(str2, DomainController.class);
                    this.mDomainController = domainController2;
                    domainController2.rawString = str2;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mDomainController == null) {
            Logger.e(TAG, "parse domainController failed!");
            return null;
        }
        boolean equals = YKLAnimationViewAdapter.TYPE_MP4.equals(map.get(TLogEventConst.PARAM_UPLOAD_FILE_TYPE));
        boolean equals2 = IWXConnection.TYPE_CELLULAR.equals(map.get("network"));
        boolean equals3 = "true".equals(map.get("force4GDomain"));
        if (!equals2 && !equals3) {
            z = false;
        }
        if (PluginName.AD.equals(map.get("playMode"))) {
            if (equals) {
                if (z) {
                    strArr2 = this.mDomainController.ad_rule.mp4_net_refresh_cellular;
                } else {
                    strArr2 = this.mDomainController.ad_rule.mp4_net_refresh_wifi;
                }
            } else if (z) {
                strArr2 = this.mDomainController.ad_rule.hls_net_refresh_cellular;
            } else {
                strArr2 = this.mDomainController.ad_rule.hls_net_refresh_wifi;
            }
            if (strArr2 != null && strArr2.length > 0) {
                if ("true".equals(map.get("forceHttps"))) {
                    for (String str3 : strArr2) {
                        Ad_meta[] ad_metaArr = this.mDomainController.ad_meta;
                        for (Ad_meta ad_meta : ad_metaArr) {
                            if (ad_meta.domain.equals("s") && ad_meta.https) {
                                str = str3;
                            }
                        }
                    }
                } else {
                    str = strArr2[0];
                }
            }
        } else {
            if (equals) {
                if (z) {
                    strArr = this.mDomainController.rule.mp4_net_refresh_cellular;
                } else {
                    strArr = this.mDomainController.rule.mp4_net_refresh_wifi;
                }
            } else if (z) {
                strArr = this.mDomainController.rule.hls_net_refresh_cellular;
            } else {
                strArr = this.mDomainController.rule.hls_net_refresh_wifi;
            }
            if (strArr != null && strArr.length > 0) {
                if ("true".equals(map.get("forceHttps"))) {
                    for (String str4 : strArr) {
                        Meta[] metaArr = this.mDomainController.meta;
                        for (Meta meta : metaArr) {
                            if (meta.domain.equals("s") && meta.https) {
                                str = str4;
                            }
                        }
                    }
                } else {
                    str = strArr[0];
                }
            }
        }
        if (!"1".equals(map.get("useAbsoluteFreeFlowDomain")) || !z) {
            return str;
        }
        if ("1".equals(map.get("useProxyNewDomain"))) {
            return this.mNewFreeDomain;
        }
        return this.mFreeDomain;
    }

    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1136160363")) {
            return (String) ipChange.ipc$dispatch("-1136160363", new Object[]{this});
        } else if (this.mInfo != null) {
            return this.mInfo.domainVersion;
        } else {
            return null;
        }
    }

    public void updateInfo(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-869807584")) {
            ipChange.ipc$dispatch("-869807584", new Object[]{this, str});
        } else if (str != null) {
            HostScheduleInfo hostScheduleInfo = null;
            try {
                hostScheduleInfo = (HostScheduleInfo) JSON.toJavaObject(JSON.parseObject(str).getJSONObject("domain"), HostScheduleInfo.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (hostScheduleInfo != null) {
                synchronized (this) {
                    this.mInfo = hostScheduleInfo;
                }
            }
        }
    }

    private HostCenter() {
        this.mExecutor = Executors.newSingleThreadScheduledExecutor();
        this.mContext = YoukuContext.getApplicationContext();
        this.mFreeDomain = "x-vali.cp31.ott.cibntv.net";
        this.mNewFreeDomain = "u-vali.cp31.ott.cibntv.net";
        this.TYPE_MP4 = "0";
        this.domainRule = new HashMap<>();
        this.hostPattern = null;
    }

    public DomainCell getDomain(RequestCfg requestCfg) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1118960546")) {
            return (DomainCell) ipChange.ipc$dispatch("1118960546", new Object[]{this, requestCfg});
        }
        DomainCell domainCell = new DomainCell();
        if (requestCfg != null) {
            if (this.mInfo != null && "1".equals(ApasServiceManager.getInstance().getConfig("HostSchedule", "use_pcs_for_start", "0"))) {
                Logger.d(TAG, "use pcs info");
                try {
                    int i = AnonymousClass2.$SwitchMap$com$youku$arch$beast$hostschedule$RequestCfg$PlayMode[requestCfg.playMode.ordinal()];
                    if (i == 1) {
                        domainCell.cellular = this.mInfo.adDomain.cellular;
                        domainCell.wifi = this.mInfo.adDomain.wifi;
                    } else if (i != 2) {
                        if (i == 3) {
                            if (this.TYPE_MP4.equals(requestCfg.fileType)) {
                                domainCell.cellular = this.mInfo.feedDomain.mp4Domain.cellular;
                                domainCell.wifi = this.mInfo.feedDomain.mp4Domain.wifi;
                            } else {
                                domainCell.cellular = this.mInfo.feedDomain.hlsDomain.cellular;
                                domainCell.wifi = this.mInfo.feedDomain.hlsDomain.wifi;
                            }
                        }
                    } else if (this.TYPE_MP4.equals(requestCfg.fileType)) {
                        domainCell.cellular = this.mInfo.videoDomain.mp4Domain.cellular;
                        domainCell.wifi = this.mInfo.videoDomain.mp4Domain.wifi;
                    } else {
                        domainCell.cellular = this.mInfo.videoDomain.hlsDomain.cellular;
                        domainCell.wifi = this.mInfo.videoDomain.hlsDomain.wifi;
                    }
                    if (this.mInfo.freeDomain != null && !TextUtils.isEmpty(this.mInfo.freeDomain.all)) {
                        this.mFreeDomain = this.mInfo.freeDomain.all;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (domainCell.cellular == null || domainCell.wifi == null) {
                Logger.d(TAG, "use ups info");
                try {
                    int i2 = AnonymousClass2.$SwitchMap$com$youku$arch$beast$hostschedule$RequestCfg$PlayMode[requestCfg.playMode.ordinal()];
                    if (i2 == 1) {
                        DomainCell domainCell2 = requestCfg.adDomain;
                        domainCell.cellular = domainCell2.cellular;
                        domainCell.wifi = domainCell2.wifi;
                    } else if (i2 == 2 || i2 == 3) {
                        if (this.TYPE_MP4.equals(requestCfg.fileType)) {
                            DomainCell domainCell3 = requestCfg.mp4Domain;
                            domainCell.cellular = domainCell3.cellular;
                            domainCell.wifi = domainCell3.wifi;
                        } else {
                            DomainCell domainCell4 = requestCfg.hlsDomain;
                            domainCell.cellular = domainCell4.cellular;
                            domainCell.wifi = domainCell4.wifi;
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        this.domainRule.clear();
        NetworkSchedulerWrapper.getInstance().getDomainMappingRule(this.domainRule);
        if (!TextUtils.isEmpty(domainCell.cellular) && !TextUtils.isEmpty(this.domainRule.get(domainCell.cellular))) {
            domainCell.cellular = this.domainRule.get(domainCell.cellular);
        }
        if (!TextUtils.isEmpty(domainCell.wifi) && !TextUtils.isEmpty(this.domainRule.get(domainCell.wifi))) {
            domainCell.wifi = this.domainRule.get(domainCell.wifi);
        }
        if (requestCfg != null && requestCfg.useAbsoluteFreeFlowDomain) {
            domainCell.cellular = requestCfg.useProxyNewDomain ? this.mNewFreeDomain : this.mFreeDomain;
        }
        return domainCell;
    }
}
