package com.alient.onearch.adapter.parser.module;

import com.alibaba.fastjson.JSONObject;
import com.alient.onearch.adapter.pom.BasicModuleValue;
import com.taobao.analysis.StageType;
import com.youku.arch.v3.core.Node;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\b"}, d2 = {"Lcom/alient/onearch/adapter/parser/module/BasicModuleParser;", "Lcom/alient/onearch/adapter/parser/module/AbsModuleParser;", "Lcom/alient/onearch/adapter/pom/BasicModuleValue;", "Lcom/youku/arch/v3/core/Node;", "node", StageType.PARSE, "<init>", "()V", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public class BasicModuleParser extends AbsModuleParser<BasicModuleValue> {
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0029, code lost:
        if (com.youku.middlewareservice.provider.info.AppInfoProviderProxy.isDebuggable() != false) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002c, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0022, code lost:
        r1 = (com.alient.onearch.adapter.pom.BasicModuleValue) com.alibaba.fastjson.JSON.parseObject(r0.toJSONString(), com.alient.onearch.adapter.pom.BasicModuleValue.class);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0016 */
    @Override // com.alient.onearch.adapter.parser.module.AbsModuleParser
    @NotNull
    public BasicModuleValue parse(@NotNull Node node) {
        k21.i(node, "node");
        JSONObject data = node.getData();
        BasicModuleValue basicModuleValue = null;
        if (data != null) {
            basicModuleValue = (BasicModuleValue) data.toJavaObject(BasicModuleValue.class);
        }
        if (basicModuleValue == null) {
            basicModuleValue = new BasicModuleValue(node);
        }
        if (node.getRawJson() != null) {
            basicModuleValue.setRawJson(node.getRawJson());
        }
        k21.f(basicModuleValue);
        return basicModuleValue;
    }
}
