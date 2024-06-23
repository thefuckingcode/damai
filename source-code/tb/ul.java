package tb;

import android.app.Application;
import com.taobao.update.adapter.Log;
import com.taobao.update.adapter.NativeLibUpdateListener;
import com.taobao.update.adapter.ThreadExecutor;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class ul {
    public static List<String> blackDialogActivity = new ArrayList();
    public String appName;
    public Application application;
    public boolean autoStart = true;
    public int bundleUpdateMinDisk = 200;
    public String city;
    public boolean clickBackViewExitDialog;
    public int delayedKillAppTime = 5000;
    public int delayedStartTime;
    public boolean enableNavProcessor = false;
    public boolean enabledSoLoader = true;
    public boolean forceInstallAfaterDownload = false;
    public boolean foregroundRequest = true;
    public String group;
    public boolean installBundleAfterDownload = false;
    public boolean isOutApk = false;
    public Log logImpl;
    public int logoResourceId;
    public NativeLibUpdateListener nativeLibUpdateListener;
    public boolean popDialogBeforeInstall;
    public boolean push;
    public ThreadExecutor threadExecutorImpl;
    public String ttid;
    public Class uiConfirmClass = mp2.class;
    public Class uiNotifyClass = op2.class;
    public Class uiSysNotifyClass = qp2.class;
    public Class uiToastClass = rp2.class;

    public ul(Application application2) {
        this.application = application2;
    }
}
