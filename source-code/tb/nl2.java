package tb;

import android.content.DialogInterface;
import cn.damai.common.app.widget.ProtocolDialog;
import cn.damai.ticklet.view.TickletNFTTicketItemView;
import kotlin.jvm.functions.Function0;

/* compiled from: Taobao */
public final /* synthetic */ class nl2 implements ProtocolDialog.OnConfirmListener {
    public final /* synthetic */ String a;
    public final /* synthetic */ TickletNFTTicketItemView b;
    public final /* synthetic */ Function0 c;

    public /* synthetic */ nl2(String str, TickletNFTTicketItemView tickletNFTTicketItemView, Function0 function0) {
        this.a = str;
        this.b = tickletNFTTicketItemView;
        this.c = function0;
    }

    @Override // cn.damai.common.app.widget.ProtocolDialog.OnConfirmListener
    public final void onConfirmClick(boolean z, DialogInterface dialogInterface) {
        TickletNFTTicketItemView.m71decideShowDialog$lambda5(this.a, this.b, this.c, z, dialogInterface);
    }
}
