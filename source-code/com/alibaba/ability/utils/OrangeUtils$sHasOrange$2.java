package com.alibaba.ability.utils;

import com.taobao.orange.OrangeConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()Z", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* compiled from: Taobao */
final class OrangeUtils$sHasOrange$2 extends Lambda implements Function0<Boolean> {
    public static final OrangeUtils$sHasOrange$2 INSTANCE = new OrangeUtils$sHasOrange$2();

    OrangeUtils$sHasOrange$2() {
        super(0);
    }

    /* Return type fixed from 'boolean' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() {
        try {
            OrangeConfig.getInstance();
            return true;
        } catch (NoClassDefFoundError unused) {
            return false;
        }
    }
}
