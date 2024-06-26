package com.taobao.accs.init;

import android.app.Application;
import android.content.ComponentName;
import android.text.TextUtils;
import anet.channel.util.AppLifecycle;
import com.taobao.accs.ACCSClient;
import com.taobao.accs.AccsException;
import com.taobao.accs.AccsIPCProvider;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.OrangeAdapter;
import com.taobao.aranger.ARanger;
import io.flutter.wpkbridge.WPKFactory;
import java.io.Serializable;
import java.util.HashMap;

/* compiled from: Taobao */
public class Launcher_CrossActivityStopped implements Serializable {
    public void init(Application application, HashMap<String, Object> hashMap) {
        try {
            ALog.e("Launcher_CrossActivityStopped", "onStopped", new Object[0]);
            AppLifecycle.d();
            if (!TextUtils.isEmpty(Launcher_InitAccs.mAppkey)) {
                if (Launcher_InitAccs.mContext != null) {
                    if (!Launcher_InitAccs.mIsInited) {
                        return;
                    }
                    if (!OrangeAdapter.isChannelModeEnable() || ARanger.isConnect(new ComponentName(Launcher_InitAccs.mContext, AccsIPCProvider.class))) {
                        ThreadPoolExecutorFactory.execute(new Runnable() {
                            /* class com.taobao.accs.init.Launcher_CrossActivityStopped.AnonymousClass1 */

                            public void run() {
                                try {
                                    ACCSClient.getAccsClient().bindApp(Launcher_InitAccs.mTtid, Launcher_InitAccs.mAppReceiver);
                                } catch (AccsException e) {
                                    ALog.e("Launcher_CrossActivityStopped", "bindApp", e, new Object[0]);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
            }
            ALog.e("Launcher_CrossActivityStopped", "params null!!!", "appkey", Launcher_InitAccs.mAppkey, WPKFactory.INIT_KEY_CONTEXT, Launcher_InitAccs.mContext);
        } catch (Throwable th) {
            ALog.e("Launcher_CrossActivityStopped", "onStoped", th, new Object[0]);
            th.printStackTrace();
        }
    }
}
