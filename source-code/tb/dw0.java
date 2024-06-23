package tb;

import android.view.View;
import com.alibaba.pictures.bricks.bean.HomeNoticeBean;
import com.alibaba.pictures.bricks.component.home.notice.HomeNoticeView;

/* compiled from: Taobao */
public final /* synthetic */ class dw0 implements View.OnClickListener {
    public final /* synthetic */ HomeNoticeView a;
    public final /* synthetic */ HomeNoticeBean b;

    public /* synthetic */ dw0(HomeNoticeView homeNoticeView, HomeNoticeBean homeNoticeBean) {
        this.a = homeNoticeView;
        this.b = homeNoticeBean;
    }

    public final void onClick(View view) {
        HomeNoticeView.m131bindView$lambda0(this.a, this.b, view);
    }
}
