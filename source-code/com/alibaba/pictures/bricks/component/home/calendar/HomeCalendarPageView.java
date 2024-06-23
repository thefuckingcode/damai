package com.alibaba.pictures.bricks.component.home.calendar;

import android.content.Context;
import android.view.View;
import android.widget.Scroller;
import androidx.viewpager.widget.ViewPager;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.alient.onearch.adapter.component.pager.PagerGridView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import java.lang.reflect.Field;
import java.util.List;
import kotlin.jvm.internal.Ref$IntRef;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.f;
import tb.f90;
import tb.k21;
import tb.m40;
import tb.u50;
import tb.wn;

public final class HomeCalendarPageView extends PagerGridView {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final a Companion = new a(null);
    private static boolean SCROLLER_TAG;
    private static final String SCROLLER_TAG_KEY = "HOME_CALENDAR_SCROLLER";
    private Scroller customScroller;

    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        public final boolean a() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "2067890782")) {
                return HomeCalendarPageView.SCROLLER_TAG;
            }
            return ((Boolean) ipChange.ipc$dispatch("2067890782", new Object[]{this})).booleanValue();
        }

        public final String b() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-533828218")) {
                return HomeCalendarPageView.SCROLLER_TAG_KEY;
            }
            return (String) ipChange.ipc$dispatch("-533828218", new Object[]{this});
        }

        public final void c(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1863577402")) {
                ipChange.ipc$dispatch("-1863577402", new Object[]{this, Boolean.valueOf(z)});
                return;
            }
            HomeCalendarPageView.SCROLLER_TAG = z;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeCalendarPageView(View view) {
        super(view);
        k21.i(view, "contentView");
    }

    private final void customScroller() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "182012274")) {
            ipChange.ipc$dispatch("182012274", new Object[]{this});
            return;
        }
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            declaredField.set(getGridViewPager(), this.customScroller);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.alient.onearch.adapter.component.pager.PagerGridContract.View, com.alient.onearch.adapter.component.pager.PagerGridView
    public void renderPagerInView(int i, int i2, int i3, int i4, int i5, List<? extends VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-869818338")) {
            ipChange.ipc$dispatch("-869818338", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), list});
            return;
        }
        k21.i(list, "childAdapters");
        super.renderPagerInView(i, i2, i3, i4, i5, list);
        HomeCalendarPresent.Companion.a(0);
        this.customScroller = new Scroller(getGridViewPager().getContext());
        customScroller();
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        u50 u50 = u50.INSTANCE;
        Context context = getGridViewPager().getContext();
        k21.h(context, "gridViewPager.context");
        Context context2 = getGridViewPager().getContext();
        k21.h(context2, "gridViewPager.context");
        ref$IntRef.element = (DisplayMetrics.getwidthPixels(u50.f(context)) / 6) + u50.b(context2, 18);
        Job unused = f.b(wn.a(f90.b()), null, null, new HomeCalendarPageView$renderPagerInView$1(list, this, ref$IntRef, null), 3, null);
    }
}
