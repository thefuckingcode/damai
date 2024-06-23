package cn.damai.onearch.component.project;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.ICreator;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.Config;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.Node;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* compiled from: Taobao */
public final class OneProjectCreator implements ICreator<IComponent<ComponentValue>, Node> {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.youku.arch.v3.ICreator
    @NotNull
    public IComponent<ComponentValue> create(@NotNull Config<Node> config) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-993427548")) {
            return (IComponent) ipChange.ipc$dispatch("-993427548", new Object[]{this, config});
        }
        k21.i(config, Constants.CONFIG);
        return new OneProjectComponent(config.getContext(), config.getData());
    }
}
