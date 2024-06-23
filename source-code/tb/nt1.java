package tb;

import android.widget.ImageView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.activity.ProjectCertDetailActivity;

/* compiled from: Taobao */
public final /* synthetic */ class nt1 implements DMImageCreator.DMImageSuccListener {
    public final /* synthetic */ ProjectCertDetailActivity a;
    public final /* synthetic */ int b;
    public final /* synthetic */ ImageView c;

    public /* synthetic */ nt1(ProjectCertDetailActivity projectCertDetailActivity, int i, ImageView imageView) {
        this.a = projectCertDetailActivity;
        this.b = i;
        this.c = imageView;
    }

    @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
    public final void onSuccess(DMImageCreator.e eVar) {
        ProjectCertDetailActivity.a(this.a, this.b, this.c, eVar);
    }
}
