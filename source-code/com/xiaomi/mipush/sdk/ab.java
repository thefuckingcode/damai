package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class ab implements Runnable {
    final /* synthetic */ MiTinyDataClient.a.C0252a a;

    ab(MiTinyDataClient.a.C0252a aVar) {
        this.a = aVar;
    }

    public void run() {
        if (this.a.f33a.size() != 0) {
            this.a.b();
        } else if (MiTinyDataClient.a.C0252a.a(this.a) != null) {
            MiTinyDataClient.a.C0252a.a(this.a).cancel(false);
            this.a.f34a = null;
        }
    }
}
