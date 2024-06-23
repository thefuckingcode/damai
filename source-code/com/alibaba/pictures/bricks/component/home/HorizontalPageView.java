package com.alibaba.pictures.bricks.component.home;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.component.home.HorizontalPageContract;
import com.alibaba.pictures.bricks.component.home.calendar.HomeCalendarPresent;
import com.alibaba.pictures.bricks.component.home.calendar.NIndicator;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.alient.onearch.adapter.component.horizontal.GenericHorizontalView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.common.Constants;
import com.uc.webview.export.cyclone.StatAction;
import com.youku.arch.v3.data.Constants;
import com.youku.arch.v3.util.ViewUtil;
import com.youku.gaiax.js.utils.Log;
import com.youku.middlewareservice.provider.kvdata.SPProviderProxy;
import java.util.Map;
import kotlin.jvm.internal.Ref$IntRef;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.f90;
import tb.k21;
import tb.m40;
import tb.u50;
import tb.wn;

/* compiled from: Taobao */
public final class HorizontalPageView extends GenericHorizontalView implements HorizontalPageContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);
    private static boolean SCROLLER_TAG;
    @NotNull
    private static final String SCROLLER_TAG_KEY = "HOME_CALENDAR_SCROLLER";
    @NotNull
    private final FrameLayout container;
    @NotNull
    private final NIndicator indicator;
    @NotNull
    private final View itemView;

    /* compiled from: Taobao */
    public final class HorizontalViewItemDecoration extends RecyclerView.ItemDecoration {
        private static transient /* synthetic */ IpChange $ipChange;
        private final int a;
        private final int b;
        private final int c;

        public HorizontalViewItemDecoration(HorizontalPageView horizontalPageView, int i, int i2, int i3, int i4) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect rect, int i, @NotNull RecyclerView recyclerView) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-916230543")) {
                ipChange.ipc$dispatch("-916230543", new Object[]{this, rect, Integer.valueOf(i), recyclerView});
                return;
            }
            k21.i(rect, "outRect");
            k21.i(recyclerView, "parent");
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if (adapter == null) {
                return;
            }
            if (i == 0) {
                int i2 = this.b;
                if (i2 != 0) {
                    rect.left = i2;
                } else {
                    rect.left = this.a;
                }
            } else if (i == adapter.getItemCount() - 1) {
                int i3 = this.c;
                if (i3 != 0) {
                    rect.right = i3;
                } else {
                    rect.right = this.a;
                }
                rect.left = this.a;
            } else {
                rect.left = this.a;
            }
        }
    }

    /* compiled from: Taobao */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @NotNull
        public final String a() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1433968088")) {
                return HorizontalPageView.SCROLLER_TAG_KEY;
            }
            return (String) ipChange.ipc$dispatch("1433968088", new Object[]{this});
        }

        public final void b(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1790975512")) {
                ipChange.ipc$dispatch("1790975512", new Object[]{this, Boolean.valueOf(z)});
                return;
            }
            HorizontalPageView.SCROLLER_TAG = z;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HorizontalPageView(@NotNull View view) {
        super(view);
        k21.i(view, "itemView");
        this.itemView = view;
        View findViewById = view.findViewById(R$id.indicator);
        k21.h(findViewById, "itemView.findViewById(R.id.indicator)");
        this.indicator = (NIndicator) findViewById;
        View findViewById2 = view.findViewById(R$id.container);
        k21.h(findViewById2, "itemView.findViewById(R.id.container)");
        this.container = (FrameLayout) findViewById2;
    }

    private final int getDimenId(Context context, Map<String, ? extends Object> map, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-740154445")) {
            return ((Integer) ipChange.ipc$dispatch("-740154445", new Object[]{this, context, map, str})).intValue();
        } else if (map.containsKey(str)) {
            return ViewUtil.getIdentifier(context, (String) map.get(str), Constants.DIMEN);
        } else {
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0058  */
    @Override // com.alibaba.pictures.bricks.component.home.HorizontalPageContract.View
    public void bindView(@Nullable JSONObject jSONObject) {
        int i;
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "940877923")) {
            ipChange.ipc$dispatch("940877923", new Object[]{this, jSONObject});
            return;
        }
        if (jSONObject != null) {
            try {
                Object obj = jSONObject.get(StatAction.KEY_TOTAL);
                if (obj != null) {
                    i = Integer.parseInt(obj.toString());
                    this.indicator.setVisibility(i <= 3 ? 0 : 8);
                    u50 u50 = u50.INSTANCE;
                    if (i <= 3) {
                        Context context = this.itemView.getContext();
                        k21.h(context, "itemView.context");
                        i2 = u50.b(context, 4);
                    } else {
                        Context context2 = this.itemView.getContext();
                        k21.h(context2, "itemView.context");
                        i2 = u50.b(context2, 1);
                    }
                    this.container.setPadding(0, 0, 0, i2);
                    if (i > 3 && !SCROLLER_TAG && !SPProviderProxy.getPreferenceBoolean(SCROLLER_TAG_KEY)) {
                        Ref$IntRef ref$IntRef = new Ref$IntRef();
                        u50 u502 = u50.INSTANCE;
                        Context context3 = getRecyclerView().getContext();
                        k21.h(context3, "recyclerView.context");
                        Context context4 = getRecyclerView().getContext();
                        k21.h(context4, "recyclerView.context");
                        ref$IntRef.element = (DisplayMetrics.getwidthPixels(u502.f(context3)) / 6) + u502.b(context4, 18);
                        Job unused = f.b(wn.a(f90.b()), null, null, new HorizontalPageView$bindView$3(this, ref$IntRef, null), 3, null);
                        return;
                    }
                    return;
                }
            } catch (NumberFormatException e) {
                String message = e.getMessage();
                if (message != null) {
                    Log.INSTANCE.e(message);
                }
            }
        }
        i = 0;
        this.indicator.setVisibility(i <= 3 ? 0 : 8);
        u50 u503 = u50.INSTANCE;
        if (i <= 3) {
        }
        this.container.setPadding(0, 0, 0, i2);
        if (i > 3) {
        }
    }

    @NotNull
    public final View getItemView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "682128175")) {
            return this.itemView;
        }
        return (View) ipChange.ipc$dispatch("682128175", new Object[]{this});
    }

    @Override // com.alient.onearch.adapter.component.horizontal.GenericHorizontalContract.View, com.alient.onearch.adapter.component.horizontal.GenericHorizontalView
    public void initRecyclerSettings(@Nullable RecyclerView.RecycledViewPool recycledViewPool, @Nullable Map<String, ? extends Object> map) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1493016261")) {
            ipChange.ipc$dispatch("1493016261", new Object[]{this, recycledViewPool, map});
            return;
        }
        super.initRecyclerSettings(recycledViewPool, map);
        if (map != null) {
            int dimenId = getDimenId(getRecyclerView().getContext(), map, Constants.GAP);
            int dimensionPixelSize = dimenId != 0 ? getRecyclerView().getContext().getResources().getDimensionPixelSize(dimenId) : 0;
            int dimenId2 = getDimenId(getRecyclerView().getContext(), map, "listMarginLeft");
            int dimensionPixelSize2 = dimenId2 != 0 ? getRecyclerView().getContext().getResources().getDimensionPixelSize(dimenId2) : 0;
            int dimenId3 = getDimenId(getRecyclerView().getContext(), map, "listMarginRight");
            int dimensionPixelSize3 = dimenId3 != 0 ? getRecyclerView().getContext().getResources().getDimensionPixelSize(dimenId3) : 0;
            if (map.get(Constants.Name.COLUMN_COUNT) == null) {
                i = 0;
            } else {
                Object obj = map.get(Constants.Name.COLUMN_COUNT);
                k21.g(obj, "null cannot be cast to non-null type kotlin.Int");
                i = ((Integer) obj).intValue();
            }
            getRecyclerView().removeItemDecorationAt(getRecyclerView().getItemDecorationCount() - 1);
            getRecyclerView().addItemDecoration(new HorizontalViewItemDecoration(this, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, i));
            this.indicator.bindRecyclerView(getRecyclerView());
            HomeCalendarPresent.Companion.a(0);
        }
    }
}
