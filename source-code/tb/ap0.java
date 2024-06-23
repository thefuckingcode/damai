package tb;

import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.template.GXIExpression;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class ap0 implements GXRegisterCenter.GXIExtensionExpression {
    @Override // com.alibaba.gaiax.GXRegisterCenter.GXIExtensionExpression
    @NotNull
    public GXIExpression create(@Nullable String str, @NotNull Object obj) {
        k21.i(obj, "value");
        return new vn0(obj);
    }

    @Override // com.alibaba.gaiax.GXRegisterCenter.GXIExtensionExpression
    public boolean isTrue(@Nullable String str, @Nullable Object obj) {
        return k21.d(obj, Boolean.TRUE);
    }
}
