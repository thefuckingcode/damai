package com.google.vr.sdk.widgets.common;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;

/* compiled from: Taobao */
public class TouchTracker implements View.OnTouchListener {
    private boolean flingingEnabled = false;
    private final GestureDetector gestureDetector;
    private boolean isYawing;
    private PointF lastTouchPointPx = new PointF();
    private final float scrollSlopPx;
    private PointF startTouchPointPx = new PointF();
    private final TouchEnabledVrView target;
    private boolean touchTrackingEnabled = true;
    private boolean verticalTrackingEnabled = false;

    /* compiled from: Taobao */
    private class FlingGestureListener implements GestureDetector.OnGestureListener {
        private final Context context;
        private final OverScroller overScroller;
        private final View view;

        FlingGestureListener(Context context2, View view2) {
            this.context = context2;
            this.view = view2;
            OverScroller overScroller2 = new OverScroller(context2);
            this.overScroller = overScroller2;
            overScroller2.setFriction(0.1f);
        }

        private void maybeStartFling(int i, int i2) {
            this.view.getParent().requestDisallowInterceptTouchEvent(false);
            if (Math.hypot((double) i, (double) i2) >= ((double) ViewConfiguration.get(this.context).getScaledMinimumFlingVelocity())) {
                this.overScroller.forceFinished(true);
                final DisplayMetrics displayMetrics = this.context.getResources().getDisplayMetrics();
                OverScroller overScroller2 = this.overScroller;
                int round = Math.round(TouchTracker.this.lastTouchPointPx.x);
                int round2 = Math.round(TouchTracker.this.lastTouchPointPx.y);
                int round3 = Math.round((float) i);
                int round4 = TouchTracker.this.verticalTrackingEnabled ? Math.round((float) i2) : 0;
                int i3 = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
                overScroller2.fling(round, round2, round3, round4, i3 * -100, i3 * 100, TouchTracker.this.verticalTrackingEnabled ? com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics) * -100 : 0, TouchTracker.this.verticalTrackingEnabled ? com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics) * 100 : 0, 0, 0);
                final PointF pointF = new PointF(TouchTracker.this.lastTouchPointPx.x, TouchTracker.this.lastTouchPointPx.y);
                this.view.postOnAnimation(new Runnable() {
                    /* class com.google.vr.sdk.widgets.common.TouchTracker.FlingGestureListener.AnonymousClass1 */

                    public void run() {
                        if (!FlingGestureListener.this.overScroller.isFinished()) {
                            FlingGestureListener.this.overScroller.computeScrollOffset();
                            int currX = FlingGestureListener.this.overScroller.getCurrX();
                            int currY = FlingGestureListener.this.overScroller.getCurrY();
                            float f = (float) currX;
                            TouchTracker.this.target.onPanningEvent(f - pointF.x, TouchTracker.this.verticalTrackingEnabled ? ((float) currY) - pointF.y : 0.0f);
                            float f2 = (float) currY;
                            pointF.set(f, f2);
                            TouchTracker.this.lastTouchPointPx.set((float) Math.min(currX, com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics)), f2);
                            FlingGestureListener.this.view.postOnAnimation(this);
                        }
                    }
                });
            }
        }

        public boolean onDown(MotionEvent motionEvent) {
            this.overScroller.forceFinished(true);
            return false;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            TouchTracker.this.startTouchPointPx.set(motionEvent.getX(), motionEvent.getY());
            TouchTracker.this.lastTouchPointPx.set(motionEvent2.getX(), motionEvent2.getY());
            maybeStartFling(Math.round(f), Math.round(f2));
            return true;
        }

        public void onLongPress(MotionEvent motionEvent) {
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return false;
        }

        public void onShowPress(MotionEvent motionEvent) {
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public interface TouchEnabledVrView {
        VrEventListener getEventListener();

        void onPanningEvent(float f, float f2);
    }

    public TouchTracker(Context context, View view, TouchEnabledVrView touchEnabledVrView) {
        this.gestureDetector = new GestureDetector(context, new FlingGestureListener(context, view));
        this.target = touchEnabledVrView;
        this.scrollSlopPx = (float) ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.touchTrackingEnabled && this.flingingEnabled) {
            this.gestureDetector.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.startTouchPointPx.set(motionEvent.getX(), motionEvent.getY());
            this.lastTouchPointPx.set(motionEvent.getX(), motionEvent.getY());
            view.getParent().requestDisallowInterceptTouchEvent(true);
            this.isYawing = false;
            return true;
        } else if (action == 1) {
            if (!this.touchTrackingEnabled || (Math.abs(motionEvent.getX() - this.startTouchPointPx.x) < this.scrollSlopPx && Math.abs(motionEvent.getY() - this.startTouchPointPx.y) < this.scrollSlopPx)) {
                this.target.getEventListener().onClick();
            }
            view.getParent().requestDisallowInterceptTouchEvent(false);
            return true;
        } else if (action != 2) {
            return false;
        } else {
            if (!this.touchTrackingEnabled) {
                view.getParent().requestDisallowInterceptTouchEvent(false);
                return false;
            }
            if (!this.isYawing) {
                if (!this.verticalTrackingEnabled && Math.abs(motionEvent.getY() - this.startTouchPointPx.y) > this.scrollSlopPx) {
                    view.getParent().requestDisallowInterceptTouchEvent(false);
                    return false;
                } else if (Math.abs(motionEvent.getX() - this.startTouchPointPx.x) > this.scrollSlopPx) {
                    this.isYawing = true;
                }
            }
            this.target.onPanningEvent(motionEvent.getX() - this.lastTouchPointPx.x, this.verticalTrackingEnabled ? motionEvent.getY() - this.lastTouchPointPx.y : 0.0f);
            this.lastTouchPointPx.set(motionEvent.getX(), motionEvent.getY());
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public void setFlingingEnabled(boolean z) {
        this.flingingEnabled = z;
    }

    /* access modifiers changed from: package-private */
    public void setTouchTrackingEnabled(boolean z) {
        this.touchTrackingEnabled = z;
    }

    /* access modifiers changed from: package-private */
    public void setVerticalTrackingEnabled(boolean z) {
        this.verticalTrackingEnabled = z;
    }
}
