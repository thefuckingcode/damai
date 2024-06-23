package com.youku.arch.v3.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ali.user.mobile.app.constant.UTConstant;
import com.alibaba.gaiax.GXTemplateEngine;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.common.Constants;
import com.taobao.weex.ui.component.WXBasicComponentType;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0013\b\u0016\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014B#\b\u0016\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0015\u001a\u00020\t\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0013\u0010\u0018B-\b\u0016\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\u0006\u0010\u001b\u001a\u00020\t\u0012\u0006\u0010\u001c\u001a\u00020\t¢\u0006\u0004\b\u0013\u0010\u001dJ\u001c\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\tH\u0016J$\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\tH\u0016J \u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\tH\u0016¨\u0006\u001f"}, d2 = {"Lcom/youku/arch/v3/recyclerview/WrappedLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", WXBasicComponentType.RECYCLER, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "Ltb/ur2;", "onLayoutChildren", "", GXTemplateEngine.f.TYPE_ON_SCROLL_STATE_CHANGED, Constants.Name.DISTANCE_Y, "scrollVerticallyBy", "findLastCompletelyVisibleItemPosition", "recyclerView", "position", "smoothScrollToPosition", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "<init>", "(Landroid/content/Context;)V", "orientation", "", "reverseLayout", "(Landroid/content/Context;IZ)V", "Landroid/util/AttributeSet;", TemplateDom.KEY_ATTRS, "defStyleAttr", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class WrappedLinearLayoutManager extends LinearLayoutManager {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final float MILLISECONDS_PER_INCH = 160.0f;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/youku/arch/v3/recyclerview/WrappedLinearLayoutManager$Companion;", "", "", "MILLISECONDS_PER_INCH", UTConstant.Args.UT_SUCCESS_F, "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }
    }

    public WrappedLinearLayoutManager(@Nullable Context context) {
        super(context);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public int findLastCompletelyVisibleItemPosition() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1895839568")) {
            return ((Integer) ipChange.ipc$dispatch("-1895839568", new Object[]{this})).intValue();
        }
        try {
            return super.findLastCompletelyVisibleItemPosition();
        } catch (Exception e) {
            if (!AppInfoProviderProxy.isDebuggable()) {
                return -1;
            }
            throw e;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager, androidx.recyclerview.widget.LinearLayoutManager
    public void onLayoutChildren(@NotNull RecyclerView.Recycler recycler, @NotNull RecyclerView.State state) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "196873448")) {
            ipChange.ipc$dispatch("196873448", new Object[]{this, recycler, state});
            return;
        }
        k21.i(recycler, WXBasicComponentType.RECYCLER);
        k21.i(state, "state");
        try {
            super.onLayoutChildren(recycler, state);
        } catch (Exception e) {
            if (AppInfoProviderProxy.isDebuggable()) {
                throw e;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onScrollStateChanged(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1305072642")) {
            ipChange.ipc$dispatch("-1305072642", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        try {
            super.onScrollStateChanged(i);
        } catch (Exception e) {
            if (AppInfoProviderProxy.isDebuggable()) {
                throw e;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager, androidx.recyclerview.widget.LinearLayoutManager
    public int scrollVerticallyBy(int i, @NotNull RecyclerView.Recycler recycler, @NotNull RecyclerView.State state) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1939259695")) {
            return ((Integer) ipChange.ipc$dispatch("-1939259695", new Object[]{this, Integer.valueOf(i), recycler, state})).intValue();
        }
        k21.i(recycler, WXBasicComponentType.RECYCLER);
        k21.i(state, "state");
        try {
            return super.scrollVerticallyBy(i, recycler, state);
        } catch (Exception e) {
            if (!AppInfoProviderProxy.isDebuggable()) {
                return 0;
            }
            throw e;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager, androidx.recyclerview.widget.LinearLayoutManager
    public void smoothScrollToPosition(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "643845275")) {
            ipChange.ipc$dispatch("643845275", new Object[]{this, recyclerView, state, Integer.valueOf(i)});
            return;
        }
        k21.i(recyclerView, "recyclerView");
        k21.i(state, "state");
        WrappedLinearLayoutManager$smoothScrollToPosition$linearSmoothScroller$1 wrappedLinearLayoutManager$smoothScrollToPosition$linearSmoothScroller$1 = new WrappedLinearLayoutManager$smoothScrollToPosition$linearSmoothScroller$1(this, recyclerView.getContext());
        wrappedLinearLayoutManager$smoothScrollToPosition$linearSmoothScroller$1.setTargetPosition(i);
        startSmoothScroll(wrappedLinearLayoutManager$smoothScrollToPosition$linearSmoothScroller$1);
    }

    public WrappedLinearLayoutManager(@Nullable Context context, int i, boolean z) {
        super(context, i, z);
    }

    public WrappedLinearLayoutManager(@Nullable Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
