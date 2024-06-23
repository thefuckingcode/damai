package cn.damai.tetris.component.discover.mvp;

import cn.damai.tetris.component.discover.bean.NoteBean;
import cn.damai.tetris.component.discover.mvp.BigNoteContract;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.s41;

/* compiled from: Taobao */
public class BigNoteModel extends AbsModel implements BigNoteContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;
    private NoteBean bean;

    @Override // cn.damai.tetris.component.discover.mvp.BigNoteContract.Model
    public NoteBean getBean() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-64987186")) {
            return this.bean;
        }
        return (NoteBean) ipChange.ipc$dispatch("-64987186", new Object[]{this});
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1368084678")) {
            ipChange.ipc$dispatch("-1368084678", new Object[]{this, baseNode});
            return;
        }
        NoteBean noteBean = (NoteBean) s41.d(baseNode.getItem(), NoteBean.class);
        this.bean = noteBean;
        noteBean.pos = baseNode.getOffset();
    }
}
