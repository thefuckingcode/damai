package cn.damai.projectfilter.floatview;

import android.content.Context;
import cn.damai.projectfilter.FloatListener;
import cn.damai.projectfilter.bean.FilterData;
import cn.damai.projectfilter.bean.Type;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.oi0;

/* compiled from: Taobao */
public abstract class a<T> implements FloatLayer<T> {
    private static transient /* synthetic */ IpChange $ipChange;
    protected Context a;
    private FloatListener b;
    private oi0 c;

    /* renamed from: cn.damai.projectfilter.floatview.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public class C0032a implements FloatListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C0032a(a aVar) {
        }

        @Override // cn.damai.projectfilter.FloatListener
        public void onFloatCall(Type type, FilterData filterData) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1273433309")) {
                ipChange.ipc$dispatch("-1273433309", new Object[]{this, type, filterData});
            }
        }
    }

    public a(Context context) {
        this.a = context;
    }

    @Override // cn.damai.projectfilter.floatview.FloatLayer
    public oi0 getFilterUt() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-20837230")) {
            return (oi0) ipChange.ipc$dispatch("-20837230", new Object[]{this});
        }
        oi0 oi0 = this.c;
        return oi0 == null ? new oi0("default") : oi0;
    }

    @Override // cn.damai.projectfilter.floatview.FloatLayer
    public FloatListener getListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-737537469")) {
            return (FloatListener) ipChange.ipc$dispatch("-737537469", new Object[]{this});
        }
        FloatListener floatListener = this.b;
        return floatListener == null ? new C0032a(this) : floatListener;
    }

    @Override // cn.damai.projectfilter.floatview.FloatLayer
    public void setFilterUt(oi0 oi0) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-308028224")) {
            ipChange.ipc$dispatch("-308028224", new Object[]{this, oi0});
            return;
        }
        this.c = oi0;
    }

    @Override // cn.damai.projectfilter.floatview.FloatLayer
    public void setListener(FloatListener floatListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-974668265")) {
            ipChange.ipc$dispatch("-974668265", new Object[]{this, floatListener});
            return;
        }
        this.b = floatListener;
    }
}
