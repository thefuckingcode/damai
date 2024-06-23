package tb;

import android.view.View;
import androidx.constraintlayout.motion.widget.ViewTransition;

/* compiled from: Taobao */
public final /* synthetic */ class iw2 implements Runnable {
    public final /* synthetic */ ViewTransition a;
    public final /* synthetic */ View[] b;

    public /* synthetic */ iw2(ViewTransition viewTransition, View[] viewArr) {
        this.a = viewTransition;
        this.b = viewArr;
    }

    public final void run() {
        this.a.lambda$applyTransition$0(this.b);
    }
}
