package com.google.vr.cardboard;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import tb.dr2;

/* compiled from: Taobao */
public class TransitionView extends FrameLayout implements View.OnTouchListener {
    public static final int ALREADY_LANDSCAPE_LEFT_TRANSITION_DELAY_MS = 2000;
    private static final int LANDSCAPE_TOLERANCE_DEGREES = 5;
    private static final int PORTRAIT_TOLERANCE_DEGREES = 45;
    public static final int TRANSITION_ANIMATION_DURATION_MS = 500;
    public static final int TRANSITION_BACKGROUND_COLOR = -12232092;
    private static final int VIEW_CORRECTION_ROTATION_DEGREES = 90;
    private ImageButton backButton;
    private Runnable backButtonListener;
    private int orientation = -1;
    private OrientationEventListener orientationEventListener;
    private boolean rotationChecked;
    private Runnable transitionListener;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            dr2.b(TransitionView.this.getContext());
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View view) {
            TransitionView.this.fadeOutAndRemove(false);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class c extends OrientationEventListener {
        c(Context context) {
            super(context);
        }

        public void onOrientationChanged(int i) {
            TransitionView.this.orientation = i;
            if (!TransitionView.this.rotationChecked) {
                TransitionView.this.rotateViewIfNeeded();
            } else if (TransitionView.isLandscapeLeft(i)) {
                TransitionView.this.fadeOutAndRemove(false);
            } else {
                TransitionView.isLandscapeRight(i);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class d implements Animation.AnimationListener {
        d() {
        }

        public void onAnimationEnd(Animation animation) {
            TransitionView.this.setVisibility(8);
            ((ViewGroup) TransitionView.this.getParent()).removeView(TransitionView.this);
            if (TransitionView.this.transitionListener != null) {
                TransitionView.this.transitionListener.run();
            }
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class e implements View.OnClickListener {
        e() {
        }

        public void onClick(View view) {
            TransitionView.this.backButtonListener.run();
        }
    }

    public TransitionView(Context context) {
        super(context);
        setOnTouchListener(this);
        setBackground(new ColorDrawable(TRANSITION_BACKGROUND_COLOR));
        inflateContentView(R$layout.transition_view);
        super.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void fadeOutAndRemove(boolean z) {
        stopOrientationMonitor();
        Animation animation = getAnimation();
        if (animation != null) {
            if (!z && animation.getStartOffset() != 0) {
                animation.setAnimationListener(null);
                clearAnimation();
            } else {
                return;
            }
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setInterpolator(new AccelerateInterpolator());
        alphaAnimation.setRepeatCount(0);
        alphaAnimation.setDuration(500);
        if (z) {
            alphaAnimation.setStartOffset(2000);
        }
        alphaAnimation.setAnimationListener(new d());
        startAnimation(alphaAnimation);
    }

    private void inflateContentView(int i) {
        removeAllViews();
        LayoutInflater.from(getContext()).inflate(i, (ViewGroup) this, true);
        findViewById(R$id.transition_switch_action).setOnClickListener(new a());
        ((ImageView) findViewById(R$id.transition_icon)).setOnClickListener(new b());
        updateBackButtonVisibility();
        if (getResources().getConfiguration().orientation == 2) {
            findViewById(R$id.transition_bottom_frame).setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public static boolean isLandscapeLeft(int i) {
        return Math.abs(i + -270) < 5;
    }

    /* access modifiers changed from: private */
    public static boolean isLandscapeRight(int i) {
        return Math.abs(i + -90) < 5;
    }

    private static boolean isPortrait(int i) {
        return Math.abs(i + AMapEngineUtils.MIN_LONGITUDE_DEGREE) > 135;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void rotateViewIfNeeded() {
        if (getWidth() > 0 && getHeight() > 0 && this.orientation != -1 && this.orientationEventListener != null && !this.rotationChecked) {
            boolean z = getWidth() < getHeight();
            boolean isPortrait = isPortrait(this.orientation);
            if (z != isPortrait) {
                View findViewById = findViewById(R$id.transition_frame);
                int width = findViewById.getWidth();
                int height = findViewById.getHeight();
                if (Build.VERSION.SDK_INT >= 17 && getLayoutDirection() == 1) {
                    findViewById.setPivotX(((float) height) - findViewById.getPivotX());
                    findViewById.setPivotY(((float) width) - findViewById.getPivotY());
                }
                if (z) {
                    findViewById.setRotation(90.0f);
                } else {
                    findViewById.setRotation(-90.0f);
                }
                findViewById.setTranslationX((float) ((width - height) / 2));
                findViewById.setTranslationY((float) ((height - width) / 2));
                ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                layoutParams.height = width;
                layoutParams.width = height;
                findViewById.requestLayout();
            }
            if (!isPortrait) {
                findViewById(R$id.transition_bottom_frame).setVisibility(8);
            } else {
                findViewById(R$id.transition_bottom_frame).setVisibility(0);
            }
            this.rotationChecked = true;
            if (isLandscapeLeft(this.orientation)) {
                fadeOutAndRemove(true);
            }
        }
    }

    private void startOrientationMonitor() {
        if (this.orientationEventListener == null) {
            c cVar = new c(getContext());
            this.orientationEventListener = cVar;
            cVar.enable();
        }
    }

    private void stopOrientationMonitor() {
        OrientationEventListener orientationEventListener2 = this.orientationEventListener;
        if (orientationEventListener2 != null) {
            this.orientation = -1;
            orientationEventListener2.disable();
            this.orientationEventListener = null;
        }
    }

    private void updateBackButtonVisibility() {
        ImageButton imageButton = (ImageButton) ((ViewGroup) findViewById(R$id.transition_frame)).findViewById(R$id.back_button);
        this.backButton = imageButton;
        Runnable runnable = this.backButtonListener;
        if (runnable == null) {
            imageButton.setVisibility(8);
            this.backButton.setTag(null);
            this.backButton.setOnClickListener(null);
            return;
        }
        imageButton.setTag(runnable);
        this.backButton.setVisibility(0);
        this.backButton.setOnClickListener(new e());
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        OrientationEventListener orientationEventListener2 = this.orientationEventListener;
        if (orientationEventListener2 != null) {
            orientationEventListener2.enable();
        }
        rotateViewIfNeeded();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        OrientationEventListener orientationEventListener2 = this.orientationEventListener;
        if (orientationEventListener2 != null) {
            this.orientation = -1;
            orientationEventListener2.disable();
        }
        super.onDetachedFromWindow();
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return true;
    }

    public void setBackButtonListener(Runnable runnable) {
        this.backButtonListener = runnable;
        updateBackButtonVisibility();
    }

    public void setTransitionListener(Runnable runnable) {
        this.transitionListener = runnable;
    }

    public void setViewerName(String str) {
        TextView textView = (TextView) findViewById(R$id.transition_text);
        if (str != null) {
            textView.setText(getContext().getString(R$string.place_your_viewer_into_viewer_format, str));
            return;
        }
        textView.setText(getContext().getString(R$string.place_your_phone_into_cardboard));
    }

    public void setVisibility(int i) {
        int visibility = getVisibility();
        super.setVisibility(i);
        if (visibility == i) {
            return;
        }
        if (i == 0) {
            startOrientationMonitor();
        } else {
            stopOrientationMonitor();
        }
    }
}
