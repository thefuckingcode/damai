package tb;

import cn.damai.comment.bean.DmInfo;
import cn.damai.comment.view.PublishDMListView;
import java.util.List;

/* compiled from: Taobao */
public final /* synthetic */ class tv1 implements Runnable {
    public final /* synthetic */ List a;
    public final /* synthetic */ PublishDMListView b;
    public final /* synthetic */ DmInfo c;

    public /* synthetic */ tv1(List list, PublishDMListView publishDMListView, DmInfo dmInfo) {
        this.a = list;
        this.b = publishDMListView;
        this.c = dmInfo;
    }

    public final void run() {
        PublishDMListView.a(this.a, this.b, this.c);
    }
}
