package cn.damai.commonbusiness.wannasee.view;

import android.view.View;
import cn.damai.commonbusiness.wannasee.bean.RecommendProjects;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import tb.ur2;

/* compiled from: Taobao */
public final class WantSeeRecommendView$bindRecommend$1$1 extends Lambda implements Function4<Integer, Object, Integer, View, ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ RecommendProjects $recommendMo;
    final /* synthetic */ WantSeeRecommendView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WantSeeRecommendView$bindRecommend$1$1(WantSeeRecommendView wantSeeRecommendView, RecommendProjects recommendProjects) {
        super(4);
        this.this$0 = wantSeeRecommendView;
        this.$recommendMo = recommendProjects;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ ur2 invoke(Integer num, Object obj, Integer num2, View view) {
        invoke(num.intValue(), obj, num2.intValue(), view);
        return ur2.INSTANCE;
    }

    public final void invoke(int i, @Nullable Object obj, int i2, @Nullable View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1164131042")) {
            ipChange.ipc$dispatch("-1164131042", new Object[]{this, Integer.valueOf(i), obj, Integer.valueOf(i2), view});
            return;
        }
        Function4<Integer, Object, Integer, View, ur2> onEventListener = this.this$0.getOnEventListener();
        if (onEventListener != null) {
            onEventListener.invoke(Integer.valueOf(i), this.$recommendMo, Integer.valueOf(i2), view);
        }
    }
}
