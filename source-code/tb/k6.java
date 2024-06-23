package tb;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.update.adapter.UpdateMonitor;
import com.taobao.update.apk.MainUpdateData;
import com.taobao.update.apk.a;
import com.taobao.update.apk.history.ApkUpdateHistory;
import com.taobao.update.datasource.UpdateDataSource;
import com.taobao.update.datasource.UpdateListener;
import com.taobao.update.datasource.logger.Log;
import com.taobao.update.framework.UpdateRuntime;
import com.taobao.update.main.R$string;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/* compiled from: Taobao */
public class k6 extends ks2 implements UpdateListener {
    private UpdateListener.PatchListener a;
    private UpdateMonitor b;
    private Log c = y91.getLog(k6.class, (Log) null);

    public k6() {
        UpdateDataSource.getInstance().registerListener(js2.MAIN, this);
        this.b = (UpdateMonitor) eb.getInstance(UpdateMonitor.class);
        try {
            b();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a() {
        File file = new File(ns2.getStorePath(UpdateRuntime.getContext()) + "/apkupdate");
        if (file.exists() && file.listFiles() != null) {
            String versionName = ns2.getVersionName();
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (ns2.greaterThen(versionName, file2.getName())) {
                    ee.deleteDir(file2);
                }
            }
        }
    }

    private void b() {
        String str;
        String str2;
        ApkUpdateHistory.Data data = ApkUpdateHistory.getData();
        if (data != null) {
            boolean equals = ns2.getVersionName().equals(data.toVersion);
            if (equals) {
                try {
                    new File(data.ext).delete();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (!equals) {
                str2 = String.valueOf(ns2.getVersionName().equals(data.fromVersion) ? -71 : -72);
                str = "fromVersion=" + data.fromVersion + ",toVersion=" + data.toVersion;
            } else {
                str2 = "";
                str = str2;
            }
            UpdateMonitor updateMonitor = this.b;
            if (updateMonitor != null) {
                updateMonitor.add("apefficiency", equals, "install", str2, str, data.fromVersion, data.toVersion, "");
                this.b.commit("apefficiency");
            }
            ApkUpdateHistory.reset();
        }
        a();
    }

    @Override // tb.ks2
    public boolean doUpdate(JSONObject jSONObject, boolean z, String str) {
        if (jSONObject != null && ns2.greaterThen(jSONObject.getString("version"), ns2.getVersionName())) {
            UpdateListener.PatchListener patchListener = this.a;
            if (patchListener != null) {
                patchListener.patchStart();
            }
            try {
                MainUpdateData mainUpdateData = (MainUpdateData) ns2.toJavaObject(jSONObject, MainUpdateData.class);
                File file = new File("/sdcard/test_pri.txt");
                if (file.exists()) {
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                        String trim = bufferedReader.readLine().trim();
                        android.util.Log.e("update", " FIXME delete before release ... " + trim);
                        if (trim != null) {
                            mainUpdateData.remindStrategy = Integer.valueOf(trim).intValue();
                            String trim2 = bufferedReader.readLine().trim();
                            if (trim2 != null) {
                                mainUpdateData.remindCount = Integer.valueOf(trim2).intValue();
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
                android.util.Log.e("main_update", JSON.toJSONString(mainUpdateData));
                dj2 execute = new a().execute(z, mainUpdateData);
                if (execute == null || !execute.success) {
                    UpdateListener.PatchListener patchListener2 = this.a;
                    if (patchListener2 == null) {
                        return true;
                    }
                    patchListener2.patchFailed(execute.errorMsg);
                    return true;
                }
                UpdateDataSource.getInstance().clearCache();
                UpdateListener.PatchListener patchListener3 = this.a;
                if (patchListener3 == null) {
                    return true;
                }
                patchListener3.patchSuccess();
                return true;
            } catch (Throwable th) {
                th.printStackTrace();
                return true;
            }
        } else if (z) {
            return false;
        } else {
            UpdateRuntime.toast(ns2.getAppNameString(R$string.notice_noupdate, UpdateRuntime.sAppName));
            return false;
        }
    }

    @Override // com.taobao.update.datasource.UpdateListener
    public void onUpdate(boolean z, JSONObject jSONObject, String str) {
        doUpdate(jSONObject, z, str);
    }

    @Override // com.taobao.update.datasource.UpdateListener
    public void patchProcessListener(UpdateListener.PatchListener patchListener) {
        this.a = patchListener;
    }
}
