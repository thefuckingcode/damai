package com.uc.webview.export.internal.update;

import android.content.Context;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.setup.UCSetupException;
import com.uc.webview.export.internal.utility.Log;
import java.util.Map;
import java.util.concurrent.Callable;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class c implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;
    final /* synthetic */ Callable c;
    final /* synthetic */ Map d;
    final /* synthetic */ Map e;

    c(Context context, String str, Callable callable, Map map, Map map2) {
        this.a = context;
        this.b = str;
        this.c = callable;
        this.d = map;
        this.e = map2;
    }

    public final void run() {
        int i = 10;
        while (true) {
            if (SDKFactory.b() || SDKFactory.j) {
                break;
            }
            int i2 = i - 1;
            if (i <= 0) {
                i = i2;
                break;
            }
            try {
                Thread.sleep(200);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            i = i2;
        }
        if (i > 0) {
            try {
                b.b(this.a, this.b, this.c, this.d, this.e);
            } catch (Throwable th) {
                Log.e("UpdateUtils", "updateUCCore failed", th);
            }
        } else {
            throw new UCSetupException("Waiting timeout for UCCore initialization finish!");
        }
    }
}
