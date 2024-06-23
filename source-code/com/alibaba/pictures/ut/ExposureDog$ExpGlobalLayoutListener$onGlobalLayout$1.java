package com.alibaba.pictures.ut;

import android.os.SystemClock;
import android.view.ViewTreeObserver;
import com.alibaba.pictures.ut.ExposureDog;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.Metadata;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ltb/ur2;", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class ExposureDog$ExpGlobalLayoutListener$onGlobalLayout$1 implements Runnable {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ ExposureDog.ExpGlobalLayoutListener this$0;

    ExposureDog$ExpGlobalLayoutListener$onGlobalLayout$1(ExposureDog.ExpGlobalLayoutListener expGlobalLayoutListener) {
        this.this$0 = expGlobalLayoutListener;
    }

    public final void run() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1455625637")) {
            ipChange.ipc$dispatch("1455625637", new Object[]{this});
            return;
        }
        if (this.this$0.a().a() == 0 && DogCat.INSTANCE.t(this.this$0.c())) {
            ViewTreeObserver viewTreeObserver = this.this$0.c().getViewTreeObserver();
            k21.h(viewTreeObserver, "view.viewTreeObserver");
            if (viewTreeObserver.isAlive()) {
                this.this$0.a().b(SystemClock.elapsedRealtime());
                this.this$0.c().getViewTreeObserver().removeOnGlobalLayoutListener(this.this$0);
                this.this$0.c().removeCallbacks(this.this$0.b());
                return;
            }
        }
        this.this$0.c().postDelayed(this.this$0.b(), 500);
    }
}
