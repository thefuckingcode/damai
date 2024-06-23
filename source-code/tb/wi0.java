package tb;

import android.graphics.Bitmap;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.bitmap.BitmapProcessor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class wi0 implements BitmapProcessor {
    private static transient /* synthetic */ IpChange $ipChange;
    private final int a;
    private final int b;

    public wi0(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    @Override // com.taobao.phenix.bitmap.BitmapProcessor
    @NotNull
    public String getId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1096426076")) {
            return "com.alibaba.pictures.phenix.FitHeightProcessor";
        }
        return (String) ipChange.ipc$dispatch("1096426076", new Object[]{this});
    }

    @Override // com.taobao.phenix.bitmap.BitmapProcessor
    @NotNull
    public Bitmap process(@NotNull String str, @NotNull BitmapProcessor.BitmapSupplier bitmapSupplier, @NotNull Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "499788715")) {
            return (Bitmap) ipChange.ipc$dispatch("499788715", new Object[]{this, str, bitmapSupplier, bitmap});
        }
        k21.i(str, "s");
        k21.i(bitmapSupplier, "bitmapSupplier");
        k21.i(bitmap, "toTransform");
        int i = this.b;
        if (i <= 0) {
            i = bitmap.getHeight();
        }
        Bitmap g = te1.INSTANCE.g(bitmapSupplier, bitmap, this.a, i);
        return g != null ? g : bitmap;
    }
}
