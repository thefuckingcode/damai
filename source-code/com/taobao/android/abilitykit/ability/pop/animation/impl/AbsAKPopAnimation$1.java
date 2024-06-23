package com.taobao.android.abilitykit.ability.pop.animation.impl;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.taobao.android.abilitykit.ability.pop.animation.IAKPopAnimationCallback;

/* compiled from: Taobao */
class AbsAKPopAnimation$1 implements Runnable {
    final /* synthetic */ a this$0;
    final /* synthetic */ IAKPopAnimationCallback val$callback;
    final /* synthetic */ View val$targetView;

    /* compiled from: Taobao */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            IAKPopAnimationCallback iAKPopAnimationCallback = AbsAKPopAnimation$1.this.val$callback;
            if (iAKPopAnimationCallback != null) {
                iAKPopAnimationCallback.onAnimationFinished();
            }
        }

        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            AbsAKPopAnimation$1.this.val$targetView.setVisibility(0);
        }
    }

    AbsAKPopAnimation$1(a aVar, View view, IAKPopAnimationCallback iAKPopAnimationCallback) {
        this.val$targetView = view;
        this.val$callback = iAKPopAnimationCallback;
    }

    public void run() {
        a aVar = this.this$0;
        a.b(aVar, a.c(aVar, this.val$targetView));
        a.a(this.this$0).removeAllListeners();
        a.a(this.this$0).addListener(new a());
        a.a(this.this$0).start();
    }
}
