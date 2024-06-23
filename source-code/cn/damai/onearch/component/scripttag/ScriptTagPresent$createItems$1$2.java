package cn.damai.onearch.component.scripttag;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.component.GenericComponent;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import tb.ur2;

/* compiled from: Taobao */
public final class ScriptTagPresent$createItems$1$2 extends Lambda implements Function0<ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ GenericComponent<ComponentValue> $this_apply;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScriptTagPresent$createItems$1$2(GenericComponent<ComponentValue> genericComponent) {
        super(0);
        this.$this_apply = genericComponent;
    }

    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final ur2 invoke() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2112761877")) {
            return (ur2) ipChange.ipc$dispatch("-2112761877", new Object[]{this});
        }
        VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> innerAdapter = this.$this_apply.getInnerAdapter();
        if (innerAdapter != null) {
            innerAdapter.dataCount = this.$this_apply.getChildCount();
        }
        VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = this.$this_apply.getAdapter();
        if (adapter == null) {
            return null;
        }
        adapter.notifyItemChanged(0);
        return ur2.INSTANCE;
    }
}
