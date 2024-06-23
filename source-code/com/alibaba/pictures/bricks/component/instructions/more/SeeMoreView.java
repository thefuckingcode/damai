package com.alibaba.pictures.bricks.component.instructions.more;

import android.view.View;
import android.widget.TextView;
import com.alibaba.pictures.bricks.component.instructions.more.SeeMoreContract;
import com.alient.onearch.adapter.R;
import com.alient.onearch.adapter.view.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* compiled from: Taobao */
public final class SeeMoreView extends AbsView<GenericItem<ItemValue>, SeeMoreModel, SeeMorePresent> implements SeeMoreContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    private final TextView content;
    @NotNull
    private final View view;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SeeMoreView(@NotNull View view2) {
        super(view2);
        k21.i(view2, "view");
        this.view = view2;
        this.content = (TextView) view2.findViewById(R.id.content);
    }

    @NotNull
    public final View getView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1938087917")) {
            return this.view;
        }
        return (View) ipChange.ipc$dispatch("1938087917", new Object[]{this});
    }

    @Override // com.alibaba.pictures.bricks.component.instructions.more.SeeMoreContract.View
    public void renderContent(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1364363571")) {
            ipChange.ipc$dispatch("-1364363571", new Object[]{this, str});
            return;
        }
        k21.i(str, "content");
        this.content.setText(str);
    }
}
