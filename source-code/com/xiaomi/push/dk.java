package com.xiaomi.push;

import android.util.Log;
import android.util.Pair;
import java.util.Date;
import java.util.List;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class dk implements Runnable {
    final /* synthetic */ dj a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f217a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Throwable f218a;

    dk(dj djVar, String str, Throwable th) {
        this.a = djVar;
        this.f217a = str;
        this.f218a = th;
    }

    public void run() {
        dj.a().add(new Pair(String.format("%1$s %2$s %3$s ", dj.a().format(new Date()), dj.a(this.a), this.f217a), this.f218a));
        if (dj.a().size() > 20000) {
            int size = (dj.a().size() - 20000) + 50;
            for (int i = 0; i < size; i++) {
                try {
                    if (dj.a().size() > 0) {
                        dj.a().remove(0);
                    }
                } catch (IndexOutOfBoundsException unused) {
                }
            }
            List a2 = dj.a();
            a2.add(new Pair(String.format("%1$s %2$s %3$s ", dj.a().format(new Date()), dj.a(this.a), "flush " + size + " lines logs."), null));
        }
        try {
            if (!ad.d()) {
                Log.w(dj.a(this.a), "SDCard is unavailable.");
            } else {
                dj.a(this.a);
            }
        } catch (Exception e) {
            Log.e(dj.a(this.a), "", e);
        }
    }
}
