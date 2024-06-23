package tb;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class jp0 extends LinearGradient {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public jp0(float f, float f2, float f3, float f4, @NotNull int[] iArr, @Nullable float[] fArr, @NotNull Shader.TileMode tileMode) {
        super(f, f2, f3, f4, iArr, fArr, tileMode);
        k21.i(iArr, "colors");
        k21.i(tileMode, "tile");
    }
}
