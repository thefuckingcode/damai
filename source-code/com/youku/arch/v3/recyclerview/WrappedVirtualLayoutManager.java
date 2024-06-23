package com.youku.arch.v3.recyclerview;

import android.content.Context;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.ali.user.mobile.app.constant.UTConstant;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0011\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010B\u0019\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0012B!\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u000f\u0010\u0015J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/youku/arch/v3/recyclerview/WrappedVirtualLayoutManager;", "Lcom/alibaba/android/vlayout/VirtualLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "position", "Ltb/ur2;", "smoothScrollToPosition", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "linearSmoothScroller", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "<init>", "(Landroid/content/Context;)V", "orientation", "(Landroid/content/Context;I)V", "", "reverseLayout", "(Landroid/content/Context;IZ)V", "Companion", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class WrappedVirtualLayoutManager extends VirtualLayoutManager {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final float MILLISECONDS_PER_INCH = 160.0f;
    @Nullable
    private LinearSmoothScroller linearSmoothScroller;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/youku/arch/v3/recyclerview/WrappedVirtualLayoutManager$Companion;", "", "", "MILLISECONDS_PER_INCH", UTConstant.Args.UT_SUCCESS_F, "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WrappedVirtualLayoutManager(@NotNull Context context) {
        super(context);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        VirtualLayoutManager.enableDebugging(AppInfoProviderProxy.isDebuggable());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager, androidx.recyclerview.widget.LinearLayoutManager, com.alibaba.android.vlayout.VirtualLayoutManager
    public void smoothScrollToPosition(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1688644667")) {
            ipChange.ipc$dispatch("1688644667", new Object[]{this, recyclerView, state, Integer.valueOf(i)});
            return;
        }
        k21.i(recyclerView, "recyclerView");
        k21.i(state, "state");
        if (this.linearSmoothScroller == null) {
            this.linearSmoothScroller = new WrappedVirtualLayoutManager$smoothScrollToPosition$1(this, recyclerView.getContext());
        }
        LinearSmoothScroller linearSmoothScroller2 = this.linearSmoothScroller;
        k21.f(linearSmoothScroller2);
        linearSmoothScroller2.setTargetPosition(i);
        startSmoothScroll(this.linearSmoothScroller);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WrappedVirtualLayoutManager(@NotNull Context context, int i) {
        super(context, i);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        VirtualLayoutManager.enableDebugging(AppInfoProviderProxy.isDebuggable());
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WrappedVirtualLayoutManager(@NotNull Context context, int i, boolean z) {
        super(context, i, z);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        VirtualLayoutManager.enableDebugging(AppInfoProviderProxy.isDebuggable());
    }
}
