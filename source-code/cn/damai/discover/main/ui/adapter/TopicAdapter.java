package cn.damai.discover.main.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.app.base.BaseActivity;
import cn.damai.common.bean.RankBean;
import cn.damai.commonbusiness.discover.bean.VoteBean;
import cn.damai.commonbusiness.discover.bean.VoteInfoBean;
import cn.damai.commonbusiness.discover.viewholder.BaseViewHolder;
import cn.damai.commonbusiness.discover.viewholder.NoteViewHolder;
import cn.damai.commonbusiness.discover.viewholder.OnItemClickListener;
import cn.damai.commonbusiness.discover.viewholder.ThemeViewHolder;
import cn.damai.commonbusiness.discover.viewholder.VotePanel;
import cn.damai.commonbusiness.discover.viewholder.VoteViewHolder;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.commonbusiness.search.viewholder.ProjectItemViewHolder;
import cn.damai.commonbusiness.wannasee.listener.OnMultiListClickListener;
import cn.damai.tetris.component.discover.bean.NoteBean;
import cn.damai.tetris.component.discover.bean.ThemeBean;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.f92;
import tb.kk2;
import tb.vk1;
import tb.za;

/* compiled from: Taobao */
public class TopicAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int PIC_RATIO_GROUP = 5;
    private Context a;
    private OnMultiListClickListener b;
    private Exposure c;
    private List d;
    private int e;
    private kk2 f = new kk2();

    /* compiled from: Taobao */
    public interface Exposure {
        void exposureNote(View view, NoteBean noteBean, int i);

        void exposureProject(View view, ProjectItemBean projectItemBean, int i);

        void exposureRank(View view, RankBean rankBean, int i);
    }

    /* compiled from: Taobao */
    public class a implements OnItemClickListener<NoteBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        /* renamed from: a */
        public void onEditClick(NoteBean noteBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-331596925")) {
                ipChange.ipc$dispatch("-331596925", new Object[]{this, noteBean, Integer.valueOf(i)});
            } else if (TopicAdapter.this.b != null) {
                TopicAdapter.this.b.onNoteShareClick(noteBean, i);
            }
        }

        /* renamed from: b */
        public void onItemClick(NoteBean noteBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-361745190")) {
                ipChange.ipc$dispatch("-361745190", new Object[]{this, noteBean, Integer.valueOf(i)});
            } else if (TopicAdapter.this.b != null) {
                TopicAdapter.this.b.onNoteClick(noteBean, i);
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int] */
        @Override // cn.damai.commonbusiness.discover.viewholder.OnItemClickListener
        public /* synthetic */ void onDnaClick(NoteBean noteBean, int i) {
            vk1.a(this, noteBean, i);
        }
    }

    /* compiled from: Taobao */
    public class b implements OnItemClickListener<ThemeBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        /* renamed from: a */
        public void onEditClick(ThemeBean themeBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-267648339")) {
                ipChange.ipc$dispatch("-267648339", new Object[]{this, themeBean, Integer.valueOf(i)});
            }
        }

        /* renamed from: b */
        public void onItemClick(ThemeBean themeBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1202244554")) {
                ipChange.ipc$dispatch("-1202244554", new Object[]{this, themeBean, Integer.valueOf(i)});
            } else if (TopicAdapter.this.b != null) {
                TopicAdapter.this.b.onThemeClick(themeBean, i);
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int] */
        @Override // cn.damai.commonbusiness.discover.viewholder.OnItemClickListener
        public /* synthetic */ void onDnaClick(ThemeBean themeBean, int i) {
            vk1.a(this, themeBean, i);
        }
    }

    /* compiled from: Taobao */
    public class c implements VotePanel.VoteActionListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Context a;
        final /* synthetic */ int b;

        c(Context context, int i) {
            this.a = context;
            this.b = i;
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.VotePanel.VoteActionListener
        @Nullable
        public Activity getActivity() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1214812599")) {
                return (Activity) ipChange.ipc$dispatch("1214812599", new Object[]{this});
            }
            Context context = this.a;
            if (context instanceof Activity) {
                return (Activity) context;
            }
            return null;
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.VotePanel.VoteActionListener
        public void onVoteInfoUpdate(@NonNull VoteInfoBean voteInfoBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1162944455")) {
                ipChange.ipc$dispatch("-1162944455", new Object[]{this, voteInfoBean});
            }
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.VotePanel.VoteActionListener
        public void showActivityLoading(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2093417678")) {
                ipChange.ipc$dispatch("2093417678", new Object[]{this, Boolean.valueOf(z)});
                return;
            }
            Activity activity = getActivity();
            if (activity instanceof BaseActivity) {
                BaseActivity baseActivity = (BaseActivity) activity;
                if (z) {
                    baseActivity.startProgressDialog();
                } else {
                    baseActivity.stopProgressDialog();
                }
            }
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.VotePanel.VoteUtListener
        public void ut4CancelVoteClick(VoteInfoBean voteInfoBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1902225462")) {
                ipChange.ipc$dispatch("-1902225462", new Object[]{this, voteInfoBean});
                return;
            }
            za.j(TopicAdapter.this.f.n(voteInfoBean.id, 1));
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.VotePanel.VoteUtListener
        public void ut4VoteCardExposure(View view, VoteInfoBean voteInfoBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-827194004")) {
                ipChange.ipc$dispatch("-827194004", new Object[]{this, view, voteInfoBean, Integer.valueOf(i)});
                return;
            }
            TopicAdapter.this.f.s(view, voteInfoBean.id, i, this.b);
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.VotePanel.VoteUtListener
        public void ut4VoteClick(VoteInfoBean voteInfoBean, VoteBean voteBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1389829344")) {
                ipChange.ipc$dispatch("1389829344", new Object[]{this, voteInfoBean, voteBean, Integer.valueOf(i)});
                return;
            }
            za.j(TopicAdapter.this.f.x(voteInfoBean.id, voteBean.posInVoteList, this.b));
        }
    }

    /* compiled from: Taobao */
    public static class d implements Exposure {
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // cn.damai.discover.main.ui.adapter.TopicAdapter.Exposure
        public void exposureProject(View view, ProjectItemBean projectItemBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "997775694")) {
                ipChange.ipc$dispatch("997775694", new Object[]{this, view, projectItemBean, Integer.valueOf(i)});
            }
        }

        @Override // cn.damai.discover.main.ui.adapter.TopicAdapter.Exposure
        public void exposureRank(View view, RankBean rankBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1872567166")) {
                ipChange.ipc$dispatch("-1872567166", new Object[]{this, view, rankBean, Integer.valueOf(i)});
            }
        }
    }

    public TopicAdapter(Context context, int i, OnMultiListClickListener onMultiListClickListener) {
        this.a = context;
        this.b = onMultiListClickListener;
        this.e = i;
    }

    private VotePanel.VoteActionListener d(Context context, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-948733946")) {
            return new c(context, i);
        }
        return (VotePanel.VoteActionListener) ipChange.ipc$dispatch("-948733946", new Object[]{this, context, Integer.valueOf(i)});
    }

    private String e(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "400728928")) {
            return (String) ipChange.ipc$dispatch("400728928", new Object[]{this, obj});
        } else if (obj instanceof Integer) {
            return obj.toString();
        } else {
            return obj instanceof String ? (String) obj : "0";
        }
    }

    public void c(List list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "815907223")) {
            ipChange.ipc$dispatch("815907223", new Object[]{this, list});
        } else if (!f92.d(list)) {
            if (this.d == null) {
                this.d = new ArrayList();
            }
            int size = this.d.size();
            this.d.addAll(list);
            notifyItemRangeInserted(size, list.size());
        }
    }

    public void f(Exposure exposure) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1161980234")) {
            ipChange.ipc$dispatch("1161980234", new Object[]{this, exposure});
            return;
        }
        this.c = exposure;
    }

    public void g(List list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1775053642")) {
            ipChange.ipc$dispatch("-1775053642", new Object[]{this, list});
            return;
        }
        this.d = list;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2006251982")) {
            return ((Integer) ipChange.ipc$dispatch("-2006251982", new Object[]{this})).intValue();
        }
        List list = this.d;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-195717159")) {
            return ((Integer) ipChange.ipc$dispatch("-195717159", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        JSONObject jSONObject = (JSONObject) this.d.get(i);
        if (jSONObject.containsKey("type")) {
            String e2 = e(jSONObject.get("type"));
            if ("1".equals(e2)) {
                return 1;
            }
            if ("5".equals(e2)) {
                return 5;
            }
        }
        return super.getItemViewType(i);
    }

    public void h(kk2 kk2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-203186886")) {
            ipChange.ipc$dispatch("-203186886", new Object[]{this, kk2});
            return;
        }
        this.f = kk2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1541171321")) {
            ipChange.ipc$dispatch("-1541171321", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        JSONObject jSONObject = (JSONObject) this.d.get(i);
        if ((viewHolder instanceof BaseViewHolder) && jSONObject.containsKey("type")) {
            String e2 = e(jSONObject.get("type"));
            if ("1".equals(e2)) {
                NoteBean noteBean = (NoteBean) jSONObject.toJavaObject(NoteBean.class);
                if (noteBean != null) {
                    if (i % 5 == 0) {
                        noteBean.setHwRatio(1.3333334f);
                    } else {
                        noteBean.setHwRatio(1.0f);
                    }
                }
                ((BaseViewHolder) viewHolder).a(noteBean, i);
                Exposure exposure = this.c;
                if (exposure != null) {
                    exposure.exposureNote(viewHolder.itemView, noteBean, i);
                }
            } else if ("5".equals(e2)) {
                ((BaseViewHolder) viewHolder).a((VoteInfoBean) jSONObject.toJavaObject(VoteInfoBean.class), i);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-198895025")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("-198895025", new Object[]{this, viewGroup, Integer.valueOf(i)});
        } else if (i == 1) {
            return new NoteViewHolder(this.a, viewGroup, new a());
        } else {
            if (i == 2) {
                return new ThemeViewHolder(this.a, viewGroup, new b());
            }
            if (i != 5) {
                Context context = this.a;
                return new ProjectItemViewHolder(context, LayoutInflater.from(context));
            }
            Context context2 = this.a;
            return new VoteViewHolder(context2, viewGroup, d(context2, this.e));
        }
    }
}
