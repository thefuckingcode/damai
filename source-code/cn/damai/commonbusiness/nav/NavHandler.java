package cn.damai.commonbusiness.nav;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.h5container.UniH5ContainerSwitcher;
import com.alibaba.security.common.track.model.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.gr;
import tb.xf2;
import tb.xs0;
import tb.yj1;

/* compiled from: Taobao */
public class NavHandler implements DMNav.NavExceptionHandler {
    private static transient /* synthetic */ IpChange $ipChange;

    public Uri getStackUriProxy(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "109999505")) {
            return (Uri) ipChange.ipc$dispatch("109999505", new Object[]{this, intent});
        } else if (intent == null || !"true".equals(intent.getStringExtra(yj1.KEY_DMNAV_PUSH_FLAT))) {
            return null;
        } else {
            return Uri.parse("damai://home");
        }
    }

    @Override // cn.damai.common.nav.DMNav.NavExceptionHandler
    public boolean onException(Intent intent, Exception exc) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-646170940")) {
            return ((Boolean) ipChange.ipc$dispatch("-646170940", new Object[]{this, intent, exc})).booleanValue();
        }
        if (!(intent == null || xs0.a() == null)) {
            String dataString = intent.getDataString();
            if (!xf2.j(dataString) && dataString.trim().startsWith("http")) {
                Bundle bundle = new Bundle();
                bundle.putAll(intent.getExtras());
                bundle.putString("url", dataString.trim());
                if (UniH5ContainerSwitcher.getInstance().shouldInterceptUrl(dataString)) {
                    DMNav.from(xs0.a()).stack(getStackUriProxy(intent)).withExtras(bundle).toUri(NavUri.b(gr.u));
                } else {
                    DMNav.from(xs0.a()).stack(getStackUriProxy(intent)).withExtras(bundle).toUri(NavUri.b(a.c.d));
                }
            }
        }
        return false;
    }
}
