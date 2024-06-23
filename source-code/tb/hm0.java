package tb;

import android.graphics.ImageDecoder;
import io.flutter.embedding.engine.FlutterJNI;

/* compiled from: Taobao */
public final /* synthetic */ class hm0 implements ImageDecoder.OnHeaderDecodedListener {
    public final /* synthetic */ long a;

    public /* synthetic */ hm0(long j) {
        this.a = j;
    }

    public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        FlutterJNI.lambda$decodeImage$0(this.a, imageDecoder, imageInfo, source);
    }
}
