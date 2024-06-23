package tb;

import cn.damai.projectfiltercopy.adapter.CategorySubAdapter;
import cn.damai.projectfiltercopy.bean.CategoryLevelTwo;

/* compiled from: Taobao */
public final /* synthetic */ class ag implements CategorySubAdapter.OnCategorySubListener {
    public final /* synthetic */ fg a;

    public /* synthetic */ ag(fg fgVar) {
        this.a = fgVar;
    }

    @Override // cn.damai.projectfiltercopy.adapter.CategorySubAdapter.OnCategorySubListener
    public final void onSubClick(int i, CategoryLevelTwo categoryLevelTwo) {
        fg.k(this.a, i, categoryLevelTwo);
    }
}
