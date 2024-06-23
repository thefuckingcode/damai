package com.alient.onearch.adapter.component.header;

import android.view.View;
import android.widget.TextView;
import com.alient.oneservice.nav.Action;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.youku.live.dago.model.PlayerInteract;
import kotlin.Metadata;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", AdvanceSetting.NETWORK_TYPE, "Ltb/ur2;", PlayerInteract.ELEMENT_DEFAULT_ACTION, "(Landroid/view/View;)V", "com/alient/onearch/adapter/component/header/GenericHeaderView$$special$$inlined$let$lambda$2", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class GenericHeaderView$renderBtnTwo$$inlined$apply$lambda$1 implements View.OnClickListener {
    final /* synthetic */ Action $action$inlined;
    final /* synthetic */ String $text$inlined;
    final /* synthetic */ TextView $this_apply$inlined;
    final /* synthetic */ GenericHeaderView this$0;

    GenericHeaderView$renderBtnTwo$$inlined$apply$lambda$1(TextView textView, GenericHeaderView genericHeaderView, String str, Action action) {
        this.$this_apply$inlined = textView;
        this.this$0 = genericHeaderView;
        this.$text$inlined = str;
        this.$action$inlined = action;
    }

    public final void onClick(View view) {
        this.this$0.rightBtnClick(this.$this_apply$inlined, this.$action$inlined);
    }
}
