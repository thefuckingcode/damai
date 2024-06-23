package com.alibaba.pictures.bricks.component.channel;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.projectfiltercopy.FilterViewManager;
import cn.damai.projectfiltercopy.bean.FilterResponse;
import cn.damai.projectfiltercopy.bean.PresetBean;
import cn.damai.projectfiltercopy.bean.Type;
import cn.damai.projectfiltercopy.listener.FilterBtnAction;
import com.alibaba.pictures.bricks.channel.bean.StyleFilter;
import com.alibaba.pictures.bricks.channel.component.ProjectFilterComponent;
import com.alibaba.pictures.bricks.channel.component.ProjectListComponent;
import com.alient.onearch.adapter.BaseFragment;
import com.alient.onearch.adapter.view.AbsPresenter;
import com.alient.oneservice.ut.TrackInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.page.GenericFragment;
import com.youku.arch.v3.style.Style;
import java.util.List;
import kotlin.collections.k;
import tb.au1;
import tb.e92;
import tb.k21;
import tb.ni0;
import tb.ue;
import tb.wm2;

public final class ProjectFilterPresent extends AbsPresenter<GenericItem<ItemValue>, ProjectFilterModel, ProjectFilterView> {
    private static transient /* synthetic */ IpChange $ipChange;
    private GenericItem<ItemValue> mLastItem;
    private FilterViewManager mViewManager;

    public static final class a implements FilterBtnAction {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ProjectFilterPresent a;

        a(ProjectFilterPresent projectFilterPresent) {
            this.a = projectFilterPresent;
        }

        @Override // cn.damai.projectfiltercopy.listener.FilterBtnAction
        public int computeFloatTopPadding(Type type) {
            View renderView;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-968574228")) {
                return ((Integer) ipChange.ipc$dispatch("-968574228", new Object[]{this, type})).intValue();
            }
            if (Type.DATE_HOR_CALENDAR == type || (renderView = ((ProjectFilterView) this.a.getView()).getRenderView()) == null) {
                return 0;
            }
            ProjectFilterPresent projectFilterPresent = this.a;
            if (renderView.getParent() == null) {
                return 0;
            }
            FilterViewManager filterViewManager = projectFilterPresent.mViewManager;
            int j = filterViewManager != null ? filterViewManager.j() : 0;
            FilterViewManager filterViewManager2 = projectFilterPresent.mViewManager;
            int h = filterViewManager2 != null ? filterViewManager2.h() : 0;
            int top = renderView.getTop() + j;
            if (top < -5 || top > 5) {
                return 0;
            }
            return h;
        }

        @Override // cn.damai.projectfiltercopy.listener.FilterBtnAction
        public void doBeforeFilterBtnClick(Type type) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2041147948")) {
                ipChange.ipc$dispatch("2041147948", new Object[]{this, type});
                return;
            }
            this.a.dispatchScroll2TopFilterView();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProjectFilterPresent(String str, String str2, View view, EventHandler eventHandler, String str3) {
        super(str, str2, view, eventHandler, str3);
        k21.i(str, "mClassName");
        k21.i(str2, "vClassName");
        k21.i(eventHandler, "eventHandler");
    }

    private final void dispatchScroll2TopFilterView() {
        View renderView;
        GenericFragment fragment;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1948372250")) {
            ipChange.ipc$dispatch("1948372250", new Object[]{this});
            return;
        }
        try {
            FilterViewManager filterViewManager = this.mViewManager;
            if (filterViewManager != null && (renderView = ((ProjectFilterView) getView()).getRenderView()) != null && (fragment = ((GenericItem) getItem()).getPageContext().getFragment()) != null) {
                RecyclerView recyclerView = fragment.getRecyclerView();
                if (recyclerView != null) {
                    int childAdapterPosition = recyclerView.getChildAdapterPosition(renderView);
                    int j = filterViewManager.j();
                    if (childAdapterPosition >= 0) {
                        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
                        if (linearLayoutManager != null) {
                            linearLayoutManager.scrollToPositionWithOffset(childAdapterPosition, -j);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: init$lambda-4$lambda-2 */
    public static final void m99init$lambda4$lambda2(GenericItem genericItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1122865661")) {
            ipChange.ipc$dispatch("1122865661", new Object[]{genericItem});
            return;
        }
        k21.i(genericItem, "$item");
        List<IComponent<ComponentValue>> components = genericItem.getComponent().getModule().getComponents();
        if (!e92.d(components)) {
            Object b0 = k.b0(components);
            ProjectListComponent projectListComponent = b0 instanceof ProjectListComponent ? (ProjectListComponent) b0 : null;
            if (projectListComponent != null) {
                projectListComponent.refresh();
            }
        }
    }

    public void init(GenericItem<ItemValue> genericItem) {
        Activity activity;
        Style style;
        ComponentValue property;
        TrackInfo trackInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "790930367")) {
            ipChange.ipc$dispatch("790930367", new Object[]{this, genericItem});
            return;
        }
        k21.i(genericItem, "item");
        super.init((IItem) genericItem);
        if ((!k21.d(genericItem, this.mLastItem) || this.mViewManager == null) && (activity = genericItem.getPageContext().getActivity()) != null) {
            this.mLastItem = genericItem;
            GenericFragment fragment = genericItem.getPageContext().getFragment();
            ViewGroup viewGroup = null;
            BaseFragment baseFragment = fragment instanceof BaseFragment ? (BaseFragment) fragment : null;
            String spmb = (baseFragment == null || (trackInfo = baseFragment.getTrackInfo()) == null) ? null : trackInfo.getSpmb();
            if (spmb == null) {
                spmb = ue.CALENDAR_PAGE;
            }
            PresetBean presetFromBundle = PresetBean.presetFromBundle(genericItem.getPageContext().getBundle());
            FilterResponse filterResponse = (FilterResponse) wm2.INSTANCE.j(genericItem.getProperty().getData(), FilterResponse.class);
            IComponent<ComponentValue> component = genericItem.getComponent();
            ProjectFilterComponent projectFilterComponent = component instanceof ProjectFilterComponent ? (ProjectFilterComponent) component : null;
            FrameLayout frameLayout = new FrameLayout(activity);
            frameLayout.setVisibility(8);
            if (projectFilterComponent != null) {
                projectFilterComponent.addView2RecyclerViewContainer(frameLayout);
            }
            if (projectFilterComponent == null || (property = projectFilterComponent.getProperty()) == null || (style = property.getStyle()) == null) {
                style = genericItem.getProperty().getStyle();
            }
            Object styleValue = style != null ? style.getStyleValue("topRound") : null;
            String str = styleValue instanceof String ? (String) styleValue : null;
            Object styleValue2 = style != null ? style.getStyleValue("calendarStyle") : null;
            StyleFilter styleFilter = new StyleFilter(styleValue2 instanceof String ? (String) styleValue2 : null, null, str);
            FilterViewManager filterViewManager = new FilterViewManager(activity, frameLayout, new ni0(spmb));
            filterViewManager.l(filterResponse, styleFilter, presetFromBundle);
            if (projectFilterComponent != null) {
                projectFilterComponent.setRequestParamProvider(filterViewManager.i());
            }
            filterViewManager.i().setParamChangeListener(new au1(genericItem));
            filterViewManager.m(new a(this));
            View itemView = ((ProjectFilterView) getView()).getItemView();
            if (itemView instanceof ViewGroup) {
                viewGroup = (ViewGroup) itemView;
            }
            if (viewGroup != null) {
                viewGroup.removeAllViews();
                viewGroup.addView(filterViewManager.k(), -1, -2);
            }
            this.mViewManager = filterViewManager;
            ((ProjectFilterView) getView()).bind(filterResponse);
        }
    }
}
