package com.alient.onearch.adapter.loader;

import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.core.IContext;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import tb.ur2;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"Ltb/ur2;", "invoke", "()V", "com/alient/onearch/adapter/loader/BasePageLoader$handleLoadMore$1$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class BasePageLoader$$special$$inlined$apply$lambda$1 extends Lambda implements Function0<ur2> {
    final /* synthetic */ int $startUpdateIndex$inlined;
    final /* synthetic */ IContext $this_apply;
    final /* synthetic */ IComponent $this_with$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BasePageLoader$$special$$inlined$apply$lambda$1(IContext iContext, IComponent iComponent, int i) {
        super(0);
        this.$this_apply = iContext;
        this.$this_with$inlined = iComponent;
        this.$startUpdateIndex$inlined = i;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        this.$this_apply.runOnUIThreadLocked(new Function0<ur2>(this) {
            /* class com.alient.onearch.adapter.loader.BasePageLoader$$special$$inlined$apply$lambda$1.AnonymousClass1 */
            final /* synthetic */ BasePageLoader$$special$$inlined$apply$lambda$1 this$0;

            {
                this.this$0 = r1;
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final ur2 invoke() {
                try {
                    if (this.this$0.$this_with$inlined.getInnerAdapter() != null) {
                        VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> innerAdapter = this.this$0.$this_with$inlined.getInnerAdapter();
                        if (innerAdapter != null) {
                            innerAdapter.dataCount = this.this$0.$this_with$inlined.getChildCount();
                        }
                        VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> innerAdapter2 = this.this$0.$this_with$inlined.getInnerAdapter();
                        if (innerAdapter2 == null) {
                            return null;
                        }
                        BasePageLoader$$special$$inlined$apply$lambda$1 basePageLoader$$special$$inlined$apply$lambda$1 = this.this$0;
                        innerAdapter2.notifyItemRangeInserted(basePageLoader$$special$$inlined$apply$lambda$1.$startUpdateIndex$inlined, basePageLoader$$special$$inlined$apply$lambda$1.$this_with$inlined.getChildCount() - this.this$0.$startUpdateIndex$inlined);
                        return ur2.INSTANCE;
                    }
                    VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = this.this$0.$this_with$inlined.getAdapter();
                    if (adapter != null) {
                        adapter.dataCount = this.this$0.$this_with$inlined.getChildCount();
                    }
                    VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter2 = this.this$0.$this_with$inlined.getAdapter();
                    if (adapter2 == null) {
                        return null;
                    }
                    BasePageLoader$$special$$inlined$apply$lambda$1 basePageLoader$$special$$inlined$apply$lambda$12 = this.this$0;
                    adapter2.notifyItemRangeInserted(basePageLoader$$special$$inlined$apply$lambda$12.$startUpdateIndex$inlined, basePageLoader$$special$$inlined$apply$lambda$12.$this_with$inlined.getChildCount() - this.this$0.$startUpdateIndex$inlined);
                    return ur2.INSTANCE;
                } catch (Exception e) {
                    e.printStackTrace();
                    return ur2.INSTANCE;
                }
            }
        });
    }
}
