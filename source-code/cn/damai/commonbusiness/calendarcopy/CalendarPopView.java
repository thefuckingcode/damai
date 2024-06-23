package cn.damai.commonbusiness.calendarcopy;

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
import cn.damai.commonbusiness.calendarcopy.adapter.CalendarListAdapter;
import cn.damai.commonbusiness.calendarcopy.bean.CalendarBean;
import cn.damai.commonbusiness.calendarcopy.bean.CalendarEntity;
import cn.damai.commonbusiness.calendarcopy.bean.Day;
import cn.damai.commonbusiness.home.bean.HomeMessage;
import cn.damai.projectfiltercopy.bean.CalendarInitBean;
import com.alibaba.fastjson.JSON;
import com.alibaba.pictures.R$anim;
import com.alibaba.pictures.R$color;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
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
import tb.e92;
import tb.l42;
import tb.ni0;
import tb.nl;
import tb.we;

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
    private ni0 y;

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
            if (AndroidInstantRuntime.support(ipChange, "1414833593")) {
                ipChange.ipc$dispatch("1414833593", new Object[]{this, view});
            } else if (view.getTag() != null && (day = (Day) view.getTag()) != null && day.showType != 0) {
                CalendarPopView calendarPopView = CalendarPopView.this;
                calendarPopView.r = 5;
                if (calendarPopView.w == null) {
                    CalendarPopView.this.w = day;
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(day);
                    CalendarPopView.this.D(arrayList);
                } else if (CalendarPopView.this.x != null) {
                    CalendarPopView.this.w = null;
                    CalendarPopView.this.x = null;
                    CalendarPopView.this.D(new ArrayList());
                } else if (day.equals(CalendarPopView.this.w)) {
                    CalendarPopView.this.w = null;
                    CalendarPopView.this.D(new ArrayList());
                } else if (day.isAfterDay(CalendarPopView.this.w)) {
                    CalendarPopView.this.x = day;
                    CalendarPopView calendarPopView2 = CalendarPopView.this;
                    calendarPopView2.D(calendarPopView2.q());
                } else {
                    CalendarPopView calendarPopView3 = CalendarPopView.this;
                    calendarPopView3.x = calendarPopView3.w;
                    CalendarPopView.this.w = day;
                    CalendarPopView calendarPopView4 = CalendarPopView.this;
                    calendarPopView4.D(calendarPopView4.q());
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
            if (AndroidInstantRuntime.support(ipChange, "1342447035")) {
                ipChange.ipc$dispatch("1342447035", new Object[]{this, view});
                return;
            }
            CalendarPopView calendarPopView = CalendarPopView.this;
            int i = calendarPopView.r;
            String str = "";
            if (i != -1 && i != 5) {
                calendarPopView.z(i, null, null, 0, calendarPopView.s);
                if (CalendarPopView.this.y != null) {
                    CalendarPopView.this.y.c(CalendarPopView.this.r, str, str);
                }
            } else if (calendarPopView.w == null) {
                CalendarPopView.this.o = null;
                CalendarPopView.this.z(0, null, null, 0, "全部时间");
            } else {
                String simpleShortDateString = CalendarPopView.this.w.toSimpleShortDateString();
                if (CalendarPopView.this.x == null) {
                    CalendarPopView calendarPopView2 = CalendarPopView.this;
                    calendarPopView2.x = calendarPopView2.w;
                } else {
                    simpleShortDateString = simpleShortDateString + "-" + CalendarPopView.this.x.toSimpleShortDateString();
                }
                if (CalendarPopView.this.y != null) {
                    ni0 ni0 = CalendarPopView.this.y;
                    CalendarPopView calendarPopView3 = CalendarPopView.this;
                    ni0.c(calendarPopView3.r, calendarPopView3.w.toSimpleDateString(), CalendarPopView.this.x == null ? str : CalendarPopView.this.x.toSimpleDateString());
                }
                CalendarPopView calendarPopView4 = CalendarPopView.this;
                String simpleDateString = calendarPopView4.w.toSimpleDateString();
                if (CalendarPopView.this.x != null) {
                    str = CalendarPopView.this.x.toSimpleDateString();
                }
                calendarPopView4.z(5, simpleDateString, str, 0, simpleShortDateString);
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
            if (AndroidInstantRuntime.support(ipChange, "-841229892")) {
                ipChange.ipc$dispatch("-841229892", new Object[]{this, view});
                return;
            }
            CalendarPopView calendarPopView = CalendarPopView.this;
            calendarPopView.r = 0;
            calendarPopView.H();
            CalendarPopView calendarPopView2 = CalendarPopView.this;
            calendarPopView2.w = calendarPopView2.x = null;
            CalendarPopView.this.D(new ArrayList());
            if (CalendarPopView.this.y != null) {
                CalendarPopView.this.y.e();
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
            if (AndroidInstantRuntime.support(ipChange, "1270060477")) {
                ipChange.ipc$dispatch("1270060477", new Object[]{this, view});
                return;
            }
            CalendarPopView.this.o = null;
            CalendarPopView.this.z(0, null, null, 0, "全部时间");
        }
    }

    /* compiled from: Taobao */
    public class e implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-913616450")) {
                ipChange.ipc$dispatch("-913616450", new Object[]{this, view});
                return;
            }
            CalendarPopView.this.o = null;
            CalendarPopView.this.z(10, null, null, 1, "一周内");
        }
    }

    /* compiled from: Taobao */
    public class f implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        f() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1197673919")) {
                ipChange.ipc$dispatch("1197673919", new Object[]{this, view});
                return;
            }
            CalendarPopView.this.o = null;
            CalendarPopView.this.z(4, null, null, 2, "一月内");
        }
    }

    /* compiled from: Taobao */
    public class g implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        g() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-986003008")) {
                ipChange.ipc$dispatch("-986003008", new Object[]{this, view});
                return;
            }
            CalendarPopView.this.o = null;
            CalendarPopView.this.z(9, null, null, 3, "本周末");
        }
    }

    public CalendarPopView(Context context, boolean z, boolean z2, int i2, OnDateClickListener onDateClickListener, CalendarInitBean calendarInitBean) {
        w(context, z, z2, i2, onDateClickListener, calendarInitBean);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void C() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1315188770")) {
            ipChange.ipc$dispatch("1315188770", new Object[]{this});
        } else if ((this.i.getChildAt(0) instanceof LinearLayout) && (viewGroup = (ViewGroup) this.i.getChildAt(0)) != null && (viewGroup2 = (ViewGroup) viewGroup.getChildAt(0)) != null && (viewGroup3 = (ViewGroup) viewGroup2.getChildAt(0)) != null) {
            E(viewGroup3);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void D(List<Day> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1446216388")) {
            ipChange.ipc$dispatch("1446216388", new Object[]{this, list});
            return;
        }
        this.o = list;
        if (e92.c(list) > 0) {
            Day day = list.get(0);
            if (day != null) {
                this.p = we.f(day);
            }
        } else {
            this.p = -1;
        }
        this.m.a(this.n, this.o);
    }

    private void E(ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1876729461")) {
            ipChange.ipc$dispatch("-1876729461", new Object[]{this, viewGroup});
        } else if (viewGroup != null && viewGroup.getChildCount() >= 2 && (viewGroup.getChildAt(0) instanceof TextView) && (viewGroup.getChildAt(1) instanceof TextView)) {
            TextView textView = (TextView) viewGroup.getChildAt(1);
            this.k.setText(((TextView) viewGroup.getChildAt(0)).getText());
            if (textView.getText() == null || TextUtils.isEmpty(textView.getText().toString())) {
                this.l.setVisibility(8);
                return;
            }
            CharSequence text = textView.getText();
            boolean equals = TextUtils.equals(this.l.getText(), text);
            this.l.setText(text);
            this.l.setVisibility(0);
            if (!equals) {
                this.l.post(new Runnable() {
                    /* class cn.damai.commonbusiness.calendarcopy.CalendarPopView.AnonymousClass10 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void run() {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-1980396668")) {
                            ipChange.ipc$dispatch("-1980396668", new Object[]{this});
                            return;
                        }
                        CalendarPopView.this.l.requestLayout();
                    }
                });
            }
        }
    }

    private void G() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "392825464")) {
            ipChange.ipc$dispatch("392825464", new Object[]{this});
            return;
        }
        this.c.startAnimation(AnimationUtils.loadAnimation(this.a, R$anim.copy_common_calendar_anim));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void H() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "819310129")) {
            ipChange.ipc$dispatch("819310129", new Object[]{this});
            return;
        }
        int i2 = this.r;
        if (i2 == 0) {
            this.e.setBackgroundResource(R$drawable.copy_common_date_select_bg);
            TextView textView = this.f;
            int i3 = R$drawable.copy_common_date_normal_bg;
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
            int i5 = R$drawable.copy_common_date_normal_bg;
            textView3.setBackgroundResource(i5);
            this.f.setBackgroundResource(i5);
            this.g.setBackgroundResource(R$drawable.copy_common_date_select_bg);
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
            int i7 = R$drawable.copy_common_date_normal_bg;
            textView5.setBackgroundResource(i7);
            this.f.setBackgroundResource(i7);
            this.g.setBackgroundResource(i7);
            this.h.setBackgroundResource(R$drawable.copy_common_date_select_bg);
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
            int i9 = R$drawable.copy_common_date_normal_bg;
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
            int i11 = R$drawable.copy_common_date_normal_bg;
            textView9.setBackgroundResource(i11);
            this.f.setBackgroundResource(R$drawable.copy_common_date_select_bg);
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
            int i13 = R$drawable.copy_common_date_normal_bg;
            textView11.setBackgroundResource(i13);
            this.f.setBackgroundResource(R$drawable.copy_common_date_select_bg);
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

    private List<Day> s(CalendarBean calendarBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2087069047")) {
            return (List) ipChange.ipc$dispatch("2087069047", new Object[]{this, calendarBean});
        }
        ArrayList arrayList = new ArrayList();
        if (calendarBean != null && !TextUtils.isEmpty(calendarBean.startDate)) {
            Date s2 = we.s(calendarBean.startDate);
            if (TextUtils.isEmpty(calendarBean.endDate)) {
                calendarBean.endDate = calendarBean.startDate;
            }
            Date s3 = we.s(calendarBean.endDate);
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

    private void v() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1436837416")) {
            ipChange.ipc$dispatch("-1436837416", new Object[]{this});
            return;
        }
        this.b.findViewById(R$id.item_filter_confirm).setOnClickListener(new b());
        this.b.findViewById(R$id.item_filter_reset).setOnClickListener(new c());
    }

    private void w(Context context, boolean z, boolean z2, int i2, OnDateClickListener onDateClickListener, CalendarInitBean calendarInitBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-256225320")) {
            ipChange.ipc$dispatch("-256225320", new Object[]{this, context, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), onDateClickListener, calendarInitBean});
            return;
        }
        this.t = z;
        this.q = z2;
        View inflate = LayoutInflater.from(context).inflate(R$layout.copy_common_calendar_pop, (ViewGroup) null);
        this.b = inflate;
        inflate.setVisibility(8);
        Context context2 = this.b.getContext();
        this.a = context2;
        this.u = l42.a(context2, (float) i2);
        this.v = onDateClickListener;
        if (calendarInitBean.mYearBeanList != null) {
            CalendarBean calendarBean = new CalendarBean();
            this.n = calendarBean;
            calendarBean.calendar = calendarInitBean.mYearBeanList;
        } else {
            try {
                String spValue = nl.INSTANCE.a().getSpValue(HomeMessage.CALENDAR_DATA);
                if (spValue != null) {
                    this.n = (CalendarBean) JSON.parseObject(spValue, CalendarBean.class);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        y(calendarInitBean.mCalendarEntityList);
    }

    private void x() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1686928343")) {
            ipChange.ipc$dispatch("1686928343", new Object[]{this});
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
            H();
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void y(List<CalendarEntity> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "773259702")) {
            ipChange.ipc$dispatch("773259702", new Object[]{this, list});
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
        CalendarListAdapter calendarListAdapter = new CalendarListAdapter(this.a, list, new a());
        this.m = calendarListAdapter;
        this.i.setAdapter(calendarListAdapter);
        this.i.addOnScrollListener(new RecyclerView.OnScrollListener() {
            /* class cn.damai.commonbusiness.calendarcopy.CalendarPopView.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1498508519")) {
                    ipChange.ipc$dispatch("-1498508519", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                    return;
                }
                CalendarPopView.this.i.getChildAt(0);
                if (CalendarPopView.this.t) {
                    CalendarPopView.this.C();
                }
            }
        });
        x();
        v();
        this.m.notifyDataSetChanged();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    private void z(int i2, String str, String str2, int i3, String str3) {
        String str4;
        ni0 ni0;
        OnDateClickListener onDateClickListener;
        IpChange ipChange = $ipChange;
        int i4 = 3;
        if (AndroidInstantRuntime.support(ipChange, "1794846544")) {
            ipChange.ipc$dispatch("1794846544", new Object[]{this, Integer.valueOf(i2), str, str2, Integer.valueOf(i3), str3});
            return;
        }
        if (i2 == 5) {
            this.i.scrollToPosition(0);
        }
        if (i2 == 10) {
            this.o = we.k();
        } else {
            if (i2 == 4) {
                this.o = we.l();
                str4 = "一月内";
                i4 = 2;
            } else if (i2 == 9) {
                this.o = we.q();
                str4 = "本周末";
            } else if (i2 == 0) {
                str4 = "全部时间";
                i4 = 0;
            }
            ni0 = this.y;
            if (!(ni0 == null || i2 == 5)) {
                ni0.d(str4, i4);
            }
            this.m.a(this.n, this.o);
            this.r = i2;
            this.s = str3;
            if (this.q) {
                H();
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
        ni0 = this.y;
        ni0.d(str4, i4);
        this.m.a(this.n, this.o);
        this.r = i2;
        this.s = str3;
        if (this.q) {
        }
        onDateClickListener = this.v;
        if (onDateClickListener == null) {
        }
    }

    public void A(CalendarBean calendarBean) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "2000608571")) {
            ipChange.ipc$dispatch("2000608571", new Object[]{this, calendarBean});
        } else if (calendarBean != null) {
            try {
                i2 = Integer.parseInt(calendarBean.dateType);
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            }
            if (i2 == 10) {
                this.o = we.k();
            } else if (i2 == 4) {
                this.o = we.l();
            } else if (i2 == 9) {
                this.o = we.q();
            } else if (i2 == 5) {
                this.o = s(calendarBean);
            } else if (i2 == 0) {
                this.o = new ArrayList();
            }
            this.m.a(this.n, this.o);
            this.r = i2;
            this.s = calendarBean.name;
            if (this.q) {
                H();
            }
        }
    }

    public ni0 B(ni0 ni0) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "449981919")) {
            return (ni0) ipChange.ipc$dispatch("449981919", new Object[]{this, ni0});
        }
        this.y = ni0;
        return ni0;
    }

    public void F() {
        Day day;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1874278652")) {
            ipChange.ipc$dispatch("1874278652", new Object[]{this});
            return;
        }
        this.b.setVisibility(0);
        G();
        this.m.a(this.n, this.o);
        final int a2 = (((((DisplayMetrics.getwidthPixels(this.a.getResources().getDisplayMetrics()) - l42.a(this.a, 18.0f)) / 7) - 6) * 56) / 45) + l42.a(this.a, 16.0f);
        if (e92.c(this.o) > 0 && (day = this.o.get(0)) != null) {
            this.p = we.f(day);
        }
        this.i.postDelayed(new Runnable() {
            /* class cn.damai.commonbusiness.calendarcopy.CalendarPopView.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1719555848")) {
                    ipChange.ipc$dispatch("-1719555848", new Object[]{this});
                    return;
                }
                if (CalendarPopView.this.p < 1) {
                    CalendarPopView.this.i.scrollToPosition(0);
                } else {
                    CalendarPopView.this.i.scrollToPosition(CalendarPopView.this.p - 1);
                }
                CalendarPopView.this.i.postDelayed(new Runnable() {
                    /* class cn.damai.commonbusiness.calendarcopy.CalendarPopView.AnonymousClass1.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void run() {
                        Day day;
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-1584461173")) {
                            ipChange.ipc$dispatch("-1584461173", new Object[]{this});
                            return;
                        }
                        int h = we.h(we.p(), we.n());
                        int m = we.m();
                        if (e92.c(CalendarPopView.this.o) > 0 && (day = (Day) CalendarPopView.this.o.get(0)) != null) {
                            h = we.h(day.year, day.month);
                            Calendar.getInstance(TimeZone.getTimeZone("GMT+8")).set(day.year, day.month, day.day);
                            m = day.day;
                        }
                        CalendarPopView.this.i.scrollBy(0, a2 * (((h + m) - 2) / 7));
                    }
                }, 100);
            }
        }, 100);
    }

    public List<Day> q() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1454806351")) {
            return (List) ipChange.ipc$dispatch("-1454806351", new Object[]{this});
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

    public ni0 r() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1995850722")) {
            return this.y;
        }
        return (ni0) ipChange.ipc$dispatch("1995850722", new Object[]{this});
    }

    public View t() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1588872087")) {
            return this.b;
        }
        return (View) ipChange.ipc$dispatch("1588872087", new Object[]{this});
    }

    public void u() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1442231169")) {
            ipChange.ipc$dispatch("1442231169", new Object[]{this});
            return;
        }
        this.b.setVisibility(8);
        this.x = null;
        this.w = null;
    }
}
