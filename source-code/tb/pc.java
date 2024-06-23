package tb;

import android.view.View;
import com.alibaba.pictures.bricks.bean.BottomAction;
import com.alibaba.pictures.bricks.view.BottomActionDialog;

/* compiled from: Taobao */
public final /* synthetic */ class pc implements View.OnClickListener {
    public final /* synthetic */ BottomActionDialog a;
    public final /* synthetic */ BottomAction b;

    public /* synthetic */ pc(BottomActionDialog bottomActionDialog, BottomAction bottomAction) {
        this.a = bottomActionDialog;
        this.b = bottomAction;
    }

    public final void onClick(View view) {
        BottomActionDialog.Vh.c(this.a, this.b, view);
    }
}
