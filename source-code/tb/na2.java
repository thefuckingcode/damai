package tb;

import android.view.View;
import com.alibaba.pictures.bricks.selector.bean.ScriptSelectMo;
import com.alibaba.pictures.bricks.selector.view.ShopViewHolder;

/* compiled from: Taobao */
public final /* synthetic */ class na2 implements View.OnClickListener {
    public final /* synthetic */ ShopViewHolder a;
    public final /* synthetic */ ScriptSelectMo b;

    public /* synthetic */ na2(ShopViewHolder shopViewHolder, ScriptSelectMo scriptSelectMo) {
        this.a = shopViewHolder;
        this.b = scriptSelectMo;
    }

    public final void onClick(View view) {
        ShopViewHolder.a(this.a, this.b, view);
    }
}
