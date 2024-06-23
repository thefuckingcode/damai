package tb;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

/* compiled from: Taobao */
public class ks {
    @NonNull
    private List<AnimatorSet> a;
    @Nullable
    private AnimatorSet b;
    private boolean c;
    private boolean d;
    private int e = -1;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        public void onAnimationEnd(Animator animator) {
            ks.this.b();
        }
    }

    public ks(@NonNull List<AnimatorSet> list) {
        this.a = list;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void b() {
        if (!this.d && this.e < this.a.size() - 1) {
            List<AnimatorSet> list = this.a;
            int i = this.e + 1;
            this.e = i;
            AnimatorSet animatorSet = list.get(i);
            this.b = animatorSet;
            if (animatorSet != null) {
                animatorSet.start();
            }
        }
    }

    public void c() {
        if (!this.c) {
            this.c = true;
            for (AnimatorSet animatorSet : this.a) {
                animatorSet.addListener(new a());
            }
            b();
        }
    }

    public void d() {
        AnimatorSet animatorSet;
        this.d = true;
        if (this.c && (animatorSet = this.b) != null) {
            animatorSet.end();
        }
    }
}
