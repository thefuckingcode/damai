package tb;

import android.graphics.Bitmap;
import com.alibaba.pictures.moimage.IBitmapTransform;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.bitmap.BitmapProcessor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class vb0 implements BitmapProcessor {
    private static transient /* synthetic */ IpChange $ipChange;
    private final IBitmapTransform a;

    public vb0(@NotNull IBitmapTransform iBitmapTransform) {
        k21.i(iBitmapTransform, "transform");
        this.a = iBitmapTransform;
    }

    @Override // com.taobao.phenix.bitmap.BitmapProcessor
    @NotNull
    public String getId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1087481292")) {
            return "com.alibaba.pictures.phenix.DownloaderBitmapProcessor";
        }
        return (String) ipChange.ipc$dispatch("1087481292", new Object[]{this});
    }

    @Override // com.taobao.phenix.bitmap.BitmapProcessor
    @NotNull
    public Bitmap process(@NotNull String str, @NotNull BitmapProcessor.BitmapSupplier bitmapSupplier, @NotNull Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1113784773")) {
            return (Bitmap) ipChange.ipc$dispatch("-1113784773", new Object[]{this, str, bitmapSupplier, bitmap});
        }
        k21.i(str, "s");
        k21.i(bitmapSupplier, "bitmapSupplier");
        k21.i(bitmap, "toTransform");
        Bitmap transform = this.a.transform(bitmap);
        return transform != null ? transform : bitmap;
    }
}
