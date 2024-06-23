package me.ele.altriax.launcher.config.impl;

import androidx.annotation.Keep;
import com.taobao.android.job.core.DAGTaskChain;

@Keep
/* compiled from: Taobao */
public final class DamaiGenerator extends AltriaXGenerator {
    @Override // com.taobao.android.launcher.config.Generator, me.ele.altriax.launcher.config.impl.AltriaXGenerator
    public void genChannelAttach(DAGTaskChain<String> dAGTaskChain) {
        dAGTaskChain.createTaskPair("DMInitMtop", "DMInitLoginSDK");
        dAGTaskChain.createInitialTask("DMInitUT");
        dAGTaskChain.createInitialTask("DMInitTetrisProxy");
        dAGTaskChain.createInitialTask("DMInitDynamicX");
    }

    @Override // com.taobao.android.launcher.config.Generator, me.ele.altriax.launcher.config.impl.AltriaXGenerator
    public void genMainCreate(DAGTaskChain<String> dAGTaskChain) {
        dAGTaskChain.createTaskPair("DMInitMtop", "DMInitLoginSDK");
        dAGTaskChain.createInitialTask("DMInitImageLoader");
        dAGTaskChain.createInitialTask("DMInitNav");
        dAGTaskChain.createInitialTask("DMInitUT");
        dAGTaskChain.createInitialTask("DMInitTetrisProxy");
        dAGTaskChain.createInitialTask("DMInitDynamicX");
    }
}
