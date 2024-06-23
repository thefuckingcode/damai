package com.alibaba.pictures.dolores.prefetch;

import com.alibaba.pictures.dolores.prefetch.page.PrefetchPageMo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000j\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002`\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Ljava/util/HashMap;", "", "Lcom/alibaba/pictures/dolores/prefetch/page/PrefetchPageMo;", "Lkotlin/collections/HashMap;", "invoke", "()Ljava/util/HashMap;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class PrefetchManager$pageList$2 extends Lambda implements Function0<HashMap<String, PrefetchPageMo>> {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final PrefetchManager$pageList$2 INSTANCE = new PrefetchManager$pageList$2();

    PrefetchManager$pageList$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final HashMap<String, PrefetchPageMo> invoke() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1299922613")) {
            return new HashMap<>();
        }
        return (HashMap) ipChange.ipc$dispatch("-1299922613", new Object[]{this});
    }
}
