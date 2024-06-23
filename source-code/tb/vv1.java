package tb;

import android.view.View;
import cn.damai.comment.bean.DmInfo;
import cn.damai.comment.view.PublishDMTagView;

/* compiled from: Taobao */
public final /* synthetic */ class vv1 implements View.OnClickListener {
    public final /* synthetic */ DmInfo a;
    public final /* synthetic */ String b;
    public final /* synthetic */ PublishDMTagView.TagView c;

    public /* synthetic */ vv1(DmInfo dmInfo, String str, PublishDMTagView.TagView tagView) {
        this.a = dmInfo;
        this.b = str;
        this.c = tagView;
    }

    public final void onClick(View view) {
        PublishDMTagView.m3bindData$lambda1$lambda0(this.a, this.b, this.c, view);
    }
}
