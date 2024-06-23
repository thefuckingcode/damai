package tb;

import android.view.View;
import cn.damai.tetris.component.star.bean.ItemModuleBean;
import cn.damai.tetris.component.star.officalMall.ProductShopDelegate;
import java.util.HashMap;

/* compiled from: Taobao */
public final /* synthetic */ class et1 implements View.OnClickListener {
    public final /* synthetic */ ProductShopDelegate.ProductViewHolder a;
    public final /* synthetic */ ItemModuleBean.GoodBean b;
    public final /* synthetic */ int c;
    public final /* synthetic */ HashMap d;

    public /* synthetic */ et1(ProductShopDelegate.ProductViewHolder productViewHolder, ItemModuleBean.GoodBean goodBean, int i, HashMap hashMap) {
        this.a = productViewHolder;
        this.b = goodBean;
        this.c = i;
        this.d = hashMap;
    }

    public final void onClick(View view) {
        this.a.b(this.b, this.c, this.d, view);
    }
}
