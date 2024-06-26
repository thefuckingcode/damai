package com.alient.onearch.adapter.component.banner;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ali.user.mobile.app.constant.UTConstant;
import com.alibaba.gaiax.GXTemplateEngine;
import com.alient.onearch.adapter.R;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.taobao.weex.common.Constants;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import io.flutter.wpkbridge.WPKFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 72\u00020\u0001:\u0003789B'\b\u0007\u0012\u0006\u00101\u001a\u000200\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u000102\u0012\b\b\u0002\u00104\u001a\u00020\u0007¢\u0006\u0004\b5\u00106J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0014J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0014J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0016R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0016R\u001c\u0010\u0018\u001a\b\u0018\u00010\u0017R\u00020\u00008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u001bR\u0016\u0010!\u001a\u00020 8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020 8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b#\u0010\"R\u0016\u0010$\u001a\u00020 8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b$\u0010\"R\u0016\u0010%\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010\u001dR\u0018\u0010'\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\"\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020&0)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010-\u001a\u00020,8\u0002@\u0002XD¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010/\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u0010\u001d¨\u0006:"}, d2 = {"Lcom/alient/onearch/adapter/component/banner/PagerLineIndicator;", "Landroid/view/View;", "Ltb/ur2;", "updateIndicatorPath", "removeAllSources", "", "dp", "", "dpToPx", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "attachToRecyclerView", "Landroid/graphics/Canvas;", "canvas", "onDraw", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "Landroid/os/Parcelable;", "state", "onRestoreInstanceState", "onSaveInstanceState", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/alient/onearch/adapter/component/banner/PagerLineIndicator$InternalRecyclerScrollListener;", "internalRecyclerScrollListener", "Lcom/alient/onearch/adapter/component/banner/PagerLineIndicator$InternalRecyclerScrollListener;", "offsetPercent", UTConstant.Args.UT_SUCCESS_F, "selectedItemPosition", "I", "intermediateSelectedItemPosition", BQCCameraParam.FOCUS_AREA_RADIUS, "Landroid/graphics/Paint;", "paintPageFill", "Landroid/graphics/Paint;", "paintStroke", "paintFill", "orientation", "Landroid/graphics/Path;", "indicatorBgPath", "Landroid/graphics/Path;", "", "indicatorPathMap", "Ljava/util/Map;", "", "isProgressModel", "Z", "strokeWidth", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Landroid/util/AttributeSet;", TemplateDom.KEY_ATTRS, "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "InternalRecyclerScrollListener", "SavedState", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class PagerLineIndicator extends View {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int DEFAULT_LINE_RADIUS_DP = 4;
    private static final int DEFAULT_LINE_WIDTH_DP = 4;
    private Path indicatorBgPath;
    private final Map<Integer, Path> indicatorPathMap;
    private int intermediateSelectedItemPosition;
    private InternalRecyclerScrollListener internalRecyclerScrollListener;
    private final boolean isProgressModel;
    private float offsetPercent;
    private int orientation;
    @JvmField
    @NotNull
    public final Paint paintFill;
    @JvmField
    @NotNull
    public final Paint paintPageFill;
    @JvmField
    @NotNull
    public final Paint paintStroke;
    @JvmField
    public float radius;
    private RecyclerView recyclerView;
    private int selectedItemPosition;
    private int strokeWidth;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/alient/onearch/adapter/component/banner/PagerLineIndicator$Companion;", "", "", "DEFAULT_LINE_RADIUS_DP", "I", "DEFAULT_LINE_WIDTH_DP", "<init>", "()V", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J \u0010\u000f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/alient/onearch/adapter/component/banner/PagerLineIndicator$InternalRecyclerScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroid/view/View;", "getMostVisibleChild", "child", "", "calculatePercentVisible", "mostVisibleChild", "Ltb/ur2;", "setIntermediateSelectedItemPosition", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", Constants.Name.DISTANCE_Y, GXTemplateEngine.f.TYPE_ON_SCROLLED, "previousMostVisibleChild", "Landroid/view/View;", "<init>", "(Lcom/alient/onearch/adapter/component/banner/PagerLineIndicator;)V", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
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
                if (right <= PagerLineIndicator.this.getWidth()) {
                    return 1.0f;
                }
                right = PagerLineIndicator.this.getWidth() - left;
            }
            return ((float) right) / ((float) width);
        }

        private final View getMostVisibleChild() {
            RecyclerView.LayoutManager layoutManager;
            RecyclerView.LayoutManager layoutManager2;
            RecyclerView recyclerView = PagerLineIndicator.this.recyclerView;
            Integer valueOf = (recyclerView == null || (layoutManager2 = recyclerView.getLayoutManager()) == null) ? null : Integer.valueOf(layoutManager2.getChildCount());
            k21.f(valueOf);
            float f = 0.0f;
            View view = null;
            for (int intValue = valueOf.intValue() - 1; intValue >= 0; intValue--) {
                RecyclerView recyclerView2 = PagerLineIndicator.this.recyclerView;
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
            RecyclerView recyclerView = PagerLineIndicator.this.recyclerView;
            if (recyclerView != null && (findContainingViewHolder = recyclerView.findContainingViewHolder(view)) != null) {
                PagerLineIndicator.this.intermediateSelectedItemPosition = findContainingViewHolder.getAdapterPosition();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int i, int i2) {
            k21.i(recyclerView, "recyclerView");
            View mostVisibleChild = getMostVisibleChild();
            if (mostVisibleChild != null) {
                setIntermediateSelectedItemPosition(mostVisibleChild);
                PagerLineIndicator.this.offsetPercent = ((float) mostVisibleChild.getLeft()) / ((float) mostVisibleChild.getMeasuredWidth());
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            if (this.previousMostVisibleChild != linearLayoutManager.findViewByPosition(i >= 0 ? linearLayoutManager.findLastVisibleItemPosition() : linearLayoutManager.findFirstVisibleItemPosition())) {
                PagerLineIndicator pagerLineIndicator = PagerLineIndicator.this;
                pagerLineIndicator.selectedItemPosition = pagerLineIndicator.intermediateSelectedItemPosition;
            }
            this.previousMostVisibleChild = mostVisibleChild;
            PagerLineIndicator.this.invalidate();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0013\b\u0016\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011B\u0011\b\u0012\u0012\u0006\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0013J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\"\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/alient/onearch/adapter/component/banner/PagerLineIndicator$SavedState;", "Landroid/view/View$BaseSavedState;", "Landroid/os/Parcel;", "dest", "", com.taobao.accs.common.Constants.KEY_FLAGS, "Ltb/ur2;", "writeToParcel", "selectedItemPosition", "I", "getSelectedItemPosition", "()I", "setSelectedItemPosition", "(I)V", "Landroid/os/Parcelable;", "superState", "<init>", "(Landroid/os/Parcelable;)V", "in", "(Landroid/os/Parcel;)V", "Companion", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: Taobao */
    public static final class SavedState extends View.BaseSavedState {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<SavedState> CREATOR = new PagerLineIndicator$SavedState$Companion$CREATOR$1();
        @NotNull
        public static final Companion Companion = new Companion(null);
        private int selectedItemPosition;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/alient/onearch/adapter/component/banner/PagerLineIndicator$SavedState$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/alient/onearch/adapter/component/banner/PagerLineIndicator$SavedState;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
        /* compiled from: Taobao */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(m40 m40) {
                this();
            }
        }

        public /* synthetic */ SavedState(Parcel parcel, m40 m40) {
            this(parcel);
        }

        public final int getSelectedItemPosition() {
            return this.selectedItemPosition;
        }

        public final void setSelectedItemPosition(int i) {
            this.selectedItemPosition = i;
        }

        public void writeToParcel(@NotNull Parcel parcel, int i) {
            k21.i(parcel, "dest");
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.selectedItemPosition);
        }

        public SavedState(@Nullable Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.selectedItemPosition = parcel.readInt();
        }
    }

    @JvmOverloads
    public PagerLineIndicator(@NotNull Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public PagerLineIndicator(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PagerLineIndicator(Context context, AttributeSet attributeSet, int i, int i2, m40 m40) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final int dpToPx(float f) {
        Resources resources = getResources();
        k21.h(resources, "resources");
        return (int) (f * ((float) (resources.getDisplayMetrics().densityDpi / 160)));
    }

    private final void removeAllSources() {
        RecyclerView recyclerView2;
        InternalRecyclerScrollListener internalRecyclerScrollListener2 = this.internalRecyclerScrollListener;
        if (!(internalRecyclerScrollListener2 == null || (recyclerView2 = this.recyclerView) == null)) {
            recyclerView2.removeOnScrollListener(internalRecyclerScrollListener2);
        }
        this.recyclerView = null;
    }

    private final void updateIndicatorPath() {
        RectF rectF;
        RecyclerView.Adapter adapter;
        this.indicatorPathMap.clear();
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f = (float) measuredWidth;
        float f2 = (float) measuredHeight;
        RectF rectF2 = new RectF(0.0f, 0.0f, f, f2);
        Path path = new Path();
        this.indicatorBgPath = path;
        k21.f(path);
        float f3 = this.radius;
        path.addRoundRect(rectF2, f3, f3, Path.Direction.CW);
        if (this.orientation != 0) {
            measuredWidth = measuredHeight;
        }
        RecyclerView recyclerView2 = this.recyclerView;
        int itemCount = (recyclerView2 == null || (adapter = recyclerView2.getAdapter()) == null) ? 0 : adapter.getItemCount();
        if (itemCount > 0) {
            int i = measuredWidth / itemCount;
            for (int i2 = 0; i2 < itemCount; i2++) {
                int i3 = this.isProgressModel ? 0 : i * i2;
                if (this.orientation == 0) {
                    if (i2 == itemCount - 1) {
                        rectF = new RectF((float) i3, 0.0f, (float) measuredWidth, f2);
                    } else {
                        rectF = new RectF((float) i3, 0.0f, (float) ((i2 + 1) * i), f2);
                    }
                } else if (i2 == itemCount - 1) {
                    rectF = new RectF((float) i3, 0.0f, f, (float) measuredWidth);
                } else {
                    rectF = new RectF(0.0f, (float) i3, f, (float) ((i2 + 1) * i));
                }
                Path path2 = new Path();
                float f4 = this.radius;
                path2.addRoundRect(rectF, f4, f4, Path.Direction.CW);
                this.indicatorPathMap.put(Integer.valueOf(i2), path2);
            }
        }
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
        if (!this.indicatorPathMap.isEmpty()) {
            Path path = this.indicatorBgPath;
            if (path != null) {
                canvas.drawPath(path, this.paintPageFill);
                if (this.strokeWidth > 0) {
                    canvas.drawPath(path, this.paintStroke);
                }
            }
            Path path2 = this.indicatorPathMap.get(Integer.valueOf(this.intermediateSelectedItemPosition % this.indicatorPathMap.size()));
            if (path2 != null) {
                canvas.drawPath(path2, this.paintFill);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        updateIndicatorPath();
    }

    public void onRestoreInstanceState(@NotNull Parcelable parcelable) {
        k21.i(parcelable, "state");
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.intermediateSelectedItemPosition = savedState.getSelectedItemPosition();
        requestLayout();
    }

    @NotNull
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.setSelectedItemPosition(this.intermediateSelectedItemPosition);
        return savedState;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PagerLineIndicator(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        Paint paint = new Paint(1);
        this.paintPageFill = paint;
        Paint paint2 = new Paint(1);
        this.paintStroke = paint2;
        Paint paint3 = new Paint(1);
        this.paintFill = paint3;
        this.indicatorPathMap = new HashMap();
        this.isProgressModel = true;
        float f = (float) 4;
        this.strokeWidth = dpToPx(f);
        paint2.setStyle(Paint.Style.STROKE);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.PagerIndicator, 0, 0);
            this.radius = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.PagerIndicator_lineRadius, dpToPx(f));
            this.strokeWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.PagerIndicator_lineWidth, dpToPx(f));
            int i2 = R.styleable.PagerIndicator_indicatorColor;
            Context context2 = getContext();
            k21.h(context2, "getContext()");
            paint.setColor(obtainStyledAttributes.getColor(i2, context2.getResources().getColor(R.color.default_indicator_color)));
            int i3 = R.styleable.PagerIndicator_selectedIndicatorColor;
            Context context3 = getContext();
            k21.h(context3, "getContext()");
            paint3.setColor(obtainStyledAttributes.getColor(i3, context3.getResources().getColor(R.color.default_selected_indicator_color)));
            obtainStyledAttributes.recycle();
        }
    }
}
