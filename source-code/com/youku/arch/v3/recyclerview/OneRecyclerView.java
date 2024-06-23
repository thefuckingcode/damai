package com.youku.arch.v3.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.GXTemplateEngine;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.common.Constants;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0003\u001b\u001c\u001dB)\b\u0007\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0007\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u000b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bR\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/youku/arch/v3/recyclerview/OneRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Ltb/ur2;", "setMainScrollListener", "Lcom/youku/arch/v3/recyclerview/OneRecyclerView$OnScrolledListener;", "onScrolledListener", "addScrolledListener", "removeScrolledListener", "Lcom/youku/arch/v3/recyclerview/OneRecyclerView$OnScrollIdleListener;", "onScrollIdleListener", "addScrollIdleListener", "removeScrollIdleListener", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "mainScrollListener", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "", "onScrollIdleListeners", "Ljava/util/List;", "onScrolledListeners", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Landroid/util/AttributeSet;", TemplateDom.KEY_ATTRS, "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "OnScrollIdleListener", "OnScrolledListener", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class OneRecyclerView extends RecyclerView {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final String TAG = "OneRecyclerView";
    @Nullable
    private RecyclerView.OnScrollListener mainScrollListener;
    @Nullable
    private List<OnScrollIdleListener> onScrollIdleListeners;
    @Nullable
    private List<OnScrolledListener> onScrolledListeners;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/youku/arch/v3/recyclerview/OneRecyclerView$Companion;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&¨\u0006\t"}, d2 = {"Lcom/youku/arch/v3/recyclerview/OneRecyclerView$OnScrollIdleListener;", "", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "firstVisibleItemPosition", "lastVisibleItemPosition", "Ltb/ur2;", "onScrollIdle", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public interface OnScrollIdleListener {
        void onScrollIdle(@Nullable RecyclerView recyclerView, int i, int i2);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J2\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H&¨\u0006\u000b"}, d2 = {"Lcom/youku/arch/v3/recyclerview/OneRecyclerView$OnScrolledListener;", "", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", Constants.Name.DISTANCE_Y, "firstVisibleItemPosition", "lastVisibleItemPosition", "Ltb/ur2;", GXTemplateEngine.f.TYPE_ON_SCROLLED, "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public interface OnScrolledListener {
        void onScrolled(@Nullable RecyclerView recyclerView, int i, int i2, int i3, int i4);
    }

    @JvmOverloads
    public OneRecyclerView(@Nullable Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public OneRecyclerView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OneRecyclerView(Context context, AttributeSet attributeSet, int i, int i2, m40 m40) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void setMainScrollListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "480976749")) {
            ipChange.ipc$dispatch("480976749", new Object[]{this});
        } else if (this.mainScrollListener == null && (getLayoutManager() instanceof LinearLayoutManager)) {
            OneRecyclerView$setMainScrollListener$1 oneRecyclerView$setMainScrollListener$1 = new OneRecyclerView$setMainScrollListener$1(this);
            this.mainScrollListener = oneRecyclerView$setMainScrollListener$1;
            Objects.requireNonNull(oneRecyclerView$setMainScrollListener$1, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.OnScrollListener");
            addOnScrollListener(oneRecyclerView$setMainScrollListener$1);
        }
    }

    public final void addScrollIdleListener(@Nullable OnScrollIdleListener onScrollIdleListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1046496030")) {
            ipChange.ipc$dispatch("-1046496030", new Object[]{this, onScrollIdleListener});
        } else if (onScrollIdleListener != null) {
            setMainScrollListener();
            if (this.onScrollIdleListeners == null) {
                this.onScrollIdleListeners = Collections.synchronizedList(new ArrayList());
            }
            List<OnScrollIdleListener> list = this.onScrollIdleListeners;
            k21.f(list);
            list.add(onScrollIdleListener);
        }
    }

    public final void addScrolledListener(@Nullable OnScrolledListener onScrolledListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1330756670")) {
            ipChange.ipc$dispatch("-1330756670", new Object[]{this, onScrolledListener});
        } else if (onScrolledListener != null) {
            setMainScrollListener();
            if (this.onScrolledListeners == null) {
                this.onScrolledListeners = Collections.synchronizedList(new ArrayList());
            }
            List<OnScrolledListener> list = this.onScrolledListeners;
            k21.f(list);
            list.add(onScrolledListener);
        }
    }

    public final void removeScrollIdleListener(@Nullable OnScrollIdleListener onScrollIdleListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-278804755")) {
            ipChange.ipc$dispatch("-278804755", new Object[]{this, onScrollIdleListener});
            return;
        }
        List<OnScrollIdleListener> list = this.onScrollIdleListeners;
        if (list != null && onScrollIdleListener != null) {
            k21.f(list);
            list.remove(onScrollIdleListener);
        }
    }

    public final void removeScrolledListener(@Nullable OnScrolledListener onScrolledListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1032129357")) {
            ipChange.ipc$dispatch("1032129357", new Object[]{this, onScrolledListener});
            return;
        }
        List<OnScrolledListener> list = this.onScrolledListeners;
        if (list != null && onScrolledListener != null) {
            k21.f(list);
            list.remove(onScrolledListener);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OneRecyclerView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        k21.f(context);
    }
}
