package tb;

import android.view.View;
import cn.damai.tetris.component.star.bean.ModuleTitleModel;

/* compiled from: Taobao */
public final /* synthetic */ class ff1 implements View.OnClickListener {
    public final /* synthetic */ gf1 a;
    public final /* synthetic */ ModuleTitleModel.OperationBean b;

    public /* synthetic */ ff1(gf1 gf1, ModuleTitleModel.OperationBean operationBean) {
        this.a = gf1;
        this.b = operationBean;
    }

    public final void onClick(View view) {
        this.a.c(this.b, view);
    }
}
