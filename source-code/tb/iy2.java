package tb;

import android.view.View;
import cn.damai.commonbusiness.wannasee.bean.RecommendProjects;
import cn.damai.commonbusiness.wannasee.view.WantSeeRecommendView;

/* compiled from: Taobao */
public final /* synthetic */ class iy2 implements View.OnClickListener {
    public final /* synthetic */ WantSeeRecommendView a;
    public final /* synthetic */ RecommendProjects b;

    public /* synthetic */ iy2(WantSeeRecommendView wantSeeRecommendView, RecommendProjects recommendProjects) {
        this.a = wantSeeRecommendView;
        this.b = recommendProjects;
    }

    public final void onClick(View view) {
        WantSeeRecommendView.m17bindData$lambda0(this.a, this.b, view);
    }
}
