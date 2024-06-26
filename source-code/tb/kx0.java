package tb;

import cn.damai.tetris.component.drama.bean.CardTitleBean;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.core.mtop.GlobalConfig;
import cn.damai.tetris.v2.common.Node;
import cn.damai.tetris.v2.convertor.IConverter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class kx0 implements IConverter<BaseResponse, BaseSection, GlobalConfig, List<Node>> {
    private static transient /* synthetic */ IpChange $ipChange;

    /* renamed from: a */
    public List<Node> convert(BaseResponse baseResponse, BaseSection baseSection, GlobalConfig globalConfig, qa qaVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-565856798")) {
            return (List) ipChange.ipc$dispatch("-565856798", new Object[]{this, baseResponse, baseSection, globalConfig, qaVar});
        }
        if (!(baseSection == null || baseSection.getItem() == null || baseSection.getStyle() == null)) {
            baseSection.getItem().put("mainTitle", (Object) CardTitleBean.fromTetrisStyle(baseSection.getStyle()).title);
        }
        return new i12().convert(baseResponse, baseSection, globalConfig, qaVar);
    }
}
