package tb;

import android.view.View;
import io.flutter.plugin.platform.PlatformViewsController;

/* compiled from: Taobao */
public final /* synthetic */ class wq1 implements View.OnFocusChangeListener {
    public final /* synthetic */ PlatformViewsController a;
    public final /* synthetic */ int b;

    public /* synthetic */ wq1(PlatformViewsController platformViewsController, int i) {
        this.a = platformViewsController;
        this.b = i;
    }

    public final void onFocusChange(View view, boolean z) {
        this.a.lambda$initializePlatformViewIfNeeded$0(this.b, view, z);
    }
}
