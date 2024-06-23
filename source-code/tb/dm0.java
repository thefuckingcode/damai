package tb;

import android.media.ImageReader;
import io.flutter.embedding.android.FlutterImageView;

/* compiled from: Taobao */
public final /* synthetic */ class dm0 implements Runnable {
    public final /* synthetic */ FlutterImageView a;
    public final /* synthetic */ ImageReader b;

    public /* synthetic */ dm0(FlutterImageView flutterImageView, ImageReader imageReader) {
        this.a = flutterImageView;
        this.b = imageReader;
    }

    public final void run() {
        this.a.lambda$onImageAvailable$3(this.b);
    }
}
