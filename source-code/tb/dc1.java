package tb;

import android.content.Context;
import com.alibaba.ability.IAbility;
import com.alibaba.ability.callback.IOnCallbackListener;
import com.alibaba.ability.env.IAbilityContext;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.abilitykit.AKBaseAbility;
import com.taobao.android.abilitykit.AKIAbilityCallback;
import com.taobao.weex.bridge.WXBridgeManager;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.collections.x;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class dc1 extends AKBaseAbility<q> {
    private final IAbility b;
    private final String c;
    private final String d;

    /* compiled from: Taobao */
    public static final class a implements IOnCallbackListener {
        final /* synthetic */ dc1 a;
        final /* synthetic */ AKIAbilityCallback b;

        a(dc1 dc1, AKIAbilityCallback aKIAbilityCallback) {
            this.a = dc1;
            this.b = aKIAbilityCallback;
        }

        @Override // com.alibaba.ability.callback.IOnCallbackListener
        public void onCallback(@NotNull ti0 ti0) {
            k21.j(ti0, "result");
            AKIAbilityCallback aKIAbilityCallback = this.b;
            String b2 = ti0.b();
            Map<String, Object> a2 = ti0.a();
            aKIAbilityCallback.callback(b2, new o(a2 != null ? new JSONObject(a2) : null));
        }

        @Override // com.alibaba.ability.callback.IOnCallbackListener
        public void onErrorCallback(@NotNull je0 je0) {
            k21.j(je0, "ret");
            AKIAbilityCallback aKIAbilityCallback = this.b;
            String b2 = je0.b();
            String c = je0.c();
            JSONObject jSONObject = new JSONObject(2);
            jSONObject.put("code", (Object) b2);
            jSONObject.put("msg", (Object) c);
            aKIAbilityCallback.callback(AKBaseAbility.CALLBACK_FAILURE, new n(jSONObject));
        }

        @Override // com.alibaba.ability.callback.IOnCallbackListener
        public void ongoingCallback(@NotNull mf0 mf0) {
            k21.j(mf0, "result");
            throw null;
        }
    }

    public dc1(@Nullable IAbility iAbility, @Nullable String str, @NotNull String str2) {
        k21.j(str2, "megaApi");
        this.b = iAbility;
        this.c = str;
        this.d = str2;
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.abilitykit.AKBaseAbility
    @NotNull
    public l<?> c(@Nullable r rVar, @NotNull q qVar, @NotNull AKIAbilityCallback aKIAbilityCallback) {
        Map<String, ? extends Object> map;
        lf0 lf0;
        r0 e;
        k21.j(qVar, "akCtx");
        k21.j(aKIAbilityCallback, WXBridgeManager.METHOD_CALLBACK);
        h a2 = qVar.a();
        k21.e(a2, "akCtx.abilityEngine");
        q0 f = a2.f();
        Context c2 = qVar.c();
        if (c2 != null) {
            f.setContextRef(new WeakReference<>(c2));
        }
        p0 p0Var = new p0(f);
        p0Var.setUserContext(qVar);
        JSONObject jSONObject = null;
        y yVar = (y) (!(qVar instanceof y) ? null : qVar);
        IAbilityContext withInvokeView = p0Var.withInvokeView(yVar != null ? yVar.f() : null);
        if (rVar == null || (map = rVar.c()) == null) {
            map = x.i();
        }
        a aVar = new a(this, aKIAbilityCallback);
        if (this.c != null) {
            h a3 = qVar.a();
            if (a3 == null || (e = a3.e()) == null || (lf0 = e.a(this.c, this.d, withInvokeView, map, aVar)) == null) {
                lf0 = new je0("400", "NoEngine", null, 4, null);
            }
        } else {
            IAbility iAbility = this.b;
            if (iAbility == null || (lf0 = iAbility.execute(this.d, withInvokeView, map, new o0(aVar))) == null) {
                lf0 = new je0("400", "NoMegability", null, 4, null);
            }
        }
        Map<String, Object> a4 = lf0.a();
        if (a4 != null) {
            jSONObject = new JSONObject(a4);
        }
        if (lf0 instanceof ti0) {
            return new o(jSONObject);
        }
        if (!(lf0 instanceof je0)) {
            return new m(jSONObject);
        }
        je0 je0 = (je0) lf0;
        String b2 = je0.b();
        String c3 = je0.c();
        JSONObject jSONObject2 = new JSONObject(2);
        jSONObject2.put("code", (Object) b2);
        jSONObject2.put("msg", (Object) c3);
        return new k(new j(10000, jSONObject2.toJSONString()));
    }
}
