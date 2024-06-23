package cn.damai.search.component.feed;

import android.view.View;
import android.view.ViewGroup;
import cn.damai.commonbusiness.discover.viewholder.NoteViewHolder;
import cn.damai.commonbusiness.discover.viewholder.OnItemClickListener;
import cn.damai.onearch.view.AbsView;
import cn.damai.search.component.feed.ContentContract;
import cn.damai.tetris.component.discover.bean.NoteBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import tb.vk1;
import tb.xs0;

/* compiled from: Taobao */
public class ContentView extends AbsView<IItem<ItemValue>, ContentContract.Model<IItem<ItemValue>>, ContentContract.Presenter<IItem<ItemValue>, ContentContract.Model<IItem<ItemValue>>>> implements ContentContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    private final NoteViewHolder mNoteViewHolder;

    /* compiled from: Taobao */
    public class a implements OnItemClickListener<NoteBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        /* renamed from: a */
        public void onEditClick(NoteBean noteBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-604660130")) {
                ipChange.ipc$dispatch("-604660130", new Object[]{this, noteBean, Integer.valueOf(i)});
            }
        }

        /* renamed from: b */
        public void onItemClick(NoteBean noteBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-634808395")) {
                ipChange.ipc$dispatch("-634808395", new Object[]{this, noteBean, Integer.valueOf(i)});
                return;
            }
            PRESENTER presenter = ContentView.this.presenter;
            if (presenter != null) {
                ((ContentContract.Presenter) presenter).gotoContentActivity(noteBean, i);
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int] */
        @Override // cn.damai.commonbusiness.discover.viewholder.OnItemClickListener
        public /* synthetic */ void onDnaClick(NoteBean noteBean, int i) {
            vk1.a(this, noteBean, i);
        }
    }

    public ContentView(View view) {
        super(view);
        ViewGroup viewGroup = (ViewGroup) view;
        AnonymousClass2 r0 = new NoteViewHolder(xs0.a(), viewGroup, new a()) {
            /* class cn.damai.search.component.feed.ContentView.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.commonbusiness.discover.viewholder.NoteViewHolder
            public void k(View view, NoteBean noteBean, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-289067554")) {
                    ipChange.ipc$dispatch("-289067554", new Object[]{this, view, noteBean, Integer.valueOf(i)});
                    return;
                }
                PRESENTER presenter = ContentView.this.presenter;
                if (presenter != null) {
                    ((ContentContract.Presenter) presenter).exposeContentCard(view, noteBean, i);
                }
            }
        };
        this.mNoteViewHolder = r0;
        viewGroup.addView(r0.itemView);
    }

    @Override // cn.damai.search.component.feed.ContentContract.View
    public void render(NoteBean noteBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1985446066")) {
            ipChange.ipc$dispatch("1985446066", new Object[]{this, noteBean, Integer.valueOf(i)});
        } else if (noteBean != null) {
            this.mNoteViewHolder.a(noteBean, i);
        }
    }
}
