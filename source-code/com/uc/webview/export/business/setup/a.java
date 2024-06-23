package com.uc.webview.export.business.setup;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.uc.webview.export.Build;
import com.uc.webview.export.CDParamKeys;
import com.uc.webview.export.business.BusinessWrapper;
import com.uc.webview.export.business.a;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.cyclone.UCElapseTime;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.setup.BaseSetupTask;
import com.uc.webview.export.internal.setup.UCSetupException;
import com.uc.webview.export.internal.setup.bt;
import com.uc.webview.export.internal.setup.h;
import com.uc.webview.export.internal.utility.Log;
import com.uc.webview.export.internal.utility.g;
import com.uc.webview.export.internal.utility.j;
import com.uc.webview.export.internal.utility.p;
import com.uc.webview.export.utility.SetupTask;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
public class a extends SetupTask {
    private static final String a = a.class.getSimpleName();
    private com.uc.webview.export.business.a c = new com.uc.webview.export.business.a();
    private com.uc.webview.export.business.a d = new com.uc.webview.export.business.a();
    private com.uc.webview.export.business.a e = new com.uc.webview.export.business.a();
    private com.uc.webview.export.business.a f = new com.uc.webview.export.business.a();
    private com.uc.webview.export.business.a g = new com.uc.webview.export.business.a();
    private C0243a h;
    private ValueCallback<BaseSetupTask> i = new i(this);
    private ValueCallback<BaseSetupTask> j = new j(this);
    private ValueCallback<BaseSetupTask> k = new k(this);
    private ValueCallback<BaseSetupTask> l = new l(this);
    private ValueCallback<BaseSetupTask> m = new m(this);
    private Map<String, Pair<ValueCallback<BaseSetupTask>, ValueCallback<BaseSetupTask>>> n = new n(this);
    private Map<String, String> o = new o(this);

    static /* synthetic */ com.uc.webview.export.business.a a(a aVar) {
        return aVar.c;
    }

    static /* synthetic */ com.uc.webview.export.business.a b(a aVar) {
        return aVar.e;
    }

    static /* synthetic */ void b() {
    }

    static /* synthetic */ com.uc.webview.export.business.a c(a aVar) {
        return aVar.f;
    }

    static /* synthetic */ com.uc.webview.export.business.a d(a aVar) {
        return aVar.g;
    }

    static /* synthetic */ com.uc.webview.export.business.a e(a aVar) {
        return aVar.d;
    }

    private void g() {
        a(new c(this));
    }

    private void i() {
        a(new f(this));
    }

    static /* synthetic */ ConcurrentHashMap o(a aVar) {
        return aVar.mOptions;
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0172  */
    @Override // com.uc.webview.export.internal.setup.UCAsyncTask
    public void run() {
        String str;
        boolean z;
        String str2 = "OPTION_CONTEXT is null.";
        String str3 = a;
        Log.d(str3, ".run begin.");
        boolean z2 = false;
        this.h = new C0243a(this, (byte) 0);
        try {
            this.c.a(a.d.a);
            try {
                this.e.a(a.b.a);
                if (p.a(getOption("CONTEXT"))) {
                    this.e.a(a.b.e);
                    str = str2;
                } else if (p.a((String) this.mOptions.get(UCCore.OPTION_NEW_UCM_ZIP_FILE))) {
                    this.e.a(a.b.b);
                    str = "OPTION_NEW_UCM_ZIP_FILE is empty.";
                } else if (p.a((String) this.mOptions.get(UCCore.OPTION_BUSINESS_DECOMPRESS_ROOT_PATH))) {
                    this.e.a(a.b.c);
                    str = "OPTION_BUSINESS_DECOMPRESS_ROOT_PATH is empty.";
                } else if (p.a(this.mOptions.get(UCCore.OPTION_FORCE_USE_BUSINESS_DECOMPRESS_ROOT_PATH))) {
                    this.e.a(a.b.d);
                    str = "OPTION_FORCE_USE_BUSINESS_DECOMPRESS_ROOT_PATH is null.";
                } else if (!p.a((String) this.mOptions.get(UCCore.OPTION_OLD_DEX_DIR_PATH)) && p.a(getOption(UCCore.OPTION_PROMISE_SPECIAL_VERSION_CORE_INIT))) {
                    this.e.a(a.b.f);
                    str = "OPTION_OLD_DEX_DIR_PATH not empty but OPTION_PROMISE_SPECIAL_VERSION_CORE_INIT is null.";
                } else if (!p.a((Boolean) getOption(UCCore.OPTION_UCMOBILE_INIT)) || p.h()) {
                    str = null;
                } else {
                    this.e.a(a.b.g);
                    str = "OPTION_UCMOBILE_INIT is true but Class.forName(\"com.uc.webview.browser.BrowserCore\") exception.";
                }
                if (p.a(str)) {
                    this.f.a(a.C0242a.b);
                    if (p.b((String) getOption(UCCore.OPTION_BUSINESS_DECOMPRESS_ROOT_PATH), (String) getOption(UCCore.OPTION_NEW_UCM_ZIP_FILE))) {
                        this.f.a(a.C0242a.d);
                        if (!p.a((Boolean) getOption(UCCore.OPTION_SKIP_PRECONDITIONS_IO_CHECK))) {
                            long d2 = d(f());
                            if (0 != d2) {
                                this.f.a(d2);
                            }
                        }
                        z = true;
                        if (!z) {
                            Log.d(str3, ".run readyDecompressAndODex && checkNewCoreFileExistsAndPermissions.");
                            a(new d(this));
                            this.c.a(a.d.b);
                            C0243a aVar = this.h;
                            aVar.b = String.valueOf(aVar.a.getMilis());
                            C0243a aVar2 = this.h;
                            aVar2.c = String.valueOf(aVar2.a.getMilisCpu());
                            Log.d(str3, "mInitStat：" + this.c.a);
                            Log.d(str3, "checkMillis：" + this.h.b);
                            return;
                        }
                        this.g.a(a.C0242a.c);
                        long c2 = c((String) this.mOptions.get(UCCore.OPTION_OLD_DEX_DIR_PATH));
                        if (0 == c2) {
                            z2 = true;
                        } else {
                            this.g.a(c2);
                        }
                        if (z2) {
                            Log.d(str3, ".run checkOldCoreCompatibleAndFileExistsPermissions.");
                            h();
                            this.c.a(a.d.c);
                            C0243a aVar3 = this.h;
                            aVar3.b = String.valueOf(aVar3.a.getMilis());
                            C0243a aVar4 = this.h;
                            aVar4.c = String.valueOf(aVar4.a.getMilisCpu());
                            Log.d(str3, "mInitStat：" + this.c.a);
                            Log.d(str3, "checkMillis：" + this.h.b);
                            return;
                        }
                        Log.d(str3, ".run initNewCoreByZipFile.");
                        g();
                        this.c.a(a.d.d);
                        C0243a aVar5 = this.h;
                        aVar5.b = String.valueOf(aVar5.a.getMilis());
                        C0243a aVar6 = this.h;
                        aVar6.c = String.valueOf(aVar6.a.getMilisCpu());
                        Log.d(str3, "mInitStat：" + this.c.a);
                        Log.d(str3, "checkMillis：" + this.h.b);
                        return;
                    }
                    z = false;
                    if (!z) {
                    }
                } else {
                    throw new UCSetupException(7001, str);
                }
            } catch (UCSetupException e2) {
                String str4 = a;
                Log.d(str4, "checkInputConditions failure message: ", e2);
                if (e2.errCode() == 7001) {
                    if (p.a(getOption("CONTEXT"))) {
                        this.e.a(a.b.e);
                    } else if (!CDParamKeys.CD_VALUE_LOAD_POLICY_SHARE_CORE.equals(UCCore.getParam(CDParamKeys.CD_KEY_SHARE_CORE_CLIENT_LOAD_POLICY))) {
                        this.e.a(a.b.h);
                        str2 = "shareCoreLoadPolicy not equals sc_lshco";
                    } else if (p.a(UCCore.getParam(CDParamKeys.CD_KEY_SHARE_CORE_COMMONALITY_TARGET_FPATH))) {
                        this.e.a(a.b.i);
                        str2 = "CD_KEY_SHARE_CORE_COMMONALITY_TARGET_FPATH is empty.";
                    } else if (p.a(UCCore.getParam(CDParamKeys.CD_KEY_SHARE_CORE_CLIENT_SPECIAL_HOST_PKG_NAME_LIST))) {
                        this.e.a(a.b.j);
                        str2 = "CD_KEY_SHARE_CORE_CLIENT_SPECIAL_HOST_PKG_NAME_LIST is empty.";
                    } else if (p.a(UCCore.getParam(CDParamKeys.CD_KEY_SHARE_CORE_CLIENT_UCM_VERSIONS))) {
                        this.e.a(a.b.k);
                        str2 = "CD_KEY_SHARE_CORE_CLIENT_UCM_VERSIONS is empty.";
                    } else if (!j.b(getContext())) {
                        this.e.a(a.b.l);
                        str2 = "Sdcard配置及权限校验失败.";
                    } else {
                        str2 = null;
                    }
                    if (p.a(str2)) {
                        Log.d(str4, ".run initShareCore.");
                        i();
                        this.c.a(a.d.j);
                    } else {
                        throw new UCSetupException(7003, str2);
                    }
                } else {
                    throw e2;
                }
            } catch (UCSetupException e3) {
                Log.d(a, "checkShareCore failure message: ", e3);
                j();
            }
        } finally {
            C0243a aVar7 = this.h;
            aVar7.b = String.valueOf(aVar7.a.getMilis());
            C0243a aVar8 = this.h;
            aVar8.c = String.valueOf(aVar8.a.getMilisCpu());
            String str5 = a;
            Log.d(str5, "mInitStat：" + this.c.a);
            Log.d(str5, "checkMillis：" + this.h.b);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.uc.webview.export.business.setup.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public class C0243a {
        UCElapseTime a;
        String b;
        String c;
        String d;
        String e;
        String f;
        String g;

        private C0243a() {
            this.a = new UCElapseTime();
        }

        /* synthetic */ C0243a(a aVar, byte b2) {
            this();
        }
    }

    static /* synthetic */ Object d(a aVar, String str) {
        return aVar.getOption(str);
    }

    private SetupTask e() {
        if (!p.a((Boolean) getOption(UCCore.OPTION_UCMOBILE_INIT))) {
            return UCCore.setup("CONTEXT", this.mOptions.get("CONTEXT"));
        }
        try {
            return (SetupTask) UCCyclone.invoke(null, Class.forName("com.uc.webview.browser.BrowserCore"), UCCore.LEGACY_EVENT_SETUP, new Class[]{String.class, Object.class}, new Object[]{"CONTEXT", this.mOptions.get("CONTEXT")});
        } catch (Exception e2) {
            throw new UCSetupException(e2);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String f() {
        File file = new File(UCCore.getExtractDirPath((String) this.mOptions.get(UCCore.OPTION_BUSINESS_DECOMPRESS_ROOT_PATH), (String) this.mOptions.get(UCCore.OPTION_NEW_UCM_ZIP_FILE)));
        if (!file.exists()) {
            file = new File(UCCore.getExtractDirPath(p.a(getContext(), "decompresses2").getAbsolutePath(), (String) this.mOptions.get(UCCore.OPTION_NEW_UCM_ZIP_FILE)));
        }
        return file.getAbsolutePath();
    }

    static /* synthetic */ void g(a aVar) {
        aVar.d.a(aVar.c.a);
        b bVar = new b(aVar);
        for (Map.Entry entry : bVar.entrySet()) {
            IWaStat.WaStat.stat((String) entry.getKey(), (String) entry.getValue());
        }
        String str = a;
        Log.d(str, "processStatMaps: " + bVar);
    }

    private void h() {
        a(new e(this));
    }

    static /* synthetic */ void i(a aVar) {
        long j2;
        Object option = aVar.getOption(UCCore.OPTION_DECOMPRESS_AND_ODEX_TASK_WAIT_MILIS);
        if (option != null) {
            if (option instanceof Long) {
                j2 = ((Long) option).longValue();
            } else if (option instanceof Integer) {
                j2 = ((Integer) option).longValue();
            }
            ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) BusinessWrapper.decompressAndODex("CONTEXT", aVar.getContext()).setup("o_flag_odex_done", (Object) Boolean.TRUE)).setup(UCCore.OPTION_UCM_ZIP_FILE, aVar.getOption(UCCore.OPTION_NEW_UCM_ZIP_FILE))).setup(UCCore.OPTION_ZIP_FILE_TYPE, aVar.getOption(UCCore.OPTION_NEW_UCM_ZIP_TYPE))).setup(UCCore.OPTION_DECOMPRESS_ROOT_DIR, aVar.getOption(UCCore.OPTION_BUSINESS_DECOMPRESS_ROOT_PATH))).setup(UCCore.OPTION_DELETE_AFTER_EXTRACT, (Object) Boolean.FALSE)).setup(UCCore.OPTION_PROVIDED_KEYS, aVar.getOption(UCCore.OPTION_PROVIDED_KEYS))).setup(UCCore.OPTION_DECOMPRESS_CALLBACK, aVar.getOption(UCCore.OPTION_DECOMPRESS_CALLBACK))).setup(UCCore.OPTION_DECOMPRESS_AND_ODEX_CALLBACK, aVar.getOption(UCCore.OPTION_DECOMPRESS_AND_ODEX_CALLBACK))).setup(UCCore.OPTION_VERIFY_POLICY, aVar.getOption(UCCore.OPTION_VERIFY_POLICY))).start(Long.valueOf(j2).longValue());
        }
        j2 = 3000;
        ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) BusinessWrapper.decompressAndODex("CONTEXT", aVar.getContext()).setup("o_flag_odex_done", (Object) Boolean.TRUE)).setup(UCCore.OPTION_UCM_ZIP_FILE, aVar.getOption(UCCore.OPTION_NEW_UCM_ZIP_FILE))).setup(UCCore.OPTION_ZIP_FILE_TYPE, aVar.getOption(UCCore.OPTION_NEW_UCM_ZIP_TYPE))).setup(UCCore.OPTION_DECOMPRESS_ROOT_DIR, aVar.getOption(UCCore.OPTION_BUSINESS_DECOMPRESS_ROOT_PATH))).setup(UCCore.OPTION_DELETE_AFTER_EXTRACT, (Object) Boolean.FALSE)).setup(UCCore.OPTION_PROVIDED_KEYS, aVar.getOption(UCCore.OPTION_PROVIDED_KEYS))).setup(UCCore.OPTION_DECOMPRESS_CALLBACK, aVar.getOption(UCCore.OPTION_DECOMPRESS_CALLBACK))).setup(UCCore.OPTION_DECOMPRESS_AND_ODEX_CALLBACK, aVar.getOption(UCCore.OPTION_DECOMPRESS_AND_ODEX_CALLBACK))).setup(UCCore.OPTION_VERIFY_POLICY, aVar.getOption(UCCore.OPTION_VERIFY_POLICY))).start(Long.valueOf(j2).longValue());
    }

    private void j() {
        a(new g(this));
    }

    private void a(BaseSetupTask baseSetupTask) {
        for (Map.Entry<String, Pair<ValueCallback<BaseSetupTask>, ValueCallback<BaseSetupTask>>> entry : this.n.entrySet()) {
            String key = entry.getKey();
            Iterator<Map.Entry<String, String>> it = this.o.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, String> next = it.next();
                if (next.getKey().equals(key)) {
                    key = next.getValue();
                    break;
                }
            }
            baseSetupTask.onEvent(key, (ValueCallback) entry.getValue().second);
        }
    }

    private DexClassLoader b(String str) {
        Context context = (Context) getOption("CONTEXT");
        File file = new File(str);
        try {
            String absolutePath = new File(file, "sdk_shell.jar").getAbsolutePath();
            Integer num = (Integer) this.mOptions.get(UCCore.OPTION_VERIFY_POLICY);
            if (!(num == null || (num.intValue() & 1) == 0)) {
                h.a(context, num, absolutePath);
            }
            return new DexClassLoader(absolutePath, UCCore.getODexDirPath(context, file.getAbsolutePath()), "", a.class.getClassLoader());
        } catch (Throwable unused) {
            Log.d(a, "create sdk_shell dexLoader failure!");
            return null;
        }
    }

    private void c() {
        for (Map.Entry<String, Pair<ValueCallback<BaseSetupTask>, ValueCallback<BaseSetupTask>>> entry : this.n.entrySet()) {
            ValueCallback callback = getCallback(entry.getKey());
            if (callback != null) {
                entry.setValue(new Pair<>(callback, entry.getValue().second));
            }
        }
    }

    private long d(String str) {
        String str2;
        try {
            File file = new File(str);
            if (!file.exists()) {
                String str3 = "check new core files, " + str + " not exists!";
                long j2 = a.C0242a.e;
                if (!p.a(str3)) {
                    Log.d(a, str3);
                }
                return j2;
            }
            DexClassLoader b = b(str);
            if (b == null) {
                long j3 = a.C0242a.f;
                if (!p.a("check new core files, create sdk_shell dexLoader failure!")) {
                    Log.d(a, "check new core files, create sdk_shell dexLoader failure!");
                }
                return j3;
            }
            long a2 = a(file, b);
            if (0 != a2) {
                if (!p.a("check new core files, file exists and permission failure!")) {
                    Log.d(a, "check new core files, file exists and permission failure!");
                }
                return a2;
            }
            if (!p.a((String) null)) {
                Log.d(a, null);
            }
            return 0;
        } catch (Throwable th) {
            if (!p.a(str2)) {
                Log.d(a, str2);
            }
            throw th;
        }
    }

    private long c(String str) {
        String str2;
        String str3 = a;
        Log.d(str3, ".checkCoreCompatibleAndFileExistsPermissions " + str);
        try {
            File file = new File(str);
            if (!file.exists()) {
                String str4 = "check new core files, " + str + " not exists!";
                long j2 = a.C0242a.e;
                if (!p.a(str4)) {
                    Log.d(str3, ".checkCoreCompatibleAndFileExistsPermissions " + str4);
                }
                return j2;
            }
            DexClassLoader b = b(str);
            if (b == null) {
                long j3 = a.C0242a.f;
                if (!p.a("check old core files, create sdk_shell dexLoader failure!")) {
                    Log.d(str3, ".checkCoreCompatibleAndFileExistsPermissions " + "check old core files, create sdk_shell dexLoader failure!");
                }
                return j3;
            }
            String b2 = com.uc.webview.export.internal.utility.h.b(b);
            if (p.a(b2)) {
                long j4 = a.C0242a.g;
                if (!p.a("check old core files, get core version failure!")) {
                    Log.d(str3, ".checkCoreCompatibleAndFileExistsPermissions " + "check old core files, get core version failure!");
                }
                return j4;
            }
            UCCore.Callable callable = (UCCore.Callable) getOption(UCCore.OPTION_PROMISE_SPECIAL_VERSION_CORE_INIT);
            if (callable == null || !((Boolean) callable.call(b2)).booleanValue()) {
                long j5 = a.C0242a.h;
                if (!p.a("check callable permission failure!")) {
                    Log.d(str3, ".checkCoreCompatibleAndFileExistsPermissions " + "check callable permission failure!");
                }
                return j5;
            }
            if (!a(Build.Version.NAME, Build.Version.SUPPORT_U4_MIN, b2, com.uc.webview.export.internal.utility.h.c(b))) {
                long j6 = a.C0242a.i;
                if (!p.a("check old core files, version compatible failure!")) {
                    Log.d(str3, ".checkCoreCompatibleAndFileExistsPermissions " + "check old core files, version compatible failure!");
                }
                return j6;
            }
            if (p.b((Boolean) getOption(UCCore.OPTION_SKIP_PRECONDITIONS_IO_CHECK))) {
                long a2 = a(file, b);
                if (0 != a2) {
                    if (!p.a("check old core files, file exists and permission failure!")) {
                        Log.d(str3, ".checkCoreCompatibleAndFileExistsPermissions " + "check old core files, file exists and permission failure!");
                    }
                    return a2;
                }
            }
            if (!p.a((String) null)) {
                Log.d(str3, ".checkCoreCompatibleAndFileExistsPermissions " + ((String) null));
            }
            return 0;
        } catch (Throwable th) {
            if (!p.a(str2)) {
                Log.d(a, ".checkCoreCompatibleAndFileExistsPermissions " + str2);
            }
            throw th;
        }
    }

    private static final int[] a(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split("\\.");
        if (split.length <= 3) {
            return null;
        }
        return new int[]{Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3])};
    }

    private static final boolean a(String str, String str2, String str3, String str4) {
        try {
            String str5 = a;
            Log.d(str5, "sdk版本:" + str);
            Log.d(str5, "sdk支持的最小内核版本:" + str2);
            Log.d(str5, "内核版本:" + str3);
            Log.d(str5, "内核支持的最小sdk版本:" + str4);
            int[] a2 = a(str3);
            int[] a3 = a(str2);
            if (a2 != null) {
                if (a3 != null) {
                    if (a2[0] >= a3[0]) {
                        if (a2[0] == a3[0]) {
                            if (a2[1] >= a3[1]) {
                                if (a2[1] == a3[1]) {
                                    if (a2[2] >= a3[2]) {
                                        if (a2[2] == a3[2] && a2[3] < a3[3]) {
                                        }
                                    }
                                }
                            }
                        }
                        int[] a4 = a(str);
                        int[] a5 = a(str4);
                        if (a4 != null) {
                            if (a5 != null) {
                                if (a4[0] >= a5[0]) {
                                    if (a4[0] == a5[0]) {
                                        if (a4[1] >= a5[1]) {
                                            if (a4[1] == a5[1]) {
                                                if (a4[2] >= a5[2]) {
                                                    if (a4[2] == a5[2] && a4[3] < a5[3]) {
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    return true;
                                }
                                Log.d(str5, "最小SDK版本不通过");
                            }
                        }
                        return false;
                    }
                    Log.d(str5, "最小内核版本不通过");
                }
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private static long a(File file, String[] strArr) {
        String str = null;
        try {
            if (strArr.length <= 0) {
                long j2 = a.C0242a.k;
                if (!p.a("so file array is empty.")) {
                    Log.d(a, ".checkFilesExistsAndPermissions failure, because " + "so file array is empty.");
                }
                return j2;
            } else if (!p.b(file, file)) {
                long j3 = a.C0242a.l;
                if (!p.a("root dir modifyFilePermissionsDirFromTo failure.")) {
                    Log.d(a, ".checkFilesExistsAndPermissions failure, because " + "root dir modifyFilePermissionsDirFromTo failure.");
                }
                return j3;
            } else {
                String[] strArr2 = {"core.jar", "sdk_shell.jar"};
                for (int i2 = 0; i2 < 2; i2++) {
                    File file2 = new File(file, strArr2[i2]);
                    if (!file2.exists() || !g.a(file2)) {
                        String str2 = file2.getName() + " not exists or setReadable failure.";
                        long j4 = a.C0242a.m;
                        if (!p.a(str2)) {
                            Log.d(a, ".checkFilesExistsAndPermissions failure, because " + str2);
                        }
                        return j4;
                    }
                }
                File file3 = new File(file, "assets");
                if (!p.b(file3, file)) {
                    long j5 = a.C0242a.n;
                    if (!p.a("resource dir modifyFilePermissionsDirFromTo failure.")) {
                        Log.d(a, ".checkFilesExistsAndPermissions failure, because " + "resource dir modifyFilePermissionsDirFromTo failure.");
                    }
                    return j5;
                }
                File[] listFiles = p.b(file3, bt.RES_PAKS_DIR_NAME).listFiles();
                for (File file4 : listFiles) {
                    if (!file4.exists() || !g.a(file4)) {
                        String str3 = file4.getName() + " not exists or setReadable failure.";
                        long j6 = a.C0242a.o;
                        if (!p.a(str3)) {
                            Log.d(a, ".checkFilesExistsAndPermissions failure, because " + str3);
                        }
                        return j6;
                    }
                }
                File parentFile = new File(p.a(file, strArr[0])).getParentFile();
                if (!p.b(parentFile, file)) {
                    long j7 = a.C0242a.p;
                    if (!p.a("so dir modifyFilePermissionsDirFromTo failure.")) {
                        Log.d(a, ".checkFilesExistsAndPermissions failure, because " + "so dir modifyFilePermissionsDirFromTo failure.");
                    }
                    return j7;
                } else if (!parentFile.exists() || !g.a(parentFile)) {
                    String str4 = parentFile.getName() + " not exists or setReadable failure.";
                    long j8 = a.C0242a.q;
                    if (!p.a(str4)) {
                        Log.d(a, ".checkFilesExistsAndPermissions failure, because " + str4);
                    }
                    return j8;
                } else {
                    for (String str5 : strArr) {
                        File file5 = new File(parentFile, str5);
                        if (!file5.exists()) {
                            String str6 = file5.getName() + " not exists.";
                            long j9 = a.C0242a.r;
                            if (!p.a(str6)) {
                                Log.d(a, ".checkFilesExistsAndPermissions failure, because " + str6);
                            }
                            return j9;
                        } else if (!g.b(file5)) {
                            String str7 = file5.getName() + " setExecutable failure.";
                            long j10 = a.C0242a.s;
                            if (!p.a(str7)) {
                                Log.d(a, ".checkFilesExistsAndPermissions failure, because " + str7);
                            }
                            return j10;
                        } else if (!g.a(file5)) {
                            String str8 = file5.getName() + " setReadable failure.";
                            long j11 = a.C0242a.t;
                            if (!p.a(str8)) {
                                Log.d(a, ".checkFilesExistsAndPermissions failure, because " + str8);
                            }
                            return j11;
                        }
                    }
                    if (p.a((String) null)) {
                        return 0;
                    }
                    Log.d(a, ".checkFilesExistsAndPermissions failure, because " + ((String) null));
                    return 0;
                }
            }
        } catch (Throwable th) {
            if (!p.a(str)) {
                Log.d(a, ".checkFilesExistsAndPermissions failure, because " + str);
            }
            throw th;
        }
    }

    private static long a(File file, DexClassLoader dexClassLoader) {
        return a(file, com.uc.webview.export.internal.utility.h.f(dexClassLoader));
    }

    private void a(Map<String, Object> map) {
        String str;
        String str2;
        try {
            ValueCallback valueCallback = (ValueCallback) getOption(UCCore.OPTION_START_INIT_UC_CORE);
            if (valueCallback != null) {
                Bundle bundle = new Bundle();
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    if (entry.getValue() instanceof String) {
                        str = entry.getKey();
                        str2 = (String) entry.getValue();
                    } else {
                        str = entry.getKey();
                        str2 = entry.getValue() == null ? "null" : entry.getValue().toString();
                    }
                    bundle.putString(str, str2);
                }
                valueCallback.onReceiveValue(bundle);
            }
        } catch (Throwable th) {
            Log.d(a, "init core callback", th);
        }
        String str3 = a;
        Log.d(str3, "initCore options: " + map);
        c();
        SetupTask e2 = e();
        ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) e2.setOptions(this.mOptions)).setParent(this)).setCallbacks(this.mCallbacks)).setup(UCCore.OPTION_DECOMPRESS_ROOT_DIR, this.mOptions.get(UCCore.OPTION_BUSINESS_DECOMPRESS_ROOT_PATH))).setAsDefault();
        a((BaseSetupTask) e2);
        for (Map.Entry<String, Object> entry2 : map.entrySet()) {
            e2.setup(entry2.getKey(), entry2.getValue());
        }
        e2.start();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.uc.webview.export.internal.setup.BaseSetupTask */
    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void a(a aVar, String str, BaseSetupTask baseSetupTask) {
        ValueCallback valueCallback;
        for (Map.Entry<String, Pair<ValueCallback<BaseSetupTask>, ValueCallback<BaseSetupTask>>> entry : aVar.n.entrySet()) {
            if (str.equals(entry.getKey()) && (valueCallback = (ValueCallback) entry.getValue().first) != null) {
                try {
                    valueCallback.onReceiveValue(baseSetupTask != 0 ? baseSetupTask : aVar);
                } catch (Throwable th) {
                    String str2 = a;
                    Log.d(str2, str + " callback", th);
                }
            }
        }
    }

    static /* synthetic */ void a(a aVar, String str) {
        h hVar = new h(aVar, str);
        IWaStat.WaStat.statAKV(new Pair(IWaStat.BUSINESS_ELAPSE_KEY, hVar));
        String str2 = a;
        Log.d(str2, "elapseStatMaps: " + hVar);
    }
}
