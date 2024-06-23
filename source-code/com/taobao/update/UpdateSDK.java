package com.taobao.update;

import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.taobao.orange.OrangeConfig;
import com.taobao.orange.OrangeConfigListener;
import com.taobao.update.datasource.UpdateDataSource;
import com.taobao.update.framework.UpdateRuntime;
import com.taobao.update.instantpatch.InstantPatchUpdater;
import java.util.ArrayList;
import java.util.List;
import tb.fs2;
import tb.hs2;
import tb.js2;
import tb.k6;
import tb.ks2;
import tb.lj;
import tb.m20;
import tb.ns2;
import tb.qc2;
import tb.ul;
import tb.uo;

/* compiled from: Taobao */
public class UpdateSDK {
    private List<ks2> a = new ArrayList();

    /* compiled from: Taobao */
    class a implements OrangeConfigListener {
        final /* synthetic */ hs2 a;

        a(UpdateSDK updateSDK, hs2 hs2) {
            this.a = hs2;
        }

        @Override // com.taobao.orange.OrangeConfigListener
        public void onConfigUpdate(String str) {
            String config = OrangeConfig.getInstance().getConfig(js2.UPDATE_CONFIG_GROUP, js2.AUTO_START_BUNDLES, "");
            if (!TextUtils.isEmpty(config)) {
                PreferenceManager.getDefaultSharedPreferences(this.a.config.application).edit().putString(js2.AUTO_START_BUNDLES, config).apply();
            }
        }
    }

    public UpdateSDK(hs2 hs2) {
        ul ulVar = hs2.config;
        if (ulVar != null) {
            if (!UpdateDataSource.inited) {
                UpdateDataSource.getInstance().init(ulVar.application, ulVar.group, ulVar.ttid, ulVar.isOutApk, new fs2());
                this.a.add(new m20(ulVar));
            }
            b(ulVar);
            if (hs2.apkUpdateEnabled) {
                this.a.add(new k6());
            }
            this.a.add(new lj());
            InstantPatchUpdater.instance().init(ulVar.application);
            UpdateDataSource.getInstance().registerListener(js2.HOTPATCH, InstantPatchUpdater.instance());
            this.a.add(InstantPatchUpdater.instance());
            if (ulVar.enabledSoLoader) {
                qc2 instance = qc2.instance();
                instance.init(ulVar.application);
                UpdateDataSource.getInstance().registerListener(instance.registerName(), instance);
                this.a.add(instance);
            }
        }
    }

    private void b(ul ulVar) {
        int currentRuntimeCpuArchValue = uo.getCurrentRuntimeCpuArchValue(ulVar.application);
        String versionName = ns2.getVersionName();
        if (PreferenceManager.getDefaultSharedPreferences(ulVar.application).getInt(versionName.concat("_bit_runtime"), 0) == 0) {
            AppMonitor.Counter.commit("update-sdk", "bit-runtime", (double) currentRuntimeCpuArchValue);
            PreferenceManager.getDefaultSharedPreferences(ulVar.application).edit().putInt(versionName.concat("_bit_runtime"), currentRuntimeCpuArchValue).apply();
        }
    }

    public void init(hs2 hs2) {
        for (ks2 ks2 : this.a) {
            try {
                ks2.init(hs2.config.application);
            } catch (Throwable th) {
                Log.e("UpdateSDK", " updateLifeCycle:" + ks2.getClass().getName(), th);
            }
        }
        if (hs2.checkUpdateOnStartUp) {
            UpdateDataSource.getInstance().startUpdate(true, false);
        }
        OrangeConfig.getInstance().registerListener(new String[]{js2.UPDATE_CONFIG_GROUP}, new a(this, hs2));
    }

    public void onBackground() {
        for (ks2 ks2 : this.a) {
            ks2.onBackground();
        }
    }

    public void onExit() {
        for (ks2 ks2 : this.a) {
            ks2.onExit();
        }
    }

    public void onForeground() {
        UpdateRuntime.execute(new Runnable() {
            /* class com.taobao.update.UpdateSDK.AnonymousClass2 */

            public void run() {
                for (ks2 ks2 : UpdateSDK.this.a) {
                    ks2.onForeground();
                }
            }
        });
    }
}
