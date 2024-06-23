package tb;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.address.bean.DivisionBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class l90 extends p2 {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<DivisionBean> i;

    public l90(Context context, List<DivisionBean> list) {
        super(context);
        this.i = list;
        e(context.getResources().getColor(R$color.color_222222));
        f(16);
    }

    /* access modifiers changed from: protected */
    @Override // tb.p2
    public CharSequence b(int i2) {
        DivisionBean divisionBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-510270704")) {
            return (CharSequence) ipChange.ipc$dispatch("-510270704", new Object[]{this, Integer.valueOf(i2)});
        }
        if (i2 < 0 || i2 > this.i.size() || (divisionBean = this.i.get(i2)) == null) {
            return null;
        }
        return divisionBean.getDivisionName();
    }

    @Override // cn.damai.uikit.wheel.adapters.WheelViewAdapter, tb.p2
    public View getItem(int i2, View view, ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2073344022")) {
            return super.getItem(i2, view, viewGroup);
        }
        return (View) ipChange.ipc$dispatch("2073344022", new Object[]{this, Integer.valueOf(i2), view, viewGroup});
    }

    @Override // cn.damai.uikit.wheel.adapters.WheelViewAdapter
    public int getItemsCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-200012035")) {
            return ((Integer) ipChange.ipc$dispatch("-200012035", new Object[]{this})).intValue();
        }
        List<DivisionBean> list = this.i;
        if (list != null) {
            return list.size();
        }
        return 0;
    }
}
