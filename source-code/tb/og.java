package tb;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import cn.damai.musicfestival.bean.FeedInfo;
import cn.damai.tetris.component.drama.bean.CardTitleBean;
import cn.damai.tetris.core.BaseLayer;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.NodeData;
import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.v2.convertor.ChainPreProcess;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
public class og implements ChainPreProcess {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.tetris.v2.convertor.ChainPreProcess
    public void process(@NonNull BaseResponse baseResponse) {
        Boolean bool;
        BaseSection baseSection;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "555811360")) {
            ipChange.ipc$dispatch("555811360", new Object[]{this, baseResponse});
            return;
        }
        ArrayList<BaseLayer> arrayList = baseResponse.layers;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<BaseLayer> it = arrayList.iterator();
            while (it.hasNext()) {
                BaseLayer next = it.next();
                List<BaseSection> sections = next.getSections();
                if (sections != null && sections.size() > 0) {
                    int size = sections.size();
                    BaseSection baseSection2 = null;
                    int i = -1;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            break;
                        }
                        baseSection = sections.get(i2);
                        if (baseSection != null && (TextUtils.equals(wj2.DISCOVER_FEED_V2_COMPONENT_ID, baseSection.getComponentId()) || TextUtils.equals(wj2.CIRCLE_FEED_COMPONENT_ID, baseSection.getComponentId()))) {
                            i = i2;
                            baseSection2 = baseSection;
                        } else {
                            i2++;
                        }
                    }
                    i = i2;
                    baseSection2 = baseSection;
                    if (baseSection2 != null) {
                        NodeData item = baseSection2.getItem();
                        boolean booleanValue = (item == null || (bool = item.getBoolean(wj2.HAS_NEXT)) == null) ? false : bool.booleanValue();
                        String layerId = next.getLayerId();
                        CardTitleBean fromTetrisStyle = CardTitleBean.fromTetrisStyle(baseSection2.getStyle());
                        FeedInfo feedInfo = new FeedInfo();
                        feedInfo.hasNext = booleanValue;
                        feedInfo.targetLayerId = layerId;
                        feedInfo.targetSectionId = baseSection2.getSectionId();
                        feedInfo.feedTitle = fromTetrisStyle.title;
                        sections.add(i, BaseSection.obj2Section(wj2.DISCOVER_FEED_V2_COMPONENT_PLUGIN_ID, JSON.parseObject(JSON.toJSONString(feedInfo)), baseSection2.getTrackInfo()));
                    }
                }
            }
        }
    }
}
