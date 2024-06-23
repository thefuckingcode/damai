package com.youku.gaiax.js.api;

import com.youku.gaiax.js.utils.IdGenerator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0006\n\u0002\u0010\t\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GaiaXBaseModule$_id$2 extends Lambda implements Function0<Long> {
    public static final GaiaXBaseModule$_id$2 INSTANCE = new GaiaXBaseModule$_id$2();

    GaiaXBaseModule$_id$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Long invoke() {
        return Long.valueOf(IdGenerator.INSTANCE.genLongId());
    }
}
