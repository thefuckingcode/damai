package tb;

import android.text.TextUtils;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.HashMap;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class xz2 {
    @NotNull
    public static final xz2 INSTANCE = new xz2();
    @NotNull
    private static String a = AgooConstants.MESSAGE_POPUP;
    @NotNull
    private static String b = "failureMonitor";

    private xz2() {
    }

    private final void c(String str, String str2, String str3, String str4, String str5, boolean z) {
        try {
            c03 c03 = new c03();
            if (str3 != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("arg", str3);
                ur2 ur2 = ur2.INSTANCE;
                c03.setExtral(hashMap);
            }
            c03.setBizCode(str4);
            c03.setBizMsg(str5);
            c03.setBizScene(str);
            c03.setMPointName(str2);
            c03.setResultExpected(z);
            c03.release();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println((Object) String.valueOf(ur2.INSTANCE));
        }
    }

    public final void a(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        if (!AppInfoProviderProxy.isDebuggable()) {
            try {
                AppMonitor.Alarm.commitFail(a, b, str, str2, str3);
                c(a, b, str, str2, str3, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Nullable
    public final String b(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        StringBuilder sb = new StringBuilder();
        sb.append(jl1.BLOCK_START_STR);
        if (!TextUtils.isEmpty(str)) {
            sb.append(k21.r(" api:", str));
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append(k21.r(", apiName:", str2));
        }
        if (!TextUtils.isEmpty(str5)) {
            sb.append(k21.r(AVFSCacheConstants.COMMA_SEP, str5));
        }
        if (!TextUtils.isEmpty(str3)) {
            sb.append(k21.r(", retCode:", str3));
        }
        if (!TextUtils.isEmpty(str4)) {
            sb.append(k21.r(", retMsg:", str4));
        }
        sb.append(" }");
        return sb.toString();
    }
}
