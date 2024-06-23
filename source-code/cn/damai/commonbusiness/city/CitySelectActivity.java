package cn.damai.commonbusiness.city;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.DamaiConstants;
import cn.damai.common.app.ShareperfenceConstants;
import cn.damai.common.nav.DMNav;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.city.adapter.CitySelectAdapter;
import cn.damai.commonbusiness.city.bean.CityParam;
import cn.damai.commonbusiness.city.listener.OnCityListItemClickListener;
import cn.damai.commonbusiness.city.model.GroupsBean;
import cn.damai.commonbusiness.city.model.HotCityBean;
import cn.damai.commonbusiness.city.model.ManualBean;
import cn.damai.commonbusiness.city.model.SitesBean;
import cn.damai.commonbusiness.city.net.CityListRequest;
import cn.damai.commonbusiness.city.net.CityListResponse;
import cn.damai.commonbusiness.city.util.CityLocationUtil;
import cn.damai.commonbusiness.city.view.FloatingTitleDecoration;
import cn.damai.commonbusiness.city.view.LetterSortBar;
import com.alibaba.fastjson.JSON;
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
import tb.br;
import tb.d20;
import tb.fp1;
import tb.g91;
import tb.gi;
import tb.hp1;
import tb.ji;
import tb.jp1;
import tb.jq2;
import tb.lp1;
import tb.pp2;
import tb.v50;
import tb.wk;
import tb.xf2;
import tb.xs0;

/* compiled from: Taobao */
public class CitySelectActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String CITY_ID = "ex_city_id";
    public static final String CITY_NAME = "ex_city_name";
    public static final String OBTAIN_CITY_PARAM = "extra_obtain_city_param";
    private CitySelectAdapter mAdapter;
    private RecyclerView mCityList;
    private List<ji> mCityListData = new ArrayList();
    private CityLocationUtil mCityLocationUtil;
    private CityParam mExtraCity;
    private Map<String, String> mGroupCityListManualMap = new HashMap();
    private Map<String, String> mHotCityListManualMap = new HashMap();
    private int mIndex;
    private List<String> mLetterIndexList = new ArrayList();
    private LetterSortBar mLetterSortBar;
    private ji mLocationCityHolder;
    private boolean mMoveAgain = false;
    private OnCityListItemClickListener mOnCityListItemClickListener = new a();
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() {
        /* class cn.damai.commonbusiness.city.CitySelectActivity.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2087776039")) {
                ipChange.ipc$dispatch("2087776039", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                return;
            }
            super.onScrolled(recyclerView, i, i2);
            int findFirstVisibleItemPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
            if (CitySelectActivity.this.mMoveAgain) {
                CitySelectActivity.this.mMoveAgain = false;
                int i3 = CitySelectActivity.this.mIndex - findFirstVisibleItemPosition;
                if (i3 >= 0 && i3 < CitySelectActivity.this.mCityList.getChildCount()) {
                    CitySelectActivity.this.mCityList.scrollBy(0, CitySelectActivity.this.mCityList.getChildAt(i3).getTop() - CitySelectActivity.this.mSectionTitleHeight);
                }
            }
        }
    };
    private Map<Integer, String> mSectionTitle = new HashMap();
    private int mSectionTitleHeight;

    /* compiled from: Taobao */
    public class a implements OnCityListItemClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.commonbusiness.city.listener.OnCityListItemClickListener
        public void onGroupCityClick(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1024050003")) {
                ipChange.ipc$dispatch("1024050003", new Object[]{this, str, str2});
                return;
            }
            cn.damai.common.user.c.e().x(wk.j().f(str2));
            if (!CitySelectActivity.this.trySetCityResultAndFinish(str, str2)) {
                if (CitySelectActivity.this.mGroupCityListManualMap.size() > 0 && CitySelectActivity.this.mGroupCityListManualMap.containsKey(str) && !((String) CitySelectActivity.this.mGroupCityListManualMap.get(str)).contains(pp2.SCHEME_HOMEPAGE)) {
                    DMNav.from(CitySelectActivity.this.mContext).toUri((String) CitySelectActivity.this.mGroupCityListManualMap.get(str));
                    CitySelectActivity.this.finish();
                } else if (TextUtils.getTrimmedLength(d20.c()) <= 0 || !d20.c().equals(str)) {
                    d20.c0(str);
                    d20.f0(str2);
                    d20.g0();
                    xs0.b = (long) new Integer(str).intValue();
                    xs0.c = str2;
                    br.c(DamaiConstants.CITY_CHANGED, "");
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str.trim())) {
                        CitySelectActivity.this.setResult(-1, null);
                        CitySelectActivity.this.finish();
                    }
                } else {
                    CitySelectActivity.this.finish();
                }
            }
        }

        @Override // cn.damai.commonbusiness.city.listener.OnCityListItemClickListener
        public void onHotCityClick(String str, String str2, String str3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1113832107")) {
                ipChange.ipc$dispatch("1113832107", new Object[]{this, str, str2, str3});
            } else if (!CitySelectActivity.this.trySetCityResultAndFinish(str2, str)) {
                if (TextUtils.isEmpty(str3) || !str3.contains(pp2.SCHEME_HOMEPAGE)) {
                    cn.damai.common.user.c.e().x(wk.j().f(str));
                    DMNav.from(CitySelectActivity.this.mContext).toUri(str3);
                    CitySelectActivity.this.finish();
                } else if (TextUtils.getTrimmedLength(d20.c()) <= 0 || !d20.c().equals(str2)) {
                    d20.c0(str2);
                    d20.f0(str);
                    d20.g0();
                    xs0.b = (long) new Integer(str2).intValue();
                    xs0.c = str;
                    br.c(DamaiConstants.CITY_CHANGED, "");
                    if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str2.trim())) {
                        CitySelectActivity.this.setResult(-1, null);
                        CitySelectActivity.this.finish();
                    }
                } else {
                    CitySelectActivity.this.finish();
                }
            }
        }

        @Override // cn.damai.commonbusiness.city.listener.OnCityListItemClickListener
        public void onLocationCityClick(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "95853369")) {
                ipChange.ipc$dispatch("95853369", new Object[]{this, str, str2});
                return;
            }
            cn.damai.common.user.c.e().x(wk.j().f(str2));
            if (!CitySelectActivity.this.trySetCityResultAndFinish(str, str2)) {
                if (CitySelectActivity.this.mHotCityListManualMap.size() > 0 && CitySelectActivity.this.mHotCityListManualMap.containsKey(str) && !((String) CitySelectActivity.this.mHotCityListManualMap.get(str)).contains(pp2.SCHEME_HOMEPAGE)) {
                    DMNav.from(CitySelectActivity.this.mContext).toUri((String) CitySelectActivity.this.mHotCityListManualMap.get(str));
                    CitySelectActivity.this.finish();
                } else if (CitySelectActivity.this.mGroupCityListManualMap.size() > 0 && CitySelectActivity.this.mGroupCityListManualMap.containsKey(str) && !((String) CitySelectActivity.this.mGroupCityListManualMap.get(str)).contains(pp2.SCHEME_HOMEPAGE)) {
                    DMNav.from(CitySelectActivity.this.mContext).toUri((String) CitySelectActivity.this.mGroupCityListManualMap.get(str));
                    CitySelectActivity.this.finish();
                } else if (TextUtils.getTrimmedLength(d20.c()) <= 0 || !d20.c().equals(str)) {
                    d20.c0(str);
                    d20.f0(str2);
                    d20.g0();
                    xs0.b = xf2.m(str, 0);
                    xs0.c = str2;
                    br.c(DamaiConstants.CITY_CHANGED, "");
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str.trim())) {
                        CitySelectActivity.this.setResult(-1, null);
                        CitySelectActivity.this.finish();
                    }
                } else {
                    CitySelectActivity.this.finish();
                }
            }
        }

        @Override // cn.damai.commonbusiness.city.listener.OnCityListItemClickListener
        public void onRequestLocationPermission() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "587984666")) {
                ipChange.ipc$dispatch("587984666", new Object[]{this});
                return;
            }
            CitySelectActivity.this.dispatchLocationChecking(true);
        }
    }

    /* compiled from: Taobao */
    public class b implements LetterSortBar.OnTouchingLetterChangedListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.commonbusiness.city.view.LetterSortBar.OnTouchingLetterChangedListener
        public void onClickLetterChanged(String str, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-274543135")) {
                ipChange.ipc$dispatch("-274543135", new Object[]{this, str, Integer.valueOf(i)});
                return;
            }
            int i2 = i + 1;
            try {
                if (i2 < xf2.e(CitySelectActivity.this.mCityListData) - 1) {
                    CitySelectActivity.this.moveToPosition(i2);
                    return;
                }
                CitySelectActivity citySelectActivity = CitySelectActivity.this;
                citySelectActivity.moveToPosition(xf2.e(citySelectActivity.mCityListData) - 1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // cn.damai.commonbusiness.city.view.LetterSortBar.OnTouchingLetterChangedListener
        public void onDraggingLetterChanged(String str, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1704467348")) {
                ipChange.ipc$dispatch("-1704467348", new Object[]{this, str, Integer.valueOf(i)});
            } else if (i <= 0) {
                try {
                    CitySelectActivity.this.moveToPosition(0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                int i2 = i + 1;
                if (i2 < xf2.e(CitySelectActivity.this.mCityListData) - 1) {
                    CitySelectActivity.this.moveToPosition(i2);
                    return;
                }
                CitySelectActivity citySelectActivity = CitySelectActivity.this;
                citySelectActivity.moveToPosition(xf2.e(citySelectActivity.mCityListData) - 1);
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements IPermissionListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ boolean a;
        final /* synthetic */ ji b;

        /* compiled from: Taobao */
        public class a implements DialogInterface.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1208119086")) {
                    ipChange.ipc$dispatch("-1208119086", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                    return;
                }
                dialogInterface.dismiss();
                jp1.f(CitySelectActivity.this);
            }
        }

        /* compiled from: Taobao */
        public class b implements DialogInterface.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            b(c cVar) {
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-238538063")) {
                    ipChange.ipc$dispatch("-238538063", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                    return;
                }
                dialogInterface.dismiss();
            }
        }

        c(boolean z, ji jiVar) {
            this.a = z;
            this.b = jiVar;
        }

        @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
        public void onPermissionDenied(@NotNull String[] strArr) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "910801225")) {
                ipChange.ipc$dispatch("910801225", new Object[]{this, strArr});
            }
        }

        @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
        public void onPermissionGranted() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1811158978")) {
                ipChange.ipc$dispatch("-1811158978", new Object[]{this});
                return;
            }
            if (!this.a) {
                CitySelectActivity.this.updateLocationCityHolder(this.b, true);
            }
            CitySelectActivity.this.initLocation(this.b);
        }

        @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
        public void onShowRationale(@NotNull String[] strArr) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2111142993")) {
                ipChange.ipc$dispatch("-2111142993", new Object[]{this, strArr});
                return;
            }
            fp1.a(CitySelectActivity.this, "获取你所在城市的演出赛事信息，帮助你找到附近的演出赛事", Arrays.asList(strArr), false, new a(), new b(this));
        }
    }

    /* compiled from: Taobao */
    public class d implements CityLocationUtil.LocaltionListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ji a;

        d(ji jiVar) {
            this.a = jiVar;
        }

        @Override // cn.damai.commonbusiness.city.util.CityLocationUtil.LocaltionListener
        public void onGetLocalFinsih() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "941185573")) {
                ipChange.ipc$dispatch("941185573", new Object[]{this});
                return;
            }
            SitesBean sitesBean = new SitesBean();
            sitesBean.setCityId("852");
            sitesBean.setCityName("北京");
            this.a.f(sitesBean);
            this.a.c = 136;
            CitySelectActivity.this.mAdapter.notifyDataSetChanged();
        }

        @Override // cn.damai.commonbusiness.city.util.CityLocationUtil.LocaltionListener
        public void onGetLocalSuccess(SitesBean sitesBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-196312401")) {
                ipChange.ipc$dispatch("-196312401", new Object[]{this, sitesBean});
                return;
            }
            SitesBean sitesBean2 = new SitesBean();
            sitesBean2.setCityId(sitesBean.getCityId());
            sitesBean2.setCityName(sitesBean.getCityName());
            this.a.f(sitesBean2);
            this.a.c = 136;
            CitySelectActivity.this.mAdapter.notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void dispatchLocationChecking(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-330537617")) {
            ipChange.ipc$dispatch("-330537617", new Object[]{this, Boolean.valueOf(z)});
        } else if (this.mLocationCityHolder != null) {
            if (z || hp1.i(lp1.LOCATION)) {
                requestLocation(this.mLocationCityHolder);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void initData(CityListResponse cityListResponse) {
        List<SitesBean> sites;
        int e;
        IpChange ipChange = $ipChange;
        int i = 1;
        if (AndroidInstantRuntime.support(ipChange, "996515862")) {
            ipChange.ipc$dispatch("996515862", new Object[]{this, cityListResponse});
            return;
        }
        this.mSectionTitle.clear();
        this.mCityListData.clear();
        this.mGroupCityListManualMap.clear();
        this.mSectionTitle.put(0, "当前定位城市");
        ji jiVar = new ji(0);
        this.mLocationCityHolder = jiVar;
        updateLocationCityHolder(jiVar, false);
        this.mCityListData.add(this.mLocationCityHolder);
        List<HotCityBean> hotCity = cityListResponse.getHotCity();
        int e2 = xf2.e(hotCity);
        if (e2 > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < e2; i2++) {
                HotCityBean hotCityBean = hotCity.get(i2);
                if (TextUtils.getTrimmedLength(hotCityBean.getCityId()) > 0 && TextUtils.getTrimmedLength(hotCityBean.getCityName()) > 0 && TextUtils.getTrimmedLength(hotCityBean.getUrl()) > 0) {
                    arrayList.add(hotCityBean);
                    this.mHotCityListManualMap.put(hotCityBean.getCityId(), hotCityBean.getUrl());
                }
            }
            if (xf2.e(arrayList) > 0) {
                this.mSectionTitle.put(1, "热门城市");
                this.mLetterIndexList.add("热");
                ji jiVar2 = new ji(1);
                jiVar2.e(arrayList);
                this.mCityListData.add(jiVar2);
                i = 2;
            }
        }
        List<GroupsBean> groups = cityListResponse.getGroups();
        int e3 = xf2.e(groups);
        if (e3 > 0) {
            for (int i3 = 0; i3 < e3; i3++) {
                GroupsBean groupsBean = groups.get(i3);
                if (groupsBean != null && (e = xf2.e((sites = groupsBean.getSites()))) > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i4 = 0; i4 < e; i4++) {
                        SitesBean sitesBean = sites.get(i4);
                        if (sitesBean != null && TextUtils.getTrimmedLength(sitesBean.getCityId()) > 0 && TextUtils.getTrimmedLength(sitesBean.getCityName()) > 0) {
                            arrayList2.add(sitesBean);
                        }
                    }
                    if (xf2.e(arrayList2) > 0) {
                        int i5 = i + 1;
                        this.mSectionTitle.put(Integer.valueOf(i), groupsBean.getSpellCode());
                        this.mLetterIndexList.add(groupsBean.getSpellCode());
                        ji jiVar3 = new ji(2);
                        jiVar3.g(arrayList2);
                        this.mCityListData.add(jiVar3);
                        i = i5;
                    }
                }
            }
        }
        List<ManualBean> manual = cityListResponse.getManual();
        int e4 = xf2.e(manual);
        if (e4 > 0) {
            for (int i6 = 0; i6 < e4; i6++) {
                ManualBean manualBean = manual.get(i6);
                if (manualBean != null && !TextUtils.isEmpty(manualBean.getCityId().trim()) && !TextUtils.isEmpty(manualBean.getUrl().trim())) {
                    this.mGroupCityListManualMap.put(manualBean.getCityId(), manualBean.getUrl());
                }
            }
        }
        FloatingTitleDecoration floatingTitleDecoration = new FloatingTitleDecoration(this.mContext);
        floatingTitleDecoration.d(this.mSectionTitle);
        floatingTitleDecoration.c(this.mSectionTitleHeight);
        this.mCityList.addItemDecoration(floatingTitleDecoration);
        this.mLetterSortBar.setLetters(this.mLetterIndexList);
        this.mAdapter.notifyDataSetChanged();
        dispatchLocationChecking(false);
    }

    private void initLetterSortBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1033060701")) {
            ipChange.ipc$dispatch("1033060701", new Object[]{this});
            return;
        }
        LetterSortBar letterSortBar = (LetterSortBar) findViewById(R$id.city_select_sort_letter);
        this.mLetterSortBar = letterSortBar;
        letterSortBar.setOnTouchingLetterChangedListener(new b());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void initLocation(ji jiVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1227674141")) {
            ipChange.ipc$dispatch("1227674141", new Object[]{this, jiVar});
            return;
        }
        CityLocationUtil cityLocationUtil = new CityLocationUtil(this.mContext, new d(jiVar));
        this.mCityLocationUtil = cityLocationUtil;
        cityLocationUtil.p(true);
        this.mCityLocationUtil.n();
    }

    private void initRecyclerView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1779831878")) {
            ipChange.ipc$dispatch("-1779831878", new Object[]{this});
            return;
        }
        this.mCityList = (RecyclerView) findViewById(R$id.city_select_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mContext);
        linearLayoutManager.setOrientation(1);
        this.mCityList.setLayoutManager(linearLayoutManager);
        CitySelectAdapter citySelectAdapter = new CitySelectAdapter(this, this.mCityListData);
        this.mAdapter = citySelectAdapter;
        citySelectAdapter.g(this.mOnCityListItemClickListener);
        CityParam cityParam = this.mExtraCity;
        if (cityParam != null && cityParam.isOnlyObtainCityId && !TextUtils.isEmpty(cityParam.selectCityName)) {
            this.mAdapter.h(this.mExtraCity.selectCityName);
        }
        this.mCityList.setAdapter(this.mAdapter);
        this.mCityList.addOnScrollListener(this.mOnScrollListener);
    }

    private void initTitleView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1920365681")) {
            ipChange.ipc$dispatch("-1920365681", new Object[]{this});
            return;
        }
        this.mSectionTitleHeight = v50.a(this.mContext, 40.0f);
        findViewById(R$id.city_select_cancel).setOnClickListener(this);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void moveToPosition(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1020681590")) {
            ipChange.ipc$dispatch("-1020681590", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mIndex = i;
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.mCityList.getLayoutManager();
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        if (i <= findFirstVisibleItemPosition) {
            this.mCityList.scrollToPosition(i);
        } else if (i <= findLastVisibleItemPosition) {
            this.mCityList.scrollBy(0, this.mCityList.getChildAt(i - findFirstVisibleItemPosition).getTop() - this.mSectionTitleHeight);
        } else {
            this.mCityList.scrollToPosition(i);
            this.mMoveAgain = true;
        }
    }

    private void requestCityList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1270895740")) {
            ipChange.ipc$dispatch("-1270895740", new Object[]{this});
            return;
        }
        CityListRequest cityListRequest = new CityListRequest();
        cityListRequest.showLoginUI(false);
        cityListRequest.request(new DMMtopRequestListener<CityListResponse>(CityListResponse.class) {
            /* class cn.damai.commonbusiness.city.CitySelectActivity.AnonymousClass4 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1989172907")) {
                    ipChange.ipc$dispatch("-1989172907", new Object[]{this, str, str2});
                    return;
                }
                CitySelectActivity.this.stopProgressDialog();
                String B = d20.B(ShareperfenceConstants.CITY_DATA_New);
                if (TextUtils.isEmpty(B)) {
                    B = gi.a(CitySelectActivity.this);
                }
                try {
                    CityListResponse cityListResponse = (CityListResponse) JSON.parseObject(B, CityListResponse.class);
                    if (cityListResponse != null) {
                        CitySelectActivity.this.initData(cityListResponse);
                    }
                } catch (Exception e) {
                    g91.b("CitySelectActivity", e.getMessage());
                }
                ToastUtil.a().e(CitySelectActivity.this.mContext, str2);
            }

            public void onSuccess(CityListResponse cityListResponse) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "798063426")) {
                    ipChange.ipc$dispatch("798063426", new Object[]{this, cityListResponse});
                    return;
                }
                CitySelectActivity.this.stopProgressDialog();
                if (cityListResponse != null) {
                    CitySelectActivity.this.initData(cityListResponse);
                    try {
                        d20.T(ShareperfenceConstants.CITY_DATA_New, JSON.toJSONString(cityListResponse));
                        d20.T(ShareperfenceConstants.CITY_CACHE_TIME_New, String.valueOf(System.currentTimeMillis()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        startProgressDialog();
    }

    private void requestLocation(ji jiVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-281023380")) {
            ipChange.ipc$dispatch("-281023380", new Object[]{this, jiVar});
            return;
        }
        String[] strArr = lp1.LOCATION;
        new Permission(this, new PermissionModel(strArr, "位置权限使用说明", Integer.valueOf(R$drawable.permission_location_icon), "用于为你提供所在城市演出和场馆信息及帮助你找到附近的演出")).a(new c(hp1.i(strArr), jiVar)).b();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean trySetCityResultAndFinish(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1697982407")) {
            return ((Boolean) ipChange.ipc$dispatch("-1697982407", new Object[]{this, str, str2})).booleanValue();
        }
        CityParam cityParam = this.mExtraCity;
        if (cityParam == null || !cityParam.isOnlyObtainCityId) {
            return false;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Intent intent = new Intent();
            intent.putExtra(CITY_ID, str);
            intent.putExtra(CITY_NAME, str2);
            setResult(-1, intent);
            finish();
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateLocationCityHolder(ji jiVar, boolean z) {
        CitySelectAdapter citySelectAdapter;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1086553639")) {
            ipChange.ipc$dispatch("1086553639", new Object[]{this, jiVar, Boolean.valueOf(z)});
        } else if (jiVar != null && jiVar.d() == 0) {
            if (hp1.i(lp1.LOCATION)) {
                jiVar.c = 119;
            } else {
                jiVar.c = 102;
            }
            if (z && (citySelectAdapter = this.mAdapter) != null) {
                citySelectAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1147461866")) {
            ipChange.ipc$dispatch("-1147461866", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2138815764")) {
            return R$layout.activity_city_select;
        }
        return ((Integer) ipChange.ipc$dispatch("2138815764", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "16780519")) {
            ipChange.ipc$dispatch("16780519", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1891057188")) {
            ipChange.ipc$dispatch("1891057188", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-260996615")) {
            ipChange.ipc$dispatch("-260996615", new Object[]{this});
            return;
        }
        this.mExtraCity = (CityParam) getIntent().getParcelableExtra(OBTAIN_CITY_PARAM);
        hideBaseLayout();
        initTitleView();
        initLetterSortBar();
        initRecyclerView();
        requestCityList();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1482531936")) {
            ipChange.ipc$dispatch("-1482531936", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        if (i == 2168) {
            updateLocationCityHolder(this.mLocationCityHolder, true);
            dispatchLocationChecking(false);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "456621983")) {
            ipChange.ipc$dispatch("456621983", new Object[]{this, view});
            return;
        }
        super.onClick(view);
        if (view.getId() == R$id.city_select_cancel) {
            finish();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2101829215")) {
            ipChange.ipc$dispatch("-2101829215", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setDamaiUTKeyBuilder(wk.j().g());
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1259331094")) {
            ipChange.ipc$dispatch("1259331094", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1061197119")) {
            ipChange.ipc$dispatch("1061197119", new Object[]{this});
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "409830274")) {
            ipChange.ipc$dispatch("409830274", new Object[]{this});
            return;
        }
        super.onResume();
        jq2.a().c();
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2139304072")) {
            return null;
        }
        return (String) ipChange.ipc$dispatch("2139304072", new Object[]{this});
    }
}
