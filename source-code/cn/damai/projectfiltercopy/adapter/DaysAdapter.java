package cn.damai.projectfiltercopy.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.calendarcopy.bean.Day;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.e92;
import tb.g30;
import tb.k21;
import tb.we;

/* compiled from: Taobao */
public final class DaysAdapter extends RecyclerView.Adapter<DayVh> {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final OnHorCalendarListener a;
    @Nullable
    private List<? extends Day> b;
    @Nullable
    private List<? extends Day> c;
    @Nullable
    private Day d;

    /* compiled from: Taobao */
    public final class DayVh extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private final TextView a;
        private final TextView b;
        @Nullable
        private Day c;
        final /* synthetic */ DaysAdapter d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DayVh(@NotNull DaysAdapter daysAdapter, View view) {
            super(view);
            k21.i(view, "itemView");
            this.d = daysAdapter;
            this.a = (TextView) view.findViewById(R$id.id_day_top_tip);
            this.b = (TextView) view.findViewById(R$id.id_day_top_date);
            view.setOnClickListener(new g30(this, daysAdapter));
        }

        /* access modifiers changed from: private */
        public static final void b(DayVh dayVh, DaysAdapter daysAdapter, View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-296867122")) {
                ipChange.ipc$dispatch("-296867122", new Object[]{dayVh, daysAdapter, view});
                return;
            }
            k21.i(dayVh, "this$0");
            k21.i(daysAdapter, "this$1");
            Day day = dayVh.c;
            if (day != null) {
                daysAdapter.c().onCalendarClick(day, daysAdapter.c);
            }
        }

        public final void c(@NotNull Day day, int i) {
            IpChange ipChange = $ipChange;
            boolean z = false;
            if (AndroidInstantRuntime.support(ipChange, "-1846701213")) {
                ipChange.ipc$dispatch("-1846701213", new Object[]{this, day, Integer.valueOf(i)});
                return;
            }
            k21.i(day, "day");
            this.c = day;
            Day day2 = this.d.d;
            if (day2 != null) {
                z = day2.equals(day);
            }
            if (z) {
                this.a.setText("今天");
            } else {
                TextView textView = this.a;
                String str = day.tag;
                if (str == null) {
                    str = day.getWeekStr();
                }
                textView.setText(str);
            }
            this.b.setText(day.toSimpleShortDateString());
            int a2 = e92.a(this.d.c);
            if (a2 <= 0) {
                this.itemView.setBackground(null);
                return;
            }
            int i2 = -1;
            if (a2 == 1) {
                List list = this.d.c;
                if (list != null) {
                    i2 = list.indexOf(day);
                }
                if (i2 >= 0) {
                    this.itemView.setBackgroundResource(R$drawable.bricks_hor_calendar_item_select_single);
                } else {
                    this.itemView.setBackground(null);
                }
            } else if (a2 == 2) {
                List list2 = this.d.c;
                if (list2 != null) {
                    i2 = list2.indexOf(day);
                }
                if (i2 == 0) {
                    this.itemView.setBackgroundResource(R$drawable.bricks_hor_calendar_item_select_left_two);
                } else if (i2 != 1) {
                    this.itemView.setBackground(null);
                } else {
                    this.itemView.setBackgroundResource(R$drawable.bricks_hor_calendar_item_select_right_two);
                }
            } else {
                List list3 = this.d.c;
                if (list3 != null) {
                    i2 = list3.indexOf(day);
                }
                if (i2 < 0) {
                    this.itemView.setBackground(null);
                } else if (i2 == 0) {
                    this.itemView.setBackgroundResource(R$drawable.bricks_hor_calendar_item_select_left);
                } else if (i2 == a2 - 1) {
                    this.itemView.setBackgroundResource(R$drawable.bricks_hor_calendar_item_select_right);
                } else {
                    this.itemView.setBackgroundResource(R$drawable.bricks_hor_calendar_item_select_middle);
                }
            }
        }
    }

    public DaysAdapter(@NotNull OnHorCalendarListener onHorCalendarListener) {
        k21.i(onHorCalendarListener, "listener");
        this.a = onHorCalendarListener;
    }

    @NotNull
    public final OnHorCalendarListener c() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "210031124")) {
            return this.a;
        }
        return (OnHorCalendarListener) ipChange.ipc$dispatch("210031124", new Object[]{this});
    }

    /* renamed from: d */
    public void onBindViewHolder(@NotNull DayVh dayVh, int i) {
        Day day;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-196994762")) {
            ipChange.ipc$dispatch("-196994762", new Object[]{this, dayVh, Integer.valueOf(i)});
            return;
        }
        k21.i(dayVh, "holder");
        List<? extends Day> list = this.b;
        if (list != null && (day = (Day) list.get(i)) != null) {
            dayVh.c(day, i);
        }
    }

    @NotNull
    /* renamed from: e */
    public DayVh onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "147550464")) {
            return (DayVh) ipChange.ipc$dispatch("147550464", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        k21.i(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.copy_filter_hor_day_item, viewGroup, false);
        k21.h(inflate, "inflate");
        return new DayVh(this, inflate);
    }

    public final void f(@Nullable List<? extends Day> list, @Nullable List<? extends Day> list2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "124458530")) {
            ipChange.ipc$dispatch("124458530", new Object[]{this, list, list2});
            return;
        }
        this.b = list;
        this.c = list2;
        this.d = we.t();
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1473605590")) {
            return ((Integer) ipChange.ipc$dispatch("1473605590", new Object[]{this})).intValue();
        }
        List<? extends Day> list = this.b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }
}
