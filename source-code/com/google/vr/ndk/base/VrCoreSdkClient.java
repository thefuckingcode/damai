package com.google.vr.ndk.base;

import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.vr.cardboard.R$string;
import com.google.vr.vrcore.base.api.VrCoreNotAvailableException;
import com.google.vr.vrcore.base.api.VrCoreUtils;
import com.google.vr.vrcore.common.api.HeadTrackingState;
import com.google.vr.vrcore.common.api.IDaydreamListener;
import com.google.vr.vrcore.common.api.IDaydreamManager;
import com.google.vr.vrcore.common.api.IVrCoreSdkService;
import com.google.vr.vrcore.logging.api.IVrCoreLoggingService;
import java.lang.ref.WeakReference;
import tb.dr2;
import tb.vk2;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class VrCoreSdkClient {
    private final Runnable closeVrRunnable;
    private final ComponentName componentName;
    private final Context context;
    private final DaydreamListenerImpl daydreamListener;
    private IDaydreamManager daydreamManager;
    private final DaydreamUtilsWrapper daydreamUtils;
    private final FadeOverlayView fadeOverlayView;
    private final GvrApi gvrApi;
    private AlertDialog helpCenterDialog;
    private boolean isBound;
    private boolean isEnabled = true;
    private boolean isResumed;
    private IVrCoreLoggingService loggingService;
    private PendingIntent optionalReentryIntent;
    private final ServiceConnection serviceConnection = new ServiceConnection() {
        /* class com.google.vr.ndk.base.VrCoreSdkClient.AnonymousClass1 */

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            int i;
            IVrCoreSdkService asInterface = IVrCoreSdkService.Stub.asInterface(iBinder);
            try {
                if (!asInterface.initialize(19)) {
                    Log.e("VrCoreSdkClient", "Failed to initialize VrCore SDK Service.");
                    VrCoreSdkClient.this.handleBindFailed();
                    return;
                }
                VrCoreSdkClient.this.vrCoreSdkService = asInterface;
                try {
                    VrCoreSdkClient vrCoreSdkClient = VrCoreSdkClient.this;
                    vrCoreSdkClient.daydreamManager = vrCoreSdkClient.vrCoreSdkService.getDaydreamManager();
                    if (VrCoreSdkClient.this.daydreamManager == null) {
                        Log.w("VrCoreSdkClient", "Failed to obtain DaydreamManager from VrCore SDK Service.");
                        VrCoreSdkClient.this.handleNoDaydreamManager();
                        return;
                    }
                    VrCoreSdkClient.this.daydreamManager.registerListener(VrCoreSdkClient.this.componentName, VrCoreSdkClient.this.daydreamListener);
                    HeadTrackingState headTrackingState = null;
                    try {
                        HeadTrackingState headTrackingState2 = VrCoreSdkClient.this.getHeadTrackingState();
                        if (VrCoreSdkClient.this.vrCoreClientApiVersion >= 13) {
                            int componentDaydreamCompatibility = DaydreamUtils.getComponentDaydreamCompatibility(VrCoreSdkClient.this.context, VrCoreSdkClient.this.componentName);
                            PendingIntent pendingIntent = VrCoreSdkClient.this.optionalReentryIntent;
                            if (pendingIntent == null) {
                                Intent createVrIntent = DaydreamApi.createVrIntent(VrCoreSdkClient.this.componentName);
                                createVrIntent.addFlags(536870912);
                                pendingIntent = PendingIntent.getActivity(VrCoreSdkClient.this.context, 0, createVrIntent, 1073741824);
                            }
                            i = VrCoreSdkClient.this.daydreamManager.prepareVr2(VrCoreSdkClient.this.componentName, componentDaydreamCompatibility, pendingIntent, headTrackingState2);
                        } else {
                            if (VrCoreSdkClient.this.optionalReentryIntent != null) {
                                Log.i("VrCoreSdkClient", "Ignoring client re-entry intent; unsupported by current VrCore.");
                            }
                            i = VrCoreSdkClient.this.daydreamManager.prepareVr(VrCoreSdkClient.this.componentName, headTrackingState2);
                        }
                        if (i == 2) {
                            Log.e("VrCoreSdkClient", "Daydream VR preparation failed, closing VR session.");
                            VrCoreSdkClient.this.handlePrepareVrFailed();
                            VrCoreSdkClient.this.resumeTracking(null);
                            return;
                        }
                        if (i == 0) {
                            headTrackingState = headTrackingState2;
                        }
                        VrCoreSdkClient.this.resumeTracking(headTrackingState);
                        try {
                            VrCoreSdkClient vrCoreSdkClient2 = VrCoreSdkClient.this;
                            vrCoreSdkClient2.loggingService = vrCoreSdkClient2.vrCoreSdkService.getLoggingService();
                        } catch (RemoteException e) {
                            String valueOf = String.valueOf(e);
                            StringBuilder sb = new StringBuilder(valueOf.length() + 42);
                            sb.append("Error getting logging service from VrCore:");
                            sb.append(valueOf);
                            Log.w("VrCoreSdkClient", sb.toString());
                        }
                    } catch (RemoteException e2) {
                        String valueOf2 = String.valueOf(e2);
                        StringBuilder sb2 = new StringBuilder(valueOf2.length() + 61);
                        sb2.append("Error while registering listener with the VrCore SDK Service:");
                        sb2.append(valueOf2);
                        Log.w("VrCoreSdkClient", sb2.toString());
                    } catch (Throwable th) {
                        VrCoreSdkClient.this.resumeTracking(null);
                        throw th;
                    }
                } catch (RemoteException e3) {
                    String valueOf3 = String.valueOf(e3);
                    StringBuilder sb3 = new StringBuilder(valueOf3.length() + 57);
                    sb3.append("Failed to obtain DaydreamManager from VrCore SDK Service:");
                    sb3.append(valueOf3);
                    Log.w("VrCoreSdkClient", sb3.toString());
                    VrCoreSdkClient.this.handleNoDaydreamManager();
                }
            } catch (RemoteException e4) {
                String valueOf4 = String.valueOf(e4);
                StringBuilder sb4 = new StringBuilder(valueOf4.length() + 41);
                sb4.append("Failed to initialize VrCore SDK Service: ");
                sb4.append(valueOf4);
                Log.w("VrCoreSdkClient", sb4.toString());
                VrCoreSdkClient.this.handleBindFailed();
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            VrCoreSdkClient.this.vrCoreSdkService = null;
            VrCoreSdkClient.this.daydreamManager = null;
            VrCoreSdkClient.this.loggingService = null;
        }
    };
    private final boolean shouldBind;
    private int vrCoreClientApiVersion;
    private IVrCoreSdkService vrCoreSdkService;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class DaydreamListenerImpl extends IDaydreamListener.Stub {
        private static final long FADE_SAFEGUARD_DELAY_MILLIS = 5500;
        private static final int MSG_FADE_IN_SAFEGUARD = 2;
        private static final int MSG_TRACKING_RESUME_SAFEGUARD = 1;
        private static final long TRACKING_SAFEGUARD_DELAY_MILLIS = 5000;
        private final WeakReference<Runnable> closeVrRunnableWeak;
        private final WeakReference<FadeOverlayView> fadeOverlayViewWeak;
        private final WeakReference<GvrApi> gvrApiWeak;
        private final Handler safeguardHandler = new Handler() {
            /* class com.google.vr.ndk.base.VrCoreSdkClient.DaydreamListenerImpl.AnonymousClass1 */

            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 1) {
                    Log.w("VrCoreSdkClient", "Forcing tracking resume: VrCore unresponsive");
                    DaydreamListenerImpl.this.resumeHeadTrackingImpl(null);
                } else if (i != 2) {
                    super.handleMessage(message);
                } else {
                    Log.w("VrCoreSdkClient", "Forcing fade in: VrCore unresponsive");
                    DaydreamListenerImpl.this.applyFadeImpl(1, 350);
                }
            }
        };

        DaydreamListenerImpl(GvrApi gvrApi, FadeOverlayView fadeOverlayView, Runnable runnable) {
            this.gvrApiWeak = new WeakReference<>(gvrApi);
            this.fadeOverlayViewWeak = new WeakReference<>(fadeOverlayView);
            this.closeVrRunnableWeak = new WeakReference<>(runnable);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void applyFadeImpl(final int i, final long j) {
            final FadeOverlayView fadeOverlayView = this.fadeOverlayViewWeak.get();
            if (fadeOverlayView != null) {
                cancelSafeguard(2);
                fadeOverlayView.post(new Runnable(this) {
                    /* class com.google.vr.ndk.base.VrCoreSdkClient.DaydreamListenerImpl.AnonymousClass2 */

                    public void run() {
                        fadeOverlayView.startFade(i, j);
                    }
                });
                if (i == 2) {
                    rescheduleSafeguard(2, j + FADE_SAFEGUARD_DELAY_MILLIS);
                }
            }
        }

        private final void cancelSafeguard(int i) {
            this.safeguardHandler.removeMessages(i);
        }

        private final void rescheduleSafeguard(int i, long j) {
            cancelSafeguard(i);
            this.safeguardHandler.sendEmptyMessageDelayed(i, j);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void resumeHeadTrackingImpl(HeadTrackingState headTrackingState) {
            GvrApi gvrApi = this.gvrApiWeak.get();
            if (gvrApi == null) {
                Log.w("VrCoreSdkClient", "Invalid resumeHeadTracking() call: GvrApi no longer valid");
                return;
            }
            cancelSafeguard(1);
            VrCoreSdkClient.resumeTracking(gvrApi, headTrackingState);
        }

        @Override // com.google.vr.vrcore.common.api.IDaydreamListener
        public final void applyFade(int i, long j) {
            applyFadeImpl(i, j);
        }

        @Override // com.google.vr.vrcore.common.api.IDaydreamListener
        public final void deprecated_setLensOffsets(float f, float f2, float f3, float f4) {
            GvrApi gvrApi = this.gvrApiWeak.get();
            if (gvrApi == null) {
                Log.w("VrCoreSdkClient", "Invalid setLensOffsets() call: GvrApi no longer valid");
            } else {
                gvrApi.setLensOffset(f, f2, 0.0f);
            }
        }

        @Override // com.google.vr.vrcore.common.api.IDaydreamListener
        public final void dumpDebugData() throws RemoteException {
            GvrApi gvrApi = this.gvrApiWeak.get();
            if (gvrApi == null) {
                Log.w("VrCoreSdkClient", "Invalid dumpDebugData() call: GvrApi no longer valid");
            } else {
                gvrApi.dumpDebugData();
            }
        }

        @Override // com.google.vr.vrcore.common.api.IDaydreamListener
        public final int getTargetApiVersion() throws RemoteException {
            return 19;
        }

        @Override // com.google.vr.vrcore.common.api.IDaydreamListener
        public final void invokeCloseAction() {
            Runnable runnable = this.closeVrRunnableWeak.get();
            if (runnable == null) {
                Log.w("VrCoreSdkClient", "Invalid invokeCloseAction() call: Runnable no longer valid");
            } else {
                vk2.a(runnable);
            }
        }

        @Override // com.google.vr.vrcore.common.api.IDaydreamListener
        public final void recenterHeadTracking() throws RemoteException {
            GvrApi gvrApi = this.gvrApiWeak.get();
            if (gvrApi == null) {
                Log.w("VrCoreSdkClient", "Invalid recenterHeadTracking() call: GvrApi no longer valid");
            } else {
                gvrApi.recenterTracking();
            }
        }

        @Override // com.google.vr.vrcore.common.api.IDaydreamListener
        public final HeadTrackingState requestStopTracking() throws RemoteException {
            GvrApi gvrApi = this.gvrApiWeak.get();
            if (gvrApi == null) {
                Log.w("VrCoreSdkClient", "Invalid requestStopTracking() call: GvrApi no longer valid");
                return null;
            }
            byte[] pauseTrackingGetState = gvrApi.pauseTrackingGetState();
            rescheduleSafeguard(1, 5000);
            if (pauseTrackingGetState != null) {
                return new HeadTrackingState(pauseTrackingGetState);
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public final void resetSafeguards() {
            this.safeguardHandler.removeCallbacksAndMessages(null);
        }

        @Override // com.google.vr.vrcore.common.api.IDaydreamListener
        public final void resumeHeadTracking(HeadTrackingState headTrackingState) {
            resumeHeadTrackingImpl(headTrackingState);
        }

        @Override // com.google.vr.vrcore.common.api.IDaydreamListener
        public final void setLensOffset(float f, float f2, float f3) {
            GvrApi gvrApi = this.gvrApiWeak.get();
            if (gvrApi == null) {
                Log.w("VrCoreSdkClient", "Invalid setLensOffset() call: GvrApi no longer valid");
            } else {
                gvrApi.setLensOffset(f, f2, f3);
            }
        }
    }

    public VrCoreSdkClient(Context context2, GvrApi gvrApi2, ComponentName componentName2, DaydreamUtilsWrapper daydreamUtilsWrapper, Runnable runnable, FadeOverlayView fadeOverlayView2) {
        this.context = context2;
        this.gvrApi = gvrApi2;
        this.componentName = componentName2;
        this.daydreamUtils = daydreamUtilsWrapper;
        this.closeVrRunnable = runnable;
        this.fadeOverlayView = fadeOverlayView2;
        this.daydreamListener = new DaydreamListenerImpl(gvrApi2, fadeOverlayView2, runnable);
        this.shouldBind = hasCompatibleSdkService(context2);
        gvrApi2.setIgnoreManualTrackerPauseResume(true);
    }

    private boolean doBind() {
        if (this.isBound) {
            return true;
        }
        if (this.shouldBind) {
            Intent intent = new Intent("com.google.vr.vrcore.BIND_SDK_SERVICE");
            intent.setPackage("com.google.vr.vrcore");
            this.isBound = this.context.bindService(intent, this.serviceConnection, 1);
        }
        if (!this.isBound) {
            handleBindFailed();
        }
        return this.isBound;
    }

    private void doUnbind() {
        if (this.isResumed) {
            resumeTracking(null);
        } else {
            this.gvrApi.pauseTrackingGetState();
        }
        if (this.isBound) {
            IDaydreamManager iDaydreamManager = this.daydreamManager;
            if (iDaydreamManager != null) {
                try {
                    iDaydreamManager.unregisterListener(this.componentName);
                } catch (RemoteException e) {
                    String valueOf = String.valueOf(e);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 40);
                    sb.append("Failed to unregister Daydream listener: ");
                    sb.append(valueOf);
                    Log.w("VrCoreSdkClient", sb.toString());
                }
                this.daydreamManager = null;
            }
            this.vrCoreSdkService = null;
            this.loggingService = null;
            this.context.unbindService(this.serviceConnection);
            this.isBound = false;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void handleBindFailed() {
        doUnbind();
        warnIfIncompatibleClient();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void handleNoDaydreamManager() {
        doUnbind();
        warnIfIncompatibleClient();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void handlePrepareVrFailed() {
        doUnbind();
        this.closeVrRunnable.run();
    }

    private boolean hasCompatibleSdkService(Context context2) {
        try {
            int vrCoreClientApiVersion2 = VrCoreUtils.getVrCoreClientApiVersion(context2);
            this.vrCoreClientApiVersion = vrCoreClientApiVersion2;
            if (vrCoreClientApiVersion2 >= 5) {
                return true;
            }
            Log.w("VrCoreSdkClient", String.format("VrCore service obsolete, GVR SDK requires API %d but found API %d.", 5, Integer.valueOf(this.vrCoreClientApiVersion)));
            return false;
        } catch (VrCoreNotAvailableException unused) {
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void resumeTracking(HeadTrackingState headTrackingState) {
        resumeTracking(this.gvrApi, headTrackingState);
        FadeOverlayView fadeOverlayView2 = this.fadeOverlayView;
        if (fadeOverlayView2 != null) {
            fadeOverlayView2.flushAutoFade();
        }
    }

    private void warnIfIncompatibleClient() {
        if (!this.daydreamUtils.isDaydreamPhone(this.context) && this.daydreamUtils.isDaydreamRequiredComponent(this.context) && !ActivityManager.isRunningInTestHarness()) {
            AlertDialog alertDialog = this.helpCenterDialog;
            if (alertDialog != null) {
                alertDialog.show();
            } else {
                this.helpCenterDialog = dr2.c(this.context, R$string.dialog_title_incompatible_phone, R$string.dialog_message_incompatible_phone, this.closeVrRunnable);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public HeadTrackingState getHeadTrackingState() {
        return new HeadTrackingState();
    }

    /* access modifiers changed from: package-private */
    public IVrCoreLoggingService getLoggingService() {
        return this.loggingService;
    }

    public void onExitingFromVr() {
        IDaydreamManager iDaydreamManager = this.daydreamManager;
        if (iDaydreamManager != null && this.vrCoreClientApiVersion >= 16) {
            try {
                iDaydreamManager.onExitingFromVr();
            } catch (RemoteException e) {
                String valueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(valueOf.length() + 41);
                sb.append("Failed to signal exit from VR to VrCore: ");
                sb.append(valueOf);
                Log.e("VrCoreSdkClient", sb.toString());
            }
        }
    }

    public void onPause() {
        this.isResumed = false;
        this.daydreamListener.resetSafeguards();
        if (this.isEnabled) {
            doUnbind();
        }
    }

    public boolean onResume() {
        this.isResumed = true;
        if (!this.isEnabled) {
            return false;
        }
        return doBind();
    }

    public void setEnabled(boolean z) {
        if (this.isEnabled != z) {
            this.isEnabled = z;
            this.gvrApi.setIgnoreManualTrackerPauseResume(z);
            if (!this.isResumed) {
                return;
            }
            if (this.isEnabled) {
                doBind();
            } else {
                doUnbind();
            }
        }
    }

    public void setReentryIntent(PendingIntent pendingIntent) {
        this.optionalReentryIntent = pendingIntent;
    }

    /* access modifiers changed from: private */
    public static void resumeTracking(GvrApi gvrApi2, HeadTrackingState headTrackingState) {
        gvrApi2.resumeTrackingSetState((headTrackingState == null || headTrackingState.isEmpty()) ? null : headTrackingState.getData());
    }
}
