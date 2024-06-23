package cn.damai.tetris.component.rank;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$id;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import cn.damai.tetris.component.rank.adapter.RankTypeAdapter;
import cn.damai.tetris.component.rank.bean.CategoryTabBean;
import cn.damai.tetris.component.rank.bean.PresetBean;
import cn.damai.tetris.component.rank.bean.RankFilterBean;
import cn.damai.tetris.component.rank.bean.TypeTabBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.google.android.material.tabs.TabLayout;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ax1;
import tb.f92;
import tb.k21;
import tb.n42;
import tb.qi2;
import tb.xs0;
import tb.zw1;

/* compiled from: Taobao */
public final class RankFilterViewManager implements TabLayout.BaseOnTabSelectedListener<TabLayout.Tab> {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final Context a;
    @NotNull
    private final View b;
    @NotNull
    private final OnRankActionListener c;
    @NotNull
    private final TabLayout d;
    @NotNull
    private final RecyclerView e;
    @NotNull
    private final TextView f;
    @NotNull
    private final TextView g;
    @NotNull
    private final View h;
    @NotNull
    private final View i;
    @Nullable
    private RankTypeAdapter j;
    @Nullable
    private List<? extends CategoryTabBean> k;
    @Nullable
    private CategoryTabBean l;
    @Nullable
    private TypeTabBean m;
    private final int n;
    private final int o;

    /* compiled from: Taobao */
    public interface OnRankActionListener {
        void onChangeCityClick();

        void onFilterChanged(@NotNull CategoryTabBean categoryTabBean, @NotNull TypeTabBean typeTabBean);

        void onMainBtnClick(@NotNull CategoryTabBean categoryTabBean, int i);

        void onMainBtnExpose(@Nullable View view, @NotNull CategoryTabBean categoryTabBean, int i);

        void onSubBtnClick(@NotNull CategoryTabBean categoryTabBean, @NotNull TypeTabBean typeTabBean, int i);

        void onSubBtnExpose(@Nullable View view, @Nullable CategoryTabBean categoryTabBean, @Nullable TypeTabBean typeTabBean, int i);
    }

    /* compiled from: Taobao */
    public static final class a implements OnItemBindListener<TypeTabBean> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ RankFilterViewManager a;

        a(RankFilterViewManager rankFilterViewManager) {
            this.a = rankFilterViewManager;
        }

        /* renamed from: a */
        public void exposeItem(@Nullable View view, @Nullable TypeTabBean typeTabBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-550949573")) {
                ipChange.ipc$dispatch("-550949573", new Object[]{this, view, typeTabBean, Integer.valueOf(i)});
                return;
            }
            this.a.c.onSubBtnExpose(view, this.a.l, typeTabBean, i);
        }

        /* renamed from: b */
        public void onItemClick(@Nullable TypeTabBean typeTabBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1304773350")) {
                ipChange.ipc$dispatch("1304773350", new Object[]{this, typeTabBean, Integer.valueOf(i)});
                return;
            }
            this.a.m = typeTabBean;
            RankTypeAdapter rankTypeAdapter = this.a.j;
            if (rankTypeAdapter != null) {
                rankTypeAdapter.g(typeTabBean);
            }
            if (!(this.a.m == null || this.a.l == null)) {
                OnRankActionListener onRankActionListener = this.a.c;
                CategoryTabBean categoryTabBean = this.a.l;
                k21.f(categoryTabBean);
                TypeTabBean typeTabBean2 = this.a.m;
                k21.f(typeTabBean2);
                onRankActionListener.onSubBtnClick(categoryTabBean, typeTabBean2, i);
            }
            this.a.t();
            this.a.o();
        }
    }

    public RankFilterViewManager(@NotNull Context context, @NotNull View view, @NotNull OnRankActionListener onRankActionListener) {
        k21.i(context, "mContext");
        k21.i(view, "mView");
        k21.i(onRankActionListener, "mListener");
        this.a = context;
        this.b = view;
        this.c = onRankActionListener;
        View findViewById = view.findViewById(R$id.id_rank_f_main_btn_tab);
        k21.h(findViewById, "mView.findViewById(R.id.id_rank_f_main_btn_tab)");
        TabLayout tabLayout = (TabLayout) findViewById;
        this.d = tabLayout;
        View findViewById2 = view.findViewById(R$id.id_rank_f_sub_btn_lv);
        k21.h(findViewById2, "mView.findViewById(R.id.id_rank_f_sub_btn_lv)");
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        this.e = recyclerView;
        View findViewById3 = view.findViewById(R$id.id_rank_f_tip);
        k21.h(findViewById3, "mView.findViewById(R.id.id_rank_f_tip)");
        this.f = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R$id.id_rank_city_tip);
        k21.h(findViewById4, "mView.findViewById(R.id.id_rank_city_tip)");
        this.g = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R$id.id_tetris_rank_empty_layout);
        k21.h(findViewById5, "mView.findViewById(R.id.…tetris_rank_empty_layout)");
        this.h = findViewById5;
        View findViewById6 = view.findViewById(R$id.id_tetris_rank_top_round_bg);
        k21.h(findViewById6, "mView.findViewById(R.id.…tetris_rank_top_round_bg)");
        this.i = findViewById6;
        findViewById5.findViewById(R$id.id_tetris_rank_change_city).setOnClickListener(new zw1(this));
        findViewById5.setVisibility(8);
        this.n = n42.a(context, 12.0f);
        this.o = n42.a(context, 12.0f);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, 0, false));
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration(this) {
            /* class cn.damai.tetris.component.rank.RankFilterViewManager.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ RankFilterViewManager a;

            {
                this.a = r1;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
                IpChange ipChange = $ipChange;
                boolean z = true;
                int i = 0;
                if (AndroidInstantRuntime.support(ipChange, "-310703418")) {
                    ipChange.ipc$dispatch("-310703418", new Object[]{this, rect, view, recyclerView, state});
                    return;
                }
                k21.i(rect, "outRect");
                k21.i(view, "view");
                k21.i(recyclerView, "parent");
                k21.i(state, "state");
                int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
                boolean z2 = childAdapterPosition == 0;
                RankTypeAdapter rankTypeAdapter = this.a.j;
                k21.f(rankTypeAdapter);
                if (childAdapterPosition != rankTypeAdapter.getItemCount() - 1) {
                    z = false;
                }
                if (z2) {
                    i = this.a.n;
                }
                rect.left = i;
                RankFilterViewManager rankFilterViewManager = this.a;
                rect.right = z ? rankFilterViewManager.n : rankFilterViewManager.o;
            }
        });
        RankTypeAdapter rankTypeAdapter = new RankTypeAdapter(context, new a(this));
        this.j = rankTypeAdapter;
        recyclerView.setAdapter(rankTypeAdapter);
        tabLayout.setSelectedTabIndicator(new qi2(22));
        tabLayout.addOnTabSelectedListener(this);
    }

    /* access modifiers changed from: private */
    public static final void c(RankFilterViewManager rankFilterViewManager, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "282888616")) {
            ipChange.ipc$dispatch("282888616", new Object[]{rankFilterViewManager, view});
            return;
        }
        k21.i(rankFilterViewManager, "this$0");
        rankFilterViewManager.c.onChangeCityClick();
    }

    /* access modifiers changed from: private */
    public static final void n(RankFilterViewManager rankFilterViewManager) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "954643546")) {
            ipChange.ipc$dispatch("954643546", new Object[]{rankFilterViewManager});
            return;
        }
        k21.i(rankFilterViewManager, "this$0");
        TabLayout tabLayout = rankFilterViewManager.d;
        tabLayout.setScrollPosition(tabLayout.getSelectedTabPosition(), 0.0f, false);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void o() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "759262057")) {
            ipChange.ipc$dispatch("759262057", new Object[]{this});
            return;
        }
        CategoryTabBean categoryTabBean = this.l;
        if (categoryTabBean != null && this.m != null) {
            OnRankActionListener onRankActionListener = this.c;
            k21.f(categoryTabBean);
            TypeTabBean typeTabBean = this.m;
            k21.f(typeTabBean);
            onRankActionListener.onFilterChanged(categoryTabBean, typeTabBean);
        }
    }

    private final void p() {
        TypeTabBean typeTabBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1892987811")) {
            ipChange.ipc$dispatch("-1892987811", new Object[]{this});
            return;
        }
        CategoryTabBean categoryTabBean = this.l;
        if (categoryTabBean != null) {
            int indexOf = categoryTabBean.subTypeList.indexOf(this.m);
            if (indexOf >= 0) {
                typeTabBean = categoryTabBean.subTypeList.get(indexOf);
            } else {
                typeTabBean = categoryTabBean.subTypeList.isEmpty() ? null : categoryTabBean.subTypeList.get(0);
            }
            this.m = typeTabBean;
            RankTypeAdapter rankTypeAdapter = this.j;
            if (rankTypeAdapter != null) {
                rankTypeAdapter.f(categoryTabBean.subTypeList, typeTabBean);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void t() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-403641165")) {
            ipChange.ipc$dispatch("-403641165", new Object[]{this});
            return;
        }
        TypeTabBean typeTabBean = this.m;
        if (typeTabBean != null) {
            this.f.setText(typeTabBean.desc);
        }
    }

    public final void m(@Nullable RankFilterBean rankFilterBean, @Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-5607747")) {
            ipChange.ipc$dispatch("-5607747", new Object[]{this, rankFilterBean, str});
        } else if (rankFilterBean != null) {
            this.d.removeOnTabSelectedListener(this);
            this.d.removeAllTabs();
            rankFilterBean.ensureFormatBeanOneTime();
            List<CategoryTabBean> list = rankFilterBean.categoryTabs;
            this.k = list;
            if (!f92.d(list)) {
                this.l = PresetBean.obtainSelected(this.k, str);
                List<? extends CategoryTabBean> list2 = this.k;
                if (list2 != null) {
                    Iterator<T> it = list2.iterator();
                    while (it.hasNext()) {
                        T next = it.next();
                        TabLayout.Tab newTab = this.d.newTab();
                        k21.h(newTab, "mCategoryTabsLayout.newTab()");
                        newTab.setText(next.name);
                        this.d.addTab(newTab, next == this.l);
                    }
                }
                if (this.d.getSelectedTabPosition() > 0) {
                    this.d.post(new ax1(this));
                }
                View childAt = this.d.getChildAt(0);
                if (childAt instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) childAt;
                    if (viewGroup.getChildCount() > 0) {
                        int childCount = viewGroup.getChildCount();
                        int i2 = 0;
                        while (i2 < childCount) {
                            View childAt2 = viewGroup.getChildAt(i2);
                            boolean z = i2 == 0;
                            boolean z2 = i2 == childCount + -1;
                            ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                                if (z) {
                                    ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = n42.a(xs0.a(), 3.0f);
                                }
                                if (z2) {
                                    ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = n42.a(xs0.a(), 8.0f);
                                }
                            }
                            CategoryTabBean categoryTabBean = (CategoryTabBean) f92.b(this.k, i2);
                            if (categoryTabBean != null) {
                                this.c.onMainBtnExpose(childAt2, categoryTabBean, i2);
                            }
                            i2++;
                        }
                    }
                }
            }
            p();
            t();
            this.d.addOnTabSelectedListener(this);
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabReselected(@Nullable TabLayout.Tab tab) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-980465837")) {
            ipChange.ipc$dispatch("-980465837", new Object[]{this, tab});
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabSelected(@NotNull TabLayout.Tab tab) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-652674970")) {
            ipChange.ipc$dispatch("-652674970", new Object[]{this, tab});
            return;
        }
        k21.i(tab, "tab");
        int position = tab.getPosition();
        CategoryTabBean categoryTabBean = (CategoryTabBean) f92.b(this.k, position);
        CategoryTabBean categoryTabBean2 = this.l;
        if (categoryTabBean2 == null || !k21.d(categoryTabBean2, categoryTabBean)) {
            this.l = categoryTabBean;
            if (categoryTabBean != null) {
                OnRankActionListener onRankActionListener = this.c;
                k21.f(categoryTabBean);
                onRankActionListener.onMainBtnClick(categoryTabBean, position);
            }
            p();
            o();
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabUnselected(@Nullable TabLayout.Tab tab) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "722620205")) {
            ipChange.ipc$dispatch("722620205", new Object[]{this, tab});
        }
    }

    public final void q(boolean z) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1476544653")) {
            ipChange.ipc$dispatch("-1476544653", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        View view = this.h;
        if (!z) {
            i2 = 8;
        }
        view.setVisibility(i2);
    }

    public final void r(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1483848354")) {
            ipChange.ipc$dispatch("-1483848354", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        this.i.setBackgroundColor(i2);
    }

    public final void s(boolean z) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "267185801")) {
            ipChange.ipc$dispatch("267185801", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        TextView textView = this.g;
        if (!z) {
            i2 = 8;
        }
        textView.setVisibility(i2);
    }
}
