package tb;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import cn.damai.tetris.R$layout;
import cn.damai.tetris.core.BaseLayer;
import cn.damai.tetris.core.adapter.VerticalAdapter;
import cn.damai.tetris.core.holder.BaseViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class vv2 {
    private static transient /* synthetic */ IpChange $ipChange;
    w9 a;

    public vv2(Activity activity) {
        w9 w9Var = new w9();
        this.a = w9Var;
        w9Var.setActivity(activity);
    }

    public w9 a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1372332307")) {
            return this.a;
        }
        return (w9) ipChange.ipc$dispatch("1372332307", new Object[]{this});
    }

    public String b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1203965371")) {
            return (String) ipChange.ipc$dispatch("1203965371", new Object[]{this});
        }
        w9 w9Var = this.a;
        if (w9Var == null) {
            return "";
        }
        return w9Var.a();
    }

    public LinearLayout c(ArrayList<BaseLayer> arrayList, ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "796979545")) {
            return (LinearLayout) ipChange.ipc$dispatch("796979545", new Object[]{this, arrayList, viewGroup});
        }
        List<BaseLayer> o = qa.o(arrayList);
        VerticalAdapter verticalAdapter = new VerticalAdapter(this.a, new kv2());
        verticalAdapter.b(o);
        w9 w9Var = this.a;
        if (w9Var == null || w9Var.getActivity() == null) {
            n91.b("ViewCreater", " toLinearLayout : baseContext is null ");
            return null;
        }
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.a.getActivity()).inflate(R$layout.tetris_core_linear_proxy, viewGroup, false);
        for (int i = 0; i < verticalAdapter.getItemCount(); i++) {
            BaseViewHolder f = verticalAdapter.onCreateViewHolder(linearLayout, verticalAdapter.getItemViewType(i));
            verticalAdapter.onBindViewHolder(f, i);
            linearLayout.addView(f.itemView);
        }
        return linearLayout;
    }
}
