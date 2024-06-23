package tb;

import cn.damai.tetris.component.drama.bean.ProjectShowBean;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.NodeData;
import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.core.mtop.GlobalConfig;
import cn.damai.tetris.v2.common.Node;
import cn.damai.tetris.v2.convertor.IConverter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class mt1 implements IConverter<BaseResponse, BaseSection, GlobalConfig, List<Node>> {
    private static transient /* synthetic */ IpChange $ipChange;

    /* renamed from: a */
    public List<Node> convert(BaseResponse baseResponse, BaseSection baseSection, GlobalConfig globalConfig, qa qaVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "809856769")) {
            return (List) ipChange.ipc$dispatch("809856769", new Object[]{this, baseResponse, baseSection, globalConfig, qaVar});
        }
        NodeData item = baseSection.getItem();
        if (item != null) {
            item.put(ProjectShowBean.REQUEST_FINISH_TIME, (Object) Long.valueOf(baseResponse.requestFinishTime));
            item.put(ProjectShowBean.SERVER_TIME, (Object) Long.valueOf(baseResponse.serverTime));
        }
        return new i12().convert(baseResponse, baseSection, globalConfig, qaVar);
    }
}
