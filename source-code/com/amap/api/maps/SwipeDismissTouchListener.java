package com.amap.api.maps;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;

/* compiled from: Taobao */
public class SwipeDismissTouchListener implements View.OnTouchListener {
    public static final int A_HALF = 2;
    public static final int MIN_VIEW_WIDTH = 2;
    public static final int ONE_THIRD = 3;
    private int a;
    private int b;
    private int c;
    private long d;
    private View e;
    private DismissCallbacks f;
    private int g = 1;
    private float h;
    private float i;
    private boolean j;
    private int k;
    private Object l;
    private VelocityTracker m;
    private float n;
    private boolean o;
    private boolean p;

    /* compiled from: Taobao */
    public interface DismissCallbacks {
        boolean canDismiss(Object obj);

        void onDismiss(View view, Object obj);

        void onNotifySwipe();
    }

    public SwipeDismissTouchListener(View view, Object obj, DismissCallbacks dismissCallbacks) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        this.a = viewConfiguration.getScaledTouchSlop();
        this.b = viewConfiguration.getScaledMinimumFlingVelocity() * 16;
        this.c = viewConfiguration.getScaledMaximumFlingVelocity();
        this.d = (long) view.getContext().getResources().getInteger(17694720);
        this.e = view;
        this.l = obj;
        this.f = dismissCallbacks;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        motionEvent.offsetLocation(this.n, 0.0f);
        if (this.g < 2) {
            this.g = this.e.getWidth();
        }
        int actionMasked = motionEvent.getActionMasked();
        boolean z2 = true;
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    VelocityTracker velocityTracker = this.m;
                    if (velocityTracker != null) {
                        velocityTracker.addMovement(motionEvent);
                        float rawX = motionEvent.getRawX() - this.h;
                        float rawY = motionEvent.getRawY() - this.i;
                        if (Math.abs(rawX) > ((float) this.a) && Math.abs(rawY) < Math.abs(rawX) / 2.0f) {
                            this.j = true;
                            this.k = rawX > 0.0f ? this.a : -this.a;
                            this.e.getParent().requestDisallowInterceptTouchEvent(true);
                            if (!this.o) {
                                this.o = true;
                                this.f.onNotifySwipe();
                            }
                            if (Math.abs(rawX) <= ((float) (this.g / 3))) {
                                this.p = false;
                            } else if (!this.p) {
                                this.p = true;
                                this.f.onNotifySwipe();
                            }
                            MotionEvent obtain = MotionEvent.obtain(motionEvent);
                            obtain.setAction((motionEvent.getActionIndex() << 8) | 3);
                            this.e.onTouchEvent(obtain);
                            obtain.recycle();
                        }
                        if (this.j) {
                            this.n = rawX;
                            this.e.setTranslationX(rawX - ((float) this.k));
                            this.e.setAlpha(Math.max(0.0f, Math.min(1.0f, 1.0f - ((Math.abs(rawX) * 2.0f) / ((float) this.g)))));
                            return true;
                        }
                    }
                } else if (actionMasked == 3 && this.m != null) {
                    this.e.animate().translationX(0.0f).alpha(1.0f).setDuration(this.d).setListener(null);
                    this.m.recycle();
                    this.m = null;
                    this.n = 0.0f;
                    this.h = 0.0f;
                    this.i = 0.0f;
                    this.j = false;
                }
            } else if (this.m != null) {
                float rawX2 = motionEvent.getRawX() - this.h;
                this.m.addMovement(motionEvent);
                this.m.computeCurrentVelocity(1000);
                float xVelocity = this.m.getXVelocity();
                float abs = Math.abs(xVelocity);
                float abs2 = Math.abs(this.m.getYVelocity());
                if (Math.abs(rawX2) > ((float) (this.g / 2)) && this.j) {
                    z = rawX2 > 0.0f;
                } else if (((float) this.b) > abs || abs > ((float) this.c) || abs2 >= abs || !this.j) {
                    z = false;
                    z2 = false;
                } else {
                    boolean z3 = ((xVelocity > 0.0f ? 1 : (xVelocity == 0.0f ? 0 : -1)) < 0) == ((rawX2 > 0.0f ? 1 : (rawX2 == 0.0f ? 0 : -1)) < 0);
                    if (this.m.getXVelocity() <= 0.0f) {
                        z2 = false;
                    }
                    z2 = z3;
                    z = z2;
                }
                if (z2) {
                    this.e.animate().translationX((float) (z ? this.g : -this.g)).alpha(0.0f).setDuration(50).setListener(new AnimatorListenerAdapter() {
                        /* class com.amap.api.maps.SwipeDismissTouchListener.AnonymousClass1 */

                        public void onAnimationEnd(Animator animator) {
                            SwipeDismissTouchListener.this.a();
                        }
                    });
                } else if (this.j) {
                    this.e.animate().translationX(0.0f).alpha(1.0f).setDuration(this.d).setListener(null);
                }
                this.m.recycle();
                this.m = null;
                this.n = 0.0f;
                this.h = 0.0f;
                this.i = 0.0f;
                this.j = false;
            }
            return false;
        }
        this.h = motionEvent.getRawX();
        this.i = motionEvent.getRawY();
        if (this.f.canDismiss(this.l)) {
            this.o = false;
            VelocityTracker obtain2 = VelocityTracker.obtain();
            this.m = obtain2;
            obtain2.addMovement(motionEvent);
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a() {
        this.f.onDismiss(this.e, this.l);
        final ViewGroup.LayoutParams layoutParams = this.e.getLayoutParams();
        final int height = this.e.getHeight();
        ValueAnimator duration = ValueAnimator.ofInt(height, 1).setDuration(this.d);
        duration.addListener(new AnimatorListenerAdapter() {
            /* class com.amap.api.maps.SwipeDismissTouchListener.AnonymousClass2 */

            public void onAnimationEnd(Animator animator) {
                SwipeDismissTouchListener.this.e.setAlpha(0.0f);
                SwipeDismissTouchListener.this.e.setTranslationX(0.0f);
                layoutParams.height = height;
                SwipeDismissTouchListener.this.e.setLayoutParams(layoutParams);
            }
        });
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.amap.api.maps.SwipeDismissTouchListener.AnonymousClass3 */

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SwipeDismissTouchListener.this.e.setLayoutParams(layoutParams);
            }
        });
        duration.start();
    }
}
