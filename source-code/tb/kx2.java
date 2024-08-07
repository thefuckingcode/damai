package tb;

import android.app.Application;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alibaba.aliweex.IConfigAdapter;
import com.alibaba.aliweex.adapter.IConfigGeneratorAdapter;
import com.alibaba.aliweex.adapter.IConfigModuleAdapter;
import com.alibaba.aliweex.adapter.IConfigModuleListener;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.cache.RegisterCache;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class kx2 {
    public static final String INIT_CONFIG_GROUP = "android_weex_ext_config";
    public static final String WXAPM_CONFIG_GROUP = "wxapm";
    public static final String key_back_to_home_when_exception = "backToHomeWhenException";
    public static final String key_enableAutoScan = "enableAutoScan";
    public static final String key_enableBackUpThread = "enableBackUpThread";
    public static final String key_enableBackUpThreadCache = "enableBackUpThreadCache";
    public static final String key_enableRegisterCache = "enableRegisterCache";
    public static final String key_enable_init_async = "enableInitAsync";
    public static final String key_enable_lazy_init = "enableLazyInit";
    public static final String key_enable_mtop_usecache = "enableMtopCache";
    public static final String key_enable_so_loader = "enableInitSoLoader";
    public static final String key_initLeftSize = "initLeftSize";
    private static volatile kx2 s;
    public b a = null;
    public b b = null;
    public b c = null;
    public b d = null;
    public b e = null;
    public b f = null;
    public b g = null;
    public b h = null;
    public b i = null;
    public b j = null;
    public b k = null;
    public b l = null;
    public b m = null;
    public b n = null;
    private IConfigModuleAdapter o = null;
    private IConfigModuleListener p = null;
    private SharedPreferences q = null;
    private List<b> r = new ArrayList();

    /* compiled from: Taobao */
    class a implements IConfigModuleListener {
        a() {
        }

        @Override // com.alibaba.aliweex.adapter.IConfigModuleListener
        public void onConfigUpdate(String str, Map<String, String> map) {
            IConfigAdapter c = com.alibaba.aliweex.a.l().c();
            if (c != null) {
                for (b bVar : kx2.this.r) {
                    if (bVar.a.equals(str)) {
                        kx2.this.g(c, bVar);
                    }
                }
                if ("android_weex_ext_config".equals(str)) {
                    kx2.this.d();
                }
            }
        }
    }

    /* compiled from: Taobao */
    public static class b {
        public String a;
        public String b;
        public String c;
        public String d = null;

        b(String str, String str2, String str3) {
            this.b = str;
            this.c = str2;
            this.a = str3;
        }
    }

    private kx2() {
        l();
        IConfigGeneratorAdapter d2 = com.alibaba.aliweex.a.l().d();
        if (d2 != null) {
            this.o = d2.generateConfigInstance("");
            this.p = new a();
            n(new String[]{"android_weex_ext_config", WXAPM_CONFIG_GROUP});
        }
        e();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void d() {
        RegisterCache.getInstance().setEnableAutoScan("true".equals(f(key_enableAutoScan, "false")));
    }

    private synchronized void e() {
        if (this.q == null) {
            Application b2 = com.alibaba.aliweex.a.l().b();
            if (b2 != null) {
                this.q = b2.getSharedPreferences("weex_init_config", 0);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void g(IConfigAdapter iConfigAdapter, b bVar) {
        p(bVar.b, iConfigAdapter.getConfig(bVar.a, bVar.b, bVar.c));
    }

    public static kx2 j() {
        if (s == null) {
            synchronized (kx2.class) {
                if (s == null) {
                    s = new kx2();
                }
            }
        }
        return s;
    }

    private void l() {
        boolean e2 = vx2.e();
        WXLogUtils.e("aliweex initInitConfig:" + e2);
        b bVar = new b(key_enableAutoScan, e2 ? "false" : "true", "android_weex_ext_config");
        this.a = bVar;
        this.r.add(bVar);
        b bVar2 = new b(key_enableRegisterCache, e2 ? "true" : "false", "android_weex_ext_config");
        this.b = bVar2;
        this.r.add(bVar2);
        b bVar3 = new b(key_enableBackUpThread, e2 ? "true" : "false", "android_weex_ext_config");
        this.d = bVar3;
        this.r.add(bVar3);
        b bVar4 = new b(key_enableBackUpThreadCache, "true", "android_weex_ext_config");
        this.e = bVar4;
        this.r.add(bVar4);
        b bVar5 = new b(key_enable_so_loader, "true", "android_weex_ext_config");
        this.c = bVar5;
        this.r.add(bVar5);
        b bVar6 = new b(key_initLeftSize, "50", "android_weex_ext_config");
        this.f = bVar6;
        this.r.add(bVar6);
        b bVar7 = new b(key_enable_lazy_init, "true", "android_weex_ext_config");
        this.g = bVar7;
        this.r.add(bVar7);
        b bVar8 = new b(key_enable_init_async, "true", "android_weex_ext_config");
        this.h = bVar8;
        this.r.add(bVar8);
        b bVar9 = new b(key_back_to_home_when_exception, "false", "android_weex_ext_config");
        this.n = bVar9;
        this.r.add(bVar9);
        b bVar10 = new b("use_runtime_api", "0", WXAPM_CONFIG_GROUP);
        this.i = bVar10;
        this.r.add(bVar10);
        b bVar11 = new b("enableAlarmSignal", "true", WXAPM_CONFIG_GROUP);
        this.j = bVar11;
        this.r.add(bVar11);
        b bVar12 = new b("loadRaxPkg", "true", WXAPM_CONFIG_GROUP);
        this.k = bVar12;
        this.r.add(bVar12);
        b bVar13 = new b("release_map", "true", WXAPM_CONFIG_GROUP);
        this.l = bVar13;
        this.r.add(bVar13);
        b bVar14 = new b(key_enable_mtop_usecache, "false", "android_weex_ext_config");
        this.m = bVar14;
        this.r.add(bVar14);
    }

    private synchronized void p(String str, String str2) {
        e();
        if (this.q != null && !TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str2)) {
                WXLogUtils.e("save Init Config : " + str + ":" + str2);
                SharedPreferences.Editor edit = this.q.edit();
                edit.putString(str, str2);
                edit.commit();
            }
        }
    }

    public synchronized String f(String str, String str2) {
        e();
        SharedPreferences sharedPreferences = this.q;
        if (sharedPreferences != null) {
            if (str != null) {
                str2 = sharedPreferences.getString(str, str2);
            }
        }
        return str2;
    }

    public synchronized String h(b bVar) {
        if (bVar == null) {
            return null;
        }
        if (bVar.d == null) {
            bVar.d = o(bVar.a, bVar.b, bVar.c);
        }
        return bVar.d;
    }

    public synchronized String i(b bVar) {
        if (bVar == null) {
            return null;
        }
        return f(bVar.b, bVar.c);
    }

    public void k() {
        int i2;
        if (m()) {
            String i3 = i(this.a);
            WXLogUtils.e("updateGlobalConfig enableAutoScan " + i3);
            RegisterCache.getInstance().setEnableAutoScan("true".equals(i3));
            String i4 = i(this.b);
            WXLogUtils.e("updateGlobalConfig enableRegisterCache " + i4);
            RegisterCache.getInstance().setEnable("true".equals(i4));
            String f2 = f(key_initLeftSize, "50");
            WXLogUtils.e("updateGlobalConfig initLeftSize " + f2);
            try {
                i2 = Integer.parseInt(f2);
            } catch (Exception unused) {
                i2 = 50;
            }
            RegisterCache.getInstance().setDoNotCacheSize(i2);
        }
    }

    public boolean m() {
        if (this.q == null) {
            e();
        }
        return this.o != null;
    }

    /* access modifiers changed from: package-private */
    public void n(String[] strArr) {
        IConfigModuleAdapter iConfigModuleAdapter = this.o;
        if (iConfigModuleAdapter != null) {
            iConfigModuleAdapter.registerListener(strArr, this.p);
        }
    }

    public String o(String str, String str2, String str3) {
        String f2 = f(str2, str3);
        IConfigAdapter c2 = com.alibaba.aliweex.a.l().c();
        if (c2 == null) {
            return f2;
        }
        return c2.getConfig(str, str2, f2);
    }
}
