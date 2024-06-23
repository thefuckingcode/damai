package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.export.external.libwebp;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.m;
import java.util.Map;

/* access modifiers changed from: package-private */
/* compiled from: TbsWizard */
public class s {
    private Context a = null;
    private Context b = null;
    private String c = null;
    private String[] d = null;
    private DexLoader e = null;
    private String f = "TbsDexOpt";
    private String g = null;

    public s(Context context, Context context2, String str, String str2, String[] strArr, String str3) throws Exception {
        boolean z;
        boolean z2;
        TbsLog.i("TbsWizard", "construction start...");
        if (context == null || ((context2 == null && TbsShareManager.getHostCorePathAppDefined() == null) || TextUtils.isEmpty(str) || strArr == null || strArr.length == 0)) {
            throw new Exception("TbsWizard paramter error:-1callerContext:" + context + "hostcontext" + context2 + "isEmpty" + TextUtils.isEmpty(str) + "dexfileList" + strArr);
        }
        this.a = context.getApplicationContext();
        if (context2.getApplicationContext() != null) {
            this.b = context2.getApplicationContext();
        } else {
            this.b = context2;
        }
        this.c = str;
        this.d = strArr;
        this.f = str2;
        for (int i = 0; i < this.d.length; i++) {
            TbsLog.i("TbsWizard", "#2 mDexFileList[" + i + "]: " + this.d[i]);
        }
        TbsLog.i("TbsWizard", "new DexLoader #2 libraryPath is " + str3 + " mCallerAppContext is " + this.a + " dexOutPutDir is " + str2);
        this.e = new DexLoader(str3, this.a, this.d, str2, QbSdk.n);
        System.currentTimeMillis();
        a(context);
        libwebp.loadWepLibraryIfNeed(context2, this.c);
        if ("com.nd.android.pandahome2".equals(this.a.getApplicationInfo().packageName)) {
            this.e.invokeStaticMethod("com.tencent.tbs.common.beacon.X5CoreBeaconUploader", "getInstance", new Class[]{Context.class}, this.a);
        }
        if (QbSdk.n != null) {
            try {
                z = TbsPVConfig.getInstance(this.a).getTbsCoreSandboxModeEnable();
            } catch (Throwable unused) {
                z = false;
            }
            try {
                z2 = "true".equals(String.valueOf(QbSdk.n.get(TbsCoreSettings.TBS_SETTINGS_USE_SANDBOX)));
            } catch (Throwable th) {
                th.printStackTrace();
                z2 = false;
            }
            QbSdk.n.put(TbsCoreSettings.TBS_SETTINGS_USE_SANDBOX, Boolean.valueOf(z && z2));
            this.e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTbsSettings", new Class[]{Map.class}, QbSdk.n);
        }
        int b2 = b(context);
        if (b2 >= 0) {
            TbsLog.i("TbsWizard", "construction end...");
            return;
        }
        throw new Exception("TbsWizard init error: " + b2 + "; msg: " + this.g);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARNING: Removed duplicated region for block: B:9:? A[RETURN, SYNTHETIC] */
    public void a(Context context) {
        boolean z;
        Map<String, Object> map = QbSdk.n;
        if (map != null) {
            Object obj = map.get(TbsCoreSettings.TBS_SETTINGS_CHECK_TBS_VALIDITY);
            if (obj instanceof Boolean) {
                z = ((Boolean) obj).booleanValue();
                if (!z) {
                    m.b(context);
                    return;
                }
                return;
            }
        }
        z = true;
        if (!z) {
        }
    }

    public void a(Context context, Context context2, String str, String str2, String[] strArr, String str3) throws Exception {
        this.a = context.getApplicationContext();
        if (this.b.getApplicationContext() != null) {
            this.b = this.b.getApplicationContext();
        }
        this.c = str;
        this.d = strArr;
        this.f = str2;
        libwebp.loadWepLibraryIfNeed(context2, str);
        if (QbSdk.n != null) {
            this.e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTbsSettings", new Class[]{Map.class}, QbSdk.n);
        }
        int b2 = b(context);
        if (b2 < 0) {
            throw new Exception("continueInit init error: " + b2 + "; msg: " + this.g);
        }
    }

    private int b(Context context) {
        Object obj;
        int i;
        if (this.b != null || TbsShareManager.getHostCorePathAppDefined() == null) {
            TbsLog.i("TbsWizard", "initTesRuntimeEnvironment callerContext is " + context + " mHostContext is " + this.b + " mDexLoader is " + this.e + " mtbsInstallLocation is " + this.c + " mDexOptPath is " + this.f);
            obj = this.e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[]{Context.class, Context.class, DexLoader.class, String.class, String.class, String.class, Integer.TYPE, String.class}, context, this.b, this.e, this.c, this.f, TbsConfig.TBS_SDK_VERSIONNAME, 43903, QbSdk.a());
        } else {
            obj = this.e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[]{Context.class, Context.class, DexLoader.class, String.class, String.class, String.class, Integer.TYPE, String.class, String.class}, context, this.b, this.e, this.c, this.f, TbsConfig.TBS_SDK_VERSIONNAME, 43903, QbSdk.a(), TbsShareManager.getHostCorePathAppDefined());
        }
        if (obj == null) {
            c();
            d();
            DexLoader dexLoader = this.e;
            obj = dexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[]{Context.class, Context.class, DexLoader.class, String.class, String.class}, context, this.b, dexLoader, this.c, this.f);
        }
        if (obj == null) {
            i = -3;
        } else if (obj instanceof Integer) {
            i = ((Integer) obj).intValue();
        } else if (obj instanceof Throwable) {
            TbsCoreLoadStat.getInstance().a(this.a, TbsListener.ErrorCode.THROWABLE_INITTESRUNTIMEENVIRONMENT, (Throwable) obj);
            i = -5;
        } else {
            i = -4;
        }
        if (i < 0) {
            Object invokeStaticMethod = this.e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new Class[0], new Object[0]);
            if (invokeStaticMethod instanceof Throwable) {
                Throwable th = (Throwable) invokeStaticMethod;
                this.g = "#" + th.getMessage() + "; cause: " + th.getCause() + "; th: " + th;
            }
            if (invokeStaticMethod instanceof String) {
                this.g = (String) invokeStaticMethod;
            }
        } else {
            this.g = null;
        }
        return i;
    }

    private void c() {
        this.e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "setTesSdkVersionName", new Class[]{String.class}, TbsConfig.TBS_SDK_VERSIONNAME);
    }

    private void d() {
        this.e.setStaticField("com.tencent.tbs.tbsshell.TBSShell", "VERSION", 43903);
    }

    public String a() {
        String str = null;
        Object invokeStaticMethod = this.e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "invokeStaticMethod", new Class[]{Boolean.TYPE, String.class, String.class, Class[].class, Object[].class}, true, "com.tencent.smtt.util.CrashTracker", "getCrashExtraInfo", null, new Object[0]);
        if (invokeStaticMethod == null) {
            invokeStaticMethod = this.e.invokeStaticMethod("com.tencent.smtt.util.CrashTracker", "getCrashExtraInfo", null, new Object[0]);
        }
        if (invokeStaticMethod != null) {
            str = String.valueOf(invokeStaticMethod) + " ReaderPackName=" + TbsReaderView.gReaderPackName + " ReaderPackVersion=" + TbsReaderView.gReaderPackVersion;
        }
        return str == null ? "X5 core get nothing..." : str;
    }

    public boolean a(Context context, String str, String str2, Bundle bundle) {
        Object invokeStaticMethod = this.e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "installLocalQbApk", new Class[]{Context.class, String.class, String.class, Bundle.class}, context, str, str2, bundle);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    public DexLoader b() {
        return this.e;
    }
}
