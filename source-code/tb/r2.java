package tb;

import android.app.Application;
import android.content.Context;
import cn.damai.common.AppConfig;
import cn.damai.common.R$drawable;
import com.alibaba.pictures.accs.ACCSEnvMode;
import com.alibaba.pictures.accs.IACCSConfigProvider;
import com.alibaba.pictures.accs.MoiveAccsService;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class r2 implements IACCSConfigProvider {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final String a = "openacs.m.taobao.com";
    @NotNull
    private final String b = "openjmacs.m.taobao.com";
    @NotNull
    private final String c = "msgacs.waptest.taobao.com";
    @NotNull
    private final String d = "acs.waptest.taobao.com";
    @NotNull
    private final String e = "msgacs.wapa.taobao.com";
    @NotNull
    private final String f = "acs.wapa.taobao.com";
    @NotNull
    private final HashMap<String, String> g;

    /* compiled from: Taobao */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AppConfig.EnvMode.values().length];
            iArr[AppConfig.EnvMode.test.ordinal()] = 1;
            iArr[AppConfig.EnvMode.prepare.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public r2() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(s2.ACCS_CHANNEL, MoiveAccsService.class.getName());
        hashMap.put("orange", "com.taobao.orange.accssupport.OrangeAccsService");
        hashMap.put("login", "cn.damai.login.loginaccs.LoginAccsService");
        this.g = hashMap;
    }

    @Override // com.alibaba.pictures.accs.IACCSConfigProvider
    @Nullable
    public HashMap<String, String> getAccsServiceMap() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2068162041")) {
            return this.g;
        }
        return (HashMap) ipChange.ipc$dispatch("2068162041", new Object[]{this});
    }

    @Override // com.alibaba.pictures.accs.IACCSConfigProvider
    @Nullable
    public String getAgooMsgReceiveServiceName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1029756771")) {
            return null;
        }
        return (String) ipChange.ipc$dispatch("-1029756771", new Object[]{this});
    }

    @Override // com.alibaba.pictures.accs.IACCSConfigProvider
    @Nullable
    public Integer getAppIconRes() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "959675120")) {
            return Integer.valueOf(R$drawable.logo);
        }
        return (Integer) ipChange.ipc$dispatch("959675120", new Object[]{this});
    }

    @Override // com.alibaba.pictures.accs.IACCSConfigProvider
    @NotNull
    public String getAppKey() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2035331887")) {
            return (String) ipChange.ipc$dispatch("2035331887", new Object[]{this});
        }
        AppConfig.EnvMode g2 = AppConfig.g();
        if ((g2 == null ? -1 : a.$EnumSwitchMapping$0[g2.ordinal()]) == 1) {
            String f2 = AppConfig.f();
            k21.h(f2, "{\n                AppCon…tDebugKey()\n            }");
            return f2;
        }
        String k = AppConfig.k();
        k21.h(k, "{\n                AppCon…OnlineKey()\n            }");
        return k;
    }

    @Override // com.alibaba.pictures.accs.IACCSConfigProvider
    @Nullable
    public Integer getAppTinyIconRes() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1850055824")) {
            return Integer.valueOf(R$drawable.logo);
        }
        return (Integer) ipChange.ipc$dispatch("1850055824", new Object[]{this});
    }

    @Override // com.alibaba.pictures.accs.IACCSConfigProvider
    @NotNull
    public String getChannelHost() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1783379088")) {
            return (String) ipChange.ipc$dispatch("-1783379088", new Object[]{this});
        }
        AppConfig.EnvMode g2 = AppConfig.g();
        int i = g2 == null ? -1 : a.$EnumSwitchMapping$0[g2.ordinal()];
        if (i == 1) {
            return this.d;
        }
        if (i != 2) {
            return this.b;
        }
        return this.f;
    }

    @Override // com.alibaba.pictures.accs.IACCSConfigProvider
    @NotNull
    public Context getContext() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1400767932")) {
            return (Context) ipChange.ipc$dispatch("-1400767932", new Object[]{this});
        }
        Application a2 = xs0.a();
        k21.h(a2, "getApplication()");
        return a2;
    }

    @Override // com.alibaba.pictures.accs.IACCSConfigProvider
    @NotNull
    public ACCSEnvMode getEnvMode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1453437186")) {
            return (ACCSEnvMode) ipChange.ipc$dispatch("1453437186", new Object[]{this});
        }
        AppConfig.EnvMode g2 = AppConfig.g();
        int i = g2 == null ? -1 : a.$EnumSwitchMapping$0[g2.ordinal()];
        if (i == 1) {
            return ACCSEnvMode.TEST;
        }
        if (i != 2) {
            return ACCSEnvMode.RELEASE;
        }
        return ACCSEnvMode.PRE;
    }

    @Override // com.alibaba.pictures.accs.IACCSConfigProvider
    @NotNull
    public String getInAppHost() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "605669545")) {
            return (String) ipChange.ipc$dispatch("605669545", new Object[]{this});
        }
        AppConfig.EnvMode g2 = AppConfig.g();
        int i = g2 == null ? -1 : a.$EnumSwitchMapping$0[g2.ordinal()];
        if (i == 1) {
            return this.c;
        }
        if (i != 2) {
            return this.a;
        }
        return this.e;
    }

    @Override // com.alibaba.pictures.accs.IACCSConfigProvider
    @NotNull
    public String getTTid() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-622286036")) {
            return (String) ipChange.ipc$dispatch("-622286036", new Object[]{this});
        }
        String b2 = AppConfig.b();
        k21.h(b2, "getAppId()");
        return b2;
    }

    @Override // com.alibaba.pictures.accs.IACCSConfigProvider
    @Nullable
    public String getUserId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-450051849")) {
            return b20.c();
        }
        return (String) ipChange.ipc$dispatch("-450051849", new Object[]{this});
    }

    @Override // com.alibaba.pictures.accs.IACCSConfigProvider
    public boolean isDebuggable() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1069006801")) {
            return AppConfig.v();
        }
        return ((Boolean) ipChange.ipc$dispatch("1069006801", new Object[]{this})).booleanValue();
    }
}
