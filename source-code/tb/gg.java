package tb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.projectfilter.FloatListener;
import cn.damai.projectfilter.adapter.CategoryMainAdapter;
import cn.damai.projectfilter.adapter.CategorySubAdapter;
import cn.damai.projectfilter.bean.CategoryLevelOne;
import cn.damai.projectfilter.bean.CategoryLevelTwo;
import cn.damai.projectfilter.bean.FilterData;
import cn.damai.projectfilter.bean.Type;
import cn.damai.projectfilter.model.CategoryDataAssembler;
import cn.damai.projectfilter.model.CategoryUpdate;
import cn.damai.projectfilter.model.OnCategoryUpdateListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class gg extends cn.damai.projectfilter.floatview.a<CategoryDataAssembler> {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final CategoryDataAssembler d;
    @Nullable
    private View e;
    @NotNull
    private final CategoryMainAdapter f;
    @NotNull
    private final CategorySubAdapter g;
    private long h;
    @Nullable
    private View i;

    /* compiled from: Taobao */
    public static final class a implements OnCategoryUpdateListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ gg a;

        a(gg ggVar) {
            this.a = ggVar;
        }

        @Override // cn.damai.projectfilter.model.OnCategoryUpdateListener
        public void categoryUpdate(@NotNull CategoryUpdate categoryUpdate) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "703115376")) {
                ipChange.ipc$dispatch("703115376", new Object[]{this, categoryUpdate});
                return;
            }
            k21.i(categoryUpdate, "update");
            this.a.f.c(categoryUpdate.getCloneOneList());
            this.a.g.c(categoryUpdate.getCloneTwoList());
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public gg(@Nullable Context context, @NotNull CategoryDataAssembler categoryDataAssembler) {
        super(context);
        k21.i(categoryDataAssembler, "mDataAssembler");
        this.d = categoryDataAssembler;
        categoryDataAssembler.setMListener(new a(this));
        this.f = new CategoryMainAdapter(context, new dg(this));
        this.g = new CategorySubAdapter(context, new eg(this));
    }

    private final void g() {
        View findViewById;
        View findViewById2;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1776631789")) {
            ipChange.ipc$dispatch("1776631789", new Object[]{this});
        } else if (this.e == null) {
            View inflate = LayoutInflater.from(this.a).inflate(R$layout.item_filter_category_float_new, (ViewGroup) null);
            this.e = inflate;
            if (!(inflate == null || (recyclerView2 = (RecyclerView) inflate.findViewById(R$id.float_category_list_main_lv)) == null)) {
                recyclerView2.setAdapter(this.f);
                recyclerView2.setLayoutManager(new LinearLayoutManager(this.a, 1, false));
            }
            View view = this.e;
            if (!(view == null || (recyclerView = (RecyclerView) view.findViewById(R$id.float_category_list_sub_lv)) == null)) {
                recyclerView.setAdapter(this.g);
                recyclerView.setLayoutManager(new LinearLayoutManager(this.a, 1, false));
            }
            View view2 = this.e;
            if (!(view2 == null || (findViewById2 = view2.findViewById(R$id.item_filter_reset)) == null)) {
                findViewById2.setOnClickListener(new bg(this));
            }
            View view3 = this.e;
            if (view3 != null && (findViewById = view3.findViewById(R$id.item_filter_confirm)) != null) {
                findViewById.setOnClickListener(new cg(this));
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void h(gg ggVar, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1369587783")) {
            ipChange.ipc$dispatch("1369587783", new Object[]{ggVar, view});
            return;
        }
        k21.i(ggVar, "this$0");
        ggVar.i = view;
        ggVar.d.doConfirm();
        oi0 filterUt = ggVar.getFilterUt();
        if (filterUt != null) {
            filterUt.i("confirm");
        }
        FloatListener listener = ggVar.getListener();
        Type type = Type.NEW_CATEGORY;
        FilterData filterData = new FilterData();
        filterData.mNewCategorySelected = ggVar.d.getSelect4Request();
        ur2 ur2 = ur2.INSTANCE;
        listener.onFloatCall(type, filterData);
    }

    /* access modifiers changed from: private */
    public static final void i(gg ggVar, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "316692236")) {
            ipChange.ipc$dispatch("316692236", new Object[]{ggVar, view});
            return;
        }
        k21.i(ggVar, "this$0");
        ggVar.d.doReset(true);
        oi0 filterUt = ggVar.getFilterUt();
        if (filterUt != null) {
            filterUt.i("reset");
        }
    }

    /* access modifiers changed from: private */
    public static final void j(gg ggVar, int i2, CategoryLevelOne categoryLevelOne) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1257660046")) {
            ipChange.ipc$dispatch("1257660046", new Object[]{ggVar, Integer.valueOf(i2), categoryLevelOne});
            return;
        }
        k21.i(ggVar, "this$0");
        CategoryDataAssembler categoryDataAssembler = ggVar.d;
        k21.h(categoryLevelOne, "mainBean");
        categoryDataAssembler.selectOne(categoryLevelOne, true);
        oi0 filterUt = ggVar.getFilterUt();
        if (filterUt != null) {
            filterUt.o(categoryLevelOne, i2);
        }
    }

    /* access modifiers changed from: private */
    public static final void k(gg ggVar, int i2, CategoryLevelTwo categoryLevelTwo) {
        oi0 filterUt;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2111716566")) {
            ipChange.ipc$dispatch("2111716566", new Object[]{ggVar, Integer.valueOf(i2), categoryLevelTwo});
            return;
        }
        k21.i(ggVar, "this$0");
        CategoryDataAssembler categoryDataAssembler = ggVar.d;
        k21.h(categoryLevelTwo, "subBean");
        if (categoryDataAssembler.selectTwo(categoryLevelTwo, true) && (filterUt = ggVar.getFilterUt()) != null) {
            filterUt.p(categoryLevelTwo, i2, ggVar.d.indexOneSelect());
        }
    }

    @Override // cn.damai.projectfilter.floatview.FloatLayer
    @NotNull
    public Type getType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-77463312")) {
            return Type.NEW_CATEGORY;
        }
        return (Type) ipChange.ipc$dispatch("-77463312", new Object[]{this});
    }

    @Override // cn.damai.projectfilter.floatview.FloatLayer
    @Nullable
    public View getView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1239560588")) {
            return (View) ipChange.ipc$dispatch("1239560588", new Object[]{this});
        }
        if (this.e == null) {
            g();
        }
        return this.e;
    }

    @Override // cn.damai.projectfilter.floatview.FloatLayer
    public void hide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-472856669")) {
            ipChange.ipc$dispatch("-472856669", new Object[]{this});
            return;
        }
        View view = this.i;
        if (view != null) {
            long currentTimeMillis = System.currentTimeMillis() - this.h;
            oi0 filterUt = getFilterUt();
            if (filterUt != null) {
                filterUt.s(view, currentTimeMillis);
            }
        }
    }

    /* renamed from: l */
    public void show(@Nullable CategoryDataAssembler categoryDataAssembler) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1461732766")) {
            ipChange.ipc$dispatch("1461732766", new Object[]{this, categoryDataAssembler});
            return;
        }
        this.h = System.currentTimeMillis();
        g();
        if (categoryDataAssembler != null) {
            categoryDataAssembler.doMatchIfNeed();
            CategoryUpdate update = categoryDataAssembler.getUpdate();
            this.f.c(update.getCloneOneList());
            this.g.c(update.getCloneTwoList());
        }
    }
}
