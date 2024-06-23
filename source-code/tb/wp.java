package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.Map;

/* compiled from: Taobao */
public class wp extends zp {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static String c = "cn.movieshow.app/Alarm";

    @Override // tb.zp
    public String a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "619856791")) {
            return c;
        }
        return (String) ipChange.ipc$dispatch("619856791", new Object[]{this});
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler, tb.zp
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1507527837")) {
            ipChange.ipc$dispatch("-1507527837", new Object[]{this, methodCall, result});
            return;
        }
        String str = methodCall.method;
        str.hashCode();
        if (!str.equals("alarmCommitFail")) {
            result.notImplemented();
            return;
        }
        Map map = (Map) methodCall.arguments;
        String str2 = map.containsKey("page") ? (String) map.get("page") : "FLUTTER_PAGE";
        String str3 = map.containsKey("pointName") ? (String) map.get("pointName") : "FLUTTER_ERROR";
        String str4 = map.containsKey("code") ? (String) map.get("code") : "-70000";
        String str5 = "";
        String str6 = map.containsKey("msg") ? (String) map.get("msg") : str5;
        if (map.containsKey("args")) {
            str5 = (String) map.get("args");
        }
        yz2.b(str2, str3, str6, str4, str5);
        result.success(null);
    }
}
