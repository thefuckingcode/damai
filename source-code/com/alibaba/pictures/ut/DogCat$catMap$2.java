package com.alibaba.pictures.ut;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/util/HashMap;", "", "Lcom/alibaba/pictures/ut/ClickCat;", "invoke", "()Ljava/util/HashMap;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class DogCat$catMap$2 extends Lambda implements Function0<HashMap<Integer, ClickCat>> {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final DogCat$catMap$2 INSTANCE = new DogCat$catMap$2();

    DogCat$catMap$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final HashMap<Integer, ClickCat> invoke() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-302938289")) {
            return new HashMap<>();
        }
        return (HashMap) ipChange.ipc$dispatch("-302938289", new Object[]{this});
    }
}
