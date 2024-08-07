package com.alient.onearch.adapter.parser.item;

import com.alient.onearch.adapter.pom.BasicItemValue;
import com.taobao.analysis.StageType;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.parser.IParser;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003B\u0007¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/alient/onearch/adapter/parser/item/AbsItemParser;", "Lcom/alient/onearch/adapter/pom/BasicItemValue;", "ELEMENT", "Lcom/youku/arch/v3/core/parser/IParser;", "Lcom/youku/arch/v3/core/Node;", StageType.PARSE, "node", "Ltb/ur2;", "readornNode", "(Lcom/alient/onearch/adapter/pom/BasicItemValue;Lcom/youku/arch/v3/core/Node;)V", "parseElement", "(Lcom/youku/arch/v3/core/Node;)Lcom/alient/onearch/adapter/pom/BasicItemValue;", "<init>", "()V", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public abstract class AbsItemParser<ELEMENT extends BasicItemValue> implements IParser<Node, ELEMENT> {
    private final void readornNode(ELEMENT element, Node node) {
        element.setId(node.getId());
        element.setParent(node.getParent());
        element.setLevel(node.getLevel());
        element.setType(node.getType());
        element.setMore(node.getMore());
        element.setData(node.getData());
        element.setRenders(node.getRenders());
        element.setStyle(node.getStyle());
        element.setLayout(node.getLayout());
        element.setChildren(node.getChildren());
        element.setConfig(node.getConfig());
    }

    @NotNull
    public abstract ELEMENT parse(@NotNull Node node);

    @NotNull
    public ELEMENT parseElement(@NotNull Node node) {
        k21.i(node, "node");
        ELEMENT parse = parse(node);
        readornNode(parse, node);
        return parse;
    }
}
