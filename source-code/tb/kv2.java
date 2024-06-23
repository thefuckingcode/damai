package tb;

import android.view.ViewGroup;
import cn.damai.tetris.core.holder.AbsViewHolder;
import cn.damai.tetris.core.holder.IViewHolderFactory;
import cn.damai.tetris.core.holder.LayerViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class kv2 implements IViewHolderFactory {
    private static transient /* synthetic */ IpChange $ipChange;

    /* renamed from: a */
    public AbsViewHolder createHolder(int i, ViewGroup viewGroup, w9 w9Var) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1680352731")) {
            return new LayerViewHolder(new y40(viewGroup, i), w9Var);
        }
        return (AbsViewHolder) ipChange.ipc$dispatch("1680352731", new Object[]{this, Integer.valueOf(i), viewGroup, w9Var});
    }
}
