package cn.damai.search.component.feed;

import cn.damai.onearch.view.AbsModel;
import cn.damai.search.component.feed.ContentContract;
import cn.damai.tetris.component.discover.bean.NoteBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import java.util.HashMap;
import tb.s41;

/* compiled from: Taobao */
public class ContentModel extends AbsModel<IItem<ItemValue>, Object> implements ContentContract.Model<IItem<ItemValue>> {
    private static transient /* synthetic */ IpChange $ipChange;
    private static int index = 0;
    private static HashMap<String, Float> sContentId2Ratio = new HashMap<>();
    private NoteBean mBean;

    private float getHwRatio(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1044883212")) {
            return ((Float) ipChange.ipc$dispatch("-1044883212", new Object[]{this, str})).floatValue();
        }
        Float f = sContentId2Ratio.get(str);
        if (f != null) {
            return f.floatValue();
        }
        int i = index;
        float f2 = i % 5 == 0 ? 1.3333334f : 1.0f;
        index = i + 1;
        sContentId2Ratio.put(str, Float.valueOf(f2));
        return f2;
    }

    @Override // cn.damai.search.component.feed.ContentContract.Model
    public NoteBean getNoteBean() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1907706219")) {
            return this.mBean;
        }
        return (NoteBean) ipChange.ipc$dispatch("1907706219", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    @Override // com.alient.onearch.adapter.view.AbsModel
    public void parseModelImpl(IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1565645912")) {
            ipChange.ipc$dispatch("-1565645912", new Object[]{this, iItem});
            return;
        }
        NoteBean noteBean = (NoteBean) s41.d(iItem.getProperty().getData(), NoteBean.class);
        this.mBean = noteBean;
        if (noteBean != null) {
            noteBean.setHwRatio(getHwRatio(noteBean.id));
        }
    }
}
