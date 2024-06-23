package tb;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.android.abilitykit.ability.pop.render.util.IAKGestureAnimation;

/* compiled from: Taobao */
public class u implements IAKGestureAnimation {
    private int a;
    private int b;
    @Nullable
    private Animator c;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a extends AnimatorListenerAdapter {
        final /* synthetic */ ObjectAnimator a;
        final /* synthetic */ Runnable b;

        a(ObjectAnimator objectAnimator, Runnable runnable) {
            this.a = objectAnimator;
            this.b = runnable;
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (u.this.c == this.a) {
                u.this.c();
            }
            this.b.run();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void c() {
        this.c = null;
    }

    private void d(@NonNull View view, float f, float f2, @NonNull Runnable runnable) {
        cancelAnimator();
        float translationY = view.getTranslationY();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", translationY, f2);
        ofFloat.setDuration(Math.min(300L, Math.max(50L, (long) ((Math.abs(translationY - f2) / Math.min(8000.0f, Math.max(200.0f, f))) * 1000.0f))));
        ofFloat.addListener(new a(ofFloat, runnable));
        ofFloat.setInterpolator(new LinearInterpolator());
        this.c = ofFloat;
        ofFloat.start();
    }

    @Override // com.taobao.android.abilitykit.ability.pop.render.util.IAKGestureAnimation
    public void cancelAnimator() {
        if (this.c != null && isAnimating()) {
            this.c.cancel();
        }
        c();
    }

    @Override // com.taobao.android.abilitykit.ability.pop.render.util.IAKGestureAnimation
    public void close(@NonNull View view, float f, @NonNull Runnable runnable) {
        d(view, f, (float) this.a, runnable);
    }

    @Override // com.taobao.android.abilitykit.ability.pop.render.util.IAKGestureAnimation
    public void collapse(@NonNull View view, float f, @NonNull Runnable runnable) {
        d(view, f, 0.0f, runnable);
    }

    @Override // com.taobao.android.abilitykit.ability.pop.render.util.IAKGestureAnimation
    public void expand(@NonNull View view, float f, @NonNull Runnable runnable) {
        d(view, f, (float) (this.a - this.b), runnable);
    }

    @Override // com.taobao.android.abilitykit.ability.pop.render.util.IAKGestureAnimation
    public boolean isAnimating() {
        Animator animator = this.c;
        return animator != null && animator.isStarted();
    }

    @Override // com.taobao.android.abilitykit.ability.pop.render.util.IAKGestureAnimation
    public void updateLimitSize(int i, int i2) {
        this.a = i;
        this.b = i2;
    }
}
