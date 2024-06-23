package cn.damai.tetris.v2.componentplugin;

import cn.damai.tetris.v2.adpater.VBaseViewHolder;
import cn.damai.tetris.v2.structure.section.ISection;
import java.util.List;

/* compiled from: Taobao */
public interface SectionSensitive {
    void sectionBindViewHolder(ISection iSection, VBaseViewHolder vBaseViewHolder);

    void sectionChanged(ISection iSection, boolean z);

    void sectionListChanged(List<ISection> list, boolean z);

    void sectionListClear();
}
