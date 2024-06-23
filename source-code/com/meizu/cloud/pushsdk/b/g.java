package com.meizu.cloud.pushsdk.b;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;

/* compiled from: Taobao */
public class g extends h<f> implements f {
    private static g a;
    private boolean b = false;

    private g(f fVar) {
        super(fVar);
    }

    public static g b() {
        if (a == null) {
            synchronized (g.class) {
                if (a == null) {
                    a = new g(new b());
                }
            }
        }
        return a;
    }

    public void a(Context context) {
        a(context, (String) null);
    }

    public void a(Context context, String str) {
        if (!this.b) {
            boolean z = true;
            this.b = true;
            if ((context.getApplicationInfo().flags & 2) == 0) {
                z = false;
            }
            b(z);
            if (str == null) {
                if (Build.VERSION.SDK_INT >= 29) {
                    str = MzSystemUtils.getDocumentsPath(context) + "/pushSdk/" + context.getPackageName();
                } else {
                    str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/pushSdk/" + context.getPackageName();
                }
            }
            a(str);
        }
    }

    @Override // com.meizu.cloud.pushsdk.b.f
    public void a(String str) {
        ((f) c()).a(str);
    }

    @Override // com.meizu.cloud.pushsdk.b.f
    public void a(String str, String str2) {
        ((f) c()).a(str, str2);
    }

    @Override // com.meizu.cloud.pushsdk.b.f
    public void a(String str, String str2, Throwable th) {
        ((f) c()).a(str, str2, th);
    }

    @Override // com.meizu.cloud.pushsdk.b.f
    public void a(boolean z) {
        ((f) c()).a(z);
    }

    @Override // com.meizu.cloud.pushsdk.b.f
    public boolean a() {
        return ((f) c()).a();
    }

    @Override // com.meizu.cloud.pushsdk.b.f
    public void b(String str, String str2) {
        ((f) c()).b(str, str2);
    }

    @Override // com.meizu.cloud.pushsdk.b.f
    public void b(boolean z) {
        ((f) c()).b(z);
    }

    @Override // com.meizu.cloud.pushsdk.b.f
    public void c(String str, String str2) {
        ((f) c()).c(str, str2);
    }

    @Override // com.meizu.cloud.pushsdk.b.f
    public void d(String str, String str2) {
        ((f) c()).d(str, str2);
    }
}
