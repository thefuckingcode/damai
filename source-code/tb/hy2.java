package tb;

import android.view.View;
import cn.damai.commonbusiness.wannasee.view.WantSeeRecommendItemView;
import com.alibaba.pictures.bricks.component.project.bean.ProjectItemBean;

/* compiled from: Taobao */
public final /* synthetic */ class hy2 implements View.OnClickListener {
    public final /* synthetic */ ProjectItemBean a;
    public final /* synthetic */ WantSeeRecommendItemView b;
    public final /* synthetic */ int c;

    public /* synthetic */ hy2(ProjectItemBean projectItemBean, WantSeeRecommendItemView wantSeeRecommendItemView, int i) {
        this.a = projectItemBean;
        this.b = wantSeeRecommendItemView;
        this.c = i;
    }

    public final void onClick(View view) {
        WantSeeRecommendItemView.a(this.a, this.b, this.c, view);
    }
}
