package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.ui.component.WXWeb;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

/* compiled from: Taobao */
public class j9 extends zp {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static String c = "cn.movieshow.app/nativeback";

    @Override // tb.zp
    public String a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1759449426")) {
            return c;
        }
        return (String) ipChange.ipc$dispatch("1759449426", new Object[]{this});
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler, tb.zp
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-529386232")) {
            ipChange.ipc$dispatch("-529386232", new Object[]{this, methodCall, result});
            return;
        }
        String str = methodCall.method;
        str.hashCode();
        if (!str.equals(WXWeb.GO_BACK)) {
            result.notImplemented();
            return;
        }
        b().onBackPressed();
        result.success(null);
    }
}
