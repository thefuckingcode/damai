package cn.damai.launcher.jacoco;

import android.app.Activity;
import android.app.Application;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.RequiresApi;
import cn.damai.common.AppConfig;
import cn.damai.homepage.R$string;
import cn.damai.launcher.initialize.ProcessUtils;
import cn.damai.launcher.jacoco.AppBackgroundManager;
import com.alipay.android.phone.wallet.apcoverage.AppInfo;
import com.alipay.android.phone.wallet.apcoverage.core.CodeCoverManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.accs.common.Constants;
import java.io.Serializable;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import tb.d20;

/* compiled from: Taobao */
public class ICoverInitImpl implements ICoverInit, Serializable {
    private static transient /* synthetic */ IpChange $ipChange;

    @RequiresApi(api = 14)
    private void jacocoInit(final Application application) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1872864393")) {
            ipChange.ipc$dispatch("-1872864393", new Object[]{this, application});
            return;
        }
        try {
            str = application.getString(application.getResources().getIdentifier("runtimeinfo", "string", application.getPackageName()));
        } catch (Exception e) {
            e.printStackTrace();
            str = "";
        }
        if (AppConfig.v() && !TextUtils.isEmpty(str)) {
            application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks(this) {
                /* class cn.damai.launcher.jacoco.ICoverInitImpl.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void onActivityCreated(Activity activity, Bundle bundle) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1023973882")) {
                        ipChange.ipc$dispatch("-1023973882", new Object[]{this, activity, bundle});
                    }
                }

                public void onActivityDestroyed(Activity activity) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1643178557")) {
                        ipChange.ipc$dispatch("1643178557", new Object[]{this, activity});
                    }
                }

                public void onActivityPaused(Activity activity) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1900688586")) {
                        ipChange.ipc$dispatch("1900688586", new Object[]{this, activity});
                    }
                }

                public void onActivityResumed(Activity activity) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1596697601")) {
                        ipChange.ipc$dispatch("-1596697601", new Object[]{this, activity});
                    }
                }

                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1319268899")) {
                        ipChange.ipc$dispatch("-1319268899", new Object[]{this, activity, bundle});
                    }
                }

                public void onActivityStarted(Activity activity) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1884013717")) {
                        ipChange.ipc$dispatch("1884013717", new Object[]{this, activity});
                        return;
                    }
                    AppBackgroundManager.getInstance().a(activity.getLocalClassName());
                }

                public void onActivityStopped(Activity activity) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1675182281")) {
                        ipChange.ipc$dispatch("1675182281", new Object[]{this, activity});
                        return;
                    }
                    AppBackgroundManager.getInstance().b();
                }
            });
            if (ProcessUtils.b(application)) {
                AppInfo appInfo = new AppInfo();
                appInfo.setProductName("damai");
                appInfo.setConfigUrl("http://11.159.185.205:8081/testRecord/uploadConfig.json");
                appInfo.setUploadUrl("http://11.159.185.205:8081/testRecord/upload.json");
                JSONObject jSONObject = new JSONObject();
                try {
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject = new JSONObject(str);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                try {
                    jSONObject.put(Constants.KEY_USER_ID, d20.i());
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                appInfo.setRuntimeInfo(jSONObject);
                StringBuilder sb = new StringBuilder();
                sb.append("jacocoInit v = ");
                Resources resources = application.getResources();
                int i = R$string.app_mtl_version;
                sb.append(resources.getString(i));
                Log.d("jacocoInit", sb.toString());
                appInfo.setVersion(application.getResources().getString(i));
                appInfo.setAppContext(application.getApplicationContext());
                CodeCoverManager.getInstance().registerSubProcessService(new HashMap());
                CodeCoverManager.getInstance().setDebugMode(true);
                try {
                    CodeCoverManager.getInstance().init(appInfo);
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            AppBackgroundManager.getInstance().setAppStateListener(new AppBackgroundManager.IAppStateChangeListener(this) {
                /* class cn.damai.launcher.jacoco.ICoverInitImpl.AnonymousClass2 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.launcher.jacoco.AppBackgroundManager.IAppStateChangeListener
                public void onAppStateChanged(boolean z) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1144240924")) {
                        ipChange.ipc$dispatch("-1144240924", new Object[]{this, Boolean.valueOf(z)});
                        return;
                    }
                    Log.d("jacocoInit", "isAppForceground = " + z);
                    if (z) {
                        CodeCoverManager.getInstance().onAppForeground(application.getApplicationContext());
                    } else {
                        CodeCoverManager.getInstance().onAppBackground(application.getApplicationContext());
                    }
                }
            });
        }
    }

    @Override // cn.damai.launcher.jacoco.ICoverInit
    public void init(Application application) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "883058248")) {
            ipChange.ipc$dispatch("883058248", new Object[]{this, application});
        } else if (Build.VERSION.SDK_INT >= 14) {
            jacocoInit(application);
        }
    }
}
