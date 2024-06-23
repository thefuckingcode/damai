package tb;

import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.engine.renderer.FlutterRenderer;

/* compiled from: Taobao */
public final /* synthetic */ class mm0 implements Runnable {
    public final /* synthetic */ FlutterView a;
    public final /* synthetic */ FlutterRenderer b;

    public /* synthetic */ mm0(FlutterView flutterView, FlutterRenderer flutterRenderer) {
        this.a = flutterView;
        this.b = flutterRenderer;
    }

    public final void run() {
        this.a.lambda$promoteRenderSurface$0(this.b);
    }
}
