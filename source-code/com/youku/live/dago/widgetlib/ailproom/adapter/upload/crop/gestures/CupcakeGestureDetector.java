package com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop.gestures;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class CupcakeGestureDetector implements GestureDetector {
    private static transient /* synthetic */ IpChange $ipChange = null;
    static final String TAG = "CupcakeGestureDetector";
    boolean mIsDragging;
    float mLastTouchX;
    float mLastTouchY;
    OnGestureListener mListener;
    final float mMinimumVelocity;
    final float mTouchSlop;
    VelocityTracker mVelocityTracker;

    CupcakeGestureDetector(Context context) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = (float) viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = (float) viewConfiguration.getScaledMinimumFlingVelocity();
    }

    /* access modifiers changed from: package-private */
    public float getActiveX(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-97253940")) {
            return motionEvent.getX();
        }
        return ((Float) ipChange.ipc$dispatch("-97253940", new Object[]{this, motionEvent})).floatValue();
    }

    /* access modifiers changed from: package-private */
    public float getActiveY(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-85937813")) {
            return motionEvent.getY();
        }
        return ((Float) ipChange.ipc$dispatch("-85937813", new Object[]{this, motionEvent})).floatValue();
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop.gestures.GestureDetector
    public boolean isDragging() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "865893038")) {
            return this.mIsDragging;
        }
        return ((Boolean) ipChange.ipc$dispatch("865893038", new Object[]{this})).booleanValue();
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop.gestures.GestureDetector
    public boolean isScaling() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "150421294")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("150421294", new Object[]{this})).booleanValue();
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop.gestures.GestureDetector
    public boolean onTouchEvent(MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "974362402")) {
            return ((Boolean) ipChange.ipc$dispatch("974362402", new Object[]{this, motionEvent})).booleanValue();
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            VelocityTracker obtain = VelocityTracker.obtain();
            this.mVelocityTracker = obtain;
            if (obtain != null) {
                obtain.addMovement(motionEvent);
            }
            this.mLastTouchX = getActiveX(motionEvent);
            this.mLastTouchY = getActiveY(motionEvent);
            this.mIsDragging = false;
        } else if (action == 1) {
            if (this.mIsDragging && this.mVelocityTracker != null) {
                this.mLastTouchX = getActiveX(motionEvent);
                this.mLastTouchY = getActiveY(motionEvent);
                this.mVelocityTracker.addMovement(motionEvent);
                this.mVelocityTracker.computeCurrentVelocity(1000);
                float xVelocity = this.mVelocityTracker.getXVelocity();
                float yVelocity = this.mVelocityTracker.getYVelocity();
                if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.mMinimumVelocity) {
                    this.mListener.onFling(this.mLastTouchX, this.mLastTouchY, -xVelocity, -yVelocity);
                }
            }
            VelocityTracker velocityTracker2 = this.mVelocityTracker;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.mVelocityTracker = null;
            }
        } else if (action == 2) {
            float activeX = getActiveX(motionEvent);
            float activeY = getActiveY(motionEvent);
            float f = activeX - this.mLastTouchX;
            float f2 = activeY - this.mLastTouchY;
            if (!this.mIsDragging) {
                if (Math.sqrt((double) ((f * f) + (f2 * f2))) >= ((double) this.mTouchSlop)) {
                    z = true;
                }
                this.mIsDragging = z;
            }
            if (this.mIsDragging) {
                this.mListener.onDrag(f, f2);
                this.mLastTouchX = activeX;
                this.mLastTouchY = activeY;
                VelocityTracker velocityTracker3 = this.mVelocityTracker;
                if (velocityTracker3 != null) {
                    velocityTracker3.addMovement(motionEvent);
                }
            }
        } else if (action == 3 && (velocityTracker = this.mVelocityTracker) != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
        return true;
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop.gestures.GestureDetector
    public void setOnGestureListener(OnGestureListener onGestureListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "350425457")) {
            ipChange.ipc$dispatch("350425457", new Object[]{this, onGestureListener});
            return;
        }
        this.mListener = onGestureListener;
    }
}
