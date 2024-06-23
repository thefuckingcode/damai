package tb;

import android.view.View;
import com.alibaba.gaiax.render.view.GXViewExtKt;

/* compiled from: Taobao */
public final /* synthetic */ class cr0 implements Runnable {
    public final /* synthetic */ View a;
    public final /* synthetic */ boolean b;

    public /* synthetic */ cr0(View view, boolean z) {
        this.a = view;
        this.b = z;
    }

    public final void run() {
        GXViewExtKt.w(this.a, this.b);
    }
}
