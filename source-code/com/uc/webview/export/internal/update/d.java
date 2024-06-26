package com.uc.webview.export.internal.update;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.utility.Log;
import com.uc.webview.export.internal.utility.i;
import java.util.Map;
import java.util.concurrent.Callable;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class d implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;
    final /* synthetic */ Callable c;
    final /* synthetic */ Map d;

    d(Context context, String str, Callable callable, Map map) {
        this.a = context;
        this.b = str;
        this.c = callable;
        this.d = map;
    }

    public final void run() {
        while (!SDKFactory.b()) {
            try {
                Thread.sleep(200);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (SDKFactory.c((Long) 1L).booleanValue()) {
            Log.i("UpdateUtils", "force system webview, don't download uc player");
        } else if (SDKFactory.c(Long.valueOf((long) PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED)).booleanValue()) {
            Log.i("UpdateUtils", "use ucmobile apollo, don't download uc player");
        } else if (!i.a().b(UCCore.OPTION_USE_UC_PLAYER)) {
            Log.i("UpdateUtils", "sUseUCPlayer is false, don't download uc player");
        } else {
            try {
                b.b(this.a, this.b, this.c, this.d);
            } catch (Throwable th) {
                Log.i("UpdateUtils", "updateUCPlayer failed", th);
            }
        }
    }
}
