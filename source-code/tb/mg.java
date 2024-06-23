package tb;

import android.graphics.Bitmap;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.bitmap.BitmapProcessor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class mg implements BitmapProcessor {
    private static transient /* synthetic */ IpChange $ipChange;
    private final int a;
    private final int b;

    public mg(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    @Override // com.taobao.phenix.bitmap.BitmapProcessor
    @NotNull
    public String getId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "523349247")) {
            return "com.alibaba.pictures.phenix.CenterInsideProcessor";
        }
        return (String) ipChange.ipc$dispatch("523349247", new Object[]{this});
    }

    @Override // com.taobao.phenix.bitmap.BitmapProcessor
    @NotNull
    public Bitmap process(@NotNull String str, @NotNull BitmapProcessor.BitmapSupplier bitmapSupplier, @NotNull Bitmap bitmap) {
        int i;
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-245783064")) {
            return (Bitmap) ipChange.ipc$dispatch("-245783064", new Object[]{this, str, bitmapSupplier, bitmap});
        }
        k21.i(str, "s");
        k21.i(bitmapSupplier, "bitmapSupplier");
        k21.i(bitmap, "toTransform");
        int i3 = this.a;
        if (i3 <= 0 || (i2 = this.b) > 0) {
            return (i3 <= 0 || (i = this.b) <= 0) ? bitmap : te1.INSTANCE.d(bitmapSupplier, bitmap, i3, i);
        }
        Bitmap h = te1.INSTANCE.h(bitmapSupplier, bitmap, i3, i2);
        return h != null ? h : bitmap;
    }
}
