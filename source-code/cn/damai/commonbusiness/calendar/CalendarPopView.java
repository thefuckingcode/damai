package cn.damai.commonbusiness.calendar;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$anim;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.calendar.adapter.CalendarListAdapter;
import cn.damai.commonbusiness.calendar.bean.CalendarBean;
import cn.damai.commonbusiness.calendar.bean.CalendarYearBean;
import cn.damai.commonbusiness.calendar.bean.Day;
import cn.damai.commonbusiness.home.bean.HomeMessage;
import com.ali.user.mobile.utils.ScreenUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import tb.d20;
import tb.oi0;
import tb.ve;
import tb.xf2;

/* compiled from: Taobao */
public class CalendarPopView {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String STR_ONE_WEEK = "一周内";
    private Context a;
    private View b;
    private View c;
    private ViewGroup d;
    private TextView e;
    private TextView f;
    private TextView g;
    private TextView h;
    private RecyclerView i;
    private ViewGroup j;
    private TextView k;
    private TextView l;
    private CalendarListAdapter m;
    private CalendarBean n;
    private List<Day> o;
    private int p = 0;
    private boolean q;
    public int r = -1;
    private String s;
    private boolean t;
    private int u;
    private OnDateClickListener v;
    private Day w;
    private Day x;
    private oi0 y;

    /* compiled from: Taobao */
    public interface OnDateClickListener {
        void onClose();

        void onDateClick(int i, String str, String str2, int i2, String str3);
    }

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            Day day;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "654192388")) {
                ipChange.ipc$dispatch("654192388", new Object[]{this, view});
            } else if (view.getTag() != null && (day = (Day) view.getTag()) != null && day.showType != 0) {
                CalendarPopView calendarPopView = CalendarPopView.this;
                calendarPopView.r = 5;
                if (calendarPopView.w == null) {
                    CalendarPopView.this.w = day;
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(day);
                    CalendarPopView.this.C(arrayList);
                } else if (CalendarPopView.this.x != null) {
                    CalendarPopView.this.w = null;
                    CalendarPopView.this.x = null;
                    CalendarPopView.this.C(new ArrayList());
                } else if (day.equals(CalendarPopView.this.w)) {
                    CalendarPopView.this.w = null;
                    CalendarPopView.this.C(new ArrayList());
                } else if (day.isAfterDay(CalendarPopView.this.w)) {
                    CalendarPopView.this.x = day;
                    CalendarPopView calendarPopView2 = CalendarPopView.this;
                    calendarPopView2.C(calendarPopView2.p());
                } else {
                    CalendarPopView calendarPopView3 = CalendarPopView.this;
                    calendarPopView3.x = calendarPopView3.w;
                    CalendarPopView.this.w = day;
                    CalendarPopView calendarPopView4 = CalendarPopView.this;
                    calendarPopView4.C(calendarPopView4.p());
                }
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "581805830")) {
                ipChange.ipc$dispatch("581805830", new Object[]{this, view});
                return;
            }
            CalendarPopView calendarPopView = CalendarPopView.this;
            int i = calendarPopView.r;
            String str = "";
            if (i != -1 && i != 5) {
                calendarPopView.y(i, null, null, 0, calendarPopView.s);
                if (CalendarPopView.this.y != null) {
                    CalendarPopView.this.y.f(CalendarPopView.this.r, str, str);
                }
            } else if (calendarPopView.w == null) {
                CalendarPopView.this.o = null;
                CalendarPopView.this.y(0, null, null, 0, "全部时间");
            } else {
                String shortDateString = CalendarPopView.this.w.toShortDateString();
                if (CalendarPopView.this.x == null) {
                    CalendarPopView calendarPopView2 = CalendarPopView.this;
                    calendarPopView2.x = calendarPopView2.w;
                } else {
                    shortDateString = shortDateString + "-" + CalendarPopView.this.x.toShortDateString();
                }
                if (CalendarPopView.this.y != null) {
                    oi0 oi0 = CalendarPopView.this.y;
                    CalendarPopView calendarPopView3 = CalendarPopView.this;
                    oi0.f(calendarPopView3.r, calendarPopView3.w.toSimpleDateString(), CalendarPopView.this.x == null ? str : CalendarPopView.this.x.toSimpleDateString());
                }
                CalendarPopView calendarPopView4 = CalendarPopView.this;
                String simpleDateString = calendarPopView4.w.toSimpleDateString();
                if (CalendarPopView.this.x != null) {
                    str = CalendarPopView.this.x.toSimpleDateString();
                }
                calendarPopView4.y(5, simpleDateString, str, 0, shortDateString);
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1601871097")) {
                ipChange.ipc$dispatch("-1601871097", new Object[]{this, view});
                return;
            }
            CalendarPopView calendarPopView = CalendarPopView.this;
            calendarPopView.r = 0;
            calendarPopView.G();
            CalendarPopView calendarPopView2 = CalendarPopView.this;
            calendarPopView2.w = calendarPopView2.x = null;
            CalendarPopView.this.C(new ArrayList());
            if (CalendarPopView.this.y != null) {
                CalendarPopView.this.y.h();
            }
        }
    }

    /* compiled from: Taobao */
    public class d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "509419272")) {
                ipChange.ipc$dispatch("509419272", new Object[]{this, view});
                return;
            }
            CalendarPopView.this.o = null;
            CalendarPopView.this.y(0, null, null, 0, "全部时间");
        }
    }

    /* compiled from: Taobao */
    public class e implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1674257655")) {
                ipChange.ipc$dispatch("-1674257655", new Object[]{this, view});
                return;
            }
            CalendarPopView.this.o = null;
            CalendarPopView.this.y(10, null, null, 1, "一周内");
        }
    }

    /* compiled from: Taobao */
    public class f implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        f() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "437032714")) {
                ipChange.ipc$dispatch("437032714", new Object[]{this, view});
                return;
            }
            CalendarPopView.this.o = null;
            CalendarPopView.this.y(4, null, null, 2, "一月内");
        }
    }

    /* compiled from: Taobao */
    public class g implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        g() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1746644213")) {
                ipChange.ipc$dispatch("-1746644213", new Object[]{this, view});
                return;
            }
            CalendarPopView.this.o = null;
            CalendarPopView.this.y(9, null, null, 3, "本周末");
        }
    }

    public CalendarPopView(Context context, boolean z, boolean z2, int i2, OnDateClickListener onDateClickListener) {
        v(context, z, z2, i2, onDateClickListener, null);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void B() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1587211447")) {
            ipChange.ipc$dispatch("1587211447", new Object[]{this});
        } else if ((this.i.getChildAt(0) instanceof LinearLayout) && (viewGroup = (ViewGroup) this.i.getChildAt(0)) != null && (viewGroup2 = (ViewGroup) viewGroup.getChildAt(0)) != null && (viewGroup3 = (ViewGroup) viewGroup2.getChildAt(0)) != null) {
            D(viewGroup3);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void C(List<Day> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-656530407")) {
            ipChange.ipc$dispatch("-656530407", new Object[]{this, list});
            return;
        }
        this.o = list;
        if (xf2.e(list) > 0) {
            Day day = list.get(0);
            if (day != null) {
                this.p = ve.f(day);
            }
        } else {
            this.p = -1;
        }
        this.m.a(this.n, this.o);
    }

    private void D(ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "313196960")) {
            ipChange.ipc$dispatch("313196960", new Object[]{this, viewGroup});
        } else if (viewGroup != null && viewGroup.getChildCount() >= 2 && (viewGroup.getChildAt(0) instanceof TextView) && (viewGroup.getChildAt(1) instanceof TextView)) {
            TextView textView = (TextView) viewGroup.getChildAt(1);
            this.k.setText(((TextView) viewGroup.getChildAt(0)).getText());
            if (textView.getText() == null || TextUtils.isEmpty(textView.getText().toString())) {
                this.l.setVisibility(8);
                return;
            }
            this.l.setText(textView.getText());
            this.l.setVisibility(0);
        }
    }

    private void F() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2041912573")) {
            ipChange.ipc$dispatch("-2041912573", new Object[]{this});
            return;
        }
        this.c.startAnimation(AnimationUtils.loadAnimation(this.a, R$anim.common_calendar_anim));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void G() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1793232892")) {
            ipChange.ipc$dispatch("1793232892", new Object[]{this});
            return;
        }
        int i2 = this.r;
        if (i2 == 0) {
            this.e.setBackgroundResource(R$drawable.common_date_select_bg);
            TextView textView = this.f;
            int i3 = R$drawable.common_date_normal_bg;
            textView.setBackgroundResource(i3);
            this.g.setBackgroundResource(i3);
            this.h.setBackgroundResource(i3);
            this.e.setTextColor(this.a.getResources().getColor(R$color.color_FF2D79));
            TextView textView2 = this.f;
            Resources resources = this.a.getResources();
            int i4 = R$color.color_000000;
            textView2.setTextColor(resources.getColor(i4));
            this.g.setTextColor(this.a.getResources().getColor(i4));
            this.h.setTextColor(this.a.getResources().getColor(i4));
            this.p = -1;
        } else if (i2 == 4) {
            TextView textView3 = this.e;
            int i5 = R$drawable.common_date_normal_bg;
            textView3.setBackgroundResource(i5);
            this.f.setBackgroundResource(i5);
            this.g.setBackgroundResource(R$drawable.common_date_select_bg);
            this.h.setBackgroundResource(i5);
            TextView textView4 = this.e;
            Resources resources2 = this.a.getResources();
            int i6 = R$color.color_000000;
            textView4.setTextColor(resources2.getColor(i6));
            this.f.setTextColor(this.a.getResources().getColor(i6));
            this.g.setTextColor(this.a.getResources().getColor(R$color.color_FF2D79));
            this.h.setTextColor(this.a.getResources().getColor(i6));
            this.p = -1;
        } else if (i2 == 9) {
            TextView textView5 = this.e;
            int i7 = R$drawable.common_date_normal_bg;
            textView5.setBackgroundResource(i7);
            this.f.setBackgroundResource(i7);
            this.g.setBackgroundResource(i7);
            this.h.setBackgroundResource(R$drawable.common_date_select_bg);
            TextView textView6 = this.e;
            Resources resources3 = this.a.getResources();
            int i8 = R$color.color_000000;
            textView6.setTextColor(resources3.getColor(i8));
            this.f.setTextColor(this.a.getResources().getColor(i8));
            this.g.setTextColor(this.a.getResources().getColor(i8));
            this.h.setTextColor(this.a.getResources().getColor(R$color.color_FF2D79));
            this.p = -1;
        } else if (i2 != 10) {
            TextView textView7 = this.e;
            int i9 = R$drawable.common_date_normal_bg;
            textView7.setBackgroundResource(i9);
            this.f.setBackgroundResource(i9);
            this.g.setBackgroundResource(i9);
            this.h.setBackgroundResource(i9);
            TextView textView8 = this.e;
            Resources resources4 = this.a.getResources();
            int i10 = R$color.color_000000;
            textView8.setTextColor(resources4.getColor(i10));
            this.f.setTextColor(this.a.getResources().getColor(i10));
            this.g.setTextColor(this.a.getResources().getColor(i10));
            this.h.setTextColor(this.a.getResources().getColor(i10));
        } else {
            TextView textView9 = this.e;
            int i11 = R$drawable.common_date_normal_bg;
            textView9.setBackgroundResource(i11);
            this.f.setBackgroundResource(R$drawable.common_date_select_bg);
            this.g.setBackgroundResource(i11);
            this.h.setBackgroundResource(i11);
            TextView textView10 = this.e;
            Resources resources5 = this.a.getResources();
            int i12 = R$color.color_000000;
            textView10.setTextColor(resources5.getColor(i12));
            this.f.setTextColor(this.a.getResources().getColor(R$color.color_FF2D79));
            this.g.setTextColor(this.a.getResources().getColor(i12));
            this.h.setTextColor(this.a.getResources().getColor(i12));
            this.p = -1;
        }
        if (this.r == 5 && TextUtils.equals("一周内", this.s)) {
            TextView textView11 = this.e;
            int i13 = R$drawable.common_date_normal_bg;
            textView11.setBackgroundResource(i13);
            this.f.setBackgroundResource(R$drawable.common_date_select_bg);
            this.g.setBackgroundResource(i13);
            this.h.setBackgroundResource(i13);
            TextView textView12 = this.e;
            Resources resources6 = this.a.getResources();
            int i14 = R$color.color_000000;
            textView12.setTextColor(resources6.getColor(i14));
            this.f.setTextColor(this.a.getResources().getColor(R$color.color_FF2D79));
            this.g.setTextColor(this.a.getResources().getColor(i14));
            this.h.setTextColor(this.a.getResources().getColor(i14));
            this.p = -1;
        }
    }

    private List<Day> r(CalendarBean calendarBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "846653325")) {
            return (List) ipChange.ipc$dispatch("846653325", new Object[]{this, calendarBean});
        }
        ArrayList arrayList = new ArrayList();
        if (calendarBean != null && !TextUtils.isEmpty(calendarBean.startDate)) {
            Date s2 = ve.s(calendarBean.startDate);
            if (TextUtils.isEmpty(calendarBean.endDate)) {
                calendarBean.endDate = calendarBean.startDate;
            }
            Date s3 = ve.s(calendarBean.endDate);
            if (s2 == null) {
                return arrayList;
            }
            int time = (int) ((s3.getTime() - s2.getTime()) / 86400000);
            PrintStream printStream = System.out;
            printStream.println("两个时间之间的天数差为：" + time);
            Calendar instance = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
            for (int i2 = 0; i2 <= time; i2++) {
                instance.setTime(s2);
                instance.add(5, i2);
                Day day = new Day(instance.get(1), instance.get(2) + 1, instance.get(5));
                arrayList.add(day);
                if (i2 == 0) {
                    this.w = day;
                } else if (i2 == time) {
                    this.x = day;
                }
            }
        }
        return arrayList;
    }

    private void u() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1594069021")) {
            ipChange.ipc$dispatch("-1594069021", new Object[]{this});
            return;
        }
        this.b.findViewById(R$id.item_filter_confirm).setOnClickListener(new b());
        this.b.findViewById(R$id.item_filter_reset).setOnClickListener(new c());
    }

    private void v(Context context, boolean z, boolean z2, int i2, OnDateClickListener onDateClickListener, List<CalendarYearBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-895621379")) {
            ipChange.ipc$dispatch("-895621379", new Object[]{this, context, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), onDateClickListener, list});
            return;
        }
        this.t = z;
        this.q = z2;
        View inflate = LayoutInflater.from(context).inflate(R$layout.common_calendar_pop, (ViewGroup) null);
        this.b = inflate;
        inflate.setVisibility(8);
        Context context2 = this.b.getContext();
        this.a = context2;
        this.u = ScreenUtil.dip2px(context2, (float) i2);
        this.v = onDateClickListener;
        if (list != null) {
            CalendarBean calendarBean = new CalendarBean();
            this.n = calendarBean;
            calendarBean.calendar = list;
        } else {
            try {
                String B = d20.B(HomeMessage.CALENDAR_DATA);
                if (B != null) {
                    this.n = (CalendarBean) JSON.parseObject(B, CalendarBean.class);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        x();
    }

    private void w() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-775506772")) {
            ipChange.ipc$dispatch("-775506772", new Object[]{this});
            return;
        }
        ViewGroup viewGroup = (ViewGroup) this.b.findViewById(R$id.layout_fourdate);
        this.d = viewGroup;
        if (this.q) {
            viewGroup.setVisibility(0);
            this.e = (TextView) this.d.findViewById(R$id.tv_time1);
            this.f = (TextView) this.d.findViewById(R$id.tv_time2);
            this.g = (TextView) this.d.findViewById(R$id.tv_time3);
            this.h = (TextView) this.d.findViewById(R$id.tv_time4);
            this.e.setOnClickListener(new d());
            this.f.setOnClickListener(new e());
            this.g.setOnClickListener(new f());
            this.h.setOnClickListener(new g());
            G();
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void x() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1842445200")) {
            ipChange.ipc$dispatch("1842445200", new Object[]{this});
            return;
        }
        View findViewById = this.b.findViewById(R$id.layout_calendar);
        this.c = findViewById;
        ((ViewGroup.MarginLayoutParams) findViewById.getLayoutParams()).setMargins(0, 0, 0, this.u);
        ViewGroup viewGroup = (ViewGroup) this.b.findViewById(R$id.layout_guding);
        this.j = viewGroup;
        if (this.t) {
            viewGroup.setVisibility(0);
        } else {
            viewGroup.setVisibility(8);
        }
        this.k = (TextView) this.b.findViewById(R$id.tv_calendar_month);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM", Locale.CHINA);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
        this.k.setText(simpleDateFormat.format(Calendar.getInstance(TimeZone.getTimeZone("GMT+8")).getTime()));
        this.l = (TextView) this.b.findViewById(R$id.tv_shenhua);
        RecyclerView recyclerView = (RecyclerView) this.b.findViewById(R$id.pop_irc);
        this.i = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this.a, 1, false));
        CalendarListAdapter calendarListAdapter = new CalendarListAdapter(this.a, new a());
        this.m = calendarListAdapter;
        this.i.setAdapter(calendarListAdapter);
        this.i.addOnScrollListener(new RecyclerView.OnScrollListener() {
            /* class cn.damai.commonbusiness.calendar.CalendarPopView.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-82579026")) {
                    ipChange.ipc$dispatch("-82579026", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                    return;
                }
                CalendarPopView.this.i.getChildAt(0);
                if (CalendarPopView.this.t) {
                    CalendarPopView.this.B();
                }
            }
        });
        w();
        u();
        this.m.notifyDataSetChanged();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    private void y(int i2, String str, String str2, int i3, String str3) {
        String str4;
        oi0 oi0;
        OnDateClickListener onDateClickListener;
        IpChange ipChange = $ipChange;
        int i4 = 3;
        if (AndroidInstantRuntime.support(ipChange, "-404809819")) {
            ipChange.ipc$dispatch("-404809819", new Object[]{this, Integer.valueOf(i2), str, str2, Integer.valueOf(i3), str3});
            return;
        }
        if (i2 == 5) {
            this.i.scrollToPosition(0);
        }
        if (i2 == 10) {
            this.o = ve.i();
        } else {
            if (i2 == 4) {
                this.o = ve.j();
                str4 = "一月内";
                i4 = 2;
            } else if (i2 == 9) {
                this.o = ve.p();
                str4 = "本周末";
            } else if (i2 == 0) {
                str4 = "全部时间";
                i4 = 0;
            }
            oi0 = this.y;
            if (!(oi0 == null || i2 == 5)) {
                oi0.g(str4, i4);
            }
            this.m.a(this.n, this.o);
            this.r = i2;
            this.s = str3;
            if (this.q) {
                G();
            }
            onDateClickListener = this.v;
            if (onDateClickListener == null) {
                onDateClickListener.onDateClick(i2, str, str2, i3, str3);
                return;
            }
            return;
        }
        str4 = "一周内";
        i4 = 1;
        oi0 = this.y;
        oi0.g(str4, i4);
        this.m.a(this.n, this.o);
        this.r = i2;
        this.s = str3;
        if (this.q) {
        }
        onDateClickListener = this.v;
        if (onDateClickListener == null) {
        }
    }

    public oi0 A(oi0 oi0) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1183893706")) {
            return (oi0) ipChange.ipc$dispatch("1183893706", new Object[]{this, oi0});
        }
        this.y = oi0;
        return oi0;
    }

    public void E() {
        Day day;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1110316753")) {
            ipChange.ipc$dispatch("1110316753", new Object[]{this});
            return;
        }
        this.b.setVisibility(0);
        F();
        this.m.a(this.n, this.o);
        final int dip2px = (((((DisplayMetrics.getwidthPixels(this.a.getResources().getDisplayMetrics()) - ScreenUtil.dip2px(this.a, 18.0f)) / 7) - 6) * 56) / 45) + ScreenUtil.dip2px(this.a, 16.0f);
        if (xf2.e(this.o) > 0 && (day = this.o.get(0)) != null) {
            this.p = ve.f(day);
        }
        this.i.postDelayed(new Runnable() {
            /* class cn.damai.commonbusiness.calendar.CalendarPopView.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1716516877")) {
                    ipChange.ipc$dispatch("1716516877", new Object[]{this});
                    return;
                }
                if (CalendarPopView.this.p < 1) {
                    CalendarPopView.this.i.scrollToPosition(0);
                } else {
                    CalendarPopView.this.i.scrollToPosition(CalendarPopView.this.p - 1);
                }
                CalendarPopView.this.i.postDelayed(new Runnable() {
                    /* class cn.damai.commonbusiness.calendar.CalendarPopView.AnonymousClass1.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void run() {
                        Day day;
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "1946544224")) {
                            ipChange.ipc$dispatch("1946544224", new Object[]{this});
                            return;
                        }
                        int h = ve.h(ve.o(), ve.m());
                        int k = ve.k();
                        if (xf2.e(CalendarPopView.this.o) > 0 && (day = (Day) CalendarPopView.this.o.get(0)) != null) {
                            h = ve.h(day.year, day.month);
                            Calendar.getInstance(TimeZone.getTimeZone("GMT+8")).set(day.year, day.month, day.day);
                            k = day.day;
                        }
                        CalendarPopView.this.i.scrollBy(0, dip2px * (((h + k) - 2) / 7));
                    }
                }, 100);
            }
        }, 100);
    }

    public List<Day> p() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1063673158")) {
            return (List) ipChange.ipc$dispatch("1063673158", new Object[]{this});
        }
        ArrayList arrayList = new ArrayList();
        Calendar instance = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        Day day = this.w;
        instance.set(day.year, day.month - 1, day.day);
        instance.get(6);
        Date simpleDate = this.w.toSimpleDate();
        Date simpleDate2 = this.x.toSimpleDate();
        if (!(simpleDate == null || simpleDate2 == null)) {
            int time = (int) ((simpleDate2.getTime() - simpleDate.getTime()) / 86400000);
            PrintStream printStream = System.out;
            printStream.println("两个时间之间的天数差为：" + time);
            for (int i2 = 0; i2 <= time; i2++) {
                Day day2 = this.w;
                instance.set(day2.year, day2.month - 1, day2.day);
                instance.add(5, i2);
                arrayList.add(new Day(instance.get(1), instance.get(2) + 1, instance.get(5)));
            }
        }
        return arrayList;
    }

    public oi0 q() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1697550914")) {
            return this.y;
        }
        return (oi0) ipChange.ipc$dispatch("1697550914", new Object[]{this});
    }

    public View s() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-187615700")) {
            return this.b;
        }
        return (View) ipChange.ipc$dispatch("-187615700", new Object[]{this});
    }

    public void t() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "678269270")) {
            ipChange.ipc$dispatch("678269270", new Object[]{this});
            return;
        }
        this.b.setVisibility(8);
        this.x = null;
        this.w = null;
    }

    public void z(CalendarBean calendarBean) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "1896967397")) {
            ipChange.ipc$dispatch("1896967397", new Object[]{this, calendarBean});
        } else if (calendarBean != null) {
            try {
                i2 = Integer.parseInt(calendarBean.dateType);
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            }
            if (i2 == 10) {
                this.o = ve.i();
            } else if (i2 == 4) {
                this.o = ve.j();
            } else if (i2 == 9) {
                this.o = ve.p();
            } else if (i2 == 5) {
                this.o = r(calendarBean);
            } else if (i2 == 0) {
                this.o = new ArrayList();
            }
            this.m.a(this.n, this.o);
            this.r = i2;
            this.s = calendarBean.name;
            if (this.q) {
                G();
            }
        }
    }

    public CalendarPopView(Context context, boolean z, boolean z2, int i2, OnDateClickListener onDateClickListener, List<CalendarYearBean> list) {
        v(context, z, z2, i2, onDateClickListener, list);
    }
}
