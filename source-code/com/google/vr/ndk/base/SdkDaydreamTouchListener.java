package com.google.vr.ndk.base;

import android.content.Context;
import android.os.AsyncTask;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import com.google.common.logging.nano.Vr$VREvent;
import com.google.vr.cardboard.VrParamsProvider;
import com.google.vr.sdk.proto.nano.CardboardDevice;
import com.google.vr.sdk.proto.nano.Phone;
import com.google.vr.vrcore.logging.api.VREventParcelable;
import tb.i90;
import tb.ww2;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class SdkDaydreamTouchListener extends AbstractDaydreamTouchListener implements View.OnTouchListener {
    private final GvrApi gvrApi;
    private final GvrLayoutImpl gvrLayout;
    private final boolean isDaydreamImageAlignmentEnabled;
    private final VrParamsProvider vrParamsProvider;

    /* compiled from: Taobao */
    class FinishInitilizationTask extends AsyncTask<Void, Void, Phone.PhoneParams> {
        public Display display;

        private FinishInitilizationTask() {
        }

        /* access modifiers changed from: protected */
        public void onProgressUpdate(Void... voidArr) {
        }

        /* access modifiers changed from: protected */
        public Phone.PhoneParams doInBackground(Void... voidArr) {
            return SdkDaydreamTouchListener.this.vrParamsProvider.readPhoneParams();
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Phone.PhoneParams phoneParams) {
            SdkDaydreamTouchListener.this.init(i90.d(this.display, phoneParams), phoneParams);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class RefreshViewerProfileTask extends AsyncTask<Void, Void, CardboardDevice.DeviceParams> {
        private RefreshViewerProfileTask() {
        }

        /* access modifiers changed from: protected */
        public void onProgressUpdate(Void... voidArr) {
        }

        /* access modifiers changed from: protected */
        public CardboardDevice.DeviceParams doInBackground(Void... voidArr) {
            return SdkDaydreamTouchListener.this.vrParamsProvider.readDeviceParams();
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(CardboardDevice.DeviceParams deviceParams) {
            SdkDaydreamTouchListener.this.setDeviceParams(deviceParams);
        }
    }

    public SdkDaydreamTouchListener(GvrLayoutImpl gvrLayoutImpl) {
        this.gvrLayout = gvrLayoutImpl;
        GvrApi gvrApi2 = gvrLayoutImpl.getGvrApi();
        this.gvrApi = gvrApi2;
        boolean z = true;
        this.isDaydreamImageAlignmentEnabled = (gvrApi2.getSdkConfigurationParams().daydreamImageAlignment.intValue() == 1 || gvrApi2.getSdkConfigurationParams().touchOverlayEnabled.booleanValue()) ? false : z;
        Context context = gvrLayoutImpl.getContext();
        this.vrParamsProvider = ww2.a(context);
        FinishInitilizationTask finishInitilizationTask = new FinishInitilizationTask();
        finishInitilizationTask.display = i90.b(context);
        finishInitilizationTask.execute(new Void[0]);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void init(DisplayMetrics displayMetrics, Phone.PhoneParams phoneParams) {
        initWithPhoneParams(displayMetrics, phoneParams);
        refreshViewerProfile();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.vr.ndk.base.AbstractDaydreamTouchListener
    public boolean isDaydreamImageAlignmentEnabled() {
        return this.isDaydreamImageAlignmentEnabled;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.vr.ndk.base.AbstractDaydreamTouchListener
    public void logEvent(int i, Vr$VREvent vr$VREvent) {
        if (this.gvrLayout.getVrCoreSdkClient() == null || this.gvrLayout.getVrCoreSdkClient().getLoggingService() == null) {
            Log.w("SdkDaydreamTouchListener", "Unable to log alignment event; logging service not available.");
            return;
        }
        try {
            this.gvrLayout.getVrCoreSdkClient().getLoggingService().log(new VREventParcelable(2012, vr$VREvent));
        } catch (RemoteException unused) {
            Log.w("SdkDaydreamTouchListener", "Unable to log alignment event");
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return handleTouch(motionEvent, 0.0f, 0.0f);
    }

    public void refreshViewerProfile() {
        new RefreshViewerProfileTask().execute(new Void[0]);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.vr.ndk.base.AbstractDaydreamTouchListener
    public void setLensOffset(float f, float f2, float f3) {
        this.gvrApi.setLensOffset(f, f2, 0.0f);
    }

    public void shutdown() {
        this.vrParamsProvider.close();
    }
}
