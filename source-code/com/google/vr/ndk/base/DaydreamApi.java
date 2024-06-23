package com.google.vr.ndk.base;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.vr.cardboard.annotations.UsedByReflection;
import com.google.vr.vrcore.base.api.VrCoreNotAvailableException;
import com.google.vr.vrcore.base.api.VrCoreUtils;
import com.google.vr.vrcore.common.api.IDaydreamManager;
import com.google.vr.vrcore.common.api.ITransitionCallbacks;
import com.google.vr.vrcore.common.api.IVrCoreSdkService;
import java.util.ArrayList;
import java.util.List;

@UsedByReflection("IAP")
@TargetApi(24)
/* compiled from: Taobao */
public class DaydreamApi implements AutoCloseable {
    private static final String TAG = DaydreamApi.class.getSimpleName();
    private boolean closed;
    private final ServiceConnection connection = new ServiceConnection() {
        /* class com.google.vr.ndk.base.DaydreamApi.AnonymousClass1 */

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            DaydreamApi.this.vrCoreSdkService = IVrCoreSdkService.Stub.asInterface(iBinder);
            try {
                DaydreamApi daydreamApi = DaydreamApi.this;
                daydreamApi.daydreamManager = daydreamApi.vrCoreSdkService.getDaydreamManager();
            } catch (RemoteException unused) {
                Log.e(DaydreamApi.TAG, "RemoteException in onServiceConnected");
            }
            if (DaydreamApi.this.daydreamManager == null) {
                Log.w(DaydreamApi.TAG, "Daydream service component unavailable.");
            }
            ArrayList arrayList = DaydreamApi.this.queuedRunnables;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((Runnable) obj).run();
            }
            DaydreamApi.this.queuedRunnables.clear();
        }

        public void onServiceDisconnected(ComponentName componentName) {
            DaydreamApi.this.vrCoreSdkService = null;
        }
    };
    private final Context context;
    private IDaydreamManager daydreamManager;
    private ArrayList<Runnable> queuedRunnables = new ArrayList<>();
    private int vrCoreApiVersion;
    private IVrCoreSdkService vrCoreSdkService;

    private DaydreamApi(Context context2) {
        this.context = context2;
    }

    private void checkIntent(Intent intent) throws ActivityNotFoundException {
        List<ResolveInfo> queryIntentActivities = this.context.getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities == null || queryIntentActivities.isEmpty()) {
            String valueOf = String.valueOf(intent);
            StringBuilder sb = new StringBuilder(valueOf.length() + 43);
            sb.append("No activity is available to handle intent: ");
            sb.append(valueOf);
            throw new ActivityNotFoundException(sb.toString());
        }
    }

    private void checkNotClosed() {
        if (this.closed) {
            throw new IllegalStateException("DaydreamApi object is closed and can no longer be used.");
        }
    }

    @UsedByReflection("IAP")
    public static DaydreamApi create(Context context2) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("DaydreamApi must only be used from the main thread.");
        } else if (!DaydreamUtils.isDaydreamPhone(context2)) {
            Log.i(TAG, "Phone is not Daydream-compatible");
            return null;
        } else {
            DaydreamApi daydreamApi = new DaydreamApi(context2);
            if (daydreamApi.init()) {
                return daydreamApi;
            }
            Log.w(TAG, "Failed to initialize DaydreamApi object.");
            return null;
        }
    }

    @UsedByReflection("IAP")
    public static Intent createVrIntent(ComponentName componentName) {
        Intent intent = new Intent();
        intent.setComponent(componentName);
        return setupVrIntent(intent);
    }

    private boolean init() {
        try {
            int vrCoreClientApiVersion = VrCoreUtils.getVrCoreClientApiVersion(this.context);
            this.vrCoreApiVersion = vrCoreClientApiVersion;
            if (vrCoreClientApiVersion < 8) {
                String str = TAG;
                StringBuilder sb = new StringBuilder(79);
                sb.append("VrCore out of date, current version: ");
                sb.append(vrCoreClientApiVersion);
                sb.append(", required version: 8");
                Log.e(str, sb.toString());
                return false;
            }
            Intent intent = new Intent("com.google.vr.vrcore.BIND_SDK_SERVICE");
            intent.setPackage("com.google.vr.vrcore");
            if (this.context.bindService(intent, this.connection, 1)) {
                return true;
            }
            Log.e(TAG, "Unable to bind to VrCoreSdkService");
            return false;
        } catch (VrCoreNotAvailableException e) {
            String str2 = TAG;
            String valueOf = String.valueOf(e);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 22);
            sb2.append("VrCore not available: ");
            sb2.append(valueOf);
            Log.e(str2, sb2.toString());
        }
    }

    private void launchTransitionCallbackInVr(final ITransitionCallbacks iTransitionCallbacks) {
        runWhenServiceConnected(new Runnable() {
            /* class com.google.vr.ndk.base.DaydreamApi.AnonymousClass4 */

            /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0022  */
            public void run() {
                boolean z;
                if (DaydreamApi.this.daydreamManager != null) {
                    try {
                        z = DaydreamApi.this.daydreamManager.launchVrTransition(iTransitionCallbacks);
                    } catch (RemoteException e) {
                        Log.e(DaydreamApi.TAG, "RemoteException while launching VR transition: ", e);
                    }
                    if (z) {
                        Log.w(DaydreamApi.TAG, "Can't launch callbacks via DaydreamManager, sending manually");
                        try {
                            iTransitionCallbacks.onTransitionComplete();
                            return;
                        } catch (RemoteException unused) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                z = false;
                if (z) {
                }
            }
        });
    }

    private void runWhenServiceConnected(Runnable runnable) {
        if (this.vrCoreSdkService != null) {
            runnable.run();
        } else {
            this.queuedRunnables.add(runnable);
        }
    }

    @UsedByReflection("IAP")
    public static Intent setupVrIntent(Intent intent) {
        intent.addCategory("com.google.intent.category.DAYDREAM");
        intent.addFlags(335609856);
        return intent;
    }

    @Override // java.lang.AutoCloseable
    @UsedByReflection("IAP")
    public void close() {
        if (!this.closed) {
            this.closed = true;
            runWhenServiceConnected(new Runnable() {
                /* class com.google.vr.ndk.base.DaydreamApi.AnonymousClass12 */

                public void run() {
                    DaydreamApi.this.context.unbindService(DaydreamApi.this.connection);
                    DaydreamApi.this.vrCoreSdkService = null;
                }
            });
        }
    }

    @UsedByReflection("IAP")
    public void exitFromVr(Activity activity, int i, Intent intent) {
        checkNotClosed();
        if (intent == null) {
            intent = new Intent();
        }
        final PendingIntent createPendingResult = activity.createPendingResult(i, intent, 1073741824);
        final AnonymousClass7 r3 = new Runnable(this) {
            /* class com.google.vr.ndk.base.DaydreamApi.AnonymousClass7 */

            public void run() {
                try {
                    createPendingResult.send(0);
                } catch (Exception e) {
                    String str = DaydreamApi.TAG;
                    String valueOf = String.valueOf(e);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 31);
                    sb.append("Couldn't launch PendingIntent: ");
                    sb.append(valueOf);
                    Log.e(str, sb.toString());
                }
            }
        };
        runWhenServiceConnected(new Runnable() {
            /* class com.google.vr.ndk.base.DaydreamApi.AnonymousClass8 */

            public void run() {
                if (DaydreamApi.this.daydreamManager == null) {
                    Log.w(DaydreamApi.TAG, "Failed to exit VR: Daydream service unavailable.");
                    r3.run();
                    return;
                }
                try {
                    if (!DaydreamApi.this.daydreamManager.exitFromVr(createPendingResult)) {
                        Log.w(DaydreamApi.TAG, "Failed to exit VR: Invalid request.");
                        r3.run();
                    }
                } catch (RemoteException e) {
                    String str = DaydreamApi.TAG;
                    String valueOf = String.valueOf(e);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 49);
                    sb.append("Failed to exit VR: RemoteException while exiting:");
                    sb.append(valueOf);
                    Log.e(str, sb.toString());
                    r3.run();
                }
            }
        });
    }

    @UsedByReflection("IAP")
    public void launchInVr(PendingIntent pendingIntent) {
        checkNotClosed();
        launchInVr(pendingIntent, null);
    }

    @UsedByReflection("IAP")
    public void launchInVrForResult(final Activity activity, final PendingIntent pendingIntent, final int i) {
        checkNotClosed();
        launchTransitionCallbackInVr(new ITransitionCallbacks.Stub(this) {
            /* class com.google.vr.ndk.base.DaydreamApi.AnonymousClass6 */

            @Override // com.google.vr.vrcore.common.api.ITransitionCallbacks
            public void onTransitionComplete() {
                activity.runOnUiThread(new Runnable() {
                    /* class com.google.vr.ndk.base.DaydreamApi.AnonymousClass6.AnonymousClass1 */

                    public void run() {
                        try {
                            AnonymousClass6 r0 = AnonymousClass6.this;
                            activity.startIntentSenderForResult(pendingIntent.getIntentSender(), i, null, 0, 0, 0);
                        } catch (IntentSender.SendIntentException e) {
                            String str = DaydreamApi.TAG;
                            String valueOf = String.valueOf(e);
                            StringBuilder sb = new StringBuilder(valueOf.length() + 43);
                            sb.append("Exception while starting next VR activity: ");
                            sb.append(valueOf);
                            Log.e(str, sb.toString());
                        }
                    }
                });
            }
        });
    }

    @UsedByReflection("IAP")
    public void launchVrHomescreen() {
        checkNotClosed();
        runWhenServiceConnected(new Runnable() {
            /* class com.google.vr.ndk.base.DaydreamApi.AnonymousClass5 */

            public void run() {
                if (DaydreamApi.this.daydreamManager == null) {
                    Log.e(DaydreamApi.TAG, "Can't launch VR homescreen via DaydreamManager. Giving up trying to leave current VR activity...");
                    return;
                }
                try {
                    if (!DaydreamApi.this.daydreamManager.launchVrHome()) {
                        Log.e(DaydreamApi.TAG, "There is no VR homescreen installed.");
                    }
                } catch (RemoteException e) {
                    String str = DaydreamApi.TAG;
                    String valueOf = String.valueOf(e);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 47);
                    sb.append("RemoteException while launching VR homescreen: ");
                    sb.append(valueOf);
                    Log.e(str, sb.toString());
                }
            }
        });
    }

    private void launchInVr(final PendingIntent pendingIntent, final ComponentName componentName) {
        runWhenServiceConnected(new Runnable() {
            /* class com.google.vr.ndk.base.DaydreamApi.AnonymousClass3 */

            public void run() {
                if (DaydreamApi.this.daydreamManager != null) {
                    try {
                        DaydreamApi.this.daydreamManager.launchInVr(pendingIntent, componentName);
                    } catch (RemoteException e) {
                        Log.e(DaydreamApi.TAG, "RemoteException while launching PendingIntent in VR.", e);
                    }
                } else {
                    Log.w(DaydreamApi.TAG, "Can't launch PendingIntent via DaydreamManager: not available.");
                    try {
                        pendingIntent.send();
                    } catch (Exception e2) {
                        Log.e(DaydreamApi.TAG, "Couldn't launch PendingIntent: ", e2);
                    }
                }
            }
        });
    }

    @UsedByReflection("IAP")
    public void launchInVr(Intent intent) throws ActivityNotFoundException {
        checkNotClosed();
        if (intent != null) {
            checkIntent(intent);
            launchInVr(PendingIntent.getActivity(this.context, 0, intent, 1207959552), intent.getComponent());
            return;
        }
        throw new IllegalArgumentException("Null argument 'intent' passed to launchInVr");
    }

    @UsedByReflection("IAP")
    public void launchInVr(ComponentName componentName) throws ActivityNotFoundException {
        checkNotClosed();
        if (componentName != null) {
            Intent createVrIntent = createVrIntent(componentName);
            checkIntent(createVrIntent);
            launchInVr(PendingIntent.getActivity(this.context, 0, createVrIntent, 1073741824), createVrIntent.getComponent());
            return;
        }
        throw new IllegalArgumentException("Null argument 'componentName' passed to launchInVr");
    }
}
