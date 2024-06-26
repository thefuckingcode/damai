package com.alibaba.pictures.bricks.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;

/* compiled from: Taobao */
public final class NestedRecyclerView extends RecyclerView {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);
    private boolean isStopNestUtilIdle;
    @NotNull
    private final ArrayList<NestedListener> mListenerList;
    @NotNull
    private final int[] outConsumed;

    /* compiled from: Taobao */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @Nullable
        public final NestedRecyclerView a(@Nullable View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1736658544")) {
                return (NestedRecyclerView) ipChange.ipc$dispatch("-1736658544", new Object[]{this, view});
            } else if (view instanceof NestedRecyclerView) {
                return (NestedRecyclerView) view;
            } else {
                if (view == null || !(view.getParent() instanceof View)) {
                    return null;
                }
                ViewParent parent = view.getParent();
                k21.g(parent, "null cannot be cast to non-null type android.view.View");
                return a((View) parent);
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NestedRecyclerView(@NotNull Context context) {
        this(context, null, 2, null);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NestedRecyclerView(Context context, AttributeSet attributeSet, int i, m40 m40) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    private final void dispatchNestedScroll2Listener(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1661923440")) {
            ipChange.ipc$dispatch("-1661923440", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        for (T t : this.mListenerList) {
            if (z) {
                t.startNestedScroll();
            } else {
                t.stopNestedScroll();
            }
        }
    }

    private final void dispatchPreScroll2Listener(int i, int i2, int[] iArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "396672924")) {
            ipChange.ipc$dispatch("396672924", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), iArr});
            return;
        }
        Iterator<T> it = this.mListenerList.iterator();
        while (it.hasNext()) {
            it.next().dispatchNestedPreScroll(i, i2, iArr);
        }
    }

    public final void addListener(@NotNull NestedListener nestedListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1662796761")) {
            ipChange.ipc$dispatch("1662796761", new Object[]{this, nestedListener});
            return;
        }
        k21.i(nestedListener, "listener");
        if (!this.mListenerList.contains(nestedListener)) {
            this.mListenerList.add(nestedListener);
        }
    }

    @Override // androidx.core.view.NestedScrollingChild2, androidx.recyclerview.widget.RecyclerView
    public boolean dispatchNestedPreScroll(int i, int i2, @Nullable int[] iArr, @Nullable int[] iArr2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1396061954")) {
            return ((Boolean) ipChange.ipc$dispatch("-1396061954", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), iArr, iArr2, Integer.valueOf(i3)})).booleanValue();
        }
        boolean dispatchNestedPreScroll = super.dispatchNestedPreScroll(i, i2, iArr, iArr2, i3);
        if (!this.isStopNestUtilIdle && iArr != null && iArr.length == 2) {
            int i4 = i2 - iArr[1];
            int[] iArr3 = this.outConsumed;
            iArr3[0] = 0;
            iArr3[1] = 0;
            dispatchPreScroll2Listener(i, i4, iArr3);
            if (!(iArr[1] == 0 && iArr[0] == 0)) {
                return true;
            }
        }
        return dispatchNestedPreScroll;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrollStateChanged(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "417777684")) {
            ipChange.ipc$dispatch("417777684", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        super.onScrollStateChanged(i);
        if (i == 0) {
            dispatchNestedScroll2Listener(false);
            this.isStopNestUtilIdle = false;
        } else if (i == 1) {
            dispatchNestedScroll2Listener(true);
        }
    }

    public final void removeListener(@NotNull NestedListener nestedListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1154249206")) {
            ipChange.ipc$dispatch("-1154249206", new Object[]{this, nestedListener});
            return;
        }
        k21.i(nestedListener, "listener");
        this.mListenerList.remove(nestedListener);
    }

    public final void stopDispatchScrollUtilIdle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1569379839")) {
            ipChange.ipc$dispatch("1569379839", new Object[]{this});
            return;
        }
        this.isStopNestUtilIdle = true;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NestedRecyclerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.outConsumed = new int[2];
        this.mListenerList = new ArrayList<>();
    }
}
