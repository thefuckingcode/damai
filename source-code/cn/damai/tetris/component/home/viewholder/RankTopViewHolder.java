package cn.damai.tetris.component.home.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.view.DmViewPager;
import cn.damai.tetris.component.home.adapter.RankTopPagerAdapter;
import cn.damai.tetris.component.home.bean.HomePageRankBean;
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
import tb.v50;
import tb.xf2;
import tb.xs0;
import tb.zw0;

/* compiled from: Taobao */
public class RankTopViewHolder extends CommonViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private int currentTabIndex = 0;
    private Map<Integer, List<HomePageRankBean.Content.RankLists>> dataMap = new HashMap();
    private boolean isSectionChanged;
    private Context mContext = xs0.a();
    private String mModuleTitle;
    private LinearLayout mModuleTitleMoreLayout = ((LinearLayout) this.itemView.findViewById(R$id.homepage_rank_top_more_layout));
    private TextView mModuleTitleMoreText = ((TextView) this.itemView.findViewById(R$id.homepage_rank_top_more_text));
    private View.OnClickListener mOnClickListener = new a();
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() {
        /* class cn.damai.tetris.component.home.viewholder.RankTopViewHolder.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "284594392")) {
                ipChange.ipc$dispatch("284594392", new Object[]{this, Integer.valueOf(i)});
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1041724791")) {
                ipChange.ipc$dispatch("1041724791", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-397074909")) {
                ipChange.ipc$dispatch("-397074909", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            RankTopViewHolder.this.mTabLayout.selectTitle(i);
        }
    };
    private View.OnClickListener mOnTabItemClickListener = new b();
    private RankTopPagerAdapter mPagerAdapter;
    private HomeTabScrollView mTabLayout;
    private TrackInfo mTrackInfo;
    private DmViewPager mViewPager;
    private List<ScrollTitleBean> tabs = new ArrayList();

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-998684869")) {
                ipChange.ipc$dispatch("-998684869", new Object[]{this, view});
                return;
            }
            zw0.B().k(RankTopViewHolder.this.mTrackInfo, RankTopViewHolder.this.mModuleTitle);
            DMNav.from(RankTopViewHolder.this.mContext).toUri(NavUri.b("rank_square"));
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1112605500")) {
                ipChange.ipc$dispatch("1112605500", new Object[]{this, view});
                return;
            }
            ScrollTitleBean scrollTitleBean = (ScrollTitleBean) view.getTag();
            RankTopViewHolder.this.currentTabIndex = scrollTitleBean.index;
            String str = ((ScrollTitleBean) RankTopViewHolder.this.tabs.get(scrollTitleBean.index)).name;
            if (RankTopViewHolder.this.mViewPager != null) {
                RankTopViewHolder.this.mViewPager.setCurrentItem(RankTopViewHolder.this.currentTabIndex, true);
            }
            zw0.B().l(RankTopViewHolder.this.mTrackInfo, RankTopViewHolder.this.mModuleTitle, str, scrollTitleBean.index);
        }
    }

    public RankTopViewHolder(View view) {
        super(view);
        this.mModuleTitleMoreLayout.setOnClickListener(this.mOnClickListener);
        initTabLayout();
        initViewPager();
        this.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    private void initTabLayout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1822589887")) {
            ipChange.ipc$dispatch("1822589887", new Object[]{this});
            return;
        }
        HomeTabScrollView homeTabScrollView = (HomeTabScrollView) this.itemView.findViewById(R$id.homepage_rank_top_tablayout);
        this.mTabLayout = homeTabScrollView;
        homeTabScrollView.setFontColor(R$color.color_000000, R$color.color_9c9ca5).setFontSize(16, 20).setHeight(39).setSpace(18).setOnTitleClickListener(this.mOnTabItemClickListener);
    }

    private void initViewPager() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-42750368")) {
            ipChange.ipc$dispatch("-42750368", new Object[]{this});
            return;
        }
        this.mViewPager = (DmViewPager) this.itemView.findViewById(R$id.homepage_rank_top_viewpager);
        RankTopPagerAdapter rankTopPagerAdapter = new RankTopPagerAdapter();
        this.mPagerAdapter = rankTopPagerAdapter;
        this.mViewPager.setAdapter(rankTopPagerAdapter);
        this.mViewPager.addOnPageChangeListener(this.mOnPageChangeListener);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mViewPager.getLayoutParams();
        layoutParams.weight = -1.0f;
        layoutParams.height = v50.a(this.mContext, 182.0f);
        this.mViewPager.setLayoutParams(layoutParams);
    }

    @Override // cn.damai.tetris.mvp.CommonViewHolder
    public void setData(CommonBean commonBean, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1810288801")) {
            ipChange.ipc$dispatch("1810288801", new Object[]{this, commonBean, Boolean.valueOf(z)});
            return;
        }
        this.isSectionChanged = z;
        super.setData(commonBean, z);
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.tetris.mvp.CommonViewHolder
    public void setData(CommonBean commonBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1188531053")) {
            ipChange.ipc$dispatch("-1188531053", new Object[]{this, commonBean});
        } else if ((commonBean instanceof HomePageRankBean) && this.isSectionChanged) {
            this.mTrackInfo = commonBean.trackInfo;
            HomePageRankBean homePageRankBean = (HomePageRankBean) commonBean;
            this.mModuleTitle = homePageRankBean.mainTitle;
            this.mModuleTitleMoreText.setText("广场");
            this.mModuleTitleMoreLayout.setVisibility(0);
            this.dataMap.clear();
            this.dataMap = homePageRankBean.getDataMap();
            this.tabs.clear();
            ArrayList<String> labels = homePageRankBean.getLabels();
            int e = xf2.e(labels);
            for (int i = 0; i < e; i++) {
                ScrollTitleBean scrollTitleBean = new ScrollTitleBean();
                scrollTitleBean.id = String.valueOf(i);
                scrollTitleBean.name = labels.get(i);
                scrollTitleBean.index = i;
                this.tabs.add(scrollTitleBean);
            }
            this.mTabLayout.setTitle(this.tabs).commit();
            this.mPagerAdapter.a(labels, this.dataMap, this.mTrackInfo);
            this.currentTabIndex = 0;
            this.mTabLayout.selectTitle(0);
            this.mViewPager.setCurrentItem(this.currentTabIndex);
        }
    }
}
