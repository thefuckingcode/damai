package tb;

import android.graphics.Bitmap;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.bitmap.BitmapProcessor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class vi0 implements BitmapProcessor {
    private static transient /* synthetic */ IpChange $ipChange;
    private final int a;
    private final int b;

    public vi0(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    @Override // com.taobao.phenix.bitmap.BitmapProcessor
    @NotNull
    public String getId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-720311314")) {
            return "com.alibaba.pictures.phenix.FitCenterProcessor";
        }
        return (String) ipChange.ipc$dispatch("-720311314", new Object[]{this});
    }

    @Override // com.taobao.phenix.bitmap.BitmapProcessor
    @NotNull
    public Bitmap process(@NotNull String str, @NotNull BitmapProcessor.BitmapSupplier bitmapSupplier, @NotNull Bitmap bitmap) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "872437593")) {
            return (Bitmap) ipChange.ipc$dispatch("872437593", new Object[]{this, str, bitmapSupplier, bitmap});
        }
        k21.i(str, "s");
        k21.i(bitmapSupplier, "bitmapSupplier");
        k21.i(bitmap, "toTransform");
        int i2 = this.b;
        return (i2 <= 0 || (i = this.a) <= 0) ? bitmap : te1.INSTANCE.f(bitmapSupplier, bitmap, i, i2);
    }
}
