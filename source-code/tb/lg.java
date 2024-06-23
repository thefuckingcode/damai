package tb;

import android.graphics.Bitmap;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.bitmap.BitmapProcessor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class lg implements BitmapProcessor {
    private static transient /* synthetic */ IpChange $ipChange;
    private final int a;
    private final int b;

    public lg(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    @Override // com.taobao.phenix.bitmap.BitmapProcessor
    @NotNull
    public String getId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "43192619")) {
            return "com.alibaba.pictures.phenix.CenterCropProcessor";
        }
        return (String) ipChange.ipc$dispatch("43192619", new Object[]{this});
    }

    @Override // com.taobao.phenix.bitmap.BitmapProcessor
    @NotNull
    public Bitmap process(@NotNull String str, @NotNull BitmapProcessor.BitmapSupplier bitmapSupplier, @NotNull Bitmap bitmap) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1228044604")) {
            return (Bitmap) ipChange.ipc$dispatch("1228044604", new Object[]{this, str, bitmapSupplier, bitmap});
        }
        k21.i(str, "s");
        k21.i(bitmapSupplier, "bitmapSupplier");
        k21.i(bitmap, "toTransform");
        int i2 = this.b;
        return (i2 <= 0 || (i = this.a) <= 0) ? bitmap : te1.INSTANCE.c(bitmapSupplier, bitmap, i, i2);
    }
}
