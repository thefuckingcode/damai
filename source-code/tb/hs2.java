package tb;

import com.taobao.update.adapter.UpdateMonitor;

/* compiled from: Taobao */
public class hs2 {
    public boolean apkUpdateEnabled;
    public boolean bundleUpdateEnabled;
    public boolean checkUpdateOnStartUp;
    public ul config;
    public boolean enableNativeLibUpdate;
    public boolean hasTest;
    public boolean lightApkEnabled;

    public hs2(ul ulVar) {
        this.config = ulVar;
    }

    private Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public hs2 enableApkUpdate() {
        this.apkUpdateEnabled = true;
        return this;
    }

    public hs2 enableCheckUpdateOnStartup() {
        this.checkUpdateOnStartUp = true;
        return this;
    }

    public hs2 enableMonitor(UpdateMonitor updateMonitor) {
        Class a;
        if (updateMonitor == null && (a = a("com.taobao.update.monitor.UpdateMonitorImpl")) != null) {
            eb.registerClass(a);
        } else if (updateMonitor != null) {
            eb.registerInstance(updateMonitor);
        } else {
            eb.registerInstance(new UpdateMonitor.a());
        }
        return this;
    }
}
