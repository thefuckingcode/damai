package tb;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import cn.damai.tetris.core.BaseLayer;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public abstract class a1<L extends BaseLayer> {
    private static transient /* synthetic */ IpChange $ipChange;
    private ViewGroup a;
    private int b;

    public a1(ViewGroup viewGroup, int i) {
        this.b = i;
        if (b(i) > 0) {
            this.a = (ViewGroup) LayoutInflater.from(viewGroup.getContext()).inflate(b(i), viewGroup, false);
        } else {
            this.a = c(i);
        }
    }

    public int a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "698421671")) {
            return this.b;
        }
        return ((Integer) ipChange.ipc$dispatch("698421671", new Object[]{this})).intValue();
    }

    public abstract int b(int i);

    public abstract ViewGroup c(int i);

    public ViewGroup d() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "453385876")) {
            return this.a;
        }
        return (ViewGroup) ipChange.ipc$dispatch("453385876", new Object[]{this});
    }

    public abstract void e(L l);
}
