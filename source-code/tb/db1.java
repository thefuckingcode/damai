package tb;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.media.arch.instruments.statistics.ConfigReporter;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: Taobao */
public final class db1 extends Handler {
    private static transient /* synthetic */ IpChange $ipChange;
    private static db1 b;
    private final Queue<hp> a = new LinkedBlockingQueue();

    /* compiled from: Taobao */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View a;
        final /* synthetic */ hp b;

        a(View view, hp hpVar) {
            this.a = view;
            this.b = hpVar;
        }

        @TargetApi(16)
        public void onGlobalLayout() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1636224369")) {
                ipChange.ipc$dispatch("1636224369", new Object[]{this});
                return;
            }
            if (Build.VERSION.SDK_INT < 16) {
                this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            } else {
                this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
            if (this.b.f() != null) {
                this.a.startAnimation(this.b.f());
                db1.d(this.b.d(), this.b.j());
                if (-1 != this.b.e().a) {
                    db1 db1 = db1.this;
                    hp hpVar = this.b;
                    db1.m(hpVar, -1040155167, ((long) hpVar.e().a) + this.b.f().getDuration());
                }
            }
        }
    }

    private db1() {
    }

    private void c(hp hpVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1877265846")) {
            ipChange.ipc$dispatch("-1877265846", new Object[]{this, hpVar});
        } else if (!hpVar.u()) {
            View k = hpVar.k();
            if (k.getParent() == null) {
                ViewGroup.LayoutParams layoutParams = k.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
                }
                if (hpVar.l() != null) {
                    ViewGroup l = hpVar.l();
                    if (o(l)) {
                        l.addView(k, layoutParams);
                    } else {
                        l.addView(k, 0, layoutParams);
                    }
                } else {
                    Activity d = hpVar.d();
                    if (d != null && !d.isFinishing()) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        i(marginLayoutParams, d);
                        h(marginLayoutParams, d);
                        d.addContentView(k, layoutParams);
                    } else {
                        return;
                    }
                }
            }
            k.requestLayout();
            ViewTreeObserver viewTreeObserver = k.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnGlobalLayoutListener(new a(k, hpVar));
            }
        }
    }

    public static void d(Context context, CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1134862260")) {
            ipChange.ipc$dispatch("-1134862260", new Object[]{context, charSequence});
            return;
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 4) {
            AccessibilityManager accessibilityManager = null;
            if (context != null) {
                accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
            }
            if (accessibilityManager != null && accessibilityManager.isEnabled()) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain(i < 16 ? 8 : 16384);
                obtain.getText().add(charSequence);
                obtain.setClassName(db1.class.getName());
                obtain.setPackageName(context.getPackageName());
                accessibilityManager.sendAccessibilityEvent(obtain);
            }
        }
    }

    private long e(hp hpVar) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1989716243")) {
            return ((long) hpVar.e().a) + hpVar.f().getDuration() + hpVar.h().getDuration();
        }
        return ((Long) ipChange.ipc$dispatch("-1989716243", new Object[]{this, hpVar})).longValue();
    }

    private void f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "858071508")) {
            ipChange.ipc$dispatch("858071508", new Object[]{this});
        } else if (!this.a.isEmpty()) {
            hp peek = this.a.peek();
            if (peek.d() == null) {
                this.a.poll();
            }
            if (!peek.u()) {
                l(peek, -1040157475);
                if (peek.g() != null) {
                    peek.g().onDisplayed();
                    return;
                }
                return;
            }
            m(peek, 794631, e(peek));
        }
    }

    static synchronized db1 g() {
        synchronized (db1.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-692148659")) {
                return (db1) ipChange.ipc$dispatch("-692148659", new Object[0]);
            }
            if (b == null) {
                b = new db1();
            }
            return b;
        }
    }

    @TargetApi(11)
    private void h(ViewGroup.MarginLayoutParams marginLayoutParams, Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1219085332")) {
            ipChange.ipc$dispatch("-1219085332", new Object[]{this, marginLayoutParams, activity});
        } else if (Build.VERSION.SDK_INT >= 11 && activity.getWindow().hasFeature(9)) {
            n(marginLayoutParams, activity);
        }
    }

    @TargetApi(19)
    private void i(ViewGroup.MarginLayoutParams marginLayoutParams, Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-150292483")) {
            ipChange.ipc$dispatch("-150292483", new Object[]{this, marginLayoutParams, activity});
        } else if (Build.VERSION.SDK_INT >= 19 && (activity.getWindow().getAttributes().flags & ConfigReporter.BIT_GETTER_IMP) == 67108864) {
            n(marginLayoutParams, activity);
        }
    }

    private void j(hp hpVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "487389089")) {
            ipChange.ipc$dispatch("487389089", new Object[]{this, hpVar});
            return;
        }
        removeMessages(-1040157475, hpVar);
        removeMessages(794631, hpVar);
        removeMessages(-1040155167, hpVar);
    }

    private void l(hp hpVar, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1685966815")) {
            ipChange.ipc$dispatch("-1685966815", new Object[]{this, hpVar, Integer.valueOf(i)});
            return;
        }
        Message obtainMessage = obtainMessage(i);
        obtainMessage.obj = hpVar;
        sendMessage(obtainMessage);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void m(hp hpVar, int i, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1528206929")) {
            ipChange.ipc$dispatch("1528206929", new Object[]{this, hpVar, Integer.valueOf(i), Long.valueOf(j)});
            return;
        }
        Message obtainMessage = obtainMessage(i);
        obtainMessage.obj = hpVar;
        sendMessageDelayed(obtainMessage, j);
    }

    private void n(ViewGroup.MarginLayoutParams marginLayoutParams, Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-850884902")) {
            ipChange.ipc$dispatch("-850884902", new Object[]{this, marginLayoutParams, activity});
            return;
        }
        View findViewById = activity.findViewById(Resources.getSystem().getIdentifier("action_bar_container", "id", "android"));
        if (findViewById != null) {
            marginLayoutParams.topMargin = findViewById.getBottom();
        }
    }

    private boolean o(ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "72805685")) {
            return (viewGroup instanceof FrameLayout) || (viewGroup instanceof AdapterView) || (viewGroup instanceof RelativeLayout);
        }
        return ((Boolean) ipChange.ipc$dispatch("72805685", new Object[]{this, viewGroup})).booleanValue();
    }

    /* access modifiers changed from: package-private */
    public void b(hp hpVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2052640156")) {
            ipChange.ipc$dispatch("-2052640156", new Object[]{this, hpVar});
            return;
        }
        this.a.add(hpVar);
        f();
    }

    public void handleMessage(Message message) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1073345902")) {
            ipChange.ipc$dispatch("1073345902", new Object[]{this, message});
            return;
        }
        hp hpVar = (hp) message.obj;
        if (hpVar != null) {
            int i = message.what;
            if (i == -1040157475) {
                c(hpVar);
            } else if (i == -1040155167) {
                k(hpVar);
                if (hpVar.g() != null) {
                    hpVar.g().onRemoved();
                }
            } else if (i != 794631) {
                super.handleMessage(message);
            } else {
                f();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void k(hp hpVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1445257469")) {
            ipChange.ipc$dispatch("1445257469", new Object[]{this, hpVar});
            return;
        }
        j(hpVar);
        View k = hpVar.k();
        ViewGroup viewGroup = (ViewGroup) k.getParent();
        if (viewGroup != null) {
            k.startAnimation(hpVar.h());
            hp poll = this.a.poll();
            viewGroup.removeView(k);
            if (poll != null) {
                poll.a();
                poll.c();
                if (poll.g() != null) {
                    poll.g().onRemoved();
                }
                poll.b();
            }
            m(hpVar, 794631, hpVar.h().getDuration());
        }
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-898575364")) {
            return (String) ipChange.ipc$dispatch("-898575364", new Object[]{this});
        }
        return "Manager{croutonQueue=" + this.a + '}';
    }
}
