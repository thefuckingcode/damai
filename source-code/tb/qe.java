package tb;

import android.content.Context;
import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.calendar.CalendarPopView;
import cn.damai.commonbusiness.calendar.bean.CalendarBean;
import cn.damai.commonbusiness.calendar.bean.CalendarYearBean;
import cn.damai.projectfilter.bean.FilterData;
import cn.damai.projectfilter.bean.Type;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.common.Constants;
import java.util.List;

/* compiled from: Taobao */
public class qe extends cn.damai.projectfilter.floatview.a<CalendarBean> implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private CalendarPopView d;
    long e;

    /* compiled from: Taobao */
    public class a implements CalendarPopView.OnDateClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.commonbusiness.calendar.CalendarPopView.OnDateClickListener
        public void onClose() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1805982003")) {
                ipChange.ipc$dispatch("-1805982003", new Object[]{this});
            }
        }

        @Override // cn.damai.commonbusiness.calendar.CalendarPopView.OnDateClickListener
        public void onDateClick(int i, String str, String str2, int i2, String str3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-786159583")) {
                ipChange.ipc$dispatch("-786159583", new Object[]{this, Integer.valueOf(i), str, str2, Integer.valueOf(i2), str3});
                return;
            }
            Log.d(Constants.Name.FILTER, "onDateClick  status " + i + ", start: " + str + ", end : " + str2 + " , name : " + str3);
            FilterData filterData = new FilterData();
            CalendarBean calendarBean = new CalendarBean();
            filterData.calendarBean = calendarBean;
            calendarBean.dateType = String.valueOf(i);
            CalendarBean calendarBean2 = filterData.calendarBean;
            calendarBean2.startDate = str;
            calendarBean2.endDate = str2;
            calendarBean2.name = str3;
            qe.this.getListener().onFloatCall(qe.this.getType(), filterData);
        }
    }

    public qe(Context context, List<CalendarYearBean> list) {
        super(context);
        this.d = new CalendarPopView(xs0.a(), true, true, 60, new a(), list);
    }

    /* renamed from: a */
    public void show(@Nullable CalendarBean calendarBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-473658716")) {
            ipChange.ipc$dispatch("-473658716", new Object[]{this, calendarBean});
            return;
        }
        if (this.d.q() == null) {
            this.d.A(getFilterUt());
        }
        this.d.z(calendarBean);
        this.d.E();
        this.e = System.currentTimeMillis();
    }

    @Override // cn.damai.projectfilter.floatview.FloatLayer
    public Type getType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "941470402")) {
            return Type.DATE;
        }
        return (Type) ipChange.ipc$dispatch("941470402", new Object[]{this});
    }

    @Override // cn.damai.projectfilter.floatview.FloatLayer
    public View getView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1033415174")) {
            return (View) ipChange.ipc$dispatch("-1033415174", new Object[]{this});
        }
        CalendarPopView calendarPopView = this.d;
        if (calendarPopView != null) {
            return calendarPopView.s();
        }
        return null;
    }

    @Override // cn.damai.projectfilter.floatview.FloatLayer
    public void hide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2045642123")) {
            ipChange.ipc$dispatch("-2045642123", new Object[]{this});
            return;
        }
        this.d.t();
        getFilterUt().r(this.e);
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1936147608")) {
            ipChange.ipc$dispatch("-1936147608", new Object[]{this, view});
        }
    }
}
