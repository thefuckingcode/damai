package cn.damai.search.ui.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.discover.viewholder.NoteViewHolder;
import cn.damai.commonbusiness.discover.viewholder.OnItemClickListener;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.search.ui.viewholder.WaterFlowRecommendGoodsCardViewHolder;
import cn.damai.tetris.component.discover.bean.NoteBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.c62;
import tb.gr;
import tb.vk1;
import tb.xf2;

/* compiled from: Taobao */
public class WaterFlowAdapter extends RecyclerView.Adapter {
    private static transient /* synthetic */ IpChange $ipChange;
    private List a;
    private Context b;
    private int c;
    private String d;
    private String e;
    private OnItemClickListener<NoteBean> f = new a();

    /* compiled from: Taobao */
    public class a implements OnItemClickListener<NoteBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        /* renamed from: a */
        public void onEditClick(NoteBean noteBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-476996268")) {
                ipChange.ipc$dispatch("-476996268", new Object[]{this, noteBean, Integer.valueOf(i)});
            }
        }

        /* renamed from: b */
        public void onItemClick(NoteBean noteBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-507144533")) {
                ipChange.ipc$dispatch("-507144533", new Object[]{this, noteBean, Integer.valueOf(i)});
                return;
            }
            c.e().x(c62.C().u(WaterFlowAdapter.this.d, "", noteBean.id, WaterFlowAdapter.this.c, i, ""));
            Bundle bundle = new Bundle();
            bundle.putString("contentId", noteBean.id);
            bundle.putFloat("picWhRatio", noteBean.localPicWhRatio);
            DMNav.from(WaterFlowAdapter.this.b).withExtras(bundle).toUri(NavUri.b(gr.DISCOVER_CONTENT_DETAIL));
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int] */
        @Override // cn.damai.commonbusiness.discover.viewholder.OnItemClickListener
        public /* synthetic */ void onDnaClick(NoteBean noteBean, int i) {
            vk1.a(this, noteBean, i);
        }
    }

    public WaterFlowAdapter(Context context, List list) {
        this.a = list;
        this.b = context;
    }

    public void d(String str, int i, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "191917247")) {
            ipChange.ipc$dispatch("191917247", new Object[]{this, str, Integer.valueOf(i), str2});
            return;
        }
        this.c = i;
        this.d = str;
        this.e = str2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "47857283")) {
            return xf2.e(this.a);
        }
        return ((Integer) ipChange.ipc$dispatch("47857283", new Object[]{this})).intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1193394262")) {
            return (xf2.e(this.a) != 0 && (this.a.get(i) instanceof NoteBean)) ? 1 : 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-1193394262", new Object[]{this, Integer.valueOf(i)})).intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-737888106")) {
            ipChange.ipc$dispatch("-737888106", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        Object obj = this.a.get(i);
        if ((viewHolder instanceof NoteViewHolder) && (obj instanceof NoteBean)) {
            NoteBean noteBean = (NoteBean) obj;
            ((NoteViewHolder) viewHolder).a(noteBean, i);
            if (noteBean != null) {
                c62.C().J(viewHolder.itemView, "", this.e, noteBean.content, "", noteBean.id, i);
            }
        } else if ((viewHolder instanceof WaterFlowRecommendGoodsCardViewHolder) && (obj instanceof ProjectItemBean)) {
            ProjectItemBean projectItemBean = (ProjectItemBean) obj;
            ((WaterFlowRecommendGoodsCardViewHolder) viewHolder).f(projectItemBean, this.d, this.c, i);
            if (projectItemBean != null) {
                c62.C().J(viewHolder.itemView, projectItemBean.id, this.e, projectItemBean.name, projectItemBean.alg, "", i);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-757663712")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("-757663712", new Object[]{this, viewGroup, Integer.valueOf(i)});
        } else if (i != 1) {
            return new WaterFlowRecommendGoodsCardViewHolder(viewGroup.getContext());
        } else {
            return new NoteViewHolder(this.b, viewGroup, this.f);
        }
    }
}
