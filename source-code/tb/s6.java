package tb;

import android.app.Application;
import android.content.Context;
import com.alibaba.pictures.cornerstone.EnvMode;
import com.alibaba.pictures.cornerstone.protocol.IAppInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class s6 extends ua<IAppInfo> implements IAppInfo {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final s6 INSTANCE;

    static {
        s6 s6Var = new s6();
        INSTANCE = s6Var;
        ua.f(s6Var, new r6(), null, 2, null);
    }

    private s6() {
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IAppInfo
    public boolean debugable() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1338003244")) {
            return ((IAppInfo) a()).debugable();
        }
        return ((Boolean) ipChange.ipc$dispatch("1338003244", new Object[]{this})).booleanValue();
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IAppInfo
    @NotNull
    public String getAppClientName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1479388532")) {
            return ((IAppInfo) a()).getAppClientName();
        }
        return (String) ipChange.ipc$dispatch("-1479388532", new Object[]{this});
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IAppInfo
    @NotNull
    public Context getAppContext() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1513826903")) {
            return ((IAppInfo) a()).getAppContext();
        }
        return (Context) ipChange.ipc$dispatch("-1513826903", new Object[]{this});
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IAppInfo
    @Nullable
    public String getAppKey() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1579890239")) {
            return ((IAppInfo) a()).getAppKey();
        }
        return (String) ipChange.ipc$dispatch("1579890239", new Object[]{this});
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IAppInfo
    @NotNull
    public Application getApplication() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-253601046")) {
            return ((IAppInfo) a()).getApplication();
        }
        return (Application) ipChange.ipc$dispatch("-253601046", new Object[]{this});
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IAppInfo
    @Nullable
    public String getChannelId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1744136595")) {
            return ((IAppInfo) a()).getChannelId();
        }
        return (String) ipChange.ipc$dispatch("1744136595", new Object[]{this});
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IAppInfo
    @NotNull
    public EnvMode getEnv() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2049319023")) {
            return ((IAppInfo) a()).getEnv();
        }
        return (EnvMode) ipChange.ipc$dispatch("2049319023", new Object[]{this});
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IAppInfo
    @Nullable
    public String getPackageName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1292092934")) {
            return ((IAppInfo) a()).getPackageName();
        }
        return (String) ipChange.ipc$dispatch("1292092934", new Object[]{this});
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IAppInfo
    @Nullable
    public String getTTID() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1949127108")) {
            return ((IAppInfo) a()).getTTID();
        }
        return (String) ipChange.ipc$dispatch("-1949127108", new Object[]{this});
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IAppInfo
    @Nullable
    public Integer getVersionCode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1010001907")) {
            return ((IAppInfo) a()).getVersionCode();
        }
        return (Integer) ipChange.ipc$dispatch("-1010001907", new Object[]{this});
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IAppInfo
    @Nullable
    public String getVersionName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1046976664")) {
            return ((IAppInfo) a()).getVersionName();
        }
        return (String) ipChange.ipc$dispatch("1046976664", new Object[]{this});
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IAppInfo
    public boolean isFullApp() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-135672079")) {
            return ((IAppInfo) a()).isFullApp();
        }
        return ((Boolean) ipChange.ipc$dispatch("-135672079", new Object[]{this})).booleanValue();
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IAppInfo
    public boolean isPreInstall() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "864557303")) {
            return ((IAppInfo) a()).isPreInstall();
        }
        return ((Boolean) ipChange.ipc$dispatch("864557303", new Object[]{this})).booleanValue();
    }
}
