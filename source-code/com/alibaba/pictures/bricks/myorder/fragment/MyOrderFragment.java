package com.alibaba.pictures.bricks.myorder.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.alibaba.pictures.R$color;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.bricks.bean.ScrollTitleBean;
import com.alibaba.pictures.bricks.view.EqualLinearView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.jg1;
import tb.k21;
import tb.ur2;
import tb.vm1;

/* compiled from: Taobao */
public final class MyOrderFragment extends Fragment {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final Pair<Fragment[], String[]> pages;
    private EqualLinearView tabLayout;
    @Nullable
    private String userCode;
    @Nullable
    private ViewPager viewPager;

    public MyOrderFragment() {
        MyOrderListFragment myOrderListFragment = new MyOrderListFragment(0);
        myOrderListFragment.setArguments(getExtras());
        ur2 ur2 = ur2.INSTANCE;
        MyOrderListFragment myOrderListFragment2 = new MyOrderListFragment(2);
        myOrderListFragment2.setArguments(getExtras());
        MyOrderListFragment myOrderListFragment3 = new MyOrderListFragment(1);
        myOrderListFragment3.setArguments(getExtras());
        this.pages = new Pair<>(new Fragment[]{myOrderListFragment, myOrderListFragment2, myOrderListFragment3}, new String[]{"全部", "待付款", "可使用"});
    }

    private final Bundle getExtras() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "735753948")) {
            return getArguments();
        }
        return (Bundle) ipChange.ipc$dispatch("735753948", new Object[]{this});
    }

    private final void initView(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1103488750")) {
            ipChange.ipc$dispatch("1103488750", new Object[]{this, view});
            return;
        }
        View findViewById = view.findViewById(R$id.indicator);
        k21.h(findViewById, "root.findViewById(R.id.indicator)");
        this.tabLayout = (EqualLinearView) findViewById;
        ViewPager viewPager2 = (ViewPager) view.findViewById(R$id.view_pager);
        this.viewPager = viewPager2;
        if (viewPager2 != null) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            k21.h(childFragmentManager, "childFragmentManager");
            viewPager2.setAdapter(new MyOrderPagerAdapter(childFragmentManager, this.pages.getFirst(), this.pages.getSecond()));
        }
        ViewPager viewPager3 = this.viewPager;
        if (viewPager3 != null) {
            viewPager3.setOffscreenPageLimit(1);
        }
        ViewPager viewPager4 = this.viewPager;
        if (viewPager4 != null) {
            viewPager4.addOnPageChangeListener(new MyOrderFragment$initView$1(this));
        }
        setupTabsView();
        ViewPager viewPager5 = this.viewPager;
        if (viewPager5 != null) {
            viewPager5.setCurrentItem(0);
        }
        EqualLinearView equalLinearView = this.tabLayout;
        if (equalLinearView == null) {
            k21.A("tabLayout");
            equalLinearView = null;
        }
        equalLinearView.selectTitle(0);
    }

    private final void setupTabsView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1644973361")) {
            ipChange.ipc$dispatch("1644973361", new Object[]{this});
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.clear();
        String[] second = this.pages.getSecond();
        int length = second.length;
        for (int i = 0; i < length; i++) {
            ScrollTitleBean scrollTitleBean = new ScrollTitleBean();
            scrollTitleBean.index = i;
            scrollTitleBean.name = second[i];
            arrayList.add(scrollTitleBean);
        }
        EqualLinearView equalLinearView = this.tabLayout;
        EqualLinearView equalLinearView2 = null;
        if (equalLinearView == null) {
            k21.A("tabLayout");
            equalLinearView = null;
        }
        equalLinearView.setFontColor(R$color.bricks_EA416B, R$color.bricks_9C9CA5).setFontSize(14, 14).setTitle(arrayList).setHeight(44).setLineShow(false).setOnTitleClickListener(new jg1(this)).commit();
        vm1 vm1 = vm1.INSTANCE;
        EqualLinearView equalLinearView3 = this.tabLayout;
        if (equalLinearView3 == null) {
            k21.A("tabLayout");
            equalLinearView3 = null;
        }
        vm1.h(equalLinearView3.getChildAt(0), "all", this.userCode);
        EqualLinearView equalLinearView4 = this.tabLayout;
        if (equalLinearView4 == null) {
            k21.A("tabLayout");
            equalLinearView4 = null;
        }
        vm1.h(equalLinearView4.getChildAt(1), "usable", this.userCode);
        EqualLinearView equalLinearView5 = this.tabLayout;
        if (equalLinearView5 == null) {
            k21.A("tabLayout");
        } else {
            equalLinearView2 = equalLinearView5;
        }
        vm1.h(equalLinearView2.getChildAt(2), "pay", this.userCode);
    }

    /* access modifiers changed from: private */
    /* renamed from: setupTabsView$lambda-3  reason: not valid java name */
    public static final void m164setupTabsView$lambda3(MyOrderFragment myOrderFragment, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1608702337")) {
            ipChange.ipc$dispatch("-1608702337", new Object[]{myOrderFragment, view});
            return;
        }
        k21.i(myOrderFragment, "this$0");
        Object tag = view.getTag();
        k21.g(tag, "null cannot be cast to non-null type com.alibaba.pictures.bricks.bean.ScrollTitleBean");
        ScrollTitleBean scrollTitleBean = (ScrollTitleBean) tag;
        ViewPager viewPager2 = myOrderFragment.viewPager;
        if (viewPager2 != null && viewPager2 != null) {
            viewPager2.setCurrentItem(scrollTitleBean.index);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1365339734")) {
            ipChange.ipc$dispatch("1365339734", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-187744402")) {
            return (View) ipChange.ipc$dispatch("-187744402", new Object[]{this, layoutInflater, viewGroup, bundle});
        }
        k21.i(layoutInflater, "inflater");
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = LayoutInflater.from(getContext()).inflate(R$layout.bricks_fragment_order_script_murder_order_layout, viewGroup, false);
        k21.h(inflate, "root");
        initView(inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "993900399")) {
            ipChange.ipc$dispatch("993900399", new Object[]{this, view, bundle});
            return;
        }
        k21.i(view, "view");
        super.onViewCreated(view, bundle);
    }
}
