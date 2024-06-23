package com.alient.onearch.adapter.component.pager;

import com.youku.arch.v3.adapter.VBaseAdapter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import tb.ur2;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"Ltb/ur2;", "invoke", "()V", "com/alient/onearch/adapter/component/pager/PagerGridPresenter$init$1$$special$$inlined$apply$lambda$2", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class PagerGridPresenter$init$1$$special$$inlined$apply$lambda$3 extends Lambda implements Function0<ur2> {
    final /* synthetic */ Integer $columnCount$inlined;
    final /* synthetic */ Ref$IntRef $gap$inlined;
    final /* synthetic */ Ref$IntRef $marginLeft$inlined;
    final /* synthetic */ Ref$IntRef $marginRight$inlined;
    final /* synthetic */ VBaseAdapter $parentAdapter$inlined;
    final /* synthetic */ Integer $rowCount$inlined;
    final /* synthetic */ Ref$ObjectRef $rowHeight$inlined;
    final /* synthetic */ PagerGridPresenter$init$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PagerGridPresenter$init$1$$special$$inlined$apply$lambda$3(Integer num, Integer num2, VBaseAdapter vBaseAdapter, Ref$IntRef ref$IntRef, Ref$IntRef ref$IntRef2, Ref$IntRef ref$IntRef3, Ref$ObjectRef ref$ObjectRef, PagerGridPresenter$init$1 pagerGridPresenter$init$1) {
        super(0);
        this.$rowCount$inlined = num;
        this.$columnCount$inlined = num2;
        this.$parentAdapter$inlined = vBaseAdapter;
        this.$gap$inlined = ref$IntRef;
        this.$marginLeft$inlined = ref$IntRef2;
        this.$marginRight$inlined = ref$IntRef3;
        this.$rowHeight$inlined = ref$ObjectRef;
        this.this$0 = pagerGridPresenter$init$1;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        ((PagerGridView) this.this$0.this$0.getView()).renderPagerInView(this.$gap$inlined.element, this.$marginLeft$inlined.element, this.$marginRight$inlined.element, this.$rowHeight$inlined.element.intValue(), this.$columnCount$inlined.intValue(), this.this$0.this$0.childAdapters);
    }
}
