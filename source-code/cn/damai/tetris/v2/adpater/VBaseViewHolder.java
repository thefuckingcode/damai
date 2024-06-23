package cn.damai.tetris.v2.adpater;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.tetris.core.IContext;
import cn.damai.tetris.core.IModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public abstract class VBaseViewHolder<T, C> extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    protected IContext a;
    protected T b;
    protected boolean c = false;

    public VBaseViewHolder(View view, IContext iContext) {
        super(view);
        this.a = iContext;
    }

    public T a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "249480987")) {
            return this.b;
        }
        return (T) ipChange.ipc$dispatch("249480987", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    public abstract IModel b();

    public void c(T t) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1172734758")) {
            ipChange.ipc$dispatch("-1172734758", new Object[]{this, t});
            return;
        }
        this.b = t;
    }

    public void d(IModel iModel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-272043917")) {
            ipChange.ipc$dispatch("-272043917", new Object[]{this, iModel});
        }
    }

    public IModel e(T t) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-595555293")) {
            return (IModel) ipChange.ipc$dispatch("-595555293", new Object[]{this, t});
        }
        this.b = t;
        return b();
    }

    public void onRecycled() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2053775005")) {
            ipChange.ipc$dispatch("-2053775005", new Object[]{this});
        }
    }

    public boolean rebindAble() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-309858323")) {
            return this.c;
        }
        return ((Boolean) ipChange.ipc$dispatch("-309858323", new Object[]{this})).booleanValue();
    }
}
