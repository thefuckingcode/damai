package com.taobao.android.abilitykit;

import com.alibaba.ability.MegaUtils;
import com.alibaba.fastjson.JSONObject;
import com.taobao.analysis.v3.FalcoAbilitySpan;
import tb.j;
import tb.k;
import tb.l;
import tb.m;
import tb.q;
import tb.r;
import tb.r41;
import tb.x6;

/* compiled from: Taobao */
public abstract class AKBaseAbility<T extends q> {
    public static final String CALLBACK_FAILURE = "failure";
    public static final String CALLBACK_SUCCESS = "success";
    private FalcoAbilitySpan a;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements AKIAbilityCallback {
        final /* synthetic */ AKIAbilityCallback a;
        final /* synthetic */ q b;
        final /* synthetic */ r c;

        a(AKBaseAbility aKBaseAbility, AKIAbilityCallback aKIAbilityCallback, q qVar, r rVar) {
            this.a = aKIAbilityCallback;
            this.b = qVar;
            this.c = rVar;
        }

        @Override // com.taobao.android.abilitykit.AKIAbilityCallback
        public void callback(String str, l lVar) {
            AKIAbilityCallback aKIAbilityCallback = this.a;
            if (aKIAbilityCallback != null) {
                aKIAbilityCallback.callback(str, lVar);
            }
            if (lVar instanceof k) {
                x6.a(this.b, this.c, (k) lVar);
            }
        }
    }

    public l a(JSONObject jSONObject, T t, AKIAbilityCallback aKIAbilityCallback) {
        if (jSONObject != null) {
            return b(new r(jSONObject), t, aKIAbilityCallback);
        }
        k kVar = new k(new j(10002, "NULL"), true);
        x6.a(t, null, kVar);
        return kVar;
    }

    public l b(final r rVar, final T t, AKIAbilityCallback aKIAbilityCallback) {
        final a aVar = new a(this, aKIAbilityCallback, t, rVar);
        if (r41.b(rVar != null ? rVar.b() : null, "isMainThread", true)) {
            l c = c(rVar, t, aVar);
            if (c instanceof k) {
                x6.a(t, rVar, (k) c);
            }
            return c;
        }
        MegaUtils.e(new Runnable() {
            /* class com.taobao.android.abilitykit.AKBaseAbility.AnonymousClass2 */

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.taobao.android.abilitykit.AKBaseAbility */
            /* JADX WARN: Multi-variable type inference failed */
            public void run() {
                final l c = AKBaseAbility.this.c(rVar, t, aVar);
                if (c != null && !(c instanceof m)) {
                    MegaUtils.d(new Runnable() {
                        /* class com.taobao.android.abilitykit.AKBaseAbility.AnonymousClass2.AnonymousClass1 */

                        public void run() {
                            aVar.callback("_onResult", c);
                        }
                    }, 0);
                }
            }
        });
        return new m();
    }

    /* access modifiers changed from: protected */
    public abstract l c(r rVar, T t, AKIAbilityCallback aKIAbilityCallback);

    public void d(FalcoAbilitySpan falcoAbilitySpan) {
        this.a = falcoAbilitySpan;
    }

    public boolean e() {
        return true;
    }
}
