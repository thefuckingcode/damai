package com.alient.onearch.adapter.component.more;

import android.view.View;
import android.widget.TextView;
import com.alient.onearch.adapter.R;
import com.alient.onearch.adapter.component.more.GenericMoreContract;
import com.alient.onearch.adapter.view.AbsView;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00012\u00020\u0006B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u001e\u0010\b\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\rR\u0019\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/alient/onearch/adapter/component/more/GenericMoreView;", "Lcom/alient/onearch/adapter/view/AbsView;", "Lcom/youku/arch/v3/core/item/GenericItem;", "Lcom/youku/arch/v3/core/ItemValue;", "Lcom/alient/onearch/adapter/component/more/GenericMoreModel;", "Lcom/alient/onearch/adapter/component/more/GenericMorePresent;", "Lcom/alient/onearch/adapter/component/more/GenericMoreContract$View;", "", "content", "Ltb/ur2;", "renderContent", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "Landroid/widget/TextView;", "Landroid/view/View;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public class GenericMoreView extends AbsView<GenericItem<ItemValue>, GenericMoreModel, GenericMorePresent> implements GenericMoreContract.View {
    private final TextView content;
    @NotNull
    private final View view;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GenericMoreView(@NotNull View view2) {
        super(view2);
        k21.i(view2, "view");
        this.view = view2;
        this.content = (TextView) view2.findViewById(R.id.content);
    }

    @NotNull
    public final View getView() {
        return this.view;
    }

    @Override // com.alient.onearch.adapter.component.more.GenericMoreContract.View
    public void renderContent(@NotNull String str) {
        k21.i(str, "content");
        TextView textView = this.content;
        k21.h(textView, "this.content");
        textView.setText(str);
    }
}
