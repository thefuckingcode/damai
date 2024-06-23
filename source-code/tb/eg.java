package tb;

import cn.damai.projectfilter.adapter.CategorySubAdapter;
import cn.damai.projectfilter.bean.CategoryLevelTwo;

/* compiled from: Taobao */
public final /* synthetic */ class eg implements CategorySubAdapter.OnCategorySubListener {
    public final /* synthetic */ gg a;

    public /* synthetic */ eg(gg ggVar) {
        this.a = ggVar;
    }

    @Override // cn.damai.projectfilter.adapter.CategorySubAdapter.OnCategorySubListener
    public final void onSubClick(int i, CategoryLevelTwo categoryLevelTwo) {
        gg.k(this.a, i, categoryLevelTwo);
    }
}
