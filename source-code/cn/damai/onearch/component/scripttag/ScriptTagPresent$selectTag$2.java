package cn.damai.onearch.component.scripttag;

import cn.damai.onearch.component.scripttag.ScriptTagPresent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.data.Repository;
import java.util.LinkedHashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.ur2;

/* compiled from: Taobao */
public final class ScriptTagPresent$selectTag$2 extends Lambda implements Function0<ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ int $tagPosition;
    final /* synthetic */ ScriptTagPresent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScriptTagPresent$selectTag$2(ScriptTagPresent scriptTagPresent, int i) {
        super(0);
        this.this$0 = scriptTagPresent;
        this.$tagPosition = i;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1359181561")) {
            ipChange.ipc$dispatch("1359181561", new Object[]{this});
            return;
        }
        Repository.Companion.getInstance().request(new ScriptTagPresent.ScriptRequestBuilder(this.$tagPosition).build(new LinkedHashMap()), new ScriptTagPresent.ScriptRequestCallBack());
    }
}
