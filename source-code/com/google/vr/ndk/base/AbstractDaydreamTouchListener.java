package com.google.vr.ndk.base;

import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import com.google.common.logging.nano.Vr$VREvent;
import com.google.vr.sdk.proto.nano.CardboardDevice;
import com.google.vr.sdk.proto.nano.Phone;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import tb.i90;

/* compiled from: Taobao */
public abstract class AbstractDaydreamTouchListener {
    private int angleSamplesReceived = 0;
    private float borderSizeMeters;
    private double[] currentMarkerBestDists;
    private DisplayMetrics displayMetrics;
    private boolean enabled = true;
    private boolean lastMotionEventInHeadset;
    private float[] lastTranslation = new float[2];
    private final String logTag = getClass().getSimpleName();
    private int[] markerBestTouch;
    private float[][] markersInPixels;
    private int mostTouchesSeen;
    private float[] pixelTranslation = new float[2];
    private float rotation;
    private int[] touchBestMarker;
    private float[] translation = new float[2];
    private float xMetersPerPixel;
    private float yMetersPerPixel;

    private void logPhoneAlignment(MotionEvent motionEvent, float f, float f2) {
        int pointerCount = motionEvent.getPointerCount();
        Vr$VREvent vr$VREvent = new Vr$VREvent();
        Vr$VREvent.PhoneAlignment phoneAlignment = new Vr$VREvent.PhoneAlignment();
        vr$VREvent.phoneAlignment = phoneAlignment;
        phoneAlignment.touchLocations = new Vr$VREvent.Vector2[pointerCount];
        for (int i = 0; i < pointerCount; i++) {
            vr$VREvent.phoneAlignment.touchLocations[i] = new Vr$VREvent.Vector2();
            vr$VREvent.phoneAlignment.touchLocations[i].x = Float.valueOf(motionEvent.getX(i) + f);
            vr$VREvent.phoneAlignment.touchLocations[i].y = Float.valueOf(motionEvent.getY(i) + f2);
        }
        vr$VREvent.phoneAlignment.lensOffset = new Vr$VREvent.Vector2();
        vr$VREvent.phoneAlignment.lensOffset.x = Float.valueOf(this.pixelTranslation[0]);
        vr$VREvent.phoneAlignment.lensOffset.y = Float.valueOf(this.pixelTranslation[1]);
        if (pointerCount == 2 && this.markersInPixels.length == 2) {
            double degrees = Math.toDegrees((double) getRotationRadians(motionEvent));
            vr$VREvent.phoneAlignment.angleDegrees = Float.valueOf((float) degrees);
            String str = this.logTag;
            StringBuilder sb = new StringBuilder(58);
            sb.append("Phone angle in headset (degrees): ");
            sb.append(degrees);
            Log.i(str, sb.toString());
            String str2 = this.logTag;
            StringBuilder sb2 = new StringBuilder(49);
            sb2.append("  Touch point 1: ");
            sb2.append(motionEvent.getX(0) + f);
            sb2.append(AVFSCacheConstants.COMMA_SEP);
            sb2.append(motionEvent.getY(0) + f2);
            Log.i(str2, sb2.toString());
            String str3 = this.logTag;
            float x = motionEvent.getX(1) + f;
            StringBuilder sb3 = new StringBuilder(49);
            sb3.append("  Touch point 2: ");
            sb3.append(x);
            sb3.append(AVFSCacheConstants.COMMA_SEP);
            sb3.append(motionEvent.getY(1) + f2);
            Log.i(str3, sb3.toString());
        }
        logEvent(2012, vr$VREvent);
    }

    private void resetTrackingState() {
        this.lastMotionEventInHeadset = false;
        float[] fArr = this.pixelTranslation;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        this.rotation = 0.0f;
        this.mostTouchesSeen = 0;
    }

    /* access modifiers changed from: package-private */
    public float getRotationRadians(MotionEvent motionEvent) {
        double atan2 = Math.atan2((double) (motionEvent.getY(0) - motionEvent.getY(1)), (double) (motionEvent.getX(0) - motionEvent.getX(1)));
        float[][] fArr = this.markersInPixels;
        float atan22 = (float) (atan2 - Math.atan2((double) (fArr[0][1] - fArr[1][1]), (double) (fArr[0][0] - fArr[1][0])));
        if (((double) atan22) > 1.5707963267948966d) {
            atan22 -= 3.1415927f;
        }
        return ((double) atan22) < -1.5707963267948966d ? atan22 + 3.1415927f : atan22;
    }

    public void getTranslationInScreenSpace(float[] fArr) {
        if (fArr.length >= 2) {
            DisplayMetrics displayMetrics2 = this.displayMetrics;
            if (displayMetrics2 == null) {
                Log.e(this.logTag, "displayMetrics must be set before calling getTranslationInScreenSpace.");
                return;
            }
            float[] fArr2 = this.pixelTranslation;
            fArr[0] = fArr2[0] / ((float) com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics2));
            fArr[1] = fArr2[1] / ((float) com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics2));
            fArr[0] = fArr[0] * 2.0f;
            fArr[1] = fArr[1] * -2.0f;
            return;
        }
        throw new IllegalArgumentException("Translation array too small");
    }

    /* access modifiers changed from: protected */
    public final boolean handleTouch(MotionEvent motionEvent, float f, float f2) {
        if (!processMotionEvent(motionEvent, f, f2)) {
            return false;
        }
        getTranslationInScreenSpace(this.translation);
        float[] fArr = this.translation;
        float f3 = fArr[0];
        float[] fArr2 = this.lastTranslation;
        if (!(f3 == fArr2[0] && fArr[1] == fArr2[1])) {
            fArr2[0] = fArr[0];
            fArr2[1] = fArr[1];
            setLensOffset(fArr[0], fArr[1], this.rotation);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public final void initWithPhoneParams(DisplayMetrics displayMetrics2, Phone.PhoneParams phoneParams) {
        this.displayMetrics = displayMetrics2;
        this.borderSizeMeters = i90.a(phoneParams);
        this.xMetersPerPixel = i90.f(this.displayMetrics.xdpi);
        this.yMetersPerPixel = i90.f(this.displayMetrics.ydpi);
        resetTrackingState();
    }

    /* access modifiers changed from: protected */
    public abstract boolean isDaydreamImageAlignmentEnabled();

    /* access modifiers changed from: protected */
    public abstract void logEvent(int i, Vr$VREvent vr$VREvent);

    /* access modifiers changed from: package-private */
    public boolean processMotionEvent(MotionEvent motionEvent, float f, float f2) {
        if (!viewerNeedsTouchProcessing()) {
            this.lastMotionEventInHeadset = false;
            return false;
        } else if (!isDaydreamImageAlignmentEnabled()) {
            return true;
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount > this.mostTouchesSeen) {
                this.touchBestMarker = new int[pointerCount];
                this.mostTouchesSeen = pointerCount;
            }
            for (int i = 0; i < this.markersInPixels.length; i++) {
                this.markerBestTouch[i] = -1;
                this.currentMarkerBestDists[i] = 2.25E-4d;
            }
            for (int i2 = 0; i2 < pointerCount; i2++) {
                this.touchBestMarker[i2] = -1;
                double d = 2.25E-4d;
                int i3 = 0;
                while (true) {
                    float[][] fArr = this.markersInPixels;
                    if (i3 >= fArr.length) {
                        break;
                    }
                    float x = (fArr[i3][0] - (motionEvent.getX(i2) + f)) * this.xMetersPerPixel;
                    float y = (this.markersInPixels[i3][1] - (motionEvent.getY(i2) + f2)) * this.yMetersPerPixel;
                    double d2 = (double) ((x * x) + (y * y));
                    if (d2 < d) {
                        this.touchBestMarker[i2] = i3;
                        d = d2;
                    }
                    double[] dArr = this.currentMarkerBestDists;
                    if (d2 < dArr[i3]) {
                        dArr[i3] = d2;
                        this.markerBestTouch[i3] = i2;
                    }
                    i3++;
                }
            }
            int i4 = 0;
            int i5 = 0;
            float f3 = 0.0f;
            float f4 = 0.0f;
            while (true) {
                int[] iArr = this.markerBestTouch;
                if (i4 >= iArr.length) {
                    break;
                }
                if (iArr[i4] != -1) {
                    if (this.touchBestMarker[iArr[i4]] != i4) {
                        iArr[i4] = -1;
                    } else {
                        i5++;
                        f3 += (motionEvent.getX(iArr[i4]) + f) - this.markersInPixels[i4][0];
                        f4 += (motionEvent.getY(this.markerBestTouch[i4]) + f2) - this.markersInPixels[i4][1];
                    }
                }
                i4++;
            }
            if (i5 > 0) {
                this.lastMotionEventInHeadset = true;
                float[] fArr2 = this.pixelTranslation;
                float f5 = (float) i5;
                fArr2[0] = f3 / f5;
                fArr2[1] = f4 / f5;
            } else {
                this.lastMotionEventInHeadset = false;
                float[] fArr3 = this.pixelTranslation;
                fArr3[0] = 0.0f;
                fArr3[1] = 0.0f;
            }
            if (i5 == 2) {
                this.rotation = getRotationRadians(motionEvent);
            } else {
                this.rotation = 0.0f;
            }
            if (pointerCount > 0) {
                int i6 = this.angleSamplesReceived + 1;
                this.angleSamplesReceived = i6;
                if (i6 == 200) {
                    logPhoneAlignment(motionEvent, f, f2);
                }
            }
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public final void setDeviceParams(CardboardDevice.DeviceParams deviceParams) {
        CardboardDevice.DaydreamInternalParams daydreamInternalParams;
        CardboardDevice.ScreenAlignmentMarker[] screenAlignmentMarkerArr;
        if (deviceParams == null || (daydreamInternalParams = deviceParams.daydreamInternal) == null || (screenAlignmentMarkerArr = daydreamInternalParams.alignmentMarkers) == null) {
            Log.e(this.logTag, "Null deviceParams or no alignment markers found.");
            this.markersInPixels = null;
        } else if (this.displayMetrics == null) {
            Log.e(this.logTag, "displayMetrics must be set before calling setDeviceParams.");
        } else {
            this.markersInPixels = new float[screenAlignmentMarkerArr.length][];
            this.currentMarkerBestDists = new double[screenAlignmentMarkerArr.length];
            this.markerBestTouch = new int[screenAlignmentMarkerArr.length];
            for (int i = 0; i < screenAlignmentMarkerArr.length; i++) {
                CardboardDevice.ScreenAlignmentMarker screenAlignmentMarker = screenAlignmentMarkerArr[i];
                float[][] fArr = this.markersInPixels;
                fArr[i] = new float[2];
                fArr[i][0] = ((float) (com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(this.displayMetrics) / 2)) + (screenAlignmentMarker.getHorizontal() / this.xMetersPerPixel);
                this.markersInPixels[i][1] = ((float) com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(this.displayMetrics)) - (((screenAlignmentMarker.getVertical() + deviceParams.getTrayToLensDistance()) - this.borderSizeMeters) / this.yMetersPerPixel);
            }
        }
    }

    public void setEnabled(boolean z) {
        this.enabled = z;
        if (!z) {
            resetTrackingState();
        }
    }

    /* access modifiers changed from: protected */
    public abstract void setLensOffset(float f, float f2, float f3);

    /* access modifiers changed from: package-private */
    public boolean viewerNeedsTouchProcessing() {
        float[][] fArr;
        return this.enabled && (fArr = this.markersInPixels) != null && fArr.length > 0;
    }
}
