package tb;

import android.graphics.Bitmap;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.bitmap.BitmapProcessor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class xi0 implements BitmapProcessor {
    private static transient /* synthetic */ IpChange $ipChange;
    private final int a;
    private final int b;

    public xi0(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    @Override // com.taobao.phenix.bitmap.BitmapProcessor
    @NotNull
    public String getId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2018699525")) {
            return "com.alibaba.pictures.phenix.CenterCropProcessor";
        }
        return (String) ipChange.ipc$dispatch("-2018699525", new Object[]{this});
    }

    @Override // com.taobao.phenix.bitmap.BitmapProcessor
    @NotNull
    public Bitmap process(@NotNull String str, @NotNull BitmapProcessor.BitmapSupplier bitmapSupplier, @NotNull Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-507107988")) {
            return (Bitmap) ipChange.ipc$dispatch("-507107988", new Object[]{this, str, bitmapSupplier, bitmap});
        }
        k21.i(str, "s");
        k21.i(bitmapSupplier, "bitmapSupplier");
        k21.i(bitmap, "toTransform");
        int i = this.a;
        if (i <= 0) {
            i = bitmap.getWidth();
        }
        Bitmap h = te1.INSTANCE.h(bitmapSupplier, bitmap, i, this.b);
        return h != null ? h : bitmap;
    }
}
