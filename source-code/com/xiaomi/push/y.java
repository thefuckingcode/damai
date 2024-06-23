package com.xiaomi.push;

import android.content.Context;
import java.io.File;
import java.io.IOException;

/* compiled from: Taobao */
public abstract class y implements Runnable {
    private Context a;

    /* renamed from: a  reason: collision with other field name */
    private File f1010a;

    /* renamed from: a  reason: collision with other field name */
    private Runnable f1011a;

    private y(Context context, File file) {
        this.a = context;
        this.f1010a = file;
    }

    /* synthetic */ y(Context context, File file, z zVar) {
        this(context, file);
    }

    public static void a(Context context, File file, Runnable runnable) {
        new z(context, file, runnable).run();
    }

    /* access modifiers changed from: protected */
    public abstract void a(Context context);

    public final void run() {
        x xVar = null;
        try {
            if (this.f1010a == null) {
                this.f1010a = new File(this.a.getFilesDir(), "default_locker");
            }
            xVar = x.a(this.a, this.f1010a);
            Runnable runnable = this.f1011a;
            if (runnable != null) {
                runnable.run();
            }
            a(this.a);
            if (xVar == null) {
                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
            if (0 == 0) {
                return;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                xVar.a();
            }
            throw th;
        }
        xVar.a();
    }
}
