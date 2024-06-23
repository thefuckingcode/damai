package com.alient.onearch.adapter.component.empty;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.alient.onearch.adapter.R;
import com.alient.onearch.adapter.component.empty.GenericEmptyContract;
import com.alient.onearch.adapter.view.AbsView;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00012\u00020\u0006B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0007H\u0016R\u001e\u0010\u0011\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0014R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0014R\u0019\u0010\u0016\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/alient/onearch/adapter/component/empty/GenericEmptyView;", "Lcom/alient/onearch/adapter/view/AbsView;", "Lcom/youku/arch/v3/core/item/GenericItem;", "Lcom/youku/arch/v3/core/ItemValue;", "Lcom/alient/onearch/adapter/component/empty/GenericEmptyModel;", "Lcom/alient/onearch/adapter/component/empty/GenericEmptyPresent;", "Lcom/alient/onearch/adapter/component/empty/GenericEmptyContract$View;", "", "imageUrl", "Ltb/ur2;", "renderImage", "mainDesc", "renderMainDesc", "subDesc", "renderSubDesc", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "image", "Landroid/widget/ImageView;", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "Landroid/view/View;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public class GenericEmptyView extends AbsView<GenericItem<ItemValue>, GenericEmptyModel, GenericEmptyPresent> implements GenericEmptyContract.View {
    private final ImageView image;
    private final TextView mainDesc;
    private final TextView subDesc;
    @NotNull
    private final View view;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GenericEmptyView(@NotNull View view2) {
        super(view2);
        k21.i(view2, "view");
        this.view = view2;
        this.image = (ImageView) view2.findViewById(R.id.image);
        this.mainDesc = (TextView) view2.findViewById(R.id.main_desc);
        this.subDesc = (TextView) view2.findViewById(R.id.sub_desc);
    }

    @NotNull
    public final View getView() {
        return this.view;
    }

    @Override // com.alient.onearch.adapter.component.empty.GenericEmptyContract.View
    public void renderImage(@NotNull String str) {
        k21.i(str, "imageUrl");
        ImageLoaderProviderProxy.getProxy().loadinto(str, this.image);
    }

    @Override // com.alient.onearch.adapter.component.empty.GenericEmptyContract.View
    public void renderMainDesc(@NotNull String str) {
        k21.i(str, "mainDesc");
        TextView textView = this.mainDesc;
        if (textView != null) {
            textView.setText(str);
        }
    }

    @Override // com.alient.onearch.adapter.component.empty.GenericEmptyContract.View
    public void renderSubDesc(@NotNull String str) {
        k21.i(str, "subDesc");
        TextView textView = this.subDesc;
        if (textView != null) {
            textView.setText(str);
        }
    }
}
