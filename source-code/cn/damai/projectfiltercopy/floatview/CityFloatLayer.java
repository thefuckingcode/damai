package cn.damai.projectfiltercopy.floatview;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.citycopy.adapter.CitySelectAdapter;
import cn.damai.commonbusiness.citycopy.listener.OnCityListItemClickListener;
import cn.damai.commonbusiness.citycopy.model.GroupsBean;
import cn.damai.commonbusiness.citycopy.model.HotCityBean;
import cn.damai.commonbusiness.citycopy.model.ManualBean;
import cn.damai.commonbusiness.citycopy.model.SitesBean;
import cn.damai.commonbusiness.citycopy.net.CityListResponse;
import cn.damai.commonbusiness.citycopy.util.CityLocationUtil;
import cn.damai.commonbusiness.citycopy.view.FloatingTitleDecoration;
import cn.damai.commonbusiness.citycopy.view.LetterSortBar;
import cn.damai.projectfiltercopy.bean.CityBean;
import cn.damai.projectfiltercopy.bean.FilterData;
import cn.damai.projectfiltercopy.bean.Type;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.bricks.channel.bridge.OnBizListener;
import com.alibaba.pictures.picpermission.Permission;
import com.alibaba.pictures.picpermission.custom.IPermissionListener;
import com.alibaba.pictures.picpermission.manage.PermissionModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import tb.e92;
import tb.ii;
import tb.jp1;
import tb.kp1;
import tb.l42;
import tb.nl;
import tb.wm2;

/* compiled from: Taobao */
public class CityFloatLayer extends a<CityBean> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String FILTER_CITY_CACHED_LASTTIME = "filter_city_cached_lasttime";
    View d;
    long e;
    String f;
    private List<String> g = new ArrayList();
    private Map<Integer, String> h = new HashMap();
    private List<ii> i = new ArrayList();
    private Map<String, String> j = new HashMap();
    private Map<String, String> k = new HashMap();
    private RecyclerView l;
    private CitySelectAdapter m;
    private CityLocationUtil n;
    private LetterSortBar o;
    private int p;
    private ii q;

    /* compiled from: Taobao */
    public class a implements OnCityListItemClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.commonbusiness.citycopy.listener.OnCityListItemClickListener
        public void onGroupCityClick(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1480291699")) {
                ipChange.ipc$dispatch("1480291699", new Object[]{this, str, str2});
                return;
            }
            CityFloatLayer.this.s(str, str2);
        }

        @Override // cn.damai.commonbusiness.citycopy.listener.OnCityListItemClickListener
        public void onHotCityClick(String str, String str2, String str3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "221064395")) {
                ipChange.ipc$dispatch("221064395", new Object[]{this, str, str2, str3});
                return;
            }
            CityFloatLayer.this.s(str2, str);
        }

        @Override // cn.damai.commonbusiness.citycopy.listener.OnCityListItemClickListener
        public void onLocationCityClick(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1579272935")) {
                ipChange.ipc$dispatch("-1579272935", new Object[]{this, str, str2});
                return;
            }
            CityFloatLayer.this.s(str, str2);
        }

        @Override // cn.damai.commonbusiness.citycopy.listener.OnCityListItemClickListener
        public void onRequestLocationPermission() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2117277946")) {
                ipChange.ipc$dispatch("2117277946", new Object[]{this});
                return;
            }
            CityFloatLayer.this.j(true);
        }
    }

    /* compiled from: Taobao */
    public class b implements LetterSortBar.OnTouchingLetterChangedListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.commonbusiness.citycopy.view.LetterSortBar.OnTouchingLetterChangedListener
        public void onClickLetterChanged(String str, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "812758368")) {
                ipChange.ipc$dispatch("812758368", new Object[]{this, str, Integer.valueOf(i)});
                return;
            }
            int i2 = i + 1;
            try {
                if (i2 < e92.c(CityFloatLayer.this.i) - 1) {
                    CityFloatLayer.this.r(i2);
                    return;
                }
                CityFloatLayer cityFloatLayer = CityFloatLayer.this;
                cityFloatLayer.r(e92.c(cityFloatLayer.i) - 1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // cn.damai.commonbusiness.citycopy.view.LetterSortBar.OnTouchingLetterChangedListener
        public void onDraggingLetterChanged(String str, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1746229389")) {
                ipChange.ipc$dispatch("1746229389", new Object[]{this, str, Integer.valueOf(i)});
            } else if (i <= 0) {
                try {
                    CityFloatLayer.this.r(0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                int i2 = i + 1;
                if (i2 < e92.c(CityFloatLayer.this.i) - 1) {
                    CityFloatLayer.this.r(i2);
                    return;
                }
                CityFloatLayer cityFloatLayer = CityFloatLayer.this;
                cityFloatLayer.r(e92.c(cityFloatLayer.i) - 1);
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements IPermissionListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ boolean a;
        final /* synthetic */ ii b;

        /* compiled from: Taobao */
        public class a implements DialogInterface.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1370162510")) {
                    ipChange.ipc$dispatch("-1370162510", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                    return;
                }
                dialogInterface.dismiss();
                Context context = CityFloatLayer.this.a;
                if (context instanceof Activity) {
                    jp1.f((Activity) context);
                }
            }
        }

        /* compiled from: Taobao */
        public class b implements DialogInterface.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            b(c cVar) {
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-400581487")) {
                    ipChange.ipc$dispatch("-400581487", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                    return;
                }
                dialogInterface.dismiss();
            }
        }

        c(boolean z, ii iiVar) {
            this.a = z;
            this.b = iiVar;
        }

        @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
        public void onPermissionDenied(@NotNull String[] strArr) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-177337559")) {
                ipChange.ipc$dispatch("-177337559", new Object[]{this, strArr});
            }
        }

        @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
        public void onPermissionGranted() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1704267234")) {
                ipChange.ipc$dispatch("-1704267234", new Object[]{this});
                return;
            }
            if (!this.a) {
                CityFloatLayer.this.w(this.b, true);
            }
            CityFloatLayer.this.o(this.b);
        }

        @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
        public void onShowRationale(@NotNull String[] strArr) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1839563313")) {
                ipChange.ipc$dispatch("-1839563313", new Object[]{this, strArr});
                return;
            }
            nl.INSTANCE.a().showPermissionDialog(CityFloatLayer.this.a, "获取你所在城市的演出赛事信息，帮助你找到附近的演出赛事", Arrays.asList(strArr), false, new a(), new b(this));
        }
    }

    /* compiled from: Taobao */
    public class d implements CityLocationUtil.LocaltionListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ii a;

        d(ii iiVar) {
            this.a = iiVar;
        }

        @Override // cn.damai.commonbusiness.citycopy.util.CityLocationUtil.LocaltionListener
        public void onGetLocalFinsih() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1312187323")) {
                ipChange.ipc$dispatch("-1312187323", new Object[]{this});
                return;
            }
            SitesBean sitesBean = new SitesBean();
            sitesBean.setCityId("852");
            sitesBean.setCityName("北京");
            this.a.f(sitesBean);
            this.a.c = 136;
            CityFloatLayer.this.m.notifyDataSetChanged();
        }

        @Override // cn.damai.commonbusiness.citycopy.util.CityLocationUtil.LocaltionListener
        public void onGetLocalSuccess(SitesBean sitesBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-474431494")) {
                ipChange.ipc$dispatch("-474431494", new Object[]{this, sitesBean});
                return;
            }
            SitesBean sitesBean2 = new SitesBean();
            sitesBean2.setCityId(sitesBean.getCityId());
            sitesBean2.setCityName(sitesBean.getCityName());
            this.a.f(sitesBean2);
            this.a.c = 136;
            CityFloatLayer.this.m.notifyDataSetChanged();
        }
    }

    /* compiled from: Taobao */
    public class e implements OnBizListener<CityListResponse> {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        /* renamed from: a */
        public void onBizSuccess(CityListResponse cityListResponse) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "444451341")) {
                ipChange.ipc$dispatch("444451341", new Object[]{this, cityListResponse});
                return;
            }
            if (cityListResponse != null) {
                try {
                    CityFloatLayer.this.m(cityListResponse);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            nl.INSTANCE.a().saveSpValue("filter_city_cached_lasttime", String.valueOf(System.currentTimeMillis()));
        }

        @Override // com.alibaba.pictures.bricks.channel.bridge.OnBizListener
        public void onBizFail(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "550014635")) {
                ipChange.ipc$dispatch("550014635", new Object[]{this, str, str2});
                return;
            }
            CityFloatLayer cityFloatLayer = CityFloatLayer.this;
            cityFloatLayer.q(cityFloatLayer.a);
        }
    }

    public CityFloatLayer(Context context) {
        super(context);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void j(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "922757870")) {
            ipChange.ipc$dispatch("922757870", new Object[]{this, Boolean.valueOf(z)});
        } else if (this.q != null) {
            if (z || wm2.INSTANCE.e(this.a)) {
                u(this.q);
            }
        }
    }

    private void k(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1692341805")) {
            ipChange.ipc$dispatch("1692341805", new Object[]{this, context});
        } else if (this.d == null) {
            View inflate = LayoutInflater.from(context).inflate(R$layout.copy_activity_city_select, (ViewGroup) null, false);
            this.d = inflate;
            inflate.findViewById(R$id.city_select_navtitle).setVisibility(8);
            this.p = l42.a(this.a, 40.0f);
            n();
            p();
            String spValue = nl.INSTANCE.a().getSpValue("filter_city_cached_lasttime");
            if (TextUtils.isEmpty(spValue)) {
                t();
                return;
            }
            try {
                if (System.currentTimeMillis() - Long.parseLong(spValue) > 86400000) {
                    t();
                    return;
                }
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            }
            q(context);
        }
    }

    private View l(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-89944186")) {
            return (View) ipChange.ipc$dispatch("-89944186", new Object[]{this, Integer.valueOf(i2)});
        }
        View view = this.d;
        if (view != null) {
            return view.findViewById(i2);
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void m(CityListResponse cityListResponse) {
        List<SitesBean> sites;
        int c2;
        IpChange ipChange = $ipChange;
        int i2 = 1;
        if (AndroidInstantRuntime.support(ipChange, "1755015754")) {
            ipChange.ipc$dispatch("1755015754", new Object[]{this, cityListResponse});
            return;
        }
        this.h.clear();
        this.i.clear();
        this.j.clear();
        this.h.put(0, "当前定位城市");
        ii iiVar = new ii(0);
        this.q = iiVar;
        w(iiVar, false);
        this.i.add(this.q);
        List<HotCityBean> hotCity = cityListResponse.getHotCity();
        int c3 = e92.c(hotCity);
        if (c3 > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < c3; i3++) {
                HotCityBean hotCityBean = hotCity.get(i3);
                if (TextUtils.getTrimmedLength(hotCityBean.getCityId()) > 0 && TextUtils.getTrimmedLength(hotCityBean.getCityName()) > 0 && TextUtils.getTrimmedLength(hotCityBean.getUrl()) > 0) {
                    arrayList.add(hotCityBean);
                    this.k.put(hotCityBean.getCityId(), hotCityBean.getUrl());
                }
            }
            if (e92.c(arrayList) > 0) {
                this.h.put(1, "热门城市");
                this.g.add("热");
                ii iiVar2 = new ii(1);
                iiVar2.e(arrayList);
                this.i.add(iiVar2);
                i2 = 2;
            }
        }
        List<GroupsBean> groups = cityListResponse.getGroups();
        int c4 = e92.c(groups);
        if (c4 > 0) {
            for (int i4 = 0; i4 < c4; i4++) {
                GroupsBean groupsBean = groups.get(i4);
                if (groupsBean != null && (c2 = e92.c((sites = groupsBean.getSites()))) > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i5 = 0; i5 < c2; i5++) {
                        SitesBean sitesBean = sites.get(i5);
                        if (sitesBean != null && TextUtils.getTrimmedLength(sitesBean.getCityId()) > 0 && TextUtils.getTrimmedLength(sitesBean.getCityName()) > 0) {
                            arrayList2.add(sitesBean);
                        }
                    }
                    if (e92.c(arrayList2) > 0) {
                        int i6 = i2 + 1;
                        this.h.put(Integer.valueOf(i2), groupsBean.getSpellCode());
                        this.g.add(groupsBean.getSpellCode());
                        ii iiVar3 = new ii(2);
                        iiVar3.g(arrayList2);
                        this.i.add(iiVar3);
                        i2 = i6;
                    }
                }
            }
        }
        List<ManualBean> manual = cityListResponse.getManual();
        int c5 = e92.c(manual);
        if (c5 > 0) {
            for (int i7 = 0; i7 < c5; i7++) {
                ManualBean manualBean = manual.get(i7);
                if (manualBean != null && !TextUtils.isEmpty(manualBean.getCityId().trim()) && !TextUtils.isEmpty(manualBean.getUrl().trim())) {
                    this.j.put(manualBean.getCityId(), manualBean.getUrl());
                }
            }
        }
        FloatingTitleDecoration floatingTitleDecoration = new FloatingTitleDecoration(this.a);
        floatingTitleDecoration.d(this.h);
        floatingTitleDecoration.c(this.p);
        this.l.addItemDecoration(floatingTitleDecoration);
        this.o.setLetters(this.g);
        this.m.notifyDataSetChanged();
        j(false);
    }

    private void n() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-800590372")) {
            ipChange.ipc$dispatch("-800590372", new Object[]{this});
            return;
        }
        LetterSortBar letterSortBar = (LetterSortBar) l(R$id.city_select_sort_letter);
        this.o = letterSortBar;
        letterSortBar.setOnTouchingLetterChangedListener(new b());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void o(ii iiVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1875192727")) {
            ipChange.ipc$dispatch("-1875192727", new Object[]{this, iiVar});
            return;
        }
        CityLocationUtil cityLocationUtil = new CityLocationUtil(this.a, new d(iiVar));
        this.n = cityLocationUtil;
        cityLocationUtil.o(true);
        this.n.m();
    }

    private void p() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2040343387")) {
            ipChange.ipc$dispatch("2040343387", new Object[]{this});
            return;
        }
        this.l = (RecyclerView) l(R$id.city_select_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.a);
        linearLayoutManager.setOrientation(1);
        this.l.setLayoutManager(linearLayoutManager);
        CitySelectAdapter citySelectAdapter = new CitySelectAdapter(this.a, this.i);
        this.m = citySelectAdapter;
        citySelectAdapter.g(new a());
        this.l.setAdapter(this.m);
        this.l.addOnScrollListener(new RecyclerView.OnScrollListener(this) {
            /* class cn.damai.projectfiltercopy.floatview.CityFloatLayer.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1358453402")) {
                    ipChange.ipc$dispatch("1358453402", new Object[]{this, recyclerView, Integer.valueOf(i)});
                    return;
                }
                super.onScrollStateChanged(recyclerView, i);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1091921989")) {
                    ipChange.ipc$dispatch("1091921989", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                    return;
                }
                super.onScrolled(recyclerView, i, i2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void q(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2125637431")) {
            ipChange.ipc$dispatch("-2125637431", new Object[]{this, context});
            return;
        }
        try {
            CityListResponse localCityList = nl.INSTANCE.a().getLocalCityList();
            if (localCityList != null) {
                m(localCityList);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void r(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2144376119")) {
            ipChange.ipc$dispatch("-2144376119", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.l.getLayoutManager();
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        if (i2 <= findFirstVisibleItemPosition) {
            this.l.scrollToPosition(i2);
        } else if (i2 <= findLastVisibleItemPosition) {
            this.l.scrollBy(0, this.l.getChildAt(i2 - findFirstVisibleItemPosition).getTop() - this.p);
        } else {
            this.l.scrollToPosition(i2);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void s(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1424466309")) {
            ipChange.ipc$dispatch("1424466309", new Object[]{this, str, str2});
            return;
        }
        FilterData filterData = new FilterData();
        filterData.mCityBean = new CityBean(str2, str);
        getListener().onFloatCall(getType(), filterData);
        this.f = str2;
        CitySelectAdapter citySelectAdapter = this.m;
        if (citySelectAdapter != null) {
            citySelectAdapter.h(str2);
        }
        getFilterUt().g(str2);
    }

    private void t() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1900377027")) {
            ipChange.ipc$dispatch("1900377027", new Object[]{this});
            return;
        }
        nl.INSTANCE.a().requestCityList(new e());
    }

    private void u(ii iiVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-245743658")) {
            ipChange.ipc$dispatch("-245743658", new Object[]{this, iiVar});
            return;
        }
        boolean e2 = wm2.INSTANCE.e(this.a);
        new Permission(this.a, new PermissionModel(kp1.a, "位置权限使用说明", Integer.valueOf(R$drawable.permission_location_icon), "用于为你提供所在城市演出和场馆信息及帮助你找到附近的演出")).a(new c(e2, iiVar)).b();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void w(ii iiVar, boolean z) {
        CitySelectAdapter citySelectAdapter;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "148567771")) {
            ipChange.ipc$dispatch("148567771", new Object[]{this, iiVar, Boolean.valueOf(z)});
        } else if (iiVar != null && iiVar.d() == 0) {
            if (wm2.INSTANCE.e(this.a)) {
                iiVar.c = 119;
            } else {
                iiVar.c = 102;
            }
            if (z && (citySelectAdapter = this.m) != null) {
                citySelectAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override // cn.damai.projectfiltercopy.floatview.FloatLayer
    public Type getType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1704075195")) {
            return Type.CITY;
        }
        return (Type) ipChange.ipc$dispatch("-1704075195", new Object[]{this});
    }

    @Override // cn.damai.projectfiltercopy.floatview.FloatLayer
    public View getView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1543992418")) {
            return (View) ipChange.ipc$dispatch("1543992418", new Object[]{this});
        }
        k(this.a);
        return this.d;
    }

    @Override // cn.damai.projectfiltercopy.floatview.FloatLayer
    public void hide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-525948147")) {
            ipChange.ipc$dispatch("-525948147", new Object[]{this});
            return;
        }
        getFilterUt().r(this.e, this.f);
    }

    /* renamed from: v */
    public void show(@Nullable CityBean cityBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1962727499")) {
            ipChange.ipc$dispatch("1962727499", new Object[]{this, cityBean});
            return;
        }
        k(this.a);
        CitySelectAdapter citySelectAdapter = this.m;
        if (!(citySelectAdapter == null || cityBean == null)) {
            citySelectAdapter.h(cityBean.cityName);
            this.m.notifyDataSetChanged();
            this.f = cityBean.cityName;
        }
        this.e = System.currentTimeMillis();
    }
}
