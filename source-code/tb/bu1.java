package tb;

import cn.damai.tetris.component.drama.bean.CategoryItemListInfo;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.NodeData;
import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.core.mtop.GlobalConfig;
import cn.damai.tetris.v2.common.Node;
import cn.damai.tetris.v2.convertor.IConverter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class bu1 implements IConverter<BaseResponse, BaseSection, GlobalConfig, List<Node>> {
    private static transient /* synthetic */ IpChange $ipChange;

    /* renamed from: a */
    public List<Node> convert(BaseResponse baseResponse, BaseSection baseSection, GlobalConfig globalConfig, qa qaVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1315417250")) {
            return (List) ipChange.ipc$dispatch("-1315417250", new Object[]{this, baseResponse, baseSection, globalConfig, qaVar});
        }
        CategoryItemListInfo a = wf.a(baseResponse);
        NodeData item = baseSection.getItem();
        if (item == null) {
            item = new NodeData();
        }
        item.put("itemInfo", (Object) a);
        Node n = qaVar.n(baseSection, globalConfig, item);
        ArrayList arrayList = new ArrayList();
        if (n != null) {
            arrayList.add(n);
        }
        return arrayList;
    }
}
