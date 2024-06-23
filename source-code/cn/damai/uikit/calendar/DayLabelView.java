package cn.damai.uikit.calendar;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import cn.damai.uikit.R$color;
import cn.damai.uikit.R$id;
import cn.damai.uikit.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class DayLabelView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private DayView mDayView;
    private LabelView mLabelTv;

    public DayLabelView(@NonNull Context context, CalendarDay calendarDay) {
        super(context);
        initView(context);
        initData(calendarDay);
    }

    private void initData(CalendarDay calendarDay) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "788124011")) {
            ipChange.ipc$dispatch("788124011", new Object[]{this, calendarDay});
            return;
        }
        this.mDayView.setDay(calendarDay);
    }

    private void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "460990754")) {
            ipChange.ipc$dispatch("460990754", new Object[]{this, context});
            return;
        }
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R$layout.layout_day_view, this);
        this.mDayView = (DayView) inflate.findViewById(R$id.day_view);
        this.mLabelTv = (LabelView) inflate.findViewById(R$id.tv_day_view_label);
    }

    /* access modifiers changed from: package-private */
    public void applyFacade(a aVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-832223864")) {
            ipChange.ipc$dispatch("-832223864", new Object[]{this, aVar});
        } else if (aVar != null) {
            if (!aVar.p() || !this.mDayView.isInMonth()) {
                this.mLabelTv.setVisibility(4);
            } else {
                this.mLabelTv.setBackgroundDrawable(aVar.i());
                if (aVar.j() != null) {
                    this.mLabelTv.setBackground(aVar.i(), aVar.j());
                }
                this.mLabelTv.setText(aVar.k());
                if (TextUtils.isEmpty(aVar.k()) || !"惠".equals(aVar.k())) {
                    this.mLabelTv.setTextColor(getResources().getColor(R$color.white));
                    this.mLabelTv.getPaint().setFakeBoldText(true);
                } else {
                    this.mLabelTv.setTextColor(getResources().getColor(R$color.day_ff2d79));
                    this.mLabelTv.getPaint().setFakeBoldText(false);
                }
                this.mLabelTv.setVisibility(0);
            }
            this.mDayView.applyFacade(aVar);
        }
    }

    public LabelView getDayLabelView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1233384547")) {
            return this.mLabelTv;
        }
        return (LabelView) ipChange.ipc$dispatch("-1233384547", new Object[]{this});
    }

    public DayView getDayView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "156521097")) {
            return this.mDayView;
        }
        return (DayView) ipChange.ipc$dispatch("156521097", new Object[]{this});
    }
}
