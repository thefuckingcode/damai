package com.xiaomi.mipush.sdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.HashMap;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class ap extends Handler {
    final /* synthetic */ ao a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ap(ao aoVar, Looper looper) {
        super(looper);
        this.a = aoVar;
    }

    public void dispatchMessage(Message message) {
        ao aoVar;
        HashMap<String, String> a2;
        ao aoVar2;
        if (message.what == 19) {
            String str = (String) message.obj;
            int i = message.arg1;
            synchronized (af.class) {
                if (af.a(ao.a(this.a)).m201a(str)) {
                    if (af.a(ao.a(this.a)).a(str) < 10) {
                        au auVar = au.DISABLE_PUSH;
                        if (auVar.ordinal() != i || !"syncing".equals(af.a(ao.a(this.a)).a(auVar))) {
                            auVar = au.ENABLE_PUSH;
                            if (auVar.ordinal() != i || !"syncing".equals(af.a(ao.a(this.a)).a(auVar))) {
                                au auVar2 = au.UPLOAD_HUAWEI_TOKEN;
                                if (auVar2.ordinal() != i || !"syncing".equals(af.a(ao.a(this.a)).a(auVar2))) {
                                    auVar2 = au.UPLOAD_FCM_TOKEN;
                                    if (auVar2.ordinal() != i || !"syncing".equals(af.a(ao.a(this.a)).a(auVar2))) {
                                        auVar2 = au.UPLOAD_COS_TOKEN;
                                        if (auVar2.ordinal() != i || !"syncing".equals(af.a(ao.a(this.a)).a(auVar2))) {
                                            auVar2 = au.UPLOAD_FTOS_TOKEN;
                                            if (auVar2.ordinal() == i && "syncing".equals(af.a(ao.a(this.a)).a(auVar2))) {
                                                aoVar = this.a;
                                                a2 = i.m237a(ao.a(aoVar), e.ASSEMBLE_PUSH_FTOS);
                                            }
                                            af.a(ao.a(this.a)).b(str);
                                        } else {
                                            aoVar = this.a;
                                            a2 = i.m237a(ao.a(aoVar), e.ASSEMBLE_PUSH_COS);
                                        }
                                    } else {
                                        aoVar = this.a;
                                        a2 = i.m237a(ao.a(aoVar), e.ASSEMBLE_PUSH_FCM);
                                    }
                                } else {
                                    aoVar = this.a;
                                    a2 = i.m237a(ao.a(aoVar), e.ASSEMBLE_PUSH_HUAWEI);
                                }
                                aoVar.a((ao) str, (String) auVar2, (au) false, (boolean) a2);
                                af.a(ao.a(this.a)).b(str);
                            } else {
                                aoVar2 = this.a;
                            }
                        } else {
                            aoVar2 = this.a;
                        }
                        aoVar2.a((ao) str, (String) auVar, (au) true, (boolean) null);
                        af.a(ao.a(this.a)).b(str);
                    } else {
                        af.a(ao.a(this.a)).c(str);
                    }
                }
            }
        }
    }
}
