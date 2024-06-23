package com.taobao.monitor.adapter.network;

import com.alibaba.motu.tbrest.SendService;
import com.taobao.monitor.network.INetworkSender;
import java.util.List;
import tb.i20;
import tb.qh2;
import tb.t91;
import tb.uk2;

/* compiled from: Taobao */
public class TBRestSender implements INetworkSender {
    private final Integer a = 61004;
    private final String b = null;
    private boolean c = true;
    private ILiteDb d = new a();

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void f(String str, String str2) {
        ILiteDb iLiteDb = this.d;
        iLiteDb.insert(str + "HA_APM_______HA_APM" + str2);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean g(String str, String str2) {
        return SendService.getInstance().sendRequest(this.b, System.currentTimeMillis(), null, this.a.intValue(), "AliHAMonitor", str2, str, null).booleanValue();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void h() {
        List<String> select = this.d.select();
        if (select != null) {
            for (String str : select) {
                if (str != null) {
                    String[] split = str.split("HA_APM_______HA_APM");
                    if (split.length >= 2) {
                        g(split[0], split[1]);
                    }
                }
            }
        }
        this.d.delete();
    }

    @Override // com.taobao.monitor.network.INetworkSender
    public void send(final String str, final String str2) {
        if (qh2.c) {
            i20.a("TBRestSender", str, str2);
            uk2.d(new Runnable() {
                /* class com.taobao.monitor.adapter.network.TBRestSender.AnonymousClass1 */

                public void run() {
                    try {
                        t91.d("TBRestSender", str2);
                        int i = 0;
                        boolean z = false;
                        while (true) {
                            int i2 = i + 1;
                            if (i >= 2) {
                                break;
                            }
                            z = TBRestSender.this.g(str, str2);
                            if (z) {
                                t91.d("TBRestSender", "send success" + i2);
                                break;
                            }
                            i = i2;
                        }
                        if (!z) {
                            TBRestSender.this.f(str, str2);
                            TBRestSender.this.c = true;
                        }
                        if (z && TBRestSender.this.c) {
                            TBRestSender.this.h();
                            TBRestSender.this.c = false;
                        }
                    } catch (Throwable th) {
                        t91.f(th);
                    }
                }
            });
        }
    }
}
