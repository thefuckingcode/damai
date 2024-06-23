package com.youku.widget;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.baseproject.ui.R$drawable;

/* compiled from: Taobao */
public class Loading extends ImageView {
    private AnimationDrawable frameAnim;

    public Loading(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
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

    public void startAnimation() {
        post(new Runnable() {
            /* class com.youku.widget.Loading.AnonymousClass1 */

            public void run() {
                if (Loading.this.frameAnim != null && !Loading.this.frameAnim.isRunning()) {
                    Loading.this.frameAnim.start();
                }
            }
        });
    }

    public void stopAnimation() {
        post(new Runnable() {
            /* class com.youku.widget.Loading.AnonymousClass2 */

            public void run() {
                if (Loading.this.frameAnim != null && Loading.this.frameAnim.isRunning()) {
                    Loading.this.frameAnim.stop();
                }
            }
        });
    }

    public Loading(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackgroundResource(R$drawable.youku_loading_anim);
        this.frameAnim = (AnimationDrawable) getBackground();
        startAnimation();
    }

    public Loading(Context context) {
        super(context);
    }
}
