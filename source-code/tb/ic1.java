package tb;

import cn.damai.commonbusiness.yymember.view.MemberAuthPopWindow;
import cn.damai.tetris.page.a;

/* compiled from: Taobao */
public final /* synthetic */ class ic1 implements Runnable {
    public final /* synthetic */ a a;
    public final /* synthetic */ String b;
    public final /* synthetic */ MemberAuthPopWindow c;

    public /* synthetic */ ic1(a aVar, String str, MemberAuthPopWindow memberAuthPopWindow) {
        this.a = aVar;
        this.b = str;
        this.c = memberAuthPopWindow;
    }

    public final void run() {
        MemberAuthPopWindow.m19initData$lambda2(this.a, this.b, this.c);
    }
}
