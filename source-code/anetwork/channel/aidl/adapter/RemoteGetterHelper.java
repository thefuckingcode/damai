package anetwork.channel.aidl.adapter;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import anet.channel.util.ALog;
import anetwork.channel.aidl.IRemoteNetworkGetter;
import anetwork.channel.aidl.NetworkService;
import java.util.concurrent.CountDownLatch;

/* compiled from: Taobao */
public class RemoteGetterHelper {
    private static final String TAG = "anet.RemoteGetter";
    static volatile boolean bBindFailed;
    static volatile boolean bBinding;
    private static ServiceConnection conn = new ServiceConnection() {
        /* class anetwork.channel.aidl.adapter.RemoteGetterHelper.AnonymousClass1 */

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (ALog.g(2)) {
                ALog.f(RemoteGetterHelper.TAG, "[onServiceConnected]ANet_Service start success. ANet run with service mode", null, new Object[0]);
            }
            synchronized (RemoteGetterHelper.class) {
                RemoteGetterHelper.mGetter = IRemoteNetworkGetter.Stub.asInterface(iBinder);
                if (RemoteGetterHelper.mServiceBindLock != null) {
                    RemoteGetterHelper.mServiceBindLock.countDown();
                }
            }
            RemoteGetterHelper.bBindFailed = false;
            RemoteGetterHelper.bBinding = false;
        }

        public void onServiceDisconnected(ComponentName componentName) {
            if (ALog.g(2)) {
                ALog.f(RemoteGetterHelper.TAG, "ANet_Service Disconnected", null, new Object[0]);
            }
            RemoteGetterHelper.mGetter = null;
            RemoteGetterHelper.bBinding = false;
            if (RemoteGetterHelper.mServiceBindLock != null) {
                RemoteGetterHelper.mServiceBindLock.countDown();
            }
        }
    };
    static Handler handler = new Handler(Looper.getMainLooper());
    static volatile IRemoteNetworkGetter mGetter;
    static volatile CountDownLatch mServiceBindLock;

    private static void asyncBindService(Context context) {
        if (ALog.g(2)) {
            ALog.f(TAG, "[asyncBindService] mContext:" + context + " bBindFailed:" + bBindFailed + " bBinding:" + bBinding, null, new Object[0]);
        }
        if (context != null && !bBindFailed && !bBinding) {
            bBinding = true;
            Intent intent = new Intent(context, NetworkService.class);
            intent.setAction(IRemoteNetworkGetter.class.getName());
            intent.addCategory("android.intent.category.DEFAULT");
            bBindFailed = !context.bindService(intent, conn, 1);
            if (bBindFailed) {
                bBinding = false;
                ALog.e(TAG, "[asyncBindService]ANet_Service start not success. ANet run with local mode!", null, new Object[0]);
            }
            handler.postDelayed(new Runnable() {
                /* class anetwork.channel.aidl.adapter.RemoteGetterHelper.AnonymousClass2 */

                public void run() {
                    if (RemoteGetterHelper.bBinding) {
                        RemoteGetterHelper.bBinding = false;
                        ALog.e(RemoteGetterHelper.TAG, "binding service timeout. reset status!", null, new Object[0]);
                    }
                }
            }, 10000);
        }
    }

    public static IRemoteNetworkGetter getRemoteGetter() {
        return mGetter;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002a, code lost:
        anet.channel.util.ALog.f(anetwork.channel.aidl.adapter.RemoteGetterHelper.TAG, "[initRemoteGetterAndWait]begin to wait", null, new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0040, code lost:
        if (anetwork.channel.aidl.adapter.RemoteGetterHelper.mServiceBindLock.await((long) tb.sh1.d(), java.util.concurrent.TimeUnit.SECONDS) == false) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0042, code lost:
        anet.channel.util.ALog.f(anetwork.channel.aidl.adapter.RemoteGetterHelper.TAG, "mServiceBindLock count down to 0", null, new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004c, code lost:
        anet.channel.util.ALog.f(anetwork.channel.aidl.adapter.RemoteGetterHelper.TAG, "mServiceBindLock wait timeout", null, new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        return;
     */
    public static void initRemoteGetterAndWait(Context context, boolean z) {
        if (mGetter == null && !bBindFailed) {
            asyncBindService(context);
            if (!bBindFailed && z) {
                try {
                    synchronized (RemoteGetterHelper.class) {
                        if (mGetter == null) {
                            if (mServiceBindLock == null) {
                                mServiceBindLock = new CountDownLatch(1);
                            }
                        }
                    }
                } catch (InterruptedException unused) {
                    ALog.e(TAG, "mServiceBindLock wait interrupt", null, new Object[0]);
                }
            }
        }
    }
}
