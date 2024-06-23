package com.uc.crashsdk;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.uc.crashsdk.a.a;
import java.util.Iterator;
import java.util.Map;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class c implements Application.ActivityLifecycleCallbacks {
    private boolean a = false;
    private boolean b = false;

    c() {
    }

    private void a(Activity activity, int i) {
        if (1 == i) {
            String unused = b.ad = activity.getComponentName().flattenToShortString();
        } else {
            String unused2 = b.ad = "";
        }
        b.D();
        if (g.J()) {
            boolean unused3 = b.ac = true;
            synchronized (b.ab) {
                b.ab.put(activity, Integer.valueOf(i));
                a(i);
            }
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        a(activity, 2);
    }

    public final void onActivityDestroyed(Activity activity) {
        if (g.J()) {
            boolean unused = b.ac = true;
            synchronized (b.ab) {
                b.ab.remove(activity);
                a(2);
            }
        }
    }

    public final void onActivityPaused(Activity activity) {
        a(activity, 2);
    }

    public final void onActivityResumed(Activity activity) {
        a(activity, 1);
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
        a(activity, 1);
    }

    public final void onActivityStopped(Activity activity) {
        a(activity, 2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    private void a(int i) {
        boolean isEmpty;
        if (e.u()) {
            a.a("crashsdk", "[LifeCycle] ignore state change while crashing");
            return;
        }
        boolean z = true;
        boolean z2 = 1 == i;
        if (!z2) {
            Iterator it = b.ab.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object value = ((Map.Entry) it.next()).getValue();
                if (value != null && ((Integer) value).intValue() == 1) {
                    break;
                }
            }
            if (this.a != z) {
                b.b(z);
                this.a = z;
            }
            isEmpty = b.ab.isEmpty();
            if (this.b == isEmpty) {
                if (isEmpty) {
                    b.w();
                }
                this.b = isEmpty;
                return;
            }
            return;
        }
        z = z2;
        if (this.a != z) {
        }
        isEmpty = b.ab.isEmpty();
        if (this.b == isEmpty) {
        }
    }
}
