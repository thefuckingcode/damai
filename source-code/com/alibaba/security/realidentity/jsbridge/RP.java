package com.alibaba.security.realidentity.jsbridge;

import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;

/* compiled from: Taobao */
public class RP extends WVApiPlugin {
    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, final WVCallBackContext wVCallBackContext) {
        return g.a(this.mContext, str, str2, new h() {
            /* class com.alibaba.security.realidentity.jsbridge.RP.AnonymousClass1 */

            @Override // com.alibaba.security.realidentity.jsbridge.h
            public final void a(WVResult wVResult) {
                WVCallBackContext wVCallBackContext = wVCallBackContext;
                if (wVCallBackContext != null) {
                    wVCallBackContext.error(wVResult);
                }
            }

            @Override // com.alibaba.security.realidentity.jsbridge.h
            public final void b(WVResult wVResult) {
                WVCallBackContext wVCallBackContext = wVCallBackContext;
                if (wVCallBackContext != null) {
                    wVCallBackContext.success(wVResult);
                }
            }

            @Override // com.alibaba.security.realidentity.jsbridge.h
            public final void a(String str) {
                WVCallBackContext wVCallBackContext = wVCallBackContext;
                if (wVCallBackContext != null) {
                    wVCallBackContext.error(str);
                }
            }

            @Override // com.alibaba.security.realidentity.jsbridge.h
            public final void b() {
                WVCallBackContext wVCallBackContext = wVCallBackContext;
                if (wVCallBackContext != null) {
                    wVCallBackContext.success();
                }
            }

            @Override // com.alibaba.security.realidentity.jsbridge.h
            public final void a() {
                WVCallBackContext wVCallBackContext = wVCallBackContext;
                if (wVCallBackContext != null) {
                    wVCallBackContext.error();
                }
            }

            @Override // com.alibaba.security.realidentity.jsbridge.h
            public final void b(String str) {
                WVCallBackContext wVCallBackContext = wVCallBackContext;
                if (wVCallBackContext != null) {
                    wVCallBackContext.success(str);
                }
            }

            @Override // com.alibaba.security.realidentity.jsbridge.h
            public final void a(String str, String str2) {
                WVCallBackContext wVCallBackContext = wVCallBackContext;
                if (wVCallBackContext != null) {
                    wVCallBackContext.fireEvent(str, str2);
                }
            }
        });
    }
}
