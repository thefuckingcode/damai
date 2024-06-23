package com.uc.webview.export.internal.setup;

import android.content.Context;
import android.webkit.ValueCallback;
import com.taobao.accs.common.Constants;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.setup.UCSetupTask;
import com.uc.webview.export.internal.utility.Log;
import com.uc.webview.export.internal.utility.p;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
public class aj<RETURN_TYPE extends UCSetupTask<RETURN_TYPE, CALLBACK_TYPE>, CALLBACK_TYPE extends UCSetupTask<RETURN_TYPE, CALLBACK_TYPE>> {
    private static String d = "aj";
    String a = "";
    public final ValueCallback<CALLBACK_TYPE> b = new ak(this);
    public final ValueCallback<CALLBACK_TYPE> c = new al(this);
    private WeakReference<UCSetupTask> e;
    private File f;
    private File g;
    private File h;

    /* compiled from: Taobao */
    public static class a {
        private static ConcurrentHashMap<String, aj> a = new ConcurrentHashMap<>();

        /* access modifiers changed from: private */
        public static aj b(UCSetupTask uCSetupTask, Context context, String str) {
            aj ajVar;
            String str2 = aj.d;
            Log.d(str2, "create " + str);
            if (p.a(str)) {
                return null;
            }
            synchronized (aj.class) {
                ajVar = new aj(uCSetupTask, context, str);
                a.put(str, ajVar);
            }
            return ajVar;
        }

        public static aj a(UCSetupTask uCSetupTask, Context context, String str) {
            if (p.a(str)) {
                return null;
            }
            synchronized (aj.class) {
                if (a.containsKey(str)) {
                    aj ajVar = a.get(str);
                    ajVar.a(uCSetupTask);
                    return ajVar;
                }
                return b(uCSetupTask, context, str);
            }
        }
    }

    public aj(UCSetupTask uCSetupTask, Context context, String str) {
        if (this.f == null) {
            a(uCSetupTask);
            File b2 = p.b(p.a(context, Constants.KEY_FLAGS), p.e(str));
            String str2 = d;
            Log.d(str2, "<init> flgDirFile.path: " + b2.getAbsolutePath());
            this.f = new File(b2, "b36ce8d879e33bc88f717f74617ea05a");
            this.g = new File(b2, "bd89426940609c9ae14e5ae90827201b");
            this.h = new File(b2, "51bfcd9dd2f1379936c4fbb3558a6e67");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x006c, code lost:
        if (r1 != false) goto L_0x0070;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x003a */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00af  */
    static /* synthetic */ void d(aj ajVar) {
        Integer num;
        boolean exists = ajVar.f.exists();
        boolean exists2 = ajVar.h.exists();
        boolean z = true;
        if (ajVar.g.exists()) {
            if (exists && exists2) {
                if (System.currentTimeMillis() - Math.max(ajVar.g.lastModified(), ajVar.h.lastModified()) > 86400000) {
                    ajVar.g.delete();
                    try {
                        ajVar.f.delete();
                    } catch (Throwable unused) {
                    }
                } else {
                    ajVar.a = "2";
                    Boolean bool = (Boolean) ajVar.e.get().getOption(UCCore.OPTION_MULTI_UNKNOWN_CRASH_DISABLE);
                    if (bool == null || !bool.booleanValue()) {
                        ajVar.e.get().callback("crash_repeat");
                        return;
                    }
                    return;
                }
            }
            if (exists && (num = (Integer) ajVar.e.get().getOption(UCCore.OPTION_VERIFY_POLICY)) != null) {
                ajVar.e.get().setup(UCCore.OPTION_VERIFY_POLICY, (Object) Integer.valueOf(num.intValue() | 16));
            }
            ajVar.a = !z ? "1" : "0";
            ajVar.e.get().callback(!z ? "crash_seen" : "crash_none");
        } else if (exists) {
        }
        z = false;
        ajVar.e.get().setup(UCCore.OPTION_VERIFY_POLICY, (Object) Integer.valueOf(num.intValue() | 16));
        ajVar.a = !z ? "1" : "0";
        ajVar.e.get().callback(!z ? "crash_seen" : "crash_none");
    }

    static /* synthetic */ void e(aj ajVar) {
        try {
            if (!ajVar.f.exists()) {
                ajVar.f.createNewFile();
            } else if (!ajVar.h.exists()) {
                ajVar.h.createNewFile();
            } else if (!ajVar.g.exists()) {
                ajVar.g.createNewFile();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static String a(String str) {
        return "ThickSetupTask_" + str;
    }

    public static void a(Context context, String[] strArr) {
        for (int i = 0; i < 2; i++) {
            a.b(null, context, strArr[i]);
        }
    }

    public final void a(UCSetupTask uCSetupTask) {
        if (uCSetupTask != null) {
            WeakReference<UCSetupTask> weakReference = this.e;
            if (weakReference == null || weakReference.get() != uCSetupTask) {
                this.e = new WeakReference<>(uCSetupTask);
                String str = d;
                Log.d(str, "UCSetupt.class: " + this.e.get().getClass());
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0005 */
    public final void a() {
        this.f.delete();
        try {
            this.h.delete();
        } catch (Throwable unused) {
        }
    }
}
