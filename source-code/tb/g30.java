package tb;

import android.view.View;
import cn.damai.projectfiltercopy.adapter.DaysAdapter;

/* compiled from: Taobao */
public final /* synthetic */ class g30 implements View.OnClickListener {
    public final /* synthetic */ DaysAdapter.DayVh a;
    public final /* synthetic */ DaysAdapter b;

    public /* synthetic */ g30(DaysAdapter.DayVh dayVh, DaysAdapter daysAdapter) {
        this.a = dayVh;
        this.b = daysAdapter;
    }

    public final void onClick(View view) {
        DaysAdapter.DayVh.b(this.a, this.b, view);
    }
}
