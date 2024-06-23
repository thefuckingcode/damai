package tb;

import cn.damai.search.v2.SearchActivity;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* compiled from: Taobao */
public final /* synthetic */ class u52 implements Function0 {
    public final /* synthetic */ SearchActivity a;
    public final /* synthetic */ List b;

    public /* synthetic */ u52(SearchActivity searchActivity, List list) {
        this.a = searchActivity;
        this.b = list;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return this.a.lambda$onTabDataLoaded$0(this.b);
    }
}
