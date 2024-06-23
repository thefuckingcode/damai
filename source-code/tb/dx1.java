package tb;

import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.v2.common.Node;
import cn.damai.tetris.v2.convertor.ILayerStyleBuilder;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.common.Constants;
import com.youku.arch.v3.data.Constants;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class dx1 implements ILayerStyleBuilder {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.tetris.v2.convertor.ILayerStyleBuilder
    @NotNull
    public Node setLayerStyle(@NotNull BaseSection baseSection, @NotNull Node node) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2131625485")) {
            return (Node) ipChange.ipc$dispatch("-2131625485", new Object[]{this, baseSection, node});
        }
        k21.i(baseSection, "style");
        k21.i(node, "layerNode");
        JSONObject jSONObject = node.data;
        k21.h(jSONObject, "layerNode.data");
        jSONObject.put((Object) Constants.LAYOUT_TYPE, (Object) "linear");
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put((Object) Constants.Name.MARGIN_LEFT, (Object) 9);
        jSONObject2.put((Object) Constants.Name.MARGIN_RIGHT, (Object) 9);
        JSONObject jSONObject3 = node.data;
        k21.h(jSONObject3, "layerNode.data");
        jSONObject3.put((Object) "layoutParams", (Object) jSONObject2);
        return node;
    }
}
