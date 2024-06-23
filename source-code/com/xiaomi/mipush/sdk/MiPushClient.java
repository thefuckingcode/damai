package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.taobao.weex.bridge.WXBridgeManager;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.manager.ClientReportClient;
import com.xiaomi.clientreport.manager.a;
import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.push.Cdo;
import com.xiaomi.push.al;
import com.xiaomi.push.bp;
import com.xiaomi.push.dd;
import com.xiaomi.push.dn;
import com.xiaomi.push.el;
import com.xiaomi.push.em;
import com.xiaomi.push.en;
import com.xiaomi.push.ey;
import com.xiaomi.push.h;
import com.xiaomi.push.hj;
import com.xiaomi.push.hn;
import com.xiaomi.push.ho;
import com.xiaomi.push.ht;
import com.xiaomi.push.hw;
import com.xiaomi.push.hx;
import com.xiaomi.push.id;
import com.xiaomi.push.ii;
import com.xiaomi.push.ij;
import com.xiaomi.push.in;
import com.xiaomi.push.ip;
import com.xiaomi.push.ir;
import com.xiaomi.push.iu;
import com.xiaomi.push.j;
import com.xiaomi.push.m;
import com.xiaomi.push.n;
import com.xiaomi.push.o;
import com.xiaomi.push.service.ba;
import com.xiaomi.push.service.bd;
import com.xiaomi.push.service.receivers.NetworkStatusReceiver;
import com.xiaomi.push.t;
import com.xiaomi.push.v;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import io.flutter.wpkbridge.WPKFactory;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: Taobao */
public abstract class MiPushClient {
    public static final String COMMAND_REGISTER = "register";
    public static final String COMMAND_SET_ACCEPT_TIME = "accept-time";
    public static final String COMMAND_SET_ACCOUNT = "set-account";
    public static final String COMMAND_SET_ALIAS = "set-alias";
    public static final String COMMAND_SUBSCRIBE_TOPIC = "subscribe-topic";
    public static final String COMMAND_UNREGISTER = "unregister";
    public static final String COMMAND_UNSET_ACCOUNT = "unset-account";
    public static final String COMMAND_UNSET_ALIAS = "unset-alias";
    public static final String COMMAND_UNSUBSCRIBE_TOPIC = "unsubscibe-topic";
    public static final String PREF_EXTRA = "mipush_extra";
    private static Context sContext;
    private static long sCurMsgId = System.currentTimeMillis();

    /* compiled from: Taobao */
    public static class CodeResult {
        private long resultCode = -1;

        public long getResultCode() {
            return this.resultCode;
        }

        /* access modifiers changed from: protected */
        public void setResultCode(long j) {
            this.resultCode = j;
        }
    }

    /* compiled from: Taobao */
    public interface ICallbackResult<R> {
        void onResult(R r);
    }

    @Deprecated
    /* compiled from: Taobao */
    public static abstract class MiPushClientCallback {
        private String category;

        /* access modifiers changed from: protected */
        public String getCategory() {
            return this.category;
        }

        public void onCommandResult(String str, long j, String str2, List<String> list) {
        }

        public void onInitializeResult(long j, String str, String str2) {
        }

        public void onReceiveMessage(MiPushMessage miPushMessage) {
        }

        public void onReceiveMessage(String str, String str2, String str3, boolean z) {
        }

        public void onSubscribeResult(long j, String str, String str2) {
        }

        public void onUnsubscribeResult(long j, String str, String str2) {
        }

        /* access modifiers changed from: protected */
        public void setCategory(String str) {
            this.category = str;
        }
    }

    /* compiled from: Taobao */
    public static class TokenResult {
        private long resultCode = -1;
        private String token = null;

        public long getResultCode() {
            return this.resultCode;
        }

        public String getToken() {
            return this.token;
        }

        /* access modifiers changed from: protected */
        public void setResultCode(long j) {
            this.resultCode = j;
        }

        /* access modifiers changed from: protected */
        public void setToken(String str) {
            this.token = str;
        }
    }

    /* compiled from: Taobao */
    public interface UPSRegisterCallBack extends ICallbackResult<TokenResult> {
    }

    /* compiled from: Taobao */
    public interface UPSTurnCallBack extends ICallbackResult<CodeResult> {
    }

    /* compiled from: Taobao */
    public interface UPSUnRegisterCallBack extends ICallbackResult<TokenResult> {
    }

    private static boolean acceptTimeSet(Context context, String str, String str2) {
        String acceptTime = getAcceptTime(context);
        return TextUtils.equals(acceptTime, str + "," + str2);
    }

    public static long accountSetTime(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        return sharedPreferences.getLong("account_" + str, -1);
    }

    static synchronized void addAcceptTime(Context context, String str, String str2) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putString(Constants.EXTRA_KEY_ACCEPT_TIME, str + "," + str2);
            t.a(edit);
        }
    }

    static synchronized void addAccount(Context context, String str) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putLong("account_" + str, System.currentTimeMillis()).commit();
        }
    }

    static synchronized void addAlias(Context context, String str) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putLong("alias_" + str, System.currentTimeMillis()).commit();
        }
    }

    private static void addPullNotificationTime(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.putLong("last_pull_notification", System.currentTimeMillis());
        t.a(edit);
    }

    private static void addRegRequestTime(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.putLong("last_reg_request", System.currentTimeMillis());
        t.a(edit);
    }

    static synchronized void addTopic(Context context, String str) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putLong("topic_" + str, System.currentTimeMillis()).commit();
        }
    }

    public static long aliasSetTime(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        return sharedPreferences.getLong("alias_" + str, -1);
    }

    public static void awakeApps(final Context context, final String[] strArr) {
        al.a(context).a(new Runnable() {
            /* class com.xiaomi.mipush.sdk.MiPushClient.AnonymousClass4 */

            public void run() {
                try {
                    String[] strArr = strArr;
                    for (String str : strArr) {
                        if (!TextUtils.isEmpty(str)) {
                            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 4);
                            if (packageInfo != null) {
                                MiPushClient.awakePushServiceByPackageInfo(context, packageInfo);
                            }
                        }
                    }
                } catch (Throwable th) {
                    b.a(th);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public static void awakePushServiceByPackageInfo(Context context, PackageInfo packageInfo) {
        ServiceInfo[] serviceInfoArr = packageInfo.services;
        if (serviceInfoArr != null) {
            for (ServiceInfo serviceInfo : serviceInfoArr) {
                if (serviceInfo.exported && serviceInfo.enabled && "com.xiaomi.mipush.sdk.PushMessageHandler".equals(serviceInfo.name) && !context.getPackageName().equals(serviceInfo.packageName)) {
                    try {
                        Thread.sleep(((long) ((Math.random() * 2.0d) + 1.0d)) * 1000);
                        Intent intent = new Intent();
                        intent.setClassName(serviceInfo.packageName, serviceInfo.name);
                        intent.setAction("com.xiaomi.mipush.sdk.WAKEUP");
                        intent.putExtra("waker_pkgname", context.getPackageName());
                        PushMessageHandler.a(context, intent);
                        return;
                    } catch (Throwable unused) {
                        return;
                    }
                }
            }
        }
    }

    private static void checkNotNull(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException("param " + str + " is not nullable");
        }
    }

    protected static void clearExtras(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.clear();
        edit.commit();
    }

    private static void clearExtrasForInitialize(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        Iterator<String> it = getAllAlias(context).iterator();
        while (it.hasNext()) {
            edit.remove("alias_" + it.next());
        }
        Iterator<String> it2 = getAllUserAccount(context).iterator();
        while (it2.hasNext()) {
            edit.remove("account_" + it2.next());
        }
        Iterator<String> it3 = getAllTopic(context).iterator();
        while (it3.hasNext()) {
            edit.remove("topic_" + it3.next());
        }
        edit.remove(Constants.EXTRA_KEY_ACCEPT_TIME);
        edit.commit();
    }

    public static void clearLocalNotificationType(Context context) {
        ao.a(context).f();
    }

    public static void clearNotification(Context context) {
        ao.a(context).a(-1);
    }

    public static void clearNotification(Context context, int i) {
        ao.a(context).a(i);
    }

    public static void clearNotification(Context context, String str, String str2) {
        ao.a(context).a(str, str2);
    }

    public static void disablePush(Context context) {
        ao.a(context).a(true);
    }

    public static void enablePush(Context context) {
        ao.a(context).a(false);
    }

    protected static String getAcceptTime(Context context) {
        return context.getSharedPreferences("mipush_extra", 0).getString(Constants.EXTRA_KEY_ACCEPT_TIME, "00:00-23:59");
    }

    public static List<String> getAllAlias(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (str.startsWith("alias_")) {
                arrayList.add(str.substring(6));
            }
        }
        return arrayList;
    }

    public static List<String> getAllTopic(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (str.startsWith("topic_") && !str.contains("**ALL**")) {
                arrayList.add(str.substring(6));
            }
        }
        return arrayList;
    }

    public static List<String> getAllUserAccount(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (str.startsWith("account_")) {
                arrayList.add(str.substring(8));
            }
        }
        return arrayList;
    }

    public static String getAppRegion(Context context) {
        if (b.m219a(context).m228c()) {
            return b.m219a(context).f();
        }
        return null;
    }

    private static boolean getDefaultSwitch() {
        return m.m738b();
    }

    protected static boolean getOpenFCMPush(Context context) {
        checkNotNull(context, WPKFactory.INIT_KEY_CONTEXT);
        return f.a(context).b(e.ASSEMBLE_PUSH_FCM);
    }

    protected static boolean getOpenHmsPush(Context context) {
        checkNotNull(context, WPKFactory.INIT_KEY_CONTEXT);
        return f.a(context).b(e.ASSEMBLE_PUSH_HUAWEI);
    }

    protected static boolean getOpenOPPOPush(Context context) {
        checkNotNull(context, WPKFactory.INIT_KEY_CONTEXT);
        return f.a(context).b(e.ASSEMBLE_PUSH_COS);
    }

    protected static boolean getOpenVIVOPush(Context context) {
        return f.a(context).b(e.ASSEMBLE_PUSH_FTOS);
    }

    public static String getRegId(Context context) {
        if (b.m219a(context).m228c()) {
            return b.m219a(context).m227c();
        }
        return null;
    }

    private static void initEventPerfLogic(final Context context) {
        en.a(new en.a() {
            /* class com.xiaomi.mipush.sdk.MiPushClient.AnonymousClass5 */

            @Override // com.xiaomi.push.en.a
            public void uploader(Context context, hn hnVar) {
                MiTinyDataClient.upload(context, hnVar);
            }
        });
        Config a = en.a(context);
        a.a(context).a("4_9_1");
        ClientReportClient.init(context, a, new el(context), new em(context));
        a.a(context);
        t.a(context, a);
        ba.a(context).a(new ba.a(100, "perf event job update") {
            /* class com.xiaomi.mipush.sdk.MiPushClient.AnonymousClass6 */

            /* access modifiers changed from: protected */
            @Override // com.xiaomi.push.service.ba.a
            public void onCallback() {
                en.m444a(context);
            }
        });
    }

    @Deprecated
    public static void initialize(Context context, String str, String str2, MiPushClientCallback miPushClientCallback) {
        initialize(context, str, str2, miPushClientCallback, null, null);
    }

    /* access modifiers changed from: private */
    public static void initialize(Context context, String str, String str2, MiPushClientCallback miPushClientCallback, String str3, ICallbackResult iCallbackResult) {
        try {
            b.a(context.getApplicationContext());
            b.e("sdk_version = 4_9_1");
            com.xiaomi.push.ba.a(context).m274a();
            dd.a(context);
            if (miPushClientCallback != null) {
                PushMessageHandler.a(miPushClientCallback);
            }
            if (iCallbackResult != null) {
                PushMessageHandler.a(iCallbackResult);
            }
            if (v.m882a(sContext)) {
                v.a(sContext);
            }
            boolean z = b.m219a(sContext).a() != Constants.a();
            if (z || shouldSendRegRequest(sContext)) {
                if (z || !b.m219a(sContext).a(str, str2) || b.m219a(sContext).m231f()) {
                    String a = bp.a(6);
                    b.m219a(sContext).m221a();
                    b.m219a(sContext).a(Constants.a());
                    b.m219a(sContext).a(str, str2, a);
                    MiTinyDataClient.a.a().b(MiTinyDataClient.PENDING_REASON_APPID);
                    clearExtras(sContext);
                    clearNotification(context);
                    ij ijVar = new ij();
                    ijVar.a(bd.b());
                    ijVar.b(str);
                    ijVar.e(str2);
                    ijVar.d(sContext.getPackageName());
                    ijVar.f(a);
                    Context context2 = sContext;
                    ijVar.c(h.m537a(context2, context2.getPackageName()));
                    Context context3 = sContext;
                    ijVar.b(h.a(context3, context3.getPackageName()));
                    ijVar.h("4_9_1");
                    ijVar.a(40091);
                    ijVar.a(hx.Init);
                    if (!TextUtils.isEmpty(str3)) {
                        ijVar.g(str3);
                    }
                    if (!m.m740d()) {
                        String e = j.e(sContext);
                        if (!TextUtils.isEmpty(e)) {
                            ijVar.i(bp.a(e) + "," + j.h(sContext));
                        }
                    }
                    int a2 = j.a();
                    if (a2 >= 0) {
                        ijVar.c(a2);
                    }
                    ao.a(sContext).a(ijVar, z);
                    sContext.getSharedPreferences("mipush_extra", 4).getBoolean("mipush_registed", true);
                } else {
                    if (1 == PushMessageHelper.getPushMode(sContext)) {
                        checkNotNull(miPushClientCallback, WXBridgeManager.METHOD_CALLBACK);
                        miPushClientCallback.onInitializeResult(0, null, b.m219a(sContext).m227c());
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(b.m219a(sContext).m227c());
                        PushMessageHelper.sendCommandMessageBroadcast(sContext, PushMessageHelper.generateCommandMessage(ey.COMMAND_REGISTER.f325a, arrayList, 0, null, null, null));
                    }
                    ao.a(sContext).m210a();
                    if (b.m219a(sContext).m223a()) {
                        ii iiVar = new ii();
                        iiVar.b(b.m219a(sContext).m220a());
                        iiVar.c(ht.ClientInfoUpdate.f497a);
                        iiVar.a(bd.a());
                        HashMap hashMap = new HashMap();
                        iiVar.f636a = hashMap;
                        Context context4 = sContext;
                        hashMap.put("app_version", h.m537a(context4, context4.getPackageName()));
                        Map<String, String> map = iiVar.f636a;
                        Context context5 = sContext;
                        map.put(Constants.EXTRA_KEY_APP_VERSION_CODE, Integer.toString(h.a(context5, context5.getPackageName())));
                        iiVar.f636a.put("push_sdk_vn", "4_9_1");
                        iiVar.f636a.put("push_sdk_vc", Integer.toString(40091));
                        String e2 = b.m219a(sContext).e();
                        if (!TextUtils.isEmpty(e2)) {
                            iiVar.f636a.put("deviceid", e2);
                        }
                        ao.a(sContext).a((iu) iiVar, hj.Notification, false, (hw) null);
                    }
                    if (!n.m742a(sContext, "update_devId", false)) {
                        updateImeiOrOaid();
                        n.a(sContext, "update_devId", true);
                    }
                    if (shouldUseMIUIPush(sContext) && shouldPullNotification(sContext)) {
                        ii iiVar2 = new ii();
                        iiVar2.b(b.m219a(sContext).m220a());
                        iiVar2.c(ht.PullOfflineMessage.f497a);
                        iiVar2.a(bd.a());
                        iiVar2.a(false);
                        ao.a(sContext).a((iu) iiVar2, hj.Notification, false, (hw) null, false);
                        addPullNotificationTime(sContext);
                    }
                }
                addRegRequestTime(sContext);
                scheduleOcVersionCheckJob();
                scheduleDataCollectionJobs(sContext);
                initEventPerfLogic(sContext);
                av.a(sContext);
                if (!sContext.getPackageName().equals("com.xiaomi.xmsf")) {
                    if (Logger.getUserLogger() != null) {
                        Logger.setLogger(sContext, Logger.getUserLogger());
                    }
                    b.a(2);
                }
                operateSyncAction(context);
                return;
            }
            ao.a(sContext).m210a();
            b.m182a("Could not send  register message within 5s repeatly .");
        } catch (Throwable th) {
            b.a(th);
        }
    }

    private static void operateSyncAction(Context context) {
        if ("syncing".equals(af.a(sContext).a(au.DISABLE_PUSH))) {
            disablePush(sContext);
        }
        if ("syncing".equals(af.a(sContext).a(au.ENABLE_PUSH))) {
            enablePush(sContext);
        }
        if ("syncing".equals(af.a(sContext).a(au.UPLOAD_HUAWEI_TOKEN))) {
            syncAssemblePushToken(sContext);
        }
        if ("syncing".equals(af.a(sContext).a(au.UPLOAD_FCM_TOKEN))) {
            syncAssembleFCMPushToken(sContext);
        }
        if ("syncing".equals(af.a(sContext).a(au.UPLOAD_COS_TOKEN))) {
            syncAssembleCOSPushToken(context);
        }
        if ("syncing".equals(af.a(sContext).a(au.UPLOAD_FTOS_TOKEN))) {
            syncAssembleFTOSPushToken(context);
        }
    }

    public static void pausePush(Context context, String str) {
        setAcceptTime(context, 0, 0, 0, 0, str);
    }

    static void reInitialize(Context context, hx hxVar) {
        b.e("re-register reason: " + hxVar);
        String a = bp.a(6);
        String a2 = b.m219a(context).m220a();
        String b = b.m219a(context).b();
        b.m219a(context).m221a();
        clearExtrasForInitialize(context);
        clearNotification(context);
        b.m219a(context).a(Constants.a());
        b.m219a(context).a(a2, b, a);
        ij ijVar = new ij();
        ijVar.a(bd.b());
        ijVar.b(a2);
        ijVar.e(b);
        ijVar.f(a);
        ijVar.d(context.getPackageName());
        ijVar.c(h.m537a(context, context.getPackageName()));
        ijVar.b(h.a(context, context.getPackageName()));
        ijVar.h("4_9_1");
        ijVar.a(40091);
        ijVar.a(hxVar);
        int a3 = j.a();
        if (a3 >= 0) {
            ijVar.c(a3);
        }
        ao.a(context).a(ijVar, false);
    }

    @Deprecated
    public static void registerCrashHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
    }

    private static void registerNetworkReceiver(Context context) {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION);
            intentFilter.addCategory("android.intent.category.DEFAULT");
            o.a(context.getApplicationContext(), new NetworkStatusReceiver(null), intentFilter);
            o.a(context, NetworkStatusReceiver.class);
        } catch (Throwable th) {
            b.m182a("dynamic register network status receiver failed:" + th);
        }
    }

    public static void registerPush(Context context, String str, String str2) {
        registerPush(context, str, str2, new PushConfiguration());
    }

    public static void registerPush(Context context, String str, String str2, PushConfiguration pushConfiguration) {
        registerPush(context, str, str2, pushConfiguration, null, null);
    }

    private static void registerPush(Context context, final String str, final String str2, PushConfiguration pushConfiguration, final String str3, final ICallbackResult iCallbackResult) {
        checkNotNull(context, WPKFactory.INIT_KEY_CONTEXT);
        checkNotNull(str, "appID");
        checkNotNull(str2, "appToken");
        Context applicationContext = context.getApplicationContext();
        sContext = applicationContext;
        if (applicationContext == null) {
            sContext = context;
        }
        Context context2 = sContext;
        v.a(context2);
        if (!NetworkStatusReceiver.a()) {
            registerNetworkReceiver(sContext);
        }
        f.a(sContext).a(pushConfiguration);
        al.a(context2).a(new Runnable() {
            /* class com.xiaomi.mipush.sdk.MiPushClient.AnonymousClass1 */

            public void run() {
                MiPushClient.initialize(MiPushClient.sContext, str, str2, null, str3, iCallbackResult);
            }
        });
    }

    public static void registerPush(Context context, String str, String str2, String str3) {
        registerPush(context, str, str2, new PushConfiguration(), str3, null);
    }

    public static void registerToken(Context context, String str, String str2, String str3, UPSRegisterCallBack uPSRegisterCallBack) {
        registerPush(context, str, str2, new PushConfiguration(), null, uPSRegisterCallBack);
    }

    static synchronized void removeAcceptTime(Context context) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.remove(Constants.EXTRA_KEY_ACCEPT_TIME);
            t.a(edit);
        }
    }

    static synchronized void removeAccount(Context context, String str) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.remove("account_" + str).commit();
        }
    }

    static synchronized void removeAlias(Context context, String str) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.remove("alias_" + str).commit();
        }
    }

    static synchronized void removeAllAccounts(Context context) {
        synchronized (MiPushClient.class) {
            for (String str : getAllUserAccount(context)) {
                removeAccount(context, str);
            }
        }
    }

    static synchronized void removeAllAliases(Context context) {
        synchronized (MiPushClient.class) {
            for (String str : getAllAlias(context)) {
                removeAlias(context, str);
            }
        }
    }

    static synchronized void removeAllTopics(Context context) {
        synchronized (MiPushClient.class) {
            for (String str : getAllTopic(context)) {
                removeTopic(context, str);
            }
        }
    }

    static synchronized void removeTopic(Context context, String str) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.remove("topic_" + str).commit();
        }
    }

    public static void removeWindow(Context context) {
        ao.a(context).m218e();
    }

    public static void reportAppRunInBackground(Context context, boolean z) {
        if (b.m219a(context).m226b()) {
            ht htVar = z ? ht.APP_SLEEP : ht.APP_WAKEUP;
            ii iiVar = new ii();
            iiVar.b(b.m219a(context).m220a());
            iiVar.c(htVar.f497a);
            iiVar.d(context.getPackageName());
            iiVar.a(bd.a());
            iiVar.a(false);
            ao.a(context).a((iu) iiVar, hj.Notification, false, (hw) null, false);
        }
    }

    static void reportIgnoreRegMessageClicked(Context context, String str, hw hwVar, String str2, String str3) {
        ii iiVar = new ii();
        if (TextUtils.isEmpty(str3)) {
            b.d("do not report clicked message");
            return;
        }
        iiVar.b(str3);
        iiVar.c("bar:click");
        iiVar.a(str);
        iiVar.a(false);
        ao.a(context).a(iiVar, hj.Notification, false, true, hwVar, true, str2, str3);
    }

    public static void reportMessageClicked(Context context, MiPushMessage miPushMessage) {
        hw hwVar = new hw();
        hwVar.a(miPushMessage.getMessageId());
        hwVar.b(miPushMessage.getTopic());
        hwVar.d(miPushMessage.getDescription());
        hwVar.c(miPushMessage.getTitle());
        hwVar.c(miPushMessage.getNotifyId());
        hwVar.a(miPushMessage.getNotifyType());
        hwVar.b(miPushMessage.getPassThrough());
        hwVar.a(miPushMessage.getExtra());
        reportMessageClicked(context, miPushMessage.getMessageId(), hwVar, null);
    }

    @Deprecated
    public static void reportMessageClicked(Context context, String str) {
        reportMessageClicked(context, str, null, null);
    }

    static void reportMessageClicked(Context context, String str, hw hwVar, String str2) {
        ii iiVar = new ii();
        if (TextUtils.isEmpty(str2)) {
            if (b.m219a(context).m226b()) {
                str2 = b.m219a(context).m220a();
            } else {
                b.d("do not report clicked message");
                return;
            }
        }
        iiVar.b(str2);
        iiVar.c("bar:click");
        iiVar.a(str);
        iiVar.a(false);
        ao.a(context).a((iu) iiVar, hj.Notification, false, hwVar);
    }

    public static void resumePush(Context context, String str) {
        setAcceptTime(context, 0, 0, 23, 59, str);
    }

    private static void scheduleDataCollectionJobs(Context context) {
        if (ba.a(sContext).a(ho.DataCollectionSwitch.a(), getDefaultSwitch())) {
            dn.a().a(new r(context));
            al.a(sContext).a(new Runnable() {
                /* class com.xiaomi.mipush.sdk.MiPushClient.AnonymousClass2 */

                public void run() {
                    Cdo.a(MiPushClient.sContext);
                }
            }, 10);
        }
    }

    private static void scheduleOcVersionCheckJob() {
        al.a(sContext).a(new ae(sContext), ba.a(sContext).a(ho.OcVersionCheckFrequency.a(), 86400), 5);
    }

    public static void setAcceptTime(Context context, int i, int i2, int i3, int i4, String str) {
        if (i < 0 || i >= 24 || i3 < 0 || i3 >= 24 || i2 < 0 || i2 >= 60 || i4 < 0 || i4 >= 60) {
            throw new IllegalArgumentException("the input parameter is not valid.");
        }
        long rawOffset = (long) (((TimeZone.getTimeZone("GMT+08").getRawOffset() - TimeZone.getDefault().getRawOffset()) / 1000) / 60);
        long j = ((((long) ((i * 60) + i2)) + rawOffset) + 1440) % 1440;
        long j2 = ((((long) ((i3 * 60) + i4)) + rawOffset) + 1440) % 1440;
        ArrayList arrayList = new ArrayList();
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(j / 60), Long.valueOf(j % 60)));
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(j2 / 60), Long.valueOf(j2 % 60)));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(String.format("%1$02d:%2$02d", Integer.valueOf(i), Integer.valueOf(i2)));
        arrayList2.add(String.format("%1$02d:%2$02d", Integer.valueOf(i3), Integer.valueOf(i4)));
        if (!acceptTimeSet(context, (String) arrayList.get(0), (String) arrayList.get(1))) {
            setCommand(context, ey.COMMAND_SET_ACCEPT_TIME.f325a, arrayList, str);
        } else if (1 == PushMessageHelper.getPushMode(context)) {
            PushMessageHandler.a(context, str, ey.COMMAND_SET_ACCEPT_TIME.f325a, 0, null, arrayList2);
        } else {
            PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(ey.COMMAND_SET_ACCEPT_TIME.f325a, arrayList2, 0, null, null, null));
        }
    }

    public static void setAlias(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            setCommand(context, ey.COMMAND_SET_ALIAS.f325a, str, str2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003e, code lost:
        com.xiaomi.mipush.sdk.PushMessageHelper.sendCommandMessageBroadcast(r12, com.xiaomi.mipush.sdk.PushMessageHelper.generateCommandMessage(r0.f325a, r6, 0, null, r15, null));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00a9, code lost:
        if (1 == com.xiaomi.mipush.sdk.PushMessageHelper.getPushMode(r12)) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0031, code lost:
        if (1 == com.xiaomi.mipush.sdk.PushMessageHelper.getPushMode(r12)) goto L_0x0033;
     */
    protected static void setCommand(Context context, String str, String str2, String str3) {
        StringBuilder sb;
        String str4;
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
        }
        ey eyVar = ey.COMMAND_SET_ALIAS;
        if (!eyVar.f325a.equalsIgnoreCase(str) || Math.abs(System.currentTimeMillis() - aliasSetTime(context, str2)) >= 86400000) {
            if (!ey.COMMAND_UNSET_ALIAS.f325a.equalsIgnoreCase(str) || aliasSetTime(context, str2) >= 0) {
                eyVar = ey.COMMAND_SET_ACCOUNT;
                if (!eyVar.f325a.equalsIgnoreCase(str) || Math.abs(System.currentTimeMillis() - accountSetTime(context, str2)) >= DateUtils.MILLIS_PER_HOUR) {
                    if (!ey.COMMAND_UNSET_ACCOUNT.f325a.equalsIgnoreCase(str) || accountSetTime(context, str2) >= 0) {
                        setCommand(context, str, arrayList, str3);
                        return;
                    } else {
                        sb = new StringBuilder();
                        str4 = "Don't cancel account for ";
                    }
                }
            } else {
                sb = new StringBuilder();
                str4 = "Don't cancel alias for ";
            }
            sb.append(str4);
            sb.append(bp.a(arrayList.toString(), 3));
            sb.append(" is unseted");
            b.m182a(sb.toString());
            return;
        }
        PushMessageHandler.a(context, str3, str, 0, null, arrayList);
    }

    protected static void setCommand(Context context, String str, ArrayList<String> arrayList, String str2) {
        if (!TextUtils.isEmpty(b.m219a(context).m220a())) {
            id idVar = new id();
            String a = bd.a();
            idVar.a(a);
            idVar.b(b.m219a(context).m220a());
            idVar.c(str);
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                idVar.m608a(it.next());
            }
            idVar.e(str2);
            idVar.d(context.getPackageName());
            b.e("cmd:" + str + AVFSCacheConstants.COMMA_SEP + a);
            ao.a(context).a(idVar, hj.Command, (hw) null);
        }
    }

    public static void setLocalNotificationType(Context context, int i) {
        ao.a(context).b(i & -1);
    }

    public static void setUserAccount(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            setCommand(context, ey.COMMAND_SET_ACCOUNT.f325a, str, str2);
        }
    }

    private static boolean shouldPullNotification(Context context) {
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_pull_notification", -1)) > 300000;
    }

    private static boolean shouldSendRegRequest(Context context) {
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_reg_request", -1)) > DanmakuFactory.DEFAULT_DANMAKU_DURATION_V;
    }

    public static boolean shouldUseMIUIPush(Context context) {
        return ao.a(context).m212a();
    }

    public static void subscribe(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(b.m219a(context).m220a()) && !TextUtils.isEmpty(str)) {
            if (Math.abs(System.currentTimeMillis() - topicSubscribedTime(context, str)) > 86400000) {
                in inVar = new in();
                String a = bd.a();
                inVar.a(a);
                inVar.b(b.m219a(context).m220a());
                inVar.c(str);
                inVar.d(context.getPackageName());
                inVar.e(str2);
                b.e("cmd:" + ey.COMMAND_SUBSCRIBE_TOPIC + AVFSCacheConstants.COMMA_SEP + a);
                ao.a(context).a(inVar, hj.Subscription, (hw) null);
            } else if (1 == PushMessageHelper.getPushMode(context)) {
                PushMessageHandler.a(context, str2, 0, null, str);
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(ey.COMMAND_SUBSCRIBE_TOPIC.f325a, arrayList, 0, null, null, null));
            }
        }
    }

    public static void syncAssembleCOSPushToken(Context context) {
        ao.a(context).a((String) null, au.UPLOAD_COS_TOKEN, e.ASSEMBLE_PUSH_COS);
    }

    public static void syncAssembleFCMPushToken(Context context) {
        ao.a(context).a((String) null, au.UPLOAD_FCM_TOKEN, e.ASSEMBLE_PUSH_FCM);
    }

    public static void syncAssembleFTOSPushToken(Context context) {
        ao.a(context).a((String) null, au.UPLOAD_FTOS_TOKEN, e.ASSEMBLE_PUSH_FTOS);
    }

    public static void syncAssemblePushToken(Context context) {
        ao.a(context).a((String) null, au.UPLOAD_HUAWEI_TOKEN, e.ASSEMBLE_PUSH_HUAWEI);
    }

    public static long topicSubscribedTime(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        return sharedPreferences.getLong("topic_" + str, -1);
    }

    public static void turnOffPush(Context context, UPSTurnCallBack uPSTurnCallBack) {
        disablePush(context);
        if (uPSTurnCallBack != null) {
            CodeResult codeResult = new CodeResult();
            codeResult.setResultCode(0);
            codeResult.getResultCode();
            uPSTurnCallBack.onResult(codeResult);
        }
    }

    public static void turnOnPush(Context context, UPSTurnCallBack uPSTurnCallBack) {
        enablePush(context);
        if (uPSTurnCallBack != null) {
            CodeResult codeResult = new CodeResult();
            codeResult.setResultCode(0);
            codeResult.getResultCode();
            uPSTurnCallBack.onResult(codeResult);
        }
    }

    public static void unRegisterToken(Context context, UPSUnRegisterCallBack uPSUnRegisterCallBack) {
        unregisterPush(context);
        if (uPSUnRegisterCallBack != null) {
            TokenResult tokenResult = new TokenResult();
            tokenResult.setToken(null);
            tokenResult.getToken();
            tokenResult.setResultCode(0);
            tokenResult.getResultCode();
            uPSUnRegisterCallBack.onResult(tokenResult);
        }
    }

    public static void unregisterPush(Context context) {
        i.c(context);
        ba.a(context).a();
        if (b.m219a(context).m226b()) {
            ip ipVar = new ip();
            ipVar.a(bd.a());
            ipVar.b(b.m219a(context).m220a());
            ipVar.c(b.m219a(context).m227c());
            ipVar.e(b.m219a(context).b());
            ipVar.d(context.getPackageName());
            ao.a(context).a(ipVar);
            PushMessageHandler.a();
            PushMessageHandler.b();
            b.m219a(context).m225b();
            clearLocalNotificationType(context);
            clearNotification(context);
            clearExtras(context);
        }
    }

    public static void unsetAlias(Context context, String str, String str2) {
        setCommand(context, ey.COMMAND_UNSET_ALIAS.f325a, str, str2);
    }

    public static void unsetUserAccount(Context context, String str, String str2) {
        setCommand(context, ey.COMMAND_UNSET_ACCOUNT.f325a, str, str2);
    }

    public static void unsubscribe(Context context, String str, String str2) {
        if (b.m219a(context).m226b()) {
            if (topicSubscribedTime(context, str) < 0) {
                b.m182a("Don't cancel subscribe for " + str + " is unsubscribed");
                return;
            }
            ir irVar = new ir();
            String a = bd.a();
            irVar.a(a);
            irVar.b(b.m219a(context).m220a());
            irVar.c(str);
            irVar.d(context.getPackageName());
            irVar.e(str2);
            b.e("cmd:" + ey.COMMAND_UNSUBSCRIBE_TOPIC + AVFSCacheConstants.COMMA_SEP + a);
            ao.a(context).a(irVar, hj.UnSubscription, (hw) null);
        }
    }

    private static void updateImeiOrOaid() {
        new Thread(new Runnable() {
            /* class com.xiaomi.mipush.sdk.MiPushClient.AnonymousClass3 */

            public void run() {
                if (m.m740d()) {
                    return;
                }
                if (j.d(MiPushClient.sContext) != null || com.xiaomi.push.ba.a(MiPushClient.sContext).m275a()) {
                    ii iiVar = new ii();
                    iiVar.b(b.m219a(MiPushClient.sContext).m220a());
                    iiVar.c(ht.ClientInfoUpdate.f497a);
                    iiVar.a(bd.a());
                    iiVar.a(new HashMap());
                    String str = "";
                    String d = j.d(MiPushClient.sContext);
                    if (!TextUtils.isEmpty(d)) {
                        str = str + bp.a(d);
                    }
                    String f = j.f(MiPushClient.sContext);
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(f)) {
                        str = str + "," + f;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        iiVar.m633a().put(Constants.EXTRA_KEY_IMEI_MD5, str);
                    }
                    com.xiaomi.push.ba.a(MiPushClient.sContext).a(iiVar.m633a());
                    int a = j.a();
                    if (a >= 0) {
                        iiVar.m633a().put("space_id", Integer.toString(a));
                    }
                    ao.a(MiPushClient.sContext).a((iu) iiVar, hj.Notification, false, (hw) null);
                }
            }
        }).start();
    }
}
