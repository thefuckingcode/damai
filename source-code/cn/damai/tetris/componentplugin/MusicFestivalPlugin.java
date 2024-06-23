package cn.damai.tetris.componentplugin;

import androidx.annotation.Nullable;
import cn.damai.musicfestival.bean.MusicFestivalRes;
import cn.damai.tetris.core.NodeData;
import cn.damai.tetris.v2.componentplugin.ComponentPageUi;
import cn.damai.tetris.v2.componentplugin.ComponentPlugin;
import cn.damai.tetris.v2.structure.section.ISection;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.cg1;
import tb.s41;

/* compiled from: Taobao */
public class MusicFestivalPlugin extends ComponentPlugin {
    private static transient /* synthetic */ IpChange $ipChange;
    private cg1 mUt = new cg1();

    public MusicFestivalPlugin(ComponentPageUi componentPageUi) {
        super(componentPageUi);
    }

    @Override // cn.damai.tetris.v2.componentplugin.ComponentPlugin
    public boolean onLoadMore() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "756932189")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("756932189", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.tetris.v2.componentplugin.ComponentPlugin
    public boolean onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1681529932")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1681529932", new Object[]{this, Integer.valueOf(i), obj})).booleanValue();
    }

    @Override // cn.damai.tetris.v2.componentplugin.ComponentPlugin
    public boolean onRefresh() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "648904895")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("648904895", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.tetris.v2.componentplugin.ComponentPlugin
    public void onSectionBind(ISection iSection) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2034189523")) {
            ipChange.ipc$dispatch("2034189523", new Object[]{this, iSection});
        } else if (iSection != null) {
            JSONObject item = iSection.getItem();
            if (item != null) {
                MusicFestivalRes musicFestivalRes = (MusicFestivalRes) s41.d(new NodeData(item), MusicFestivalRes.class);
                if (musicFestivalRes != null) {
                    musicFestivalRes.initData();
                }
                iSection.setExtra(musicFestivalRes);
            }
            this.mUt.a(iSection, "category_music", "bottom");
        }
    }

    @Override // cn.damai.tetris.v2.componentplugin.ComponentPlugin
    public void onSectionRemoved(@Nullable ISection iSection) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2009431150")) {
            ipChange.ipc$dispatch("2009431150", new Object[]{this, iSection});
        }
    }
}
