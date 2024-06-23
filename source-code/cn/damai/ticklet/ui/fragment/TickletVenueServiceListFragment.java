package cn.damai.ticklet.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.member.R$string;
import cn.damai.ticklet.bean.ExchangeSiteInfo;
import cn.damai.ticklet.bean.GaoDeCode;
import cn.damai.ticklet.bean.TicketServiceFacility;
import cn.damai.ticklet.bean.TickletExchangeSiteNearbyResult;
import cn.damai.ticklet.bean.TickletVenueMapBean;
import cn.damai.ticklet.inteface.TickletVenueSiteCallback;
import cn.damai.ticklet.net.TickletExchangeTicketSiteRequest;
import cn.damai.ticklet.ui.activity.TickletVenueActivity;
import cn.damai.ticklet.ui.adapter.TickletVenueExchangeSiteListAdapter;
import cn.damai.uikit.irecycler.OnLoadMoreListener;
import cn.damai.uikit.irecycler.OnRefreshListener;
import cn.damai.uikit.irecycler.widget.WrapLinearLayoutManager;
import com.alibaba.fastjson.JSON;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.ui.component.WXComponent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import tb.d20;
import tb.g91;
import tb.jl1;
import tb.v50;
import tb.vl2;
import tb.xf2;

/* compiled from: Taobao */
public class TickletVenueServiceListFragment extends DamaiBaseMvpFragment implements OnLoadMoreListener, OnRefreshListener, PoiSearch.OnPoiSearchListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private TickletVenueActivity activity;
    private String bianlidianCode = "060200|060201|060202";
    private TickletVenueSiteCallback callBack;
    private String chosenLat;
    private String chosenLng;
    private Context context;
    private TickletVenueMapBean data;
    private LinearLayout errorPageView;
    private String foodCode = "050000";
    private boolean isExchangeSite;
    private LinearLayout llView;
    private TickletVenueExchangeSiteListAdapter mAdapter;
    private int mFirstVisibleItemCount = 0;
    private int mFirstVisibleItems = 0;
    private LinearLayoutManager mLinearLayoutManager;
    private RecyclerView mRecyclerView;
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() {
        /* class cn.damai.ticklet.ui.fragment.TickletVenueServiceListFragment.AnonymousClass2 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-945823198")) {
                ipChange.ipc$dispatch("-945823198", new Object[]{this, recyclerView, Integer.valueOf(i)});
                return;
            }
            super.onScrollStateChanged(recyclerView, i);
            int findFirstVisibleItemPosition = TickletVenueServiceListFragment.this.mLinearLayoutManager.findFirstVisibleItemPosition();
            if (TickletVenueServiceListFragment.this.mFirstVisibleItems <= 0) {
                TickletVenueServiceListFragment.this.mFirstVisibleItems = findFirstVisibleItemPosition;
                TickletVenueServiceListFragment tickletVenueServiceListFragment = TickletVenueServiceListFragment.this;
                tickletVenueServiceListFragment.mFirstVisibleItemCount = tickletVenueServiceListFragment.mLinearLayoutManager.getChildCount();
            }
            if (findFirstVisibleItemPosition >= TickletVenueServiceListFragment.this.mFirstVisibleItemCount && TickletVenueServiceListFragment.this.callBack != null) {
                TickletVenueServiceListFragment.this.callBack.addMapMarkData();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-438974531")) {
                ipChange.ipc$dispatch("-438974531", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                return;
            }
            super.onScrolled(recyclerView, i, i2);
        }
    };
    private String noResult = "亲，没有查询到相关信息！";
    private String performId;
    private String productSystemId;
    private PoiSearch.Query query;
    private String shopMallCode = "060100|060101|060102|060103|";
    private String stationCode = "150900";
    private String stationTraCode = "150700|150702|150500";
    private ProgressBar ticklet_venue_progress;
    private int type = 0;
    private String waterhandCode = "200300|200301|200302|200303|200304";

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void exchangeListErrorXFlushMonitor(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-596853276")) {
            ipChange.ipc$dispatch("-596853276", new Object[]{this, str, str2});
            return;
        }
        vl2.d(vl2.i(vl2.TICKLET_EXCHANGE_LIST_API, "mtop.damai.wireless.ticklet2.extension.exchangesite.list", str, str2, this.performId), vl2.TICKLET_EXCHANGE_LIST_NETWORK_ERROR_CODE, str, vl2.TICKLET_EXCHANGE_LIST_NETWORK_ERROR_MSG);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void exchangeSiteListError(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1849637743")) {
            ipChange.ipc$dispatch("-1849637743", new Object[]{this, str, str2, str3});
        } else if (TextUtils.isEmpty(str)) {
            loadDataFinishRefreshUI(2, getResources().getString(R$string.ticklet_venue_error), str2, str3);
        } else {
            loadDataFinishRefreshUI(2, str, str2, str3);
        }
    }

    private String getCityCodeByName(String str) {
        List parseArray;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1602117965")) {
            return (String) ipChange.ipc$dispatch("-1602117965", new Object[]{this, str});
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String cityCodeList = getCityCodeList();
        try {
            if (!TextUtils.isEmpty(cityCodeList) && (parseArray = JSON.parseArray(cityCodeList, GaoDeCode.class)) != null && parseArray.size() > 0) {
                for (int i = 0; i < parseArray.size(); i++) {
                    GaoDeCode gaoDeCode = (GaoDeCode) parseArray.get(i);
                    if (gaoDeCode != null && (str.contains(gaoDeCode.name) || gaoDeCode.name.contains(str))) {
                        return gaoDeCode.code;
                    }
                }
            }
        } catch (Exception e) {
            g91.b("StackTrace", e.toString());
        }
        return "";
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0086 A[SYNTHETIC, Splitter:B:37:0x0086] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0094 A[SYNTHETIC, Splitter:B:42:0x0094] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00a5 A[SYNTHETIC, Splitter:B:50:0x00a5] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b3 A[SYNTHETIC, Splitter:B:55:0x00b3] */
    private String getCityCodeList() {
        BufferedReader bufferedReader;
        Throwable th;
        InputStreamReader inputStreamReader;
        Exception e;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-398919783")) {
            return (String) ipChange.ipc$dispatch("-398919783", new Object[]{this});
        }
        InputStreamReader inputStreamReader2 = null;
        try {
            inputStreamReader = new InputStreamReader(getResources().getAssets().open("gaode_citycode.txt"));
            try {
                bufferedReader = new BufferedReader(inputStreamReader);
                String str = "";
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        str = str + readLine;
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            g91.b("StackTrace", e.toString());
                            if (inputStreamReader != null) {
                            }
                            if (bufferedReader != null) {
                            }
                            return "";
                        } catch (Throwable th2) {
                            th = th2;
                            inputStreamReader2 = inputStreamReader;
                            if (inputStreamReader2 != null) {
                                try {
                                    inputStreamReader2.close();
                                } catch (IOException e3) {
                                    g91.b("Stacktrace", e3.toString());
                                }
                            }
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e4) {
                                    g91.b("Stacktrace", e4.toString());
                                }
                            }
                            throw th;
                        }
                    }
                }
                inputStreamReader.close();
                bufferedReader.close();
                try {
                    inputStreamReader.close();
                } catch (IOException e5) {
                    g91.b("Stacktrace", e5.toString());
                }
                try {
                    bufferedReader.close();
                } catch (IOException e6) {
                    g91.b("Stacktrace", e6.toString());
                }
                return str;
            } catch (Exception e7) {
                bufferedReader = null;
                e = e7;
                g91.b("StackTrace", e.toString());
                if (inputStreamReader != null) {
                }
                if (bufferedReader != null) {
                }
                return "";
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                inputStreamReader2 = inputStreamReader;
                if (inputStreamReader2 != null) {
                }
                if (bufferedReader != null) {
                }
                throw th;
            }
        } catch (Exception e8) {
            bufferedReader = null;
            e = e8;
            inputStreamReader = null;
            g91.b("StackTrace", e.toString());
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e9) {
                    g91.b("Stacktrace", e9.toString());
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e10) {
                    g91.b("Stacktrace", e10.toString());
                }
            }
            return "";
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            if (inputStreamReader2 != null) {
            }
            if (bufferedReader != null) {
            }
            throw th;
        }
    }

    private boolean isTypeListEmpty() {
        ArrayList<ExchangeSiteInfo> arrayList;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-872670068")) {
            return ((Boolean) ipChange.ipc$dispatch("-872670068", new Object[]{this})).booleanValue();
        }
        TickletVenueMapBean tickletVenueMapBean = this.data;
        return tickletVenueMapBean == null || (arrayList = tickletVenueMapBean.exchangeSiteInfos) == null || arrayList.size() == 0;
    }

    private void loadExchangesiteList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "581697961")) {
            ipChange.ipc$dispatch("581697961", new Object[]{this});
            return;
        }
        TickletExchangeTicketSiteRequest tickletExchangeTicketSiteRequest = new TickletExchangeTicketSiteRequest();
        if (!TextUtils.isEmpty(this.performId)) {
            tickletExchangeTicketSiteRequest.performId = this.performId;
            tickletExchangeTicketSiteRequest.productSystemId = this.productSystemId;
            isLoading(true);
            tickletExchangeTicketSiteRequest.request(new DMMtopRequestListener<TickletExchangeSiteNearbyResult>(TickletExchangeSiteNearbyResult.class) {
                /* class cn.damai.ticklet.ui.fragment.TickletVenueServiceListFragment.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-901634821")) {
                        ipChange.ipc$dispatch("-901634821", new Object[]{this, str, str2});
                        return;
                    }
                    TickletVenueServiceListFragment.this.stopProgressDialog();
                    TickletVenueServiceListFragment.this.exchangeSiteListError(str2, str, "mtop.damai.wireless.ticklet2.extension.exchangesite.list");
                    TickletVenueServiceListFragment.this.exchangeListErrorXFlushMonitor(str, str2);
                }

                public void onSuccess(TickletExchangeSiteNearbyResult tickletExchangeSiteNearbyResult) {
                    ArrayList<ExchangeSiteInfo> arrayList;
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "2032845710")) {
                        ipChange.ipc$dispatch("2032845710", new Object[]{this, tickletExchangeSiteNearbyResult});
                        return;
                    }
                    TickletVenueServiceListFragment.this.stopProgressDialog();
                    if (tickletExchangeSiteNearbyResult == null || (arrayList = tickletExchangeSiteNearbyResult.exchangeSiteInfoList) == null || arrayList.isEmpty()) {
                        TickletVenueServiceListFragment tickletVenueServiceListFragment = TickletVenueServiceListFragment.this;
                        tickletVenueServiceListFragment.loadDataFinishRefreshUI(3, tickletVenueServiceListFragment.getResources().getString(R$string.ticklet_venue_exchange_empty), "", "mtop.damai.wireless.ticklet2.extension.exchangesite.list");
                        return;
                    }
                    TickletVenueServiceListFragment.this.returnExchangeSiteList(tickletExchangeSiteNearbyResult.exchangeSiteInfoList);
                }
            });
            return;
        }
        exchangeSiteListError("", "", "");
    }

    public static TickletVenueServiceListFragment newInstance(TickletVenueMapBean tickletVenueMapBean, int i, String str, String str2, boolean z, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1299075817")) {
            return (TickletVenueServiceListFragment) ipChange.ipc$dispatch("-1299075817", new Object[]{tickletVenueMapBean, Integer.valueOf(i), str, str2, Boolean.valueOf(z), str3, str4});
        }
        TickletVenueServiceListFragment tickletVenueServiceListFragment = new TickletVenueServiceListFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("data", tickletVenueMapBean);
        bundle.putInt("type", i);
        bundle.putString("chosenLat", str);
        bundle.putString("chosenLng", str2);
        bundle.putString(TicketDetailExtFragment.PERFORM_ID, str3);
        bundle.putString(TicketDetailExtFragment.PRODUCT_SYSTEM_ID, str4);
        bundle.putBoolean("isExchangeSite", z);
        tickletVenueServiceListFragment.setArguments(bundle);
        return tickletVenueServiceListFragment;
    }

    private void poiSearchErrorXFlushMonitor(String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-513343635")) {
            ipChange.ipc$dispatch("-513343635", new Object[]{this, str, str2, str3, str4, str5});
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("info:{");
        sb.append("type:");
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        sb.append(str2);
        sb.append(";");
        sb.append("code:");
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        sb.append(str3);
        sb.append(";");
        sb.append("venue:");
        sb.append(jl1.ARRAY_START_STR);
        if (TextUtils.isEmpty(str4)) {
            str4 = "";
        }
        sb.append(str4);
        sb.append("/");
        if (TextUtils.isEmpty(str5)) {
            str5 = "";
        }
        sb.append(str5);
        sb.append(jl1.ARRAY_END_STR);
        sb.append("}");
        vl2.d(vl2.j(str, sb.toString(), this.performId), vl2.TICKLET_VENUE_POI_SEARCH_ERROR_CODE, vl2.TICKLET_VENUE_POI_SEARCH_ERROR_CODE, vl2.TICKLET_VENUE_POI_SEARCH_ERROR_MSG);
    }

    private String posType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-125434654")) {
            return (String) ipChange.ipc$dispatch("-125434654", new Object[]{this, Integer.valueOf(i)});
        } else if (i == 0) {
            return this.stationTraCode;
        } else {
            if (i == 1) {
                return this.stationCode;
            }
            if (i == 2) {
                return this.foodCode;
            }
            if (i == 3) {
                return this.waterhandCode;
            }
            if (i != 4) {
                return i != 5 ? "" : this.shopMallCode;
            }
            return this.bianlidianCode;
        }
    }

    private void searchMapData(int i) {
        TickletVenueSiteCallback tickletVenueSiteCallback;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-859973970")) {
            ipChange.ipc$dispatch("-859973970", new Object[]{this, Integer.valueOf(i)});
        } else if (isTypeListEmpty() || (tickletVenueSiteCallback = this.callBack) == null) {
            String posType = posType(i);
            if (!TextUtils.isEmpty(posType) && getContext() != null) {
                String cityCodeByName = getCityCodeByName(d20.d());
                isLoading(true);
                if (TextUtils.isEmpty(cityCodeByName) || TextUtils.isEmpty(this.chosenLat) || TextUtils.isEmpty(this.chosenLng)) {
                    loadDataFinishRefreshUI(2, "无法获取定位,搜索失败", null, null);
                    return;
                }
                PoiSearch.Query query2 = new PoiSearch.Query("", posType, "");
                this.query = query2;
                query2.setPageSize(20);
                try {
                    PoiSearch poiSearch = new PoiSearch(getContext(), this.query);
                    poiSearch.setOnPoiSearchListener(this);
                    poiSearch.setBound(new PoiSearch.SearchBound(new LatLonPoint(Double.parseDouble(this.chosenLat), Double.parseDouble(this.chosenLng)), 1500));
                    poiSearch.searchPOIAsyn();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            tickletVenueSiteCallback.onServiceDataSuccess(i, this.data.exchangeSiteInfos);
        }
    }

    private void showErrorPage(String str, boolean z, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-848258395")) {
            ipChange.ipc$dispatch("-848258395", new Object[]{this, str, Boolean.valueOf(z), str2, str3});
        } else if (z) {
            onResponseError(str, str2, str3, this.errorPageView, true);
            this.mErrorPage.updateErrorPageGravity(48, v50.a(getContext(), 1.0f));
        } else {
            onResponseError(3, str, str2, str3, this.errorPageView, true);
            this.mErrorPage.updateErrorPageGravity(48, v50.a(getContext(), 1.0f));
        }
    }

    private String typeTitle(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1764213714")) {
            return (String) ipChange.ipc$dispatch("1764213714", new Object[]{this, Integer.valueOf(i)});
        } else if (this.isExchangeSite) {
            return TicketServiceFacility.EXCHANGE_SITE;
        } else {
            if (i == 0) {
                return TicketServiceFacility.PUBLIC_TRANSIT;
            }
            if (i == 1) {
                return TicketServiceFacility.PARKING;
            }
            if (i == 2) {
                return TicketServiceFacility.FINE_FOOD;
            }
            if (i == 3) {
                return TicketServiceFacility.TOILET;
            }
            if (i != 4) {
                return i != 5 ? "" : TicketServiceFacility.SHOP_MALL;
            }
            return TicketServiceFacility.CONVENINCE_STORE;
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseFragment
    public int getLayoutResource() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-121024520")) {
            return R$layout.ticklet_venue_site_list;
        }
        return ((Integer) ipChange.ipc$dispatch("-121024520", new Object[]{this})).intValue();
    }

    public int getServiceType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "829067665")) {
            return this.type;
        }
        return ((Integer) ipChange.ipc$dispatch("829067665", new Object[]{this})).intValue();
    }

    public ArrayList<ExchangeSiteInfo> getTypeDataList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1683255989")) {
            return (ArrayList) ipChange.ipc$dispatch("1683255989", new Object[]{this});
        }
        TickletVenueMapBean tickletVenueMapBean = this.data;
        if (tickletVenueMapBean != null) {
            return tickletVenueMapBean.exchangeSiteInfos;
        }
        return null;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-484949360")) {
            ipChange.ipc$dispatch("-484949360", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        reloadData();
    }

    public void initAdapter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1618451692")) {
            ipChange.ipc$dispatch("-1618451692", new Object[]{this});
            return;
        }
        TickletVenueExchangeSiteListAdapter tickletVenueExchangeSiteListAdapter = new TickletVenueExchangeSiteListAdapter(getContext(), this.data.exchangeSiteInfos);
        this.mAdapter = tickletVenueExchangeSiteListAdapter;
        tickletVenueExchangeSiteListAdapter.f(this.callBack);
        WrapLinearLayoutManager wrapLinearLayoutManager = new WrapLinearLayoutManager(getContext());
        this.mLinearLayoutManager = wrapLinearLayoutManager;
        this.mRecyclerView.setLayoutManager(wrapLinearLayoutManager);
        this.mRecyclerView.setAdapter(this.mAdapter);
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-777667173")) {
            ipChange.ipc$dispatch("-777667173", new Object[]{this});
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseFragment
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "290518050")) {
            ipChange.ipc$dispatch("290518050", new Object[]{this});
            return;
        }
        this.mRecyclerView = (RecyclerView) this.rootView.findViewById(R$id.ticklet_venue_window_listview);
        this.llView = (LinearLayout) this.rootView.findViewById(R$id.ticklet_venue_exchange_view);
        this.errorPageView = (LinearLayout) this.rootView.findViewById(R$id.errorPageView);
        this.ticklet_venue_progress = (ProgressBar) this.rootView.findViewById(R$id.ticklet_venue_progress);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.data = (TickletVenueMapBean) arguments.getSerializable("data");
            this.type = arguments.getInt("type");
            this.chosenLat = arguments.getString("chosenLat");
            this.chosenLng = arguments.getString("chosenLng");
            this.isExchangeSite = arguments.getBoolean("isExchangeSite");
            this.performId = arguments.getString(TicketDetailExtFragment.PERFORM_ID);
            this.productSystemId = arguments.getString(TicketDetailExtFragment.PRODUCT_SYSTEM_ID);
        }
        if (this.data != null) {
            initAdapter();
            if (this.isExchangeSite) {
                loadExchangesiteList();
            } else {
                searchMapData(this.type);
            }
        }
    }

    public void isLoading(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1555769901")) {
            ipChange.ipc$dispatch("-1555769901", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            this.ticklet_venue_progress.setVisibility(0);
            this.mRecyclerView.setVisibility(8);
            this.errorPageView.setVisibility(8);
        }
    }

    public void loadDataFinishRefreshUI(int i, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2143660346")) {
            ipChange.ipc$dispatch("2143660346", new Object[]{this, Integer.valueOf(i), str, str2, str3});
        } else if (1 == i) {
            this.mRecyclerView.setVisibility(0);
            this.errorPageView.setVisibility(8);
            this.ticklet_venue_progress.setVisibility(8);
        } else if (2 == i) {
            this.mRecyclerView.setVisibility(8);
            this.ticklet_venue_progress.setVisibility(8);
            this.errorPageView.setVisibility(0);
            showErrorPage(str, true, str2, str3);
            if (this.context != null) {
                ToastUtil.f(str);
            }
        } else if (3 == i) {
            this.mRecyclerView.setVisibility(8);
            this.ticklet_venue_progress.setVisibility(8);
            this.errorPageView.setVisibility(0);
            showErrorPage(str, false, str2, str3);
            if (this.context != null) {
                ToastUtil.f(str);
            }
        }
    }

    public void notifyChanged(ArrayList<ExchangeSiteInfo> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-775655006")) {
            ipChange.ipc$dispatch("-775655006", new Object[]{this, arrayList});
            return;
        }
        TickletVenueMapBean tickletVenueMapBean = this.data;
        ArrayList<ExchangeSiteInfo> arrayList2 = tickletVenueMapBean.exchangeSiteInfos;
        if (arrayList2 == null) {
            tickletVenueMapBean.exchangeSiteInfos = new ArrayList<>();
        } else {
            arrayList2.clear();
        }
        loadDataFinishRefreshUI(1, "", null, null);
        this.data.exchangeSiteInfos.addAll(arrayList);
        this.mAdapter.notifyDataSetChanged();
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "841488776")) {
            ipChange.ipc$dispatch("841488776", new Object[]{this, view});
        }
    }

    @Override // cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1048605877")) {
            ipChange.ipc$dispatch("1048605877", new Object[]{this, view});
        }
    }

    @Override // com.amap.api.services.poisearch.PoiSearch.OnPoiSearchListener
    public void onPoiItemSearched(PoiItem poiItem, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "307913321")) {
            ipChange.ipc$dispatch("307913321", new Object[]{this, poiItem, Integer.valueOf(i)});
        }
    }

    @Override // com.amap.api.services.poisearch.PoiSearch.OnPoiSearchListener
    public void onPoiSearched(PoiResult poiResult, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2118295817")) {
            ipChange.ipc$dispatch("-2118295817", new Object[]{this, poiResult, Integer.valueOf(i)});
            return;
        }
        String str = null;
        if (i != 1000) {
            TickletVenueSiteCallback tickletVenueSiteCallback = this.callBack;
            if (tickletVenueSiteCallback != null) {
                tickletVenueSiteCallback.onFail("", "");
            }
            loadDataFinishRefreshUI(2, getResources().getString(R$string.ticklet_venue_error), String.valueOf(i), "poiResult返回错误");
            String category = (poiResult == null || poiResult.getQuery() == null) ? null : poiResult.getQuery().getCategory();
            TickletVenueMapBean tickletVenueMapBean = this.data;
            if (tickletVenueMapBean != null && !xf2.j(tickletVenueMapBean.pageTitle)) {
                str = this.data.pageTitle;
            }
            poiSearchErrorXFlushMonitor(String.valueOf(i), str, category, this.chosenLat, this.chosenLng);
        } else if (poiResult == null || poiResult.getQuery() == null) {
            loadDataFinishRefreshUI(2, getResources().getString(R$string.ticklet_venue_error), null, "poiResult结果返回空");
        } else if (poiResult.getQuery().equals(this.query)) {
            ArrayList<PoiItem> pois = poiResult.getPois();
            g91.b("TickletVenueActivity", pois.toString());
            if (pois.size() > 0) {
                ArrayList<ExchangeSiteInfo> arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < pois.size(); i2++) {
                    ExchangeSiteInfo exchangeSiteInfo = new ExchangeSiteInfo();
                    exchangeSiteInfo.detailLocation = pois.get(i2).getSnippet();
                    exchangeSiteInfo.distanceDesc = "距场馆" + pois.get(i2).getDistance() + WXComponent.PROP_FS_MATCH_PARENT;
                    if (pois.get(i2).getLatLonPoint() != null) {
                        exchangeSiteInfo.lat = String.valueOf(pois.get(i2).getLatLonPoint().getLatitude());
                        exchangeSiteInfo.lng = String.valueOf(pois.get(i2).getLatLonPoint().getLongitude());
                    }
                    exchangeSiteInfo.siteName = pois.get(i2).getTitle();
                    arrayList.add(exchangeSiteInfo);
                }
                notifyChanged(arrayList);
                TickletVenueSiteCallback tickletVenueSiteCallback2 = this.callBack;
                if (tickletVenueSiteCallback2 != null) {
                    tickletVenueSiteCallback2.onServiceDataSuccess(this.type, arrayList);
                }
            } else {
                loadDataFinishRefreshUI(3, getResources().getString(R$string.ticklet_venue_data_empty, typeTitle(this.type)), null, "poiResult结果返回空");
            }
        }
        TickletVenueSiteCallback tickletVenueSiteCallback3 = this.callBack;
        if (tickletVenueSiteCallback3 != null) {
            tickletVenueSiteCallback3.showPopIconUtil();
        }
    }

    @Override // cn.damai.uikit.irecycler.OnRefreshListener
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-26519145")) {
            ipChange.ipc$dispatch("-26519145", new Object[]{this});
        }
    }

    public void reloadData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2082089940")) {
            ipChange.ipc$dispatch("2082089940", new Object[]{this});
            return;
        }
        TickletVenueMapBean tickletVenueMapBean = this.data;
        ArrayList<ExchangeSiteInfo> arrayList = tickletVenueMapBean.exchangeSiteInfos;
        if (arrayList == null) {
            tickletVenueMapBean.exchangeSiteInfos = new ArrayList<>();
        } else {
            arrayList.clear();
        }
        if (this.isExchangeSite) {
            loadExchangesiteList();
        } else {
            searchMapData(this.type);
        }
    }

    public void returnExchangeSiteList(ArrayList<ExchangeSiteInfo> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1683036533")) {
            ipChange.ipc$dispatch("-1683036533", new Object[]{this, arrayList});
        } else if (arrayList == null || arrayList.size() <= 0) {
            loadDataFinishRefreshUI(3, getResources().getString(R$string.ticklet_venue_exchange_empty), null, "mtop.damai.wireless.ticklet2.extension.exchangesite.list");
        } else {
            notifyChanged(arrayList);
            TickletVenueSiteCallback tickletVenueSiteCallback = this.callBack;
            if (tickletVenueSiteCallback != null) {
                tickletVenueSiteCallback.onServiceDataSuccess(this.type, arrayList);
            }
        }
    }

    public void scrollPos(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "152526615")) {
            ipChange.ipc$dispatch("152526615", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        try {
            if (i < this.mAdapter.getItemCount()) {
                if (i >= 0) {
                    this.mAdapter.c(i);
                }
                this.mAdapter.notifyDataSetChanged();
                if (i >= 0) {
                    ((LinearLayoutManager) this.mRecyclerView.getLayoutManager()).scrollToPositionWithOffset(i, 0);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            vl2.e(vl2.TICKLET_VENUE_LIST_ERROR_CODE, vl2.TICKLET_VENUE_LIST_ERROR_MSG, e.getMessage());
        }
    }

    public void setCallBack(TickletVenueSiteCallback tickletVenueSiteCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-585562354")) {
            ipChange.ipc$dispatch("-585562354", new Object[]{this, tickletVenueSiteCallback});
            return;
        }
        this.callBack = tickletVenueSiteCallback;
    }
}
