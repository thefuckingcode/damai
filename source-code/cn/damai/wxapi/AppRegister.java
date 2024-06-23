package cn.damai.wxapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import tb.z10;

/* compiled from: Taobao */
public class AppRegister extends BroadcastReceiver {
    private static transient /* synthetic */ IpChange $ipChange;

    public void onReceive(Context context, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1545276825")) {
            ipChange.ipc$dispatch("-1545276825", new Object[]{this, context, intent});
            return;
        }
        WXAPIFactory.createWXAPI(context, null).registerApp(z10.a(WXEntryActivity.APP_ID_CRYPT));
    }
}
