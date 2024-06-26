package com.youku.arch.v3.creator;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.ICreator;
import com.youku.arch.v3.IModule;
import com.youku.arch.v3.core.Config;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.ModuleValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.module.GenericModule;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0005H\u0016¨\u0006\n"}, d2 = {"Lcom/youku/arch/v3/creator/ModuleCreator;", "Lcom/youku/arch/v3/ICreator;", "Lcom/youku/arch/v3/IModule;", "Lcom/youku/arch/v3/core/ModuleValue;", "Lcom/youku/arch/v3/core/Node;", "Lcom/youku/arch/v3/core/Config;", Constants.CONFIG, "create", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class ModuleCreator implements ICreator<IModule<ModuleValue>, Node> {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.youku.arch.v3.ICreator
    @NotNull
    public IModule<ModuleValue> create(@NotNull Config<Node> config) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "26814804")) {
            return (IModule) ipChange.ipc$dispatch("26814804", new Object[]{this, config});
        }
        k21.i(config, Constants.CONFIG);
        return new GenericModule(config.getContext(), config.getData());
    }
}
