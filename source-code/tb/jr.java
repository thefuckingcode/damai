package tb;

import android.view.View;
import cn.damai.uikit.view.DMProtocolDialog;

/* compiled from: Taobao */
public final /* synthetic */ class jr implements View.OnClickListener {
    public final /* synthetic */ DMProtocolDialog a;
    public final /* synthetic */ DMProtocolDialog.OnClickListener b;

    public /* synthetic */ jr(DMProtocolDialog dMProtocolDialog, DMProtocolDialog.OnClickListener onClickListener) {
        this.a = dMProtocolDialog;
        this.b = onClickListener;
    }

    public final void onClick(View view) {
        this.a.j(this.b, view);
    }
}
