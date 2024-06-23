package tb;

import android.view.View;
import cn.damai.commonbusiness.notice.NoticeViewHolder;

/* compiled from: Taobao */
public final /* synthetic */ class tj1 implements View.OnClickListener {
    public final /* synthetic */ String a;
    public final /* synthetic */ NoticeViewHolder b;

    public /* synthetic */ tj1(String str, NoticeViewHolder noticeViewHolder) {
        this.a = str;
        this.b = noticeViewHolder;
    }

    public final void onClick(View view) {
        NoticeViewHolder.c(this.a, this.b, view);
    }
}
