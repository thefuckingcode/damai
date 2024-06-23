package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class xg2 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static final void a(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-576245185")) {
            ipChange.ipc$dispatch("-576245185", new Object[]{str, str2, str3, str4, str5, Boolean.valueOf(z)});
            return;
        }
        k21.i(str, "bizSceneStr");
        k21.i(str2, "point");
        k21.i(str3, "arg");
        k21.i(str4, "errorCode");
        k21.i(str5, "errorMsg");
        try {
            d03 d03 = new d03();
            HashMap hashMap = new HashMap();
            hashMap.put("arg", str3);
            d03.setExtral(hashMap);
            d03.setBizCode(str4);
            d03.setBizMsg(str5);
            d03.setBizScene(str);
            d03.setMPointName(str2);
            d03.setResultExpected(z);
            d03.release();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println((Object) String.valueOf(ur2.INSTANCE));
        }
    }
}
