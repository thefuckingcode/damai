package tb;

import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.v2.common.Node;
import cn.damai.tetris.v2.convertor.ILayerStyleBuilder;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.common.Constants;
import com.youku.arch.v3.data.Constants;

/* compiled from: Taobao */
public class fi implements ILayerStyleBuilder {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.tetris.v2.convertor.ILayerStyleBuilder
    public Node setLayerStyle(BaseSection baseSection, Node node) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1091462423")) {
            return (Node) ipChange.ipc$dispatch("1091462423", new Object[]{this, baseSection, node});
        }
        node.data.put(Constants.LAYOUT_TYPE, (Object) "linear");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Constants.Name.MARGIN_LEFT, (Object) 12);
        jSONObject.put(Constants.Name.MARGIN_RIGHT, (Object) 12);
        node.data.put("layoutParams", (Object) jSONObject);
        return node;
    }
}
