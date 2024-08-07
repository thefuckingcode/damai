package com.youku.arch.v3.core;

import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.ui.component.richtext.node.RichTextNode;
import com.youku.arch.v3.ValueObject;
import com.youku.arch.v3.style.Style;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.tn;
import tb.wi1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u001e\n\u0002\u0010!\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0016\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\bK\u0010LB\u0013\b\u0016\u0012\b\u0010M\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\bK\u0010JJ\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u001c\u0010\u0007\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0000H\u0002J\u001c\u0010\t\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\bH\u0002J\u0013\u0010\t\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010\r\u001a\u00020\fH\u0016R\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\u00020\f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\u00020\f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR$\u0010\u001e\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010$\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R\"\u0010'\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R*\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010-8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R$\u00104\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b4\u0010\u001f\u001a\u0004\b5\u0010!\"\u0004\b6\u0010#R$\u00107\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b7\u0010\u001f\u001a\u0004\b8\u0010!\"\u0004\b9\u0010#R*\u0010<\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010:8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b<\u0010/\u001a\u0004\b=\u00101\"\u0004\b>\u00103R$\u0010?\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR$\u0010E\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010J¨\u0006N"}, d2 = {"Lcom/youku/arch/v3/core/Node;", "Lcom/youku/arch/v3/ValueObject;", "Lcom/youku/arch/v3/style/Style;", "a", "b", "", "equalStyle", "equalHeader", "Lcom/alibaba/fastjson/JSONObject;", "equals", "", "other", "", "hashCode", "", "id", "J", "getId", "()J", "setId", "(J)V", "level", "I", "getLevel", "()I", "setLevel", "(I)V", "type", "getType", "setType", "data", "Lcom/alibaba/fastjson/JSONObject;", "getData", "()Lcom/alibaba/fastjson/JSONObject;", "setData", "(Lcom/alibaba/fastjson/JSONObject;)V", "rawJson", "getRawJson", "setRawJson", "more", "Z", "getMore", "()Z", "setMore", "(Z)V", "", RichTextNode.CHILDREN, "Ljava/util/List;", "getChildren", "()Ljava/util/List;", "setChildren", "(Ljava/util/List;)V", "layout", "getLayout", "setLayout", Constants.CONFIG, "getConfig", "setConfig", "", "Lcom/youku/arch/v3/core/Render;", "renders", "getRenders", "setRenders", "style", "Lcom/youku/arch/v3/style/Style;", "getStyle", "()Lcom/youku/arch/v3/style/Style;", "setStyle", "(Lcom/youku/arch/v3/style/Style;)V", "parent", "Lcom/youku/arch/v3/core/Node;", "getParent", "()Lcom/youku/arch/v3/core/Node;", "setParent", "(Lcom/youku/arch/v3/core/Node;)V", "<init>", "()V", "node", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public class Node implements ValueObject {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private List<Node> children;
    @Nullable
    private JSONObject config;
    @Nullable
    private JSONObject data;
    private long id;
    @Nullable
    private JSONObject layout;
    private int level;
    private boolean more;
    @Nullable
    private Node parent;
    @Nullable
    private JSONObject rawJson;
    @Nullable
    private List<? extends Render> renders;
    @Nullable
    private Style style;
    private int type;

    public Node() {
    }

    private final boolean equalHeader(Node node, Node node2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-412567157")) {
            return ((Boolean) ipChange.ipc$dispatch("-412567157", new Object[]{this, node, node2})).booleanValue();
        } else if (node == null && node2 == null) {
            return true;
        } else {
            if (node == null || node2 == null) {
                return false;
            }
            return k21.d(node, node2);
        }
    }

    private final boolean equalStyle(Style style2, Style style3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1757841705")) {
            return ((Boolean) ipChange.ipc$dispatch("1757841705", new Object[]{this, style2, style3})).booleanValue();
        } else if (style2 == null && style3 == null) {
            return true;
        } else {
            if (style2 == null || style3 == null) {
                return false;
            }
            return k21.d(style2, style3);
        }
    }

    public boolean equals(@Nullable Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "85817027")) {
            return ((Boolean) ipChange.ipc$dispatch("85817027", new Object[]{this, obj})).booleanValue();
        } else if (!(obj instanceof Node)) {
            return super.equals(obj);
        } else {
            Node node = (Node) obj;
            if (this.id == node.id && this.level == node.level && this.type == node.type && this.more == node.more && equalStyle(this.style, node.style) && equals(this.layout, node.layout) && equals(this.data, node.data)) {
                return true;
            }
            return false;
        }
    }

    @Nullable
    public final List<Node> getChildren() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1897699380")) {
            return this.children;
        }
        return (List) ipChange.ipc$dispatch("1897699380", new Object[]{this});
    }

    @Nullable
    public final JSONObject getConfig() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "315022320")) {
            return this.config;
        }
        return (JSONObject) ipChange.ipc$dispatch("315022320", new Object[]{this});
    }

    @Nullable
    public final JSONObject getData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-49796664")) {
            return this.data;
        }
        return (JSONObject) ipChange.ipc$dispatch("-49796664", new Object[]{this});
    }

    public final long getId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-145661237")) {
            return this.id;
        }
        return ((Long) ipChange.ipc$dispatch("-145661237", new Object[]{this})).longValue();
    }

    @Nullable
    public final JSONObject getLayout() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "583736072")) {
            return this.layout;
        }
        return (JSONObject) ipChange.ipc$dispatch("583736072", new Object[]{this});
    }

    public final int getLevel() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1661404697")) {
            return this.level;
        }
        return ((Integer) ipChange.ipc$dispatch("-1661404697", new Object[]{this})).intValue();
    }

    public final boolean getMore() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1393536801")) {
            return this.more;
        }
        return ((Boolean) ipChange.ipc$dispatch("1393536801", new Object[]{this})).booleanValue();
    }

    @Nullable
    public final Node getParent() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1812125940")) {
            return this.parent;
        }
        return (Node) ipChange.ipc$dispatch("1812125940", new Object[]{this});
    }

    @Nullable
    public final JSONObject getRawJson() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1437062952")) {
            return this.rawJson;
        }
        return (JSONObject) ipChange.ipc$dispatch("1437062952", new Object[]{this});
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: java.util.List<? extends com.youku.arch.v3.core.Render>, java.util.List<com.youku.arch.v3.core.Render> */
    @Nullable
    public final List<Render> getRenders() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "594591852")) {
            return this.renders;
        }
        return (List) ipChange.ipc$dispatch("594591852", new Object[]{this});
    }

    @Nullable
    public final Style getStyle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-769085646")) {
            return this.style;
        }
        return (Style) ipChange.ipc$dispatch("-769085646", new Object[]{this});
    }

    public final int getType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-699427573")) {
            return this.type;
        }
        return ((Integer) ipChange.ipc$dispatch("-699427573", new Object[]{this})).intValue();
    }

    public int hashCode() {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "377311354")) {
            return ((Integer) ipChange.ipc$dispatch("377311354", new Object[]{this})).intValue();
        }
        int a = ((((((tn.a(this.id) * 31) + this.level) * 31) + this.type) * 31) + wi1.a(this.more)) * 31;
        Style style2 = this.style;
        int hashCode = (a + (style2 == null ? 0 : style2.hashCode())) * 31;
        JSONObject jSONObject = this.layout;
        int hashCode2 = (hashCode + (jSONObject == null ? 0 : jSONObject.hashCode())) * 31;
        JSONObject jSONObject2 = this.data;
        if (jSONObject2 != null) {
            i = jSONObject2.hashCode();
        }
        return hashCode2 + i;
    }

    public final void setChildren(@Nullable List<Node> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1790406632")) {
            ipChange.ipc$dispatch("-1790406632", new Object[]{this, list});
            return;
        }
        this.children = list;
    }

    public final void setConfig(@Nullable JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-457883092")) {
            ipChange.ipc$dispatch("-457883092", new Object[]{this, jSONObject});
            return;
        }
        this.config = jSONObject;
    }

    public final void setData(@Nullable JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1037712812")) {
            ipChange.ipc$dispatch("-1037712812", new Object[]{this, jSONObject});
            return;
        }
        this.data = jSONObject;
    }

    public final void setId(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-435117351")) {
            ipChange.ipc$dispatch("-435117351", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.id = j;
    }

    public final void setLayout(@Nullable JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-717691372")) {
            ipChange.ipc$dispatch("-717691372", new Object[]{this, jSONObject});
            return;
        }
        this.layout = jSONObject;
    }

    public final void setLevel(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1585084419")) {
            ipChange.ipc$dispatch("1585084419", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.level = i;
    }

    public final void setMore(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "161433699")) {
            ipChange.ipc$dispatch("161433699", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.more = z;
    }

    public final void setParent(@Nullable Node node) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1515912064")) {
            ipChange.ipc$dispatch("1515912064", new Object[]{this, node});
            return;
        }
        this.parent = node;
    }

    public final void setRawJson(@Nullable JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1879389020")) {
            ipChange.ipc$dispatch("1879389020", new Object[]{this, jSONObject});
            return;
        }
        this.rawJson = jSONObject;
    }

    public final void setRenders(@Nullable List<? extends Render> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "354425208")) {
            ipChange.ipc$dispatch("354425208", new Object[]{this, list});
            return;
        }
        this.renders = list;
    }

    public final void setStyle(@Nullable Style style2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1060244856")) {
            ipChange.ipc$dispatch("-1060244856", new Object[]{this, style2});
            return;
        }
        this.style = style2;
    }

    public final void setType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-295968265")) {
            ipChange.ipc$dispatch("-295968265", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.type = i;
    }

    public Node(@Nullable Node node) {
        if (node != null) {
            setId(node.getId());
            setLevel(node.getLevel());
            setType(node.getType());
            setMore(node.getMore());
            setStyle(node.getStyle());
            setLayout(node.getLayout());
            setChildren(node.getChildren());
            setRawJson(node.getRawJson());
            setConfig(node.getConfig());
        }
    }

    private final boolean equals(JSONObject jSONObject, JSONObject jSONObject2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2056244505")) {
            return ((Boolean) ipChange.ipc$dispatch("-2056244505", new Object[]{this, jSONObject, jSONObject2})).booleanValue();
        } else if (jSONObject == null && jSONObject2 == null) {
            return true;
        } else {
            if (jSONObject == null || jSONObject2 == null) {
                return false;
            }
            return k21.d(jSONObject.toString(), jSONObject2.toString());
        }
    }
}
