package com.alibaba.pictures.accs;

import android.app.NotificationManager;
import android.content.Context;
import com.alibaba.security.biometrics.service.common.ABLogRecorderKeys;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.heytap.msp.push.HeytapPushManager;
import com.heytap.msp.push.callback.ICallBackResultService;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.push.HmsMessaging;
import com.meizu.cloud.pushsdk.PushManager;
import com.taobao.accs.ACCSClient;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.AccsException;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AppMonitorAdapter;
import com.taobao.agoo.TaobaoRegister;
import com.vivo.push.IPushActionListener;
import com.vivo.push.PushClient;
import com.xiaomi.mipush.sdk.MiPushClient;
import io.flutter.wpkbridge.WPKFactory;
import java.util.Objects;
import kotlin.jvm.JvmStatic;
import org.android.agoo.assist.AssistCallback;
import org.android.agoo.assist.AssistManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.f;
import tb.k21;

/* compiled from: Taobao */
public final class PushAgent {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final PushAgent INSTANCE = new PushAgent();
    private static final String a = ("AGOO." + PushAgent.class.getSimpleName());
    private static boolean b = true;
    private static int c;
    @Nullable
    private static IAccsServiceDelegate d;
    @Nullable
    private static IAgooServiceDelegate e;
    @Nullable
    private static INotifyActionHandler f;
    @Nullable
    private static IACCSConfigProvider g;

    /* compiled from: Taobao */
    public static final class a implements AssistCallback {
        private static transient /* synthetic */ IpChange $ipChange;

        /* renamed from: com.alibaba.pictures.accs.PushAgent$a$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public static final class C0090a implements ICallBackResultService {
            private static transient /* synthetic */ IpChange $ipChange;

            C0090a() {
            }

            @Override // com.heytap.msp.push.callback.ICallBackResultService
            public void onError(int i, @Nullable String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1884207078")) {
                    ipChange.ipc$dispatch("-1884207078", new Object[]{this, Integer.valueOf(i), str});
                    return;
                }
                PushAgent pushAgent = PushAgent.INSTANCE;
                String str2 = PushAgent.a;
                ALog.i(str2, "onError：" + i + "-mag=" + str, new Object[0]);
            }

            @Override // com.heytap.msp.push.callback.ICallBackResultService
            public void onGetNotificationStatus(int i, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1710889192")) {
                    ipChange.ipc$dispatch("1710889192", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
                }
            }

            @Override // com.heytap.msp.push.callback.ICallBackResultService
            public void onGetPushStatus(int i, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2094104409")) {
                    ipChange.ipc$dispatch("2094104409", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
                }
            }

            @Override // com.heytap.msp.push.callback.ICallBackResultService
            public void onRegister(int i, @NotNull String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "523516161")) {
                    ipChange.ipc$dispatch("523516161", new Object[]{this, Integer.valueOf(i), str});
                    return;
                }
                k21.i(str, "token");
                AssistManager.reportToken(str);
            }

            @Override // com.heytap.msp.push.callback.ICallBackResultService
            public void onSetPushTime(int i, @NotNull String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "902974299")) {
                    ipChange.ipc$dispatch("902974299", new Object[]{this, Integer.valueOf(i), str});
                    return;
                }
                k21.i(str, "s");
            }

            @Override // com.heytap.msp.push.callback.ICallBackResultService
            public void onUnRegister(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "695022256")) {
                    ipChange.ipc$dispatch("695022256", new Object[]{this, Integer.valueOf(i)});
                }
            }
        }

        /* compiled from: Taobao */
        public static final class b implements IPushActionListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ Context a;

            b(Context context) {
                this.a = context;
            }

            @Override // com.vivo.push.IPushActionListener
            public final void onStateChanged(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-821572693")) {
                    ipChange.ipc$dispatch("-821572693", new Object[]{this, Integer.valueOf(i)});
                } else if (i == 0) {
                    PushClient instance = PushClient.getInstance(this.a);
                    k21.h(instance, "PushClient.getInstance(context)");
                    AssistManager.reportToken(instance.getRegId());
                }
            }
        }

        a() {
        }

        @Override // org.android.agoo.assist.AssistCallback
        public void onRegisterFlyme(@Nullable Context context, @Nullable String str, @Nullable String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1330915282")) {
                ipChange.ipc$dispatch("1330915282", new Object[]{this, context, str, str2});
                return;
            }
            PushManager.register(context, str, str2);
        }

        @Override // org.android.agoo.assist.AssistCallback
        public void onRegisterHuawei(@Nullable Context context, @Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1044731300")) {
                ipChange.ipc$dispatch("1044731300", new Object[]{this, context, str});
                return;
            }
            PushAgent pushAgent = PushAgent.INSTANCE;
            ALog.d(PushAgent.a, "onRegisterHuawei: ---", new Object[0]);
            try {
                String token = HmsInstanceId.getInstance(context).getToken(str, HmsMessaging.DEFAULT_TOKEN_SCOPE);
                AssistManager.reportToken(token);
                String str2 = PushAgent.a;
                ALog.d(str2, "onRegisterHuawei: ---" + token, new Object[0]);
            } catch (ApiException e) {
                e.printStackTrace();
                PushAgent pushAgent2 = PushAgent.INSTANCE;
                String str3 = PushAgent.a;
                ALog.d(str3, "onRegisterHuawei: --- " + e.getMessage(), new Object[0]);
            }
        }

        @Override // org.android.agoo.assist.AssistCallback
        public void onRegisterOppo(@NotNull Context context, @Nullable String str, @Nullable String str2) {
            IpChange ipChange = $ipChange;
            boolean z = true;
            if (AndroidInstantRuntime.support(ipChange, "704175143")) {
                ipChange.ipc$dispatch("704175143", new Object[]{this, context, str, str2});
                return;
            }
            k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
            if ((context.getApplicationInfo().flags & 2) == 0) {
                z = false;
            }
            HeytapPushManager.init(context, z);
            HeytapPushManager.register(context, str, str2, new C0090a());
        }

        @Override // org.android.agoo.assist.AssistCallback
        public void onRegisterVivo(@Nullable Context context) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1329496161")) {
                ipChange.ipc$dispatch("-1329496161", new Object[]{this, context});
                return;
            }
            PushClient.getInstance(context).initialize();
            PushClient.getInstance(context).turnOnPush(new b(context));
        }

        @Override // org.android.agoo.assist.AssistCallback
        public void onRegisterXiaomi(@Nullable Context context, @Nullable String str, @Nullable String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1626762942")) {
                ipChange.ipc$dispatch("-1626762942", new Object[]{this, context, str, str2});
                return;
            }
            MiPushClient.registerPush(context, str, str2);
        }
    }

    private PushAgent() {
    }

    @JvmStatic
    public static final void b(@NotNull Context context, @Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1341202008")) {
            ipChange.ipc$dispatch("-1341202008", new Object[]{context, str});
            return;
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        if (str == null) {
            ALog.e(a, "error,bindAccsUser userId==null", new Object[0]);
            return;
        }
        try {
            ACCSClient.getAccsClient("default").bindUser(str);
        } catch (Exception e2) {
            String message = e2.getMessage();
            if (message == null) {
                message = "";
            }
            AppMonitorAdapter.commitAlarmFail("accs_agoo", "status", "", "10003", message);
        }
        try {
            TaobaoRegister.setAlias(context, str, new PushAgent$bindAccsUser$1());
        } catch (Exception e3) {
            String message2 = e3.getMessage();
            if (message2 == null) {
                message2 = "";
            }
            AppMonitorAdapter.commitAlarmFail("accs_agoo", "status", "", ABLogRecorderKeys.EventIdLeaveAdjust, message2);
        }
    }

    @JvmStatic
    public static final void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1051437602")) {
            ipChange.ipc$dispatch("1051437602", new Object[0]);
            return;
        }
        IACCSConfigProvider iACCSConfigProvider = g;
        if (iACCSConfigProvider == null) {
            INSTANCE.q();
            return;
        }
        ACCSClient.getAccsClient("default").bindApp(iACCSConfigProvider.getTTid(), new f(iACCSConfigProvider));
    }

    @JvmStatic
    public static final void j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1207590046")) {
            ipChange.ipc$dispatch("-1207590046", new Object[0]);
            return;
        }
        try {
            IACCSConfigProvider iACCSConfigProvider = g;
            if (iACCSConfigProvider == null) {
                INSTANCE.q();
                return;
            }
            String appKey = iACCSConfigProvider.getAppKey();
            Context context = iACCSConfigProvider.getContext();
            ACCSManager.setAppkey(context, appKey, c);
            String inAppHost = iACCSConfigProvider.getInAppHost();
            String channelHost = iACCSConfigProvider.getChannelHost();
            ACCSClient.setEnvironment(context, c);
            if (iACCSConfigProvider.isDebuggable()) {
                ALog.setUseTlog(true);
            }
            AccsClientConfig.Builder builder = new AccsClientConfig.Builder();
            builder.setAppKey(appKey);
            builder.setTag("default");
            builder.setInappHost(inAppHost);
            builder.setChannelHost(channelHost);
            if (c == 2) {
                builder.setInappPubKey(0);
                builder.setChannelPubKey(0);
            } else {
                builder.setInappPubKey(10);
                builder.setChannelPubKey(10);
            }
            builder.setConfigEnv(c);
            ACCSClient.init(context, builder.build());
        } catch (AccsException e2) {
            e2.printStackTrace();
        }
    }

    @JvmStatic
    public static final void k() {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-453912341")) {
            ipChange.ipc$dispatch("-453912341", new Object[0]);
            return;
        }
        IACCSConfigProvider iACCSConfigProvider = g;
        if (iACCSConfigProvider == null) {
            INSTANCE.q();
            return;
        }
        Context context = iACCSConfigProvider.getContext();
        try {
            TaobaoRegister.setAccsConfigTag(context, "default");
        } catch (Exception e2) {
            String str2 = a;
            ALog.e(str2, "initAgooAccsChannel:error-" + e2.getMessage(), new Object[0]);
        }
        TaobaoRegister.setEnv(context, c);
        String agooMsgReceiveServiceName = iACCSConfigProvider.getAgooMsgReceiveServiceName();
        if (agooMsgReceiveServiceName == null || agooMsgReceiveServiceName.length() == 0) {
            str = "com.alibaba.pictures.accs.TaobaoIntentService";
        } else {
            str = iACCSConfigProvider.getAgooMsgReceiveServiceName();
        }
        TaobaoRegister.setAgooMsgReceiveService(str);
        TaobaoRegister.register(context, "default", iACCSConfigProvider.getAppKey(), null, iACCSConfigProvider.getTTid(), new PushAgent$initAgooAccsChannel$1());
        String userId = iACCSConfigProvider.getUserId();
        if (userId != null) {
            TaobaoRegister.setAlias(context, userId, new PushAgent$initAgooAccsChannel$2$1());
        } else {
            ALog.e(a, "bindAlias fail: userId null", new Object[0]);
        }
    }

    @JvmStatic
    public static final void l() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1090739628")) {
            ipChange.ipc$dispatch("1090739628", new Object[0]);
            return;
        }
        IACCSConfigProvider iACCSConfigProvider = g;
        if (iACCSConfigProvider == null) {
            INSTANCE.q();
        } else {
            AssistManager.init(iACCSConfigProvider.getContext(), new a());
        }
    }

    private final void q() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1375350132")) {
            ipChange.ipc$dispatch("-1375350132", new Object[]{this});
            return;
        }
        ALog.e(a, "you need invoke PushAgent.setConfigProvider() first!", new Object[0]);
        AppMonitorAdapter.commitAlarmFail("accs_agoo", "status", "", "10000", "not init!");
    }

    @JvmStatic
    public static final void r(@NotNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-860941129")) {
            ipChange.ipc$dispatch("-860941129", new Object[]{context});
            return;
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        try {
            ACCSClient.getAccsClient("default").unbindUser();
        } catch (Exception e2) {
            String message = e2.getMessage();
            if (message == null) {
                message = "";
            }
            AppMonitorAdapter.commitAlarmFail("accs_agoo", "status", "", ABLogRecorderKeys.EventIdEnterAct, message);
        }
        try {
            TaobaoRegister.removeAlias(context, new PushAgent$unbindAccsUser$1());
        } catch (Exception e3) {
            String message2 = e3.getMessage();
            if (message2 == null) {
                message2 = "";
            }
            AppMonitorAdapter.commitAlarmFail("accs_agoo", "status", "", "10008", message2);
        }
    }

    @Nullable
    public final IAccsServiceDelegate d() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1826451152")) {
            return d;
        }
        return (IAccsServiceDelegate) ipChange.ipc$dispatch("1826451152", new Object[]{this});
    }

    @Nullable
    public final IAgooServiceDelegate e() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1379814064")) {
            return e;
        }
        return (IAgooServiceDelegate) ipChange.ipc$dispatch("-1379814064", new Object[]{this});
    }

    @Nullable
    public final IACCSConfigProvider f() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-21311452")) {
            return g;
        }
        return (IACCSConfigProvider) ipChange.ipc$dispatch("-21311452", new Object[]{this});
    }

    @Nullable
    public final NotificationManager g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1140752405")) {
            return (NotificationManager) ipChange.ipc$dispatch("1140752405", new Object[]{this});
        }
        IACCSConfigProvider iACCSConfigProvider = g;
        if (iACCSConfigProvider == null) {
            q();
            return null;
        }
        Object systemService = iACCSConfigProvider.getContext().getSystemService("notification");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        return (NotificationManager) systemService;
    }

    @Nullable
    public final INotifyActionHandler h() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-446859152")) {
            return f;
        }
        return (INotifyActionHandler) ipChange.ipc$dispatch("-446859152", new Object[]{this});
    }

    public final boolean i() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1368811416")) {
            return b;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1368811416", new Object[]{this})).booleanValue();
    }

    public final void m(@Nullable IAccsServiceDelegate iAccsServiceDelegate) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-264303062")) {
            ipChange.ipc$dispatch("-264303062", new Object[]{this, iAccsServiceDelegate});
            return;
        }
        d = iAccsServiceDelegate;
    }

    public final void n(@Nullable IAgooServiceDelegate iAgooServiceDelegate) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1928826130")) {
            ipChange.ipc$dispatch("1928826130", new Object[]{this, iAgooServiceDelegate});
            return;
        }
        e = iAgooServiceDelegate;
    }

    public final void o(@Nullable IACCSConfigProvider iACCSConfigProvider) {
        IpChange ipChange = $ipChange;
        int i = 1;
        if (AndroidInstantRuntime.support(ipChange, "1692526822")) {
            ipChange.ipc$dispatch("1692526822", new Object[]{this, iACCSConfigProvider});
            return;
        }
        ACCSEnvMode aCCSEnvMode = null;
        if ((iACCSConfigProvider != null ? iACCSConfigProvider.getEnvMode() : null) == ACCSEnvMode.TEST) {
            i = 2;
        } else {
            if (iACCSConfigProvider != null) {
                aCCSEnvMode = iACCSConfigProvider.getEnvMode();
            }
            if (aCCSEnvMode != ACCSEnvMode.PRE) {
                i = 0;
            }
        }
        c = i;
        g = iACCSConfigProvider;
    }

    public final void p(@Nullable INotifyActionHandler iNotifyActionHandler) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1715754340")) {
            ipChange.ipc$dispatch("1715754340", new Object[]{this, iNotifyActionHandler});
            return;
        }
        f = iNotifyActionHandler;
    }
}
