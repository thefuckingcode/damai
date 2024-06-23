package tb;

import cn.damai.common.nav.DMNav;
import cn.damai.commonbusiness.nav.NavHandler;
import cn.damai.commonbusiness.nav.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ah1 {
    private static transient /* synthetic */ IpChange $ipChange;

    public void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1081313083")) {
            ipChange.ipc$dispatch("1081313083", new Object[]{this});
            return;
        }
        try {
            DMNav.registerStickPreprocessor(new a());
            DMNav.registerStickPreprocessor(new e81());
            DMNav.registerStickPreprocessor(new rb0());
            DMNav.registerPreprocessor(new r4());
            DMNav.setExceptionHandler(new NavHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
