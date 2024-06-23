package com.ali.user.open.ucc.remote;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.Site;
import com.ali.user.open.core.config.ConfigManager;
import com.ali.user.open.core.context.KernelContext;
import com.ali.user.open.core.model.LoginReturnData;
import com.ali.user.open.core.trace.SDKLogger;
import com.ali.user.open.core.util.CommonUtils;
import com.ali.user.open.service.SessionService;
import com.ali.user.open.session.Session;
import com.ali.user.open.ucc.IRemoteUccCallback;
import com.ali.user.open.ucc.IRemoteUccService;
import com.ali.user.open.ucc.UccCallback;
import com.ali.user.open.ucc.UccService;
import com.ali.user.open.ucc.UccServiceImpl;
import com.ali.user.open.ucc.UccServiceProviderFactory;
import com.ali.user.open.ucc.remote.broadcast.UccBroadcastHelper;
import com.ali.user.open.ucc.remote.broadcast.UccBroadcastReceiver;
import com.ali.user.open.ucc.util.UccConstants;
import com.alibaba.fastjson.JSON;
import com.taobao.orange.OConfigListener;
import com.taobao.orange.OrangeConfig;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeoutException;

/* compiled from: Taobao */
public class RemoteUccServiceDelegate extends UccServiceImpl {
    public static final String TAG = "UccServiceImpl";
    private static volatile RemoteUccServiceDelegate sInstance;
    private ServiceConnection conn = new ServiceConnection() {
        /* class com.ali.user.open.ucc.remote.RemoteUccServiceDelegate.AnonymousClass2 */

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (RemoteUccServiceDelegate.this.mLock) {
                RemoteUccServiceDelegate.this.mIRemoteUccService = IRemoteUccService.Stub.asInterface(iBinder);
                RemoteUccServiceDelegate.this.mLock.notifyAll();
            }
            try {
                iBinder.linkToDeath(RemoteUccServiceDelegate.this.mDeathRecipient, 0);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            RemoteUccServiceDelegate.this.mIRemoteUccService = null;
            SDKLogger.d("UccServiceImpl", "binder died");
        }
    };
    private IBinder.DeathRecipient mDeathRecipient = new IBinder.DeathRecipient() {
        /* class com.ali.user.open.ucc.remote.RemoteUccServiceDelegate.AnonymousClass1 */

        public void binderDied() {
            if (RemoteUccServiceDelegate.this.mIRemoteUccService != null) {
                RemoteUccServiceDelegate.this.mIRemoteUccService.asBinder().unlinkToDeath(RemoteUccServiceDelegate.this.mDeathRecipient, 0);
                RemoteUccServiceDelegate.this.mIRemoteUccService = null;
            }
            OrangeConfig.getInstance().registerListener(new String[]{"login4android"}, new OConfigListener() {
                /* class com.ali.user.open.ucc.remote.RemoteUccServiceDelegate.AnonymousClass1.AnonymousClass1 */

                @Override // com.taobao.orange.OConfigListener
                public void onConfigUpdate(String str, Map<String, String> map) {
                    try {
                        if (TextUtils.equals(OrangeConfig.getInstance().getConfig("login4android", "rebind_ucc_service_when_death", "false"), "true")) {
                            RemoteUccServiceDelegate.this.bindService();
                        }
                        OrangeConfig.getInstance().unregisterListener(new String[]{"login4android"}, this);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }, false);
        }
    };
    private IRemoteUccService mIRemoteUccService;
    private final Object mLock = new Object();

    public RemoteUccServiceDelegate() {
        if (ConfigManager.getInstance().isMultiProcessEnable && !TextUtils.equals(CommonUtils.getProcessName(KernelContext.getApplicationContext()), KernelContext.getApplicationContext().getPackageName())) {
            bindService();
            UccBroadcastHelper.registerLoginReceiver(KernelContext.getApplicationContext(), new UccBroadcastReceiver());
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void bindService() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(KernelContext.getApplicationContext().getPackageName(), "com.ali.user.open.ucc.remote.RemoteUccService"));
        KernelContext.getApplicationContext().bindService(intent, this.conn, 1);
    }

    public static RemoteUccServiceDelegate getInstance() {
        if (sInstance == null) {
            synchronized (RemoteUccServiceDelegate.class) {
                if (sInstance == null) {
                    sInstance = new RemoteUccServiceDelegate();
                }
            }
        }
        return sInstance;
    }

    @Override // com.ali.user.open.ucc.UccService, com.ali.user.open.ucc.UccServiceImpl
    public void bind(Activity activity, String str, String str2, UccCallback uccCallback) {
        bind(activity, str, str2, new HashMap(4), uccCallback);
    }

    @Override // com.ali.user.open.ucc.UccService, com.ali.user.open.ucc.UccServiceImpl
    public void cleanUp() {
        UccServiceProviderFactory.getInstance().cleanUp();
    }

    @Override // com.ali.user.open.ucc.UccService, com.ali.user.open.ucc.UccServiceImpl
    public Session getSession(String str) {
        if (!ConfigManager.getInstance().isMultiProcessEnable || TextUtils.equals(CommonUtils.getProcessName(KernelContext.getApplicationContext()), KernelContext.getApplicationContext().getPackageName())) {
            return UccServiceImpl.getInstance().getSession(str);
        }
        try {
            IRemoteUccService iRemoteUccService = this.mIRemoteUccService;
            if (iRemoteUccService == null) {
                bindService();
                return null;
            }
            String session = iRemoteUccService.getSession(str);
            if (TextUtils.isEmpty(session)) {
                return null;
            }
            return (Session) JSON.parseObject(session, Session.class);
        } catch (Throwable th) {
            th.printStackTrace();
            SDKLogger.e("UccServiceImpl", "remote unbind exception = " + th.getMessage());
            return null;
        }
    }

    @Override // com.ali.user.open.ucc.UccService, com.ali.user.open.ucc.UccServiceImpl
    public void logout(Context context, String str) {
        if (!ConfigManager.getInstance().isMultiProcessEnable || TextUtils.equals(CommonUtils.getProcessName(context.getApplicationContext()), context.getPackageName())) {
            UccServiceImpl.getInstance().logout(context, str);
            return;
        }
        try {
            IRemoteUccService iRemoteUccService = this.mIRemoteUccService;
            if (iRemoteUccService == null) {
                bindService();
            } else {
                iRemoteUccService.logout(str);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            SDKLogger.e("UccServiceImpl", "remote unbind exception = " + th.getMessage());
        }
    }

    @Override // com.ali.user.open.ucc.UccService, com.ali.user.open.ucc.UccServiceImpl
    public void logoutAll(Context context) {
        if (!ConfigManager.getInstance().isMultiProcessEnable || TextUtils.equals(CommonUtils.getProcessName(context.getApplicationContext()), context.getPackageName())) {
            UccServiceImpl.getInstance().logoutAll(context);
            return;
        }
        try {
            IRemoteUccService iRemoteUccService = this.mIRemoteUccService;
            if (iRemoteUccService == null) {
                bindService();
            } else {
                iRemoteUccService.logoutAll();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            SDKLogger.e("UccServiceImpl", "remote unbind exception = " + th.getMessage());
        }
    }

    @Override // com.ali.user.open.ucc.UccService, com.ali.user.open.ucc.UccServiceImpl
    public void trustLogin(Activity activity, @Site.SiteName String str, Map<String, String> map, UccCallback uccCallback) {
        if (activity == null) {
            trustLogin(str, map, uccCallback);
            return;
        }
        if (map != null) {
            map.remove("site");
        }
        if (!ConfigManager.getInstance().isMultiProcessEnable || TextUtils.equals(CommonUtils.getProcessName(KernelContext.getApplicationContext()), KernelContext.getApplicationContext().getPackageName())) {
            UccServiceImpl.getInstance().setUccDataProvider(((UccService) AliMemberSDK.getService(UccService.class)).getUccDataProvider());
            UccServiceImpl.getInstance().trustLogin(activity, str, map, uccCallback);
            return;
        }
        trustLogin(str, map, uccCallback);
    }

    @Override // com.ali.user.open.ucc.UccService, com.ali.user.open.ucc.UccServiceImpl
    public void unbind(@Site.SiteName String str, UccCallback uccCallback) {
        unbind(str, null, uccCallback);
    }

    public boolean waitUntilConnected(long j) throws InterruptedException, TimeoutException {
        try {
            IRemoteUccService iRemoteUccService = this.mIRemoteUccService;
            if (iRemoteUccService != null && iRemoteUccService.asBinder() != null) {
                return true;
            }
            synchronized (this.mLock) {
                this.mLock.wait(j);
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.ali.user.open.ucc.UccService, com.ali.user.open.ucc.UccServiceImpl
    public void bind(Activity activity, @NonNull String str, String str2, Map<String, String> map, UccCallback uccCallback) {
        if (activity == null) {
            bind(str, str2, map, uccCallback);
            return;
        }
        if (map != null) {
            map.remove("site");
        }
        if (!ConfigManager.getInstance().isMultiProcessEnable || TextUtils.equals(CommonUtils.getProcessName(activity.getApplicationContext()), activity.getPackageName())) {
            UccServiceImpl.getInstance().setUccDataProvider(((UccService) AliMemberSDK.getService(UccService.class)).getUccDataProvider());
            UccServiceImpl.getInstance().bind(activity, str, str2, map, uccCallback);
            return;
        }
        bind(str, str2, map, uccCallback);
    }

    @Override // com.ali.user.open.ucc.UccService, com.ali.user.open.ucc.UccServiceImpl
    public void unbind(final String str, final Map<String, String> map, final UccCallback uccCallback) {
        if (map != null) {
            map.remove("site");
        }
        if (!ConfigManager.getInstance().isMultiProcessEnable || TextUtils.equals(CommonUtils.getProcessName(KernelContext.getApplicationContext()), KernelContext.getApplicationContext().getPackageName())) {
            UccServiceImpl.getInstance().setUccDataProvider(((UccService) AliMemberSDK.getService(UccService.class)).getUccDataProvider());
            UccServiceImpl.getInstance().unbind(str, map, uccCallback);
            return;
        }
        if (map == null) {
            try {
                map = new HashMap<>();
            } catch (Throwable th) {
                th.printStackTrace();
                SDKLogger.e("UccServiceImpl", "remote unbind exception = " + th.getMessage());
                if (uccCallback != null) {
                    uccCallback.onFail(str, 1999, "");
                    return;
                }
                return;
            }
        }
        map.put("process", CommonUtils.getProcessName(KernelContext.getApplicationContext()));
        ((ExecutorService) AliMemberSDK.getService(ExecutorService.class)).execute(new Runnable() {
            /* class com.ali.user.open.ucc.remote.RemoteUccServiceDelegate.AnonymousClass4 */

            public void run() {
                try {
                    if (RemoteUccServiceDelegate.this.mIRemoteUccService == null || RemoteUccServiceDelegate.this.mIRemoteUccService.asBinder() == null || !RemoteUccServiceDelegate.this.mIRemoteUccService.asBinder().isBinderAlive()) {
                        RemoteUccServiceDelegate.this.bindService();
                        RemoteUccServiceDelegate.this.waitUntilConnected(DanmakuFactory.DEFAULT_DANMAKU_DURATION_V);
                    }
                    if (RemoteUccServiceDelegate.this.mIRemoteUccService != null) {
                        RemoteUccServiceDelegate.this.mIRemoteUccService.unbind(str, map, new IRemoteUccCallback.Stub() {
                            /* class com.ali.user.open.ucc.remote.RemoteUccServiceDelegate.AnonymousClass4.AnonymousClass1 */

                            @Override // com.ali.user.open.ucc.IRemoteUccCallback
                            public void onFail(String str, int i, String str2) throws RemoteException {
                                UccCallback uccCallback = uccCallback;
                                if (uccCallback != null) {
                                    uccCallback.onFail(str, i, str2);
                                }
                            }

                            @Override // com.ali.user.open.ucc.IRemoteUccCallback
                            public void onSuccess(String str, Map map) throws RemoteException {
                                UccCallback uccCallback = uccCallback;
                                if (uccCallback != null) {
                                    uccCallback.onSuccess(str, map);
                                }
                            }
                        });
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    UccCallback uccCallback = uccCallback;
                    if (uccCallback != null) {
                        uccCallback.onFail(str, 1999, "");
                    }
                }
            }
        });
    }

    @Override // com.ali.user.open.ucc.UccService, com.ali.user.open.ucc.UccServiceImpl
    public void trustLogin(final String str, final Map<String, String> map, final UccCallback uccCallback) {
        if (map != null) {
            map.remove("site");
        }
        if (!ConfigManager.getInstance().isMultiProcessEnable || TextUtils.equals(CommonUtils.getProcessName(KernelContext.getApplicationContext()), KernelContext.getApplicationContext().getPackageName())) {
            UccServiceImpl.getInstance().setUccDataProvider(((UccService) AliMemberSDK.getService(UccService.class)).getUccDataProvider());
            UccServiceImpl.getInstance().trustLogin(str, map, uccCallback);
            return;
        }
        if (map == null) {
            try {
                map = new HashMap<>();
            } catch (Throwable th) {
                th.printStackTrace();
                SDKLogger.e("UccServiceImpl", "remote unbind exception = " + th.getMessage());
                return;
            }
        }
        map.put("process", CommonUtils.getProcessName(KernelContext.getApplicationContext()));
        ((ExecutorService) AliMemberSDK.getService(ExecutorService.class)).execute(new Runnable() {
            /* class com.ali.user.open.ucc.remote.RemoteUccServiceDelegate.AnonymousClass5 */

            public void run() {
                try {
                    if (RemoteUccServiceDelegate.this.mIRemoteUccService == null || RemoteUccServiceDelegate.this.mIRemoteUccService.asBinder() == null || !RemoteUccServiceDelegate.this.mIRemoteUccService.asBinder().isBinderAlive()) {
                        RemoteUccServiceDelegate.this.bindService();
                        RemoteUccServiceDelegate.this.waitUntilConnected(DanmakuFactory.DEFAULT_DANMAKU_DURATION_V);
                    }
                    if (RemoteUccServiceDelegate.this.mIRemoteUccService != null) {
                        RemoteUccServiceDelegate.this.mIRemoteUccService.trustLogin(str, map, new IRemoteUccCallback.Stub() {
                            /* class com.ali.user.open.ucc.remote.RemoteUccServiceDelegate.AnonymousClass5.AnonymousClass1 */

                            @Override // com.ali.user.open.ucc.IRemoteUccCallback
                            public void onFail(String str, int i, String str2) throws RemoteException {
                                UccCallback uccCallback = uccCallback;
                                if (uccCallback != null) {
                                    uccCallback.onFail(str, i, str2);
                                }
                            }

                            @Override // com.ali.user.open.ucc.IRemoteUccCallback
                            public void onSuccess(String str, Map map) throws RemoteException {
                                if (map != null) {
                                    String str2 = (String) map.get(UccConstants.PARAM_LOGIN_DATA);
                                    if (!TextUtils.isEmpty(str2)) {
                                        ((SessionService) AliMemberSDK.getService(SessionService.class)).refreshCookie(str, (LoginReturnData) JSON.parseObject(str2, LoginReturnData.class));
                                    }
                                }
                                UccCallback uccCallback = uccCallback;
                                if (uccCallback != null) {
                                    uccCallback.onSuccess(str, map);
                                }
                            }
                        });
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    UccCallback uccCallback = uccCallback;
                    if (uccCallback != null) {
                        uccCallback.onFail(str, 1999, "");
                    }
                }
            }
        });
    }

    @Override // com.ali.user.open.ucc.UccService, com.ali.user.open.ucc.UccServiceImpl
    public void bind(@NonNull String str, String str2, Map<String, String> map, UccCallback uccCallback) {
        SDKLogger.d("UccServiceImpl", "bind goUccActivity");
        if (map != null) {
            map.remove("site");
        }
        if (!ConfigManager.getInstance().isMultiProcessEnable || TextUtils.equals(CommonUtils.getProcessName(KernelContext.getApplicationContext()), KernelContext.getApplicationContext().getPackageName())) {
            UccServiceImpl.getInstance().setUccDataProvider(((UccService) AliMemberSDK.getService(UccService.class)).getUccDataProvider());
            UccServiceImpl.getInstance().bind(str, str2, map, uccCallback);
            return;
        }
        bind(str2, map, uccCallback);
    }

    @Override // com.ali.user.open.ucc.UccService, com.ali.user.open.ucc.UccServiceImpl
    public void bind(Activity activity, String str, UccCallback uccCallback) {
        bind(activity, str, new HashMap(4), uccCallback);
    }

    @Override // com.ali.user.open.ucc.UccService, com.ali.user.open.ucc.UccServiceImpl
    public void bind(Activity activity, String str, Map<String, String> map, UccCallback uccCallback) {
        if (activity == null) {
            bind(str, map, uccCallback);
            return;
        }
        if (map != null) {
            map.remove("site");
        }
        if (!ConfigManager.getInstance().isMultiProcessEnable || TextUtils.equals(CommonUtils.getProcessName(activity.getApplicationContext()), activity.getPackageName())) {
            UccServiceImpl.getInstance().setUccDataProvider(((UccService) AliMemberSDK.getService(UccService.class)).getUccDataProvider());
            UccServiceImpl.getInstance().bind(activity, str, map, uccCallback);
            return;
        }
        bind(str, map, uccCallback);
    }

    @Override // com.ali.user.open.ucc.UccService, com.ali.user.open.ucc.UccServiceImpl
    public void bind(final String str, final Map<String, String> map, final UccCallback uccCallback) {
        if (map != null) {
            map.remove("site");
        }
        if (!ConfigManager.getInstance().isMultiProcessEnable || TextUtils.equals(CommonUtils.getProcessName(KernelContext.getApplicationContext()), KernelContext.getApplicationContext().getPackageName())) {
            UccServiceImpl.getInstance().setUccDataProvider(((UccService) AliMemberSDK.getService(UccService.class)).getUccDataProvider());
            UccServiceImpl.getInstance().bind(str, map, uccCallback);
            return;
        }
        if (map == null) {
            try {
                map = new HashMap<>();
            } catch (Throwable th) {
                th.printStackTrace();
                SDKLogger.e("UccServiceImpl", "remote bind exception = " + th.getMessage());
                return;
            }
        }
        map.put("process", CommonUtils.getProcessName(KernelContext.getApplicationContext()));
        ((ExecutorService) AliMemberSDK.getService(ExecutorService.class)).execute(new Runnable() {
            /* class com.ali.user.open.ucc.remote.RemoteUccServiceDelegate.AnonymousClass3 */

            public void run() {
                try {
                    if (RemoteUccServiceDelegate.this.mIRemoteUccService == null || RemoteUccServiceDelegate.this.mIRemoteUccService.asBinder() == null || !RemoteUccServiceDelegate.this.mIRemoteUccService.asBinder().isBinderAlive()) {
                        RemoteUccServiceDelegate.this.bindService();
                        RemoteUccServiceDelegate.this.waitUntilConnected(DanmakuFactory.DEFAULT_DANMAKU_DURATION_V);
                    }
                    if (RemoteUccServiceDelegate.this.mIRemoteUccService != null) {
                        RemoteUccServiceDelegate.this.mIRemoteUccService.bind(str, map, new IRemoteUccCallback.Stub() {
                            /* class com.ali.user.open.ucc.remote.RemoteUccServiceDelegate.AnonymousClass3.AnonymousClass1 */

                            @Override // com.ali.user.open.ucc.IRemoteUccCallback
                            public void onFail(String str, int i, String str2) throws RemoteException {
                                UccCallback uccCallback = uccCallback;
                                if (uccCallback != null) {
                                    uccCallback.onFail(str, i, str2);
                                }
                            }

                            @Override // com.ali.user.open.ucc.IRemoteUccCallback
                            public void onSuccess(String str, Map map) throws RemoteException {
                                if (map != null) {
                                    String str2 = (String) map.get(UccConstants.PARAM_LOGIN_DATA);
                                    if (!TextUtils.isEmpty(str2)) {
                                        ((SessionService) AliMemberSDK.getService(SessionService.class)).refreshCookie(str, (LoginReturnData) JSON.parseObject(str2, LoginReturnData.class));
                                    }
                                }
                                UccCallback uccCallback = uccCallback;
                                if (uccCallback != null) {
                                    uccCallback.onSuccess(str, map);
                                }
                            }
                        });
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    SDKLogger.e("UccServiceImpl", "remote bind exception = " + th.getMessage());
                }
            }
        });
    }
}
