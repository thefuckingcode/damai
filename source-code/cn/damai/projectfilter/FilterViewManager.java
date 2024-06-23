package cn.damai.projectfilter;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.projectfilter.adapter.FastFilterAdapter;
import cn.damai.projectfilter.bean.FilterBean;
import cn.damai.projectfilter.bean.FilterResponse;
import cn.damai.projectfilter.bean.PresetBean;
import cn.damai.projectfilter.bean.Type;
import cn.damai.projectfilter.floatcontainer.FloatContainer;
import cn.damai.projectfilter.listener.FilterBtnAction;
import cn.damai.projectfilter.listener.RequestParamProvider;
import cn.damai.projectfilter.listener.UiBizListener;
import cn.damai.projectfilter.model.FilterModel;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.f92;
import tb.ji0;
import tb.kj0;
import tb.ng0;
import tb.oi0;

/* compiled from: Taobao */
public class FilterViewManager implements FilterBtnAction {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private View b;
    private ViewGroup c;
    private ViewGroup d;
    private FloatContainer e;
    private RecyclerView f;
    private FastFilterAdapter g;
    private TextView h;
    private FilterModel i;
    private List<ji0> j = new ArrayList();
    private FilterBtnAction k;
    private oi0 l;

    /* compiled from: Taobao */
    public class a implements OnItemBindListener<FilterBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        /* renamed from: a */
        public void exposeItem(View view, FilterBean filterBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1515333811")) {
                ipChange.ipc$dispatch("1515333811", new Object[]{this, view, filterBean, Integer.valueOf(i)});
                return;
            }
            FilterViewManager.this.l.u(view, filterBean, i);
        }

        /* renamed from: b */
        public void onItemClick(FilterBean filterBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-788053848")) {
                ipChange.ipc$dispatch("-788053848", new Object[]{this, filterBean, Integer.valueOf(i)});
                return;
            }
            FilterViewManager.this.l.k(filterBean, i);
            FilterViewManager.this.i.onFastCall(filterBean);
        }
    }

    /* compiled from: Taobao */
    public class b implements UiBizListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.projectfilter.listener.UiBizListener
        public void onFastFilterChanged(List<FilterBean> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2116647743")) {
                ipChange.ipc$dispatch("2116647743", new Object[]{this, list});
                return;
            }
            FilterViewManager.this.g.c(list);
        }

        @Override // cn.damai.projectfilter.listener.UiBizListener
        public void onMainFilterChanged(Type type) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-486417862")) {
                ipChange.ipc$dispatch("-486417862", new Object[]{this, type});
                return;
            }
            for (ji0 ji0 : FilterViewManager.this.j) {
                if (type == ji0.a) {
                    ji0.d.setState(false);
                }
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements OnItemBindListener<Type> {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        /* renamed from: a */
        public void exposeItem(View view, Type type, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-674110937")) {
                ipChange.ipc$dispatch("-674110937", new Object[]{this, view, type, Integer.valueOf(i)});
                return;
            }
            FilterViewManager.this.l.v(view, type);
        }

        /* renamed from: b */
        public void onItemClick(Type type, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "914313820")) {
                ipChange.ipc$dispatch("914313820", new Object[]{this, type, Integer.valueOf(i)});
                return;
            }
            FilterViewManager.this.l.l(type);
        }
    }

    public FilterViewManager(Context context, ViewGroup viewGroup, oi0 oi0) {
        this.a = context;
        this.l = oi0;
        View inflate = LayoutInflater.from(context).inflate(R$layout.item_filter_view_container, (ViewGroup) null);
        this.b = inflate;
        inflate.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        if (context.getClass().getName().equals("cn.damai.homepage.MainActivity") || context.getClass().getName().equals("cn.damai.livehouse.ComponentActivity") || context.getClass().getName().equals("cn.damai.homepage.v2.ChannelPageActivity")) {
            this.b.setBackgroundResource(R$drawable.filter_panel_gradient_bg);
        }
        this.c = (ViewGroup) this.b.findViewById(R$id.filter_btn_container);
        this.d = (ViewGroup) this.b.findViewById(R$id.filter_btn_container2);
        this.h = (TextView) this.b.findViewById(R$id.filter_view_title);
        RecyclerView recyclerView = (RecyclerView) this.b.findViewById(R$id.filter_fast_filter_list);
        this.f = recyclerView;
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            /* class cn.damai.projectfilter.FilterViewManager.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
                IpChange ipChange = $ipChange;
                boolean z = true;
                int i = 0;
                if (AndroidInstantRuntime.support(ipChange, "-1808961746")) {
                    ipChange.ipc$dispatch("-1808961746", new Object[]{this, rect, view, recyclerView, state});
                    return;
                }
                int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
                if (FilterViewManager.this.g == null || childAdapterPosition != FilterViewManager.this.g.getItemCount() - 1) {
                    z = false;
                }
                if (childAdapterPosition == 0) {
                    i = ng0.MARGIN_12;
                }
                rect.left = i;
                rect.right = z ? ng0.MARGIN_12 : ng0.MARGIN_9;
            }
        });
        this.f.setItemAnimator(null);
        this.f.setLayoutManager(new LinearLayoutManager(this.a, 0, false));
        FastFilterAdapter fastFilterAdapter = new FastFilterAdapter(this.a, new a());
        this.g = fastFilterAdapter;
        this.f.setAdapter(fastFilterAdapter);
        this.e = new kj0(context, viewGroup);
        this.i = new FilterModel(new b());
    }

    @Override // cn.damai.projectfilter.listener.FilterBtnAction
    public int computeFloatTopPadding() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2033817470")) {
            return ((Integer) ipChange.ipc$dispatch("2033817470", new Object[]{this})).intValue();
        }
        FilterBtnAction filterBtnAction = this.k;
        if (filterBtnAction != null) {
            return filterBtnAction.computeFloatTopPadding();
        }
        return 0;
    }

    @Override // cn.damai.projectfilter.listener.FilterBtnAction
    public void doBeforeFilterBtnClick(Type type) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "942089421")) {
            ipChange.ipc$dispatch("942089421", new Object[]{this, type});
            return;
        }
        FilterBtnAction filterBtnAction = this.k;
        if (filterBtnAction != null) {
            filterBtnAction.doBeforeFilterBtnClick(type);
        }
    }

    public RequestParamProvider e() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-125735316")) {
            return this.i;
        }
        return (RequestParamProvider) ipChange.ipc$dispatch("-125735316", new Object[]{this});
    }

    public int f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-956090282")) {
            return ((Integer) ipChange.ipc$dispatch("-956090282", new Object[]{this})).intValue();
        } else if (this.h.getVisibility() == 8) {
            return 0;
        } else {
            return this.h.getHeight();
        }
    }

    public View g() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "578704869")) {
            return this.b;
        }
        return (View) ipChange.ipc$dispatch("578704869", new Object[]{this});
    }

    public void h(FilterResponse filterResponse, String str, PresetBean presetBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1376862864")) {
            ipChange.ipc$dispatch("-1376862864", new Object[]{this, filterResponse, str, presetBean});
            return;
        }
        this.i.init(filterResponse, presetBean);
        this.j.clear();
        if (TextUtils.isEmpty(str)) {
            this.h.setVisibility(8);
        } else {
            this.h.setText(str);
            this.h.setVisibility(0);
        }
        List<Type> list = this.i.supportType;
        if (list.contains(Type.DATE)) {
            Context context = this.a;
            FloatContainer floatContainer = this.e;
            FilterModel filterModel = this.i;
            this.j.add(ji0.c(context, floatContainer, filterModel, filterModel.getYearList()));
        }
        if (list.contains(Type.NEW_CATEGORY)) {
            this.j.add(ji0.e(this.a, this.e, this.i));
        }
        if (list.contains(Type.CITY)) {
            this.j.add(ji0.b(this.a, this.e, this.i));
        }
        if (list.contains(Type.SORT)) {
            Context context2 = this.a;
            FloatContainer floatContainer2 = this.e;
            FilterModel filterModel2 = this.i;
            this.j.add(ji0.f(context2, floatContainer2, filterModel2, filterModel2.getSortList()));
        }
        if (list.contains(Type.FILTER)) {
            Context context3 = this.a;
            FloatContainer floatContainer3 = this.e;
            FilterModel filterModel3 = this.i;
            this.j.add(ji0.d(context3, floatContainer3, filterModel3, filterModel3.getFilterBean()));
        }
        for (ji0 ji0 : this.j) {
            ji0.g(new c());
            ji0.e.setFilterUt(this.l);
            ji0.a(this.c, this.d, this);
        }
        List<FilterBean> list2 = this.i.mFastFilterList;
        if (f92.d(list2)) {
            this.f.setVisibility(8);
            return;
        }
        this.f.setVisibility(0);
        this.g.c(list2);
    }

    public void i(FilterBtnAction filterBtnAction) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2067378997")) {
            ipChange.ipc$dispatch("2067378997", new Object[]{this, filterBtnAction});
            return;
        }
        this.k = filterBtnAction;
    }
}
