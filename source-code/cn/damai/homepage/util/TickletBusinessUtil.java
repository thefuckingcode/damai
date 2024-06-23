package cn.damai.homepage.util;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.widget.FrameLayout;
import cn.damai.common.DamaiConstants;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.ticklet.listener.TickletPopListener;
import cn.damai.commonbusiness.update.UpdateUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.ax0;
import tb.j70;
import tb.n3;
import tb.ul2;

/* compiled from: Taobao */
public class TickletBusinessUtil implements TickletPopListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private DamaiBaseActivity a;
    private ul2 b;
    PopNoShow c;

    /* compiled from: Taobao */
    public interface PopNoShow {
        void popNoShow();
    }

    public TickletBusinessUtil(DamaiBaseActivity damaiBaseActivity) {
        this.a = damaiBaseActivity;
    }

    private void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-649562542")) {
            ipChange.ipc$dispatch("-649562542", new Object[]{this});
            return;
        }
        new Handler().postDelayed(new Runnable() {
            /* class cn.damai.homepage.util.TickletBusinessUtil.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1091089052")) {
                    ipChange.ipc$dispatch("-1091089052", new Object[]{this});
                    return;
                }
                TickletBusinessUtil.this.h();
            }
        }, 3000);
    }

    private void f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1034736971")) {
            ipChange.ipc$dispatch("1034736971", new Object[]{this});
            return;
        }
        try {
            DamaiBaseActivity damaiBaseActivity = this.a;
            if (damaiBaseActivity != null && !damaiBaseActivity.isFinishing()) {
                Intent intent = new Intent();
                intent.setAction(DamaiConstants.TICKLET_EXTERNAL_CALL_BRODCAST_ACTION);
                intent.setPackage("cn.damai");
                intent.putExtra("type", 9);
                this.a.sendBroadcast(intent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1988024921")) {
            ipChange.ipc$dispatch("-1988024921", new Object[]{this});
            return;
        }
        DamaiBaseActivity damaiBaseActivity = this.a;
        if (damaiBaseActivity != null && !damaiBaseActivity.isFinishing()) {
            try {
                Intent intent = new Intent();
                intent.setAction(DamaiConstants.TICKLET_EXTERNAL_CALL_BRODCAST_ACTION);
                intent.setPackage("cn.damai");
                intent.putExtra("type", 3);
                intent.putExtra("from", "home_preload");
                intent.putExtra("downTime", false);
                this.a.sendBroadcast(intent);
            } catch (Exception e) {
                n3.a("damai_member", "member_service_start", "homepage_sync", e.getMessage());
            }
        }
    }

    public void d(DialogInterface.OnDismissListener onDismissListener, PopNoShow popNoShow) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "455079275")) {
            ipChange.ipc$dispatch("455079275", new Object[]{this, onDismissListener, popNoShow});
            return;
        }
        DamaiBaseActivity damaiBaseActivity = this.a;
        if (damaiBaseActivity != null && !damaiBaseActivity.isFinishing()) {
            this.c = popNoShow;
            ul2 ul2 = new ul2(this.a);
            this.b = ul2;
            ul2.i(this);
            this.b.h(onDismissListener);
        }
    }

    @Override // cn.damai.commonbusiness.ticklet.listener.TickletPopListener
    public void doNotShowTickletPopWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1903550252")) {
            ipChange.ipc$dispatch("-1903550252", new Object[]{this});
            return;
        }
        DamaiBaseActivity damaiBaseActivity = this.a;
        if (damaiBaseActivity != null && !damaiBaseActivity.isFinishing() && ((Build.VERSION.SDK_INT < 17 || !this.a.isDestroyed()) && this.a.isActivityForeground())) {
            j70.d().f(this.a);
        }
        PopNoShow popNoShow = this.c;
        if (popNoShow != null) {
            popNoShow.popNoShow();
        }
    }

    public void e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-151242521")) {
            ipChange.ipc$dispatch("-151242521", new Object[]{this});
            return;
        }
        ul2 ul2 = this.b;
        if (ul2 != null) {
            ul2.f();
        }
    }

    public void g(final FrameLayout frameLayout, boolean z) {
        ul2 ul2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-232882686")) {
            ipChange.ipc$dispatch("-232882686", new Object[]{this, frameLayout, Boolean.valueOf(z)});
        } else if (!z || (ul2 = this.b) == null) {
            new Handler().postDelayed(new Runnable() {
                /* class cn.damai.homepage.util.TickletBusinessUtil.AnonymousClass2 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1287602557")) {
                        ipChange.ipc$dispatch("-1287602557", new Object[]{this});
                    } else if (TickletBusinessUtil.this.b != null) {
                        TickletBusinessUtil.this.b.g(frameLayout);
                    }
                }
            }, 2000);
        } else {
            ul2.g(frameLayout);
        }
    }

    public void i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "572335986")) {
            ipChange.ipc$dispatch("572335986", new Object[]{this});
        } else if (this.a != null) {
            f();
            c();
        }
    }

    @Override // cn.damai.commonbusiness.ticklet.listener.TickletPopListener
    public void popWindowClickListener(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1920166403")) {
            ipChange.ipc$dispatch("-1920166403", new Object[]{this, str});
            return;
        }
        c.e().x(ax0.I().B(str));
    }

    @Override // cn.damai.commonbusiness.ticklet.listener.TickletPopListener
    public void showPopFailed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "48625323")) {
            ipChange.ipc$dispatch("48625323", new Object[]{this});
            return;
        }
        PopNoShow popNoShow = this.c;
        if (popNoShow != null) {
            popNoShow.popNoShow();
        }
    }

    @Override // cn.damai.commonbusiness.ticklet.listener.TickletPopListener
    public void showPopWindow(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "85426658")) {
            ipChange.ipc$dispatch("85426658", new Object[]{this, str});
            return;
        }
        c.e().A(ax0.I().C(str), ax0.CUSTOM_VIPALERTSHOW, "home");
        UpdateUtil.f();
    }
}
