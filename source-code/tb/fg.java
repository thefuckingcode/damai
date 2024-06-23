package tb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.projectfiltercopy.FloatListener;
import cn.damai.projectfiltercopy.adapter.CategoryMainAdapter;
import cn.damai.projectfiltercopy.adapter.CategorySubAdapter;
import cn.damai.projectfiltercopy.bean.CategoryLevelOne;
import cn.damai.projectfiltercopy.bean.CategoryLevelTwo;
import cn.damai.projectfiltercopy.bean.FilterData;
import cn.damai.projectfiltercopy.bean.Type;
import cn.damai.projectfiltercopy.model.CategoryDataAssembler;
import cn.damai.projectfiltercopy.model.CategoryUpdate;
import cn.damai.projectfiltercopy.model.OnCategoryUpdateListener;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class fg extends cn.damai.projectfiltercopy.floatview.a<CategoryDataAssembler> {
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
        final /* synthetic */ fg a;

        a(fg fgVar) {
            this.a = fgVar;
        }

        @Override // cn.damai.projectfiltercopy.model.OnCategoryUpdateListener
        public void categoryUpdate(@NotNull CategoryUpdate categoryUpdate) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-574964016")) {
                ipChange.ipc$dispatch("-574964016", new Object[]{this, categoryUpdate});
                return;
            }
            k21.i(categoryUpdate, "update");
            this.a.f.c(categoryUpdate.getCloneOneList());
            this.a.g.c(categoryUpdate.getCloneTwoList());
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public fg(@Nullable Context context, @NotNull CategoryDataAssembler categoryDataAssembler) {
        super(context);
        k21.i(categoryDataAssembler, "mDataAssembler");
        this.d = categoryDataAssembler;
        categoryDataAssembler.setMListener(new a(this));
        this.f = new CategoryMainAdapter(context, new zf(this));
        this.g = new CategorySubAdapter(context, new ag(this));
    }

    private final void g() {
        View findViewById;
        View findViewById2;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1670498530")) {
            ipChange.ipc$dispatch("1670498530", new Object[]{this});
        } else if (this.e == null) {
            View inflate = LayoutInflater.from(this.a).inflate(R$layout.copy_item_filter_category_float_new, (ViewGroup) null);
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
                findViewById2.setOnClickListener(new yf(this));
            }
            View view3 = this.e;
            if (view3 != null && (findViewById = view3.findViewById(R$id.item_filter_confirm)) != null) {
                findViewById.setOnClickListener(new xf(this));
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void h(fg fgVar, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "770259239")) {
            ipChange.ipc$dispatch("770259239", new Object[]{fgVar, view});
            return;
        }
        k21.i(fgVar, "this$0");
        fgVar.i = view;
        fgVar.d.doConfirm();
        ni0 filterUt = fgVar.getFilterUt();
        if (filterUt != null) {
            filterUt.f("confirm");
        }
        FloatListener listener = fgVar.getListener();
        Type type = Type.NEW_CATEGORY;
        FilterData filterData = new FilterData();
        filterData.mNewCategorySelected = fgVar.d.getSelect4Request();
        ur2 ur2 = ur2.INSTANCE;
        listener.onFloatCall(type, filterData);
    }

    /* access modifiers changed from: private */
    public static final void i(fg fgVar, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-32879946")) {
            ipChange.ipc$dispatch("-32879946", new Object[]{fgVar, view});
            return;
        }
        k21.i(fgVar, "this$0");
        fgVar.d.doReset(true);
        ni0 filterUt = fgVar.getFilterUt();
        if (filterUt != null) {
            filterUt.f("reset");
        }
    }

    /* access modifiers changed from: private */
    public static final void j(fg fgVar, int i2, CategoryLevelOne categoryLevelOne) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-48638045")) {
            ipChange.ipc$dispatch("-48638045", new Object[]{fgVar, Integer.valueOf(i2), categoryLevelOne});
            return;
        }
        k21.i(fgVar, "this$0");
        CategoryDataAssembler categoryDataAssembler = fgVar.d;
        k21.h(categoryLevelOne, "mainBean");
        categoryDataAssembler.selectOne(categoryLevelOne, true);
        ni0 filterUt = fgVar.getFilterUt();
        if (filterUt != null) {
            filterUt.m(categoryLevelOne, i2);
        }
    }

    /* access modifiers changed from: private */
    public static final void k(fg fgVar, int i2, CategoryLevelTwo categoryLevelTwo) {
        ni0 filterUt;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-10414879")) {
            ipChange.ipc$dispatch("-10414879", new Object[]{fgVar, Integer.valueOf(i2), categoryLevelTwo});
            return;
        }
        k21.i(fgVar, "this$0");
        CategoryDataAssembler categoryDataAssembler = fgVar.d;
        k21.h(categoryLevelTwo, "subBean");
        if (categoryDataAssembler.selectTwo(categoryLevelTwo, true) && (filterUt = fgVar.getFilterUt()) != null) {
            filterUt.n(categoryLevelTwo, i2, fgVar.d.indexOneSelect());
        }
    }

    @Override // cn.damai.projectfiltercopy.floatview.FloatLayer
    @NotNull
    public Type getType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "565404176")) {
            return Type.NEW_CATEGORY;
        }
        return (Type) ipChange.ipc$dispatch("565404176", new Object[]{this});
    }

    @Override // cn.damai.projectfiltercopy.floatview.FloatLayer
    @Nullable
    public View getView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "519571575")) {
            return (View) ipChange.ipc$dispatch("519571575", new Object[]{this});
        }
        if (this.e == null) {
            g();
        }
        return this.e;
    }

    @Override // cn.damai.projectfiltercopy.floatview.FloatLayer
    public void hide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1166928936")) {
            ipChange.ipc$dispatch("-1166928936", new Object[]{this});
            return;
        }
        View view = this.i;
        if (view != null) {
            long currentTimeMillis = System.currentTimeMillis() - this.h;
            ni0 filterUt = getFilterUt();
            if (filterUt != null) {
                filterUt.q(view, currentTimeMillis);
            }
        }
    }

    /* renamed from: l */
    public void show(@Nullable CategoryDataAssembler categoryDataAssembler) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2128110530")) {
            ipChange.ipc$dispatch("-2128110530", new Object[]{this, categoryDataAssembler});
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
