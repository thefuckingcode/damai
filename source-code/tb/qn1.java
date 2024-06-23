package tb;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.taobao.monitor.impl.data.lifecycle.FragmentLifecycle;
import com.taobao.monitor.procedure.IPage;
import com.taobao.monitor.procedure.b;
import java.util.HashMap;

/* compiled from: Taobao */
public class qn1 {
    private boolean a = true;
    private View b;
    private Fragment c;
    private String d;
    private String e;
    private boolean f = true;
    private boolean g = true;
    Activity h;
    Fragment i;
    private String j;

    @NonNull
    public IPage a() {
        ea eaVar;
        if (!this.a) {
            return new b();
        }
        if (this.b == null) {
            i20.a("CustomPageBuilder", "create error: page root view is null");
            return new b();
        }
        on1 on1 = new on1();
        on1.L(this.b);
        on1.B(this.j);
        Activity activity = this.h;
        if (activity != null) {
            on1.x(activity);
            on1.A(k3.b(this.h));
        } else {
            Fragment fragment = this.i;
            if (fragment != null) {
                on1.z(fragment);
                on1.A(jn0.a(this.i));
            }
        }
        if (this.g) {
            eaVar = new do1(on1);
        } else {
            eaVar = new ld0(on1);
        }
        eaVar.k(this.f);
        on1.H(this.f);
        pp ppVar = new pp(on1);
        on1.N(eaVar);
        on1.D(ppVar);
        if (lc0.v) {
            on1.K(new qp(on1));
        } else {
            on1.K(eaVar);
        }
        Fragment fragment2 = this.c;
        if (fragment2 != null) {
            on1.I(FragmentLifecycle.a(fragment2));
            on1.getPageLifecycleCallback().onPageCreate(this.d, this.e, new HashMap());
        }
        return on1;
    }

    public qn1 b(Activity activity) {
        this.h = activity;
        return this;
    }

    public qn1 c(Fragment fragment) {
        this.i = fragment;
        return this;
    }

    public qn1 d(String str) {
        this.j = str;
        return this;
    }

    public qn1 e(boolean z) {
        this.f = z;
        return this;
    }

    public qn1 f(boolean z) {
        this.g = z;
        return this;
    }

    public qn1 g(String str) {
        this.d = str;
        return this;
    }

    public qn1 h(Fragment fragment) {
        this.c = fragment;
        return this;
    }

    public qn1 i(View view) {
        this.b = view;
        return this;
    }

    public qn1 j(Window window) {
        if (window != null) {
            this.b = window.getDecorView();
        }
        return this;
    }

    public qn1 k(String str) {
        this.e = str;
        return this;
    }

    public qn1 l(boolean z) {
        this.a = z;
        return this;
    }
}
