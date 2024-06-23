package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.tbs.video.interfaces.IUserStateChangedListener;
import com.tencent.tbs.video.interfaces.a;

/* compiled from: TbsVideoPlayer */
class p {
    private static p e;
    r a = null;
    Context b;
    a c;
    IUserStateChangedListener d;

    public static synchronized p a(Context context) {
        p pVar;
        synchronized (p.class) {
            if (e == null) {
                e = new p(context);
            }
            pVar = e;
        }
        return pVar;
    }

    private p(Context context) {
        this.b = context.getApplicationContext();
        this.a = new r(this.b);
    }

    public boolean a(String str, Bundle bundle, a aVar) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (!TextUtils.isEmpty(str)) {
            bundle.putString("videoUrl", str);
        }
        if (aVar != null) {
            this.a.a();
            if (!this.a.b()) {
                return false;
            }
            this.c = aVar;
            AnonymousClass1 r1 = new IUserStateChangedListener() {
                /* class com.tencent.smtt.sdk.p.AnonymousClass1 */

                @Override // com.tencent.tbs.video.interfaces.IUserStateChangedListener
                public void onUserStateChanged() {
                    p.this.a.c();
                }
            };
            this.d = r1;
            this.c.a(r1);
            bundle.putInt("callMode", 3);
        } else {
            bundle.putInt("callMode", 1);
        }
        this.a.a(bundle, aVar == null ? null : this);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void a(Activity activity, int i) {
        this.a.a(activity, i);
    }

    public boolean a() {
        this.a.a();
        return this.a.b();
    }

    public void a(int i, int i2, Intent intent) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(i, i2, intent);
        }
    }
}
