package com.alibaba.ability.hub;

import com.alibaba.ability.callback.IOnCallbackListener;
import com.alibaba.ability.env.IAbilityContext;
import java.util.Map;
import kotlin.Metadata;
import tb.je0;
import tb.lf0;
import tb.r0;
import tb.ti0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ltb/ur2;", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* compiled from: Taobao */
final class AbilityHubAdapter$asyncCall$1 implements Runnable {
    final /* synthetic */ String $api;
    final /* synthetic */ IOnCallbackListener $callback;
    final /* synthetic */ IAbilityContext $context;
    final /* synthetic */ String $name;
    final /* synthetic */ Map $params;
    final /* synthetic */ r0 this$0;

    AbilityHubAdapter$asyncCall$1(r0 r0Var, String str, String str2, IAbilityContext iAbilityContext, Map map, IOnCallbackListener iOnCallbackListener) {
        this.this$0 = r0Var;
        this.$name = str;
        this.$api = str2;
        this.$context = iAbilityContext;
        this.$params = map;
        this.$callback = iOnCallbackListener;
    }

    public final void run() {
        lf0 a = this.this$0.a(this.$name, this.$api, this.$context, this.$params, this.$callback);
        if (a == null) {
            return;
        }
        if (a instanceof je0) {
            this.$callback.onErrorCallback((je0) a);
        } else if (a instanceof ti0) {
            this.$callback.onCallback((ti0) a);
        }
    }
}
