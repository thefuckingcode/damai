package tb;

import com.alibaba.fastjson.JSONObject;
import com.taobao.android.abilitykit.AKIAbilityCallback;
import java.lang.ref.SoftReference;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin.collections.x;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class u0 {
    public static final u0 INSTANCE = new u0();
    private static SoftReference<h> a;

    private u0() {
    }

    @JvmStatic
    @Nullable
    public static final l<?> a(@NotNull String str, @NotNull JSONObject jSONObject, @Nullable q qVar, @Nullable AKIAbilityCallback aKIAbilityCallback, boolean z) {
        h hVar;
        k21.j(str, "type");
        k21.j(jSONObject, "params");
        if (qVar == null || (hVar = qVar.a()) == null) {
            hVar = c();
        }
        Map map = x.m(do2.a("type", str), do2.a("params", jSONObject), do2.a("isMainThread", Boolean.valueOf(z)));
        if (map != null) {
            return hVar.a(new JSONObject(map), qVar, aKIAbilityCallback);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
    }

    @JvmStatic
    @Nullable
    public static /* bridge */ /* synthetic */ l b(String str, JSONObject jSONObject, q qVar, AKIAbilityCallback aKIAbilityCallback, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            qVar = null;
        }
        if ((i & 8) != 0) {
            aKIAbilityCallback = null;
        }
        if ((i & 16) != 0) {
            z = true;
        }
        return a(str, jSONObject, qVar, aKIAbilityCallback, z);
    }

    @JvmStatic
    private static final h c() {
        h hVar;
        SoftReference<h> softReference = a;
        if (softReference != null && (hVar = softReference.get()) != null) {
            return hVar;
        }
        h hVar2 = new h(new q0("AbilityKit", "AbilityKit"), null);
        a = new SoftReference<>(hVar2);
        return hVar2;
    }
}
