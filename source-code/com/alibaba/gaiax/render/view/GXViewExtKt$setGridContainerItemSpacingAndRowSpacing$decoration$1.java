package com.alibaba.gaiax.render.view;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/alibaba/gaiax/render/view/GXViewExtKt$setGridContainerItemSpacingAndRowSpacing$decoration$1", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "GaiaX"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GXViewExtKt$setGridContainerItemSpacingAndRowSpacing$decoration$1 extends RecyclerView.ItemDecoration {
    final /* synthetic */ Rect a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;

    GXViewExtKt$setGridContainerItemSpacingAndRowSpacing$decoration$1(Rect rect, int i, int i2) {
        this.a = rect;
        this.b = i;
        this.c = i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0059  */
    private final void a(float f, float f2, Rect rect, int i, int i2, Rect rect2, int i3, int i4) {
        float f3;
        float f4;
        float f5;
        float f6;
        int i5;
        float f7;
        float f8;
        int i6;
        float f9 = 0.0f;
        if (i == 1) {
            float f10 = (float) (i2 - 1);
            int i7 = rect.left;
            int i8 = rect.right;
            float f11 = ((f * f10) + (((float) i7) + ((float) i8))) / ((float) i2);
            int i9 = i3 % i2;
            int i10 = i3 / i2;
            if (i7 == 0 && i8 == 0 && rect.top == 0 && rect.bottom == 0) {
                float f12 = (((float) i9) * f11) / f10;
                f3 = f11 - f12;
                f9 = f12;
                if (i4 / i2 == i10) {
                    f5 = 0.0f;
                    f4 = 0.0f;
                } else {
                    f4 = 0.0f;
                    f5 = f2;
                }
            } else {
                if (i3 < i2) {
                    int i11 = rect.top;
                    if (i11 != 0) {
                        f9 = (float) i11;
                    }
                } else if (i4 / i2 == i10 && (i6 = rect.bottom) != 0) {
                    f5 = (float) i6;
                    if (i2 != 1) {
                        f8 = (float) i7;
                        f7 = (float) i8;
                    } else {
                        f8 = ((((float) i9) * ((f11 - ((float) i7)) - ((float) i8))) / f10) + ((float) ((i7 + i8) / 2));
                        f7 = f11 - f8;
                    }
                    f3 = f7;
                    f9 = f8;
                    f4 = f9;
                }
                f5 = f2;
                if (i2 != 1) {
                }
                f3 = f7;
                f9 = f8;
                f4 = f9;
            }
        } else {
            float f13 = (float) (i2 - 1);
            int i12 = rect.top;
            int i13 = rect.bottom;
            float f14 = ((f * f13) + ((float) (i12 + i13))) / ((float) i2);
            int i14 = i3 % i2;
            int i15 = i3 / i2;
            int i16 = rect.left;
            if (i16 == 0 && rect.right == 0 && i12 == 0 && i13 == 0) {
                float f15 = (((float) i14) * f14) / f13;
                float f16 = f14 - f15;
                if (i4 / i2 == i15) {
                    f4 = f15;
                    f5 = f16;
                    f3 = 0.0f;
                } else {
                    f3 = f2;
                    f4 = f15;
                    f5 = f16;
                }
            } else {
                if (i3 < i2) {
                    if (i16 != 0) {
                        f9 = (float) i16;
                    }
                } else if (i4 / i2 == i15 && (i5 = rect.right) != 0) {
                    f6 = (float) i5;
                    f4 = ((((float) i14) * ((f14 - ((float) i12)) - ((float) i13))) / f13) + ((float) ((i12 + i13) / 2));
                    f3 = f6;
                    f5 = f14 - f4;
                }
                f6 = f2;
                f4 = ((((float) i14) * ((f14 - ((float) i12)) - ((float) i13))) / f13) + ((float) ((i12 + i13) / 2));
                f3 = f6;
                f5 = f14 - f4;
            }
        }
        rect2.left = (int) f9;
        rect2.top = (int) f4;
        rect2.right = (int) f3;
        rect2.bottom = (int) f5;
    }

    private final void b(float f, Rect rect, int i, int i2, Rect rect2, int i3, int i4) {
        float f2;
        float f3;
        float f4 = (float) (i2 - 1);
        int i5 = rect.left;
        int i6 = rect.right;
        float f5 = ((f * f4) + (((float) i5) + ((float) i6))) / ((float) i2);
        int i7 = i3 % i2;
        int i8 = rect.top;
        float f6 = (float) i8;
        int i9 = rect.bottom;
        float f7 = (float) i9;
        if (i5 == 0 && i6 == 0 && i8 == 0 && i9 == 0) {
            f2 = (((float) i7) * f5) / f4;
        } else if (i2 == 1) {
            f2 = (float) i5;
            f3 = (float) i6;
            rect2.left = (int) f2;
            rect2.top = (int) f6;
            rect2.right = (int) f3;
            rect2.bottom = (int) f7;
        } else {
            f2 = ((((float) i7) * ((f5 - ((float) i5)) - ((float) i6))) / f4) + ((float) ((i5 + i6) / 2));
        }
        f3 = f5 - f2;
        rect2.left = (int) f2;
        rect2.top = (int) f6;
        rect2.right = (int) f3;
        rect2.bottom = (int) f7;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        k21.i(rect, "outRect");
        k21.i(view, "view");
        k21.i(recyclerView, "parent");
        k21.i(state, "state");
        super.getItemOffsets(rect, view, recyclerView, state);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        int itemCount = adapter == null ? 0 : adapter.getItemCount();
        int spanCount = gridLayoutManager.getSpanCount();
        int orientation = gridLayoutManager.getOrientation();
        int i = recyclerView.getLayoutParams().height;
        int i2 = view.getLayoutParams().height;
        if (orientation != 1 || (((float) itemCount) * 1.0f) / ((float) spanCount) > 1.0f || i2 <= 0 || i <= 0) {
            a((float) this.b, (float) this.c, this.a, orientation, spanCount, rect, childAdapterPosition, itemCount);
            return;
        }
        int i3 = (int) (((float) (i - i2)) / 2.0f);
        Rect rect2 = this.a;
        b((float) this.b, new Rect(rect2.left, i3, rect2.right, i3), orientation, spanCount, rect, childAdapterPosition, itemCount);
    }
}
