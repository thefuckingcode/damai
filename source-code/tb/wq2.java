package tb;

import android.text.TextUtils;
import cn.damai.common.user.a;
import cn.damai.common.user.c;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class wq2 extends zp {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static String c = "cn.movieshow.app/UT";

    private a.b c(String str, String str2, String str3, String str4, Map map, boolean z) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-102940703")) {
            return new a.b().i(str).f(str2).l(str3).c(str4).g(z).j(map);
        }
        return (a.b) ipChange.ipc$dispatch("-102940703", new Object[]{this, str, str2, str3, str4, map, Boolean.valueOf(z)});
    }

    @Override // tb.zp
    public String a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "413927666")) {
            return c;
        }
        return (String) ipChange.ipc$dispatch("413927666", new Object[]{this});
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0140, code lost:
        if (r0.equals("pageDisAppear") == false) goto L_0x0101;
     */
    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler, tb.zp
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str;
        String str2;
        String str3;
        String str4;
        IpChange ipChange = $ipChange;
        char c2 = 2;
        if (AndroidInstantRuntime.support(ipChange, "-1003409048")) {
            ipChange.ipc$dispatch("-1003409048", new Object[]{this, methodCall, result});
            return;
        }
        Map map = (Map) methodCall.arguments;
        long j = 0;
        HashMap hashMap = new HashMap();
        if (map.containsKey("bPointName")) {
            str = (String) map.get("bPointName");
        } else {
            str = "";
        }
        if (map.containsKey("cPointName")) {
            str2 = (String) map.get("cPointName");
        } else {
            str2 = "";
        }
        if (map.containsKey("dPointName")) {
            str3 = (String) map.get("dPointName");
        } else {
            str3 = "";
        }
        if (map.containsKey("controlName")) {
            str4 = (String) map.get("controlName");
        } else {
            str4 = "";
        }
        if (map.containsKey("properties")) {
            hashMap = (HashMap) map.get("properties");
        }
        boolean booleanValue = map.containsKey("updateToNextPage") ? ((Boolean) map.get("updateToNextPage")).booleanValue() : false;
        if (map.containsKey("duration")) {
            j = (long) ((Integer) map.get("duration")).intValue();
        }
        int intValue = (!map.containsKey("eventId") || TextUtils.isEmpty((String) map.get("eventId"))) ? 0 : Integer.valueOf((String) map.get("eventId")).intValue();
        if (map.containsKey("eventLabel")) {
            String str5 = (String) map.get("eventLabel");
        }
        if (map.containsKey("pageName")) {
            String str6 = (String) map.get("pageName");
        }
        HashMap hashMap2 = hashMap == null ? new HashMap() : hashMap;
        String str7 = methodCall.method;
        str7.hashCode();
        switch (str7.hashCode()) {
            case -1801488983:
                if (str7.equals("customEvent")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -1156050047:
                if (str7.equals("clickWithCDPoint")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case -1025553932:
                break;
            case -734314539:
                if (str7.equals("reportCustomEvent")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 768062724:
                if (str7.equals("pageAppear")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 1729443235:
                if (str7.equals("updatePageName")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case 1773339218:
                if (str7.equals("updatePageAndProperties")) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case 2085223132:
                if (str7.equals("updateProperties")) {
                    c2 = 7;
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
                c.e().A(hashMap2, str3, str);
                result.success(null);
                return;
            case 1:
                c.e().x(c(str, str2, str3, str4, hashMap2, booleanValue));
                result.success(null);
                return;
            case 2:
                c.e().t(b());
                result.success(null);
                return;
            case 3:
                c.e().C(str3, str2, str, "1.0", j, hashMap2, intValue);
                result.success(null);
                return;
            case 4:
                a.b bVar = new a.b();
                bVar.i(str);
                bVar.j(hashMap2);
                c.e().k(b(), bVar);
                result.success(null);
                return;
            case 5:
                c.e().L(b(), str);
                if (b().getIntent() != null) {
                    b().getIntent().putExtra("dm_pageName", str);
                }
                result.success(null);
                return;
            case 6:
                a.b bVar2 = new a.b();
                bVar2.i(str);
                bVar2.j(hashMap2);
                c.e().L(b(), str);
                c.e().l(b(), bVar2);
                result.success(null);
                return;
            case 7:
                c.e().O(b(), hashMap2);
                result.success(null);
                return;
            default:
                result.notImplemented();
                return;
        }
    }
}
