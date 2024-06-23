package tb;

import android.view.View;
import cn.damai.issue.view.DMEvaluateSuccessHeadView;

/* compiled from: Taobao */
public final /* synthetic */ class kq implements View.OnClickListener {
    public final /* synthetic */ String a;
    public final /* synthetic */ DMEvaluateSuccessHeadView b;
    public final /* synthetic */ String c;

    public /* synthetic */ kq(String str, DMEvaluateSuccessHeadView dMEvaluateSuccessHeadView, String str2) {
        this.a = str;
        this.b = dMEvaluateSuccessHeadView;
        this.c = str2;
    }

    public final void onClick(View view) {
        DMEvaluateSuccessHeadView.m52setData$lambda0(this.a, this.b, this.c, view);
    }
}
