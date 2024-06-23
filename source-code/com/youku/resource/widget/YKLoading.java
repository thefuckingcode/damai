package com.youku.resource.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.OnCompositionLoadedListener;
import com.airbnb.lottie.a;
import com.youku.resource.R;

/* compiled from: Taobao */
public class YKLoading extends ImageView {
    private static final int MSG_ANIM = 10010;
    public String TAG = "Loading";
    private AnimationDrawable frameAnim;
    private LottieDrawable lottieDrawable;
    private boolean start = false;
    boolean startImmediately = true;

    public YKLoading(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private AnimationDrawable getAnimationDrawable() {
        if (this.frameAnim == null) {
            if (getBackground() == null) {
                setBackgroundResource(R.drawable.youku_loading_space);
            }
            if (getBackground() instanceof AnimationDrawable) {
                this.frameAnim = (AnimationDrawable) getBackground();
            }
        }
        return this.frameAnim;
    }

    private LottieDrawable getLottieDrawable() {
        if (this.lottieDrawable == null) {
            a.b.a(getContext(), "loading.json", new OnCompositionLoadedListener() {
                /* class com.youku.resource.widget.YKLoading.AnonymousClass1 */

                @Override // com.airbnb.lottie.OnCompositionLoadedListener
                public void onCompositionLoaded(@Nullable a aVar) {
                    if (aVar != null) {
                        YKLoading.this.lottieDrawable = new LottieDrawable();
                        YKLoading.this.lottieDrawable.setComposition(aVar);
                        YKLoading.this.setBackgroundColor(0);
                        YKLoading yKLoading = YKLoading.this;
                        yKLoading.setImageDrawable(yKLoading.lottieDrawable);
                    }
                }
            });
        }
        return this.lottieDrawable;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
        if (isShown()) {
            startAnimation();
        } else {
            stopAnimation();
        }
    }

    /* access modifiers changed from: protected */
    public void start() {
        if (getAnimationDrawable() != null && !getAnimationDrawable().isRunning()) {
            this.start = true;
            getAnimationDrawable().start();
        }
    }

    public void startAnimation() {
        post(new Runnable() {
            /* class com.youku.resource.widget.YKLoading.AnonymousClass2 */

            public void run() {
                YKLoading.this.start();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void stop() {
        AnimationDrawable animationDrawable = this.frameAnim;
        if (animationDrawable != null && animationDrawable.isRunning()) {
            this.start = false;
            this.frameAnim.stop();
        }
    }

    public void stopAnimation() {
        post(new Runnable() {
            /* class com.youku.resource.widget.YKLoading.AnonymousClass3 */

            public void run() {
                YKLoading.this.stop();
            }
        });
    }

    public YKLoading(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.YKLoading);
        if (obtainStyledAttributes != null) {
            this.startImmediately = obtainStyledAttributes.getBoolean(R.styleable.YKLoading_start_anim_immediately, true);
            obtainStyledAttributes.recycle();
        }
        if (this.startImmediately) {
            startAnimation();
        }
    }

    public YKLoading(Context context) {
        super(context);
    }
}
