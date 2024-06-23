package com.alibaba.pictures.bricks.component.footer;

import android.view.View;
import android.widget.TextView;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.component.footer.SectionFooterContract;
import com.alibaba.pictures.bricks.onearch.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import tb.y72;

/* compiled from: Taobao */
public class SectionFooterView extends AbsView<IItem<ItemValue>, SectionFooterContract.Model<IItem<ItemValue>>, SectionFooterContract.Presenter<IItem<ItemValue>, SectionFooterContract.Model<IItem<ItemValue>>>> implements SectionFooterContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    private final TextView content;

    public SectionFooterView(View view) {
        super(view);
        this.content = (TextView) view.findViewById(R$id.footer_content);
        view.setOnClickListener(new y72(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-866408059")) {
            ipChange.ipc$dispatch("-866408059", new Object[]{this, view});
            return;
        }
        ((SectionFooterContract.Presenter) this.presenter).dispatchAction();
    }

    @Override // com.alibaba.pictures.bricks.component.footer.SectionFooterContract.View
    public void renderContent(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1518158933")) {
            ipChange.ipc$dispatch("1518158933", new Object[]{this, str});
            return;
        }
        this.content.setText(str);
    }
}
