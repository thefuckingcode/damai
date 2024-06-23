package tb;

import cn.damai.projectfiltercopy.adapter.CategoryMainAdapter;
import cn.damai.projectfiltercopy.bean.CategoryLevelOne;

/* compiled from: Taobao */
public final /* synthetic */ class zf implements CategoryMainAdapter.OnCategoryMainListener {
    public final /* synthetic */ fg a;

    public /* synthetic */ zf(fg fgVar) {
        this.a = fgVar;
    }

    @Override // cn.damai.projectfiltercopy.adapter.CategoryMainAdapter.OnCategoryMainListener
    public final void onSubClick(int i, CategoryLevelOne categoryLevelOne) {
        fg.j(this.a, i, categoryLevelOne);
    }
}
