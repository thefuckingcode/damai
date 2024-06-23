package cn.damai.tetris.core;

import android.view.View;
import cn.damai.tetris.core.IPresenter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import tb.gg2;
import tb.w9;

/* compiled from: Taobao */
public class AbsView<P extends IPresenter> implements IView<P>, Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private P mPresenter;
    private View mView;
    private gg2 styleType;

    public AbsView(View view) {
        this.mView = view;
    }

    public w9 getContext() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1799896894")) {
            return (w9) ipChange.ipc$dispatch("1799896894", new Object[]{this});
        }
        P p = this.mPresenter;
        if (p != null) {
            return p.getContext();
        }
        return null;
    }

    public P getPresenter() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1275800254")) {
            return this.mPresenter;
        }
        return (P) ((IPresenter) ipChange.ipc$dispatch("-1275800254", new Object[]{this}));
    }

    @Override // cn.damai.tetris.core.IView
    public View getRootView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1504962616")) {
            return this.mView;
        }
        return (View) ipChange.ipc$dispatch("1504962616", new Object[]{this});
    }

    public gg2 getStyleType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-965841760")) {
            return this.styleType;
        }
        return (gg2) ipChange.ipc$dispatch("-965841760", new Object[]{this});
    }

    public View getView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1167387386")) {
            return this.mView;
        }
        return (View) ipChange.ipc$dispatch("1167387386", new Object[]{this});
    }

    @Override // cn.damai.tetris.core.IView
    public void setPresenter(P p) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1307608228")) {
            ipChange.ipc$dispatch("-1307608228", new Object[]{this, p});
            return;
        }
        this.mPresenter = p;
    }

    @Override // cn.damai.tetris.core.IView
    public void setStyle(gg2 gg2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2137968378")) {
            ipChange.ipc$dispatch("-2137968378", new Object[]{this, gg2});
            return;
        }
        this.styleType = gg2;
    }

    public void setStyleType(gg2 gg2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1271224992")) {
            ipChange.ipc$dispatch("-1271224992", new Object[]{this, gg2});
            return;
        }
        this.styleType = gg2;
    }

    public void setView(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-550407386")) {
            ipChange.ipc$dispatch("-550407386", new Object[]{this, view});
            return;
        }
        this.mView = this.mView;
    }
}
