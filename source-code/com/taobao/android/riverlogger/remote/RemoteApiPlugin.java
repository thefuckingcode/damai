package com.taobao.android.riverlogger.remote;

import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.text.TextUtils;
import com.taobao.android.riverlogger.RVLRemoteConnectCallback;
import com.taobao.android.riverlogger.RVLRemoteInfo;

/* compiled from: Taobao */
public class RemoteApiPlugin extends WVApiPlugin {

    /* compiled from: Taobao */
    class a implements RVLRemoteConnectCallback {
        final /* synthetic */ WVCallBackContext a;

        a(RemoteApiPlugin remoteApiPlugin, WVCallBackContext wVCallBackContext) {
            this.a = wVCallBackContext;
        }

        @Override // com.taobao.android.riverlogger.RVLRemoteConnectCallback
        public void finish(boolean z, String str) {
            WVResult wVResult = new WVResult();
            if (z) {
                this.a.success(wVResult);
                return;
            }
            wVResult.addData("msg", str);
            this.a.error(wVResult);
        }
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if (!TextUtils.equals(str, "openRemote")) {
            return false;
        }
        b.d(RVLRemoteInfo.f(str2), new a(this, wVCallBackContext));
        return true;
    }
}
