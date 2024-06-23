package tb;

import android.graphics.Bitmap;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.bitmap.BitmapProcessor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.pe1;

/* compiled from: Taobao */
public final class up1 implements BitmapProcessor {
    private static transient /* synthetic */ IpChange $ipChange;
    private pe1.a a;

    public up1(int i, int i2, @Nullable pe1.a aVar) {
        this.a = aVar;
    }

    @Override // com.taobao.phenix.bitmap.BitmapProcessor
    @NotNull
    public String getId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2061797708")) {
            return "com.alibaba.pictures.phenix.PhenixBorderProcessor";
        }
        return (String) ipChange.ipc$dispatch("-2061797708", new Object[]{this});
    }

    @Override // com.taobao.phenix.bitmap.BitmapProcessor
    @NotNull
    public Bitmap process(@NotNull String str, @NotNull BitmapProcessor.BitmapSupplier bitmapSupplier, @NotNull Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1794062765")) {
            return (Bitmap) ipChange.ipc$dispatch("-1794062765", new Object[]{this, str, bitmapSupplier, bitmap});
        }
        k21.i(str, "s");
        k21.i(bitmapSupplier, "bitmapSupplier");
        k21.i(bitmap, "toTransform");
        pe1.a aVar = this.a;
        if (aVar == null) {
            return bitmap;
        }
        te1 te1 = te1.INSTANCE;
        k21.f(aVar);
        Bitmap b = te1.b(bitmapSupplier, bitmap, aVar);
        return b != null ? b : bitmap;
    }
}
