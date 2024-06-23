package com.alibaba.pictures.ut;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a&\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000j\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "invoke", "()Ljava/util/HashMap;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class ExposureDog$params$2 extends Lambda implements Function0<HashMap<String, String>> {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final ExposureDog$params$2 INSTANCE = new ExposureDog$params$2();

    ExposureDog$params$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final HashMap<String, String> invoke() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "863780026")) {
            return new HashMap<>();
        }
        return (HashMap) ipChange.ipc$dispatch("863780026", new Object[]{this});
    }
}
