package com.heytap.mcssdk.e;

import android.content.Context;
import com.heytap.mcssdk.c;
import com.heytap.mcssdk.constant.MessageConstant$CommandId;
import com.heytap.msp.push.callback.ICallBackResultService;
import com.heytap.msp.push.callback.IDataMessageCallBackService;
import com.heytap.msp.push.callback.IGetAppNotificationCallBackService;
import com.heytap.msp.push.callback.ISetAppNotificationCallBackService;
import com.heytap.msp.push.mode.BaseMode;
import tb.a23;
import tb.hu2;
import tb.l53;
import tb.w33;

/* compiled from: Taobao */
public class a implements c {
    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void c(a23 a23, c cVar) {
        String str;
        if (a23 == null) {
            str = "message is null , please check param of parseCommandMessage(2)";
        } else if (cVar == null) {
            str = "pushService is null , please check param of parseCommandMessage(2)";
        } else if (cVar.s() == null) {
            str = "pushService.getPushCallback() is null , please check param of parseCommandMessage(2)";
        } else {
            int f = a23.f();
            if (f == 12287) {
                ICallBackResultService s = cVar.s();
                if (s != null) {
                    s.onError(a23.j(), a23.h());
                    return;
                }
                return;
            } else if (f == 12298) {
                cVar.s().onSetPushTime(a23.j(), a23.h());
                return;
            } else if (f == 12306) {
                cVar.s().onGetPushStatus(a23.j(), hu2.i(a23.h()));
                return;
            } else if (f == 12309) {
                cVar.s().onGetNotificationStatus(a23.j(), hu2.i(a23.h()));
                return;
            } else if (f == 12289) {
                if (a23.j() == 0) {
                    cVar.setRegisterID(a23.h());
                }
                cVar.s().onRegister(a23.j(), a23.h());
                return;
            } else if (f != 12290) {
                switch (f) {
                    case MessageConstant$CommandId.COMMAND_APP_NOTIFICATION_OPEN:
                    case MessageConstant$CommandId.COMMAND_APP_NOTIFICATION_CLOSE:
                        ISetAppNotificationCallBackService u = cVar.u();
                        if (u != null) {
                            u.onSetAppNotificationSwitch(a23.j());
                            return;
                        }
                        return;
                    case MessageConstant$CommandId.COMMAND_APP_NOTIFICATION_GET:
                        int i = 0;
                        try {
                            i = Integer.parseInt(a23.h());
                        } catch (Exception unused) {
                        }
                        IGetAppNotificationCallBackService t = cVar.t();
                        if (t != null) {
                            t.onGetAppNotificationSwitch(a23.j(), i);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            } else {
                cVar.s().onUnRegister(a23.j());
                return;
            }
        }
        w33.b(str);
    }

    @Override // com.heytap.mcssdk.e.c
    public void a(Context context, BaseMode baseMode, IDataMessageCallBackService iDataMessageCallBackService) {
        if (baseMode != null && baseMode.getType() == 4105) {
            final a23 a23 = (a23) baseMode;
            w33.a("mcssdk-CallBackResultProcessor:" + a23.toString());
            l53.b(new Runnable() {
                /* class com.heytap.mcssdk.e.a.AnonymousClass1 */

                public void run() {
                    a.this.c(a23, c.m());
                }
            });
        }
    }
}
