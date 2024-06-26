package tb;

import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.core.mtop.GlobalConfig;
import cn.damai.tetris.v2.common.Node;
import cn.damai.tetris.v2.convertor.IConverter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class i12 implements IConverter<BaseResponse, BaseSection, GlobalConfig, List<Node>> {
    private static transient /* synthetic */ IpChange $ipChange;

    /* renamed from: a */
    public List<Node> convert(BaseResponse baseResponse, BaseSection baseSection, GlobalConfig globalConfig, qa qaVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-940266358")) {
            return (List) ipChange.ipc$dispatch("-940266358", new Object[]{this, baseResponse, baseSection, globalConfig, qaVar});
        }
        ArrayList arrayList = new ArrayList();
        Node n = qaVar.n(baseSection, globalConfig, baseSection.getItem());
        if (n != null) {
            arrayList.add(n);
        }
        return arrayList;
    }
}
