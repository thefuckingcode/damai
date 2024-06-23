package cn.damai.launcher.jacoco;

import android.app.Application;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class CoverInject implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String InitImplClass = "cn.damai.launcher.jacoco.ICoverInitImpl";

    public void loadCoverInit(Application application) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1875757273")) {
            ipChange.ipc$dispatch("-1875757273", new Object[]{this, application});
            return;
        }
        Log.d("CoverInject", "loadCoverInit start. =====   ");
        try {
            Class<?> loadClass = application.getClassLoader().loadClass(InitImplClass);
            if (loadClass == null) {
                Log.d("CoverInject", "class not found ");
                return;
            }
            ((ICoverInit) loadClass.newInstance()).init(application);
            Log.d("CoverInject", "iCoverInit.init(application)");
            Log.d("CoverInject", "loadCoverInit end. =====  ");
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("CoverInject", "inject error: " + e.getMessage());
        }
    }
}
