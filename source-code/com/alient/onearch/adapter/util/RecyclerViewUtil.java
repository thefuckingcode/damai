package com.alient.onearch.adapter.util;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ(\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006J(\u0010\r\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b¨\u0006\u0010"}, d2 = {"Lcom/alient/onearch/adapter/util/RecyclerViewUtil;", "", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "position", "scrollByHeight", "Ltb/ur2;", "smoothScrollToPosition", "", "millisecondsPerInch", "smoothScrollToPositionSpeed", "<init>", "()V", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class RecyclerViewUtil {
    @NotNull
    public static final RecyclerViewUtil INSTANCE = new RecyclerViewUtil();

    private RecyclerViewUtil() {
    }

    public final void smoothScrollToPosition(@Nullable Context context, @NotNull RecyclerView recyclerView, int i, int i2) {
        k21.i(recyclerView, "recyclerView");
        if (i >= 0) {
            try {
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager != null && (layoutManager instanceof LinearLayoutManager)) {
                    RecyclerViewUtil$smoothScrollToPosition$linearSmoothScroller$1 recyclerViewUtil$smoothScrollToPosition$linearSmoothScroller$1 = new RecyclerViewUtil$smoothScrollToPosition$linearSmoothScroller$1(i2, context, context);
                    recyclerViewUtil$smoothScrollToPosition$linearSmoothScroller$1.setTargetPosition(i);
                    RecyclerView.LayoutManager layoutManager2 = recyclerView.getLayoutManager();
                    if (layoutManager2 != null) {
                        layoutManager2.startSmoothScroll(recyclerViewUtil$smoothScrollToPosition$linearSmoothScroller$1);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public final void smoothScrollToPositionSpeed(@Nullable Context context, @NotNull RecyclerView recyclerView, int i, float f) {
        k21.i(recyclerView, "recyclerView");
        if (i >= 0) {
            try {
                RecyclerViewUtil$smoothScrollToPositionSpeed$linearSmoothScroller$1 recyclerViewUtil$smoothScrollToPositionSpeed$linearSmoothScroller$1 = new RecyclerViewUtil$smoothScrollToPositionSpeed$linearSmoothScroller$1(recyclerView, f, context, context);
                recyclerViewUtil$smoothScrollToPositionSpeed$linearSmoothScroller$1.setTargetPosition(i);
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                k21.f(layoutManager);
                layoutManager.startSmoothScroll(recyclerViewUtil$smoothScrollToPositionSpeed$linearSmoothScroller$1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
