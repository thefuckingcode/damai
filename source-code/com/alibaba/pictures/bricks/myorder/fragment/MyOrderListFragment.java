package com.alibaba.pictures.bricks.myorder.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.bricks.base.BricksBaseFragment;
import com.alibaba.pictures.bricks.myorder.request.MyOrderListRequest;
import com.alibaba.pictures.dolores.login.DoloresLoginHandler;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.youku.kubus.Event;
import com.youku.kubus.EventBus;
import com.youku.kubus.Subscribe;
import kotlin.Lazy;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ca1;
import tb.eb0;
import tb.k21;
import tb.m40;

/* compiled from: Taobao */
public final class MyOrderListFragment extends BricksBaseFragment implements OnLoadMoreListener, OnRefreshListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    public static final String KEY_PAGE_TYPE = "pageType";
    public static final int REQUEST_CODE_LOGIN = 10;
    public static final int VALUE_PAGE_TYPE_ALL = 0;
    public static final int VALUE_PAGE_TYPE_UNPAY = 2;
    public static final int VALUE_PAGE_TYPE_UNUSED = 1;
    @NotNull
    private final Lazy adapter$delegate;
    private ViewGroup errorContainer;
    private boolean isRefresh;
    private boolean needRefreshStateOnResume;
    private int pageNumber;
    private int pageType;
    private RecyclerView recyclerView;
    private SmartRefreshLayout refreshLayout;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    /* compiled from: Taobao */
    public static final class b implements BricksBaseFragment.IClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ MyOrderListFragment a;

        b(MyOrderListFragment myOrderListFragment) {
            this.a = myOrderListFragment;
        }

        @Override // com.alibaba.pictures.bricks.base.BricksBaseFragment.IClickListener
        public void handleClick(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1976779913")) {
                ipChange.ipc$dispatch("1976779913", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            this.a.requestOrderList(true);
        }
    }

    public MyOrderListFragment() {
        this(0, 1, null);
    }

    public MyOrderListFragment(int i) {
        this.pageType = i;
        this.pageNumber = 1;
        this.isRefresh = true;
        this.adapter$delegate = kotlin.b.b(new MyOrderListFragment$adapter$2(this));
    }

    /* access modifiers changed from: private */
    public final MyOrderListAdapter getAdapter() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-523431726")) {
            return (MyOrderListAdapter) this.adapter$delegate.getValue();
        }
        return (MyOrderListAdapter) ipChange.ipc$dispatch("-523431726", new Object[]{this});
    }

    private final void initView(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1005666320")) {
            ipChange.ipc$dispatch("-1005666320", new Object[]{this, view});
            return;
        }
        View findViewById = view.findViewById(R$id.error_container);
        k21.h(findViewById, "root.findViewById(R.id.error_container)");
        this.errorContainer = (ViewGroup) findViewById;
        View findViewById2 = view.findViewById(R$id.recyclerView);
        k21.h(findViewById2, "root.findViewById(R.id.recyclerView)");
        RecyclerView recyclerView2 = (RecyclerView) findViewById2;
        this.recyclerView = recyclerView2;
        RecyclerView recyclerView3 = null;
        if (recyclerView2 == null) {
            k21.A("recyclerView");
            recyclerView2 = null;
        }
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext()));
        View findViewById3 = view.findViewById(R$id.refresh_layout);
        k21.h(findViewById3, "root.findViewById(R.id.refresh_layout)");
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) findViewById3;
        this.refreshLayout = smartRefreshLayout;
        if (smartRefreshLayout == null) {
            k21.A("refreshLayout");
            smartRefreshLayout = null;
        }
        smartRefreshLayout.setEnableLoadMore(true);
        SmartRefreshLayout smartRefreshLayout2 = this.refreshLayout;
        if (smartRefreshLayout2 == null) {
            k21.A("refreshLayout");
            smartRefreshLayout2 = null;
        }
        smartRefreshLayout2.setEnableAutoLoadMore(true);
        SmartRefreshLayout smartRefreshLayout3 = this.refreshLayout;
        if (smartRefreshLayout3 == null) {
            k21.A("refreshLayout");
            smartRefreshLayout3 = null;
        }
        smartRefreshLayout3.setOnRefreshListener(this);
        SmartRefreshLayout smartRefreshLayout4 = this.refreshLayout;
        if (smartRefreshLayout4 == null) {
            k21.A("refreshLayout");
            smartRefreshLayout4 = null;
        }
        smartRefreshLayout4.setOnLoadMoreListener(this);
        RecyclerView recyclerView4 = this.recyclerView;
        if (recyclerView4 == null) {
            k21.A("recyclerView");
        } else {
            recyclerView3 = recyclerView4;
        }
        recyclerView3.setAdapter(getAdapter());
        JSONObject jSONObject = new JSONObject();
        jSONObject.put((Object) "pageType", (Object) Integer.valueOf(this.pageType));
        getAdapter().b(jSONObject);
    }

    private final void parseArguments() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2045546156")) {
            ipChange.ipc$dispatch("-2045546156", new Object[]{this});
        } else if (getArguments() != null) {
            Bundle arguments = getArguments();
            k21.f(arguments);
            if (arguments.containsKey("pageType")) {
                Bundle arguments2 = getArguments();
                k21.f(arguments2);
                this.pageType = arguments2.getInt("pageType");
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void requestOrderList(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1654924582")) {
            ipChange.ipc$dispatch("-1654924582", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        if (z) {
            this.pageNumber = 1;
        } else {
            this.pageNumber++;
        }
        this.isRefresh = z;
        if (DoloresLoginHandler.Companion.a().c()) {
            MyOrderListRequest myOrderListRequest = new MyOrderListRequest();
            myOrderListRequest.setPageSize(20);
            myOrderListRequest.setPageNum(this.pageNumber);
            myOrderListRequest.setQueryType(this.pageType);
            eb0.a(myOrderListRequest).doOnKTStart(MyOrderListFragment$requestOrderList$2.INSTANCE).doOnKTSuccess(new MyOrderListFragment$requestOrderList$3(z, this)).doOnKTFail(new MyOrderListFragment$requestOrderList$4(z, this));
            return;
        }
        ca1.Companion.d(this, 10);
    }

    /* access modifiers changed from: private */
    public final void showEmpty() {
        ViewGroup viewGroup;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-829477053")) {
            ipChange.ipc$dispatch("-829477053", new Object[]{this});
            return;
        }
        ViewGroup viewGroup2 = this.errorContainer;
        if (viewGroup2 == null) {
            k21.A("errorContainer");
            viewGroup2 = null;
        }
        viewGroup2.setVisibility(0);
        ViewGroup viewGroup3 = this.errorContainer;
        if (viewGroup3 == null) {
            k21.A("errorContainer");
            viewGroup = null;
        } else {
            viewGroup = viewGroup3;
        }
        showErrorView(3, "暂无相关内容", "", viewGroup, false, false, true, new b(this));
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2044178697")) {
            ipChange.ipc$dispatch("2044178697", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 10) {
            requestOrderList(this.isRefresh);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-743815336")) {
            ipChange.ipc$dispatch("-743815336", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        parseArguments();
        EventBus.getDefault().register(this);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "522920236")) {
            return (View) ipChange.ipc$dispatch("522920236", new Object[]{this, layoutInflater, viewGroup, bundle});
        }
        k21.i(layoutInflater, "inflater");
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = LayoutInflater.from(getContext()).inflate(R$layout.bricks_fragment_order_script_murder_list_layout, viewGroup, false);
        k21.h(inflate, "root");
        initView(inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-672930152")) {
            ipChange.ipc$dispatch("-672930152", new Object[]{this});
            return;
        }
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(eventType = {"scriptOrderRefresh"})
    public void onEventMainThread(@Nullable Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1563396415")) {
            ipChange.ipc$dispatch("1563396415", new Object[]{this, event});
            return;
        }
        this.needRefreshStateOnResume = getUserVisibleHint();
    }

    @Override // com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
    public void onLoadMore(@NotNull RefreshLayout refreshLayout2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "930605938")) {
            ipChange.ipc$dispatch("930605938", new Object[]{this, refreshLayout2});
            return;
        }
        k21.i(refreshLayout2, "refreshLayout");
        requestOrderList(false);
    }

    @Override // com.scwang.smartrefresh.layout.listener.OnRefreshListener
    public void onRefresh(@NotNull RefreshLayout refreshLayout2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "849591948")) {
            ipChange.ipc$dispatch("849591948", new Object[]{this, refreshLayout2});
            return;
        }
        k21.i(refreshLayout2, "refreshLayout");
        requestOrderList(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1575748395")) {
            ipChange.ipc$dispatch("1575748395", new Object[]{this});
            return;
        }
        super.onResume();
        if (this.needRefreshStateOnResume) {
            requestOrderList(true);
            this.needRefreshStateOnResume = false;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "404700457")) {
            ipChange.ipc$dispatch("404700457", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.setUserVisibleHint(z);
        if (z) {
            showLoading("");
            requestOrderList(true);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MyOrderListFragment(int i, int i2, m40 m40) {
        this((i2 & 1) != 0 ? 0 : i);
    }
}
