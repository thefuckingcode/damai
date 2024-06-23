package cn.damai.onearch.component.project;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.IContext;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.component.GenericComponent;
import com.youku.arch.v3.data.Constants;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* compiled from: Taobao */
public final class OneProjectComponent extends GenericComponent<ComponentValue> {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OneProjectComponent(@NotNull IContext iContext, @NotNull Node node) {
        super(iContext, node);
        k21.i(iContext, Constants.PAGE_CONTEXT);
        k21.i(node, "node");
    }

    @Override // com.youku.arch.v3.DomainObject, com.youku.arch.v3.core.component.GenericComponent
    public void initProperties(@NotNull Node node) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-734106026")) {
            ipChange.ipc$dispatch("-734106026", new Object[]{this, node});
            return;
        }
        k21.i(node, "data");
        super.initProperties(node);
    }
}
