package tb;

import android.view.View;
import cn.damai.commonbusiness.wannasee.view.WantSeeRecommendItemView;
import com.alibaba.pictures.bricks.component.project.bean.ProjectItemBean;

/* compiled from: Taobao */
public final /* synthetic */ class gy2 implements View.OnClickListener {
    public final /* synthetic */ WantSeeRecommendItemView a;
    public final /* synthetic */ ProjectItemBean b;
    public final /* synthetic */ int c;

    public /* synthetic */ gy2(WantSeeRecommendItemView wantSeeRecommendItemView, ProjectItemBean projectItemBean, int i) {
        this.a = wantSeeRecommendItemView;
        this.b = projectItemBean;
        this.c = i;
    }

    public final void onClick(View view) {
        WantSeeRecommendItemView.b(this.a, this.b, this.c, view);
    }
}
