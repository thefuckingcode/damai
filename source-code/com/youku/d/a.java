package com.youku.d;

import android.content.Context;
import com.taobao.tao.remotebusiness.login.RemoteLogin;
import com.youku.config.YoukuConfig;
import com.youku.core.context.YoukuContext;
import com.youku.httpcommunication.c;
import com.youku.service.util.YoukuUtil;
import com.youku.usercenter.passport.api.LoginImpl;
import com.youku.usercenter.passport.api.TaobaoLoginImpl;
import java.lang.reflect.Field;
import mtopsdk.common.log.TLogAdapterImpl;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.domain.EnvModeEnum;
import mtopsdk.mtop.global.MtopConfig;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.intf.MtopEnablePropertyType;
import mtopsdk.mtop.intf.MtopSetting;

/* compiled from: Taobao */
public class a {
    private static Mtop a;
    private static Mtop b;
    private static volatile boolean c;
    private static String d;

    public static synchronized Mtop a() {
        Mtop mtop;
        synchronized (a.class) {
            if (!c) {
                a(YoukuContext.getApplicationContext(), YoukuContext.getVersionName(), YoukuUtil.getTTID(), null);
            }
            a(a);
            mtop = a;
        }
        return mtop;
    }

    private static void a(Context context, String str, String str2) {
        EnvModeEnum envModeEnum;
        MtopSetting.setAppKeyIndex("havana-instance-taobao", 0, 2);
        MtopSetting.setAppVersion("havana-instance-taobao", str);
        MtopConfig mtopConfig = new MtopConfig("havana-instance-taobao");
        if (YoukuConfig.getEnvType() != 0) {
            if (YoukuConfig.getEnvType() == 1) {
                envModeEnum = EnvModeEnum.PREPARE;
            } else if (YoukuConfig.getEnvType() == 2) {
                envModeEnum = EnvModeEnum.TEST;
            }
            mtopConfig.envMode = envModeEnum;
            Mtop registerTtid = Mtop.instance("havana-instance-taobao", context, str2, 0, mtopConfig).registerTtid(str2);
            b = registerTtid;
            RemoteLogin.setLoginImpl(registerTtid, new TaobaoLoginImpl());
        }
        envModeEnum = EnvModeEnum.ONLINE;
        mtopConfig.envMode = envModeEnum;
        Mtop registerTtid2 = Mtop.instance("havana-instance-taobao", context, str2, 0, mtopConfig).registerTtid(str2);
        b = registerTtid2;
        try {
            RemoteLogin.setLoginImpl(registerTtid2, new TaobaoLoginImpl());
        } catch (Throwable th) {
            com.youku.httpcommunication.a.a("MTopManager", th);
        }
    }

    private static void a(Context context, String str, String str2, String str3) {
        b(context, str, str2, str3);
        a(context, str, str2);
    }

    private static void a(Mtop mtop) {
        EnvModeEnum envModeEnum;
        if (YoukuConfig.getEnvType() != 0 && mtop != null) {
            EnvModeEnum envModeEnum2 = null;
            if ((YoukuConfig.getEnvType() == 1 && mtop.getMtopConfig().envMode != (envModeEnum = EnvModeEnum.PREPARE)) || (YoukuConfig.getEnvType() == 2 && mtop.getMtopConfig().envMode != (envModeEnum = EnvModeEnum.TEST))) {
                envModeEnum2 = envModeEnum;
            }
            if (envModeEnum2 != null) {
                try {
                    Field declaredField = Mtop.class.getDeclaredField("mtopConfig");
                    declaredField.setAccessible(true);
                    ((MtopConfig) declaredField.get(mtop)).envMode = envModeEnum2;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static synchronized String b() {
        String str;
        synchronized (a.class) {
            str = d;
        }
        return str;
    }

    private static void b(Context context, String str, String str2, String str3) {
        EnvModeEnum envModeEnum;
        TBSdkLog.setLogAdapter(new TLogAdapterImpl());
        MtopSetting.setEnableProperty(Mtop.Id.INNER, MtopEnablePropertyType.ENABLE_NEW_DEVICE_ID, false);
        MtopSetting.setEnableProperty(Mtop.Id.INNER, MtopEnablePropertyType.ENABLE_NOTIFY_SESSION_RET, true);
        MtopSetting.setAppKeyIndex(Mtop.Id.INNER, 0, 2);
        MtopSetting.setAppVersion(Mtop.Id.INNER, str);
        MtopSetting.setMtopDomain(Mtop.Id.INNER, "acs.youku.com", "pre-acs.youku.com", "daily-acs.youku.com");
        d = str2;
        MtopConfig mtopConfig = new MtopConfig(Mtop.Id.INNER);
        if (YoukuConfig.getEnvType() != 0) {
            if (YoukuConfig.getEnvType() == 1) {
                envModeEnum = EnvModeEnum.PREPARE;
            } else if (YoukuConfig.getEnvType() == 2) {
                envModeEnum = EnvModeEnum.TEST;
            }
            mtopConfig.envMode = envModeEnum;
            Mtop registerTtid = Mtop.instance(Mtop.Id.INNER, context, str2, 0, mtopConfig).registerTtid(str2);
            a = registerTtid;
            RemoteLogin.setLoginImpl(registerTtid, new LoginImpl());
            c = true;
            c.a();
        }
        envModeEnum = EnvModeEnum.ONLINE;
        mtopConfig.envMode = envModeEnum;
        Mtop registerTtid2 = Mtop.instance(Mtop.Id.INNER, context, str2, 0, mtopConfig).registerTtid(str2);
        a = registerTtid2;
        try {
            RemoteLogin.setLoginImpl(registerTtid2, new LoginImpl());
        } catch (Throwable th) {
            com.youku.httpcommunication.a.a("MTopManager", th);
        }
        c = true;
        c.a();
    }
}
