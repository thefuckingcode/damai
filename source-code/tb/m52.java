package tb;

import android.view.View;
import com.alibaba.pictures.bricks.selector.bean.ScriptSelectMo;
import com.alibaba.pictures.bricks.selector.view.ScriptViewHolder;

/* compiled from: Taobao */
public final /* synthetic */ class m52 implements View.OnClickListener {
    public final /* synthetic */ ScriptViewHolder a;
    public final /* synthetic */ ScriptSelectMo b;

    public /* synthetic */ m52(ScriptViewHolder scriptViewHolder, ScriptSelectMo scriptSelectMo) {
        this.a = scriptViewHolder;
        this.b = scriptSelectMo;
    }

    public final void onClick(View view) {
        ScriptViewHolder.c(this.a, this.b, view);
    }
}
