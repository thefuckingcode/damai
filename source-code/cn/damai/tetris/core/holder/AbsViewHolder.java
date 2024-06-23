package cn.damai.tetris.core.holder;

import android.view.LayoutInflater;
import android.view.View;
import cn.damai.tetris.core.BaseLayer;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.IView;
import cn.damai.tetris.core.config.ComponentConfig;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.a1;
import tb.n91;
import tb.w9;
import tb.wl;

/* compiled from: Taobao */
public abstract class AbsViewHolder<T extends a1, P extends BasePresenter, L extends BaseLayer> extends BaseViewHolder {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String TAG = "AbsViewHolder";
    protected P a;
    protected T b;
    IView c;

    public AbsViewHolder(T t, w9 w9Var) {
        super(t.d());
        n91.a(TAG, "AbsViewHolder start. ");
        if (w9Var != null && w9Var.getActivity() != null) {
            this.b = t;
            int a2 = t.a();
            ComponentConfig a3 = wl.c(w9Var.getActivity()).a(a2);
            n91.a(TAG, "AbsViewHolder get config . type: " + a2 + " , config " + a3);
            if (a3 != null) {
                View inflate = LayoutInflater.from(w9Var.getActivity()).inflate(w9Var.getActivity().getResources().getIdentifier(a3.layoutXml, "layout", w9Var.getActivity().getPackageName()), t.d(), false);
                try {
                    Class<?> cls = Class.forName(a3.vClass);
                    IView iView = (IView) cls.getConstructor(View.class).newInstance(inflate);
                    this.c = iView;
                    a(t, iView);
                    this.a = (P) ((BasePresenter) Class.forName(a3.pClass).getConstructor(cls, String.class, w9.class).newInstance(this.c, a3.mClass, w9Var));
                } catch (Exception e) {
                    e.printStackTrace();
                    n91.b(TAG, "AbsViewHolder Class.forName :" + e);
                }
            }
        }
    }

    public abstract void a(T t, IView iView);

    public P b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-439638794")) {
            return this.a;
        }
        return (P) ((BasePresenter) ipChange.ipc$dispatch("-439638794", new Object[]{this}));
    }

    public void c(L l) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-598750757")) {
            ipChange.ipc$dispatch("-598750757", new Object[]{this, l});
            return;
        }
        this.b.e(l);
    }
}
