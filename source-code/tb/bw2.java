package tb;

import androidx.viewpager.widget.ViewPager;
import cn.damai.ticklet.view.ViewPagerScroller;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.reflect.Field;

/* compiled from: Taobao */
public class bw2 {
    private static transient /* synthetic */ IpChange $ipChange;
    ViewPager a;
    ViewPagerScroller b;

    public bw2(ViewPager viewPager) {
        this.a = viewPager;
        b();
    }

    private void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1498667205")) {
            ipChange.ipc$dispatch("1498667205", new Object[]{this});
            return;
        }
        this.b = new ViewPagerScroller(this.a.getContext());
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            declaredField.set(this.a, this.b);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
    }

    public ViewPagerScroller a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1724606404")) {
            return this.b;
        }
        return (ViewPagerScroller) ipChange.ipc$dispatch("-1724606404", new Object[]{this});
    }
}
