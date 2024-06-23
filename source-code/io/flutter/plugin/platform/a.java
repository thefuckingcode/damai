package io.flutter.plugin.platform;

import android.view.View;
import io.flutter.plugin.platform.PlatformViewsController;

/* compiled from: Taobao */
public final /* synthetic */ class a implements View.OnFocusChangeListener {
    public final /* synthetic */ PlatformViewsController.AnonymousClass1 a;
    public final /* synthetic */ int b;

    public /* synthetic */ a(PlatformViewsController.AnonymousClass1 r1, int i) {
        this.a = r1;
        this.b = i;
    }

    public final void onFocusChange(View view, boolean z) {
        this.a.lambda$createForTextureLayer$0(this.b, view, z);
    }
}
