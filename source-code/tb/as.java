package tb;

import cn.damai.common.AppConfig;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.media.arch.instruments.utils.RemoteLogger;
import com.youku.playerservice.axp.DrmConfig;
import com.youku.playerservice.axp.axpinterface.PlayDefinition;
import com.youku.vpm.Callable;
import com.youku.vpm.constants.TableField;
import com.youku.youkuplayer.data.YKPlayerConfig;

/* compiled from: Taobao */
public class as extends YKPlayerConfig {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    public class a implements Callable {
        private static transient /* synthetic */ IpChange $ipChange;

        a(as asVar) {
        }

        /* renamed from: a */
        public String call(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1526364606")) {
                return (String) ipChange.ipc$dispatch("1526364606", new Object[]{this, str});
            }
            str.hashCode();
            return (str.equals(TableField.IS_VIP) || str.equals("isLogin")) ? "false" : "";
        }
    }

    /* compiled from: Taobao */
    public class b implements RemoteLogger.IRemoteAdapter {
        private static transient /* synthetic */ IpChange $ipChange;

        b(as asVar) {
        }

        @Override // com.youku.media.arch.instruments.utils.RemoteLogger.IRemoteAdapter
        public void log(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2021878461")) {
                ipChange.ipc$dispatch("-2021878461", new Object[]{this, str, str2});
                return;
            }
            h91.b(str, str2);
        }
    }

    public as() {
        super(xs0.a().getApplicationContext());
    }

    public YKPlayerConfig a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1595524921")) {
            return (YKPlayerConfig) ipChange.ipc$dispatch("-1595524921", new Object[]{this});
        }
        YKPlayerConfig yKPlayerConfig = new YKPlayerConfig(xs0.a().getApplicationContext());
        yKPlayerConfig.setAppKey(AppConfig.c());
        yKPlayerConfig.setCCode("01010121");
        yKPlayerConfig.setDisableAd(true);
        yKPlayerConfig.putString("hardwareDecode", "1");
        yKPlayerConfig.setDrmConfig(new DrmConfig("DM-Android", ""));
        yKPlayerConfig.setDisableAd(true);
        yKPlayerConfig.setDynamicProperties(new a(this));
        yKPlayerConfig.setNetworkType(PlayDefinition.NetworkType.HTTP);
        RemoteLogger.setRemoteAdapter(new b(this));
        return yKPlayerConfig;
    }
}
