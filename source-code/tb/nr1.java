package tb;

import android.widget.FrameLayout;
import cn.damai.common.app.base.BaseActivity;
import cn.damai.homepage.util.TickletBusinessUtil;
import cn.damai.homepage.util.window.MiddlePriortyHandle;
import cn.damai.homepage.util.window.PopupCallback;
import cn.damai.homepage.util.window.TopPriortyHandle;
import cn.damai.rank.view.WantSeePosterTips;
import com.alibaba.yymidservice.popup.popupcenter.PopupPriorityManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class nr1 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    public static final String WANT_SEE_UPDATE = "MainActivity_wantSeeFloat";
    @NotNull
    private BaseActivity<?, ?> a;
    @NotNull
    private PopupPriorityManager b;
    @Nullable
    private TopPriortyHandle c = new TopPriortyHandle(this.a);
    @Nullable
    private n61 d = new n61(this.a);
    @Nullable
    private MiddlePriortyHandle e = new MiddlePriortyHandle(this.a);
    @Nullable
    private d21 f = new d21(this.a);

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    public nr1(@NotNull BaseActivity<?, ?> baseActivity) {
        k21.i(baseActivity, "cxt");
        this.a = baseActivity;
        this.b = new PopupPriorityManager(baseActivity);
    }

    public final void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-43977090")) {
            ipChange.ipc$dispatch("-43977090", new Object[]{this});
            return;
        }
        this.b.q(null);
        this.b.i(null);
        this.b.m(this.c, this.e, this.d);
        this.b.n(this.f, PopupPriorityManager.InterceptType.SAMEAPPEAR);
        this.b.l(true);
    }

    public final void b(@Nullable TickletBusinessUtil tickletBusinessUtil, @Nullable FrameLayout frameLayout, @Nullable WantSeePosterTips wantSeePosterTips, @Nullable PopupCallback popupCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "935117102")) {
            ipChange.ipc$dispatch("935117102", new Object[]{this, tickletBusinessUtil, frameLayout, wantSeePosterTips, popupCallback});
            return;
        }
        TopPriortyHandle topPriortyHandle = this.c;
        if (topPriortyHandle != null) {
            topPriortyHandle.j(tickletBusinessUtil, frameLayout, popupCallback);
        }
        MiddlePriortyHandle middlePriortyHandle = this.e;
        if (middlePriortyHandle != null) {
            middlePriortyHandle.g(popupCallback, wantSeePosterTips);
        }
        d21 d21 = this.f;
        if (d21 != null) {
            d21.a(popupCallback);
        }
    }
}
