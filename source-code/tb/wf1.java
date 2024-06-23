package tb;

import android.view.View;
import cn.damai.commonbusiness.wannasee.adapter.MultiAdapter;
import kotlin.jvm.functions.Function4;

/* compiled from: Taobao */
public final /* synthetic */ class wf1 implements Function4 {
    public final /* synthetic */ MultiAdapter a;

    public /* synthetic */ wf1(MultiAdapter multiAdapter) {
        this.a = multiAdapter;
    }

    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return this.a.h((Integer) obj, obj2, (Integer) obj3, (View) obj4);
    }
}
