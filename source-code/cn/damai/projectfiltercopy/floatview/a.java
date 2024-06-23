package cn.damai.projectfiltercopy.floatview;

import android.content.Context;
import cn.damai.projectfiltercopy.FloatListener;
import cn.damai.projectfiltercopy.bean.FilterData;
import cn.damai.projectfiltercopy.bean.Type;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.ni0;

/* compiled from: Taobao */
public abstract class a<T> implements FloatLayer<T> {
    private static transient /* synthetic */ IpChange $ipChange;
    protected Context a;
    private FloatListener b;
    private ni0 c;

    /* renamed from: cn.damai.projectfiltercopy.floatview.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public class C0033a implements FloatListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C0033a(a aVar) {
        }

        @Override // cn.damai.projectfiltercopy.FloatListener
        public void onFloatCall(Type type, FilterData filterData) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-5603356")) {
                ipChange.ipc$dispatch("-5603356", new Object[]{this, type, filterData});
            }
        }
    }

    public a(Context context) {
        this.a = context;
    }

    @Override // cn.damai.projectfiltercopy.floatview.FloatLayer
    public ni0 getFilterUt() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1858641486")) {
            return (ni0) ipChange.ipc$dispatch("-1858641486", new Object[]{this});
        }
        ni0 ni0 = this.c;
        return ni0 == null ? new ni0("default") : ni0;
    }

    @Override // cn.damai.projectfiltercopy.floatview.FloatLayer
    public FloatListener getListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1819500771")) {
            return (FloatListener) ipChange.ipc$dispatch("1819500771", new Object[]{this});
        }
        FloatListener floatListener = this.b;
        return floatListener == null ? new C0033a(this) : floatListener;
    }

    @Override // cn.damai.projectfiltercopy.floatview.FloatLayer
    public void setFilterUt(ni0 ni0) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "187550422")) {
            ipChange.ipc$dispatch("187550422", new Object[]{this, ni0});
            return;
        }
        this.c = ni0;
    }

    @Override // cn.damai.projectfiltercopy.floatview.FloatLayer
    public void setListener(FloatListener floatListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1677925715")) {
            ipChange.ipc$dispatch("-1677925715", new Object[]{this, floatListener});
            return;
        }
        this.b = floatListener;
    }
}
