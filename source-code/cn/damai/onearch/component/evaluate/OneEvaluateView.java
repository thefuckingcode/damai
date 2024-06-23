package cn.damai.onearch.component.evaluate;

import android.view.View;
import cn.damai.evaluate.ui.item.EvaluateItemViewHolder;
import cn.damai.onearch.component.evaluate.OneEvaluate;
import com.alient.onearch.adapter.view.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* compiled from: Taobao */
public final class OneEvaluateView extends AbsView<GenericItem<ItemValue>, OneEvaluateModel, OneEvaluatePresent> implements OneEvaluate.View {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final View itemView;
    @NotNull
    private final EvaluateItemViewHolder mEvaluateView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OneEvaluateView(@NotNull View view) {
        super(view);
        k21.i(view, "itemView");
        this.itemView = view;
        this.mEvaluateView = new EvaluateItemViewHolder(view);
    }

    @Override // cn.damai.onearch.component.evaluate.OneEvaluate.View
    @NotNull
    public EvaluateItemViewHolder getEvaluateHolder() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1763813544")) {
            return this.mEvaluateView;
        }
        return (EvaluateItemViewHolder) ipChange.ipc$dispatch("1763813544", new Object[]{this});
    }

    @NotNull
    public final View getItemView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1605787763")) {
            return this.itemView;
        }
        return (View) ipChange.ipc$dispatch("1605787763", new Object[]{this});
    }
}
