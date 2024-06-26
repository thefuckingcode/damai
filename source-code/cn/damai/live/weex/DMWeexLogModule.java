package cn.damai.live.weex;

import android.os.Handler;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;
import tb.br;

/* compiled from: Taobao */
public class DMWeexLogModule extends WXModule {
    private static transient /* synthetic */ IpChange $ipChange;

    @JSMethod
    public void log(final String str, JSCallback jSCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1555805491")) {
            ipChange.ipc$dispatch("-1555805491", new Object[]{this, str, jSCallback});
            return;
        }
        Log.d("DMWeexLog", str);
        new Handler().postDelayed(new Runnable() {
            /* class cn.damai.live.weex.DMWeexLogModule.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1508275389")) {
                    ipChange.ipc$dispatch("1508275389", new Object[]{this});
                    return;
                }
                br.c("weexLog", str);
            }
        }, 200);
    }
}
