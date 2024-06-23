package com.alient.onearch.adapter.component.tab.generic.vertical;

import com.youku.arch.v3.IItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.ur2;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"Ltb/ur2;", "invoke", "()V", "com/alient/onearch/adapter/component/tab/generic/vertical/VerticalTabView$setChildComponentData$2$2", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class VerticalTabView$setChildComponentData$$inlined$apply$lambda$1 extends Lambda implements Function0<ur2> {
    final /* synthetic */ List $childComponentNodes$inlined;
    final /* synthetic */ List $childComponentTitles$inlined;
    final /* synthetic */ IItem $containerItem$inlined;
    final /* synthetic */ VerticalTabView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VerticalTabView$setChildComponentData$$inlined$apply$lambda$1(VerticalTabView verticalTabView, List list, List list2, IItem iItem) {
        super(0);
        this.this$0 = verticalTabView;
        this.$childComponentTitles$inlined = list;
        this.$childComponentNodes$inlined = list2;
        this.$containerItem$inlined = iItem;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        this.$containerItem$inlined.getPageContext().runOnUIThreadLocked(new Function0<ur2>(this) {
            /* class com.alient.onearch.adapter.component.tab.generic.vertical.VerticalTabView$setChildComponentData$$inlined$apply$lambda$1.AnonymousClass1 */
            final /* synthetic */ VerticalTabView$setChildComponentData$$inlined$apply$lambda$1 this$0;

            {
                this.this$0 = r1;
            }

            @Override // kotlin.jvm.functions.Function0
            public final void invoke() {
                VerticalTabView verticalTabView = this.this$0.this$0;
                verticalTabView.showCurrentComponent(verticalTabView.getCurrentSelectedTabPosition(), false);
            }
        });
    }
}
