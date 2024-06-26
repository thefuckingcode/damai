package com.alibaba.pictures.bricks.component.text;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.component.text.RichTextViewContract;
import com.alient.onearch.adapter.view.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* compiled from: Taobao */
public final class RichTextViewView extends AbsView<GenericItem<ItemValue>, RichTextViewModel, RichTextViewPresent> implements RichTextViewContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private View itemView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RichTextViewView(@NotNull View view) {
        super(view);
        k21.i(view, "itemView");
        this.itemView = view;
    }

    @NotNull
    public final View getItemView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1768537858")) {
            return this.itemView;
        }
        return (View) ipChange.ipc$dispatch("1768537858", new Object[]{this});
    }

    @Override // com.alibaba.pictures.bricks.component.text.RichTextViewContract.View
    @NotNull
    public RecyclerView getRichTextView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1047211281")) {
            return (RecyclerView) ipChange.ipc$dispatch("1047211281", new Object[]{this});
        }
        View findViewById = this.itemView.findViewById(R$id.bricks_richtext_click_more);
        k21.h(findViewById, "itemView.findViewById(R.…icks_richtext_click_more)");
        return (RecyclerView) findViewById;
    }

    @Override // com.alibaba.pictures.bricks.component.text.RichTextViewContract.View
    @NotNull
    public TextView getShowMoreView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-609382155")) {
            return (TextView) ipChange.ipc$dispatch("-609382155", new Object[]{this});
        }
        View findViewById = this.itemView.findViewById(R$id.bricks_richtext_recycleview);
        k21.h(findViewById, "itemView.findViewById(R.…cks_richtext_recycleview)");
        return (TextView) findViewById;
    }

    public final void setItemView(@NotNull View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "743782942")) {
            ipChange.ipc$dispatch("743782942", new Object[]{this, view});
            return;
        }
        k21.i(view, "<set-?>");
        this.itemView = view;
    }
}
