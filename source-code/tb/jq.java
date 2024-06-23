package tb;

import android.view.View;
import cn.damai.issue.view.DMEvaluateSuccessHeadView;

/* compiled from: Taobao */
public final /* synthetic */ class jq implements View.OnClickListener {
    public final /* synthetic */ DMEvaluateSuccessHeadView a;
    public final /* synthetic */ String b;

    public /* synthetic */ jq(DMEvaluateSuccessHeadView dMEvaluateSuccessHeadView, String str) {
        this.a = dMEvaluateSuccessHeadView;
        this.b = str;
    }

    public final void onClick(View view) {
        DMEvaluateSuccessHeadView.m53setData$lambda3$lambda2(this.a, this.b, view);
    }
}
