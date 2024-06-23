package tb;

import cn.damai.fluttercommon.DMNFCActivity;
import cn.damai.ticket.nfc.NfcUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class kg1 extends zp {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static String c = "cn.movieshow.app/Ticket";

    /* access modifiers changed from: protected */
    @Override // tb.zp
    public String a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "85275034")) {
            return c;
        }
        return (String) ipChange.ipc$dispatch("85275034", new Object[]{this});
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0059, code lost:
        if (r9.equals("isSupportNFC") == false) goto L_0x0046;
     */
    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler, tb.zp
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        IpChange ipChange = $ipChange;
        char c2 = 2;
        if (AndroidInstantRuntime.support(ipChange, "1230921152")) {
            ipChange.ipc$dispatch("1230921152", new Object[]{this, methodCall, result});
            return;
        }
        Map map = (Map) methodCall.arguments;
        NfcUtil nfcUtil = b() instanceof DMNFCActivity ? ((DMNFCActivity) b()).getNfcUtil() : null;
        if (nfcUtil == null) {
            result.success(null);
            return;
        }
        String str = methodCall.method;
        str.hashCode();
        switch (str.hashCode()) {
            case -1200178928:
                if (str.equals("closeTicketByNFC")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 329759243:
                if (str.equals("isNFCOpen")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 1557357606:
                break;
            case 1924800629:
                if (str.equals("launchTicketByNFC")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
                nfcUtil.h();
                result.success(null);
                return;
            case 1:
                HashMap hashMap = new HashMap();
                if (!nfcUtil.e()) {
                    hashMap.put("isOpen", "0");
                } else {
                    hashMap.put("isOpen", "1");
                }
                result.success(hashMap);
                return;
            case 2:
                HashMap hashMap2 = new HashMap();
                if (!nfcUtil.f()) {
                    hashMap2.put("isSupport", "0");
                } else {
                    hashMap2.put("isSupport", "1");
                }
                result.success(hashMap2);
                return;
            case 3:
                nfcUtil.o();
                result.success(null);
                return;
            default:
                result.notImplemented();
                return;
        }
    }
}
