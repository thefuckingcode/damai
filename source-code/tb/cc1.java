package tb;

import com.taobao.android.abilitykit.AKBaseAbility;
import com.taobao.android.abilitykit.AKIBuilderAbility;
import kotlin.Lazy;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class cc1<DATA> implements AKIBuilderAbility<DATA> {
    static final /* synthetic */ KProperty[] d = {dz1.i(new PropertyReference1Impl(dz1.b(cc1.class), "wrapper", "getWrapper()Lcom/taobao/android/abilitykit/mega/MegaWrapper;"))};
    private final Lazy a;
    private final String b;
    private final String c;

    private final dc1 c() {
        Lazy lazy = this.a;
        KProperty kProperty = d[0];
        return (dc1) lazy.getValue();
    }

    @Override // com.taobao.android.abilitykit.AKIBuilderAbility
    @NotNull
    public AKBaseAbility<?> build(@Nullable DATA data) {
        return c();
    }
}
