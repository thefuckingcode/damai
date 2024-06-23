package cn.damai.tetris.component.common;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.view.DmViewPager;
import cn.damai.tetris.component.home.widget.HomeTabScrollView;
import cn.damai.tetris.core.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.v50;

/* compiled from: Taobao */
public class BaseTabView extends AbsView<BaseTabContract$Presenter> implements BaseTabContract$View<BaseTabContract$Presenter> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context mContext;
    private LinearLayout mModuleTitleMoreLayout = ((LinearLayout) getView().findViewById(R$id.homepage_rank_top_more_layout));
    private TextView mModuleTitleMoreTextView = ((TextView) getView().findViewById(R$id.homepage_rank_top_more_text));
    private BaseTabViewPagerAdapter mPagerAdapter;
    private HomeTabScrollView mTabLayout;
    private DmViewPager mViewPager;

    public BaseTabView(View view) {
        super(view);
        this.mContext = view.getContext();
        initTabLayout();
        initViewPager();
        getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    private void initTabLayout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "802990260")) {
            ipChange.ipc$dispatch("802990260", new Object[]{this});
            return;
        }
        HomeTabScrollView homeTabScrollView = (HomeTabScrollView) getView().findViewById(R$id.homepage_rank_top_tablayout);
        this.mTabLayout = homeTabScrollView;
        homeTabScrollView.setFontColor(R$color.color_000000, R$color.color_9c9ca5).setFontSize(16, 20).setHeight(39).setSpace(18);
    }

    private void initViewPager() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1062349995")) {
            ipChange.ipc$dispatch("-1062349995", new Object[]{this});
            return;
        }
        this.mViewPager = (DmViewPager) getView().findViewById(R$id.homepage_rank_top_viewpager);
        BaseTabViewPagerAdapter baseTabViewPagerAdapter = new BaseTabViewPagerAdapter();
        this.mPagerAdapter = baseTabViewPagerAdapter;
        this.mViewPager.setAdapter(baseTabViewPagerAdapter);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mViewPager.getLayoutParams();
        layoutParams.weight = -1.0f;
        layoutParams.height = v50.a(this.mContext, 182.0f);
        this.mViewPager.setLayoutParams(layoutParams);
    }

    @Override // cn.damai.tetris.component.common.BaseTabContract$View
    public LinearLayout getModuleTitleMoreLayout() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1167626295")) {
            return this.mModuleTitleMoreLayout;
        }
        return (LinearLayout) ipChange.ipc$dispatch("-1167626295", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.common.BaseTabContract$View
    public TextView getModuleTitleMoreTextView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-386340130")) {
            return this.mModuleTitleMoreTextView;
        }
        return (TextView) ipChange.ipc$dispatch("-386340130", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.common.BaseTabContract$View
    public BaseTabViewPagerAdapter getPagerAdapter() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1165028454")) {
            return this.mPagerAdapter;
        }
        return (BaseTabViewPagerAdapter) ipChange.ipc$dispatch("1165028454", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.common.BaseTabContract$View
    public HomeTabScrollView getTabLayout() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-143894385")) {
            return this.mTabLayout;
        }
        return (HomeTabScrollView) ipChange.ipc$dispatch("-143894385", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.common.BaseTabContract$View
    public DmViewPager getViewPager() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1155860402")) {
            return this.mViewPager;
        }
        return (DmViewPager) ipChange.ipc$dispatch("1155860402", new Object[]{this});
    }
}
