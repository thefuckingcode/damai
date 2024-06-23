package com.huawei.hms.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.common.api.ConnectionPostProcessor;
import com.huawei.hms.common.internal.AutoLifecycleFragment;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.RequestHeader;
import com.huawei.hms.core.aidl.ResponseHeader;
import com.huawei.hms.core.aidl.c;
import com.huawei.hms.core.aidl.d;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.BundleResult;
import com.huawei.hms.support.api.client.InnerApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.core.ConnectService;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.api.entity.core.CheckConnectInfo;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.api.entity.core.ConnectInfo;
import com.huawei.hms.support.api.entity.core.ConnectResp;
import com.huawei.hms.support.api.entity.core.DisconnectInfo;
import com.huawei.hms.support.api.entity.core.DisconnectResp;
import com.huawei.hms.support.api.entity.core.JosGetNoticeResp;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.UIUtil;
import com.huawei.hms.utils.Util;
import com.uc.webview.export.media.MessageID;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: Taobao */
public class HuaweiApiClientImpl extends HuaweiApiClient implements ServiceConnection, InnerApiClient {
    private static final Object A = new Object();
    public static final String DEFAULT_ACCOUNT = "<<default account>>";
    public static final int SIGN_IN_MODE_OPTIONAL = 2;
    public static final int SIGN_IN_MODE_REQUIRED = 1;
    private static final Object z = new Object();
    private int a = -1;
    private final Context b;
    private final String c;
    private String d;
    private String e;
    private volatile com.huawei.hms.core.aidl.d f;
    private String g;
    private WeakReference<Activity> h;
    private WeakReference<Activity> i;
    private boolean j = false;
    private AtomicInteger k = new AtomicInteger(1);
    private List<Scope> l;
    private List<PermissionInfo> m;
    private Map<Api<?>, Api.ApiOptions> n;
    private SubAppInfo o;
    private long p = 0;
    private int q = 0;
    private final Object r = new Object();
    private final ReentrantLock s;
    private final Condition t;
    private ConnectionResult u;
    private HuaweiApiClient.ConnectionCallbacks v;
    private HuaweiApiClient.OnConnectionFailedListener w;
    private Handler x;
    private Handler y;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements Handler.Callback {
        a() {
        }

        public boolean handleMessage(Message message) {
            if (message == null || message.what != 2) {
                return false;
            }
            HMSLog.e("HuaweiApiClientImpl", "In connect, bind core service time out");
            if (HuaweiApiClientImpl.this.k.get() == 5) {
                HuaweiApiClientImpl.this.c((HuaweiApiClientImpl) 1);
                HuaweiApiClientImpl.this.b();
            }
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b implements Handler.Callback {
        b() {
        }

        public boolean handleMessage(Message message) {
            if (message == null || message.what != 3) {
                return false;
            }
            HMSLog.e("HuaweiApiClientImpl", "In connect, process time out");
            if (HuaweiApiClientImpl.this.k.get() == 2) {
                HuaweiApiClientImpl.this.c((HuaweiApiClientImpl) 1);
                HuaweiApiClientImpl.this.b();
            }
            return true;
        }
    }

    /* compiled from: Taobao */
    class c extends c.a {
        final /* synthetic */ ResultCallback a;

        c(HuaweiApiClientImpl huaweiApiClientImpl, ResultCallback resultCallback) {
            this.a = resultCallback;
        }

        @Override // com.huawei.hms.core.aidl.c
        public void call(com.huawei.hms.core.aidl.b bVar) {
            if (bVar != null) {
                com.huawei.hms.core.aidl.e a2 = com.huawei.hms.core.aidl.a.a(bVar.c());
                ResponseHeader responseHeader = new ResponseHeader();
                a2.a(bVar.b, responseHeader);
                BundleResult bundleResult = new BundleResult(responseHeader.getStatusCode(), bVar.a());
                HMSLog.i("HuaweiApiClientImpl", "Exit asyncRequest onResult");
                this.a.onResult(bundleResult);
                return;
            }
            HMSLog.i("HuaweiApiClientImpl", "Exit asyncRequest onResult -1");
            this.a.onResult(new BundleResult(-1, null));
        }
    }

    /* compiled from: Taobao */
    static class d extends PendingResultImpl<Status, IMessageEntity> {
        public d(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        public Status onComplete(IMessageEntity iMessageEntity) {
            return new Status(0);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class e implements ResultCallback<ResolveResult<ConnectResp>> {

        /* access modifiers changed from: package-private */
        /* compiled from: Taobao */
        public class a implements Runnable {
            final /* synthetic */ ResolveResult a;

            a(ResolveResult resolveResult) {
                this.a = resolveResult;
            }

            public void run() {
                HuaweiApiClientImpl.this.a((HuaweiApiClientImpl) this.a);
            }
        }

        private e() {
        }

        /* renamed from: a */
        public void onResult(ResolveResult<ConnectResp> resolveResult) {
            new Handler(Looper.getMainLooper()).post(new a(resolveResult));
        }

        /* synthetic */ e(HuaweiApiClientImpl huaweiApiClientImpl, a aVar) {
            this();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class f implements ResultCallback<ResolveResult<DisconnectResp>> {

        /* access modifiers changed from: package-private */
        /* compiled from: Taobao */
        public class a implements Runnable {
            final /* synthetic */ ResolveResult a;

            a(ResolveResult resolveResult) {
                this.a = resolveResult;
            }

            public void run() {
                HuaweiApiClientImpl.this.b((HuaweiApiClientImpl) this.a);
            }
        }

        private f() {
        }

        /* renamed from: a */
        public void onResult(ResolveResult<DisconnectResp> resolveResult) {
            new Handler(Looper.getMainLooper()).post(new a(resolveResult));
        }

        /* synthetic */ f(HuaweiApiClientImpl huaweiApiClientImpl, a aVar) {
            this();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class g implements ResultCallback<ResolveResult<JosGetNoticeResp>> {
        private g() {
        }

        /* renamed from: a */
        public void onResult(ResolveResult<JosGetNoticeResp> resolveResult) {
            JosGetNoticeResp value;
            Intent noticeIntent;
            if (resolveResult != null && resolveResult.getStatus().isSuccess() && (noticeIntent = (value = resolveResult.getValue()).getNoticeIntent()) != null && value.getStatusCode() == 0) {
                HMSLog.i("HuaweiApiClientImpl", "get notice has intent.");
                Activity validActivity = Util.getValidActivity((Activity) HuaweiApiClientImpl.this.h.get(), HuaweiApiClientImpl.this.getTopActivity());
                if (validActivity == null) {
                    HMSLog.e("HuaweiApiClientImpl", "showNotice no valid activity!");
                    return;
                }
                HuaweiApiClientImpl.this.j = true;
                validActivity.startActivity(noticeIntent);
            }
        }

        /* synthetic */ g(HuaweiApiClientImpl huaweiApiClientImpl, a aVar) {
            this();
        }
    }

    public HuaweiApiClientImpl(Context context) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.s = reentrantLock;
        this.t = reentrantLock.newCondition();
        this.x = null;
        this.y = null;
        this.b = context;
        String appId = Util.getAppId(context);
        this.c = appId;
        this.d = appId;
        this.e = Util.getCpId(context);
    }

    private DisconnectInfo d() {
        ArrayList arrayList = new ArrayList();
        Map<Api<?>, Api.ApiOptions> map = this.n;
        if (map != null) {
            for (Api<?> api : map.keySet()) {
                arrayList.add(api.getApiName());
            }
        }
        return new DisconnectInfo(this.l, arrayList);
    }

    private int e() {
        int hmsVersion = Util.getHmsVersion(this.b);
        if (hmsVersion != 0 && hmsVersion >= 20503000) {
            return hmsVersion;
        }
        int f2 = f();
        if (g()) {
            if (f2 < 20503000) {
                return 20503000;
            }
            return f2;
        } else if (f2 < 20600000) {
            return 20600000;
        } else {
            return f2;
        }
    }

    private int f() {
        Integer num;
        int intValue;
        Map<Api<?>, Api.ApiOptions> apiMap = getApiMap();
        int i2 = 0;
        if (apiMap == null) {
            return 0;
        }
        for (Api<?> api : apiMap.keySet()) {
            String apiName = api.getApiName();
            if (!TextUtils.isEmpty(apiName) && (num = HuaweiApiAvailability.getApiMap().get(apiName)) != null && (intValue = num.intValue()) > i2) {
                i2 = intValue;
            }
        }
        return i2;
    }

    private boolean g() {
        Map<Api<?>, Api.ApiOptions> map = this.n;
        if (map == null) {
            return false;
        }
        for (Api<?> api : map.keySet()) {
            if (HuaweiApiAvailability.HMS_API_NAME_GAME.equals(api.getApiName())) {
                return true;
            }
        }
        return false;
    }

    private void h() {
        Handler handler = this.x;
        if (handler != null) {
            handler.removeMessages(2);
        } else {
            this.x = new Handler(Looper.getMainLooper(), new a());
        }
        this.x.sendEmptyMessageDelayed(2, DanmakuFactory.DEFAULT_DANMAKU_DURATION_V);
    }

    private void i() {
        synchronized (A) {
            Handler handler = this.y;
            if (handler != null) {
                handler.removeMessages(3);
            } else {
                this.y = new Handler(Looper.getMainLooper(), new b());
            }
            boolean sendEmptyMessageDelayed = this.y.sendEmptyMessageDelayed(3, 3000);
            HMSLog.d("HuaweiApiClientImpl", "sendEmptyMessageDelayed for onConnectionResult 3 seconds. the result is : " + sendEmptyMessageDelayed);
        }
    }

    private void j() {
        HMSLog.i("HuaweiApiClientImpl", "Enter sendConnectApiServceRequest.");
        ConnectService.connect(this, c()).setResultCallback(new e(this, null));
    }

    private void k() {
        ConnectService.disconnect(this, d()).setResultCallback(new f(this, null));
    }

    private void l() {
        HMSLog.i("HuaweiApiClientImpl", "Enter sendForceConnectApiServceRequest.");
        ConnectService.forceConnect(this, c()).setResultCallback(new e(this, null));
    }

    private void m() {
        if (this.j) {
            HMSLog.i("HuaweiApiClientImpl", "Connect notice has been shown.");
        } else if (HuaweiApiAvailability.getInstance().isHuaweiMobileNoticeAvailable(this.b) == 0) {
            ConnectService.getNotice(this, 0, "6.4.0.302").setResultCallback(new g(this, null));
        }
    }

    private void n() {
        Util.unBindServiceCatchException(this.b, this);
        this.f = null;
    }

    public int asyncRequest(Bundle bundle, String str, int i2, ResultCallback<BundleResult> resultCallback) {
        HMSLog.i("HuaweiApiClientImpl", "Enter asyncRequest.");
        if (resultCallback == null || str == null || bundle == null) {
            HMSLog.e("HuaweiApiClientImpl", "arguments is invalid.");
            return CommonCode.ErrorCode.ARGUMENTS_INVALID;
        } else if (!innerIsConnected()) {
            HMSLog.e("HuaweiApiClientImpl", "client is unConnect.");
            return CommonCode.ErrorCode.CLIENT_API_INVALID;
        } else {
            com.huawei.hms.core.aidl.b bVar = new com.huawei.hms.core.aidl.b(str, i2);
            com.huawei.hms.core.aidl.e a2 = com.huawei.hms.core.aidl.a.a(bVar.c());
            bVar.a(bundle);
            RequestHeader requestHeader = new RequestHeader(getAppID(), getPackageName(), 60400302, getSessionId());
            requestHeader.setApiNameList(getApiNameList());
            bVar.b = a2.a(requestHeader, new Bundle());
            try {
                getService().a(bVar, new c(this, resultCallback));
                return 0;
            } catch (RemoteException e2) {
                HMSLog.e("HuaweiApiClientImpl", "remote exception:" + e2.getMessage());
                return CommonCode.ErrorCode.INTERNAL_ERROR;
            }
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void checkUpdate(Activity activity, CheckUpdatelistener checkUpdatelistener) {
        if (checkUpdatelistener == null) {
            HMSLog.e("HuaweiApiClientImpl", "listener is null!");
        } else {
            checkUpdatelistener.onResult(-1);
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void connect(Activity activity) {
        HMSLog.i("HuaweiApiClientImpl", "====== HMSSDK version: 60400302 ======");
        int i2 = this.k.get();
        HMSLog.i("HuaweiApiClientImpl", "Enter connect, Connection Status: " + i2);
        if (i2 != 3 && i2 != 5 && i2 != 2 && i2 != 4) {
            if (activity != null) {
                this.h = new WeakReference<>(activity);
                this.i = new WeakReference<>(activity);
            }
            this.d = TextUtils.isEmpty(this.c) ? Util.getAppId(this.b) : this.c;
            int e2 = e();
            HMSLog.i("HuaweiApiClientImpl", "connect minVersion:" + e2);
            HuaweiApiAvailability.setServicesVersionCode(e2);
            int isHuaweiMobileServicesAvailable = HuaweiMobileServicesUtil.isHuaweiMobileServicesAvailable(this.b, e2);
            HMSLog.i("HuaweiApiClientImpl", "In connect, isHuaweiMobileServicesAvailable result: " + isHuaweiMobileServicesAvailable);
            this.q = HMSPackageManager.getInstance(this.b).getHmsMultiServiceVersion();
            if (isHuaweiMobileServicesAvailable == 0) {
                c(5);
                if (this.f == null) {
                    a();
                    return;
                }
                c(2);
                j();
                i();
            } else if (this.w != null) {
                b(isHuaweiMobileServicesAvailable);
            }
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void connectForeground() {
        HMSLog.i("HuaweiApiClientImpl", "====== HMSSDK version: 60400302 ======");
        int i2 = this.k.get();
        HMSLog.i("HuaweiApiClientImpl", "Enter forceConnect, Connection Status: " + i2);
        if (i2 != 3 && i2 != 5 && i2 != 2 && i2 != 4) {
            this.d = TextUtils.isEmpty(this.c) ? Util.getAppId(this.b) : this.c;
            l();
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void disableLifeCycleManagement(Activity activity) {
        if (this.a >= 0) {
            AutoLifecycleFragment.getInstance(activity).stopAutoManage(this.a);
            return;
        }
        throw new IllegalStateException("disableLifeCycleManagement failed");
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public PendingResult<Status> discardAndReconnect() {
        return new d(this, null, null);
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void disconnect() {
        int i2 = this.k.get();
        HMSLog.i("HuaweiApiClientImpl", "Enter disconnect, Connection Status: " + i2);
        if (i2 == 2) {
            c(4);
        } else if (i2 == 3) {
            c(4);
            k();
        } else if (i2 == 5) {
            a(2);
            c(4);
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public Map<Api<?>, Api.ApiOptions> getApiMap() {
        return this.n;
    }

    @Override // com.huawei.hms.support.api.client.AidlApiClient
    public List<String> getApiNameList() {
        ArrayList arrayList = new ArrayList();
        Map<Api<?>, Api.ApiOptions> map = this.n;
        if (map != null) {
            for (Api<?> api : map.keySet()) {
                arrayList.add(api.getApiName());
            }
        }
        return arrayList;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getAppID() {
        return this.d;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public ConnectionResult getConnectionResult(Api<?> api) {
        if (isConnected()) {
            this.u = null;
            return new ConnectionResult(0, (PendingIntent) null);
        }
        ConnectionResult connectionResult = this.u;
        if (connectionResult != null) {
            return connectionResult;
        }
        return new ConnectionResult(13, (PendingIntent) null);
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public Context getContext() {
        return this.b;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getCpID() {
        return this.e;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getPackageName() {
        return this.b.getPackageName();
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public List<PermissionInfo> getPermissionInfos() {
        return this.m;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public List<Scope> getScopes() {
        return this.l;
    }

    @Override // com.huawei.hms.support.api.client.AidlApiClient
    public com.huawei.hms.core.aidl.d getService() {
        return this.f;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getSessionId() {
        return this.g;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public final SubAppInfo getSubAppInfo() {
        return this.o;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public Activity getTopActivity() {
        WeakReference<Activity> weakReference = this.i;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getTransportName() {
        return IPCTransport.class.getName();
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public boolean hasConnectedApi(Api<?> api) {
        return isConnected();
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public boolean hasConnectionFailureListener(HuaweiApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Checker.checkNonNull(onConnectionFailedListener, "onConnectionFailedListener should not be null");
        synchronized (this.r) {
            if (this.w == onConnectionFailedListener) {
                return true;
            }
            return false;
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public boolean hasConnectionSuccessListener(HuaweiApiClient.ConnectionCallbacks connectionCallbacks) {
        Checker.checkNonNull(connectionCallbacks, "connectionCallbacksListener should not be null");
        synchronized (this.r) {
            if (this.v == connectionCallbacks) {
                return true;
            }
            return false;
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public ConnectionResult holdUpConnect() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.s.lock();
            try {
                connect((Activity) null);
                while (isConnecting()) {
                    try {
                        this.t.await();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        return new ConnectionResult(15, (PendingIntent) null);
                    }
                }
                if (isConnected()) {
                    this.u = null;
                    ConnectionResult connectionResult = new ConnectionResult(0, (PendingIntent) null);
                    this.s.unlock();
                    return connectionResult;
                }
                ConnectionResult connectionResult2 = this.u;
                if (connectionResult2 != null) {
                    this.s.unlock();
                    return connectionResult2;
                }
                ConnectionResult connectionResult3 = new ConnectionResult(13, (PendingIntent) null);
                this.s.unlock();
                return connectionResult3;
            } finally {
                this.s.unlock();
            }
        } else {
            throw new IllegalStateException("blockingConnect must not be called on the UI thread");
        }
    }

    @Override // com.huawei.hms.support.api.client.InnerApiClient
    public boolean innerIsConnected() {
        return this.k.get() == 3 || this.k.get() == 4;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient, com.huawei.hms.support.api.client.ApiClient
    public boolean isConnected() {
        if (this.q == 0) {
            this.q = HMSPackageManager.getInstance(this.b).getHmsMultiServiceVersion();
        }
        if (this.q >= 20504000) {
            return innerIsConnected();
        }
        long currentTimeMillis = System.currentTimeMillis() - this.p;
        if (currentTimeMillis > 0 && currentTimeMillis < 300000) {
            return innerIsConnected();
        }
        if (!innerIsConnected()) {
            return false;
        }
        Status status = ConnectService.checkconnect(this, new CheckConnectInfo()).awaitOnAnyThread(2000, TimeUnit.MILLISECONDS).getStatus();
        if (status.isSuccess()) {
            this.p = System.currentTimeMillis();
            return true;
        }
        int statusCode = status.getStatusCode();
        HMSLog.i("HuaweiApiClientImpl", "isConnected is false, statuscode:" + statusCode);
        if (statusCode == 907135004) {
            return false;
        }
        n();
        c(1);
        this.p = System.currentTimeMillis();
        return false;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public boolean isConnecting() {
        int i2 = this.k.get();
        return i2 == 2 || i2 == 5;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void onPause(Activity activity) {
        HMSLog.i("HuaweiApiClientImpl", MessageID.onPause);
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void onResume(Activity activity) {
        if (activity != null) {
            HMSLog.i("HuaweiApiClientImpl", "onResume");
            this.i = new WeakReference<>(activity);
        }
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        HMSLog.i("HuaweiApiClientImpl", "HuaweiApiClientImpl Enter onServiceConnected.");
        a(2);
        this.f = d.a.a(iBinder);
        if (this.f == null) {
            HMSLog.e("HuaweiApiClientImpl", "In onServiceConnected, mCoreService must not be null.");
            n();
            c(1);
            if (this.w != null) {
                PendingIntent pendingIntent = null;
                WeakReference<Activity> weakReference = this.h;
                if (!(weakReference == null || weakReference.get() == null)) {
                    pendingIntent = HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent(this.h.get(), 10);
                }
                ConnectionResult connectionResult = new ConnectionResult(10, pendingIntent);
                this.w.onConnectionFailed(connectionResult);
                this.u = connectionResult;
            }
        } else if (this.k.get() == 5) {
            c(2);
            j();
            i();
        } else if (this.k.get() != 3) {
            n();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        HMSLog.i("HuaweiApiClientImpl", "Enter onServiceDisconnected.");
        this.f = null;
        c(1);
        HuaweiApiClient.ConnectionCallbacks connectionCallbacks = this.v;
        if (connectionCallbacks != null) {
            connectionCallbacks.onConnectionSuspended(1);
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void print(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void reconnect() {
        disconnect();
        connect((Activity) null);
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void removeConnectionFailureListener(HuaweiApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Checker.checkNonNull(onConnectionFailedListener, "onConnectionFailedListener should not be null");
        synchronized (this.r) {
            if (this.w != onConnectionFailedListener) {
                HMSLog.w("HuaweiApiClientImpl", "unregisterConnectionFailedListener: this onConnectionFailedListener has not been registered");
            } else {
                this.w = null;
            }
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void removeConnectionSuccessListener(HuaweiApiClient.ConnectionCallbacks connectionCallbacks) {
        Checker.checkNonNull(connectionCallbacks, "connectionCallbacksListener should not be null");
        synchronized (this.r) {
            if (this.v != connectionCallbacks) {
                HMSLog.w("HuaweiApiClientImpl", "unregisterConnectionCallback: this connectionCallbacksListener has not been registered");
            } else {
                this.v = null;
            }
        }
    }

    public void setApiMap(Map<Api<?>, Api.ApiOptions> map) {
        this.n = map;
    }

    /* access modifiers changed from: protected */
    public void setAutoLifecycleClientId(int i2) {
        this.a = i2;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void setConnectionCallbacks(HuaweiApiClient.ConnectionCallbacks connectionCallbacks) {
        this.v = connectionCallbacks;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void setConnectionFailedListener(HuaweiApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.w = onConnectionFailedListener;
    }

    public void setHasShowNotice(boolean z2) {
        this.j = z2;
    }

    public void setPermissionInfos(List<PermissionInfo> list) {
        this.m = list;
    }

    public void setScopes(List<Scope> list) {
        this.l = list;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public boolean setSubAppInfo(SubAppInfo subAppInfo) {
        HMSLog.i("HuaweiApiClientImpl", "Enter setSubAppInfo");
        if (subAppInfo == null) {
            HMSLog.e("HuaweiApiClientImpl", "subAppInfo is null");
            return false;
        }
        String subAppID = subAppInfo.getSubAppID();
        if (TextUtils.isEmpty(subAppID)) {
            HMSLog.e("HuaweiApiClientImpl", "subAppId is empty");
            return false;
        }
        if (subAppID.equals(TextUtils.isEmpty(this.c) ? Util.getAppId(this.b) : this.c)) {
            HMSLog.e("HuaweiApiClientImpl", "subAppId is host appid");
            return false;
        }
        this.o = new SubAppInfo(subAppInfo);
        return true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void c(int i2) {
        this.k.set(i2);
        if (i2 == 1 || i2 == 3 || i2 == 2) {
            this.s.lock();
            try {
                this.t.signalAll();
            } finally {
                this.s.unlock();
            }
        }
    }

    private void b(int i2) {
        PendingIntent pendingIntent;
        WeakReference<Activity> weakReference = this.h;
        if (weakReference == null || weakReference.get() == null) {
            pendingIntent = null;
        } else {
            pendingIntent = HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent(this.h.get(), i2);
            HMSLog.i("HuaweiApiClientImpl", "connect 2.0 fail: " + i2);
        }
        ConnectionResult connectionResult = new ConnectionResult(i2, pendingIntent);
        this.w.onConnectionFailed(connectionResult);
        this.u = connectionResult;
    }

    private void a() {
        Intent intent = new Intent(HMSPackageManager.getInstance(this.b).getServiceAction());
        HMSPackageManager.getInstance(this.b).refreshForMultiService();
        intent.setPackage(HMSPackageManager.getInstance(this.b).getHMSPackageNameForMultiService());
        synchronized (z) {
            if (this.b.bindService(intent, this, 1)) {
                h();
                return;
            }
            c(1);
            HMSLog.e("HuaweiApiClientImpl", "In connect, bind core service fail");
            b();
        }
    }

    private ConnectInfo c() {
        String packageSignature = new PackageManagerHelper(this.b).getPackageSignature(this.b.getPackageName());
        if (packageSignature == null) {
            packageSignature = "";
        }
        SubAppInfo subAppInfo = this.o;
        return new ConnectInfo(getApiNameList(), this.l, packageSignature, subAppInfo == null ? null : subAppInfo.getSubAppID());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void b() {
        n();
        if (this.w != null) {
            int i2 = UIUtil.isBackground(this.b) ? 7 : 6;
            PendingIntent pendingIntent = null;
            WeakReference<Activity> weakReference = this.h;
            if (!(weakReference == null || weakReference.get() == null)) {
                pendingIntent = HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent(this.h.get(), i2);
            }
            ConnectionResult connectionResult = new ConnectionResult(i2, pendingIntent);
            this.w.onConnectionFailed(connectionResult);
            this.u = connectionResult;
        }
    }

    private void c(ResolveResult<ConnectResp> resolveResult) {
        if (resolveResult.getValue() != null) {
            ProtocolNegotiate.getInstance().negotiate(resolveResult.getValue().protocolVersion);
        }
        c(3);
        this.u = null;
        HuaweiApiClient.ConnectionCallbacks connectionCallbacks = this.v;
        if (connectionCallbacks != null) {
            connectionCallbacks.onConnected();
        }
        if (this.h != null) {
            m();
        }
        for (Map.Entry<Api<?>, Api.ApiOptions> entry : getApiMap().entrySet()) {
            if (entry.getKey().getmConnetctPostList() != null && !entry.getKey().getmConnetctPostList().isEmpty()) {
                HMSLog.i("HuaweiApiClientImpl", "Enter onConnectionResult, get the ConnetctPostList ");
                for (ConnectionPostProcessor connectionPostProcessor : entry.getKey().getmConnetctPostList()) {
                    HMSLog.i("HuaweiApiClientImpl", "Enter onConnectionResult, processor.run");
                    connectionPostProcessor.run(this, this.h);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void b(ResolveResult<DisconnectResp> resolveResult) {
        HMSLog.i("HuaweiApiClientImpl", "Enter onDisconnectionResult, disconnect from server result: " + resolveResult.getStatus().getStatusCode());
        n();
        c(1);
    }

    private void a(int i2) {
        if (i2 == 2) {
            synchronized (z) {
                Handler handler = this.x;
                if (handler != null) {
                    handler.removeMessages(i2);
                    this.x = null;
                }
            }
        }
        if (i2 == 3) {
            synchronized (A) {
                Handler handler2 = this.y;
                if (handler2 != null) {
                    handler2.removeMessages(i2);
                    this.y = null;
                }
            }
        }
        synchronized (z) {
            Handler handler3 = this.x;
            if (handler3 != null) {
                handler3.removeMessages(2);
                this.x = null;
            }
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public ConnectionResult holdUpConnect(long j2, TimeUnit timeUnit) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.s.lock();
            try {
                connect((Activity) null);
                long nanos = timeUnit.toNanos(j2);
                while (isConnecting()) {
                    if (nanos <= 0) {
                        disconnect();
                        ConnectionResult connectionResult = new ConnectionResult(14, (PendingIntent) null);
                        this.s.unlock();
                        return connectionResult;
                    }
                    try {
                        nanos = this.t.awaitNanos(nanos);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        return new ConnectionResult(15, (PendingIntent) null);
                    }
                }
                if (isConnected()) {
                    this.u = null;
                    ConnectionResult connectionResult2 = new ConnectionResult(0, (PendingIntent) null);
                    this.s.unlock();
                    return connectionResult2;
                }
                ConnectionResult connectionResult3 = this.u;
                if (connectionResult3 != null) {
                    this.s.unlock();
                    return connectionResult3;
                }
                ConnectionResult connectionResult4 = new ConnectionResult(13, (PendingIntent) null);
                this.s.unlock();
                return connectionResult4;
            } finally {
                this.s.unlock();
            }
        } else {
            throw new IllegalStateException("blockingConnect must not be called on the UI thread");
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void connect(int i2) {
        connect((Activity) null);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(ResolveResult<ConnectResp> resolveResult) {
        HMSLog.i("HuaweiApiClientImpl", "Enter onConnectionResult");
        if (this.f == null || this.k.get() != 2) {
            HMSLog.e("HuaweiApiClientImpl", "Invalid onConnectionResult");
            return;
        }
        a(3);
        ConnectResp value = resolveResult.getValue();
        if (value != null) {
            this.g = value.sessionId;
        }
        SubAppInfo subAppInfo = this.o;
        PendingIntent pendingIntent = null;
        String subAppID = subAppInfo == null ? null : subAppInfo.getSubAppID();
        if (!TextUtils.isEmpty(subAppID)) {
            this.d = subAppID;
        }
        int statusCode = resolveResult.getStatus().getStatusCode();
        HMSLog.i("HuaweiApiClientImpl", "Enter onConnectionResult, connect to server result: " + statusCode);
        if (Status.SUCCESS.equals(resolveResult.getStatus())) {
            c(resolveResult);
        } else if (resolveResult.getStatus() == null || resolveResult.getStatus().getStatusCode() != 1001) {
            n();
            c(1);
            if (this.w != null) {
                WeakReference<Activity> weakReference = this.h;
                if (!(weakReference == null || weakReference.get() == null)) {
                    pendingIntent = HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent(this.h.get(), statusCode);
                }
                ConnectionResult connectionResult = new ConnectionResult(statusCode, pendingIntent);
                this.w.onConnectionFailed(connectionResult);
                this.u = connectionResult;
            }
        } else {
            n();
            c(1);
            HuaweiApiClient.ConnectionCallbacks connectionCallbacks = this.v;
            if (connectionCallbacks != null) {
                connectionCallbacks.onConnectionSuspended(3);
            }
        }
    }
}
