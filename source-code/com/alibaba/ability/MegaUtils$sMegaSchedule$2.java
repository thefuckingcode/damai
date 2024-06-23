package com.alibaba.ability;

import com.alibaba.android.schedule.MegaScheduler;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/alibaba/android/schedule/MegaScheduler;", "invoke", "()Lcom/alibaba/android/schedule/MegaScheduler;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* compiled from: Taobao */
final class MegaUtils$sMegaSchedule$2 extends Lambda implements Function0<MegaScheduler> {
    public static final MegaUtils$sMegaSchedule$2 INSTANCE = new MegaUtils$sMegaSchedule$2();

    MegaUtils$sMegaSchedule$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final MegaScheduler invoke() {
        return new MegaScheduler("MegaKit", 3);
    }
}
