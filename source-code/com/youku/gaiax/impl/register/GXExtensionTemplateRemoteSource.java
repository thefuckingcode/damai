package com.youku.gaiax.impl.register;

import android.os.SystemClock;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.GXTemplateEngine;
import com.alibaba.gaiax.template.GXTemplateInfo;
import com.taobao.weex.common.Constants;
import com.tencent.open.SocialConstants;
import com.uc.webview.export.extension.UCCore;
import com.youku.gaiax.GaiaX;
import com.youku.gaiax.IStable;
import com.youku.gaiax.api.proxy.IProxyFeatures;
import com.youku.gaiax.api.proxy.IProxyMonitor;
import com.youku.gaiax.api.proxy.IProxyNet;
import com.youku.gaiax.api.proxy.IProxyPrefs;
import com.youku.gaiax.api.proxy.IProxySource;
import com.youku.gaiax.api.proxy.IProxyTask;
import com.youku.gaiax.common.utils.Log;
import com.youku.gaiax.impl.GaiaXProxy;
import com.youku.gaiax.impl.GaiaXStableApiImpl;
import com.youku.gaiax.impl.register.remote.GaiaXRemoteCacheUtils;
import com.youku.gaiax.impl.register.remote.GaiaXRemoteSourceUtils;
import com.youku.gaiax.impl.register.remote.GaiaXRemoteVersionUtils;
import com.youku.gaiax.impl.register.remote.IGaiaXRemoteTemplateEntity;
import com.youku.gaiax.impl.utils.ConfigUtils;
import com.youku.gaiax.impl.utils.ExceptionUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.b;
import kotlin.collections.k;
import org.apache.commons.net.SocketClient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.bo0;
import tb.k21;
import tb.m40;
import tb.vq0;
import tb.zo0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\u0006\b\u0016\u0018\u0000 e2\u00020\u0001:\u0001eB\u0007¢\u0006\u0004\bc\u0010dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0005H\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\fH\u0002J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\fH\u0003J\u001a\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0016\u001a\u00020\u0015H\u0002J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fH\u0002J\u0012\u0010\u001c\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002J\u0010\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0018\u0010#\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\"2\u0006\u0010!\u001a\u00020 H\u0002J\u0010\u0010&\u001a\u00020%2\u0006\u0010$\u001a\u00020\fH\u0002J\b\u0010'\u001a\u00020\u0002H\u0002J\u0010\u0010)\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u0005H\u0002J\b\u0010*\u001a\u00020\u0002H\u0002J \u0010-\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010+\u001a\u00020\f2\u0006\u0010,\u001a\u00020\u0011H\u0002J\u0012\u00100\u001a\u0004\u0018\u00010\u001a2\u0006\u0010/\u001a\u00020.H\u0016J\u0018\u00102\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\"01J\u0016\u00103\u001a\u00020 2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010+\u001a\u00020\fJ\u0016\u00104\u001a\u00020%2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010+\u001a\u00020\fJ\u0006\u00105\u001a\u00020\u0002J\u0006\u00106\u001a\u00020\u0002J\u0016\u00107\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010+\u001a\u00020\fJ\u000e\u00108\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\fJ\u0010\u00109\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\fH\u0007J\u0016\u00109\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010+\u001a\u00020\fJ\u0006\u0010:\u001a\u00020\fJ\u0006\u0010;\u001a\u00020\u0002J\u0001\u0010K\u001a\u0004\u0018\u00010\u001d2\u0006\u0010+\u001a\u00020\f2\u0006\u0010<\u001a\u00020%2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010=\u001a\u00020\f2\u0006\u0010>\u001a\u00020\f2\u0006\u0010?\u001a\u00020\f2\u0006\u0010@\u001a\u00020\f2\u0006\u0010A\u001a\u00020\f2\u0006\u0010B\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u00052\u0006\u0010D\u001a\u00020\f2\u0006\u0010E\u001a\u00020\f2\u0006\u0010F\u001a\u00020\f2\u0006\u0010G\u001a\u00020\f2\u0006\u0010H\u001a\u00020\f2\u0006\u0010I\u001a\u00020\f2\u0006\u0010J\u001a\u00020\fH\u0016J\u0010\u0010L\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0010\u0010M\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\"H\u0016J(\u0010P\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\"2\u0006\u0010N\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010O\u001a\u00020\fH\u0016J0\u0010Q\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\"2\u0006\u0010+\u001a\u00020\f2\u0006\u0010<\u001a\u00020%2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010H\u001a\u00020\fH\u0016J8\u0010R\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\"2\u0006\u0010+\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010H\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010O\u001a\u00020\fH\u0016J\b\u0010S\u001a\u00020\u0002H\u0016R\u0016\u0010T\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010V\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bV\u0010UR\u0016\u0010W\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bW\u0010UR\u0016\u0010X\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bX\u0010UR(\u0010[\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0Z0Y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010]\u001a\u00020%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010_\u001a\u00020%8\u0002@\u0002XD¢\u0006\u0006\n\u0004\b_\u0010^R\u001c\u0010a\u001a\b\u0012\u0004\u0012\u00020\f0`8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\ba\u0010b¨\u0006f"}, d2 = {"Lcom/youku/gaiax/impl/register/GXExtensionTemplateRemoteSource;", "Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionTemplateSource;", "Ltb/ur2;", "initRemoteCacheDirectory", "resetNetTimestamp", "", "getNetTimestamp", "finalTimestamp", "setNetTimestamp", "getAppVersion", "appVersion", "setAppVersion", "", "env", "setAppEnv", "getAppEnv", "templateBiz", "Lcom/alibaba/fastjson/JSONArray;", "templatesId", "requestTemplates", "templates", "", "autoLoadDepend", "processTemplatesData", "layer", "autoLoadDependTemplates", "Ltb/vq0;", "gxTemplate", "addTemplateToCache", "Lcom/youku/gaiax/impl/register/remote/IGaiaXRemoteTemplateEntity;", "entity", "createTemplateFromBinary", "Lcom/alibaba/fastjson/JSONObject;", "templateData", "", "writeTemplateToLocal", "templateReleaseStatus", "", "getTargetStatus", "initLocalTemplateSource", "timestamp", "requestAllTemplate", "initRemoteTemplateSource", "templateId", "result", "fillPrepareTemplate", "Lcom/alibaba/gaiax/GXTemplateEngine$h;", "gxTemplateItem", "getTemplate", "", "getAllRemoteTemplatesInMemory", "getRemoteTemplateFromDB", "getRemoteTemplateVersion", "launchDB", "launchRemote", "templateExistWithRemote", "requestRemoteTemplatesWithAsync", "requestRemoteTemplatesWithSync", "getRemoteGaiaXCachePath", "cleanRemoteTemplates", "templateVersion", "templatePlatform", "templateDesc", "templateResourceUrl", "templateLocalUrl", "templatePriority", "templateSupportMinVersion", "templateSupportMaxVersion", "templateCreateTime", "templateModifyTime", "templateCreateEmpId", "templateModifyEmpId", "templateStatus", "templateExtInfo", "templateFileType", "createTemplateEntity", "insertTemplateEntity", "getAll", "status", "platform", "getAllWithStatusAndAppVersion", "getTemplateEntityWithStatus", "getTemplateEntityWithStatusAndAppVersion", "clearAllToDB", "isHaveEmptyResult", "Z", "isHaveParseError", "isSyncNetTemplate", "isSyncLocalTemplate", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/CopyOnWriteArraySet;", "remoteTemplateCache", "Ljava/util/concurrent/ConcurrentHashMap;", "pageNum", "I", Constants.Name.PAGE_SIZE, "", "remoteCheckCache", "Ljava/util/Set;", "<init>", "()V", "Companion", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public class GXExtensionTemplateRemoteSource implements GXRegisterCenter.GXIExtensionTemplateSource {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final Lazy<GXExtensionTemplateRemoteSource> instance$delegate = b.b(GXExtensionTemplateRemoteSource$Companion$instance$2.INSTANCE);
    private boolean isHaveEmptyResult;
    private boolean isHaveParseError;
    private volatile boolean isSyncLocalTemplate;
    private volatile boolean isSyncNetTemplate;
    private int pageNum;
    private final int pageSize = 50;
    @NotNull
    private final Set<String> remoteCheckCache = new LinkedHashSet();
    @NotNull
    private final ConcurrentHashMap<String, CopyOnWriteArraySet<vq0>> remoteTemplateCache = new ConcurrentHashMap<>();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\b\u001a\u00020\u00028F@\u0006X\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/youku/gaiax/impl/register/GXExtensionTemplateRemoteSource$Companion;", "", "Lcom/youku/gaiax/impl/register/GXExtensionTemplateRemoteSource;", "remoteInstance", "instance$delegate", "Lkotlin/Lazy;", "getInstance", "()Lcom/youku/gaiax/impl/register/GXExtensionTemplateRemoteSource;", "instance", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }

        @NotNull
        public final GXExtensionTemplateRemoteSource getInstance() {
            return (GXExtensionTemplateRemoteSource) GXExtensionTemplateRemoteSource.instance$delegate.getValue();
        }

        @NotNull
        public final GXExtensionTemplateRemoteSource remoteInstance() {
            IProxySource source = GaiaXProxy.Companion.getInstance().getSource();
            GXExtensionTemplateRemoteSource remoteTemplateSource = source == null ? null : source.getRemoteTemplateSource();
            return remoteTemplateSource == null ? getInstance() : remoteTemplateSource;
        }
    }

    public GXExtensionTemplateRemoteSource() {
        initRemoteCacheDirectory();
    }

    private final void addTemplateToCache(vq0 vq0) {
        if (vq0 != null) {
            CopyOnWriteArraySet<vq0> copyOnWriteArraySet = this.remoteTemplateCache.get(vq0.a());
            if (copyOnWriteArraySet == null) {
                copyOnWriteArraySet = new CopyOnWriteArraySet<>();
                this.remoteTemplateCache.put(vq0.a(), copyOnWriteArraySet);
            }
            copyOnWriteArraySet.add(vq0);
            Log log = Log.INSTANCE;
            if (log.isLaunchLog()) {
                log.d("[GaiaX]", "addTemplateToCache() called with: gxTemplate = " + vq0 + " remoteTemplateCache = " + this.remoteTemplateCache.size() + " bizTemplates = " + copyOnWriteArraySet.size());
            }
        }
    }

    private final void autoLoadDependTemplates(String str, String str2) {
        JSONObject jSONObject;
        try {
            JSONObject jSONObject2 = JSON.parseObject(str2).getJSONObject("package");
            if (!(jSONObject2 == null || (jSONObject = jSONObject2.getJSONObject("dependencies")) == null)) {
                JSONArray jSONArray = new JSONArray();
                for (Map.Entry entry : jSONObject.entrySet()) {
                    jSONArray.add(entry.getKey());
                }
                if (!jSONArray.isEmpty()) {
                    requestTemplates(str, jSONArray);
                }
            }
        } catch (Exception e) {
            ExceptionUtils.INSTANCE.throwExceptionOrAlarm(e);
        }
    }

    private final vq0 createTemplateFromBinary(IGaiaXRemoteTemplateEntity iGaiaXRemoteTemplateEntity) {
        File file = new File(iGaiaXRemoteTemplateEntity.getLocalPath());
        Log log = Log.INSTANCE;
        if (log.isLaunchLog()) {
            log.d("[GaiaX]", k21.r("GaiaX远程模板初始化逻辑 - createTemplateFromBinary - start - ", file.getAbsolutePath()));
        }
        bo0 bo0 = bo0.INSTANCE;
        File absoluteFile = file.getAbsoluteFile();
        k21.h(absoluteFile, "file.absoluteFile");
        JSONObject b = bo0.b(absoluteFile);
        vq0 vq0 = new vq0(iGaiaXRemoteTemplateEntity.getTemplateId(), iGaiaXRemoteTemplateEntity.getTemplateBiz(), iGaiaXRemoteTemplateEntity.getTemplateVersion(), zo0.i(b, "layer"), zo0.i(b, "css"), zo0.i(b, "databinding"), zo0.i(b, "js"));
        vq0.i("remote");
        if (log.isLaunchLog()) {
            log.d("[GaiaX]", k21.r("GaiaX远程模板初始化逻辑 - createTemplateFromBinary - end - ", vq0));
        }
        return vq0;
    }

    private final void fillPrepareTemplate(String str, String str2, JSONArray jSONArray) {
        GXTemplateInfo gXTemplateInfo;
        List<GXTemplateInfo> k;
        CopyOnWriteArraySet<vq0> copyOnWriteArraySet = this.remoteTemplateCache.get(str);
        Object obj = null;
        if (copyOnWriteArraySet != null) {
            ArrayList arrayList = new ArrayList();
            for (T t : copyOnWriteArraySet) {
                if (k21.d(t.d(), str2)) {
                    arrayList.add(t);
                }
            }
            Iterator it = arrayList.iterator();
            if (it.hasNext()) {
                obj = it.next();
                if (it.hasNext()) {
                    int h = ((vq0) obj).h();
                    do {
                        Object next = it.next();
                        int h2 = ((vq0) next).h();
                        if (h < h2) {
                            obj = next;
                            h = h2;
                        }
                    } while (it.hasNext());
                }
            }
            obj = (vq0) obj;
        }
        if (obj == null) {
            jSONArray.add(str2);
            return;
        }
        ConcurrentHashMap<String, GXTemplateInfo> concurrentHashMap = GXExtensionTemplateInfoSource.Companion.getInstance().getDataCache().get(str);
        if (!(concurrentHashMap == null || (gXTemplateInfo = concurrentHashMap.get(str2)) == null || (k = gXTemplateInfo.k()) == null)) {
            for (T t2 : k) {
                fillPrepareTemplate(t2.r().a(), t2.r().d(), jSONArray);
            }
        }
    }

    private final String getAppEnv() {
        String string;
        IProxyPrefs prefs = GaiaXProxy.Companion.getInstance().getPrefs();
        return (prefs == null || (string = prefs.getString("GAIAX_NET_CONFIG", "app_env", "")) == null) ? "" : string;
    }

    private final long getAppVersion() {
        IProxyPrefs prefs = GaiaXProxy.Companion.getInstance().getPrefs();
        if (prefs == null) {
            return 0;
        }
        return prefs.getLong("GAIAX_NET_CONFIG", "app_version", 0);
    }

    private final long getNetTimestamp() {
        boolean z;
        IProxyPrefs prefs;
        GaiaXRemoteSourceUtils gaiaXRemoteSourceUtils = GaiaXRemoteSourceUtils.INSTANCE;
        long appVersion = gaiaXRemoteSourceUtils.getAppVersion();
        boolean z2 = true;
        if (getAppVersion() != appVersion) {
            setAppVersion(appVersion);
            resetNetTimestamp();
            z = true;
        } else {
            z = false;
        }
        String onlineStatus = gaiaXRemoteSourceUtils.getOnlineStatus();
        if (!k21.d(getAppEnv(), onlineStatus)) {
            setAppEnv(onlineStatus);
            resetNetTimestamp();
        } else {
            z2 = z;
        }
        if (!z2 && (prefs = GaiaXProxy.Companion.getInstance().getPrefs()) != null) {
            return prefs.getLong("GAIAX_NET_CONFIG", "net_all_timestamp", 0);
        }
        return 0;
    }

    private final int getTargetStatus(String str) {
        switch (str.hashCode()) {
            case -1861416333:
                return !str.equals("PUBLISH_OFFLINE") ? 0 : -2;
            case -797325479:
                return !str.equals("DAILY_ONLINE") ? 0 : 3;
            case 77184:
                str.equals("NEW");
                return 0;
            case 20817807:
                return !str.equals("PRE_ONLINE") ? 0 : 1;
            case 363160483:
                return !str.equals("PUBLISH_ONLINE") ? 0 : 2;
            case 410862599:
                return !str.equals("PRE_OFFLINE") ? 0 : -1;
            case 818224509:
                return !str.equals("DAILY_OFFLINE") ? 0 : -3;
            default:
                return 0;
        }
    }

    private final void initLocalTemplateSource() {
        GaiaXRemoteSourceUtils gaiaXRemoteSourceUtils = GaiaXRemoteSourceUtils.INSTANCE;
        String platform = gaiaXRemoteSourceUtils.getPlatform();
        String onlineStatus = gaiaXRemoteSourceUtils.getOnlineStatus();
        long appVersion = gaiaXRemoteSourceUtils.getAppVersion();
        List<IGaiaXRemoteTemplateEntity> allWithStatusAndAppVersion = getAllWithStatusAndAppVersion(onlineStatus, appVersion, platform);
        Log log = Log.INSTANCE;
        if (log.isLaunchLog()) {
            StringBuilder sb = new StringBuilder();
            sb.append("GaiaX远程模板初始化逻辑 - initLocalTemplateSource - start - ");
            sb.append(onlineStatus);
            sb.append(' ');
            sb.append(appVersion);
            sb.append(' ');
            sb.append(platform);
            sb.append(' ');
            sb.append(allWithStatusAndAppVersion == null ? null : Integer.valueOf(allWithStatusAndAppVersion.size()));
            log.d("[GaiaX]", sb.toString());
        }
        if (allWithStatusAndAppVersion != null) {
            ArrayList<IGaiaXRemoteTemplateEntity> arrayList = new ArrayList();
            for (T t : allWithStatusAndAppVersion) {
                File file = new File(t.getLocalPath());
                if (file.exists() && file.isFile()) {
                    arrayList.add(t);
                }
            }
            for (IGaiaXRemoteTemplateEntity iGaiaXRemoteTemplateEntity : arrayList) {
                Log log2 = Log.INSTANCE;
                if (log2.isLaunchLog()) {
                    log2.d("[GaiaX]", "GaiaX远程模板初始化逻辑 - 解析模板数据 - start 业务:" + iGaiaXRemoteTemplateEntity.getTemplateBiz() + "  模板:" + iGaiaXRemoteTemplateEntity.getTemplateId() + "  版本:" + iGaiaXRemoteTemplateEntity.getTemplateVersion() + "  状态：" + iGaiaXRemoteTemplateEntity.getReleaseStatus() + "  平台:" + iGaiaXRemoteTemplateEntity.getTemplatePlatform() + " 支持最大版本:" + iGaiaXRemoteTemplateEntity.getSupportMinVersion() + "  支持最小版本:" + iGaiaXRemoteTemplateEntity.getSupportMaxVersion());
                }
                addTemplateToCache(createTemplateFromBinary(iGaiaXRemoteTemplateEntity));
                if (log2.isLaunchLog()) {
                    log2.d("[GaiaX]", "GaiaX远程模板初始化逻辑 - 解析模板数据 - end");
                    log2.d("[GaiaX]", SocketClient.NETASCII_EOL);
                }
            }
        }
        Log log3 = Log.INSTANCE;
        if (log3.isLaunchLog()) {
            log3.d("[GaiaX]", "GaiaX远程模板初始化逻辑 - initLocalTemplateSource - end - " + onlineStatus + ' ' + appVersion);
        }
    }

    private final void initRemoteCacheDirectory() {
        File file = new File(GaiaXRemoteCacheUtils.INSTANCE.getCachePath());
        if (!file.exists()) {
            resetNetTimestamp();
            file.mkdirs();
        }
    }

    private final void initRemoteTemplateSource() {
        Log log = Log.INSTANCE;
        if (log.isLaunchLog()) {
            log.d("[GaiaX]", "GaiaX远程模板更新逻辑 - 接口请求 - 开始");
        }
        IProxyFeatures features = GaiaXProxy.Companion.getInstance().getFeatures();
        boolean z = false;
        if (features != null && !features.isNetworkConnected()) {
            z = true;
        }
        if (!z) {
            requestAllTemplate(Math.max(getNetTimestamp(), 0L));
            IStable stable = GaiaX.Companion.getInstance().stable();
            GaiaXStableApiImpl gaiaXStableApiImpl = stable instanceof GaiaXStableApiImpl ? (GaiaXStableApiImpl) stable : null;
            if (gaiaXStableApiImpl != null) {
                gaiaXStableApiImpl.notifyRemoteTemplateStateSuccess();
            }
            if (log.isLaunchLog()) {
                log.d("[GaiaX]", "GaiaX远程模板更新逻辑 - 接口请求 - 结束");
            }
        }
    }

    private final void processTemplatesData(JSONArray jSONArray, boolean z) {
        Iterator<T> it;
        String str;
        IGaiaXRemoteTemplateEntity iGaiaXRemoteTemplateEntity;
        for (Object obj : jSONArray) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.alibaba.fastjson.JSONObject");
            JSONObject jSONObject = (JSONObject) obj;
            String string = jSONObject.getString("status");
            String i = zo0.i(jSONObject, "metadata.templateId");
            String i2 = zo0.i(jSONObject, "metadata.templateVersion");
            String i3 = zo0.i(jSONObject, "scene.sceneId");
            try {
                Log log = Log.INSTANCE;
                if (log.isLaunchLog()) {
                    JSONArray g = zo0.g(jSONObject, "clientVersions");
                    log.d("[GaiaX]", "GaiaX远程模板更新逻辑 - 解析模板 业务：" + i3 + " - 模板：" + i + " - 版本：" + i2 + " - 状态：" + ((Object) string) + " - 版本范围:" + g);
                }
                List<IGaiaXRemoteTemplateEntity> writeTemplateToLocal = writeTemplateToLocal(jSONObject);
                String str2 = SocketClient.NETASCII_EOL;
                if (writeTemplateToLocal != null) {
                    Iterator<T> it2 = writeTemplateToLocal.iterator();
                    while (it2.hasNext()) {
                        T next = it2.next();
                        File file = new File(next.getLocalPath());
                        if (!file.exists() || !file.isFile()) {
                            throw new IllegalArgumentException("processTemplatesData id = " + i + " biz = " + i3 + " msg = file not exist " + ((Object) file.getAbsolutePath()));
                        }
                        insertTemplateEntity(next);
                        GaiaXRemoteSourceUtils gaiaXRemoteSourceUtils = GaiaXRemoteSourceUtils.INSTANCE;
                        String onlineStatus = gaiaXRemoteSourceUtils.getOnlineStatus();
                        String platform = gaiaXRemoteSourceUtils.getPlatform();
                        if (!k21.d(onlineStatus, next.getReleaseStatus()) || !k21.d(platform, next.getTemplatePlatform())) {
                            it = it2;
                            str = str2;
                        } else {
                            it = it2;
                            str = str2;
                            List<IGaiaXRemoteTemplateEntity> templateEntityWithStatusAndAppVersion = getTemplateEntityWithStatusAndAppVersion(next.getTemplateId(), next.getTemplateBiz(), onlineStatus, gaiaXRemoteSourceUtils.getAppVersion(), platform);
                            if (templateEntityWithStatusAndAppVersion == null) {
                                iGaiaXRemoteTemplateEntity = null;
                            } else {
                                iGaiaXRemoteTemplateEntity = (IGaiaXRemoteTemplateEntity) k.R(templateEntityWithStatusAndAppVersion);
                            }
                            if (iGaiaXRemoteTemplateEntity != null) {
                                vq0 createTemplateFromBinary = createTemplateFromBinary(iGaiaXRemoteTemplateEntity);
                                addTemplateToCache(createTemplateFromBinary);
                                Log log2 = Log.INSTANCE;
                                if (log2.isLaunchLog()) {
                                    log2.d("[GaiaX]", "GaiaX远程模板更新逻辑 - 更新模板 业务：" + iGaiaXRemoteTemplateEntity.getTemplateBiz() + " - 模板：" + iGaiaXRemoteTemplateEntity.getTemplateId() + " - 版本：" + iGaiaXRemoteTemplateEntity.getTemplateVersion() + " - 状态：" + iGaiaXRemoteTemplateEntity.getReleaseStatus() + " - 平台:" + iGaiaXRemoteTemplateEntity.getTemplatePlatform() + " - 支持最大版本:" + iGaiaXRemoteTemplateEntity.getSupportMaxVersion() + " - 支持最小版本:" + iGaiaXRemoteTemplateEntity.getSupportMinVersion());
                                    log2.d("[GaiaX]", str);
                                }
                                if (z) {
                                    autoLoadDependTemplates(iGaiaXRemoteTemplateEntity.getTemplateBiz(), createTemplateFromBinary.f());
                                }
                            } else {
                                throw new IllegalArgumentException("processTemplatesData entity already inserted but not query a result");
                            }
                        }
                        str2 = str;
                        it2 = it;
                    }
                    continue;
                } else if (log.isLaunchLog()) {
                    log.d("[GaiaX]", "GaiaX远程模板更新逻辑 - 跳过 业务：" + i3 + " - 模板：" + i + " - 版本：" + i2);
                    log.d("[GaiaX]", str2);
                }
            } catch (Exception e) {
                if (!this.isHaveParseError) {
                    this.isHaveParseError = true;
                }
                ExceptionUtils.INSTANCE.throwExceptionOrAlarm(e);
            }
        }
    }

    static /* synthetic */ void processTemplatesData$default(GXExtensionTemplateRemoteSource gXExtensionTemplateRemoteSource, JSONArray jSONArray, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = false;
            }
            gXExtensionTemplateRemoteSource.processTemplatesData(jSONArray, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: processTemplatesData");
    }

    private final void requestAllTemplate(long j) {
        GaiaXProxy.Companion companion = GaiaXProxy.Companion;
        IProxyMonitor monitor = companion.getInstance().getMonitor();
        if (monitor != null) {
            IProxyMonitor.DefaultImpls.monitor$default(monitor, "template_remote_request", null, null, null, UCCore.LEGACY_EVENT_INIT, 0, null, null, null, 494, null);
        }
        IProxyNet net2 = companion.getInstance().getNet();
        IProxyNet.NetResponse requestTemplateWithPage = net2 == null ? null : net2.requestTemplateWithPage(this.pageNum, this.pageSize, j);
        if (requestTemplateWithPage == null) {
            throw new IllegalArgumentException("requestAllTemplate response is null");
        } else if (requestTemplateWithPage.isSuccess()) {
            IProxyMonitor monitor2 = companion.getInstance().getMonitor();
            if (monitor2 != null) {
                IProxyMonitor.DefaultImpls.monitor$default(monitor2, "template_remote_request", null, null, null, "success", 0, null, null, null, 494, null);
            }
            int e = zo0.e(requestTemplateWithPage.getData(), "hasMore");
            long h = zo0.h(requestTemplateWithPage.getData(), "timestamp");
            zo0.e(requestTemplateWithPage.getData(), Constants.Name.PAGE_SIZE);
            JSONArray jSONArray = requestTemplateWithPage.getData().getJSONArray("result");
            if (jSONArray == null) {
                jSONArray = new JSONArray();
            }
            if (!this.isHaveEmptyResult && jSONArray.isEmpty()) {
                this.isHaveEmptyResult = true;
            }
            processTemplatesData$default(this, jSONArray, false, 2, null);
            if (e == 1) {
                this.pageNum++;
                requestAllTemplate(j);
                return;
            }
            boolean z = this.isHaveEmptyResult;
            if (!z && !this.isHaveParseError) {
                long max = Math.max(h, 0L);
                setNetTimestamp(max);
                Log log = Log.INSTANCE;
                if (log.isLaunchLog()) {
                    log.d("[GaiaX]", k21.r("GaiaX远程模板更新逻辑 - 接口请求 - 完全成功 - 时间戳 = ", Long.valueOf(max)));
                }
            } else if (z) {
                Log log2 = Log.INSTANCE;
                if (log2.isLaunchLog()) {
                    log2.d("[GaiaX]", "GaiaX远程模板更新逻辑 - 接口请求 - 数据为空的情况，没有待更新的模板，不更新时间戳");
                }
            }
        } else {
            IProxyMonitor monitor3 = companion.getInstance().getMonitor();
            if (monitor3 != null) {
                IProxyMonitor.DefaultImpls.monitor$default(monitor3, "template_remote_request", null, null, null, "error", 0, null, null, null, 494, null);
            }
            throw new IllegalArgumentException("requestAllTemplate - 接口请求 - 失败 msg = " + requestTemplateWithPage.getMessage() + " or response is null");
        }
    }

    private final void requestTemplates(String str, JSONArray jSONArray) {
        IProxyNet.NetResponse netResponse;
        IProxyNet net2 = GaiaXProxy.Companion.getInstance().getNet();
        if (net2 == null) {
            netResponse = null;
        } else {
            String jSONString = jSONArray.toJSONString();
            k21.h(jSONString, "templatesId.toJSONString()");
            netResponse = net2.requestTemplates(jSONString);
        }
        if (netResponse == null) {
            throw new IllegalArgumentException(k21.r("requestTemplates NetResponse is null, templatesId = ", jSONArray));
        } else if (netResponse.isSuccess()) {
            JSONArray jSONArray2 = netResponse.getData().getJSONArray("result");
            if (jSONArray2 == null) {
                jSONArray2 = new JSONArray();
            }
            if (jSONArray2.isEmpty()) {
                Log log = Log.INSTANCE;
                if (log.isLog()) {
                    log.d("[GaiaX]", k21.r("requestTemplates - 成功 但是数据为空，可能没有新模板需要更新，或者该模板不是远程模板 模板=", jSONArray));
                    return;
                }
                return;
            }
            this.isHaveParseError = false;
            processTemplatesData(jSONArray2, true);
            if (this.isHaveParseError) {
                for (Object obj : jSONArray) {
                    this.remoteCheckCache.remove(k21.r(str, obj));
                }
            }
        } else {
            for (Object obj2 : jSONArray) {
                this.remoteCheckCache.remove(k21.r(str, obj2));
            }
            throw new IllegalArgumentException("requestTemplates - 失败 templatesId = " + jSONArray + " msg = " + netResponse.getMessage());
        }
    }

    private final void resetNetTimestamp() {
        IProxyPrefs prefs = GaiaXProxy.Companion.getInstance().getPrefs();
        if (prefs != null) {
            prefs.putLong("GAIAX_NET_CONFIG", "net_all_timestamp", 0);
        }
    }

    private final void setAppEnv(String str) {
        IProxyPrefs prefs = GaiaXProxy.Companion.getInstance().getPrefs();
        if (prefs != null) {
            prefs.putString("GAIAX_NET_CONFIG", "app_env", str);
        }
    }

    private final void setAppVersion(long j) {
        IProxyPrefs prefs = GaiaXProxy.Companion.getInstance().getPrefs();
        if (prefs != null) {
            prefs.putLong("GAIAX_NET_CONFIG", "app_version", j);
        }
    }

    private final void setNetTimestamp(long j) {
        IProxyPrefs prefs = GaiaXProxy.Companion.getInstance().getPrefs();
        if (prefs != null) {
            prefs.putLong("GAIAX_NET_CONFIG", "net_all_timestamp", j);
        }
    }

    private final List<IGaiaXRemoteTemplateEntity> writeTemplateToLocal(JSONObject jSONObject) {
        IGaiaXRemoteTemplateEntity iGaiaXRemoteTemplateEntity;
        Iterator it;
        int i;
        String str;
        String str2;
        String str3;
        ArrayList arrayList;
        String i2 = zo0.i(jSONObject, "metadata.templateId");
        int e = zo0.e(jSONObject, "metadata.templateVersion");
        String i3 = zo0.i(jSONObject, "scene.sceneId");
        String i4 = zo0.i(jSONObject, "status");
        List<IGaiaXRemoteTemplateEntity> templateEntityWithStatus = getTemplateEntityWithStatus(i2, e, i3, i4);
        if (templateEntityWithStatus == null) {
            iGaiaXRemoteTemplateEntity = null;
        } else {
            iGaiaXRemoteTemplateEntity = (IGaiaXRemoteTemplateEntity) k.R(templateEntityWithStatus);
        }
        if (iGaiaXRemoteTemplateEntity == null || !new File(iGaiaXRemoteTemplateEntity.getLocalPath()).exists()) {
            String writeToSD = GaiaXRemoteCacheUtils.INSTANCE.writeToSD(zo0.i(jSONObject, "templateFileData"));
            String i5 = zo0.i(jSONObject, SocialConstants.PARAM_APP_DESC);
            String string = jSONObject.getString("priority");
            String i6 = zo0.i(jSONObject, "creator.timestamp");
            String i7 = zo0.i(jSONObject, "creator.empId");
            String i8 = zo0.i(jSONObject, "lastModifier.timestamp");
            String i9 = zo0.i(jSONObject, "lastModifier.empId");
            String i10 = zo0.i(jSONObject, "templateFileType");
            ArrayList arrayList2 = new ArrayList();
            JSONArray jSONArray = jSONObject.getJSONArray("clientVersions");
            if (jSONArray != null) {
                Iterator it2 = jSONArray.iterator();
                while (it2.hasNext()) {
                    Object next = it2.next();
                    Objects.requireNonNull(next, "null cannot be cast to non-null type com.alibaba.fastjson.JSONObject");
                    JSONObject jSONObject2 = (JSONObject) next;
                    String string2 = jSONObject2.getString("platform");
                    if (k21.d("ANDROID", string2) || k21.d("APAD", string2)) {
                        GaiaXRemoteVersionUtils gaiaXRemoteVersionUtils = GaiaXRemoteVersionUtils.INSTANCE;
                        long minVersion = gaiaXRemoteVersionUtils.getMinVersion(jSONObject2);
                        long maxVersion = gaiaXRemoteVersionUtils.getMaxVersion(jSONObject2);
                        k21.h(string2, "platform");
                        k21.h(string, "templatePriority");
                        it = it2;
                        arrayList = arrayList2;
                        str3 = string;
                        str2 = i4;
                        str = i3;
                        i = e;
                        IGaiaXRemoteTemplateEntity createTemplateEntity = createTemplateEntity(i2, e, i3, string2, i5, "", writeToSD, str3, minVersion, maxVersion, i6, i8, i7, i9, str2, "", i10);
                        if (createTemplateEntity != null) {
                            arrayList.add(createTemplateEntity);
                        }
                    } else {
                        it = it2;
                        arrayList = arrayList2;
                        str3 = string;
                        str2 = i4;
                        str = i3;
                        i = e;
                    }
                    arrayList2 = arrayList;
                    string = str3;
                    i4 = str2;
                    i3 = str;
                    e = i;
                    it2 = it;
                }
            }
            if (!arrayList2.isEmpty()) {
                return arrayList2;
            }
        }
        return null;
    }

    public final void cleanRemoteTemplates() {
        resetNetTimestamp();
        clearAllToDB();
    }

    public void clearAllToDB() {
    }

    @Nullable
    public IGaiaXRemoteTemplateEntity createTemplateEntity(@NotNull String str, int i, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, long j, long j2, @NotNull String str8, @NotNull String str9, @NotNull String str10, @NotNull String str11, @NotNull String str12, @NotNull String str13, @NotNull String str14) {
        k21.i(str, "templateId");
        k21.i(str2, "templateBiz");
        k21.i(str3, "templatePlatform");
        k21.i(str4, "templateDesc");
        k21.i(str5, "templateResourceUrl");
        k21.i(str6, "templateLocalUrl");
        k21.i(str7, "templatePriority");
        k21.i(str8, "templateCreateTime");
        k21.i(str9, "templateModifyTime");
        k21.i(str10, "templateCreateEmpId");
        k21.i(str11, "templateModifyEmpId");
        k21.i(str12, "templateStatus");
        k21.i(str13, "templateExtInfo");
        k21.i(str14, "templateFileType");
        return null;
    }

    @Nullable
    public List<IGaiaXRemoteTemplateEntity> getAll() {
        return null;
    }

    @NotNull
    public final Map<String, List<JSONObject>> getAllRemoteTemplatesInMemory() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, CopyOnWriteArraySet<vq0>> entry : this.remoteTemplateCache.entrySet()) {
            ArrayList arrayList = new ArrayList();
            for (T t : entry.getValue()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put((Object) "templateId", (Object) t.d());
                jSONObject.put((Object) "templateVersion", (Object) Integer.valueOf(t.h()));
                jSONObject.put((Object) "templateBiz", (Object) t.a());
                arrayList.add(jSONObject);
            }
            hashMap.put(entry.getKey(), arrayList);
        }
        return hashMap;
    }

    @Nullable
    public List<IGaiaXRemoteTemplateEntity> getAllWithStatusAndAppVersion(@NotNull String str, long j, @NotNull String str2) {
        k21.i(str, "status");
        k21.i(str2, "platform");
        return null;
    }

    @NotNull
    public final String getRemoteGaiaXCachePath() {
        return GaiaXRemoteCacheUtils.INSTANCE.getCachePath();
    }

    @NotNull
    public final JSONObject getRemoteTemplateFromDB(@NotNull String str, @NotNull String str2) {
        IGaiaXRemoteTemplateEntity iGaiaXRemoteTemplateEntity;
        k21.i(str, "templateBiz");
        k21.i(str2, "templateId");
        JSONObject jSONObject = new JSONObject();
        GaiaXRemoteSourceUtils gaiaXRemoteSourceUtils = GaiaXRemoteSourceUtils.INSTANCE;
        List<IGaiaXRemoteTemplateEntity> templateEntityWithStatusAndAppVersion = getTemplateEntityWithStatusAndAppVersion(str2, str, gaiaXRemoteSourceUtils.getOnlineStatus(), gaiaXRemoteSourceUtils.getAppVersion(), gaiaXRemoteSourceUtils.getPlatform());
        if (templateEntityWithStatusAndAppVersion == null) {
            iGaiaXRemoteTemplateEntity = null;
        } else {
            iGaiaXRemoteTemplateEntity = (IGaiaXRemoteTemplateEntity) k.R(templateEntityWithStatusAndAppVersion);
        }
        if (iGaiaXRemoteTemplateEntity == null) {
            return new JSONObject();
        }
        vq0 createTemplateFromBinary = createTemplateFromBinary(iGaiaXRemoteTemplateEntity);
        JSONObject jSONObject2 = new JSONObject();
        GXTemplateInfo.Companion companion = GXTemplateInfo.Companion;
        jSONObject2.put((Object) "index.json", (Object) companion.n(createTemplateFromBinary.f()));
        jSONObject2.put((Object) "index.css", (Object) companion.l(createTemplateFromBinary.b()));
        jSONObject2.put((Object) "index.databinding", (Object) companion.m(createTemplateFromBinary.c()));
        jSONObject2.put((Object) "index.js", (Object) createTemplateFromBinary.e());
        jSONObject.put((Object) com.youku.arch.v3.data.Constants.TEMPLATE, (Object) jSONObject2);
        jSONObject.put((Object) "templateId", (Object) str2);
        jSONObject.put((Object) "templateBiz", (Object) str);
        jSONObject.put((Object) "templateVersion", (Object) Integer.valueOf(iGaiaXRemoteTemplateEntity.getTemplateVersion()));
        jSONObject.put((Object) "templateType", (Object) "remote");
        return jSONObject;
    }

    public final int getRemoteTemplateVersion(@NotNull String str, @NotNull String str2) {
        T t;
        k21.i(str, "templateBiz");
        k21.i(str2, "templateId");
        CopyOnWriteArraySet<vq0> copyOnWriteArraySet = this.remoteTemplateCache.get(str);
        if (copyOnWriteArraySet == null) {
            return -1;
        }
        Iterator<T> it = copyOnWriteArraySet.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (k21.d(t.d(), str2)) {
                break;
            }
        }
        T t2 = t;
        if (t2 == null) {
            return -1;
        }
        return t2.h();
    }

    @Override // com.alibaba.gaiax.GXRegisterCenter.GXIExtensionTemplateSource
    @Nullable
    public vq0 getTemplate(@NotNull GXTemplateEngine.h hVar) {
        k21.i(hVar, "gxTemplateItem");
        String b = hVar.b();
        if (b.length() == 0) {
            b = hVar.a();
        }
        CopyOnWriteArraySet<vq0> copyOnWriteArraySet = this.remoteTemplateCache.get(b);
        Object obj = null;
        if (copyOnWriteArraySet == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (T t : copyOnWriteArraySet) {
            if (k21.d(t.d(), hVar.d())) {
                arrayList.add(t);
            }
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            obj = it.next();
            if (it.hasNext()) {
                int h = ((vq0) obj).h();
                do {
                    Object next = it.next();
                    int h2 = ((vq0) next).h();
                    if (h < h2) {
                        obj = next;
                        h = h2;
                    }
                } while (it.hasNext());
            }
        }
        return (vq0) obj;
    }

    @Nullable
    public List<IGaiaXRemoteTemplateEntity> getTemplateEntityWithStatus(@NotNull String str, int i, @NotNull String str2, @NotNull String str3) {
        k21.i(str, "templateId");
        k21.i(str2, "templateBiz");
        k21.i(str3, "templateStatus");
        return null;
    }

    @Nullable
    public List<IGaiaXRemoteTemplateEntity> getTemplateEntityWithStatusAndAppVersion(@NotNull String str, @NotNull String str2, @NotNull String str3, long j, @NotNull String str4) {
        k21.i(str, "templateId");
        k21.i(str2, "templateBiz");
        k21.i(str3, "templateStatus");
        k21.i(str4, "platform");
        return null;
    }

    public void insertTemplateEntity(@NotNull IGaiaXRemoteTemplateEntity iGaiaXRemoteTemplateEntity) {
        k21.i(iGaiaXRemoteTemplateEntity, "entity");
    }

    public final void launchDB() {
        long j;
        Log log = Log.INSTANCE;
        if (log.isLaunchLog()) {
            log.d("[GaiaX]", "GaiaX远程模板初始化逻辑 - 开始");
            j = SystemClock.elapsedRealtime();
        } else {
            j = 0;
        }
        if (ConfigUtils.INSTANCE.checkRemoteData() && !this.isSyncLocalTemplate) {
            this.isSyncLocalTemplate = true;
            try {
                initLocalTemplateSource();
            } catch (Exception e) {
                ExceptionUtils.INSTANCE.throwExceptionOrAlarm(e);
            }
        }
        Log log2 = Log.INSTANCE;
        if (log2.isLaunchLog()) {
            log2.d("[GaiaX]", "GaiaX远程模板初始化逻辑 - 结束 耗时(" + (SystemClock.elapsedRealtime() - j) + ')');
            log2.d("[GaiaX]", SocketClient.NETASCII_EOL);
        }
    }

    public final void launchRemote() {
        long j;
        Log log = Log.INSTANCE;
        if (log.isLaunchLog()) {
            log.d("[GaiaX]", "GaiaX远程模板更新逻辑 - 开始");
            j = SystemClock.elapsedRealtime();
        } else {
            j = 0;
        }
        if (ConfigUtils.INSTANCE.checkRemoteData() && !this.isSyncNetTemplate) {
            this.isSyncNetTemplate = true;
            try {
                initRemoteTemplateSource();
            } catch (Exception e) {
                ExceptionUtils.INSTANCE.throwExceptionOrAlarm(e);
            }
        }
        Log log2 = Log.INSTANCE;
        if (log2.isLaunchLog()) {
            log2.d("[GaiaX]", "GaiaX远程模板更新逻辑 - 结束 耗时(" + (SystemClock.elapsedRealtime() - j) + ')');
        }
        IProxyMonitor monitor = GaiaXProxy.Companion.getInstance().getMonitor();
        if (monitor != null) {
            monitor.monitorLocalAndRemote();
        }
    }

    public final void requestRemoteTemplatesWithAsync(@NotNull String str) {
        k21.i(str, "templatesId");
        IProxyTask task = GaiaXProxy.Companion.getInstance().getTask();
        if (task != null) {
            task.executeTask(new GXExtensionTemplateRemoteSource$requestRemoteTemplatesWithAsync$1(this, str));
        }
    }

    @Deprecated(message = "")
    public final void requestRemoteTemplatesWithSync(@NotNull String str) {
        k21.i(str, "templatesId");
        try {
            requestTemplates(str);
        } catch (Exception e) {
            ExceptionUtils.INSTANCE.throwExceptionOrAlarm(e);
        }
    }

    public final boolean templateExistWithRemote(@NotNull String str, @NotNull String str2) {
        k21.i(str, "templateBiz");
        k21.i(str2, "templateId");
        CopyOnWriteArraySet<vq0> copyOnWriteArraySet = this.remoteTemplateCache.get(str);
        vq0 vq0 = null;
        if (copyOnWriteArraySet != null) {
            Iterator<T> it = copyOnWriteArraySet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                T next = it.next();
                if (k21.d(next.d(), str2)) {
                    vq0 = next;
                    break;
                }
            }
            vq0 = vq0;
        }
        return vq0 != null;
    }

    public final void requestRemoteTemplatesWithSync(@NotNull String str, @NotNull String str2) {
        k21.i(str, "templateBiz");
        k21.i(str2, "templateId");
        try {
            String r = k21.r(str, str2);
            if (this.remoteCheckCache.contains(r)) {
                Log log = Log.INSTANCE;
                if (log.isLog()) {
                    log.d("[GaiaX]", "requestRemoteTemplatesWithSync() called with: key = " + r + ", continue");
                    return;
                }
                return;
            }
            this.remoteCheckCache.add(r);
            JSONArray jSONArray = new JSONArray();
            fillPrepareTemplate(str, str2, jSONArray);
            Log log2 = Log.INSTANCE;
            if (log2.isLog()) {
                log2.d("[GaiaX]", k21.r("requestRemoteTemplatesWithSync() called with: result = ", jSONArray));
            }
            if (!jSONArray.isEmpty()) {
                requestTemplates(str, jSONArray);
            }
        } catch (Exception e) {
            ExceptionUtils.INSTANCE.throwExceptionOrAlarm(e);
        }
    }

    /* access modifiers changed from: private */
    @Deprecated(message = "")
    public final void requestTemplates(String str) {
        IProxyNet net2 = GaiaXProxy.Companion.getInstance().getNet();
        IProxyNet.NetResponse requestTemplates = net2 == null ? null : net2.requestTemplates(str);
        if (requestTemplates == null) {
            throw new IllegalArgumentException(k21.r("requestTemplates NetResponse is null, templatesId = ", str));
        } else if (requestTemplates.isSuccess()) {
            JSONArray jSONArray = requestTemplates.getData().getJSONArray("result");
            if (jSONArray == null) {
                jSONArray = new JSONArray();
            }
            if (!jSONArray.isEmpty()) {
                processTemplatesData(jSONArray, true);
                return;
            }
            throw new IllegalArgumentException(k21.r("requestTemplates - 成功 但是数据为空 模板=", str));
        } else {
            throw new IllegalArgumentException("requestTemplates - 失败 templatesId = " + str + " msg = " + requestTemplates.getMessage());
        }
    }
}
