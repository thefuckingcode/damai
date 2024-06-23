package tb;

import io.flutter.embedding.android.FlutterView;

/* compiled from: Taobao */
public final /* synthetic */ class nm0 implements Runnable {
    public final /* synthetic */ FlutterView a;
    public final /* synthetic */ boolean b;

    public /* synthetic */ nm0(FlutterView flutterView, boolean z) {
        this.a = flutterView;
        this.b = z;
    }

    public final void run() {
        this.a.lambda$fallbackRenderSurface$1(this.b);
    }
}
