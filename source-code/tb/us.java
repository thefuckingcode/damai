package tb;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.autonavi.base.amap.mapcore.tools.GLMapStaticValue;
import com.taobao.android.dinamic.R$id;
import com.taobao.android.dinamic.R$layout;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode;
import com.taobao.android.dinamicx.widget.calander.Calendar;
import com.taobao.android.dinamicx.widget.calander.CalendarView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: Taobao */
public class us extends DXWidgetNode {
    public static final long DXCALENDARVIEW_ANCHORDATE = -8904535438500141309L;
    public static final long DXCALENDARVIEW_AUTOCHANGEMONTH = 8833414845409451796L;
    public static final long DXCALENDARVIEW_BEGINDATE = -1860805752639688564L;
    public static final long DXCALENDARVIEW_CALENDARITEMHEIGHT = -1496427289189049292L;
    public static final long DXCALENDARVIEW_CALENDARVIEW = 116344237634520001L;
    public static final long DXCALENDARVIEW_CURRENTDAYTEXTSIZE = -7647500290265887373L;
    public static final long DXCALENDARVIEW_DATETOPGAP = -5929381539273250573L;
    public static final long DXCALENDARVIEW_DAYTEXTGRAVITY = 262055229558107607L;
    public static final long DXCALENDARVIEW_DAYTEXTSIZE = -8982072168126024311L;
    public static final long DXCALENDARVIEW_DISABLEDDATES = 2788104028282969654L;
    public static final long DXCALENDARVIEW_ENDDATE = 4804791552104474556L;
    public static final long DXCALENDARVIEW_FONT = 34149272427L;
    public static final long DXCALENDARVIEW_HIGHLIGHTDATES = -4039211786071886953L;
    public static final long DXCALENDARVIEW_ONCHANGE = 5288679823228297259L;
    public static final long DXCALENDARVIEW_ONMONTHCHANGE = -5286047925153782218L;
    public static final long DXCALENDARVIEW_SCROLLABLE = 5099976257538233901L;
    public static final long DXCALENDARVIEW_SELECTEDDATE = 792202854466360275L;
    public static final long DXCALENDARVIEW_SELECTTEXTCOLOR = 2053814541299040819L;
    public static final long DXCALENDARVIEW_WEEKBARTEXTCOLOR = -3668263311141608587L;
    private String a;
    private boolean b = true;
    private String c;
    private int d;
    private int e;
    private String f;
    private String g;
    private int h = -1;
    private String i;
    private int j;
    private CalendarView k;
    private TextView l;
    private JSONArray m;
    private JSONObject n;
    private int o = 0;
    private boolean p = true;
    private int q;
    private int r = -13421773;
    private final CalendarView.OnMonthChangeListener s = new c();
    private final CalendarView.OnMonthUIRangeChangeListener t = new d();

    /* compiled from: Taobao */
    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            us.this.k.scrollToPre(true);
        }
    }

    /* compiled from: Taobao */
    class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View view) {
            us.this.k.scrollToNext(true);
        }
    }

    /* compiled from: Taobao */
    class c implements CalendarView.OnMonthChangeListener {
        c() {
        }

        @Override // com.taobao.android.dinamicx.widget.calander.CalendarView.OnMonthChangeListener
        public void onMonthChange(int i, int i2) {
            us.this.l.setText(String.format(Locale.getDefault(), "%d年%d月", Integer.valueOf(i), Integer.valueOf(i2)));
            us.this.k.updateMonthArrowStatus();
        }
    }

    /* compiled from: Taobao */
    class d implements CalendarView.OnMonthUIRangeChangeListener {
        d() {
        }

        @Override // com.taobao.android.dinamicx.widget.calander.CalendarView.OnMonthUIRangeChangeListener
        public void onMonthUIRangeChange(Calendar calendar, String str, Pair<String, String> pair) {
            zy zyVar = new zy(us.DXCALENDARVIEW_ONMONTHCHANGE);
            if (calendar != null) {
                zyVar.f("selectedDate", calendar.getDateString());
            }
            if (!TextUtils.isEmpty(str)) {
                zyVar.f("anchorDate", str);
            }
            if (pair != null) {
                zyVar.f("startDate", (String) pair.first);
                zyVar.f("endDate", (String) pair.second);
                us.this.postEvent(zyVar);
            }
        }
    }

    /* compiled from: Taobao */
    public static class e implements IDXBuilderWidgetNode {
        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(Object obj) {
            return new us();
        }
    }

    /* compiled from: Taobao */
    private class f implements CalendarView.OnCalendarSelectListener {
        private f() {
        }

        @Override // com.taobao.android.dinamicx.widget.calander.CalendarView.OnCalendarSelectListener
        public void onCalendarOutOfRange(Calendar calendar) {
        }

        @Override // com.taobao.android.dinamicx.widget.calander.CalendarView.OnCalendarSelectListener
        public void onCalendarSelect(@NonNull Calendar calendar, boolean z) {
            if (z) {
                az azVar = new az(5288679823228297259L);
                azVar.f("selectedDate", calendar.getDateString());
                us.this.postEvent(azVar);
            }
        }

        /* synthetic */ f(us usVar, a aVar) {
            this();
        }
    }

    private boolean c(String str) {
        return !TextUtils.isEmpty(str) && Pattern.matches("(\\d{4})-((0[1-9])|(1[0-2]))-(([0-2][1-9])|3[0-1]|([1-2]0))", str);
    }

    private HashMap<String, Calendar> d() {
        String key;
        Calendar e2;
        JSONObject jSONObject = this.n;
        if (jSONObject == null || jSONObject.isEmpty()) {
            return null;
        }
        HashMap<String, Calendar> hashMap = new HashMap<>();
        for (Map.Entry<String, Object> entry : this.n.entrySet()) {
            Object value = entry.getValue();
            if ((value instanceof JSONObject) && (e2 = e((key = entry.getKey()))) != null) {
                JSONObject jSONObject2 = (JSONObject) value;
                e2.setBooked(jSONObject2.getBooleanValue("booked"));
                JSONObject jSONObject3 = jSONObject2.getJSONObject("activityInfo");
                if (jSONObject3 != null) {
                    Calendar.a aVar = new Calendar.a();
                    aVar.a = jSONObject3.getString("title");
                    aVar.b = jSONObject3.getString("color");
                    e2.setCalendarInfo(aVar);
                }
                hashMap.put(key, e2);
            }
        }
        return hashMap;
    }

    private Calendar e(String str) {
        if (!c(str)) {
            return null;
        }
        int parseInt = Integer.parseInt(str.substring(0, 4));
        int parseInt2 = Integer.parseInt(str.substring(5, 7));
        int parseInt3 = Integer.parseInt(str.substring(8, 10));
        Calendar calendar = new Calendar();
        calendar.setYear(parseInt);
        calendar.setMonth(parseInt2);
        calendar.setDay(parseInt3);
        return calendar;
    }

    private List<Pair<Calendar, Calendar>> f() {
        Calendar e2;
        Calendar e3;
        JSONArray jSONArray = this.m;
        if (jSONArray == null || jSONArray.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.m.size(); i2++) {
            String string = this.m.getString(i2);
            if (!TextUtils.isEmpty(string)) {
                String[] split = string.split(",");
                if (!(split.length != 2 || (e2 = e(split[0])) == null || (e3 = e(split[1])) == null)) {
                    arrayList.add(new Pair(e2, e3));
                }
            }
        }
        return arrayList;
    }

    @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public DXWidgetNode build(Object obj) {
        return new us();
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        if (dXWidgetNode instanceof us) {
            super.onClone(dXWidgetNode, z);
            us usVar = (us) dXWidgetNode;
            this.j = usVar.j;
            this.c = usVar.c;
            this.e = usVar.e;
            this.o = usVar.o;
            this.f = usVar.f;
            this.h = usVar.h;
            this.i = usVar.i;
            this.m = usVar.m;
            this.n = usVar.n;
            this.p = usVar.p;
            this.b = usVar.b;
            this.a = usVar.a;
            this.g = usVar.g;
            this.d = usVar.d;
            this.q = usVar.q;
            this.r = usVar.r;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        View a2 = i00.a(context, R$layout.datepicker_widget);
        this.k = (CalendarView) a2.findViewById(R$id.calendarView);
        this.l = (TextView) a2.findViewById(R$id.tv_cur_month);
        int i2 = R$id.iv_left;
        ImageView imageView = (ImageView) a2.findViewById(i2);
        int i3 = R$id.iv_right;
        ImageView imageView2 = (ImageView) a2.findViewById(i3);
        imageView.setOnClickListener(new a());
        imageView2.setOnClickListener(new b());
        int i4 = this.e;
        if (i4 != 0) {
            this.k.setDayTextSize(i4);
        }
        int i5 = this.d;
        if (i5 != 0) {
            this.k.setCurrentDayTextSize(i5);
        }
        this.k.setCalendarItemHeight(this.j);
        this.k.setOnMonthChangeListener(this.s);
        this.k.setOnMonthUIRangeChangeListener(this.t);
        a2.setTag(R$id.dx_date_picker_view_tag, this.k);
        this.k.setTag(i2, imageView);
        this.k.setTag(i3, imageView2);
        return a2;
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i2, int i3) {
        if (View.MeasureSpec.getMode(i2) == 1073741824 && View.MeasureSpec.getMode(i3) == 1073741824) {
            super.onMeasure(i2, i3);
            return;
        }
        int c2 = com.taobao.android.dinamicx.widget.calander.a.c(getDXRuntimeContext().getContext(), 50.0f);
        int i4 = this.j;
        if (i4 <= 0) {
            i4 = com.taobao.android.dinamicx.widget.calander.a.c(getDXRuntimeContext().getContext(), 56.0f);
        }
        setMeasuredDimension(i2, c2 + com.taobao.android.dinamicx.widget.calander.a.c(getDXRuntimeContext().getContext(), 40.0f) + this.q + (i4 * 6));
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        super.onRenderView(context, view);
        if (view != null) {
            if (this.k == null) {
                Object tag = view.getTag(R$id.dx_date_picker_view_tag);
                if (tag instanceof CalendarView) {
                    this.k = (CalendarView) tag;
                }
            }
            this.k.setSelectedTextColor(this.h);
            this.k.setWeekBarTextColor(this.r);
            this.k.setDateTopGap(this.q);
            this.k.setDateTextGravity(this.o);
            this.k.setDateTextFont(this.g);
            this.k.setScrollable(this.p);
            this.k.setAutoChangeMonth(this.b);
            this.k.setOnCalendarSelectListener(new f(this, null));
            Calendar e2 = e(this.c);
            Calendar e3 = e(this.f);
            Calendar e4 = e(this.a);
            List<Pair<Calendar, Calendar>> f2 = f();
            HashMap<String, Calendar> d2 = d();
            if (e2 != null) {
                int year = e2.getYear();
                int month = e2.getMonth();
                i2 = e2.getDay();
                i4 = year;
                i3 = month;
            } else {
                i4 = 1971;
                i3 = 1;
                i2 = 1;
            }
            if (e3 != null) {
                int year2 = e3.getYear();
                int month2 = e3.getMonth();
                i7 = year2;
                i5 = e3.getDay();
                i6 = month2;
            } else {
                i7 = GLMapStaticValue.MAP_PARAMETERNAME_POLYGON_FILL_CONTROL;
                i6 = 12;
                i5 = -1;
            }
            this.k.setAnchorCalendar(e4);
            this.k.setRange(i4, i3, i2, i7, i6, i5, f2, d2);
            if (e4 == null || !this.k.isInRange(e4)) {
                Calendar e5 = e(this.i);
                if (e5 == null || !this.k.isInRange(e5)) {
                    this.k.scrollToCalendar(i4, i3, i2, false, false, false);
                } else {
                    this.k.scrollToCalendar(e5.getYear(), e5.getMonth(), e5.getDay());
                }
            } else {
                this.k.scrollToCalendar(e4.getYear(), e4.getMonth(), e4.getDay(), false, false, false);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j2, int i2) {
        boolean z = true;
        if (j2 == DXCALENDARVIEW_AUTOCHANGEMONTH) {
            if (i2 == 0) {
                z = false;
            }
            this.b = z;
        } else if (j2 == DXCALENDARVIEW_CALENDARITEMHEIGHT) {
            this.j = i2;
        } else if (j2 == DXCALENDARVIEW_CURRENTDAYTEXTSIZE) {
            this.d = i2;
        } else if (j2 == DXCALENDARVIEW_DATETOPGAP) {
            this.q = i2;
        } else if (j2 == DXCALENDARVIEW_DAYTEXTGRAVITY) {
            this.o = i2;
        } else if (j2 == DXCALENDARVIEW_DAYTEXTSIZE) {
            this.e = i2;
        } else if (j2 == DXCALENDARVIEW_SELECTTEXTCOLOR) {
            this.h = i2;
        } else if (j2 == DXCALENDARVIEW_SCROLLABLE) {
            if (i2 == 0) {
                z = false;
            }
            this.p = z;
        } else if (j2 == DXCALENDARVIEW_WEEKBARTEXTCOLOR) {
            this.r = i2;
        } else {
            super.onSetIntAttribute(j2, i2);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetListAttribute(long j2, JSONArray jSONArray) {
        if (j2 == DXCALENDARVIEW_DISABLEDDATES) {
            this.m = jSONArray;
        } else {
            super.onSetListAttribute(j2, jSONArray);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetMapAttribute(long j2, JSONObject jSONObject) {
        if (j2 == DXCALENDARVIEW_HIGHLIGHTDATES) {
            this.n = jSONObject;
        } else {
            super.onSetMapAttribute(j2, jSONObject);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetStringAttribute(long j2, String str) {
        if (j2 == DXCALENDARVIEW_ANCHORDATE) {
            this.a = str;
        } else if (j2 == DXCALENDARVIEW_BEGINDATE) {
            this.c = str;
        } else if (j2 == DXCALENDARVIEW_ENDDATE) {
            this.f = str;
        } else if (j2 == 34149272427L) {
            this.g = str;
        } else if (j2 == DXCALENDARVIEW_SELECTEDDATE) {
            this.i = str;
        } else {
            super.onSetStringAttribute(j2, str);
        }
    }
}
