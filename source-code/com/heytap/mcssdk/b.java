package com.heytap.mcssdk;

import android.content.Context;
import android.content.Intent;
import com.heytap.mcssdk.e.c;
import com.heytap.msp.push.callback.IDataMessageCallBackService;
import com.heytap.msp.push.mode.BaseMode;
import java.util.List;
import tb.hu2;
import tb.l53;
import tb.w33;
import tb.y23;

/* compiled from: Taobao */
public class b {
    public static void a(final Context context, final Intent intent, final IDataMessageCallBackService iDataMessageCallBackService) {
        if (context == null) {
            w33.b("context is null , please check param of parseIntent()");
        } else if (intent == null) {
            w33.b("intent is null , please check param of parseIntent()");
        } else if (iDataMessageCallBackService == null) {
            w33.b("callback is null , please check param of parseIntent()");
        } else if (!hu2.h(context)) {
            w33.b("push is null ,please check system has push");
        } else {
            l53.a(new Runnable() {
                /* class com.heytap.mcssdk.b.AnonymousClass1 */

                public void run() {
                    List<BaseMode> a2 = y23.a(context, intent);
                    if (a2 != null) {
                        for (BaseMode baseMode : a2) {
                            if (baseMode != null) {
                                for (c cVar : c.m().r()) {
                                    if (cVar != null) {
                                        cVar.a(context, baseMode, iDataMessageCallBackService);
                                    }
                                }
                            }
                        }
                    }
                }
            });
        }
    }
}
