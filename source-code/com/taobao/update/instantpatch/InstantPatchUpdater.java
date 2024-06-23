package com.taobao.update.instantpatch;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.widget.Toast;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.common.PatchInfo;
import com.android.alibaba.ip.server.InstantPatcher;
import com.android.alibaba.ip.server.Restarter;
import com.taobao.update.datasource.UpdateDataSource;
import com.taobao.update.datasource.UpdateListener;
import com.taobao.update.instantpatch.model.InstantUpdateInfo;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import tb.js2;
import tb.ks2;
import tb.m11;
import tb.n11;
import tb.ns2;
import tb.to1;
import tb.wo1;
import tb.xo1;

/* compiled from: Taobao */
public class InstantPatchUpdater extends ks2 implements UpdateListener {
    public static final String EFFECTIVE_VERSION = "instantpatch_effective_version";
    public static final String PATCH_FROM = "patch_from";
    private Context a;
    private String b;
    private volatile boolean c;
    private PublishType d;
    private String e;
    private UpdateListener.PatchListener f;
    private SharedPreferences g;
    private boolean h;
    private boolean i;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public enum PublishType {
        BETA,
        RELEASE
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            int[] iArr = new int[PublishType.values().length];
            a = iArr;
            iArr[PublishType.BETA.ordinal()] = 1;
            a[PublishType.RELEASE.ordinal()] = 2;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class b {
        private static final InstantPatchUpdater a = new InstantPatchUpdater();
    }

    private void a() {
        for (Activity activity : Restarter.getActivities(getContext(), false)) {
            activity.finish();
        }
    }

    private void b(InstantUpdateInfo instantUpdateInfo, String str) {
        if (str.equals(js2.SCAN)) {
            j("start to do instantpatch!");
        }
        long currentTimeMillis = System.currentTimeMillis();
        xo1.stat(true, "revupdate", 0, 0, "", Long.valueOf(instantUpdateInfo.patchVersion).longValue());
        n11 n11 = new n11();
        n11.context = this.a;
        n11.workDir = n11.getPatchPath();
        new to1(n11).download(instantUpdateInfo);
        if (!n11.success || TextUtils.isEmpty(n11.path)) {
            if (str.equals(js2.SCAN)) {
                j("instantpatch download failed!");
            }
            xo1.stat(false, "download", 0, n11.errorCode, n11.errorMsg, Long.valueOf(instantUpdateInfo.patchVersion).longValue());
            UpdateListener.PatchListener patchListener = this.f;
            if (patchListener != null) {
                patchListener.patchFailed(n11.errorMsg);
                return;
            }
            return;
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (str.equals(js2.SCAN)) {
            j("instantpatch download success!");
        }
        xo1.stat(true, "download", currentTimeMillis2, n11.errorCode, n11.errorMsg, Long.valueOf(instantUpdateInfo.patchVersion).longValue());
        new wo1(n11).install(instantUpdateInfo);
        long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
        if (n11.success) {
            xo1.stat(true, "install", currentTimeMillis3, n11.errorCode, n11.errorMsg, Long.valueOf(instantUpdateInfo.patchVersion).longValue());
            i(str);
            UpdateListener.PatchListener patchListener2 = this.f;
            if (patchListener2 != null) {
                patchListener2.patchSuccess();
            }
            if (str.equals(js2.SCAN)) {
                j("instantpatch do patch success!");
                if (InstantPatcher.hasResources && m11.waitForConfirmAction("Instantpatch当前有资源patch,重启生效?")) {
                    Context context = this.a;
                    Restarter.restartApp(context, Restarter.getActivities(context, false));
                }
            }
            if (InstantPatcher.hasResources) {
                this.h = true;
                return;
            }
            return;
        }
        xo1.stat(false, "install", 0, n11.errorCode, n11.errorMsg, Long.valueOf(instantUpdateInfo.patchVersion).longValue());
        UpdateListener.PatchListener patchListener3 = this.f;
        if (patchListener3 != null) {
            patchListener3.patchFailed(n11.errorMsg);
        }
        if (str.equals(js2.SCAN)) {
            j("instantpatch do patch failed!");
        }
    }

    private boolean c(InstantUpdateInfo instantUpdateInfo) {
        return InstantPatcher.create(this.a).hasPatched(createPatchInfo(instantUpdateInfo));
    }

    private boolean d() {
        try {
            this.i = (getContext().getApplicationInfo().flags & 2) != 0;
        } catch (Exception unused) {
            this.i = true;
        }
        return this.i;
    }

    private String e() {
        return this.g.getString(PATCH_FROM, "");
    }

    private boolean f(String str) {
        if (d() && !js2.SCAN.equals(str)) {
            return false;
        }
        if (js2.SCAN.equals(str) || !e().equals(js2.SCAN)) {
            return true;
        }
        return false;
    }

    private boolean g(InstantUpdateInfo instantUpdateInfo) {
        this.d = instantUpdateInfo.beta ? PublishType.BETA : PublishType.RELEASE;
        this.e = instantUpdateInfo.patchVersion;
        String string = this.g.getString("instantpatch_effective_type", "");
        String string2 = this.g.getString(EFFECTIVE_VERSION, "");
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
            return true;
        }
        int i2 = a.a[this.d.ordinal()];
        if (i2 != 1) {
            if (i2 == 2 && !string.equals(this.d.name()) && string.equals(PublishType.BETA) && Integer.valueOf(this.e).intValue() <= Integer.valueOf(string2).intValue()) {
                return false;
            }
            return true;
        } else if (Integer.valueOf(this.e).intValue() > Integer.valueOf(string2).intValue()) {
            return true;
        } else {
            return false;
        }
    }

    private void h() {
        try {
            InstantPatcher create = InstantPatcher.create(this.a);
            Method declaredMethod = InstantPatcher.class.getDeclaredMethod("clearPatchInfo", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(create, new Object[0]);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
        }
        this.g.edit().putString(EFFECTIVE_VERSION, "").putString("instantpatch_effective_type", "").apply();
    }

    private void i(String str) {
        this.g.edit().putString("instantpatch_effective_type", this.d.name()).putString(EFFECTIVE_VERSION, this.e).putString(PATCH_FROM, str).apply();
    }

    public static InstantPatchUpdater instance() {
        return b.a;
    }

    private void j(final String str) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            /* class com.taobao.update.instantpatch.InstantPatchUpdater.AnonymousClass1 */

            public void run() {
                Toast.makeText(UpdateDataSource.sContext, str, 1).show();
            }
        });
    }

    public PatchInfo createPatchInfo(InstantUpdateInfo instantUpdateInfo) {
        PatchInfo patchInfo = new PatchInfo();
        patchInfo.setPatchVersion(Integer.valueOf(instantUpdateInfo.patchVersion).intValue());
        patchInfo.setBaseVersion(instantUpdateInfo.baseVersion);
        patchInfo.setPriority(Integer.valueOf(instantUpdateInfo.priority).intValue());
        return patchInfo;
    }

    public Context getContext() {
        return this.a;
    }

    @Override // tb.ks2
    public void init(Context context) {
        this.a = context;
        this.b = ns2.getVersionName();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.g = defaultSharedPreferences;
        if (!this.b.equals(defaultSharedPreferences.getString("instantpatch_mainversion", ""))) {
            this.g.edit().putString("instantpatch_mainversion", this.b).putString(EFFECTIVE_VERSION, "").putString("instantpatch_effective_type", "").apply();
            try {
                InstantPatcher.create(context).purge();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // tb.ks2
    public void onBackground() {
        super.onBackground();
        if (this.h) {
            a();
            ns2.killChildProcesses(getContext());
            System.exit(0);
        }
    }

    @Override // tb.ks2
    public void onExit() {
        if (this.h) {
            a();
            ns2.killChildProcesses(getContext());
            System.exit(0);
        }
    }

    @Override // com.taobao.update.datasource.UpdateListener
    public void onUpdate(boolean z, JSONObject jSONObject, String str) {
        if (f(str)) {
            if (!this.c) {
                this.c = true;
                try {
                    InstantUpdateInfo create = InstantUpdateInfo.create(jSONObject);
                    if (TextUtils.isEmpty(create.patchUrl) && !create.rollback) {
                        this.c = false;
                    } else if (create.rollback) {
                        h();
                        this.c = false;
                    } else if (c(create)) {
                        if (str.equals(js2.SCAN)) {
                            j("instantpatch has patched!");
                        } else {
                            UpdateListener.PatchListener patchListener = this.f;
                            if (patchListener != null) {
                                patchListener.hasPatched(true);
                            }
                        }
                        this.c = false;
                    } else if (!g(create)) {
                        this.c = false;
                    } else {
                        b(create, str);
                        this.c = false;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                } catch (Throwable th) {
                    this.c = false;
                    throw th;
                }
            } else if (str.equals(js2.SCAN)) {
                j("instantpatch updating ......");
            }
        }
    }

    @Override // com.taobao.update.datasource.UpdateListener
    public void patchProcessListener(UpdateListener.PatchListener patchListener) {
        this.f = patchListener;
    }

    private InstantPatchUpdater() {
        this.h = false;
    }
}
