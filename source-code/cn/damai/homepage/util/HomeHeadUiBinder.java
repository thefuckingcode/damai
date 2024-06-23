package cn.damai.homepage.util;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.AppConfig;
import cn.damai.homepage.R$id;
import cn.damai.homepage.ui.view.HomePageGuideBar;
import cn.damai.uikit.refresh.footer.SimpleHeader;
import com.alibaba.pictures.bricks.component.home.State;
import com.alibaba.pictures.bricks.component.home.StateAtmo;
import com.alibaba.pictures.bricks.view.AttachFrameLayout;
import com.alient.onearch.adapter.style.StyleConstant;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.taobao.weex.common.Constants;
import com.youku.arch.v3.event.RefreshEvent;
import com.youku.kubus.Event;
import java.util.HashMap;
import java.util.Map;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.aw0;
import tb.bw0;
import tb.f8;
import tb.g91;
import tb.k21;

/* compiled from: Taobao */
public final class HomeHeadUiBinder extends RecyclerView.OnScrollListener {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private final View a;
    @Nullable
    private final HomePageGuideBar b;
    @Nullable
    private final RecyclerView c;
    @Nullable
    private SimpleHeader d;
    @Nullable
    private View e;
    @Nullable
    private SmartRefreshLayout f;
    @Nullable
    private View g;
    private int h;
    private boolean i;
    @Nullable
    private StateAtmo j;

    public HomeHeadUiBinder(@Nullable View view, @Nullable HomePageGuideBar homePageGuideBar, @Nullable RecyclerView recyclerView) {
        this.a = view;
        this.b = homePageGuideBar;
        this.c = recyclerView;
        ViewGroup.LayoutParams layoutParams = null;
        this.d = view != null ? (SimpleHeader) view.findViewById(R$id.one_arch_header) : null;
        this.e = view != null ? view.findViewById(R$id.home_pull_refresh_bg) : null;
        this.f = view != null ? (SmartRefreshLayout) view.findViewById(R$id.one_arch_refresh_layout) : null;
        this.g = view != null ? view.findViewById(R$id.home_head_default_bg) : null;
        this.j = new StateAtmo(State.NONE, null);
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(this);
        }
        if (homePageGuideBar != null) {
            this.h = homePageGuideBar.getGuideLayoutHeight();
            View view2 = this.e;
            layoutParams = view2 != null ? view2.getLayoutParams() : layoutParams;
            if (layoutParams != null) {
                layoutParams.height = this.h;
            }
        }
        SimpleHeader simpleHeader = this.d;
        if (simpleHeader != null) {
            simpleHeader.setPullDownToRefreshText("下拉刷新");
            simpleHeader.setReleaseToRefreshText("松开刷新");
            simpleHeader.setRefreshingText("正在刷新…");
        }
    }

    /* access modifiers changed from: private */
    public static final void e(HomeHeadUiBinder homeHeadUiBinder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1107429335")) {
            ipChange.ipc$dispatch("-1107429335", new Object[]{homeHeadUiBinder});
            return;
        }
        k21.i(homeHeadUiBinder, "this$0");
        homeHeadUiBinder.f(new StateAtmo(State.NONE, null));
    }

    /* access modifiers changed from: private */
    public static final void g(HomeHeadUiBinder homeHeadUiBinder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1422611311")) {
            ipChange.ipc$dispatch("-1422611311", new Object[]{homeHeadUiBinder});
            return;
        }
        k21.i(homeHeadUiBinder, "this$0");
        homeHeadUiBinder.h();
    }

    private final void h() {
        State state;
        int i2;
        int c2;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1164619545")) {
            ipChange.ipc$dispatch("-1164619545", new Object[]{this});
            return;
        }
        StateAtmo stateAtmo = this.j;
        if (stateAtmo == null) {
            View view = this.g;
            if (view != null) {
                view.setVisibility(0);
            }
            HomePageGuideBar homePageGuideBar = this.b;
            if (homePageGuideBar != null) {
                homePageGuideBar.showTransBg(false);
            }
        } else if (stateAtmo != null && (state = stateAtmo.getState()) != null) {
            State.a aVar = State.Companion;
            if (!aVar.a(state) || (c2 = f8.INSTANCE.c()) == -10000 || c2 < -50) {
                z = false;
            }
            HomePageGuideBar homePageGuideBar2 = this.b;
            if (homePageGuideBar2 != null && !k21.d(homePageGuideBar2.isInTransBgState(), Boolean.valueOf(z))) {
                homePageGuideBar2.showTransBg(z);
            }
            if (!aVar.a(state)) {
                int a2 = AttachFrameLayout.Companion.a();
                if (a2 == -10000 || (i2 = -a2) < 0) {
                    i2 = 0;
                }
                View view2 = this.g;
                if (view2 != null) {
                    view2.setVisibility(0);
                }
                View view3 = this.g;
                if (view3 != null) {
                    view3.scrollTo(0, i2);
                    return;
                }
                return;
            }
            View view4 = this.g;
            if (view4 != null) {
                view4.setVisibility(8);
            }
        }
    }

    private final void i(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1137528386")) {
            ipChange.ipc$dispatch("-1137528386", new Object[]{this, str, str2});
        } else if (AppConfig.v()) {
            g91.c(str2, str);
        }
    }

    static /* synthetic */ void j(HomeHeadUiBinder homeHeadUiBinder, String str, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = "HomeUI";
        }
        homeHeadUiBinder.i(str, str2);
    }

    public final void c(@NotNull Event event) {
        ViewGroup.LayoutParams layoutParams;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-737416433")) {
            ipChange.ipc$dispatch("-737416433", new Object[]{this, event});
            return;
        }
        k21.i(event, "event");
        try {
            Object obj = event.data;
            if (obj instanceof HashMap) {
                float f2 = 1.0f;
                if (k21.d(event.type, RefreshEvent.ON_HEADER_MOVING)) {
                    if (this.i) {
                        Object obj2 = ((Map) obj).get("percent");
                        k21.g(obj2, "null cannot be cast to non-null type kotlin.Float");
                        float floatValue = ((Float) obj2).floatValue();
                        Object obj3 = ((Map) obj).get("offset");
                        k21.g(obj3, "null cannot be cast to non-null type kotlin.Int");
                        int intValue = ((Integer) obj3).intValue();
                        Object obj4 = ((Map) obj).get(Constants.Name.ISDRAGGING);
                        k21.g(obj4, "null cannot be cast to non-null type kotlin.Boolean");
                        boolean booleanValue = ((Boolean) obj4).booleanValue();
                        Object obj5 = ((Map) obj).get(StyleConstant.HEADER_HEIGHT);
                        k21.g(obj5, "null cannot be cast to non-null type kotlin.Int");
                        int intValue2 = ((Integer) obj5).intValue();
                        Object obj6 = ((Map) obj).get("maxDragHeight");
                        k21.g(obj6, "null cannot be cast to non-null type kotlin.Int");
                        int intValue3 = ((Integer) obj6).intValue();
                        SmartRefreshLayout smartRefreshLayout = this.f;
                        if (smartRefreshLayout != null) {
                            boolean z2 = intValue != 0;
                            smartRefreshLayout.setClipChildren(z2);
                            smartRefreshLayout.setClipToPadding(z2);
                        }
                        float f3 = ((float) 3) * floatValue;
                        if (f3 > 1.0f) {
                            f3 = 1.0f;
                        }
                        float f4 = 1.0f - f3;
                        if (f4 <= 1.0f) {
                            f2 = f4 < 0.0f ? 0.0f : f4;
                        }
                        View view = this.e;
                        if (!(view == null || (layoutParams = view.getLayoutParams()) == null)) {
                            k21.h(layoutParams, "layoutParams");
                            int i2 = layoutParams.height;
                            int i3 = this.h;
                            if (i3 + intValue != i2) {
                                layoutParams.height = i3 + intValue;
                                view.requestLayout();
                            }
                        }
                        HomePageGuideBar homePageGuideBar = this.b;
                        if (homePageGuideBar != null) {
                            if (f2 != homePageGuideBar.getAlpha()) {
                                z = false;
                            }
                            if (!z) {
                                homePageGuideBar.setAlpha(f2);
                            }
                        }
                        if (AppConfig.v()) {
                            j(this, "onMoving isDragging=" + booleanValue + " percent=" + floatValue + " offset=" + intValue + " headerHeight=" + intValue2 + " maxDragHeight=" + intValue3, null, 2, null);
                        }
                    }
                } else if (k21.d(event.type, RefreshEvent.ON_REFRESH_STATE_CHANGED)) {
                    Object obj7 = ((Map) obj).get("newState");
                    if (obj7 instanceof RefreshState) {
                        j(this, "refresh state " + ((RefreshState) obj7).name(), null, 2, null);
                        if (o.L(((RefreshState) obj7).name(), "PullDown", false, 2, null)) {
                            this.i = true;
                            View view2 = this.e;
                            if (view2 != null) {
                                view2.setVisibility(0);
                            }
                            SimpleHeader simpleHeader = this.d;
                            if (simpleHeader != null) {
                                simpleHeader.setVisibility(0);
                            }
                        }
                        if (obj7 == RefreshState.None) {
                            if (this.i) {
                                SimpleHeader simpleHeader2 = this.d;
                                if (simpleHeader2 != null) {
                                    simpleHeader2.setVisibility(4);
                                }
                                View view3 = this.e;
                                if (view3 != null) {
                                    view3.setVisibility(4);
                                }
                                HomePageGuideBar homePageGuideBar2 = this.b;
                                if (homePageGuideBar2 != null) {
                                    homePageGuideBar2.setAlpha(1.0f);
                                }
                            }
                            this.i = false;
                        }
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "509026294")) {
            ipChange.ipc$dispatch("509026294", new Object[]{this});
            return;
        }
        aw0 aw0 = new aw0(this);
        if (k21.d(Thread.currentThread(), Looper.getMainLooper().getThread())) {
            aw0.run();
        } else {
            new Handler(Looper.getMainLooper()).post(aw0);
        }
    }

    public final void f(@NotNull StateAtmo stateAtmo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2012628594")) {
            ipChange.ipc$dispatch("-2012628594", new Object[]{this, stateAtmo});
            return;
        }
        k21.i(stateAtmo, "stateAtmo");
        this.j = stateAtmo;
        HomePageGuideBar homePageGuideBar = this.b;
        if (homePageGuideBar != null) {
            homePageGuideBar.post(new bw0(this));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "176362462")) {
            ipChange.ipc$dispatch("176362462", new Object[]{this, recyclerView, Integer.valueOf(i2)});
            return;
        }
        k21.i(recyclerView, "recyclerView");
        if (i2 == 0) {
            h();
        }
        String str = i2 != 0 ? i2 != 1 ? "settling" : "dragging" : "idle";
        i("scroll state " + str, "HomeScroll");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(@NotNull RecyclerView recyclerView, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "755790465")) {
            ipChange.ipc$dispatch("755790465", new Object[]{this, recyclerView, Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        k21.i(recyclerView, "recyclerView");
        h();
    }
}
