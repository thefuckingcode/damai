package tb;

import android.content.Context;
import com.alibaba.pictures.cornerstone.protocol.ICloudConfig;
import com.alibaba.pictures.cornerstone.protocol.IInitProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.orange.OConfig;
import com.taobao.orange.OConstant;
import com.taobao.orange.OrangeConfig;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class jj implements IInitProxy<ICloudConfig> {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.alibaba.pictures.cornerstone.protocol.IInitProxy
    public void afterInit() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-15563979")) {
            ipChange.ipc$dispatch("-15563979", new Object[]{this});
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IInitProxy
    public boolean init(@Nullable Context context, @Nullable ua<ICloudConfig> uaVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-434084717")) {
            return ((Boolean) ipChange.ipc$dispatch("-434084717", new Object[]{this, context, uaVar})).booleanValue();
        }
        s6 s6Var = s6.INSTANCE;
        String versionName = s6Var.getVersionName();
        String str = "";
        if (versionName == null) {
            versionName = str;
        }
        String appKey = s6Var.getAppKey();
        if (appKey != null) {
            str = appKey;
        }
        e91 e91 = e91.INSTANCE;
        e91.d("CloudConfigProxyInit", "appVersion:" + versionName + ",appKey:" + str);
        int envMode = s6Var.getEnv().getEnvMode();
        OrangeConfig.getInstance().init(s6Var.getApplication(), new OConfig.Builder().setAppKey(str).setAppVersion(versionName).setEnv(envMode).setIndexUpdateMode(OConstant.UPDMODE.O_ALL.ordinal()).build());
        return true;
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IInitProxy
    public void preInit(@Nullable Context context, @Nullable ua<ICloudConfig> uaVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1681396668")) {
            ipChange.ipc$dispatch("-1681396668", new Object[]{this, context, uaVar});
        }
    }
}
