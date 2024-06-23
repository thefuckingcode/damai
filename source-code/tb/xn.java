package tb;

import android.view.View;
import cn.damai.issue.view.CorrelationView;

/* compiled from: Taobao */
public final /* synthetic */ class xn implements View.OnClickListener {
    public final /* synthetic */ CorrelationView a;

    public /* synthetic */ xn(CorrelationView correlationView) {
        this.a = correlationView;
    }

    public final void onClick(View view) {
        CorrelationView.a(this.a, view);
    }
}
