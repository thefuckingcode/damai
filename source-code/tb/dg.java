package tb;

import cn.damai.projectfilter.adapter.CategoryMainAdapter;
import cn.damai.projectfilter.bean.CategoryLevelOne;

/* compiled from: Taobao */
public final /* synthetic */ class dg implements CategoryMainAdapter.OnCategoryMainListener {
    public final /* synthetic */ gg a;

    public /* synthetic */ dg(gg ggVar) {
        this.a = ggVar;
    }

    @Override // cn.damai.projectfilter.adapter.CategoryMainAdapter.OnCategoryMainListener
    public final void onSubClick(int i, CategoryLevelOne categoryLevelOne) {
        gg.j(this.a, i, categoryLevelOne);
    }
}
