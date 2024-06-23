package com.alient.onearch.adapter.component.banner;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.ColorInt;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ali.user.mobile.app.constant.UTConstant;
import com.alibaba.gaiax.GXTemplateEngine;
import com.alient.onearch.adapter.R;
import com.taobao.weex.common.Constants;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.n;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;
import tb.r11;
import tb.w11;
import tb.ww1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 B2\u00020\u0001:\u0002BCB'\b\u0007\u0012\u0006\u0010<\u001a\u00020;\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010=\u0012\b\b\u0002\u0010?\u001a\u00020\u0006¢\u0006\u0004\b@\u0010AJ&\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u0002J\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0002J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0002J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\nH\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u0019\u001a\u00020\u0006H\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0002J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\u0010\u0010\u001e\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cJ\u0010\u0010!\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u001fH\u0014J\u0018\u0010$\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0006H\u0014R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010%R\u001c\u0010'\u001a\b\u0018\u00010&R\u00020\u00008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010,\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010-R\u0016\u0010/\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u0010-R\u0016\u00100\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u0010-R\u0016\u00101\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u0010-R\u0016\u00102\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u0010-R\u0016\u00103\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u0010-R\u0016\u00104\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00106\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b6\u00105R\u0016\u00107\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b7\u0010-R\u0016\u00108\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u0010-R\u0016\u00109\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b9\u0010:¨\u0006D"}, d2 = {"Lcom/alient/onearch/adapter/component/banner/PagerDotIndicator;", "Landroid/view/View;", "Landroid/graphics/Paint$Style;", "defaultStyle", "", "isAntiAliasDefault", "", "defaultColor", "Landroid/graphics/Paint;", "getDefaultPaintConfig", "", "coordinate", "Lkotlin/Pair;", "getXYPositionsByCoordinate", "position", "getDotCoordinate", "getDotYCoordinate", "getDistanceBetweenTheCenterOfTwoDots", "getRadius", "getPaint", "getCalculatedWidth", "dp", "dpToPx", "Ltb/ur2;", "removeAllSources", "getItemCount", "isRtl", "getRTLPosition", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "attachToRecyclerView", "Landroid/graphics/Canvas;", "canvas", "onDraw", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/alient/onearch/adapter/component/banner/PagerDotIndicator$InternalRecyclerScrollListener;", "internalRecyclerScrollListener", "Lcom/alient/onearch/adapter/component/banner/PagerDotIndicator$InternalRecyclerScrollListener;", "Landroid/view/animation/DecelerateInterpolator;", "interpolator", "Landroid/view/animation/DecelerateInterpolator;", "dotCount", "I", "fadingDotCount", "selectedDotRadiusPx", "dotRadiusPx", "dotSeparationDistancePx", "dotColor", "selectedDotColor", "selectedDotPaint", "Landroid/graphics/Paint;", "dotPaint", "selectedItemPosition", "intermediateSelectedItemPosition", "offsetPercent", UTConstant.Args.UT_SUCCESS_F, "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Landroid/util/AttributeSet;", TemplateDom.KEY_ATTRS, "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "InternalRecyclerScrollListener", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class PagerDotIndicator extends View {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int DEFAULT_DOT_COUNT = 5;
    private static final float DEFAULT_DOT_RADIUS_DP = 6.5f;
    private static final int DEFAULT_DOT_SEPARATION_DISTANCE_DP = 12;
    private static final int DEFAULT_FADING_DOT_COUNT = 10;
    private static final float DEFAULT_SELECTED_DOT_RADIUS_DP = 6.5f;
    @ColorInt
    private int dotColor;
    private int dotCount;
    private Paint dotPaint;
    private int dotRadiusPx;
    private int dotSeparationDistancePx;
    private int fadingDotCount;
    private int intermediateSelectedItemPosition;
    private InternalRecyclerScrollListener internalRecyclerScrollListener;
    private final DecelerateInterpolator interpolator;
    private float offsetPercent;
    private RecyclerView recyclerView;
    @ColorInt
    private int selectedDotColor;
    private Paint selectedDotPaint;
    private int selectedDotRadiusPx;
    private int selectedItemPosition;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00058\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\n\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/alient/onearch/adapter/component/banner/PagerDotIndicator$Companion;", "", "", "DEFAULT_DOT_COUNT", "I", "", "DEFAULT_DOT_RADIUS_DP", UTConstant.Args.UT_SUCCESS_F, "DEFAULT_DOT_SEPARATION_DISTANCE_DP", "DEFAULT_FADING_DOT_COUNT", "DEFAULT_SELECTED_DOT_RADIUS_DP", "<init>", "()V", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J \u0010\u000f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/alient/onearch/adapter/component/banner/PagerDotIndicator$InternalRecyclerScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroid/view/View;", "getMostVisibleChild", "child", "", "calculatePercentVisible", "mostVisibleChild", "Ltb/ur2;", "setIntermediateSelectedItemPosition", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", Constants.Name.DISTANCE_Y, GXTemplateEngine.f.TYPE_ON_SCROLLED, "previousMostVisibleChild", "Landroid/view/View;", "<init>", "(Lcom/alient/onearch/adapter/component/banner/PagerDotIndicator;)V", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: Taobao */
    public final class InternalRecyclerScrollListener extends RecyclerView.OnScrollListener {
        private View previousMostVisibleChild;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public InternalRecyclerScrollListener() {
        }

        private final float calculatePercentVisible(View view) {
            int left = view.getLeft();
            int right = view.getRight();
            int width = view.getWidth();
            if (left >= 0) {
                if (right <= PagerDotIndicator.this.getWidth()) {
                    return 1.0f;
                }
                right = PagerDotIndicator.this.getWidth() - left;
            }
            return ((float) right) / ((float) width);
        }

        private final View getMostVisibleChild() {
            RecyclerView.LayoutManager layoutManager;
            RecyclerView.LayoutManager layoutManager2;
            RecyclerView recyclerView = PagerDotIndicator.this.recyclerView;
            Integer valueOf = (recyclerView == null || (layoutManager2 = recyclerView.getLayoutManager()) == null) ? null : Integer.valueOf(layoutManager2.getChildCount());
            k21.f(valueOf);
            float f = 0.0f;
            View view = null;
            for (int intValue = valueOf.intValue() - 1; intValue >= 0; intValue--) {
                RecyclerView recyclerView2 = PagerDotIndicator.this.recyclerView;
                View childAt = (recyclerView2 == null || (layoutManager = recyclerView2.getLayoutManager()) == null) ? null : layoutManager.getChildAt(intValue);
                if (childAt != null) {
                    float calculatePercentVisible = calculatePercentVisible(childAt);
                    if (calculatePercentVisible >= f) {
                        view = childAt;
                        f = calculatePercentVisible;
                    }
                }
            }
            return view;
        }

        private final void setIntermediateSelectedItemPosition(View view) {
            RecyclerView.ViewHolder findContainingViewHolder;
            RecyclerView recyclerView = PagerDotIndicator.this.recyclerView;
            if (recyclerView != null && (findContainingViewHolder = recyclerView.findContainingViewHolder(view)) != null) {
                PagerDotIndicator.this.intermediateSelectedItemPosition = findContainingViewHolder.getAdapterPosition();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int i, int i2) {
            k21.i(recyclerView, "recyclerView");
            View mostVisibleChild = getMostVisibleChild();
            if (mostVisibleChild != null) {
                setIntermediateSelectedItemPosition(mostVisibleChild);
                PagerDotIndicator.this.offsetPercent = ((float) mostVisibleChild.getLeft()) / ((float) mostVisibleChild.getMeasuredWidth());
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            if (this.previousMostVisibleChild != linearLayoutManager.findViewByPosition(i >= 0 ? linearLayoutManager.findLastVisibleItemPosition() : linearLayoutManager.findFirstVisibleItemPosition())) {
                PagerDotIndicator pagerDotIndicator = PagerDotIndicator.this;
                pagerDotIndicator.selectedItemPosition = pagerDotIndicator.intermediateSelectedItemPosition;
            }
            this.previousMostVisibleChild = mostVisibleChild;
            PagerDotIndicator.this.invalidate();
        }
    }

    @JvmOverloads
    public PagerDotIndicator(@NotNull Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public PagerDotIndicator(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PagerDotIndicator(Context context, AttributeSet attributeSet, int i, int i2, m40 m40) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final int dpToPx(float f) {
        Resources resources = getResources();
        k21.h(resources, "resources");
        return (int) (f * ((float) (resources.getDisplayMetrics().densityDpi / 160)));
    }

    private final int getCalculatedWidth() {
        return (((this.dotCount + (this.fadingDotCount * 2)) - 1) * getDistanceBetweenTheCenterOfTwoDots()) + (this.dotRadiusPx * 2);
    }

    private final Paint getDefaultPaintConfig(Paint.Style style, boolean z, @ColorInt int i) {
        Paint paint = new Paint();
        paint.setStyle(style);
        paint.setAntiAlias(z);
        paint.setColor(i);
        return paint;
    }

    static /* synthetic */ Paint getDefaultPaintConfig$default(PagerDotIndicator pagerDotIndicator, Paint.Style style, boolean z, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            style = Paint.Style.FILL;
        }
        if ((i2 & 2) != 0) {
            z = true;
        }
        return pagerDotIndicator.getDefaultPaintConfig(style, z, i);
    }

    private final int getDistanceBetweenTheCenterOfTwoDots() {
        return (this.dotRadiusPx * 2) + this.dotSeparationDistancePx;
    }

    private final float getDotCoordinate(int i) {
        return ((float) ((i - this.intermediateSelectedItemPosition) * getDistanceBetweenTheCenterOfTwoDots())) + (((float) getDistanceBetweenTheCenterOfTwoDots()) * 1.0f);
    }

    private final int getDotYCoordinate() {
        return this.selectedDotRadiusPx;
    }

    private final int getItemCount() {
        RecyclerView.Adapter adapter;
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null || (adapter = recyclerView2.getAdapter()) == null) {
            return 0;
        }
        return adapter.getItemCount();
    }

    private final Paint getPaint(float f) {
        if (Math.abs(f) < ((float) (getDistanceBetweenTheCenterOfTwoDots() / 2))) {
            return this.selectedDotPaint;
        }
        return this.dotPaint;
    }

    private final int getRTLPosition(int i) {
        return (getItemCount() - i) - 1;
    }

    private final float getRadius(float f) {
        int i;
        float abs = Math.abs(f);
        float distanceBetweenTheCenterOfTwoDots = (((float) this.dotCount) / ((float) 2)) * ((float) getDistanceBetweenTheCenterOfTwoDots());
        if (abs < ((float) (getDistanceBetweenTheCenterOfTwoDots() / 2))) {
            i = this.selectedDotRadiusPx;
        } else if (abs <= distanceBetweenTheCenterOfTwoDots) {
            i = this.dotRadiusPx;
        } else {
            return this.interpolator.getInterpolation(((float) 1) - ((abs - distanceBetweenTheCenterOfTwoDots) / ((((float) getCalculatedWidth()) / 2.01f) - distanceBetweenTheCenterOfTwoDots))) * ((float) this.dotRadiusPx);
        }
        return (float) i;
    }

    private final Pair<Float, Float> getXYPositionsByCoordinate(float f) {
        return new Pair<>(Float.valueOf(((float) (getWidth() / 2)) + f), Float.valueOf((float) getDotYCoordinate()));
    }

    private final boolean isRtl() {
        return ViewCompat.getLayoutDirection(this) == 1;
    }

    private final void removeAllSources() {
        RecyclerView recyclerView2;
        InternalRecyclerScrollListener internalRecyclerScrollListener2 = this.internalRecyclerScrollListener;
        if (!(internalRecyclerScrollListener2 == null || (recyclerView2 = this.recyclerView) == null)) {
            recyclerView2.removeOnScrollListener(internalRecyclerScrollListener2);
        }
        this.recyclerView = null;
    }

    public final void attachToRecyclerView(@Nullable RecyclerView recyclerView2) {
        removeAllSources();
        this.recyclerView = recyclerView2;
        InternalRecyclerScrollListener internalRecyclerScrollListener2 = new InternalRecyclerScrollListener();
        this.internalRecyclerScrollListener = internalRecyclerScrollListener2;
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 != null) {
            recyclerView3.addOnScrollListener(internalRecyclerScrollListener2);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(@NotNull Canvas canvas) {
        k21.i(canvas, "canvas");
        super.onDraw(canvas);
        w11 w11 = ww1.h(0, getItemCount());
        ArrayList<Number> arrayList = new ArrayList(n.q(w11, 10));
        Iterator it = w11.iterator();
        while (it.hasNext()) {
            arrayList.add(Float.valueOf(getDotCoordinate(((r11) it).nextInt())));
        }
        for (Number number : arrayList) {
            float floatValue = number.floatValue();
            Pair<Float, Float> xYPositionsByCoordinate = getXYPositionsByCoordinate(floatValue);
            canvas.drawCircle(xYPositionsByCoordinate.component1().floatValue(), xYPositionsByCoordinate.component2().floatValue(), getRadius(floatValue), getPaint(floatValue));
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(getCalculatedWidth(), this.selectedDotRadiusPx * 2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PagerDotIndicator(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.interpolator = new DecelerateInterpolator();
        this.dotCount = 5;
        this.fadingDotCount = 10;
        this.selectedDotRadiusPx = dpToPx(6.5f);
        this.dotRadiusPx = dpToPx(6.5f);
        this.dotSeparationDistancePx = dpToPx((float) 12);
        this.dotColor = ContextCompat.getColor(context, R.color.default_indicator_color);
        this.selectedDotColor = ContextCompat.getColor(context, R.color.default_selected_indicator_color);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.PagerIndicator, 0, 0);
            this.dotCount = obtainStyledAttributes.getInteger(R.styleable.PagerIndicator_dotCount, 5);
            this.fadingDotCount = obtainStyledAttributes.getInt(R.styleable.PagerIndicator_fadingDotCount, 10);
            this.dotRadiusPx = obtainStyledAttributes.getDimensionPixelSize(R.styleable.PagerIndicator_dotRadius, this.dotRadiusPx);
            this.selectedDotRadiusPx = obtainStyledAttributes.getDimensionPixelSize(R.styleable.PagerIndicator_selectedDotRadius, this.selectedDotRadiusPx);
            this.dotColor = obtainStyledAttributes.getColor(R.styleable.PagerIndicator_indicatorColor, this.dotColor);
            this.selectedDotColor = obtainStyledAttributes.getColor(R.styleable.PagerIndicator_selectedIndicatorColor, this.selectedDotColor);
            this.dotSeparationDistancePx = obtainStyledAttributes.getDimensionPixelSize(R.styleable.PagerIndicator_dotSeparation, this.dotSeparationDistancePx);
            obtainStyledAttributes.recycle();
        }
        this.selectedDotPaint = getDefaultPaintConfig$default(this, null, false, this.selectedDotColor, 3, null);
        this.dotPaint = getDefaultPaintConfig$default(this, null, false, this.dotColor, 3, null);
    }
}
