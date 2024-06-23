package tb;

import cn.damai.category.categorygirl.ui.GirlShowAllActivity;
import cn.damai.common.OrangeConfigCenter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.orange.OrangeConfig;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.Map;

/* compiled from: Taobao */
public class pl1 extends zp {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static String c = "cn.movieshow.app/Orange";

    @Override // tb.zp
    public String a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "62333618")) {
            return c;
        }
        return (String) ipChange.ipc$dispatch("62333618", new Object[]{this});
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler, tb.zp
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1517768616")) {
            ipChange.ipc$dispatch("1517768616", new Object[]{this, methodCall, result});
            return;
        }
        Map map = (Map) methodCall.arguments;
        String str = methodCall.method;
        str.hashCode();
        if (str.equals("fetchOrangeConfigByGroupName")) {
            try {
                result.success(OrangeConfig.getInstance().getConfigs((String) map.get(GirlShowAllActivity.KEY_GROUPNAME)));
            } catch (Throwable th) {
                th.printStackTrace();
                result.success(null);
            }
        } else if (!str.equals("fetchOrangeConfig")) {
            result.notImplemented();
        } else {
            result.success(OrangeConfigCenter.c().b((String) map.get(GirlShowAllActivity.KEY_GROUPNAME), (String) map.get("key"), map.containsKey("defaultValue") ? (String) map.get("defaultValue") : ""));
        }
    }
}
