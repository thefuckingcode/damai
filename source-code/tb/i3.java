package tb;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import cn.damai.common.nav.DMNav;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Iterator;
import java.util.Stack;

/* compiled from: Taobao */
public class i3 implements DMNav.NavStack {
    private static transient /* synthetic */ IpChange $ipChange;
    private static i3 b;
    private Stack<Activity> a;

    private i3() {
        d();
    }

    public static synchronized i3 b() {
        synchronized (i3.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1757619517")) {
                return (i3) ipChange.ipc$dispatch("1757619517", new Object[0]);
            }
            if (b == null) {
                b = new i3();
            }
            return b;
        }
    }

    private void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1409390452")) {
            ipChange.ipc$dispatch("1409390452", new Object[]{this});
            return;
        }
        this.a = new Stack<>();
    }

    public void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "859277048")) {
            ipChange.ipc$dispatch("859277048", new Object[]{this});
            return;
        }
        Log.d("ActManager", "removeAll: " + this.a.toString());
        Iterator<Activity> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().finish();
        }
        this.a.clear();
    }

    public Activity c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-847823438")) {
            return (Activity) ipChange.ipc$dispatch("-847823438", new Object[]{this});
        } else if (this.a.isEmpty()) {
            return null;
        } else {
            return this.a.peek();
        }
    }

    @Override // cn.damai.common.nav.DMNav.NavStack
    public boolean checkExist(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2060171562")) {
            return ((Boolean) ipChange.ipc$dispatch("-2060171562", new Object[]{this, intent})).booleanValue();
        }
        if (!(intent == null || intent.getComponent() == null)) {
            String className = intent.getComponent().getClassName();
            Log.d("ActManager", "checkExist: " + className);
            Iterator<Activity> it = this.a.iterator();
            while (it.hasNext()) {
                if (it.next().getClass().getName().equals(className)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // cn.damai.common.nav.DMNav.NavStack
    public void clearStack() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-34972375")) {
            ipChange.ipc$dispatch("-34972375", new Object[]{this});
            return;
        }
        a();
    }

    public Activity e(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "381852460")) {
            return (Activity) ipChange.ipc$dispatch("381852460", new Object[]{this, activity});
        }
        Log.d("ActManager", "ActivityManager.push():" + activity.getClass().getSimpleName());
        return this.a.push(activity);
    }

    public void f(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "583368466")) {
            ipChange.ipc$dispatch("583368466", new Object[]{this, activity});
            return;
        }
        Log.d("ActManager", "ActivityManager.remove():" + activity.getClass().getSimpleName());
        this.a.removeElement(activity);
    }
}
