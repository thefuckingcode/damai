package cn.damai.category.category.ui.view;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.category.category.ui.adapter.CitySelectAdapter;
import cn.damai.common.askpermission.OnGrantListener;
import cn.damai.commonbusiness.city.model.GroupsBean;
import cn.damai.commonbusiness.city.model.HotCityBean;
import cn.damai.commonbusiness.city.model.ManualBean;
import cn.damai.commonbusiness.city.model.SitesBean;
import cn.damai.commonbusiness.city.net.CityListResponse;
import cn.damai.commonbusiness.city.util.CityLocationUtil;
import cn.damai.commonbusiness.city.view.FloatingTitleDecoration;
import cn.damai.commonbusiness.city.view.LetterSortBar;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$string;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.ali.user.mobile.utils.ScreenUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.d20;
import tb.dv0;
import tb.hp1;
import tb.ji;
import tb.lp1;
import tb.v50;
import tb.xf2;

/* compiled from: Taobao */
public class CityView {
    private static transient /* synthetic */ IpChange $ipChange;
    private dv0 a;
    private int b;
    private View c;
    private View d;
    private Activity e;
    private DMIconFontTextView f;
    private TextView g;
    private List<String> h = new ArrayList();
    private Map<Integer, String> i = new HashMap();
    private List<ji> j = new ArrayList();
    private Map<String, String> k = new HashMap();
    private RecyclerView l;
    private CitySelectAdapter m;
    private CityLocationUtil n;
    private LetterSortBar o;
    private int p;
    private int q;
    private View.OnClickListener r;
    private ji s;
    private int t;
    private boolean u = false;
    private RecyclerView.OnScrollListener v = new RecyclerView.OnScrollListener() {
        /* class cn.damai.category.category.ui.view.CityView.AnonymousClass2 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1035593059")) {
                ipChange.ipc$dispatch("-1035593059", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                return;
            }
            super.onScrolled(recyclerView, i, i2);
            int findFirstVisibleItemPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
            if (CityView.this.u) {
                CityView.this.u = false;
                int i3 = CityView.this.t - findFirstVisibleItemPosition;
                if (i3 >= 0 && i3 < CityView.this.l.getChildCount()) {
                    CityView.this.l.scrollBy(0, CityView.this.l.getChildAt(i3).getTop() - CityView.this.p);
                }
            }
        }
    };
    private CitySelectAdapter.OnCityListItemClickListener2 w = new d();

    /* compiled from: Taobao */
    public class a implements LetterSortBar.OnTouchingLetterChangedListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.commonbusiness.city.view.LetterSortBar.OnTouchingLetterChangedListener
        public void onClickLetterChanged(String str, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "491977850")) {
                ipChange.ipc$dispatch("491977850", new Object[]{this, str, Integer.valueOf(i)});
                return;
            }
            int i2 = i + 1;
            try {
                if (i2 < xf2.e(CityView.this.j) - 1) {
                    CityView.this.v(i2);
                    return;
                }
                CityView cityView = CityView.this;
                cityView.v(xf2.e(cityView.j) - 1);
            } catch (Exception unused) {
            }
        }

        @Override // cn.damai.commonbusiness.city.view.LetterSortBar.OnTouchingLetterChangedListener
        public void onDraggingLetterChanged(String str, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1676051251")) {
                ipChange.ipc$dispatch("1676051251", new Object[]{this, str, Integer.valueOf(i)});
            } else if (i <= 0) {
                try {
                    CityView.this.v(0);
                } catch (Exception unused) {
                }
            } else {
                int i2 = i + 1;
                if (i2 < xf2.e(CityView.this.j) - 1) {
                    CityView.this.v(i2);
                    return;
                }
                CityView cityView = CityView.this;
                cityView.v(xf2.e(cityView.j) - 1);
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements OnGrantListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ boolean a;
        final /* synthetic */ ji b;

        b(boolean z, ji jiVar) {
            this.a = z;
            this.b = jiVar;
        }

        @Override // cn.damai.common.askpermission.OnGrantListener
        public void onGranted() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1054876760")) {
                ipChange.ipc$dispatch("-1054876760", new Object[]{this});
                return;
            }
            if (!this.a) {
                CityView cityView = CityView.this;
                cityView.A(cityView.s, true);
            }
            CityView.this.t(this.b);
        }
    }

    /* compiled from: Taobao */
    public class c implements CityLocationUtil.LocaltionListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ji a;

        c(ji jiVar) {
            this.a = jiVar;
        }

        @Override // cn.damai.commonbusiness.city.util.CityLocationUtil.LocaltionListener
        public void onGetLocalFinsih() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1346462636")) {
                ipChange.ipc$dispatch("1346462636", new Object[]{this});
                return;
            }
            SitesBean sitesBean = new SitesBean();
            sitesBean.setCityId("852");
            sitesBean.setCityName("北京");
            this.a.f(sitesBean);
            this.a.c = 136;
            CityView.this.m.i(d20.d());
        }

        @Override // cn.damai.commonbusiness.city.util.CityLocationUtil.LocaltionListener
        public void onGetLocalSuccess(SitesBean sitesBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1062160824")) {
                ipChange.ipc$dispatch("-1062160824", new Object[]{this, sitesBean});
                return;
            }
            SitesBean sitesBean2 = new SitesBean();
            sitesBean2.setCityId(sitesBean.getCityId());
            sitesBean2.setCityName(sitesBean.getCityName());
            this.a.f(sitesBean2);
            this.a.c = 136;
            CityView.this.m.i(d20.d());
        }
    }

    /* compiled from: Taobao */
    public class d implements CitySelectAdapter.OnCityListItemClickListener2 {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // cn.damai.category.category.ui.adapter.CitySelectAdapter.OnCityListItemClickListener2
        public void onGroupCityClick(int i, String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1350960108")) {
                ipChange.ipc$dispatch("1350960108", new Object[]{this, Integer.valueOf(i), str, str2});
                return;
            }
            CityView.this.x(2, i, str, str2);
        }

        @Override // cn.damai.category.category.ui.adapter.CitySelectAdapter.OnCityListItemClickListener2
        public void onHotCityClick(int i, String str, String str2, String str3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "283989288")) {
                ipChange.ipc$dispatch("283989288", new Object[]{this, Integer.valueOf(i), str, str2, str3});
                return;
            }
            CityView.this.x(1, i, str2, str);
        }

        @Override // cn.damai.category.category.ui.adapter.CitySelectAdapter.OnCityListItemClickListener2
        public void onLocationCityClick(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1946723821")) {
                ipChange.ipc$dispatch("1946723821", new Object[]{this, str, str2});
                return;
            }
            CityView.this.x(0, 0, str, str2);
        }

        @Override // cn.damai.category.category.ui.adapter.CitySelectAdapter.OnCityListItemClickListener2
        public void onRequestLocationPermission() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1627475918")) {
                ipChange.ipc$dispatch("1627475918", new Object[]{this});
                return;
            }
            CityView.this.o(true);
        }
    }

    /* compiled from: Taobao */
    public class e implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1647664058")) {
                ipChange.ipc$dispatch("1647664058", new Object[]{this, view});
                return;
            }
            CityView.this.q();
            if (CityView.this.r != null) {
                CityView.this.r.onClick(view);
            }
        }
    }

    public CityView(Activity activity, int i2, View view, View view2, View view3) {
        this.e = activity;
        this.q = i2;
        TextView textView = (TextView) view;
        this.g = textView;
        textView.setText(d20.d());
        this.c = view2;
        this.d = view3;
        this.b = (int) (((double) this.q) * 0.65d);
        u();
        s();
        this.a = dv0.b(this.e, view2, this.b);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void A(ji jiVar, boolean z) {
        CitySelectAdapter citySelectAdapter;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "564209598")) {
            ipChange.ipc$dispatch("564209598", new Object[]{this, jiVar, Boolean.valueOf(z)});
        } else if (jiVar != null) {
            if (hp1.i(lp1.LOCATION)) {
                jiVar.c = 119;
            } else {
                jiVar.c = 102;
            }
            if (z && (citySelectAdapter = this.m) != null) {
                citySelectAdapter.notifyDataSetChanged();
            }
        }
    }

    private void n(ji jiVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1198539419")) {
            ipChange.ipc$dispatch("1198539419", new Object[]{this, jiVar});
            return;
        }
        String[] strArr = lp1.LOCATION;
        hp1.b(this.e, false, strArr, "才能定位到当前所在城市～", new b(hp1.i(strArr), jiVar));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void o(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1966064314")) {
            ipChange.ipc$dispatch("-1966064314", new Object[]{this, Boolean.valueOf(z)});
        } else if (this.s != null) {
            if (hp1.i(lp1.LOCATION) || z) {
                n(this.s);
            }
        }
    }

    private void s() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "572252212")) {
            ipChange.ipc$dispatch("572252212", new Object[]{this});
            return;
        }
        LetterSortBar letterSortBar = (LetterSortBar) this.c.findViewById(R$id.city_select_sort_letter);
        this.o = letterSortBar;
        ViewGroup.LayoutParams layoutParams = letterSortBar.getLayoutParams();
        layoutParams.height = this.b - ScreenUtil.dip2px(this.e, 43.0f);
        this.o.setLayoutParams(layoutParams);
        this.o.setOnTouchingLetterChangedListener(new a());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void t(ji jiVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-586653914")) {
            ipChange.ipc$dispatch("-586653914", new Object[]{this, jiVar});
            return;
        }
        CityLocationUtil cityLocationUtil = new CityLocationUtil(this.e, new c(jiVar));
        this.n = cityLocationUtil;
        cityLocationUtil.p(true);
        this.n.n();
    }

    private void u() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1391891971")) {
            ipChange.ipc$dispatch("1391891971", new Object[]{this});
            return;
        }
        this.p = v50.a(this.e, 40.0f);
        this.l = (RecyclerView) this.c.findViewById(R$id.city_select_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.e);
        linearLayoutManager.setOrientation(1);
        this.l.setLayoutManager(linearLayoutManager);
        CitySelectAdapter citySelectAdapter = new CitySelectAdapter(this.e, this.j);
        this.m = citySelectAdapter;
        citySelectAdapter.h(this.w);
        this.l.setAdapter(this.m);
        this.l.addOnScrollListener(this.v);
        ViewGroup.LayoutParams layoutParams = this.l.getLayoutParams();
        layoutParams.height = this.b;
        this.l.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void v(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1714031393")) {
            ipChange.ipc$dispatch("1714031393", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        this.t = i2;
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.l.getLayoutManager();
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        if (i2 <= findFirstVisibleItemPosition) {
            this.l.scrollToPosition(i2);
        } else if (i2 <= findLastVisibleItemPosition) {
            this.l.scrollBy(0, this.l.getChildAt(i2 - findFirstVisibleItemPosition).getTop() - this.p);
        } else {
            this.l.scrollToPosition(i2);
            this.u = true;
        }
    }

    public boolean p() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-560007945")) {
            return this.c.getVisibility() == 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("-560007945", new Object[]{this})).booleanValue();
    }

    public void q() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "837847396")) {
            ipChange.ipc$dispatch("837847396", new Object[]{this});
        } else if (this.f != null) {
            this.d.setVisibility(8);
            this.c.setVisibility(8);
            this.f.setText(this.e.getText(R$string.iconfont_shaixuanxia12));
        }
    }

    public void r(CityListResponse cityListResponse) {
        List<SitesBean> sites;
        int e2;
        IpChange ipChange = $ipChange;
        int i2 = 1;
        if (AndroidInstantRuntime.support(ipChange, "-499334611")) {
            ipChange.ipc$dispatch("-499334611", new Object[]{this, cityListResponse});
        } else if (cityListResponse != null) {
            this.h.clear();
            this.i.clear();
            this.j.clear();
            this.k.clear();
            RecyclerView recyclerView = this.l;
            if (recyclerView != null) {
                try {
                    recyclerView.removeAllViews();
                    for (int itemDecorationCount = this.l.getItemDecorationCount() - 1; itemDecorationCount >= 0; itemDecorationCount--) {
                        this.l.removeItemDecorationAt(itemDecorationCount);
                    }
                } catch (Exception unused) {
                }
            }
            this.i.put(0, "当前定位城市");
            ji jiVar = new ji(0);
            this.s = jiVar;
            A(jiVar, false);
            this.j.add(this.s);
            List<HotCityBean> hotCity = cityListResponse.getHotCity();
            int e3 = xf2.e(hotCity);
            if (e3 > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < e3; i3++) {
                    HotCityBean hotCityBean = hotCity.get(i3);
                    if (TextUtils.getTrimmedLength(hotCityBean.getCityId()) > 0 && TextUtils.getTrimmedLength(hotCityBean.getCityName()) > 0 && TextUtils.getTrimmedLength(hotCityBean.getUrl()) > 0) {
                        arrayList.add(hotCityBean);
                    }
                }
                HotCityBean hotCityBean2 = new HotCityBean();
                hotCityBean2.setCityId("0");
                hotCityBean2.setCityName("全部城市");
                arrayList.add(hotCityBean2);
                if (xf2.e(arrayList) > 0) {
                    this.i.put(1, "热门城市");
                    this.h.add("热");
                    ji jiVar2 = new ji(1);
                    jiVar2.e(arrayList);
                    this.j.add(jiVar2);
                    i2 = 2;
                }
            }
            List<GroupsBean> groups = cityListResponse.getGroups();
            int e4 = xf2.e(groups);
            if (e4 > 0) {
                for (int i4 = 0; i4 < e4; i4++) {
                    GroupsBean groupsBean = groups.get(i4);
                    if (groupsBean != null && (e2 = xf2.e((sites = groupsBean.getSites()))) > 0) {
                        ArrayList arrayList2 = new ArrayList();
                        for (int i5 = 0; i5 < e2; i5++) {
                            SitesBean sitesBean = sites.get(i5);
                            if (sitesBean != null && TextUtils.getTrimmedLength(sitesBean.getCityId()) > 0 && TextUtils.getTrimmedLength(sitesBean.getCityName()) > 0) {
                                arrayList2.add(sitesBean);
                            }
                        }
                        if (xf2.e(arrayList2) > 0) {
                            int i6 = i2 + 1;
                            this.i.put(Integer.valueOf(i2), groupsBean.getSpellCode());
                            this.h.add(groupsBean.getSpellCode());
                            ji jiVar3 = new ji(2);
                            jiVar3.g(arrayList2);
                            this.j.add(jiVar3);
                            i2 = i6;
                        }
                    }
                }
            }
            List<ManualBean> manual = cityListResponse.getManual();
            int e5 = xf2.e(manual);
            if (e5 > 0) {
                for (int i7 = 0; i7 < e5; i7++) {
                    ManualBean manualBean = manual.get(i7);
                    if (manualBean != null && !TextUtils.isEmpty(manualBean.getCityId().trim()) && !TextUtils.isEmpty(manualBean.getUrl().trim())) {
                        this.k.put(manualBean.getCityId(), manualBean.getUrl());
                    }
                }
            }
            FloatingTitleDecoration floatingTitleDecoration = new FloatingTitleDecoration(this.e);
            floatingTitleDecoration.d(this.i);
            floatingTitleDecoration.c(this.p);
            this.l.addItemDecoration(floatingTitleDecoration);
            this.o.setLetters(this.h);
            this.m.notifyDataSetChanged();
            o(false);
        }
    }

    public boolean w(int i2, int i3, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "451693741")) {
            return ((Boolean) ipChange.ipc$dispatch("451693741", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3), intent})).booleanValue();
        } else if (i2 != 2168) {
            return false;
        } else {
            A(this.s, true);
            o(false);
            return true;
        }
    }

    public void x(int i2, int i3, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-880867503")) {
            ipChange.ipc$dispatch("-880867503", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3), str, str2});
            return;
        }
        this.g.setText(str2);
        q();
    }

    public void y(View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1888232483")) {
            ipChange.ipc$dispatch("-1888232483", new Object[]{this, onClickListener});
            return;
        }
        this.r = onClickListener;
    }

    public void z(DMIconFontTextView dMIconFontTextView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "429334156")) {
            ipChange.ipc$dispatch("429334156", new Object[]{this, dMIconFontTextView});
            return;
        }
        this.f = dMIconFontTextView;
        if (this.c.getVisibility() == 0) {
            this.d.setVisibility(8);
            q();
            dMIconFontTextView.setText(this.e.getText(R$string.iconfont_shaixuanxia12));
            return;
        }
        this.d.setOnClickListener(new e());
        this.c.setVisibility(0);
        this.a.d(250);
        dMIconFontTextView.setText(this.e.getText(R$string.iconfont_shaixuanshang12));
        this.d.setVisibility(0);
        this.m.notifyDataSetChanged();
    }
}
