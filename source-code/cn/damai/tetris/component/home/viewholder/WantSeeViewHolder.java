package cn.damai.tetris.component.home.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.view.DmViewPager;
import cn.damai.tetris.component.home.adapter.RecentShowPagerAdapter;
import cn.damai.tetris.component.home.bean.HomePageRecentBean;
import cn.damai.tetris.component.home.widget.HomeTabScrollView;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.mvp.CommonBean;
import cn.damai.tetris.mvp.CommonViewHolder;
import cn.damai.uikit.snake.ScrollTitleBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.oy2;
import tb.v50;
import tb.xf2;
import tb.xs0;
import tb.zw0;

/* compiled from: Taobao */
public final class WantSeeViewHolder extends CommonViewHolder<HomePageRecentBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    private int currentTabIndex;
    @NotNull
    private Map<Integer, ArrayList<HomePageRecentBean.Labels.HomePageRecentItems>> dataMap = new HashMap();
    private boolean isSectionChanged;
    @Nullable
    private Context mContext = xs0.a();
    @Nullable
    private String mModuleTitle;
    @NotNull
    private final ViewPager.OnPageChangeListener mOnPageChangeListener = new WantSeeViewHolder$mOnPageChangeListener$1(this);
    @NotNull
    private final View.OnClickListener mOnTabItemClickListener = new oy2(this);
    @Nullable
    private RecentShowPagerAdapter mPagerAdapter;
    @Nullable
    private HomeTabScrollView mTabLayout;
    @Nullable
    private TrackInfo mTrackInfo;
    @Nullable
    private DmViewPager mViewPager;
    @NotNull
    private final List<ScrollTitleBean> tabs = new ArrayList();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WantSeeViewHolder(@NotNull View view) {
        super(view);
        k21.i(view, "view");
        initTabLayout();
        initViewPager();
        this.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    private final void initTabLayout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1111439515")) {
            ipChange.ipc$dispatch("-1111439515", new Object[]{this});
            return;
        }
        View findViewById = this.itemView.findViewById(R$id.homepage_want_see_tablayout);
        k21.g(findViewById, "null cannot be cast to non-null type cn.damai.tetris.component.home.widget.HomeTabScrollView");
        HomeTabScrollView homeTabScrollView = (HomeTabScrollView) findViewById;
        this.mTabLayout = homeTabScrollView;
        k21.f(homeTabScrollView);
        homeTabScrollView.setFontColor(R$color.color_000000, R$color.color_9c9ca5).setFontSize(16, 20).setHeight(39).setSpace(18).setOnTitleClickListener(this.mOnTabItemClickListener);
    }

    private final void initViewPager() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1318187526")) {
            ipChange.ipc$dispatch("1318187526", new Object[]{this});
            return;
        }
        View findViewById = this.itemView.findViewById(R$id.homepage_want_see_viewpager);
        k21.g(findViewById, "null cannot be cast to non-null type cn.damai.commonbusiness.view.DmViewPager");
        this.mViewPager = (DmViewPager) findViewById;
        this.mPagerAdapter = new RecentShowPagerAdapter();
        DmViewPager dmViewPager = this.mViewPager;
        k21.f(dmViewPager);
        dmViewPager.setAdapter(this.mPagerAdapter);
        DmViewPager dmViewPager2 = this.mViewPager;
        k21.f(dmViewPager2);
        dmViewPager2.addOnPageChangeListener(this.mOnPageChangeListener);
        DmViewPager dmViewPager3 = this.mViewPager;
        k21.f(dmViewPager3);
        ViewGroup.LayoutParams layoutParams = dmViewPager3.getLayoutParams();
        k21.g(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        layoutParams2.weight = -1.0f;
        layoutParams2.height = v50.a(this.mContext, 234.0f);
        DmViewPager dmViewPager4 = this.mViewPager;
        k21.f(dmViewPager4);
        dmViewPager4.setLayoutParams(layoutParams2);
    }

    /* access modifiers changed from: private */
    /* renamed from: mOnTabItemClickListener$lambda-0  reason: not valid java name */
    public static final void m66mOnTabItemClickListener$lambda0(WantSeeViewHolder wantSeeViewHolder, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1990564434")) {
            ipChange.ipc$dispatch("1990564434", new Object[]{wantSeeViewHolder, view});
            return;
        }
        k21.i(wantSeeViewHolder, "this$0");
        Object tag = view.getTag();
        k21.g(tag, "null cannot be cast to non-null type cn.damai.uikit.snake.ScrollTitleBean");
        ScrollTitleBean scrollTitleBean = (ScrollTitleBean) tag;
        int i = scrollTitleBean.index;
        wantSeeViewHolder.currentTabIndex = i;
        String str = wantSeeViewHolder.tabs.get(i).name;
        DmViewPager dmViewPager = wantSeeViewHolder.mViewPager;
        if (dmViewPager != null) {
            k21.f(dmViewPager);
            dmViewPager.setCurrentItem(wantSeeViewHolder.currentTabIndex, true);
        }
        zw0.B().A(wantSeeViewHolder.mTrackInfo, wantSeeViewHolder.mModuleTitle, str, scrollTitleBean.index);
    }

    @Override // cn.damai.tetris.mvp.CommonViewHolder
    public void setData(@Nullable CommonBean commonBean, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "880899387")) {
            ipChange.ipc$dispatch("880899387", new Object[]{this, commonBean, Boolean.valueOf(z)});
            return;
        }
        this.isSectionChanged = z;
        super.setData(commonBean, z);
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.tetris.mvp.CommonViewHolder
    public void setData(@NotNull CommonBean commonBean) {
        HomeTabScrollView title;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "582603961")) {
            ipChange.ipc$dispatch("582603961", new Object[]{this, commonBean});
            return;
        }
        k21.i(commonBean, "bean");
        if ((commonBean instanceof HomePageRecentBean) && this.isSectionChanged) {
            this.mTrackInfo = commonBean.trackInfo;
            HomePageRecentBean homePageRecentBean = (HomePageRecentBean) commonBean;
            this.mModuleTitle = homePageRecentBean.mainTitle;
            this.dataMap.clear();
            Map<Integer, ArrayList<HomePageRecentBean.Labels.HomePageRecentItems>> wantSeeDataMap = homePageRecentBean.getWantSeeDataMap();
            k21.h(wantSeeDataMap, "bean.wantSeeDataMap");
            this.dataMap = wantSeeDataMap;
            this.tabs.clear();
            ArrayList<String> content = homePageRecentBean.getContent();
            int e = xf2.e(content);
            for (int i = 0; i < e; i++) {
                ScrollTitleBean scrollTitleBean = new ScrollTitleBean();
                scrollTitleBean.id = String.valueOf(i);
                scrollTitleBean.name = content.get(i);
                scrollTitleBean.index = i;
                this.tabs.add(scrollTitleBean);
            }
            HomeTabScrollView homeTabScrollView = this.mTabLayout;
            if (!(homeTabScrollView == null || (title = homeTabScrollView.setTitle(this.tabs)) == null)) {
                title.commit();
            }
            zw0.B().H(this.mTrackInfo, this.mTabLayout, this.tabs);
            RecentShowPagerAdapter recentShowPagerAdapter = this.mPagerAdapter;
            if (recentShowPagerAdapter != null) {
                recentShowPagerAdapter.a(content, this.dataMap, this.mTrackInfo);
            }
            this.currentTabIndex = 0;
            HomeTabScrollView homeTabScrollView2 = this.mTabLayout;
            if (homeTabScrollView2 != null) {
                homeTabScrollView2.selectTitle(0);
            }
            DmViewPager dmViewPager = this.mViewPager;
            if (dmViewPager != null) {
                dmViewPager.setCurrentItem(this.currentTabIndex);
            }
        }
    }
}
