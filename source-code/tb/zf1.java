package tb;

import android.text.TextUtils;
import cn.damai.tetris.component.drama.bean.CardTitleBean;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.NodeData;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.core.mtop.GlobalConfig;
import cn.damai.tetris.v2.common.Node;
import cn.damai.tetris.v2.convertor.IConverter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class zf1 implements IConverter<BaseResponse, BaseSection, GlobalConfig, List<Node>> {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0065, code lost:
        if (android.text.TextUtils.isEmpty(r2) == false) goto L_0x006a;
     */
    /* renamed from: a */
    public List<Node> convert(BaseResponse baseResponse, BaseSection baseSection, GlobalConfig globalConfig, qa qaVar) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1504091277")) {
            return (List) ipChange.ipc$dispatch("1504091277", new Object[]{this, baseResponse, baseSection, globalConfig, qaVar});
        }
        NodeData item = baseSection.getItem();
        if (item != null) {
            CardTitleBean fromTetrisStyle = CardTitleBean.fromTetrisStyle(baseSection.getStyle());
            item.put("mainTitle", (Object) fromTetrisStyle.title);
            item.put("url", (Object) fromTetrisStyle.url);
            item.put("moreText", (Object) fromTetrisStyle.subTitle);
            String str2 = (globalConfig == null || TextUtils.isEmpty(globalConfig.pageName)) ? "category_music" : globalConfig.pageName;
            TrackInfo trackInfo = baseSection.getTrackInfo();
            if (trackInfo != null) {
                str = trackInfo.getString("spmc");
            }
            str = "hotmusic";
            item.put("spmB", (Object) str2);
            item.put("spmC", (Object) str);
        }
        return new i12().convert(baseResponse, baseSection, globalConfig, qaVar);
    }
}
