package tb;

import android.view.View;
import com.alibaba.pictures.bricks.bean.HomeCalendarBean;
import com.alibaba.pictures.bricks.component.home.calendar.HomeCalendarView;

/* compiled from: Taobao */
public final /* synthetic */ class nv0 implements View.OnClickListener {
    public final /* synthetic */ HomeCalendarView a;
    public final /* synthetic */ HomeCalendarBean b;

    public /* synthetic */ nv0(HomeCalendarView homeCalendarView, HomeCalendarBean homeCalendarBean) {
        this.a = homeCalendarView;
        this.b = homeCalendarBean;
    }

    public final void onClick(View view) {
        HomeCalendarView.a(this.a, this.b, view);
    }
}
