package cn.damai.baseview.abcpullrefresh.actionbarcompat;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import cn.damai.baseview.abcpullrefresh.library.EnvironmentDelegate;
import cn.damai.baseview.abcpullrefresh.library.PullToRefreshAttacher;
import cn.damai.baseview.abcpullrefresh.library.d;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.n0;
import tb.yu0;

/* compiled from: Taobao */
public class a extends PullToRefreshAttacher {
    private static transient /* synthetic */ IpChange $ipChange;
    private FrameLayout A;

    /* renamed from: cn.damai.baseview.abcpullrefresh.actionbarcompat.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static class C0006a implements EnvironmentDelegate {
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // cn.damai.baseview.abcpullrefresh.library.EnvironmentDelegate
        public Context getContextForInflater(Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2113609122")) {
                return (Context) ipChange.ipc$dispatch("2113609122", new Object[]{this, activity});
            }
            Context context = null;
            ActionBar supportActionBar = ((AppCompatActivity) activity).getSupportActionBar();
            if (supportActionBar != null) {
                context = supportActionBar.getThemedContext();
            }
            return context == null ? activity : context;
        }
    }

    protected a(Activity activity, d dVar) {
        super(activity, dVar);
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.baseview.abcpullrefresh.library.PullToRefreshAttacher
    public void K(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-363246943")) {
            ipChange.ipc$dispatch("-363246943", new Object[]{this, view});
        } else if (Build.VERSION.SDK_INT >= 14) {
            super.K(view);
        } else {
            FrameLayout frameLayout = this.A;
            if (frameLayout != null) {
                super.K(frameLayout);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.baseview.abcpullrefresh.library.PullToRefreshAttacher
    public void c(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-696876742")) {
            ipChange.ipc$dispatch("-696876742", new Object[]{this, view});
        } else if (Build.VERSION.SDK_INT >= 14) {
            super.c(view);
        } else {
            FrameLayout frameLayout = new FrameLayout(k());
            this.A = frameLayout;
            frameLayout.addView(view);
            super.c(this.A);
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.baseview.abcpullrefresh.library.PullToRefreshAttacher
    public EnvironmentDelegate h() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1567659588")) {
            return new C0006a();
        }
        return (EnvironmentDelegate) ipChange.ipc$dispatch("-1567659588", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.baseview.abcpullrefresh.library.PullToRefreshAttacher
    public yu0 i() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "621801020")) {
            return new n0();
        }
        return (yu0) ipChange.ipc$dispatch("621801020", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.baseview.abcpullrefresh.library.PullToRefreshAttacher
    public void z(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-569332")) {
            ipChange.ipc$dispatch("-569332", new Object[]{this, view});
        } else if (Build.VERSION.SDK_INT >= 14) {
            super.z(view);
        } else {
            FrameLayout frameLayout = this.A;
            if (frameLayout != null) {
                super.z(frameLayout);
                this.A = null;
            }
        }
    }
}
