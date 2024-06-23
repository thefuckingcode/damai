package tb;

import cn.damai.search.v2.fragment.SearchBaseFragment;
import com.youku.arch.v3.io.IResponse;
import kotlin.jvm.functions.Function0;

/* compiled from: Taobao */
public final /* synthetic */ class w52 implements Function0 {
    public final /* synthetic */ SearchBaseFragment.SearchPageLoader a;
    public final /* synthetic */ IResponse b;
    public final /* synthetic */ int c;

    public /* synthetic */ w52(SearchBaseFragment.SearchPageLoader searchPageLoader, IResponse iResponse, int i) {
        this.a = searchPageLoader;
        this.b = iResponse;
        this.c = i;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return this.a.lambda$handleLoadFinish$1(this.b, this.c);
    }
}
