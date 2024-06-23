package com.google.vr.ndk.base;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;

/* compiled from: Taobao */
class FadeOverlayView extends View {
    static final long AUTO_FADE_DURATION_MILLIS = 350;
    static final int AUTO_FADE_QUICK_START_DELAY_MILLIS = 200;
    static final long AUTO_FADE_START_DELAY_MILLIS = 1000;
    private static final int BACKGROUND_COLOR = -16777216;
    private static final boolean DEBUG = false;
    private static final int MSG_AUTO_FADE = 77337733;
    private static final String TAG = "FadeOverlayView";
    private final boolean autoFadeEnabled;
    private final Handler autoFadeHandler = new Handler(Looper.getMainLooper()) {
        /* class com.google.vr.ndk.base.FadeOverlayView.AnonymousClass2 */

        public void handleMessage(Message message) {
            if (message.what == FadeOverlayView.MSG_AUTO_FADE) {
                FadeOverlayView.this.startFade(1, FadeOverlayView.AUTO_FADE_DURATION_MILLIS);
            } else {
                super.handleMessage(message);
            }
        }
    };
    private long fadeDurationMillis;
    private long fadeStartTimeMillis;
    private int fadeType = 0;
    private final Runnable fadeUpdateRunnable = new Runnable() {
        /* class com.google.vr.ndk.base.FadeOverlayView.AnonymousClass1 */

        public void run() {
            FadeOverlayView.this.updateFade();
        }
    };
    private boolean flushAutoFadeOnVisible;
    private boolean visible;

    public FadeOverlayView(Context context, boolean z) {
        super(context);
        setBackgroundColor(-16777216);
        this.autoFadeEnabled = z;
    }

    private void endFade() {
        int i = this.fadeType;
        if (i != 0) {
            setVisibility(i == 2 ? 0 : 8);
            setAlpha(this.fadeType == 2 ? 1.0f : 0.0f);
            removeCallbacks(this.fadeUpdateRunnable);
            this.fadeType = 0;
            this.flushAutoFadeOnVisible = false;
        }
    }

    private void removeFadeCallbacks() {
        this.autoFadeHandler.removeMessages(MSG_AUTO_FADE);
        removeCallbacks(this.fadeUpdateRunnable);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateFade() {
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.fadeStartTimeMillis;
        float f = ((float) currentAnimationTimeMillis) / ((float) this.fadeDurationMillis);
        if (this.fadeType != 2) {
            f = 1.0f - f;
        }
        setAlpha(Math.min(Math.max(f, 0.0f), 1.0f));
        if (currentAnimationTimeMillis < this.fadeDurationMillis && getVisibility() != 0) {
            setVisibility(0);
        }
        if (currentAnimationTimeMillis < this.fadeDurationMillis) {
            postOnAnimation(this.fadeUpdateRunnable);
        } else {
            endFade();
        }
    }

    public void flushAutoFade() {
        if (this.autoFadeEnabled) {
            if (this.autoFadeHandler.hasMessages(MSG_AUTO_FADE)) {
                this.autoFadeHandler.removeMessages(MSG_AUTO_FADE);
                this.autoFadeHandler.sendEmptyMessageDelayed(MSG_AUTO_FADE, 200);
            } else if (!this.visible) {
                this.flushAutoFadeOnVisible = true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int getFadeType() {
        return this.fadeType;
    }

    /* access modifiers changed from: package-private */
    public boolean isVisible() {
        return this.visible;
    }

    public void onInvisible() {
        if (this.visible) {
            this.visible = false;
            if (isEnabled() && this.autoFadeEnabled) {
                removeFadeCallbacks();
                this.fadeType = 2;
                endFade();
            }
        }
    }

    public void onVisible() {
        if (!this.visible || getAlpha() != 0.0f) {
            this.visible = true;
            if (!isEnabled() || !this.autoFadeEnabled) {
                this.fadeType = 1;
                endFade();
                return;
            }
            this.autoFadeHandler.removeMessages(MSG_AUTO_FADE);
            this.autoFadeHandler.sendEmptyMessageDelayed(MSG_AUTO_FADE, this.flushAutoFadeOnVisible ? 200 : 1000);
        }
    }

    public void setEnabled(boolean z) {
        if (isEnabled() != z) {
            super.setEnabled(z);
            if (!z) {
                removeFadeCallbacks();
                this.fadeType = 1;
                endFade();
            }
        }
    }

    public void startFade(int i, long j) {
        if (!isEnabled()) {
            Log.w(TAG, "Ignoring fade request while disabled.");
        } else if (!this.visible) {
            Log.w(TAG, "Ignoring fade request while invisible.");
        } else {
            removeFadeCallbacks();
            this.fadeType = i;
            this.fadeDurationMillis = j;
            this.fadeStartTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            updateFade();
        }
    }
}
