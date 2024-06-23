package tb;

import android.view.View;
import com.alibaba.pictures.bricks.bean.ShopInfoBean;
import com.alibaba.pictures.bricks.component.script.ScriptShopPresenter;
import com.alibaba.pictures.bricks.component.script.ScriptShopView;

/* compiled from: Taobao */
public final /* synthetic */ class k52 implements View.OnClickListener {
    public final /* synthetic */ ScriptShopPresenter a;
    public final /* synthetic */ ShopInfoBean b;
    public final /* synthetic */ int c;

    public /* synthetic */ k52(ScriptShopPresenter scriptShopPresenter, ShopInfoBean shopInfoBean, int i) {
        this.a = scriptShopPresenter;
        this.b = shopInfoBean;
        this.c = i;
    }

    public final void onClick(View view) {
        ScriptShopView.m141bindData$lambda3$lambda2(this.a, this.b, this.c, view);
    }
}
