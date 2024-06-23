package com.alient.onearch.adapter.component.tab.base;

import android.view.View;
import com.alient.oneservice.nav.Action;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.youku.live.dago.model.PlayerInteract;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$ObjectRef;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u000e\u001a\u00020\n\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000\"\u000e\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0014\b\u0002\u0010\u0006*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00052\u000e\u0010\t\u001a\n \b*\u0004\u0018\u00010\u00070\u0007H\n¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/youku/arch/v3/core/item/GenericItem;", "Lcom/youku/arch/v3/core/ItemValue;", "I", "Lcom/youku/arch/v3/view/IContract$Model;", "M", "Lcom/youku/arch/v3/view/IContract$Presenter;", "P", "Landroid/view/View;", "kotlin.jvm.PlatformType", AdvanceSetting.NETWORK_TYPE, "Ltb/ur2;", PlayerInteract.ELEMENT_DEFAULT_ACTION, "(Landroid/view/View;)V", "com/alient/onearch/adapter/component/tab/base/BaseTabView$setComponentBtns$3$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class BaseTabView$setComponentBtns$$inlined$apply$lambda$3 implements View.OnClickListener {
    final /* synthetic */ Ref$ObjectRef $spmA$inlined;
    final /* synthetic */ Ref$ObjectRef $spmB$inlined;
    final /* synthetic */ Action $this_apply;
    final /* synthetic */ BaseTabView this$0;

    BaseTabView$setComponentBtns$$inlined$apply$lambda$3(Action action, BaseTabView baseTabView, Ref$ObjectRef ref$ObjectRef, Ref$ObjectRef ref$ObjectRef2) {
        this.$this_apply = action;
        this.this$0 = baseTabView;
        this.$spmA$inlined = ref$ObjectRef;
        this.$spmB$inlined = ref$ObjectRef2;
    }

    public final void onClick(View view) {
        BaseTabView baseTabView = this.this$0;
        baseTabView.rightBtnClick(baseTabView.getBtnTwo(), this.$this_apply);
    }
}
