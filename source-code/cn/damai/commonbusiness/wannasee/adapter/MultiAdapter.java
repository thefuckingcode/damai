package cn.damai.commonbusiness.wannasee.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.baseview.EmptyViewHolder;
import cn.damai.common.bean.RankBean;
import cn.damai.commonbusiness.discover.viewholder.BaseViewHolder;
import cn.damai.commonbusiness.discover.viewholder.NoteViewHolder;
import cn.damai.commonbusiness.discover.viewholder.OnItemClickListener;
import cn.damai.commonbusiness.discover.viewholder.RankViewHolder;
import cn.damai.commonbusiness.discover.viewholder.ThemeViewHolder;
import cn.damai.commonbusiness.scriptmurder.bean.ScriptBean;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.commonbusiness.search.viewholder.ProjectItemViewHolder;
import cn.damai.commonbusiness.wannasee.bean.RecommendProjects;
import cn.damai.commonbusiness.wannasee.listener.OnMultiListClickListener;
import cn.damai.commonbusiness.wannasee.viewholder.WantSeeProjectViewHolder;
import cn.damai.commonbusiness.wannasee.viewholder.WantSeeRecommendViewHolder;
import cn.damai.tetris.component.discover.bean.Extra;
import cn.damai.tetris.component.discover.bean.NoteBean;
import cn.damai.tetris.component.discover.bean.ThemeBean;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.bricks.gaiaxholder.NativeGaiaXViewHolder;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.gaiax.api.data.EventParams;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import tb.b52;
import tb.f92;
import tb.n42;
import tb.s41;
import tb.ur2;
import tb.vk1;
import tb.wf1;
import tb.xs0;

/* compiled from: Taobao */
public class MultiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int PIC_RATIO_GROUP = 5;
    private Context a;
    private OnMultiListClickListener b;
    private View.OnLongClickListener c;
    private Exposure d;
    private List e;
    private OnItemBindListener<JSONObject> f;
    private final boolean g;

    /* compiled from: Taobao */
    public interface Exposure {
        void exposureNote(View view, NoteBean noteBean, int i);

        void exposureProject(View view, ProjectItemBean projectItemBean, int i);

        void exposureRank(View view, RankBean rankBean, int i);

        void exposureRecommend(View view, RecommendProjects recommendProjects, int i);
    }

    /* compiled from: Taobao */
    public class a implements OnItemClickListener<NoteBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        /* renamed from: a */
        public void onEditClick(NoteBean noteBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1125932987")) {
                ipChange.ipc$dispatch("1125932987", new Object[]{this, noteBean, Integer.valueOf(i)});
            } else if (MultiAdapter.this.b != null) {
                MultiAdapter.this.b.onNoteShareClick(noteBean, i);
            }
        }

        /* renamed from: b */
        public void onItemClick(NoteBean noteBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1095784722")) {
                ipChange.ipc$dispatch("1095784722", new Object[]{this, noteBean, Integer.valueOf(i)});
            } else if (MultiAdapter.this.b != null) {
                MultiAdapter.this.b.onNoteClick(noteBean, i);
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
            if (AndroidInstantRuntime.support(ipChange, "1966105973")) {
                ipChange.ipc$dispatch("1966105973", new Object[]{this, themeBean, Integer.valueOf(i)});
            }
        }

        /* renamed from: b */
        public void onItemClick(ThemeBean themeBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1031509758")) {
                ipChange.ipc$dispatch("1031509758", new Object[]{this, themeBean, Integer.valueOf(i)});
            } else if (MultiAdapter.this.b != null) {
                MultiAdapter.this.b.onThemeClick(themeBean, i);
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int] */
        @Override // cn.damai.commonbusiness.discover.viewholder.OnItemClickListener
        public /* synthetic */ void onDnaClick(ThemeBean themeBean, int i) {
            vk1.a(this, themeBean, i);
        }
    }

    /* compiled from: Taobao */
    public class c implements OnItemClickListener<RankBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        /* renamed from: a */
        public void onEditClick(RankBean rankBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-52142381")) {
                ipChange.ipc$dispatch("-52142381", new Object[]{this, rankBean, Integer.valueOf(i)});
            }
        }

        /* renamed from: b */
        public void onItemClick(RankBean rankBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1723264732")) {
                ipChange.ipc$dispatch("1723264732", new Object[]{this, rankBean, Integer.valueOf(i)});
            } else if (MultiAdapter.this.b != null) {
                MultiAdapter.this.b.onRankClick(rankBean, i);
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int] */
        @Override // cn.damai.commonbusiness.discover.viewholder.OnItemClickListener
        public /* synthetic */ void onDnaClick(RankBean rankBean, int i) {
            vk1.a(this, rankBean, i);
        }
    }

    /* compiled from: Taobao */
    public class d extends b52 {
        private static transient /* synthetic */ IpChange $ipChange;

        d(Context context) {
            super(context);
        }

        @Override // tb.b52, tb.yg1
        public void e(@NonNull EventParams eventParams, @NonNull JSONObject jSONObject, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-793100689")) {
                ipChange.ipc$dispatch("-793100689", new Object[]{this, eventParams, jSONObject, Integer.valueOf(i)});
                return;
            }
            super.e(eventParams, jSONObject, i);
            if (MultiAdapter.this.f != null) {
                MultiAdapter.this.f.onItemClick(jSONObject, i);
            }
        }

        @Override // tb.b52, tb.yg1
        public void f(@NonNull View view, @NonNull JSONObject jSONObject, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1263858355")) {
                ipChange.ipc$dispatch("1263858355", new Object[]{this, view, jSONObject, Integer.valueOf(i)});
                return;
            }
            super.f(view, jSONObject, i);
            if (MultiAdapter.this.f != null) {
                MultiAdapter.this.f.exposeItem(view, jSONObject, i);
            }
        }
    }

    /* compiled from: Taobao */
    public class e implements Function1<RecommendProjects, ur2> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ int a;

        e(int i) {
            this.a = i;
        }

        /* renamed from: a */
        public ur2 invoke(RecommendProjects recommendProjects) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1289430807")) {
                return (ur2) ipChange.ipc$dispatch("-1289430807", new Object[]{this, recommendProjects});
            }
            try {
                MultiAdapter.this.e.set(this.a, recommendProjects);
                MultiAdapter.this.notifyItemChanged(this.a);
                return null;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    /* compiled from: Taobao */
    public static class f implements Exposure {
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // cn.damai.commonbusiness.wannasee.adapter.MultiAdapter.Exposure
        public void exposureProject(View view, ProjectItemBean projectItemBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2070832518")) {
                ipChange.ipc$dispatch("2070832518", new Object[]{this, view, projectItemBean, Integer.valueOf(i)});
            }
        }

        @Override // cn.damai.commonbusiness.wannasee.adapter.MultiAdapter.Exposure
        public void exposureRank(View view, RankBean rankBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2023672138")) {
                ipChange.ipc$dispatch("2023672138", new Object[]{this, view, rankBean, Integer.valueOf(i)});
            }
        }

        @Override // cn.damai.commonbusiness.wannasee.adapter.MultiAdapter.Exposure
        public void exposureRecommend(View view, RecommendProjects recommendProjects, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1513164655")) {
                ipChange.ipc$dispatch("1513164655", new Object[]{this, view, recommendProjects, Integer.valueOf(i)});
            }
        }
    }

    /* compiled from: Taobao */
    public class g implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private ProjectItemBean a;
        private int b;

        public g(ProjectItemBean projectItemBean, int i) {
            this.a = projectItemBean;
            this.b = i;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-208780595")) {
                ipChange.ipc$dispatch("-208780595", new Object[]{this, view});
            } else if (MultiAdapter.this.b != null && this.a != null) {
                MultiAdapter.this.b.onProjectClick(this.a, this.b);
            }
        }
    }

    public MultiAdapter(Context context, OnMultiListClickListener onMultiListClickListener) {
        this(context, onMultiListClickListener, false);
    }

    private Function4<Integer, Object, Integer, View, ur2> g() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1259031011")) {
            return new wf1(this);
        }
        return (Function4) ipChange.ipc$dispatch("1259031011", new Object[]{this});
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ur2 h(Integer num, Object obj, Integer num2, View view) {
        Exposure exposure;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-338639210")) {
            return (ur2) ipChange.ipc$dispatch("-338639210", new Object[]{this, num, obj, num2, view});
        }
        if (this.b != null && (obj instanceof RecommendProjects)) {
            if (num.intValue() == 1) {
                this.b.onRecommendRefreshClick((RecommendProjects) obj, num2.intValue());
            } else if (num.intValue() == 3) {
                this.b.onRecommendFollowClick((RecommendProjects) obj, num2.intValue());
            } else if (num.intValue() == 2) {
                this.b.onRecommendClick((RecommendProjects) obj, num2.intValue());
            } else if (num.intValue() == 4) {
                this.b.onRecommendFollowSuccessClick((RecommendProjects) obj, num2.intValue());
            } else if (num.intValue() == 5 && (exposure = this.d) != null) {
                exposure.exposureRecommend(view, (RecommendProjects) obj, num2.intValue());
            }
        }
        return null;
    }

    public void e(List list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-310731169")) {
            ipChange.ipc$dispatch("-310731169", new Object[]{this, list});
        } else if (!f92.d(list)) {
            if (this.e == null) {
                this.e = new ArrayList();
            }
            int size = this.e.size();
            this.e.addAll(list);
            notifyItemRangeInserted(size, list.size());
        }
    }

    public List f() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1193817074")) {
            return this.e;
        }
        return (List) ipChange.ipc$dispatch("-1193817074", new Object[]{this});
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1501320810")) {
            return ((Integer) ipChange.ipc$dispatch("1501320810", new Object[]{this})).intValue();
        }
        List list = this.e;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1062472721")) {
            return ((Integer) ipChange.ipc$dispatch("1062472721", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        Class<?> cls = this.e.get(i).getClass();
        if (cls == ThemeBean.class) {
            return 2;
        }
        if (cls == NoteBean.class) {
            return 1;
        }
        if (cls == ProjectItemBean.class) {
            return 3;
        }
        if (cls == RankBean.class) {
            return 4;
        }
        if (cls == ScriptBean.class) {
            return 5;
        }
        if (cls == RecommendProjects.class) {
            return 6;
        }
        return super.getItemViewType(i);
    }

    public void i(Exposure exposure) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-327551416")) {
            ipChange.ipc$dispatch("-327551416", new Object[]{this, exposure});
            return;
        }
        this.d = exposure;
    }

    public void j(List list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1393275262")) {
            ipChange.ipc$dispatch("1393275262", new Object[]{this, list});
            return;
        }
        this.e = list;
        notifyDataSetChanged();
    }

    public void k(View.OnLongClickListener onLongClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1954486774")) {
            ipChange.ipc$dispatch("1954486774", new Object[]{this, onLongClickListener});
            return;
        }
        this.c = onLongClickListener;
    }

    public void l(OnItemBindListener<JSONObject> onItemBindListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-346261318")) {
            ipChange.ipc$dispatch("-346261318", new Object[]{this, onItemBindListener});
            return;
        }
        this.f = onItemBindListener;
    }

    public void m(List list, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1294316525")) {
            ipChange.ipc$dispatch("1294316525", new Object[]{this, list, Boolean.valueOf(z)});
        } else if (z) {
            j(list);
        } else {
            e(list);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, @SuppressLint({"RecyclerView"}) int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "886359119")) {
            ipChange.ipc$dispatch("886359119", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        Object obj = this.e.get(i);
        if (viewHolder instanceof BaseViewHolder) {
            if (obj instanceof Extra) {
                Extra extra = (Extra) obj;
                if (i % 5 == 0) {
                    extra.setHwRatio(1.3333334f);
                } else {
                    extra.setHwRatio(1.0f);
                }
            }
            ((BaseViewHolder) viewHolder).a(obj, i);
        } else if (viewHolder instanceof ProjectItemViewHolder) {
            ProjectItemBean projectItemBean = (ProjectItemBean) obj;
            projectItemBean.pos = i;
            ((ProjectItemViewHolder) viewHolder).k(projectItemBean);
            viewHolder.itemView.setOnClickListener(new g(projectItemBean, i));
        } else if (obj instanceof ScriptBean) {
            ((NativeGaiaXViewHolder) viewHolder).c(s41.c(s41.e((ScriptBean) obj)), (float) DisplayMetrics.getwidthPixels(n42.b(xs0.a())), i);
        } else if (viewHolder instanceof WantSeeRecommendViewHolder) {
            WantSeeRecommendViewHolder wantSeeRecommendViewHolder = (WantSeeRecommendViewHolder) viewHolder;
            wantSeeRecommendViewHolder.b().setOnEventListener(g());
            wantSeeRecommendViewHolder.a((RecommendProjects) obj, i);
            wantSeeRecommendViewHolder.b().setOnRefreshSuccess(new e(i));
        } else if (viewHolder instanceof WantSeeProjectViewHolder) {
            ProjectItemBean projectItemBean2 = (ProjectItemBean) obj;
            projectItemBean2.pos = i;
            WantSeeProjectViewHolder wantSeeProjectViewHolder = (WantSeeProjectViewHolder) viewHolder;
            wantSeeProjectViewHolder.j(g());
            wantSeeProjectViewHolder.e(projectItemBean2, i);
            viewHolder.itemView.setOnClickListener(new g(projectItemBean2, i));
        }
        Exposure exposure = this.d;
        if (exposure == null) {
            return;
        }
        if (obj instanceof NoteBean) {
            exposure.exposureNote(viewHolder.itemView, (NoteBean) obj, i);
        } else if (obj instanceof RankBean) {
            exposure.exposureRank(viewHolder.itemView, (RankBean) obj, i);
        } else if (obj instanceof ProjectItemBean) {
            exposure.exposureProject(viewHolder.itemView, (ProjectItemBean) obj, i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1465491833")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("-1465491833", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        switch (i) {
            case 1:
                return new NoteViewHolder(this.a, viewGroup, new a());
            case 2:
                return new ThemeViewHolder(this.a, viewGroup, new b());
            case 3:
                if (this.g) {
                    WantSeeProjectViewHolder wantSeeProjectViewHolder = new WantSeeProjectViewHolder(viewGroup);
                    wantSeeProjectViewHolder.itemView.setOnLongClickListener(this.c);
                    return wantSeeProjectViewHolder;
                }
                Context context = this.a;
                ProjectItemViewHolder projectItemViewHolder = new ProjectItemViewHolder(context, LayoutInflater.from(context));
                projectItemViewHolder.itemView.setOnLongClickListener(this.c);
                return projectItemViewHolder;
            case 4:
                RankViewHolder rankViewHolder = new RankViewHolder(this.a, viewGroup, new c());
                rankViewHolder.itemView.setOnLongClickListener(this.c);
                return rankViewHolder;
            case 5:
                Context context2 = this.a;
                return new NativeGaiaXViewHolder(context2, new d(context2));
            case 6:
                return WantSeeRecommendViewHolder.Companion.a(this.a, viewGroup);
            default:
                return new EmptyViewHolder(viewGroup.getContext());
        }
    }

    public MultiAdapter(Context context, OnMultiListClickListener onMultiListClickListener, boolean z) {
        this.a = context;
        this.b = onMultiListClickListener;
        this.g = z;
    }
}
