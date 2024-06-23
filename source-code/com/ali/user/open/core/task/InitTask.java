package com.ali.user.open.core.task;

import android.webkit.CookieSyncManager;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.callback.InitResultCallback;
import com.ali.user.open.core.config.ConfigManager;
import com.ali.user.open.core.context.KernelContext;
import com.ali.user.open.core.device.DeviceInfo;
import com.ali.user.open.core.exception.MemberSDKException;
import com.ali.user.open.core.service.MemberExecutorService;
import com.ali.user.open.core.service.RpcService;
import com.ali.user.open.core.service.StorageService;
import com.ali.user.open.core.service.UserTrackerService;
import com.ali.user.open.core.service.impl.ExecutorServiceImpl;
import com.ali.user.open.core.trace.SDKLogger;
import com.ali.user.open.core.util.CommonUtils;
import com.ali.user.open.core.util.ReflectionUtils;
import com.ali.user.open.tbauth.TbAuthLifecycleAdapter;
import com.uc.webview.export.extension.UCCore;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: Taobao */
public class InitTask implements Callable<Void> {
    private static final String TAG = "initTask";
    private InitResultCallback initResultCallback;

    public InitTask(InitResultCallback initResultCallback2) {
        this.initResultCallback = initResultCallback2;
    }

    private void asyncRun() {
        if (!initialize()) {
            SDKLogger.d(TAG, "INIT FAILURE");
            KernelContext.executorService.postUITask(new Runnable() {
                /* class com.ali.user.open.core.task.InitTask.AnonymousClass1 */

                public void run() {
                    if (InitTask.this.initResultCallback != null) {
                        InitTask.this.initResultCallback.onFailure(-1, "service register fail");
                    }
                }
            });
            return;
        }
        KernelContext.executorService.postUITask(new Runnable() {
            /* class com.ali.user.open.core.task.InitTask.AnonymousClass2 */

            public void run() {
                if (InitTask.this.initResultCallback != null) {
                    InitTask.this.initResultCallback.onSuccess();
                }
            }
        });
        SDKLogger.d(TAG, "INIT SUCCESS");
    }

    private Object getServiceInstance(String str, String[] strArr, Object[] objArr) {
        try {
            return ReflectionUtils.newInstance(str, strArr, objArr);
        } catch (NoSuchMethodError e) {
            e.printStackTrace();
            return null;
        }
    }

    private void initUtdid() {
        DeviceInfo.init(KernelContext.getApplicationContext());
    }

    private boolean initialize() {
        SDKLogger.d(TAG, "sdk version = 4.7.1");
        initUtdid();
        try {
            CookieSyncManager.createInstance(KernelContext.getApplicationContext());
            if (!initializeCoreComponents()) {
                return false;
            }
            KernelContext.sdkInitialized = Boolean.TRUE;
            return true;
        } catch (Throwable th) {
            SDKLogger.e(TAG, "fail to sync start", th);
            doWhenException(th);
            return false;
        }
    }

    private boolean initializeCoreComponents() {
        KernelContext.wrapServiceRegistry();
        ConfigManager.getInstance().init();
        if (!registerRpc() || !registerStorage()) {
            return false;
        }
        try {
            ((StorageService) AliMemberSDK.getService(StorageService.class)).getAppKey();
            ((StorageService) AliMemberSDK.getService(StorageService.class)).getUmid();
            ((StorageService) AliMemberSDK.getService(StorageService.class)).getWUA();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (!registerUserTrack()) {
            return false;
        }
        ReflectionUtils.invoke("com.ali.user.open.module.SessionModule", UCCore.LEGACY_EVENT_INIT, null, null, null);
        ReflectionUtils.invoke("com.ali.user.open.oauth.module.OauthModule", UCCore.LEGACY_EVENT_INIT, null, null, null);
        ReflectionUtils.invoke("com.ali.user.open.ucc.module.UccModule", UCCore.LEGACY_EVENT_INIT, null, null, null);
        ReflectionUtils.invoke("com.ali.user.open.authorize.module.AuthorizeModule", UCCore.LEGACY_EVENT_INIT, null, null, null);
        KernelContext.registerService(new Class[]{MemberExecutorService.class, ExecutorService.class}, new ExecutorServiceImpl(), null);
        loadDownload();
        boolean loadLogin = loadLogin();
        CommonUtils.sendUT("init_step_ucc_load_success");
        SDKLogger.d(TAG, "INIT SUCCESS");
        return loadLogin;
    }

    private boolean loadDownload() {
        SDKLogger.d(TAG, "register download jsbridge");
        ReflectionUtils.invoke("com.ali.user.open.MemberDownload", UCCore.LEGACY_EVENT_INIT, null, Class.forName("com.ali.user.open.MemberDownload"), null);
        return true;
    }

    private boolean loadLogin() {
        SDKLogger.d(TAG, "register login service");
        try {
            ReflectionUtils.invoke("com.ali.user.open.tbauth.TbAuthLifecycleAdapter", UCCore.LEGACY_EVENT_INIT, null, TbAuthLifecycleAdapter.class, null);
        } catch (ClassNotFoundException unused) {
        }
        return true;
    }

    private boolean registerRpc() {
        SDKLogger.d(TAG, "registerRpc");
        try {
            Class[] clsArr = {RpcService.class};
            KernelContext.registerService(clsArr, getServiceInstance("com.ali.user.open.mtop.rpc.impl.MtopRpcServiceImpl", null, null), null);
            return true;
        } catch (NoSuchMethodError e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean registerStorage() {
        SDKLogger.d(TAG, "registerStorage");
        try {
            KernelContext.isMini = false;
        } catch (Throwable unused) {
        }
        try {
            Class[] clsArr = {StorageService.class};
            KernelContext.registerService(clsArr, getServiceInstance("com.ali.user.open.securityguard.SecurityGuardWrapper", null, null), null);
            return true;
        } catch (NoSuchMethodError e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean registerUserTrack() {
        SDKLogger.d(TAG, "registerUserTrack");
        try {
            Class[] clsArr = {UserTrackerService.class};
            KernelContext.registerService(clsArr, getServiceInstance("com.ali.user.open.ut.UserTrackerImpl", null, null), null);
            return true;
        } catch (NoSuchMethodError e) {
            e.printStackTrace();
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void doWhenException(Throwable th) {
        String str;
        int i;
        if (th instanceof MemberSDKException) {
            MemberSDKException memberSDKException = (MemberSDKException) th;
            i = memberSDKException.code;
            str = memberSDKException.message;
        } else {
            i = 10010;
            str = CommonUtils.toString(th);
        }
        CommonUtils.onFailure(this.initResultCallback, i, str);
    }

    @Override // java.util.concurrent.Callable
    public Void call() {
        ReentrantLock reentrantLock = KernelContext.initLock;
        reentrantLock.lock();
        try {
            asyncRun();
        } catch (Throwable th) {
            KernelContext.initLock.unlock();
            throw th;
        }
        reentrantLock.unlock();
        return null;
    }
}
