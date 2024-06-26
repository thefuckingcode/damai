package cn.damai.tetris.component.discover.mvp;

import android.view.View;
import cn.damai.commonbusiness.discover.viewholder.NoteViewHolder;
import cn.damai.commonbusiness.discover.viewholder.OnItemClickListener;
import cn.damai.tetris.component.discover.bean.NoteBean;
import cn.damai.tetris.component.discover.mvp.NoteContract;
import cn.damai.tetris.core.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.vk1;

/* compiled from: Taobao */
public class NoteView extends AbsView<NoteContract.Presenter> implements NoteContract.View<NoteContract.Presenter>, OnItemClickListener<NoteBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final NoteViewHolder mHolder;

    public NoteView(View view) {
        super(view);
        this.mHolder = new NoteViewHolder(view, this);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int] */
    @Override // cn.damai.commonbusiness.discover.viewholder.OnItemClickListener
    public /* synthetic */ void onDnaClick(NoteBean noteBean, int i) {
        vk1.a(this, noteBean, i);
    }

    @Override // cn.damai.tetris.component.discover.mvp.NoteContract.View
    public void setData(NoteBean noteBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1264620947")) {
            ipChange.ipc$dispatch("1264620947", new Object[]{this, noteBean, Integer.valueOf(i)});
            return;
        }
        this.mHolder.a(noteBean, i);
    }

    public void onEditClick(NoteBean noteBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-506342234")) {
            ipChange.ipc$dispatch("-506342234", new Object[]{this, noteBean, Integer.valueOf(i)});
        } else if (this.mHolder.v != null && getPresenter() != null) {
            NoteViewHolder noteViewHolder = this.mHolder;
            ((NoteContract.Presenter) getPresenter()).editClick(this, noteViewHolder.v, noteViewHolder.w);
        }
    }

    public void onItemClick(NoteBean noteBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-536490499")) {
            ipChange.ipc$dispatch("-536490499", new Object[]{this, noteBean, Integer.valueOf(i)});
        } else if (this.mHolder.v != null && getPresenter() != null) {
            NoteViewHolder noteViewHolder = this.mHolder;
            ((NoteContract.Presenter) getPresenter()).itemClick(this, noteViewHolder.v, noteViewHolder.w);
        }
    }
}
