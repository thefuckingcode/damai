package com.alient.onearch.adapter.parser.model;

import com.alibaba.fastjson.JSONObject;
import com.alient.onearch.adapter.pom.BasicModelValue;
import com.taobao.analysis.StageType;
import com.youku.arch.v3.core.Node;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\b"}, d2 = {"Lcom/alient/onearch/adapter/parser/model/BasicModelParser;", "Lcom/alient/onearch/adapter/parser/model/AbsModelParser;", "Lcom/alient/onearch/adapter/pom/BasicModelValue;", "Lcom/youku/arch/v3/core/Node;", "node", StageType.PARSE, "<init>", "()V", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class BasicModelParser extends AbsModelParser<BasicModelValue> {
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0029, code lost:
        if (com.youku.middlewareservice.provider.info.AppInfoProviderProxy.isDebuggable() != false) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002c, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0022, code lost:
        r1 = (com.alient.onearch.adapter.pom.BasicModelValue) com.alibaba.fastjson.JSON.parseObject(r0.toJSONString(), com.alient.onearch.adapter.pom.BasicModelValue.class);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0016 */
    @Override // com.alient.onearch.adapter.parser.model.AbsModelParser
    @NotNull
    public BasicModelValue parse(@NotNull Node node) {
        k21.i(node, "node");
        JSONObject data = node.getData();
        BasicModelValue basicModelValue = null;
        if (data != null) {
            basicModelValue = (BasicModelValue) data.toJavaObject(BasicModelValue.class);
        }
        if (basicModelValue == null) {
            basicModelValue = new BasicModelValue(node);
        }
        if (node.getRawJson() != null) {
            basicModelValue.setRawJson(node.getRawJson());
        }
        k21.f(basicModelValue);
        return basicModelValue;
    }
}
