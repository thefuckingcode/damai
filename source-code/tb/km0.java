package tb;

import io.flutter.embedding.android.FlutterSurfaceView;
import io.flutter.embedding.android.FlutterView;

/* compiled from: Taobao */
public final /* synthetic */ class km0 implements Runnable {
    public final /* synthetic */ FlutterView a;
    public final /* synthetic */ FlutterSurfaceView b;

    public /* synthetic */ km0(FlutterView flutterView, FlutterSurfaceView flutterSurfaceView) {
        this.a = flutterView;
        this.b = flutterSurfaceView;
    }

    public final void run() {
        this.a.lambda$removePromotedSurfaceView$3(this.b);
    }
}
