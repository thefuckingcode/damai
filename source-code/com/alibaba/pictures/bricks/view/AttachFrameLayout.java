package com.alibaba.pictures.bricks.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import java.lang.ref.WeakReference;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;

/* compiled from: Taobao */
public final class AttachFrameLayout extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);
    @Nullable
    private static WeakReference<View> weakAttachView;

    /* compiled from: Taobao */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        public final int a() {
            View view;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1125939106")) {
                return ((Integer) ipChange.ipc$dispatch("1125939106", new Object[]{this})).intValue();
            }
            WeakReference<View> b = b();
            if (b == null || (view = b.get()) == null) {
                return -10000;
            }
            return view.getTop();
        }

        @Nullable
        public final WeakReference<View> b() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "992307063")) {
                return AttachFrameLayout.weakAttachView;
            }
            return (WeakReference) ipChange.ipc$dispatch("992307063", new Object[]{this});
        }

        public final void c(@Nullable WeakReference<View> weakReference) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "880645409")) {
                ipChange.ipc$dispatch("880645409", new Object[]{this, weakReference});
                return;
            }
            AttachFrameLayout.weakAttachView = weakReference;
        }

        public final void d(boolean z, @NotNull View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-362630082")) {
                ipChange.ipc$dispatch("-362630082", new Object[]{this, Boolean.valueOf(z), view});
                return;
            }
            k21.i(view, "view");
            if (z) {
                c(new WeakReference<>(view));
                return;
            }
            WeakReference<View> b = b();
            if (k21.d(view, b != null ? b.get() : null)) {
                c(null);
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AttachFrameLayout(@NotNull Context context) {
        this(context, null, 2, null);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AttachFrameLayout(Context context, AttributeSet attributeSet, int i, m40 m40) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2021950957")) {
            ipChange.ipc$dispatch("-2021950957", new Object[]{this});
            return;
        }
        super.onAttachedToWindow();
        Companion.d(true, this);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1615763574")) {
            ipChange.ipc$dispatch("1615763574", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
        Companion.d(false, this);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AttachFrameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }
}
