package com.alient.onearch.adapter.view;

import android.view.View;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.view.IContract;
import com.youku.arch.v3.view.IContract.Model;
import com.youku.arch.v3.view.IContract.Presenter;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000*\u000e\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00020\u00020\u0001*\u000e\b\u0001\u0010\u0005*\b\u0012\u0004\u0012\u00028\u00000\u0004*\u0014\b\u0002\u0010\u0007*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00062\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\bB\u0011\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/alient/onearch/adapter/view/AbsView;", "Lcom/youku/arch/v3/IItem;", "Lcom/youku/arch/v3/core/ItemValue;", "I", "Lcom/youku/arch/v3/view/IContract$Model;", "M", "Lcom/youku/arch/v3/view/IContract$Presenter;", "P", "Lcom/youku/arch/v3/view/AbsView;", "Landroid/view/View;", "renderView", "Landroid/view/View;", "getRenderView", "()Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public class AbsView<I extends IItem<ItemValue>, M extends IContract.Model<I>, P extends IContract.Presenter<I, M>> extends com.youku.arch.v3.view.AbsView<I, M, P> {
    @Nullable
    private final View renderView;

    public AbsView(@Nullable View view) {
        super(view);
        this.renderView = view;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener(this) {
                /* class com.alient.onearch.adapter.view.AbsView.AnonymousClass1 */
                final /* synthetic */ AbsView this$0;

                {
                    this.this$0 = r1;
                }

                public final void onClick(View view) {
                    IContract.Presenter presenter = this.this$0.getPresenter();
                    if (!(presenter instanceof AbsPresenter)) {
                        presenter = null;
                    }
                    AbsPresenter absPresenter = (AbsPresenter) presenter;
                    if (absPresenter != null) {
                        absPresenter.itemClick(this.this$0.getRenderView());
                    }
                }
            });
        }
        if (view != null) {
            view.setOnLongClickListener(new View.OnLongClickListener(this) {
                /* class com.alient.onearch.adapter.view.AbsView.AnonymousClass2 */
                final /* synthetic */ AbsView this$0;

                {
                    this.this$0 = r1;
                }

                public final boolean onLongClick(View view) {
                    IContract.Presenter presenter = this.this$0.getPresenter();
                    if (!(presenter instanceof AbsPresenter)) {
                        presenter = null;
                    }
                    AbsPresenter absPresenter = (AbsPresenter) presenter;
                    if (absPresenter == null) {
                        return true;
                    }
                    absPresenter.itemLongClick(this.this$0.getRenderView());
                    return true;
                }
            });
        }
    }

    @Override // com.youku.arch.v3.view.AbsView, com.youku.arch.v3.view.IContract.View
    @Nullable
    public final View getRenderView() {
        return this.renderView;
    }
}
