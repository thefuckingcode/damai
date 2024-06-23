package cn.damai.search.component.script;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.IModule;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.ModuleValue;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class ScriptMoreComponent$replaceOrRemove$1$1$1 extends Lambda implements Function0<IComponent<ComponentValue>> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ IComponent<ComponentValue> $component;
    final /* synthetic */ IModule<ModuleValue> $lastModule;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScriptMoreComponent$replaceOrRemove$1$1$1(IComponent<ComponentValue> iComponent, IModule<ModuleValue> iModule) {
        super(0);
        this.$component = iComponent;
        this.$lastModule = iModule;
    }

    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final IComponent<ComponentValue> invoke() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-697332622")) {
            return (IComponent) ipChange.ipc$dispatch("-697332622", new Object[]{this});
        }
        IComponent<ComponentValue> iComponent = this.$component;
        if (iComponent == null) {
            return null;
        }
        IModule<ModuleValue> iModule = this.$lastModule;
        iModule.replaceComponent(iModule.getComponents().size() - 1, iComponent);
        return iComponent;
    }
}
