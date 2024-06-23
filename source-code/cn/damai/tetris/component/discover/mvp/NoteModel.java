package cn.damai.tetris.component.discover.mvp;

import cn.damai.tetris.component.discover.bean.NoteBean;
import cn.damai.tetris.component.discover.mvp.NoteContract;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.s41;

/* compiled from: Taobao */
public class NoteModel extends AbsModel implements NoteContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;
    private NoteBean bean;

    @Override // cn.damai.tetris.component.discover.mvp.NoteContract.Model
    public NoteBean getBean() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1740605476")) {
            return this.bean;
        }
        return (NoteBean) ipChange.ipc$dispatch("1740605476", new Object[]{this});
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1424972380")) {
            ipChange.ipc$dispatch("-1424972380", new Object[]{this, baseNode});
            return;
        }
        NoteBean noteBean = (NoteBean) s41.d(baseNode.getItem(), NoteBean.class);
        this.bean = noteBean;
        noteBean.pos = baseNode.getOffset();
    }
}
