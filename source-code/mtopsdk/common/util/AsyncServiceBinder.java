package mtopsdk.common.util;

import android.annotation.TargetApi;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.text.TextUtils;
import mtopsdk.common.util.TBSdkLog;

/* compiled from: Taobao */
public abstract class AsyncServiceBinder<T extends IInterface> {
    static final String TAG = "mtopsdk.AsyncServiceBinder";
    private ServiceConnection conn = new ServiceConnection() {
        /* class mtopsdk.common.util.AsyncServiceBinder.AnonymousClass1 */

        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            r9.this$0.mBindFailed = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0080, code lost:
            if (mtopsdk.common.util.TBSdkLog.isLogEnable(mtopsdk.common.util.TBSdkLog.LogEnable.WarnEnable) != false) goto L_0x0082;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0082, code lost:
            mtopsdk.common.util.TBSdkLog.w(mtopsdk.common.util.AsyncServiceBinder.TAG, "[onServiceConnected] Service bind failed. mBindFailed=" + r9.this$0.mBindFailed + ",interfaceName=" + r9.this$0.interfaceName);
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0076 */
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (AsyncServiceBinder.this.lock) {
                if (TextUtils.isEmpty(AsyncServiceBinder.this.interfaceName)) {
                    AsyncServiceBinder asyncServiceBinder = AsyncServiceBinder.this;
                    asyncServiceBinder.interfaceName = asyncServiceBinder.interfaceCls.getSimpleName();
                }
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                    TBSdkLog.i(AsyncServiceBinder.TAG, "[onServiceConnected] Service connected called. interfaceName =" + AsyncServiceBinder.this.interfaceName);
                }
                Class<?>[] declaredClasses = AsyncServiceBinder.this.interfaceCls.getDeclaredClasses();
                for (Class<?> cls : declaredClasses) {
                    if (cls.getSimpleName().equals("Stub")) {
                        AsyncServiceBinder.this.service = (T) ((IInterface) cls.getDeclaredMethod("asInterface", IBinder.class).invoke(cls, iBinder));
                    }
                }
                if (AsyncServiceBinder.this.service != null) {
                    AsyncServiceBinder.this.mBindFailed = false;
                    AsyncServiceBinder.this.afterAsyncBind();
                }
                AsyncServiceBinder.this.mBinding = false;
            }
        }

        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x003e */
        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (AsyncServiceBinder.this.lock) {
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.WarnEnable)) {
                    if (TextUtils.isEmpty(AsyncServiceBinder.this.interfaceName)) {
                        AsyncServiceBinder asyncServiceBinder = AsyncServiceBinder.this;
                        asyncServiceBinder.interfaceName = asyncServiceBinder.interfaceCls.getSimpleName();
                    }
                    TBSdkLog.w(AsyncServiceBinder.TAG, "[onServiceDisconnected] Service disconnected called,interfaceName=" + AsyncServiceBinder.this.interfaceName);
                }
                AsyncServiceBinder.this.service = null;
                AsyncServiceBinder.this.mBinding = false;
            }
        }
    };
    Class<? extends IInterface> interfaceCls;
    String interfaceName;
    final byte[] lock = new byte[0];
    volatile boolean mBindFailed = false;
    volatile boolean mBinding = false;
    protected volatile T service = null;
    Class<? extends Service> serviceCls;

    public AsyncServiceBinder(Class<? extends IInterface> cls, Class<? extends Service> cls2) {
        this.interfaceCls = cls;
        this.serviceCls = cls2;
    }

    /* access modifiers changed from: protected */
    public abstract void afterAsyncBind();

    @TargetApi(4)
    public void asyncBind(Context context) {
        if (this.service == null && context != null && !this.mBindFailed && !this.mBinding) {
            TBSdkLog.LogEnable logEnable = TBSdkLog.LogEnable.InfoEnable;
            if (TBSdkLog.isLogEnable(logEnable)) {
                TBSdkLog.i(TAG, "[asyncBind] mContext=" + context + ",mBindFailed= " + this.mBindFailed + ",mBinding=" + this.mBinding);
            }
            this.mBinding = true;
            try {
                if (TextUtils.isEmpty(this.interfaceName)) {
                    this.interfaceName = this.interfaceCls.getSimpleName();
                }
                if (TBSdkLog.isLogEnable(logEnable)) {
                    TBSdkLog.i(TAG, "[asyncBind]try to bind service for " + this.interfaceName);
                }
                Intent intent = new Intent(context.getApplicationContext(), this.serviceCls);
                intent.setAction(this.interfaceCls.getName());
                intent.setPackage(context.getPackageName());
                intent.addCategory("android.intent.category.DEFAULT");
                boolean bindService = context.bindService(intent, this.conn, 1);
                if (TBSdkLog.isLogEnable(logEnable)) {
                    TBSdkLog.i(TAG, "[asyncBind]use intent bind service ret=" + bindService + " for interfaceName=" + this.interfaceName);
                }
                this.mBindFailed = !bindService;
            } catch (Throwable th) {
                this.mBindFailed = true;
                TBSdkLog.e(TAG, "[asyncBind] use intent bind service failed. mBindFailed=" + this.mBindFailed + ",interfaceName = " + this.interfaceName, th);
            }
            if (this.mBindFailed) {
                this.mBinding = false;
            }
        }
    }

    public T getService() {
        return this.service;
    }
}
